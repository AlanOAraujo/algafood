package com.algaworks.algafood.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "TAB_RESTAURANTE")
@ApiModel(value = "Restaurante", description = "Representacao em classe da tabela Restaurante")
public class Restaurante implements Serializable {

    private static final long serialVersionUID = -3173617935748141842L;

    @Id
    @SequenceGenerator(sequenceName = "SEQ_TAB_RESTAURANTE", name = "SEQ_TAB_RESTAURANTE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TAB_RESTAURANTE")
    @Column(name = "ID_RESTAURANTE")
    @ApiModelProperty(value = "Registro de identificação da classe", hidden = true)
    private Long idRestaurante;

    @Column(name = "NM_RESTAURANTE", nullable = false)
    @ApiModelProperty(value = "Nome do Restaurante")
    private String nmRestaurante;

    @Column(name = "TAXA_FRETE", nullable = false)
    @ApiModelProperty(value = "Taxa do Frete cobrada pelo restaurante")
    private BigDecimal taxaFrete;

    @ManyToOne
    @JoinColumn( name = "ID_COZINHA", nullable = false, referencedColumnName = "ID_COZINHA")
    @ApiModelProperty(value = "Relacionamente referente a tabela cozinha")
    private Cozinha cozinha;

    @JsonIgnore
    @OneToMany(mappedBy = "restaurante", cascade = CascadeType.ALL, orphanRemoval = true)
    @ApiModelProperty(hidden = true)
    private Collection<RestauranteFormaPagamento> pagamentos = Collections.emptyList();

    @Builder
    public Restaurante(Long idRestaurante, String nmRestaurante, BigDecimal taxaFrete) {
        this.idRestaurante = idRestaurante;
        this.nmRestaurante = nmRestaurante;
        this.taxaFrete = taxaFrete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Restaurante that = (Restaurante) o;
        return Objects.equals(idRestaurante, that.idRestaurante);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRestaurante);
    }
}

