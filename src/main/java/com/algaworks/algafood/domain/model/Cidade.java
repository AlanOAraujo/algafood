package com.algaworks.algafood.domain.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "TAB_CIDADE")
@ApiModel(value = "Cidade", description = "Representacao em classe da tabela cidade")
public class Cidade implements Serializable {

    private static final long serialVersionUID = 7910378591214428164L;

    @Id
    @SequenceGenerator(sequenceName = "SEQ_TAB_CIDADE", name = "SEQ_TAB_CIDADE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TAB_CIDADE")
    @Column(name = "ID_CIDADE")
    @ApiModelProperty(value = "Registro de identificação da classe", hidden = true)
    private Long idCidade;

    @Column(name = "NM_CIDADE", nullable = false)
    @ApiModelProperty(value = "Nome da Cidade")
    private String nmCidade;

    @ManyToOne
    @JoinColumn( name = "ID_ESTADO", nullable = false, referencedColumnName = "ID_ESTADO")
    @ApiModelProperty(value = "Relacionamente referente a tabela estado")
    private Estado estado;

    @Builder
    public Cidade(Long idCidade, String nmCidade, Estado estado) {
        this.idCidade = idCidade;
        this.nmCidade = nmCidade;
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cidade cidade = (Cidade) o;
        return Objects.equals(idCidade, cidade.idCidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCidade);
    }
}
