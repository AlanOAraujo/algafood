package com.algaworks.algafood.domain.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@NoArgsConstructor
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

    @OneToMany(mappedBy = "cozinha")
    @ApiModelProperty(hidden = true)
    private Collection<Restaurante> restaurantes = Collections.emptyList();

    @Builder
    public Cozinha(Long id,String nome){
        this.idCozinha = id;
        this.nome = nome;
    }

    public Long getIdCozinha() {
        return idCozinha;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cozinha cozinha = (Cozinha) o;
        return Objects.equals(idCozinha, cozinha.idCozinha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCozinha);
    }
}
