package br.com.cotiinformatica.domain.entities;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "categorias")
public class Categoria {

	@Id
	private UUID id;
	private String nome;
}
