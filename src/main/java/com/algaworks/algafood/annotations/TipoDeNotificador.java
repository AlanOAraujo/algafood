package com.algaworks.algafood.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.beans.factory.annotation.Qualifier;

import com.algaworks.algafood.service.enums.NivelUrgencia;

@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface TipoDeNotificador {

	NivelUrgencia value();
	
}
