package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;

import java.util.List;

public interface RestauranteRepository {

    List<Restaurante> findAll();
    Restaurante findById(Long id);
    Restaurante save(Restaurante restaurante);
    void delete(Restaurante restaurante);

}
