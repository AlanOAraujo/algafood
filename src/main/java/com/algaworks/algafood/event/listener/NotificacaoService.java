package com.algaworks.algafood.event.listener;

import com.algaworks.algafood.annotations.TipoDeNotificador;
import com.algaworks.algafood.event.publish.ClienteAtivadoEvent;
import com.algaworks.algafood.notificacao.interfase.Notificador;
import com.algaworks.algafood.service.enums.NivelUrgencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class NotificacaoService {

    @TipoDeNotificador(NivelUrgencia.SEM_URGENCIA)
    @Autowired
    private Notificador notificador;

    @EventListener
    public void clienteAtivadoListener(ClienteAtivadoEvent clienteAtivadoEvent){
        notificador.notificar(clienteAtivadoEvent.getCliente(), "cliente ativo");
    }


}
