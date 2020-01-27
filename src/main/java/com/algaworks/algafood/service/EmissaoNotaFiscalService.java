package com.algaworks.algafood.service;

import com.algaworks.algafood.model.Cliente;
import com.algaworks.algafood.model.Produto;
import com.algaworks.algafood.notificacao.interfase.Notificador;

public class EmissaoNotaFiscalService {

	Notificador notificador;
	
	public EmissaoNotaFiscalService(Notificador notificador) {
		this.notificador = notificador;
	}
	
	public void emitir(Cliente cliente, Produto produto) {
		
		this.notificador.notificar(cliente, "Nota Fiscal do produto " +produto.getNome()+" foi emitida!");
		
	}

}
