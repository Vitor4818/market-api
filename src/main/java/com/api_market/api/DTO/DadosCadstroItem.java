package com.api_market.api.DTO;

import com.api_market.api.Model.Raridade;
import com.api_market.api.Model.Tipo;

public record DadosCadstroItem(String nome, Tipo tipo, Raridade raridade, double preco, int donoId) {
}
