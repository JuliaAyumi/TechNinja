package br.com.fatec.techninja.controller;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class QuizesController {
        @GetMapping("/quizes")
    public String quizes(HttpSession session, Model model) {
        String logedEmail = (String) session.getAttribute("logedEmail");
        model.addAttribute("logedEmail", logedEmail);
        // Verifique se o usuário está logado
        return "quizes";
    }
}
