package com.sistemaGestao.docnix.pessoa.entidade;

import com.sistemaGestao.docnix._shared.core.exceptions.RegraNegocioException;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pessoa {

    private Long id;
    private String nome;
    private Long posicao;

    public Pessoa(Long id, String nome, Long posicao) {
        this.id = id;
        this.nome = nome;
        this.posicao = posicao;
        validar();
    }

    private void validar() {
        if (posicao < 0) throw new RegraNegocioException("Posição não pode ser menor que 0");
    }

}
