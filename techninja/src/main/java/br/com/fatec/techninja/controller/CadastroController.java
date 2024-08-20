package br.com.fatec.techninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.fatec.techninja.model.Usuario;
import br.com.fatec.techninja.repository.UsuarioRepository;

@Controller
public class CadastroController {
    
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public CadastroController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Pagina de Cadastro -- Cadastro
    @GetMapping("/cadastro")
    public String cadastro() {
        return "cadastro";
    }

    // Logicas e Implementações de Cadastro -- Logica Cadastro
    @PostMapping("/cadastro")
    public String cadastro(@RequestParam String nome, @RequestParam String email, @RequestParam String senha,
            @RequestParam String repSenha,
            RedirectAttributes redirectAttributes) {

        // Verifica se o e-mail já existe
        Usuario usuarioExistente = usuarioRepository.findByEmail(email);
        if (usuarioExistente != null) {
            redirectAttributes.addFlashAttribute("error", "O e-mail já está em uso.");
            return "redirect:/cadastro";
        }

        if (!senha.equals(repSenha)) {
            redirectAttributes.addFlashAttribute("error", "As senhas não coincidem.");
            return "redirect:/cadastro";
        }

        // Se o e-mail não existir na lista, adiciona o novo usuário
        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(nome);
        novoUsuario.setEmail(email);
        novoUsuario.setSenha(senha);
        usuarioRepository.save(novoUsuario);

        redirectAttributes.addFlashAttribute("success", "Usuário cadastrado com sucesso.");
        return "redirect:/login";
    }
}