package com.algaworks.algafood.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@Entity
@Getter
@Table(name = "TAB_REST_FORM_PAG")
@ApiModel(value = "RestauranteFormaPagamento",
        description = "Representacao em classe da tabela Restaurante Forma de Pagamento")
public class RestauranteFormaPagamento implements Serializable {

    @Id
    @SequenceGenerator(sequenceName = "SEQ_TAB_REST_FORM_PAG", name = "SEQ_TAB_REST_FORM_PAG", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TAB_REST_FORM_PAG")
    @Column(name = "ID_REST_FORM_PAG")
    @ApiModelProperty(value = "Registro de identificação da classe", hidden = true)
    private Long idRestFormPag;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ID_RESTAURANTE", nullable = false, referencedColumnName = "ID_RESTAURANTE")
    @ApiModelProperty(value = "Relacionamento referente a restaurante", hidden = true)
    private Restaurante restaurante;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ID_FORMAPAGAMENTO", nullable = false, referencedColumnName = "ID_FORMAPAGAMENTO")
    @ApiModelProperty(value = "Relacionamento referente a forma de pagamento", hidden = true)
    private FormaPagamento formaPagamento;

    @Builder
    public RestauranteFormaPagamento(Long idRestFormPag, Restaurante restaurante, FormaPagamento formaPagamento){
        this.idRestFormPag = idRestFormPag;
        this.formaPagamento = formaPagamento;
        this.restaurante = restaurante;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RestauranteFormaPagamento that = (RestauranteFormaPagamento) o;
        return Objects.equals(idRestFormPag, that.idRestFormPag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRestFormPag);
    }
}
