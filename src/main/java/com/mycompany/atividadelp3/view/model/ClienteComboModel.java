/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividadelp3.view.model;

import com.mycompany.atividadelp3.bean.Cliente;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Bruno
 */
public class ClienteComboModel extends DefaultComboBoxModel<Cliente> {

    public ClienteComboModel(Vector<Cliente> items) {
        super(items);
    }

    public ClienteComboModel() {
    }

    public void setSelectedItem(Cliente cliente) {

        int numElemCB = getSize();
        for (int i = 0; i < numElemCB; i++) {
            Cliente clienteCB = getElementAt(i);
            if (clienteCB.getId() == cliente.getId()) {
                super.setSelectedItem(clienteCB);
            }
        }
    }

    @Override
    public Cliente getSelectedItem() {
        return (Cliente) super.getSelectedItem();
    }
}
