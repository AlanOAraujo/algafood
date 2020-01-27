package com.algaworks.algafood.notificacao.interfase;

import com.algaworks.algafood.model.Cliente;

public interface Notificador {

	void notificar(Cliente cliente, String mensagem);
	
}
