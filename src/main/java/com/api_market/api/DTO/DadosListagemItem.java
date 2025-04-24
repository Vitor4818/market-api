package com.api_market.api.DTO;

import com.api_market.api.Model.Item;
import com.api_market.api.Model.Raridade;
import com.api_market.api.Model.Tipo;

public record DadosListagemItem(String nome, Tipo tipo, Raridade raridade, double preco, int donoId, Long id) {
    public DadosListagemItem(Item item){
       this(
               item.getNome(),
               item.getTipo(),
               item.getRaridade(),
               item.getPreco(),
               item.getDonoId(),
               item.getId());
    }
}
