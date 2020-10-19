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
@Table(name = "TAB_FORMAPAGAMENTO")
@ApiModel(value = "FormaPagamento", description = "Representacao em classe da tabela Forma de Pagamento")
public class FormaPagamento implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @ApiModelProperty(value = "Registro de identificação da classe", hidden = true)
    @SequenceGenerator(sequenceName = "SEQ_TAB_FORMAPAGAMENTO", name = "SEQ_TAB_FORMAPAGAMENTO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TAB_FORMAPAGAMENTO")
    @Column(name = "ID_FORMAPAGAMENTO")
    private Long idFormaPagamento;

    @ApiModelProperty(value = "Descrição Forma de Pagamento")
    @Column(name = "DS_FORMAPAGAMENTO", nullable = false)
    private String descricao;

    @JsonIgnore
    @OneToMany(mappedBy = "restauranteFormapagamento", cascade = CascadeType.ALL, orphanRemoval = true)
    @ApiModelProperty(hidden = true)
    private Collection<RestauranteFormaPagamento> restaurantes = Collections.emptyList();

    @Builder
    public FormaPagamento(Long idFormaPagamento, String descricao, Collection<RestauranteFormaPagamento> restaurantes) {
        this.idFormaPagamento = idFormaPagamento;
        this.descricao = descricao;
        this.restaurantes = restaurantes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FormaPagamento that = (FormaPagamento) o;
        return Objects.equals(idFormaPagamento, that.idFormaPagamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFormaPagamento);
    }
}
