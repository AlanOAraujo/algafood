package com.algaworks.algafood.domain.service;

import com.algaworks.algafood.domain.model.Cozinha;

import java.util.List;

public interface CozinhaService {

    Cozinha save(Cozinha cozinha);

    List<Cozinha> findAll();

    Cozinha findById(Long id);

    Cozinha update(Cozinha cozinha);

    void delete(Long idCozinha);
}
