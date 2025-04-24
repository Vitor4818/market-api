package com.api_market.api.Model;

import com.api_market.api.DTO.DadosAtualizarPersonagem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.api_market.api.DTO.DadosCadastroPersonagem;

@Table(name = "personagens")
@Entity(name = "personagem")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Personagem {

    public Personagem() {
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Classe classe;
    private int nivel;
    private double moedas;

    public Personagem(DadosCadastroPersonagem dados) {
        this.moedas = dados.moedas();
        this.nivel = dados.nivel();
        this.classe = dados.classe();
        this.nome = dados.nome();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getMoedas() {
        return moedas;
    }

    public void setMoedas(double moedas) {
        this.moedas = moedas;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void atualizarDados(DadosAtualizarPersonagem dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.classe() != null) {
            this.classe = dados.classe();
        }
        if (dados.nivel() != 0) {
            this.nivel = dados.nivel();
        }
        if (dados.moedas() != 0.0) {
            this.moedas = dados.moedas();
        }
    }
}
