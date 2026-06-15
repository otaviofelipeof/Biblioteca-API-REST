package com.biblioteca.dto;

import com.biblioteca.entity.Autor;

public class AutorResponseDTO {

    private Long id;
    private String nome;
    private String nacionalidade;
    private int totalLivros;

    // Construtor que converte de Entidade para DTO
    public AutorResponseDTO(Autor autor) {
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.nacionalidade = autor.getNacionalidade();
        this.totalLivros = autor.getLivros().size();
    }

    // Getters
    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getNacionalidade() { return nacionalidade; }
    public int getTotalLivros() { return totalLivros; }
}
