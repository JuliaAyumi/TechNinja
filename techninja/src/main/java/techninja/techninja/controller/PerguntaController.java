package techninja.techninja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import techninja.techninja.model.Pergunta;
import techninja.techninja.repository.PerguntaRepository;

import java.util.List;

@RestController
@RequestMapping("/perguntas")
public class PerguntaController {

    @Autowired
    private PerguntaRepository perguntaRepository;

    @GetMapping
    public List<Pergunta> listarPerguntas(){
        return perguntaRepository.findAll();
    } //Lista todas as perguntas do banco

    //Busca uma pergunta
    @GetMapping("/{id}")
    public Pergunta getPerguntaById(@PathVariable String id) {
        return perguntaRepository.findById(id).orElse(null);
    }

    // Buscar varias perguntas
    @GetMapping("/buscar")
    public List<Pergunta> buscarPerguntasporIds(@RequestParam List<String> ids){
        return perguntaRepository.findAllByIdIn(ids);
    }

    //Adiciona uma pergunta
    @PostMapping
    public Pergunta adicionarPergunta(@RequestBody Pergunta pergunta) {
        return perguntaRepository.save(pergunta);
    }

    //Adiciona varias perguntas de uma vez
    @PostMapping("/adicionar")
    public List<Pergunta> adicionarPerguntas(@RequestBody List<Pergunta> perguntas) {
        return perguntaRepository.saveAll(perguntas);
    }

    // Atualiza uma pergunta
    @PutMapping("/{id}")
    public Pergunta atualizarPergunta(@PathVariable String id, @RequestBody Pergunta perguntaAtualizada) {
        perguntaAtualizada.setId(id);
        return perguntaRepository.save(perguntaAtualizada);
    }

    // Atualiza varias perguntas de uma vez
    @PutMapping("/atualizar")
    public ResponseEntity<String> atualizarPerguntas(@RequestBody List<Pergunta> perguntasAtualizadas) {
        for (Pergunta pergunta : perguntasAtualizadas) {
            perguntaRepository.save(pergunta);
        }
        return ResponseEntity.ok("Perguntas atualizadas com sucesso");
    }

    // Deleta uma pergunta
    @DeleteMapping("/{id}")
    public void deletarPergunta(@PathVariable String id) {
        perguntaRepository.deleteById(id);
    }

    // Deleta varias perguntas de uma vez
    @DeleteMapping("/deletar")
    public ResponseEntity<String> deletarPerguntas(@RequestBody List<String> ids) {
        perguntaRepository.deleteAllById(ids);
        return ResponseEntity.ok("Perguntas deletadas com sucesso");
    }
}