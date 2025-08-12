package br.com.javapet.api.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;
    private String nome;
    private String raca;
    private int idade;
    private String cor;
    private float peso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "abrigo_id")
    private Abrigo abrigo;

    public Pet(){
    }

    public Pet(String tipo, String nome, String raca, int idade, String cor, float peso, Abrigo abrigo){
        this.tipo = tipo;
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
        this.cor = cor;
        this.peso = peso;
        this.abrigo = abrigo;
    }

    public Long getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }

    public String getRaca() {
        return raca;
    }

    public int getIdade() {
        return idade;
    }

    public String getCor() {
        return cor;
    }

    public float getPeso() {
        return peso;
    }

    public Abrigo getAbrigo() {
        return abrigo;
    }
}
