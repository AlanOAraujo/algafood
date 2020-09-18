package com.algaworks.algafood.infrastructure.service;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import com.algaworks.algafood.domain.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class RestauranteServiceImpl implements RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Override
    public List<Restaurante> findAll() {
        return restauranteRepository.findAll();
    }

    @Override
    public Restaurante findById(Long id) {
        return restauranteRepository.findById(id);
    }

    @Override
    public Restaurante save(Restaurante restaurante) {
        return restauranteRepository.save(restaurante);
    }

    @Override
    public void delete(Long id) {

        Restaurante restaurante = this.findById(id);

        restauranteRepository.delete(restaurante);
    }
}
