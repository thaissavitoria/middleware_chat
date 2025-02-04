/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pacote;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JOptionPane;

/**
 *
 * @author admlab
 */
public class ControlPanel extends javax.swing.JFrame {
    Registry reg;
    RmiWebInterface objRmi;
    /**
     * Creates new form ControlPanel
     */
    public ControlPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblWeb = new javax.swing.JLabel();
        lblDesktop = new javax.swing.JLabel();
        lblPublicidade = new javax.swing.JLabel();
        btnWeb = new javax.swing.JToggleButton();
        btnDesktop = new javax.swing.JToggleButton();
        btnPublicidade = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Control Panel");
        setName("frmControlPanel"); // NOI18N

        lblWeb.setText("Chat Web:");
        lblWeb.setName("lblWeb"); // NOI18N

        lblDesktop.setText("Chat Desktop:");
        lblDesktop.setName("lblDesktop"); // NOI18N

        lblPublicidade.setText("Publicidade:");
        lblPublicidade.setName("lblPublicidade"); // NOI18N

        btnWeb.setText("Ativar");
        btnWeb.setName("btnWeb"); // NOI18N
        btnWeb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWebActionPerformed(evt);
            }
        });

        btnDesktop.setText("Ativar");
        btnDesktop.setName("btnDesktop"); // NOI18N
        btnDesktop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesktopActionPerformed(evt);
            }
        });

        btnPublicidade.setText("Ativar");
        btnPublicidade.setName("btnPublicidade"); // NOI18N
        btnPublicidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPublicidadeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblWeb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnWeb, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDesktop)
                            .addComponent(lblPublicidade))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnDesktop, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPublicidade, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblWeb)
                    .addComponent(btnWeb))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDesktop)
                    .addComponent(btnDesktop))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPublicidade)
                    .addComponent(btnPublicidade))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnWebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWebActionPerformed
        if(btnWeb.isSelected()){
            try{
                this.reg=LocateRegistry.createRegistry(6666);
                objRmi = new RmiWebImpl();
                this.reg.rebind("ServidorWebChat",objRmi);
                JOptionPane.showMessageDialog(null,"Servidor iniciado");
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Erro ativando servidor Rmi:" + e.getMessage());
                e.printStackTrace();
            }
            btnWeb.setText("Desativar");
        }else{
            try{     
                this.reg.unbind("ServidorWebChat");
                
                UnicastRemoteObject.unexportObject(this.objRmi, true);
                UnicastRemoteObject.unexportObject(this.reg, true);
                JOptionPane.showMessageDialog(null,"Servidor Web parado");
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Erro parando servidor Rmi:" + e.getMessage());
                e.printStackTrace();
            }
            btnWeb.setText("Ativar");
        }
    }//GEN-LAST:event_btnWebActionPerformed

    private void btnDesktopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesktopActionPerformed
        if(btnDesktop.isSelected()){
            btnDesktop.setText("Desativar");
        }else{
            btnDesktop.setText("Ativar");
        }
    }//GEN-LAST:event_btnDesktopActionPerformed

    private void btnPublicidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPublicidadeActionPerformed
        if(btnPublicidade.isSelected()){
            btnPublicidade.setText("Desativar");
        }else{
            btnPublicidade.setText("Ativar");
        }
    }//GEN-LAST:event_btnPublicidadeActionPerformed

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
            java.util.logging.Logger.getLogger(ControlPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ControlPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ControlPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControlPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ControlPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnDesktop;
    private javax.swing.JToggleButton btnPublicidade;
    private javax.swing.JToggleButton btnWeb;
    private javax.swing.JLabel lblDesktop;
    private javax.swing.JLabel lblPublicidade;
    private javax.swing.JLabel lblWeb;
    // End of variables declaration//GEN-END:variables
}
