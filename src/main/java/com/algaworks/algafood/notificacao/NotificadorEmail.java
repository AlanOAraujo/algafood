package com.algaworks.algafood.notificacao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.model.Cliente;
import com.algaworks.algafood.notificacao.interfase.Notificador;

@Component
@Primary
public class NotificadorEmail implements Notificador {

	public NotificadorEmail() {
		System.out.println("NotificadorEmail chamado");
	}
	
	@Override
	public void notificar(Cliente cliente, String mensagem) {
		System.out.println(String.format("Notificando %s através do e-mail %s: %s\n", 
				cliente.getNome(), cliente.getEmail(), mensagem));
	}
	
}
