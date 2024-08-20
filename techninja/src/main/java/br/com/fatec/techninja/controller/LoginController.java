package br.com.fatec.techninja.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.fatec.techninja.model.Usuario;
import br.com.fatec.techninja.repository.UsuarioRepository;

@Controller
public class LoginController {
    
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public LoginController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Pagina de Login -- Login
    @GetMapping("/login")
    public String login() {
        return "login" ;
    }

    // Logicas e Implementações de Login -- Logica Login
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String senha, RedirectAttributes redirectAttributes,
            HttpSession session) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario != null && usuario.getSenha().equals(senha)) {
            // Se as credenciais existirem, gera um logedToken e redireciona para a home
            session.setAttribute("logedToken", true);
            session.setAttribute("logedEmail", email); // adicionando o email do usuario na sessão

            return "redirect:/home";
        } else {
            // Se as credenciais não existirem, exibe um erro
            redirectAttributes.addFlashAttribute("error", "Email ou senha inválidos!");
            return "redirect:/login";
        }
    }
}