package com.algaworks.algafood.domain.service;

import com.algaworks.algafood.domain.model.Restaurante;

import java.util.List;

public interface RestauranteService {

    List<Restaurante> findAll();
    Restaurante findById(Long id);
    Restaurante save(Restaurante restaurante);
    void delete(Long id);

}
