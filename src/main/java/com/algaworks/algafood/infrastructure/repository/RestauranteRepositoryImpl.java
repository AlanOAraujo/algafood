package com.algaworks.algafood.infrastructure.repository;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class RestauranteRepositoryImpl implements RestauranteRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Restaurante> findAll() {

        return manager.createQuery("from Restaurante", Restaurante.class).getResultList();
    }

    @Override
    public Restaurante findById(Long id) {
        return manager.find(Restaurante.class, id);
    }

    @Override
    public Restaurante save(Restaurante restaurante) {
        return manager.merge(restaurante);
    }

    @Override
    public void delete(Restaurante restaurante) {
        manager.remove(restaurante);
    }
}
