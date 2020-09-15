package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.Cozinha;

import java.util.List;

public interface CozinhaRepository {

    List<Cozinha> findAll();
    Cozinha findById(Long id);
    Cozinha save(Cozinha cozinha);
    void delete(Cozinha cozinha);
}
