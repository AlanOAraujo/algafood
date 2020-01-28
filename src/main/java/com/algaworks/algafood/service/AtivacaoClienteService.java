package com.algaworks.algafood.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.model.Cliente;
import com.algaworks.algafood.notificacao.interfase.Notificador;

@Service
public class AtivacaoClienteService {

	/*Passando o required, estamos informando para o Spring, 
	 * para gerenciar a classe mesmo que o mesmo não esteja sendo gerenciado pelo spring.*/
	@Qualifier("email")
	@Autowired(required = false) 
	private Notificador notificador;

	public void ativar(Cliente cliente) {
		cliente.ativar();
		
		this.notificador.notificar(cliente, "Seu Cadastro no sistema está ativo!");
	}
	
}
