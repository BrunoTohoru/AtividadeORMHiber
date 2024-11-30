/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividadelp3.view.model;

import com.mycompany.atividadelp3.bean.Locacao;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Aluno
 */
public class LocacaoTableModel extends AbstractTableModel{
    private List<Locacao> dados = new LinkedList<Locacao>();
    private String[] colunas = {"ID", "Filme", "Cliente", "Emissão", "Devolução", "Valor"};
    
    public Locacao get(int linha){
        return dados.get(linha);
    }
    
    public void add(Locacao l){
        this.dados.add(l);
        this.fireTableDataChanged();
    }
    
    public void addList(List<Locacao> locacoes) {
        this.dados = locacoes;
        this.fireTableDataChanged();
    }
    
    public void remove(Locacao l){
        this.dados.remove(l);
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
        Locacao locacao = dados.get(linha);
        
        switch (coluna) {
            case 0:
                return locacao.getId();
            case 1:
                return locacao.getFilme().getNome();
            case 2:
                return locacao.getCliente().getNome();
            case 3:
                return locacao.getEmissao();
            case 4:
                return locacao.getDevolucao();
            case 5:
                return locacao.getValor();
            default:
                return null;
        }
    }
}
