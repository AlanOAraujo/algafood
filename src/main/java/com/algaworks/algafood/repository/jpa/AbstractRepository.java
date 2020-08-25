package com.algaworks.algafood.repository.jpa;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Component
public abstract class AbstractRepository implements IAbstractRepository {

    @PersistenceContext
    protected EntityManager manager;

    private Class<?> clazz;

    @Override
    public <T> Optional<T> save(T t) {

        return Optional.ofNullable(manager.merge(t));
    }

    public <T> List<T> findAll(){

        return manager.createQuery(String.format("from %s", this.clazz)).getResultList();

    }
}
