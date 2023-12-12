package com.sistemaGestao.docnix._shared.core.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class RegraNegocioException extends RuntimeException {

    private List<Mensagem> mensagens = new ArrayList<>();

    public RegraNegocioException(String mensagem, Object... args) {
        this.mensagens.add(new Mensagem(mensagem, args));
    }

    public RegraNegocioException(String mensagem) {
        this.mensagens.add(new Mensagem(mensagem));
    }

    public RegraNegocioException(String mensagem, Exception ex) {
        super(ex);
        this.mensagens.add(new Mensagem(mensagem));
    }

}
