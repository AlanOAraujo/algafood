package com.algaworks.algafood.notificacao;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.annotations.TipoDeNotificador;
import com.algaworks.algafood.model.Cliente;
import com.algaworks.algafood.notificacao.interfase.Notificador;
import com.algaworks.algafood.service.enums.NivelUrgencia;

@TipoDeNotificador(NivelUrgencia.URGENTE)
@Component
public class NotificadorSMS implements Notificador{

	@Override
	public void notificar(Cliente cliente, String mensagem) {
		System.out.println(String.format("Notificando %s por SMS através do telefone %s: %s\n", 
				cliente.getNome(), cliente.getTelefone(), mensagem));
	}
	
}
