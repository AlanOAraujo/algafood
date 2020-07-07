package com.algaworks.algafood.repository;

import com.algaworks.algafood.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRestauranteRepository extends JpaRepository<Restaurante, Long> {
}
