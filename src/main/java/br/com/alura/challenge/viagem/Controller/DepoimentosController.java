package br.com.alura.challenge.viagem.Controller;


import br.com.alura.challenge.viagem.model.dto.*;
import br.com.alura.challenge.viagem.model.entities.Depoimento;
import br.com.alura.challenge.viagem.model.repository.DepoimentosRepository;
import br.com.alura.challenge.viagem.model.infra.services.ServiceRandom;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("depoimentos")
public class DepoimentosController {

    @Autowired
    private ServiceRandom service;
    @Autowired
    private DepoimentosRepository repository;

    @PostMapping
    public ResponseEntity cadastrarDepoimento(@RequestBody @Valid DadosCadastroDepoimento dados) {
        var depoimento = new Depoimento(dados);
        repository.save(depoimento);
        return ResponseEntity.ok().body(new DadosListagemDepoimentos(depoimento));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosListagemDepoimentos> listarDepoimentosPorId(@PathVariable Long id) throws Exception {

        var depoimento = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosListagemDepoimentos(depoimento));
    }

    @PutMapping
    public ResponseEntity atualizarDepoimentos(@RequestBody @Valid DadosAtualizacaoDepoimento dados) {
        try {
            var depoimento = repository.getReferenceById(dados.id());
            depoimento.atualizarinformacoes(dados);
            return ResponseEntity.ok("Atualização realizada com sucesso");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.ok("Erro ao realizar a atualização");
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deletarDepoimentoPorId(@PathVariable Long id) {
        try {
            var depoimentos = repository.getReferenceById(id);
            repository.delete(depoimentos);
            return ResponseEntity.ok("Exclusão realizada com sucesso");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.ok("Erro ao realizar a exclusão");
        }

    }
    @GetMapping("/depoimentos-home")
    public ResponseEntity listRandomDepoimentos(@PageableDefault(size = 10, sort = {"personName"}) Pageable paginacao) {
        List<DadosListagemDepoimentos> depoimentoList = service.listRandomDepoimentos(paginacao);
        return ResponseEntity.ok(depoimentoList);
    }
}

