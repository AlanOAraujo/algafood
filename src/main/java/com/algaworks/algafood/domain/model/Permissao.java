package com.algaworks.algafood.domain.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "TAB_PERMISSAO")
@ApiModel(value = "Permissao", description = "Representacao em classe da tabela permissao")
public class Permissao implements Serializable {

    private static final long serialVersionUID = 3742399410210294453L;

    @Id
    @EqualsAndHashCode.Include
    @ApiModelProperty(value = "Registro de identificação da classe", hidden = true)
    @SequenceGenerator(sequenceName = "SEQ_TAB_PERMISSAO", name = "SEQ_TAB_PERMISSAO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TAB_PERMISSAO")
    @Column(name = "ID_PERMISSAO")
    private Long idPermissao;

    @ApiModelProperty(value = "Nome da Permissao")
    @Column(name = "NM_PERMISSAO", nullable = false)
    private String nomePermissao;

    @ApiModelProperty(value = "Descicao da Permissao")
    @Column(name = "DS_PERMISSAO", nullable = false)
    private String descricaoPermissao;

    @Builder
    public Permissao(Long idPermissao, String nomePermissao, String descricaoPermissao) {
        this.idPermissao = idPermissao;
        this.nomePermissao = nomePermissao;
        this.descricaoPermissao = descricaoPermissao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Permissao permissao = (Permissao) o;
        return Objects.equals(idPermissao, permissao.idPermissao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPermissao);
    }
}
