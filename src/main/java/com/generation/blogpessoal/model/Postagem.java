package com.generation.blogpessoal.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity // Define que será uma tabela
@Table(name = "tb_postagens") // Nomeia a Tabela
public class Postagem {

	@Id //Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increment
	private Long id;
	
	/*
	 *  Not Null = Proíbe a ausencia de qualquer coisa
	 *  Not Black = Proíbe a ausencia de qualquer coisa e também campos com espaço
	 */
	
	// Título que tenha no mínimo 5 caracteres e no máximo 100
	@NotBlank(message = "O atributo título é Obrigatório!") //
	@Size(min = 5, max = 100, message = "O atributo título deve conter no mínimo 05 e no máximo 100 caracteres")
	@Column(length = 100) // Sobrescrevendo a quantidade padrão de caracteres máximos
	private String titulo;
	
	// Texto que tenha no mínimo 10 caracteres e no máximo 1000
	@NotBlank(message = "O atributo texto é Obrigatório!")
	@Column(length = 1000) // // Sobrescrevendo a quantidade padrão de caracteres máximos
	@Size(min = 10, max = 1000, message = "O atributo texto deve conter no mínimo 10 e no máximo 1000 caracteres")
	private String texto;
	
	// Deixar o Banco de Dados saber a data - Ele mesmo vai atualizar a data, gerar a data
	@UpdateTimestamp
	private LocalDateTime data;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}
	
	
	
}
