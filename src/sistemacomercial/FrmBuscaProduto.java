/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacomercial;

import Classe.Produto;
import DAO.ProdutoDAO;
import classesBase.MyTableModel;
import classesBase.NumberRenderer;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author hugo
 */
public class FrmBuscaProduto extends javax.swing.JFrame {
    private ProdutoDAO dao = new ProdutoDAO("scv","root");
    private List <Produto> produtos;
    FrmVendas frmVendas;
    int numPedido;
    /**
     * Creates new form FrmBuscaProduto
     */
    public FrmBuscaProduto(FrmVendas frmVendas,int numPedido) {
        initComponents();
        lerDadosTabela();
        this.frmVendas = frmVendas;
        this.numPedido = numPedido;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNomeDoProduto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaProduto = new javax.swing.JTable();
        btnConfirmar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtNomeDoProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeDoProdutoKeyReleased(evt);
            }
        });

        tabelaProduto.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelaProduto);

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnCancelar.setText("cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(txtNomeDoProduto)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 277, Short.MAX_VALUE)
                        .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNomeDoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmar)
                    .addComponent(btnCancelar))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        if(this.tabelaProduto.getSelectedRow() == -1)
           JOptionPane.showMessageDialog(null,"Você deve selecionar um Produto a ser apagado");
        else{
          Produto p = this.produtos.get(this.tabelaProduto.getSelectedRow());  
          FrmVendasProduto frm = new FrmVendasProduto(p,frmVendas,this.numPedido);
          frm.setVisible(true);
          this.setVisible(false);
          
         
        }
        


    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void txtNomeDoProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeDoProdutoKeyReleased
      try {
            produtos = dao.pegaTodosProdutosPorNome(this.txtNomeDoProduto.getText().trim());
            MyTableModel tab = new MyTableModel(Produto.class,produtos,tabelaProduto);
            tabelaProduto.setModel(tab);
            
        } catch (SQLException ex) {
            System.out.println("Erro ao carregar o produto "+ex.getMessage());
        }
        
        
        
        
    }//GEN-LAST:event_txtNomeDoProdutoKeyReleased

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaProduto;
    private javax.swing.JTextField txtNomeDoProduto;
    // End of variables declaration//GEN-END:variables

private void lerDadosTabela() {
        try {
            produtos = dao.buscarTodosProdutos();
            MyTableModel tab = new MyTableModel(Produto.class,produtos,tabelaProduto);
            
            tabelaProduto.setModel(tab);
            tabelaProduto.removeColumn(tabelaProduto.getColumnModel().getColumn(3));
            int tam = tabelaProduto.getSize().width;
            tabelaProduto.getColumnModel().getColumn(0).setPreferredWidth((int) Math.floor(0.1*tam));
            tabelaProduto.getColumnModel().getColumn(1).setPreferredWidth((int) Math.floor(0.55*tam));
            tabelaProduto.getColumnModel().getColumn(2).setPreferredWidth((int) Math.floor(0.1*tam));
            tabelaProduto.getColumnModel().getColumn(3).setPreferredWidth((int) Math.floor(0.25*tam));
            //Colocar dado no formato Moeda
            tabelaProduto.getColumnModel().getColumn(2).setCellRenderer(NumberRenderer.getCurrencyRenderer());
            
            tabelaProduto.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
           
           
            
        } catch (SQLException ex) {
            System.out.println("Erro "+ex.getMessage());
        }
    }





}
