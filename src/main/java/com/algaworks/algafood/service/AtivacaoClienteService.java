package com.algaworks.algafood.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.annotations.TipoDeNotificador;
import com.algaworks.algafood.model.Cliente;
import com.algaworks.algafood.notificacao.interfase.Notificador;
import com.algaworks.algafood.service.enums.NivelUrgencia;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class AtivacaoClienteService {

	/*Passando o required dentro do Autowired, estamos informando para o Spring,
	 * para gerenciar a classe mesmo que o mesmo não esteja sendo gerenciado pelo spring.*/
	@TipoDeNotificador(NivelUrgencia.URGENTE)
	@Autowired(required = false) 
	private Notificador notificador;

	@PostConstruct
	public void init(){
		System.out.println("Init" + notificador);
	}

	@PreDestroy
	public void destroy(){
		System.out.println("Destroy");
	}

	public void ativar(Cliente cliente) {
		cliente.ativar();
		
		this.notificador.notificar(cliente, "Seu Cadastro no sistema está ativo!");
	}
	
}
