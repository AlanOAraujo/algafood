package com.algaworks.algafood.service;

import org.springframework.stereotype.Service;

import com.algaworks.algafood.model.Cliente;
import com.algaworks.algafood.notificacao.NotificadorEmail;
import com.algaworks.algafood.notificacao.interfase.Notificador;

@Service
public class AtivacaoClienteService {

	private Notificador notificador;
	
	public AtivacaoClienteService(Notificador notificador) {
		this.notificador = notificador;
		System.out.println("AtivacaoClienteService " + notificador);
	}

	public void ativar(Cliente cliente) {
		cliente.ativar();
		
		this.notificador.notificar(cliente, "Seu Cadastro no sistema está ativo!");
	}
	
}
