package com.algaworks.algafood.service.impl;

import com.algaworks.algafood.model.Restaurante;
import com.algaworks.algafood.repository.IRestauranteRepository;
import com.algaworks.algafood.service.IRestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestauranteService implements IRestauranteService {

    @Autowired
    private IRestauranteRepository repository;

    @Override
    public List<Restaurante> findAll() {
        return repository.findAll();
    }
}
