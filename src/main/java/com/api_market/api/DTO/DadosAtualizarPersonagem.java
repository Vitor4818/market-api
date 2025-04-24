package com.api_market.api.DTO;

import com.api_market.api.Model.Classe;
import com.api_market.api.Model.Raridade;
import com.api_market.api.Model.Tipo;

public record DadosAtualizarPersonagem(
        Long id,
        String nome,
        Classe classe,
        int nivel,
        double moedas
) {
}
