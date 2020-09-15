package com.algaworks.algafood.infrastructure.repository;

import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.model.Cozinha;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class CozinhaRepositoryImpl implements CozinhaRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Cozinha> findAll() {
        TypedQuery<Cozinha> typedQuery = manager.createQuery("from Cozinha", Cozinha.class);
        return typedQuery.getResultList();
    }

    @Override
    public Cozinha findById(Long id) {
        return manager.find(Cozinha.class, id);
    }

    @Override
    public Cozinha save(Cozinha cozinha) {
        return manager.merge(cozinha);
    }

    @Override
    public void delete(Cozinha cozinha) {
        manager.remove(cozinha);
    }
}
