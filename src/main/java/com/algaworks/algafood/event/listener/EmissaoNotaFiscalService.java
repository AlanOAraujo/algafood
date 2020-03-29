package com.algaworks.algafood.event.listener;

import com.algaworks.algafood.annotations.TipoDeNotificador;
import com.algaworks.algafood.event.publish.ClienteAtivadoEvent;
import com.algaworks.algafood.notificacao.interfase.Notificador;
import com.algaworks.algafood.service.enums.NivelUrgencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EmissaoNotaFiscalService {

    @TipoDeNotificador(NivelUrgencia.URGENTE)
    @Autowired
    private Notificador notificador;

    @EventListener
    public void clienteAtivadoListener(ClienteAtivadoEvent event){
        System.out.println("Emitindo nota fiscal para cliente "+ event.getCliente().getNome());
    }
}
