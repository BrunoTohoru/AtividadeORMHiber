package com.mycompany.atividadelp3.bean;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Basic
    private String nome;
    
    @Basic
    private String endereco;
    
    @Basic
    private String telefone;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private Set<Locacao> locacoes;

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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Set<Locacao> getLocacoes() {
        return locacoes;
    }

    public void setLocacoes(Set<Locacao> locacoes) {
        this.locacoes = locacoes;
    }

    @Override
    public String toString() {
        return nome.toUpperCase();
    }

}
