package com.algaworks.algafood.domain.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "TAB_COZINHA")
@ApiModel(value = "Cozinha", description = "Representacao em classe da tabela Cozinha")
public class Cozinha implements Serializable {

    private static final long serialVersionUID = -7911272381270147884L;

    @Id
    @EqualsAndHashCode.Include
    @ApiModelProperty(value = "Registro de identificação da classe", hidden = true)
    @SequenceGenerator(sequenceName = "SEQ_TAB_COZINHA", name = "SEQ_TAB_COZINHA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TAB_COZINHA")
    @Column(name = "ID_COZINHA")
    private Long idCozinha;

    @ApiModelProperty(value = "Nome da cozinha")
    @Column(name = "NM_COZINHA")
    private String nome;

    @OneToMany(mappedBy = "cozinha", fetch = FetchType.EAGER)
    @ApiModelProperty(hidden = true)
    private Collection<Restaurante> restaurantes = Collections.emptyList();

}
