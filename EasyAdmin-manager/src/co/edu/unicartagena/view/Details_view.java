
package co.edu.unicartagena.view;

import co.com.amecodetech.infoclient.Client;
import co.edu.unicartagena.controller.Filter_Controller;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author Alan M.E
 */

public class Details_view extends javax.swing.JFrame {

    private Filter_Controller filterController;
    
    public Details_view() {
        setUndecorated(true);
        setAlwaysOnTop(true);
        setResizable(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("Easy AdminPro");
        setLocationRelativeTo(null);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/co/edu/unicartagena/view/icon/favicon.png"));
        setIconImage(icon);
        
        initComponents();
    }

    public Details_view datos(Client client, String user) {
        txtUsuario.setText(user);
        
        txtDatos.append(client.getUserName()+"\n");
        txtDatos.append(client.getOperativeSystem()+"\n");
        txtDatos.append(client.getFeaturesSystem()+"\n");
        
        txtDatos.append("========CPU=======\n");
        txtDatos.append(client.getCpu().getModel()+"\n");
        txtDatos.append(client.getCpu().getVendor()+"\n");
        txtDatos.append(client.getCpu().getmHZ()+"\n");
        txtDatos.append(client.getCpu().getCore()+"\n");
        txtDatos.append(client.getCpu().getCache()+"\n");
        
        txtDatos.append("========RAM=======\n");
        txtDatos.append(client.getRam().getTotalMemory()+"\n");
        txtDatos.append(client.getRam().getSWAP()+"\n");
        
        txtDatos.append("========RED=======\n");
        txtDatos.append(client.getNetwork().getIp()+"\n");
        txtDatos.append(client.getNetwork().getMask()+"\n");
        txtDatos.append(client.getNetwork().getMac()+"\n");
        txtDatos.append(client.getNetwork().getDescription()+"\n");
        
        return this;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUsuario = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDatos = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/unicartagena/view/image/user.png"))); // NOI18N
        txtUsuario.setText("Usuario");

        txtDatos.setEditable(false);
        txtDatos.setColumns(20);
        txtDatos.setRows(5);
        jScrollPane1.setViewportView(txtDatos);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/unicartagena/view/icon/favicon.png"))); // NOI18N

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(btnCerrar)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCerrar)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtDatos;
    private javax.swing.JLabel txtUsuario;
    // End of variables declaration//GEN-END:variables
}
