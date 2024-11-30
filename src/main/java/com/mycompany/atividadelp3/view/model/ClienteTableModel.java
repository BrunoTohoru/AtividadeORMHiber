/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividadelp3.view.model;

import com.mycompany.atividadelp3.bean.Cliente;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Aluno
 */
public class ClienteTableModel extends AbstractTableModel {

    private List<Cliente> dados = new LinkedList<Cliente>();
    private String[] colunas = {"ID", "Nome", "Endereço", "Telefone"};

    public Cliente get(int linha) {
        return dados.get(linha);
    }

    public void add(Cliente c) {
        this.dados.add(c);
        this.fireTableDataChanged();
    }

    public void addList(List<Cliente> clientes) {
        this.dados = clientes;
        this.fireTableDataChanged();
    }

    public void remove(Cliente c) {
        this.dados.remove(c);
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
        Cliente cliente = dados.get(linha);

        switch (coluna) {
            case 0:
                return cliente.getId();
            case 1:
                return cliente.getNome();
            case 2:
                return cliente.getEndereco();
            case 3:
                return cliente.getTelefone();
            default:
                return null;
        }
    }
}
