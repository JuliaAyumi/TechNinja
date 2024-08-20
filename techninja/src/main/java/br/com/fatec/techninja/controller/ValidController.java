package br.com.fatec.techninja.controller;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;

@Controller
public class ValidController {
    
    @GetMapping("/checkEmail")
    public ResponseEntity<Boolean> checkEmail(@RequestParam String email) {
        JSONParser jsonParser = new JSONParser();
        JSONArray listaUsuarios = new JSONArray();
        File file = new File("usuarios.json");
        if (file.exists()) {
            try (FileReader reader = new FileReader("usuarios.json")) {
                Object obj = jsonParser.parse(reader);
                listaUsuarios = (JSONArray) obj;
                for (Object usuarioObj : listaUsuarios) {
                    JSONObject usuario = (JSONObject) usuarioObj;
                    if (usuario.get("email").equals(email)) {
                        return ResponseEntity.ok(true);
                    }
                }
            } catch (IOException | ParseException e) {
                // handle exception
            }
        }
        return ResponseEntity.ok(false);
    }


    
}
