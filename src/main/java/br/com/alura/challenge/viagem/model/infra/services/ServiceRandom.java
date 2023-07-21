package br.com.alura.challenge.viagem.model.infra.services;

import br.com.alura.challenge.viagem.model.dto.DadosListagemDepoimentos;
import br.com.alura.challenge.viagem.model.entities.Depoimento;
import br.com.alura.challenge.viagem.model.repository.DepoimentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ServiceRandom {

    @Autowired
    private DepoimentosRepository depoimentosRepository;



    public List<DadosListagemDepoimentos> listRandomDepoimentos(Pageable paginacao) {
        List<Depoimento> depoimentos = depoimentosRepository.findRandomDepoimentos();
        return depoimentos.stream()
                .map(DadosListagemDepoimentos::new)
                .collect(Collectors.toList());
    }
}

