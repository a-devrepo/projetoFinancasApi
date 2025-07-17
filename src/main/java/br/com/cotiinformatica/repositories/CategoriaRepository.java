package br.com.cotiinformatica.repositories;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.cotiinformatica.domain.entities.Categoria;

public interface CategoriaRepository extends MongoRepository<Categoria, UUID> {}
