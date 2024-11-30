/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividadelp3.view.model;

import com.mycompany.atividadelp3.bean.Filme;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Aluno
 */
public class FilmeTableModel extends AbstractTableModel {

    private List<Filme> dados = new LinkedList<Filme>();
    private String[] colunas = {"ID", "Estilo", "Nome", "Ano", "Duração", "Sinopse"};

    public Filme get(int linha) {
        return dados.get(linha);
    }

    public void add(Filme f) {
        this.dados.add(f);
        this.fireTableDataChanged();
    }

    public void addList(List<Filme> filmes) {
        this.dados = filmes;
        this.fireTableDataChanged();
    }

    public void remove(Filme f) {
        this.dados.remove(f);
        this.fireTableDataChanged();
    }

    @Override
    public String getColumnName(int coluna) {
        return colunas[coluna];
    }

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Filme filme = dados.get(linha);

        switch (coluna) {
            case 0:
                return filme.getId();
            case 1:
                return filme.getEstilo().getNome();
            case 2:
                return filme.getNome();
            case 3:
                return filme.getAno();
            case 4:
                return filme.getDuracao();
            case 5:
                return filme.getSinopse();
            default:
                return null;
        }
    }
}
