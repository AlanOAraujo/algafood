package com.algaworks.algafood.infrastructure.service;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.repository.IRestauranteRepository;
import com.algaworks.algafood.domain.service.IRestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestauranteServiceImpl implements IRestauranteService {

    @Autowired
    private IRestauranteRepository repository;

    @Override
    public List<Restaurante> findAll() {
        return repository.findAll();
    }
}
