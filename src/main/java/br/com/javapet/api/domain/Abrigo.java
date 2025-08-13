package br.com.javapet.api.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "abrigos")
public class Abrigo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do abrigo é obrigatório.")
    private String nome;

    @NotBlank(message = "O telefone é obrigatório.")
    @Pattern(regexp = "\\d{10,11}", message = "O número do telefone deve conter entre 10 e 11 dígitos.")
    private String telefone;

    @NotBlank(message = "O e-mail é obrigatório.")
    @Email(message = "Formato do e-mail inválido.")
    private String email;

    @OneToMany(mappedBy = "abrigo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Pet> pets = new ArrayList<>();

    public Abrigo(){
    }

    public Abrigo(String nome, String telefone, String email){
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public List<Pet> getPets() {
        return pets;
    }
}
