package com.biblioteca.service;

import com.biblioteca.dto.AutorRequestDTO;
import com.biblioteca.dto.AutorResponseDTO;
import com.biblioteca.entity.Autor;
import com.biblioteca.repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    // Injeção de dependência via construtor (boa prática)
    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    /**
     * Cadastra um novo autor
     */
    public AutorResponseDTO cadastrar(AutorRequestDTO dto) {
        Autor autor = new Autor(dto.getNome(), dto.getNacionalidade());
        Autor salvo = autorRepository.save(autor);
        return new AutorResponseDTO(salvo);
    }

    /**
     * Lista todos os autores cadastrados
     */
    public List<AutorResponseDTO> listarTodos() {
        return autorRepository.findAll()
                .stream()
                .map(AutorResponseDTO::new)
                .collect(Collectors.toList());
    }

    /**
     * Busca um autor pelo ID (usado internamente)
     */
    public Autor buscarEntidadePorId(Long id) {
        return autorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor não encontrado com ID: " + id));
    }
}
