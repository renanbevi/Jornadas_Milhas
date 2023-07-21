package br.com.alura.challenge.viagem.model.dto;

import br.com.alura.challenge.viagem.model.entities.Depoimento;

public record DadosListagemDepoimentos(
        Long id,
        String nome,
        String foto,
        String depoimento


) {
    public DadosListagemDepoimentos(Depoimento depoimento){
        this(depoimento.getId(), depoimento.getNome(), depoimento.getFoto(), depoimento.getDepoimento());
    }
}
