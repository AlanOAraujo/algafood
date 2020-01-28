package com.algaworks.algafood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.model.Cliente;
import com.algaworks.algafood.notificacao.interfase.Notificador;

@Service
public class AtivacaoClienteService {

	@Autowired 
	private List<Notificador> notificadores;

	public void ativar(Cliente cliente) {
		cliente.ativar();
		
		for (Notificador notificador : notificadores) {
			notificador.notificar(cliente, "Seu Cadastro no sistema está ativo!");
		}
		
	}
	
}
