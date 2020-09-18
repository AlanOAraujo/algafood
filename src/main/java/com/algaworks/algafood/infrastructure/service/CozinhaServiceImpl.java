package com.algaworks.algafood.infrastructure.service;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.service.CozinhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class CozinhaServiceImpl implements CozinhaService {

   @Autowired
   private CozinhaRepository repository;

   @Override
   public Cozinha save(Cozinha cozinha) {
      return repository.save(cozinha);
   }

   @Override
   public List<Cozinha> findAll() {
      return repository.findAll();
   }

   @Override
   public Cozinha findById(Long id) {
      return repository.findById(id);
   }

   @Override
   public Cozinha update(Cozinha cozinha) {
      return repository.save(cozinha);
   }

   @Override
   public void delete(Long idCozinha) {

      Cozinha cozinha = this.findById(idCozinha);

      repository.delete(cozinha);
   }
}
