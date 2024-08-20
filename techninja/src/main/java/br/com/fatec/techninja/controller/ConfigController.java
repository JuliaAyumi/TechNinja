package br.com.fatec.techninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConfigController {
        // Pagina de Configurações -- Configurações
    @GetMapping("/configuracoes")
    public String configuracoes() {
        // verificar se o usuário está logado
        return "configuracoes";
    }
}
