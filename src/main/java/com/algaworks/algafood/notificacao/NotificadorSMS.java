package com.algaworks.algafood.notificacao;

import com.algaworks.algafood.model.Cliente;

public class NotificadorSMS {

	public void notificar(Cliente cliente, String mensagem) {
		System.out.println(String.format("Notificando %s por SMS através do telefone %s: %s\n", 
				cliente.getNome(), cliente.getTelefone(), mensagem));
	}
	
}
