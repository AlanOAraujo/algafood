package com.algaworks.algafood.repository.jpa;

import com.algaworks.algafood.model.Cozinha;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class CadastroCozinha {

    @PersistenceContext
    private EntityManager manager;

    public List<Cozinha> findAll(){

        TypedQuery<Cozinha> typedQuery = manager.createQuery("from Cozinha", Cozinha.class);
        return typedQuery.getResultList();

    }

}
