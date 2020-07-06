package com.algaworks.algafood.repository;

import com.algaworks.algafood.model.Cozinha;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class CozinhaRepository {

    @PersistenceContext
    private EntityManager entityManager;


    public List<Cozinha> findAll(){
        return entityManager.createQuery("from Cozinha", Cozinha.class)
                .getResultList();
    }

}
