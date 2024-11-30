/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividadelp3.view.model;

import com.mycompany.atividadelp3.bean.Estilo;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Aluno
 */
public class EstiloComboModel extends DefaultComboBoxModel<Estilo> {

    public EstiloComboModel(Vector<Estilo> items) {
        super(items);
    }

    public EstiloComboModel() {
    }

    public void setSelectedItem(Estilo estilo) {

        int numElemCB = getSize();
        for (int i = 0; i < numElemCB; i++) {
            Estilo estiloCB = getElementAt(i);
            if (estiloCB.getId() == estilo.getId()) {
                super.setSelectedItem(estiloCB);
            }
        }
    }

    @Override
    public Estilo getSelectedItem() {
        return (Estilo) super.getSelectedItem();
    }
}
