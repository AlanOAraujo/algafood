package com.algaworks.algafood.domain.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@NoArgsConstructor
@Entity
@Table(name = "TAB_RESTAURANTE")
@ApiModel(value = "Restaurante", description = "Representacao em classe da tabela Restaurante")
public class Restaurante implements Serializable {

    private static final long serialVersionUID = -6771549701497617148L;

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

    @ManyToOne
    @JoinColumn( name = "ID_COZINHA", nullable = false, referencedColumnName = "ID_COZINHA")
    @ApiModelProperty(value = "Relacionamente referente a tabela cozinha")
    private Cozinha cozinha;

    @Builder
    public Restaurante(Long idRestaurante, String nmRestaurante, BigDecimal taxaFrete) {
        this.idRestaurante = idRestaurante;
        this.nmRestaurante = nmRestaurante;
        this.taxaFrete = taxaFrete;
    }

    public Long getIdRestaurante() {
        return idRestaurante;
    }

    public String getNmRestaurante() {
        return nmRestaurante;
    }

    public BigDecimal getTaxaFrete() {
        return taxaFrete;
    }

    public Cozinha getCozinha() {
        return cozinha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurante that = (Restaurante) o;
        return Objects.equals(idRestaurante, that.idRestaurante);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRestaurante);
    }
}

