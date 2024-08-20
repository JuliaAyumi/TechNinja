package br.com.fatec.techninja.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {
        @GetMapping("/home")
    public String home(HttpSession session) {
        // Verifica se o usuário possui um logedToken
        if (session.getAttribute("logedToken") != null) {
            return "home";
        } else {
            // Se o usuário não possuir um logedToken, exibe um erro
            return "error";
        }
    }
    
}
