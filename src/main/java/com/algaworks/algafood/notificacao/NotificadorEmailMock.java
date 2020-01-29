package com.algaworks.algafood.notificacao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.annotations.TipoDeNotificador;
import com.algaworks.algafood.model.Cliente;
import com.algaworks.algafood.notificacao.interfase.Notificador;
import com.algaworks.algafood.service.enums.NivelUrgencia;

@Profile("dev")
@TipoDeNotificador(NivelUrgencia.SEM_URGENCIA)
@Component
public class NotificadorEmailMock implements Notificador {
	
	public NotificadorEmailMock() {
		System.out.println("Notificador Email Teste");
	}
	
	@Override
	public void notificar(Cliente cliente, String mensagem) {
		System.out.println(String.format("MOCK: Notificando seria enviada %s através do e-mail %s: %s\n", 
				cliente.getNome(), cliente.getEmail(), mensagem));
	}
	
}
