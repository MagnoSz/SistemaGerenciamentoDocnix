package com.sistemaGestao.docnix.pessoa.infra.impl;

import com.sistemaGestao.docnix.pessoa.entidade.Pessoa;
import com.sistemaGestao.docnix.pessoa.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
@RequiredArgsConstructor
public class PessoaRepositoryImpl implements PessoaRepository {

    @Override
    public Optional<Pessoa> inserir(Pessoa pessoa) {
        return Optional.empty();
    }

    @Override
    public Optional<Pessoa> editar(Pessoa pessoa) {
        return Optional.empty();
    }

    @Override
    public void deletar(Long id) {

    }

    @Override
    public Optional<Pessoa> consultar(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Pessoa> listar() {
        return null;
    }

}
