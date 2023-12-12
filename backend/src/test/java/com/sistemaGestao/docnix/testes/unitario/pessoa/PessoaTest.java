package com.sistemaGestao.docnix.testes.unitario.pessoa;

import com.sistemaGestao.docnix._shared.core.exceptions.RegraNegocioException;
import com.sistemaGestao.docnix.pessoa.entidade.Pessoa;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PessoaTest {

    @Test
    public void deveCriarUmaPessoa() throws Exception {
        Pessoa pessoa = new Pessoa(1L, "Pessoa", 1L);
        Assert.assertEquals(pessoa.getNome(), "Pessoa");
    }

    @Test
    public void naoDevePermitirCriarUmaPessoaComPositionNegativo() {
        try {
            Pessoa pessoa = new Pessoa(1L, "Pessoa", -1L);
        } catch (RegraNegocioException e) {
            Assert.assertEquals(e.getMensagens().getFirst().getTexto(), "Posição não pode ser menor que 0");
        }
    }

}
