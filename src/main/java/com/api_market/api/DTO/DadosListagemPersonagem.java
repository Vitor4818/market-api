package com.api_market.api.DTO;

import com.api_market.api.Model.Classe;
import com.api_market.api.Model.Personagem;

public record DadosListagemPersonagem(Long id, String nome, Classe classe, int nivel, double moedas) {
    public DadosListagemPersonagem(Personagem personagem){
        this(personagem.getId(),
                personagem.getNome(),
                personagem.getClasse(),
                personagem.getNivel(),
        personagem.getMoedas());
    }
}
