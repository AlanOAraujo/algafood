package com.algaworks.algafood.domain.model;

import java.io.Serializable;
import java.util.Objects;

public class Permissao implements Serializable {

    private Long idPermissao;

    private String nomePermissao;

    private String descricaoPermissao;


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
