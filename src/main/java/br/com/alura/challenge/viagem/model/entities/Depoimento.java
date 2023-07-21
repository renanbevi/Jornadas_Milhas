package br.com.alura.challenge.viagem.model.entities;

import br.com.alura.challenge.viagem.model.dto.DadosAtualizacaoDepoimento;
import br.com.alura.challenge.viagem.model.dto.DadosCadastroDepoimento;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="depoimentos")
@Entity(name="Depoimento")

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Depoimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String foto;

    private String depoimento;

    private Boolean ativo;


    public Depoimento(DadosCadastroDepoimento dados){
        this.nome = dados.nome();
        this.foto = dados.foto();
        this.depoimento = dados.depoimento();
        this.ativo = true;
    }

    public void atualizarinformacoes(DadosAtualizacaoDepoimento dados){

        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.foto() != null){
            this.foto = dados.foto();
        }
        if (dados.depoimento() != null){
            this.depoimento = dados.depoimento();
        }
    }

}