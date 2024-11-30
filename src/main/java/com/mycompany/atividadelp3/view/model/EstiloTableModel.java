/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividadelp3.view.model;

import com.mycompany.atividadelp3.bean.Estilo;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Aluno
 */
public class EstiloTableModel extends AbstractTableModel {

    private List<Estilo> dados = new LinkedList<Estilo>();
    private String[] colunas = {"ID", "Nome"};

    public Estilo get(int linha) {
        return dados.get(linha);
    }

    public void add(Estilo e) {
        this.dados.add(e);
        this.fireTableDataChanged();
    }

    public void addList(List<Estilo> estilos) {
        this.dados = estilos;
        this.fireTableDataChanged();
    }

    public void remove(Estilo e) {
        this.dados.remove(e);
        this.fireTableDataChanged();
    }

    @Override
    public String getColumnName(int coluna) {
        return this.colunas[coluna];
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
        Estilo estilo = dados.get(linha);
        switch (coluna) {
            case 0:
                return estilo.getId();
            case 1:
                return estilo.getNome();
            default:
                return null;
        }
    }

}
