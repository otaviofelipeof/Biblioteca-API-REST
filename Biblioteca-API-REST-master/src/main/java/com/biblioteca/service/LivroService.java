package com.biblioteca.service;

import com.biblioteca.dto.LivroRequestDTO;
import com.biblioteca.dto.LivroResponseDTO;
import com.biblioteca.entity.Autor;
import com.biblioteca.entity.Livro;
import com.biblioteca.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroService {

    private final LivroRepository livroRepository;
    private final AutorService autorService;

    public LivroService(LivroRepository livroRepository, AutorService autorService) {
        this.livroRepository = livroRepository;
        this.autorService = autorService;
    }

    /**
     * Cadastra um novo livro
     */
    public LivroResponseDTO cadastrar(LivroRequestDTO dto) {
        // Verifica se já existe um livro com o mesmo ISBN
        if (livroRepository.existsByIsbn(dto.getIsbn())) {
            throw new RuntimeException("Já existe um livro cadastrado com o ISBN: " + dto.getIsbn());
        }

        // Busca o autor no banco
        Autor autor = autorService.buscarEntidadePorId(dto.getAutorId());

        Livro livro = new Livro(
                dto.getTitulo(),
                dto.getIsbn(),
                dto.getAnoPublicacao(),
                dto.getGenero(),
                autor
        );

        Livro salvo = livroRepository.save(livro);
        return new LivroResponseDTO(salvo);
    }

    /**
     * Lista todos os livros cadastrados
     */
    public List<LivroResponseDTO> listarTodos() {
        return livroRepository.findAll()
                .stream()
                .map(LivroResponseDTO::new)
                .collect(Collectors.toList());
    }

    /**
     * Atualiza os dados de um livro existente
     */
    public LivroResponseDTO atualizar(Long id, LivroRequestDTO dto) {
        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado com ID: " + id));

        // Verifica ISBN duplicado (ignora o próprio livro)
        if (!livro.getIsbn().equals(dto.getIsbn()) && livroRepository.existsByIsbn(dto.getIsbn())) {
            throw new RuntimeException("Já existe um livro cadastrado com o ISBN: " + dto.getIsbn());
        }

        Autor autor = autorService.buscarEntidadePorId(dto.getAutorId());

        livro.setTitulo(dto.getTitulo());
        livro.setIsbn(dto.getIsbn());
        livro.setAnoPublicacao(dto.getAnoPublicacao());
        livro.setGenero(dto.getGenero());
        livro.setAutor(autor);

        Livro atualizado = livroRepository.save(livro);
        return new LivroResponseDTO(atualizado);
    }

    /**
     * Remove um livro pelo ID
     */
    public void excluir(Long id) {
        if (!livroRepository.existsById(id)) {
            throw new RuntimeException("Livro não encontrado com ID: " + id);
        }
        livroRepository.deleteById(id);
    }
}
