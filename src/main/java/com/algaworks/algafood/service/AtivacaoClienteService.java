package com.algaworks.algafood.service;

import com.algaworks.algafood.event.publish.ClienteAtivadoEvent;
import com.algaworks.algafood.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class AtivacaoClienteService {

	@Autowired
	private ApplicationEventPublisher eventPublisher;

	/**
	 * Os metodos Init e Destroy
	 * é para mostrar o ciclo de vida de nosso bean
	 * **/

	/** Estamos mostrando o ciclo de inicialização da Bean**/
	//	@PostConstruct
	//	public void init(){
	//		System.out.println("Init " + notificador);
	//	}

	/** Estamos mostrando o ciclo final da via da Bean**/
	//	@PreDestroy
	//	public void destroy(){
	//		System.out.println("Destroy");
	//	}

	public void ativar(Cliente cliente) {
		cliente.ativar();

		eventPublisher.publishEvent(new ClienteAtivadoEvent(cliente));
	}
	
}
