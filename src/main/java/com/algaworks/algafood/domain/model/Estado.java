package com.algaworks.algafood.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "TAB_ESTADO")
@ApiModel(value = "Estado", description = "Representacao em classe da tabela estado")
public class Estado implements Serializable {

    private static final long serialVersionUID = -8602294129383999976L;

    @Id
    @EqualsAndHashCode.Include
    @ApiModelProperty(value = "Registro de identificação da classe", hidden = true)
    @SequenceGenerator(sequenceName = "SEQ_TAB_ESTADO", name = "SEQ_TAB_ESTADO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TAB_ESTADO")
    @Column(name = "ID_ESTADO")
    private Long idEstado;

    @ApiModelProperty(value = "Nome da Estado")
    @Column(name = "NM_ESTADO", nullable = false)
    private String nomeEstado;

    @JsonIgnore
    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL, orphanRemoval = true)
    @ApiModelProperty(hidden = true)
    private Collection<Cidade> cidades = Collections.emptyList();

    @Builder
    public Estado(Long idEstado, String nomeEstado) {
        this.idEstado = idEstado;
        this.nomeEstado = nomeEstado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estado estado = (Estado) o;
        return Objects.equals(idEstado, estado.idEstado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEstado);
    }
}
