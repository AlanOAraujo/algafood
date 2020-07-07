package com.algaworks.algafood.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "TAB_RESTAURANTE")
public class Restaurante {

    @Id
    @SequenceGenerator(sequenceName = "SEQ_TAB_RESTAURANTE", name = "SEQ_TAB_RESTAURANTE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TAB_RESTAURANTE")
    @Column(name = "ID_RESTAURANTE")
    private Long idRestaurante;

    @Column(name = "NM_RESTAURANTE")
    private String nmRestaurante;

    @Column(name = "TAXA_FRETE")
    private BigDecimal taxaFrete;

    public Long getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(Long idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public String getNmRestaurante() {
        return nmRestaurante;
    }

    public void setNmRestaurante(String nmRestaurante) {
        this.nmRestaurante = nmRestaurante;
    }

    public BigDecimal getTaxaFrete() {
        return taxaFrete;
    }

    public void setTaxaFrete(BigDecimal taxaFrete) {
        this.taxaFrete = taxaFrete;
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

