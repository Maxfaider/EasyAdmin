/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicartagena.view;

import co.com.amecodetech.infoclient.Client;
import co.edu.unicartagena.controller.Filter_Controller;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author Lmarck
 */
public class Sesion_view extends javax.swing.JFrame {
    
    private Filter_Controller filterController;

    public Sesion_view() {
        //setAlwaysOnTop(true);
        setTitle("Easy AdminPro");
        setLocationRelativeTo(null);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/co/edu/unicartagena/view/icon/favicon.png"));
        setIconImage(icon);
        //setExtendedState( MAXIMIZED_BOTH );
        initComponents();
    }
    
    public JFrame setController(Filter_Controller filterController) {
        this.filterController = filterController;
        return this;
    }
    
    public void openWindow() {
        dispose();
        new Blocked_view().setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        btnVincular = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        image_load = new javax.swing.JLabel();
        txtResult = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/unicartagena/view/image/logo.png"))); // NOI18N

        jLabel2.setText("Administrador:");

        jLabel3.setText("Contraseña:");

        btnVincular.setText("Vincular");
        btnVincular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVincularActionPerformed(evt);
            }
        });

        jLabel4.setText("Easy AdminPro - v1.0");

        image_load.setBackground(new java.awt.Color(255, 51, 51));

        txtResult.setBackground(new java.awt.Color(0, 0, 0));
        txtResult.setForeground(new java.awt.Color(255, 0, 0));
        txtResult.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVincular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(image_load, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(139, 139, 139))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtResult, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(image_load, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVincular)
                .addGap(18, 18, 18)
                .addComponent(txtResult, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVincularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVincularActionPerformed
        
        Thread job = new Thread(() -> {
            btnVincular.setEnabled(false);
            String user = txtUser.getText();
            String password = String.valueOf(txtPass.getPassword());
            
            String result = filterController.loginAdmin(user, password);
            if(result.equals(user)) {
                
                Client client = new Client();
                if(filterController.RegisterClient(client).equals("success")) {
                    txtResult.setForeground(Color.green);
                    txtResult.setText("PC cliente ha sido vinculado");
                    filterController.setLinked();
                    try { 
                        Thread.sleep(1000); 
                        openWindow();
                    } catch(InterruptedException ex) {
                        Logger.getLogger(Sesion_view.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //exito
                } else {
                    txtResult.setText("ha ocurrido un problema...");
                }
            } else if(result.equals("not found")) {
                
                txtResult.setText("usuario o contraseña invalido");
            } else {
                txtResult.setText(result); 
            }
            btnVincular.setEnabled(true);
        });
        job.start();
        
        new Thread(() -> {
            ImageIcon carga = new ImageIcon(getClass().getResource("/co/edu/unicartagena/view/image/load.gif"));
            image_load.setIcon(carga);
            while(job.isAlive()) {
                try {
                    //System.out.println("Ejecutandome");
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Sesion_view.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            image_load.setIcon(null);
        }).start();
    }//GEN-LAST:event_btnVincularActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVincular;
    private javax.swing.JLabel image_load;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JLabel txtResult;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
