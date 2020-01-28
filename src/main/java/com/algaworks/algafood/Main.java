package com.algaworks.algafood;

import com.algaworks.algafood.model.Cliente;
import com.algaworks.algafood.notificacao.NotificadorEmail;
import com.algaworks.algafood.service.AtivacaoClienteService;

public class Main {

	public static void main(String[] args) {
		Cliente joao = new Cliente("João", "joao@xyz.com", "11988774455");
		Cliente maria = new Cliente("Maria", "maria@xyz.com", "11911223344");
		
		NotificadorEmail notificador = new NotificadorEmail();
		
		AtivacaoClienteService ativacaoClienteService = new AtivacaoClienteService(notificador);
		ativacaoClienteService.ativar(joao);
		ativacaoClienteService.ativar(maria);
	}
	
}
