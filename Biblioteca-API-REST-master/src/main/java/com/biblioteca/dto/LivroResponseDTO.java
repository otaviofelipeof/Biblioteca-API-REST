package com.biblioteca.dto;

import com.biblioteca.entity.Livro;

public class LivroResponseDTO {

    private Long id;
    private String titulo;
    private String isbn;
    private Integer anoPublicacao;
    private String genero;
    private String nomeAutor;
    private Long autorId;

    // Construtor que converte de Entidade para DTO
    public LivroResponseDTO(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.isbn = livro.getIsbn();
        this.anoPublicacao = livro.getAnoPublicacao();
        this.genero = livro.getGenero();
        this.nomeAutor = livro.getAutor().getNome();
        this.autorId = livro.getAutor().getId();
    }

    // Getters
    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getIsbn() { return isbn; }
    public Integer getAnoPublicacao() { return anoPublicacao; }
    public String getGenero() { return genero; }
    public String getNomeAutor() { return nomeAutor; }
    public Long getAutorId() { return autorId; }
}
