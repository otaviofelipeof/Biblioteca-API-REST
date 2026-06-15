package com.biblioteca.repository;

import com.biblioteca.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    // Spring Data JPA gera automaticamente os métodos básicos de CRUD
    // Métodos adicionais podem ser declarados aqui se necessário
    boolean existsByNome(String nome);
}
