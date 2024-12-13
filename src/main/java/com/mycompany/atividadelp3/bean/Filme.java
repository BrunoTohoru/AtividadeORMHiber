package com.mycompany.atividadelp3.bean;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "filme")
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    private String nome;

    @Basic
    private String ano;

    @Basic
    private Integer duracao;

    /*
    @Lob
    private Blob foto;
     */
    @Basic
    private String sinopse;

    @ManyToOne
    @JoinColumn(name = "estilo_id")
    private Estilo estilo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "filme")
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

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    /*
    public Blob getFoto() {
        return foto;
    }
    
    public void setFoto(Blob foto) {
        this.foto = foto;
    }
     */
    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public Estilo getEstilo() {
        return estilo;
    }

    public void setEstilo(Estilo estilo) {
        this.estilo = estilo;
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
