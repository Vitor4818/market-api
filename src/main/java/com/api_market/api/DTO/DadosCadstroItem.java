package com.api_market.api.DTO;

import com.api_market.api.Model.Raridade;
import com.api_market.api.Model.Tipo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DadosCadstroItem(
        @NotBlank(message = "Campo obrigatório!")
        String nome,
        @NotNull (message = "Campo obrigatório")
        Tipo tipo,
        @NotNull (message = "Campo obrigatório")
        Raridade raridade,
        @NotNull(message = "Campo obrigatório!")
        @Positive(message = "Preço deve ser positivo!")
        double preco,
        @NotNull(message = "Campo obrigatório!")
        int donoId) {
}
