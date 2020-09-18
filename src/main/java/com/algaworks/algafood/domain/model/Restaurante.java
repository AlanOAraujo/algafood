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
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "TAB_RESTAURANTE")
@ApiModel(value = "Restaurante", description = "Representacao em classe da tabela Restaurante")
public class Restaurante implements Serializable {

    private static final long serialVersionUID = -6771549701497617148L;

    @EqualsAndHashCode.Include
    @Id
    @SequenceGenerator(sequenceName = "SEQ_TAB_RESTAURANTE", name = "SEQ_TAB_RESTAURANTE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TAB_RESTAURANTE")
    @Column(name = "ID_RESTAURANTE")
    @ApiModelProperty(value = "Registro de identificação da classe", hidden = true)
    private Long idRestaurante;

    @Column(name = "NM_RESTAURANTE")
    @ApiModelProperty(value = "Nome do Restaurante")
    private String nmRestaurante;

    @Column(name = "TAXA_FRETE")
    @ApiModelProperty(value = "Taxa do Frete cobrada pelo restaurante")
    private BigDecimal taxaFrete;

}

