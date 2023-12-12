package com.sistemaGestao.docnix.pessoa.aplicacao;

import com.sistemaGestao.docnix.pessoa.dto.PessoaDTO;
import com.sistemaGestao.docnix.pessoa.entidade.Pessoa;
import com.sistemaGestao.docnix.pessoa.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository repository;

    public Pessoa inserir(PessoaDTO pessoaDTO) {
        Pessoa pessoa = pessoaDTO.toDomain();
        return repository.inserir(pessoa).get();
    }

    public Pessoa editar(PessoaDTO pessoaDTO) {
        Pessoa pessoa = pessoaDTO.toDomain();
        return repository.editar(pessoa).get();
    }

    public void deletar(Long id) {
        repository.deletar(id);
    }

    public Pessoa consultar(Long id) {
        return repository.consultar(id).get();
    }

    public List<PessoaDTO> listar() {
        List<Pessoa> pessoasDominio = repository.listar();
        return PessoaDTO.from(pessoasDominio);
    }

}
