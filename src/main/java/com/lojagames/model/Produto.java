package com.lojagames.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import jakarta.validation.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "tb_produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Título é obrigatório!")
	@Size(min=1, max=255, message="O título do produto deve ter entre 1 e 255 caracteres.")
	private String titulo;
	
	@NotNull(message = "Preço é obrigatório!")
    @Positive(message = "O preço deve ser maior do que zero!")
    private BigDecimal preco;
	
	@UpdateTimestamp
	private LocalDateTime datacadastro;
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Categoria categoria;

	
//	métodos Getters e Setters
	
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

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public LocalDateTime getDatacadastro() {
		return datacadastro;
	}

	public void setDatacadastro(LocalDateTime datacadastro) {
		this.datacadastro = datacadastro;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	
	

}
