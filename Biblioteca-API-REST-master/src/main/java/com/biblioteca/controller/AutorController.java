package com.biblioteca.controller;

import com.biblioteca.dto.AutorRequestDTO;
import com.biblioteca.dto.AutorResponseDTO;
import com.biblioteca.service.AutorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    /**
     * POST /autores
     * Cadastra um novo autor
     */
    @PostMapping
    public ResponseEntity<AutorResponseDTO> cadastrar(@Valid @RequestBody AutorRequestDTO dto) {
        AutorResponseDTO resposta = autorService.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    /**
     * GET /autores
     * Lista todos os autores
     */
    @GetMapping
    public ResponseEntity<List<AutorResponseDTO>> listarTodos() {
        List<AutorResponseDTO> autores = autorService.listarTodos();
        return ResponseEntity.ok(autores);
    }
}
