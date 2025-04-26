package com.api_market.api.DTO;

import com.api_market.api.Model.Raridade;
import com.api_market.api.Model.Tipo;

public record ItemFilter(String nome, Tipo tipo, Double precoMin, Double precoMax, Raridade raridade) {
}
