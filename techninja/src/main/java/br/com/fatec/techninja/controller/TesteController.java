package br.com.fatec.techninja.controller;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;

@Controller
public class TesteController {
    
    @GetMapping("/testes")
    public String testes(HttpSession session, Model model) {
        String logedEmail = (String) session.getAttribute("logedEmail");
        if (logedEmail == null) {
            return "redirect:/login";
        }
        model.addAttribute("logedEmail", logedEmail);

        ObjectMapper objectMapper = new ObjectMapper();
        try {

            List<Map<String, Object>> users = objectMapper.readValue(Paths.get("/usuariosInfo.json").toFile(),
                    new TypeReference<List<Map<String, Object>>>() {
                    });

            for (Map<String, Object> user : users) {
                if (logedEmail.equals(user.get("email"))) {
                    model.addAttribute("userInfo", user);

                    break;
                }
            }
        } catch (IOException e) {
            // handle exception
        }

        return "testes";
    }
}
