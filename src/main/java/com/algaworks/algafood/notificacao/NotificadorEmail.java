package com.algaworks.algafood.notificacao;

import org.springframework.context.annotation.Primary;

import com.algaworks.algafood.model.Cliente;
import com.algaworks.algafood.notificacao.interfase.Notificador;

@Primary
public class NotificadorEmail implements Notificador {

	private boolean caixaAlta;
	private String hostServerSmtp;
	
	public NotificadorEmail(String hostServerSmtp) {
		this.hostServerSmtp = hostServerSmtp;
		System.out.println("NotificadorEmail chamado");
	}
	
	@Override
	public void notificar(Cliente cliente, String mensagem) {
		
		if(this.caixaAlta)
			mensagem = mensagem.toUpperCase();
		
		System.out.println(String.format("Notificando %s através do e-mail %s usando o SMTP %s: %s\n", 
				cliente.getNome(), cliente.getEmail(), this.hostServerSmtp, mensagem));
	}

	public void setCaixaAlta(boolean caixaAlta) {
		this.caixaAlta = caixaAlta;
	}
	
	
	
}
