package br.com.fatec.techninja.controller;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import br.com.fatec.techninja.repository.QuestionRepository;
import br.com.fatec.techninja.repository.UsuarioRepository;
import br.com.fatec.techninja.model.Question;
import br.com.fatec.techninja.model.Usuario;



@RestController
public class QuizController {

    private final QuestionRepository questionRepository;
    private final UsuarioRepository userRepository;

    @Autowired
    public QuizController(QuestionRepository questionRepository, UsuarioRepository userRepository) {
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/quiz")
    public ResponseEntity<List<Question>> getQuiz(@RequestParam String difficulty, @RequestParam String theme) {
        System.out.println("Dificuldade: " + difficulty);
        System.out.println("Tema: " + theme);

        List<Question> allQuestions = questionRepository.findAll();

        List<Question> filteredQuestions = allQuestions.stream()
                .filter(q -> q.difficulty.equals(difficulty) && q.theme.equals(theme))
                .collect(Collectors.toList());

        Collections.shuffle(filteredQuestions);

        return ResponseEntity.ok(filteredQuestions.subList(0, Math.min(filteredQuestions.size(), 5)));
    }

    @PostMapping("/saveQuiz")
    public void saveQuiz(@RequestBody String quizData) {
        JSONParser jsonParser = new JSONParser();
        try {
            // Parse quizData into a JSONObject
            JSONObject quizDataJson = (JSONObject) jsonParser.parse(quizData);
            String userEmail = (String) quizDataJson.get("email");

            Usuario user = userRepository.findByEmail(userEmail);
            if (user != null) {
                user.getCompletedQuizzes().add(quizData);
                userRepository.save(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}