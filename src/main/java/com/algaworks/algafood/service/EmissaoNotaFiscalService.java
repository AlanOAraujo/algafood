package com.algaworks.algafood.service;

import org.springframework.stereotype.Service;

import com.algaworks.algafood.model.Cliente;
import com.algaworks.algafood.model.Produto;
import com.algaworks.algafood.notificacao.interfase.Notificador;

@Service
public class EmissaoNotaFiscalService {

	Notificador notificador;
	
	public EmissaoNotaFiscalService(Notificador notificador) {
		this.notificador = notificador;
	}
	
	public void emitir(Cliente cliente, Produto produto) {
		
		this.notificador.notificar(cliente, "Nota Fiscal do produto " +produto.getNome()+" foi emitida!");
		
	}

}
