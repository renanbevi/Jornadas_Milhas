package br.com.alura.challenge.viagem.model.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroDepoimento(
        @NotBlank(message = "Nome é obrigatório")
        String nome,
        @NotBlank(message = "Foto é obrigatório")
        String foto,
        @NotBlank(message = "Depoimento é obrigatório")
        String depoimento
) {
}
