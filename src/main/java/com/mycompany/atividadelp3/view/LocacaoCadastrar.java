/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.atividadelp3.view;

import com.mycompany.atividadelp3.bean.Cliente;
import com.mycompany.atividadelp3.bean.Filme;
import com.mycompany.atividadelp3.bean.Locacao;
import com.mycompany.atividadelp3.dao.ClienteDao;
import com.mycompany.atividadelp3.dao.FilmeDao;
import com.mycompany.atividadelp3.dao.LocacaoDao;
import com.mycompany.atividadelp3.view.model.ClienteComboModel;
import com.mycompany.atividadelp3.view.model.FilmeComboModel;
import com.mycompany.atividadelp3.view.model.LocacaoTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Aluno
 */
public class LocacaoCadastrar extends javax.swing.JFrame {

    private LocacaoTableModel tbm;
    private FilmeComboModel cbmFilme;
    private ClienteComboModel cbmCliente;
    private Locacao locacaoSelecionado = null;

    /**
     * Creates new form LocacaoCadastrar
     */
    public LocacaoCadastrar() {
        initComponents();
        tbm = new LocacaoTableModel();
        tblLocacao.setModel(tbm);
        cbmFilme = new FilmeComboModel();
        cbFilme.setModel(cbmFilme);
        cbmCliente = new ClienteComboModel();
        cbCliente.setModel(cbmCliente);
        popula();
        tblLocacao.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int linha = tblLocacao.getSelectedRow();
                locacaoSelecionado = tbm.get(linha);
                populaForm(locacaoSelecionado);
            }

        });
    }

    private void populaForm(Locacao locacao) {
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yy");
        tfID.setText(String.valueOf(locacao.getId()));
        tfValor.setText(locacao.getValor().toString());
        cbmCliente.setSelectedItem(locacao.getCliente());
        cbmFilme.setSelectedItem(locacao.getFilme());
        ftfDevolucao.setText(formatoData.format(locacao.getDevolucao()));
        ftfEmissao.setText(formatoData.format(locacao.getEmissao()));
    }

    private void popula() {
        
        LocacaoDao dao = new LocacaoDao();
        tbm.addList(dao.getList());
        FilmeDao daoFilme = new FilmeDao();
        cbmFilme.addAll(daoFilme.getList());
        ClienteDao daoCliente = new ClienteDao();
        cbmCliente.addAll(daoCliente.getList());

    }

    private void limpaTela() {
        tfID.setText("");
        tfValor.setText("");
        ftfDevolucao.setText("");
        ftfEmissao.setText("");
        cbCliente.setSelectedItem(-1);
        cbFilme.setSelectedItem(-1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfID = new javax.swing.JTextField();
        lblFilme = new javax.swing.JLabel();
        cbFilme = new javax.swing.JComboBox<>();
        lblCliente = new javax.swing.JLabel();
        cbCliente = new javax.swing.JComboBox<>();
        btnAddFilme = new javax.swing.JButton();
        btnAddCliente = new javax.swing.JButton();
        lblEmissao = new javax.swing.JLabel();
        ftfEmissao = new javax.swing.JFormattedTextField();
        lblDevolucao = new javax.swing.JLabel();
        ftfDevolucao = new javax.swing.JFormattedTextField();
        lblValor = new javax.swing.JLabel();
        tfValor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLocacao = new javax.swing.JTable();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("ID");

        tfID.setEditable(false);

        lblFilme.setText("Filme");

        lblCliente.setText("Cliente");

        btnAddFilme.setText("...");
        btnAddFilme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFilmeActionPerformed(evt);
            }
        });

        btnAddCliente.setText("...");
        btnAddCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddClienteActionPerformed(evt);
            }
        });

        lblEmissao.setText("Emissão");

        lblDevolucao.setText("Devolução");

        lblValor.setText("Valor");

        tblLocacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblLocacao);

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfID, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblFilme)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbFilme, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddFilme))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddCliente))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblEmissao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ftfEmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDevolucao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ftfDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblValor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfValor, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFilme)
                    .addComponent(cbFilme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddFilme))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCliente)
                    .addComponent(cbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmissao)
                    .addComponent(ftfEmissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDevolucao)
                    .addComponent(ftfDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValor)
                    .addComponent(tfValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir)
                    .addComponent(btnEditar)
                    .addComponent(btnCadastrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        Locacao locacao = new Locacao();
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yy");
        Date dataDevolucao = null;
        Date dataEmissao = null;
        try {
            dataDevolucao = formatoData.parse(ftfDevolucao.getText());
            dataEmissao = formatoData.parse(ftfEmissao.getText());
        } catch (ParseException ex) {
            Logger.getLogger(LocacaoCadastrar.class.getName()).log(Level.SEVERE, null, ex);
        }
        locacao.setCliente(cbmCliente.getSelectedItem());
        locacao.setFilme(cbmFilme.getSelectedItem());
        locacao.setValor(Double.parseDouble(tfValor.getText()));
        locacao.setDevolucao(dataDevolucao);
        locacao.setEmissao(dataEmissao);

        LocacaoDao dao = new LocacaoDao();
        dao.salvar(locacao);

        tbm.add(locacao);

        limpaTela();
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (locacaoSelecionado == null) {
            JOptionPane.showMessageDialog(this, "Selecione uma locacao na tabela");
        } else {
            SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yy");
            Date dataDevolucao = null;
            Date dataEmissao = null;
            try {
                dataDevolucao = formatoData.parse(ftfDevolucao.getText());
                dataEmissao = formatoData.parse(ftfEmissao.getText());
            } catch (ParseException ex) {
                Logger.getLogger(LocacaoCadastrar.class.getName()).log(Level.SEVERE, null, ex);
            }
            locacaoSelecionado.setValor(Double.parseDouble(tfValor.getText()));
            locacaoSelecionado.setCliente(cbmCliente.getSelectedItem());
            locacaoSelecionado.setFilme(cbmFilme.getSelectedItem());
            locacaoSelecionado.setEmissao(dataEmissao);
            locacaoSelecionado.setDevolucao(dataDevolucao);

            LocacaoDao dao = new LocacaoDao();
            dao.atualizar(locacaoSelecionado);
            tbm.fireTableDataChanged();
            limpaTela();
            locacaoSelecionado = null;
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        locacaoSelecionado = tbm.get(tblLocacao.getSelectedRow());
        LocacaoDao dao = new LocacaoDao();
        dao.remover(Long.parseLong(locacaoSelecionado.getId().toString()));
        System.out.println(locacaoSelecionado);
        tbm.remove(locacaoSelecionado);
        limpaTela();
        locacaoSelecionado = null;
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAddFilmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFilmeActionPerformed
        FilmeCadastrar telaFilme = new FilmeCadastrar();
        telaFilme.setVisible(true);
    }//GEN-LAST:event_btnAddFilmeActionPerformed

    private void btnAddClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddClienteActionPerformed
        ClienteCadastrar telaCliente = new ClienteCadastrar();
        telaCliente.setVisible(true);
    }//GEN-LAST:event_btnAddClienteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LocacaoCadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LocacaoCadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LocacaoCadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LocacaoCadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LocacaoCadastrar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCliente;
    private javax.swing.JButton btnAddFilme;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JComboBox<Cliente> cbCliente;
    private javax.swing.JComboBox<Filme> cbFilme;
    private javax.swing.JFormattedTextField ftfDevolucao;
    private javax.swing.JFormattedTextField ftfEmissao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblDevolucao;
    private javax.swing.JLabel lblEmissao;
    private javax.swing.JLabel lblFilme;
    private javax.swing.JLabel lblValor;
    private javax.swing.JTable tblLocacao;
    private javax.swing.JTextField tfID;
    private javax.swing.JTextField tfValor;
    // End of variables declaration//GEN-END:variables
}
