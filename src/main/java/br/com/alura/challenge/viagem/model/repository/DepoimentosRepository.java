package br.com.alura.challenge.viagem.model.repository;

import br.com.alura.challenge.viagem.model.entities.Depoimento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface DepoimentosRepository extends JpaRepository<Depoimento, Long> {

    Page<Depoimento> findByAtivoTrue(Pageable paginacao);
    @Query(value = "SELECT * FROM depoimentos WHERE ativo = true ORDER BY RAND() LIMIT 3", nativeQuery = true)
    List<Depoimento> findRandomDepoimentos();
}
