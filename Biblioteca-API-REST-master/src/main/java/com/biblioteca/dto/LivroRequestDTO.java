package com.biblioteca.dto;

import jakarta.validation.constraints.*;

public class LivroRequestDTO {

    @NotBlank(message = "O título é obrigatório")
    @Size(min = 1, max = 200, message = "O título deve ter entre 1 e 200 caracteres")
    private String titulo;

    @NotBlank(message = "O ISBN é obrigatório")
    @Pattern(regexp = "\\d{13}", message = "O ISBN deve conter exatamente 13 dígitos numéricos")
    private String isbn;

    @NotNull(message = "O ano de publicação é obrigatório")
    @Min(value = 1000, message = "Ano de publicação inválido")
    @Max(value = 2100, message = "Ano de publicação inválido")
    private Integer anoPublicacao;

    @NotBlank(message = "O gênero é obrigatório")
    private String genero;

    @NotNull(message = "O ID do autor é obrigatório")
    private Long autorId;

    // Getters e Setters
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public Integer getAnoPublicacao() { return anoPublicacao; }
    public void setAnoPublicacao(Integer anoPublicacao) { this.anoPublicacao = anoPublicacao; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public Long getAutorId() { return autorId; }
    public void setAutorId(Long autorId) { this.autorId = autorId; }
}
