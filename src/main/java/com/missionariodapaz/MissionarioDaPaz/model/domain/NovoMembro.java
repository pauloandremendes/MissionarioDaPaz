package com.missionariodapaz.MissionarioDaPaz.model.domain;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "novoMembro")
public class NovoMembro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String nome;
    public String sobrenome;
    public String rua;
    public String numero;
    public String bairro;
    public String cidade;
    public String telefone;

//    @ManyToOne(cascade = CascadeType.PERSIST)
//    public Voluntario voluntario;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

//    public Voluntario getVoluntario() {
//        return voluntario;
//    }

//    public void setVoluntario(Voluntario voluntario) {
//        this.voluntario = voluntario;
//    }
}
