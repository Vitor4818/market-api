package com.api_market.api.Model;

import com.api_market.api.DTO.DadosCadstroItem;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

@Table(name ="itens")
@Entity(name = "item")
@EqualsAndHashCode(of = "id")
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Tipo tipo;
    private Raridade raridade;
    private double preco;
    private int donoId;

    public Item(DadosCadstroItem dados) {
    this.nome = dados.nome();
    this.preco = dados.preco();
    this.tipo = dados.tipo();
    this.raridade = dados.raridade();
    this.donoId = dados.donoId();
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Raridade getRaridade() {
        return raridade;
    }

    public void setRaridade(Raridade raridade) {
        this.raridade = raridade;
    }

    public int getDonoId() {
        return donoId;
    }

    public void setDonoId(int donoId) {
        this.donoId = donoId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}
