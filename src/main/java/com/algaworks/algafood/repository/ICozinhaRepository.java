package com.algaworks.algafood.repository;

import com.algaworks.algafood.domain.model.Cozinha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICozinhaRepository  extends JpaRepository<Cozinha, Long> {
}
