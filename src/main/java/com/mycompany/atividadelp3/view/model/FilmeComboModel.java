/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividadelp3.view.model;

import com.mycompany.atividadelp3.bean.Filme;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Aluno
 */
public class FilmeComboModel extends DefaultComboBoxModel<Filme> {

    public FilmeComboModel(Vector<Filme> items) {
        super(items);
    }

    public FilmeComboModel() {
    }

    public void setSelectedItem(Filme estilo) {

        int numElemCB = getSize();
        for (int i = 0; i < numElemCB; i++) {
            Filme filmeCB = getElementAt(i);
            if (filmeCB.getId() == estilo.getId()) {
                super.setSelectedItem(filmeCB);
            }
        }
    }

    @Override
    public Filme getSelectedItem() {
        return (Filme) super.getSelectedItem();
    }
}
