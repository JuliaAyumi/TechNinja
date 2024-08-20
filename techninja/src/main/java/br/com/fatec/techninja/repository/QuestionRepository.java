package br.com.fatec.techninja.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import br.com.fatec.techninja.model.Question;
import java.util.List;

public interface QuestionRepository extends MongoRepository<Question, String> {
    
    @Override
    @Query("{}")
    List<br.com.fatec.techninja.model.Question> findAll();
}