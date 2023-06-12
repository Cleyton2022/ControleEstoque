/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ec.telas;
import br.com.ec.dao.ModuloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
/**
 *
 * @author 55127512021.1
 */
public class TelaFornecedor extends javax.swing.JInternalFrame {
Connection conexao =null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    /**
     * Creates new form TelaFornecedor
     */
    public TelaFornecedor() {
        initComponents();
        conexao = ModuloConexao.conector();
    }
 private void consultarFornecedor(){
         String sql = "Select * from tblfornecedor where Idfornecedor=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1,idfornecedor.getText());
            rs = pst.executeQuery();
            if (rs.next()){
               nomefornecedor.setText(rs.getString(2));
               cnpjfornecedor.setText(rs.getString(3));
               empresafornecedor.setText(rs.getString(4));
              celularfornecedor.setText(rs.getString(5));
              marcafornecedor.setText(rs.getString(6));
                produtofornecedor.setText(rs.getString(7));
                
               
               
               
               
               
               
               
            } else {
                JOptionPane.showMessageDialog(null,"Fornecedor não localizado");
                
               
            
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);        }
        
        
    }
 
   
    public void validaCampo(){
    
   
    if ((idfornecedor.getText().isEmpty()) ||nomefornecedor.getText().isEmpty() || cnpjfornecedor.getText().isEmpty() || celularfornecedor.getText().isEmpty() ||marcafornecedor.getText().isEmpty()|| produtofornecedor.getText().isEmpty()){
    JOptionPane.showMessageDialog(null,"Preencha todos os campos!");
}
}
    
    
    private void adicionar(){
      String sql = "insert into tblfornecedor (idfornecedor,nomefornecedor,cnpj,empresa,celular,marca,produto) values (?,?,?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1,idfornecedor.getText());
            pst.setString(2,nomefornecedor.getText());
            pst.setString(3,cnpjfornecedor.getText());
                pst.setString(4,empresafornecedor.getText());
             pst.setString(5,celularfornecedor.getText());
                pst.setString(6,marcafornecedor.getText());
                pst.setString(7,produtofornecedor.getText());
            
           
         
          
           
            validaCampo();
            //Iserir os dados na tabela com
            int adicionado = pst.executeUpdate();
            if (adicionado>0) {
                JOptionPane.showMessageDialog(null,"Cadastrado");
                limpaForm();
            } else {
                JOptionPane.showMessageDialog(null,"errado");
            }
        } catch (Exception e) {
        }
    
    
    
    }
    
    private void alterar(){
        
        String sql = "update  tblfornecedor set nomefornecedor=?, cnpj=?,empresa=?,celular=?,marca=?,produto=?, where idfornecedor=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, idfornecedor.getText());
            pst.setString(2, nomefornecedor.getText());
            pst.setString(3, cnpjfornecedor.getText());
            pst.setString(4, empresafornecedor.getText());
             pst.setString(5, celularfornecedor.getText());
            pst.setString(6, marcafornecedor.getText());
              pst.setString(7, produtofornecedor.getText());
           
       
              
              int alterado = pst.executeUpdate();
              if (alterado>0){
                  JOptionPane.showMessageDialog(null,"Alterado com suscesso");
                  limpaForm();
              } else {
                  JOptionPane.showMessageDialog(null,"Alteração não realizada");
                  limpaForm();
              }
            
        } catch (Exception e) {
        
        }
        
        
    }
    
    public void remover(){
        int confirma = JOptionPane.showConfirmDialog(null,"Tem certeza? ","Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma==JOptionPane.YES_OPTION){
            String sql = "delete from tblfornecedor where idfornecedor=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1,idfornecedor.getText());
                pst.executeUpdate();
                limpaForm();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        
    }
    
    public void limpaForm(){
        nomefornecedor.setText(null);
        cnpjfornecedor.setText(null);
        celularfornecedor.setText(null);
        marcafornecedor.setText(null);
        empresafornecedor.setText(null);
        
        
        produtofornecedor.setText(null);
        
        idfornecedor.requestFocus();
               
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
        idfornecedor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nomefornecedor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cnpjfornecedor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        celularfornecedor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        empresafornecedor = new javax.swing.JTextField();
        btnForCreate = new javax.swing.JButton();
        btnForRead = new javax.swing.JButton();
        btnForDelete = new javax.swing.JButton();
        btnForEdit = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        marcafornecedor = new javax.swing.JTextField();
        produtofornecedor = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Fornecedor");

        jLabel1.setText("ID:");

        jLabel2.setText("Nome:");

        jLabel3.setText("Cnpj:");

        jLabel4.setText("Celular:");

        jLabel5.setText("Empresa:");

        btnForCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ec/icones/adduser.png"))); // NOI18N
        btnForCreate.setPreferredSize(new java.awt.Dimension(90, 75));
        btnForCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnForCreateActionPerformed(evt);
            }
        });

        btnForRead.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ec/icones/searchuser.png"))); // NOI18N
        btnForRead.setPreferredSize(new java.awt.Dimension(90, 70));
        btnForRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnForReadActionPerformed(evt);
            }
        });

        btnForDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ec/icones/deluser.png"))); // NOI18N
        btnForDelete.setPreferredSize(new java.awt.Dimension(90, 70));
        btnForDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnForDeleteActionPerformed(evt);
            }
        });

        btnForEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ec/icones/edituser.png"))); // NOI18N

        jLabel6.setText("Marca:");

        jLabel7.setText("Produto:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btnForRead, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnForCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnForDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(idfornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(nomefornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel6))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cnpjfornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                    .addComponent(empresafornecedor)
                                    .addComponent(celularfornecedor))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnForEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(produtofornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                    .addComponent(marcafornecedor))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(idfornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nomefornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(marcafornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cnpjfornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(produtofornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(empresafornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(celularfornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnForEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnForDelete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnForCreate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnForRead, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnForReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnForReadActionPerformed

consultarFornecedor();

        // TODO add your handling code here:
    }//GEN-LAST:event_btnForReadActionPerformed

    private void btnForCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnForCreateActionPerformed
adicionar();        // TODO add your handling code here:
    }//GEN-LAST:event_btnForCreateActionPerformed

    private void btnForDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnForDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnForDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnForCreate;
    private javax.swing.JButton btnForDelete;
    private javax.swing.JButton btnForEdit;
    private javax.swing.JButton btnForRead;
    private javax.swing.JTextField celularfornecedor;
    private javax.swing.JTextField cnpjfornecedor;
    private javax.swing.JTextField empresafornecedor;
    private javax.swing.JTextField idfornecedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField marcafornecedor;
    private javax.swing.JTextField nomefornecedor;
    private javax.swing.JTextField produtofornecedor;
    // End of variables declaration//GEN-END:variables
}
