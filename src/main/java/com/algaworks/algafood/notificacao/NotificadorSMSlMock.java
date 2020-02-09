package com.algaworks.algafood.notificacao;

import com.algaworks.algafood.annotations.TipoDeNotificador;
import com.algaworks.algafood.model.Cliente;
import com.algaworks.algafood.notificacao.interfase.Notificador;
import com.algaworks.algafood.service.enums.NivelUrgencia;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("dev")
@TipoDeNotificador(NivelUrgencia.URGENTE)
@Component
public class NotificadorSMSlMock implements Notificador {

	public NotificadorSMSlMock() {
		System.out.println("Notificador SMS Teste");
	}

	@Override
	public void notificar(Cliente cliente, String mensagem) {
		System.out.println(String.format("MOCK: Notificando enviado para %s através do telefone %s: %s\n",
				cliente.getNome(), cliente.getTelefone(), mensagem));
	}
	
}
