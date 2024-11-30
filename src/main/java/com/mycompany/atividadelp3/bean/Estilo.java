package com.mycompany.atividadelp3.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "estilo")
public class Estilo {

    private Integer id;
    private String nome;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome.toUpperCase();
    }

}
