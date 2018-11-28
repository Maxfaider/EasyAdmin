/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicartagena.view;

import co.com.amecodetech.infoclient.Client;
import co.edu.unicartagena.controller.Filter_Controller;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alan M.E
 */

public class Gestion_view extends javax.swing.JFrame {
    
    private Filter_Controller filterController;
    private List<Client> clients;

    public Gestion_view() {
        setTitle("Easy AdminPro");
        setLocationRelativeTo(null);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/co/edu/unicartagena/view/icon/favicon.png"));
        setIconImage(icon);
        
        initComponents();
    }
    
    public JFrame setController(Filter_Controller filterController) {
        this.filterController = filterController;
        txtUsuario.setText(filterController.getUser());
        setTable();
        return this;
    }
    
    private void setTable() {
        
        Thread job = new Thread(() -> {
            clients = this.filterController.sendClients();
            String aux;
        
            for(Client index: clients) {
                if(index.getState().equals("online")) {
                   aux = "Block";
            } else {
                aux = "---";
            }
            Object[] newRow={index.getState(), index.getUserName(), index.getNetwork().getIp(), 
               index.getOperativeSystem(), aux, "00:00:00", "[Ver Detalle]"};
            
            DefaultTableModel tableModel = (DefaultTableModel) tablePCs.getModel();
            tableModel.addRow(newRow);
            }
        });
        job.start();
        
        new Thread(() -> {
            ImageIcon carga = new ImageIcon(getClass().getResource("/co/edu/unicartagena/view/image/load.gif"));
            txtLogo.setIcon(carga);
            while(job.isAlive()) {
                try {
                    //System.out.println("Ejecutandome");
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Sesion_view.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            carga = new ImageIcon(getClass().getResource("/co/edu/unicartagena/view/icon/favicon.png"));
            txtLogo.setIcon(carga);
        }).start();
    }
    
    private Client find(String ip) {
        for(Client index: this.clients) {
            if(index.getNetwork().getIp().equals(ip)) {
                return index;
            }
        }
        return null;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePCs = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtLogo = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/unicartagena/view/image/user.png"))); // NOI18N

        txtUsuario.setText("Usuario");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/unicartagena/view/image/update.png"))); // NOI18N
        jButton1.setText("Actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tablePCs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "PC", "IP Address", "OS", "Estado", "Contador", "ver"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablePCs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePCsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePCs);
        if (tablePCs.getColumnModel().getColumnCount() > 0) {
            tablePCs.getColumnModel().getColumn(0).setMaxWidth(80);
            tablePCs.getColumnModel().getColumn(4).setMaxWidth(80);
            tablePCs.getColumnModel().getColumn(5).setMaxWidth(80);
            tablePCs.getColumnModel().getColumn(6).setMaxWidth(80);
        }

        jLabel3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jLabel3.setText("www.EasyAdmin.ga");

        txtLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/unicartagena/view/icon/favicon.png"))); // NOI18N
        txtLogo.setText("Easy AdminPRO");

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Apagar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Reiniciar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Cerrar Sesión");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(29, 29, 29))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUsuario)
                        .addGap(229, 229, 229)
                        .addComponent(txtLogo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtUsuario)
                        .addComponent(jButton1)
                        .addComponent(txtLogo))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel tableModel = (DefaultTableModel) tablePCs.getModel();
        while(tableModel.getRowCount() != 0) {
            tableModel.removeRow(0);
        }
        setTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    public void send(String action, int row, int column) {
        if(column >= 0 && row >= 0) {
            String ip = (String) tablePCs.getValueAt(row, 2);
            filterController.sendOrder(action, ip);
        } 
    }
    
    private void tablePCsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePCsMouseClicked
        int row = tablePCs.getSelectedRow();
        int column = tablePCs.getSelectedColumn();
        int maxRow = tablePCs.getRowCount();
        
        if((row>=0 && row<maxRow)) {
            DefaultTableModel tableModel = (DefaultTableModel) tablePCs.getModel();
            
            if(column == 4) {
                Object value = tableModel.getValueAt(row, column);
                String ip = (String) tableModel.getValueAt(row, 2);
                if(value.equals("Block")) {
                    tableModel.setValueAt("Unlock", row, column);
                    filterController.sendOrder("Desbloquear", ip);
                } else if(value.equals("Unlock")) {
                    tableModel.setValueAt("Block", row, column);
                    filterController.sendOrder("Bloquear", ip);
                }
            }
            
            if(column == 5) {
                String state = (String) tableModel.getValueAt(row, 4);
                if(state.equals("Block")) {
                    String ip = (String) tableModel.getValueAt(row, 2);
                    new Contador_view().viewFather(this, row, column, ip)
                            .setVisible(true);
                }
            }
            
            if(column == 6) {
                String ip = (String) tableModel.getValueAt(row, 2);
                Client client = find(ip);
                new Details_view().datos(client, filterController.getUser())
                        .setVisible(true);
            }
        }    
    }//GEN-LAST:event_tablePCsMouseClicked

    public void assignTime(int row, int column, String timeFinal) {
        Time time = new Time(this, row, column, timeFinal);
        new Thread(time).start();
    }
    
    public JTable getTable() {
        return this.tablePCs;
    }

    public Filter_Controller getFilterController() {
        return filterController;
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        final String action = "Apagar";
        send(action, tablePCs.getSelectedRow(), tablePCs.getSelectedColumn());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        final String action = "Reiniciar";
        send(action, tablePCs.getSelectedRow(), tablePCs.getSelectedColumn());
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        final String action = "Cerrar Sesion";
        send(action, tablePCs.getSelectedRow(), tablePCs.getSelectedColumn());
    }//GEN-LAST:event_jButton4ActionPerformed

    ImageIcon offline = new ImageIcon(getClass().getResource("/co/edu/unicartagena/view/image/offline-icon.png"));
    ImageIcon online = new ImageIcon(getClass().getResource("/co/edu/unicartagena/view/image/online-icon.png"));
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablePCs;
    private javax.swing.JLabel txtLogo;
    private javax.swing.JLabel txtUsuario;
    // End of variables declaration//GEN-END:variables
}
