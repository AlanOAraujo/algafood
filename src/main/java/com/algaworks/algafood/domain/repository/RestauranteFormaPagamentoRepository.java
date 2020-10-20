package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.RestauranteFormaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestauranteFormaPagamentoRepository extends JpaRepository<RestauranteFormaPagamento, Long> {
}
