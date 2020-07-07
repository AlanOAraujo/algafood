package com.algaworks.algafood.service.impl;

import com.algaworks.algafood.model.Cozinha;
import com.algaworks.algafood.repository.ICozinhaRepository;
import com.algaworks.algafood.service.ICozinhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CozinhaService implements ICozinhaService {

   @Autowired
   private ICozinhaRepository repository;

   @Override
   public List<Cozinha> findAll() {
      return repository.findAll();
   }
}
