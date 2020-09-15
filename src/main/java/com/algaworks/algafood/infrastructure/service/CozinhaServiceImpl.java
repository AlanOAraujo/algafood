package com.algaworks.algafood.infrastructure.service;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.service.ICozinhaService;
import com.algaworks.algafood.repository.ICozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CozinhaServiceImpl implements ICozinhaService {

   @Autowired
   private ICozinhaRepository repository;

   @Override
   public Cozinha save(String nome) {

      Cozinha cozinha = new Cozinha();

      cozinha.setNome(nome);

      return repository.save(cozinha);
   }

   @Override
   public List<Cozinha> findAll() {
      return repository.findAll();
   }

   @Override
   public Cozinha findById(Long id) {
      return repository.findById(id).get();
   }

   @Override
   public Cozinha update(Cozinha cozinha) {
      return repository.save(cozinha);
   }

   @Override
   public void delete(Long idCozinha) {

      repository.delete(this.findById(idCozinha));
   }
}
