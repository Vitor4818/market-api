package com.api_market.api.DTO;

import com.api_market.api.Model.Classe;
import jakarta.validation.constraints.*;

public record DadosCadastroPersonagem(
        @NotBlank(message = "Campo Obrigatório!")
        String nome,
        @NotNull (message = "Campo obrigatório")
        Classe classe,
        @NotNull
        @Min(value = 1, message = "O nível mínimo é 1")
        @Max(value = 99, message = "O nível máximo é 99")
        int nivel,
        @NotNull(message = "Moedas são obrigatórias")
        @PositiveOrZero(message = "Moedas devem ser zero ou um valor positivo")
        double moedas) {

}
