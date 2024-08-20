package br.com.fatec.techninja.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
        // Pagina Incial do Site -- Incial
    @GetMapping("/")
    public String inicial() {
        return "inicial";
    }
        // Pagina Tutorial -- Tutorial
    @GetMapping("/tutorial")
        public String tutorial() {
            return "tutorial";
        }
        // Pagina de Perguntas -- Perguntas
        @GetMapping("/perguntas")
        public String perguntas() {
            // Verifique se o usuário está logado
            return "perguntas";
        }
    /*
     * @PostMapping("/cadastro")
     * public String cadastro(@RequestParam String nome, @RequestParam String
     * email, @RequestParam String senha, @RequestParam String repSenha,
     * RedirectAttributes redirectAttributes) {
     * JSONParser jsonParser = new JSONParser();
     * JSONArray listaUsuarios = new JSONArray();
     * 
     * // Verifica se o arquivo usuarios.json existe, se não existir ele cria o
     * arquivo
     * File file = new File("usuarios.json");
     * if (file.exists()) {
     * try (FileReader reader = new FileReader("usuarios.json")) {
     * // Lê o arquivo JSON existente
     * Object obj = jsonParser.parse(reader);
     * listaUsuarios = (JSONArray) obj;
     * } catch (IOException | ParseException e) {
     * // handle exception
     * }
     * }
     * 
     * // Adiciona o novo usuário
     * JSONObject novoUsuario = new JSONObject();
     * novoUsuario.put("nome", nome);
     * novoUsuario.put("email", email);
     * novoUsuario.put("senha", senha);
     * novoUsuario.put("repSenha", repSenha);
     * listaUsuarios.add(novoUsuario);
     * 
     * // Salva a lista atualizada no arquivo
     * try (FileWriter writer = new FileWriter("usuarios.json")) {
     * writer.write(listaUsuarios.toJSONString());
     * writer.flush();
     * } catch (IOException e) {
     * // handle exception
     * }
     * 
     * redirectAttributes.addFlashAttribute("success",
     * "Usuário cadastrado com sucesso.");
     * return "redirect:/login";
     * }
     */
    // Pagina de Testes -- Testes
    /*
     * @PostMapping("/checkCredentials")
     * 
     * @ResponseBody
     * public boolean checkCredentials(@RequestParam String email, @RequestParam
     * String senha) {
     * JSONParser jsonParser = new JSONParser();
     * JSONArray listaUsuarios = new JSONArray();
     * 
     * // Verifica se o arquivo usuarios.json existe
     * File file = new File("usuarios.json");
     * if (file.exists()) {
     * try (FileReader reader = new FileReader("usuarios.json")) {
     * // Lê o arquivo JSON existente
     * Object obj = jsonParser.parse(reader);
     * listaUsuarios = (JSONArray) obj;
     * 
     * // Verifica se o e-mail e a senha estão corretos
     * for (Object usuarioObj : listaUsuarios) {
     * JSONObject usuario = (JSONObject) usuarioObj;
     * if (usuario.get("email").equals(email) && usuario.get("senha").equals(senha))
     * {
     * return true;
     * }
     * }
     * } catch (IOException | ParseException e) {
     * // handle exception
     * }
     * }
     * return false;
     * }
     */
}