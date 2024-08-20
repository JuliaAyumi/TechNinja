package br.com.fatec.techninja.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.fatec.techninja.model.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    Usuario findByEmail(String email);
}