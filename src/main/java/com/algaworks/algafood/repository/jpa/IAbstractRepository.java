package com.algaworks.algafood.repository.jpa;

import java.util.List;
import java.util.Optional;

public interface IAbstractRepository {

    <T> Optional<T> save(T t);

    <T> List<T> findAll();
}
