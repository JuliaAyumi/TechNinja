package techninja.techninja.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import techninja.techninja.model.Pergunta;

import java.util.List;

public interface PerguntaRepository extends MongoRepository<Pergunta, String>{
    List<Pergunta> findAllByIdIn(List<String> ids);
}

