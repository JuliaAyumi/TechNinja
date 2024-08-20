package br.com.fatec.techninja.controller;

import java.io.FileReader;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class PerfilController {
    
@GetMapping("/perfil")
public String perfil(HttpSession session, Model model) {
    String email = (String) session.getAttribute("logedEmail");
    System.out.println("E-mail da sessão: " + email);
    if (email != null) {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("usuariosInfo.json")) {
            Object obj = jsonParser.parse(reader);
            JSONArray listaUsuarios = (JSONArray) obj;

            for (Object usuarioObj : listaUsuarios) {
                JSONObject usuario = (JSONObject) usuarioObj;
                if (usuario.get("email").equals(email)) {
                    model.addAttribute("usuario", usuario);
                    break;
                }
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    return "profile";
}
    
}
