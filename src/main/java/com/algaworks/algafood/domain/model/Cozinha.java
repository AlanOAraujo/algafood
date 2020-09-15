package com.algaworks.algafood.domain.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TAB_COZINHA")
public class Cozinha {

    @Id
    @SequenceGenerator(sequenceName = "SEQ_TAB_COZINHA", name = "SEQ_TAB_COZINHA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TAB_COZINHA")
    @Column(name = "ID_COZINHA")
    private Long idCozinha;

    @Column(name = "NM_COZINHA")
    private String nome;

    public Long getIdCozinha() {
        return idCozinha;
    }

    public void setIdCozinha(Long idCozinha) {
        this.idCozinha = idCozinha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cozinha cozinha = (Cozinha) o;
        return idCozinha.equals(cozinha.idCozinha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCozinha);
    }
}
