package com.sistemaGestao.docnix.pessoa.dto;

import com.sistemaGestao.docnix._shared.core._utils.Util;
import com.sistemaGestao.docnix.pessoa.entidade.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.sistemaGestao.docnix._shared.core._utils.Util.isDiferenteDeNullEDeVazio;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDTO {

    private Long id;
    private String nome;
    private Long posicao;

    public Pessoa toDomain() {
        return new Pessoa(id, nome, posicao);
    }

    public List<Pessoa> toDomain(List<PessoaDTO> pessoasDTO) {
        return isDiferenteDeNullEDeVazio(pessoasDTO) ? pessoasDTO.stream().map(PessoaDTO::toDomain).collect(Collectors.toList()) : new ArrayList<>();
    }

    public static PessoaDTO from(Pessoa pessoa){
        if (pessoa == null) return null;

        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setId(pessoa.getId());
        pessoaDTO.setNome(pessoaDTO.getNome());
        pessoaDTO.setPosicao(pessoa.getPosicao());

        return pessoaDTO;
    }

    public static List<PessoaDTO> from(List<Pessoa> pessoasDominio) {
        return isDiferenteDeNullEDeVazio(pessoasDominio) ? pessoasDominio.stream().map(PessoaDTO::from).collect(Collectors.toList()) : new ArrayList<>();
    }

}
