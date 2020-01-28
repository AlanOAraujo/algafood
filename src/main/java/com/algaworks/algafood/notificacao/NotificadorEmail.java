package com.algaworks.algafood.notificacao;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.annotations.TipoDeNotificador;
import com.algaworks.algafood.model.Cliente;
import com.algaworks.algafood.notificacao.interfase.Notificador;
import com.algaworks.algafood.service.enums.NivelUrgencia;

@TipoDeNotificador(NivelUrgencia.SEM_URGENCIA)
@Component
public class NotificadorEmail implements Notificador {
	
	@Override
	public void notificar(Cliente cliente, String mensagem) {
		System.out.println(String.format("Notificando %s através do e-mail %s: %s\n", 
				cliente.getNome(), cliente.getEmail(), mensagem));
	}
	
}
