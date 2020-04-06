package com.algaworks.algafood.notificacao;

import com.algaworks.algafood.properties.NotificadorProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.annotations.TipoDeNotificador;
import com.algaworks.algafood.model.Cliente;
import com.algaworks.algafood.notificacao.interfase.Notificador;
import com.algaworks.algafood.service.enums.NivelUrgencia;

@TipoDeNotificador(NivelUrgencia.SEM_URGENCIA)
@Component
public class NotificadorEmail implements Notificador {

	@Autowired
	private NotificadorProperties properties;

	public NotificadorEmail() {
		System.out.println("Notificador Email Real");
	}
	
	@Override
	public void notificar(Cliente cliente, String mensagem) {

		System.out.println("Host: "+properties.getHostServidor());
		System.out.println("Porta: "+properties.getPortaServidor());

		System.out.println(String.format("Notificando %s através do e-mail %s: %s\n", 
				cliente.getNome(), cliente.getEmail(), mensagem));
	}
	
}
