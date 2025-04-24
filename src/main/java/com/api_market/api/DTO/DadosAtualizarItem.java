package com.api_market.api.DTO;

import com.api_market.api.Model.Raridade;
import com.api_market.api.Model.Tipo;

public record DadosAtualizarItem(
        Long id,
        String nome,
        Tipo tipo,
        Raridade raridade,
        Double preco,
        Integer donoId  ) {
}
