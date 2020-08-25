package com.algaworks.algafood.service.impl;

import com.algaworks.algafood.model.Cozinha;
import com.algaworks.algafood.repository.ICozinhaRepository;
import com.algaworks.algafood.repository.jpa.CadastroCozinha;
import com.algaworks.algafood.service.ICozinhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CozinhaService {

   @Autowired
   private ICozinhaRepository repository;

   public Cozinha save(String nome) {

      Cozinha cozinha = new Cozinha();

      cozinha.setNome(nome);

      return repository.save(cozinha);
   }

   public List<Cozinha> findAll() {
      return repository.findAll();
   }

   public Cozinha findById(Long id) {
      return repository.findById(id).get();
   }

   public Cozinha update(Cozinha cozinha) {
      return repository.save(cozinha);
   }

   public void delete(Long idCozinha) {

      repository.delete(this.findById(idCozinha));
   }
}
