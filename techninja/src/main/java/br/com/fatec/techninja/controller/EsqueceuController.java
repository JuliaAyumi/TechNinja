package br.com.fatec.techninja.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class EsqueceuController {
        // Pagina de Esqueceu a Senha -- Esqueceu
    @GetMapping("/esqueceu")
    public String esqueceu() {
        return "esqueceu";
    }
}
