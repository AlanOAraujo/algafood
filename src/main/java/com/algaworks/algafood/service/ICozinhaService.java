package com.algaworks.algafood.service;

import com.algaworks.algafood.model.Cozinha;

import java.util.List;

public interface ICozinhaService {

    Cozinha save(String nomeCozinha);

    List<Cozinha> findAll();

    Cozinha findById(Long id);

    Cozinha update(Cozinha cozinha);

    void delete(Long idCozinha);
}
