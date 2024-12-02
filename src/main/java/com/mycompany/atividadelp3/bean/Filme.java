package com.mycompany.atividadelp3.bean;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.InputStream;
import java.sql.Blob;

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

    @Lob
    private Blob foto;

    @Basic
    private int tamanhoFoto;

    @Basic
    private String sinopse;

    @ManyToOne(cascade = CascadeType.ALL)
    private Estilo estilo;

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

    public InputStream getFoto() {
        /*
        gerar aqui o código que puxa o Blob(byte[]) e trasnformar em InputStream
         */
        try {
            InputStream is = foto.getBinaryStream();
            return is; //aqui deve retornar um InputStream
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null; //aqui deve retornar um InputStream
    }

    public void setFoto(InputStream foto) {
        /*
        gerar aqui o código que salvará no atributo de InputStream em Blob(byte[])
         */
        this.foto = foto; //aqui deve salvar no atributo um Blob(byte[])
    }

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

    public int getTamanhoFoto() {
        return tamanhoFoto;
    }

    public void setTamanhoFoto(int tamanhoFoto) {
        this.tamanhoFoto = tamanhoFoto;
    }

    @Override
    public String toString() {
        return nome.toUpperCase();
    }

}
