package com.sistemaGestao.docnix.pessoa.controller;

import com.sistemaGestao.docnix.pessoa.aplicacao.PessoaService;
import com.sistemaGestao.docnix.pessoa.dto.PessoaDTO;
import com.sistemaGestao.docnix.pessoa.entidade.Pessoa;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pessoa")
public class PessoaController {

    private final PessoaService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long incluir(@RequestBody PessoaDTO pessoaDTO) {
        return service.inserir(pessoaDTO).getId();
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Long editar(@RequestBody PessoaDTO pessoaDTO) {
        return service.editar(pessoaDTO).getId();
    }

    @Transactional(readOnly = true)
    @GetMapping("{id}")
    public PessoaDTO consultar(@PathVariable Long id) {
        Pessoa pessoa = service.consultar(id);
        return new PessoaDTO().from(pessoa);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    @GetMapping
    public List<PessoaDTO> listar() {
        return service.listar();
    }

}
