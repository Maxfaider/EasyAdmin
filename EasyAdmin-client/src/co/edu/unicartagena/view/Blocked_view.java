
package co.edu.unicartagena.view;

import co.edu.unicartagena.model.ListenerOrder;
import co.edu.unicartagena.controller.Filter_Controller;
import co.edu.unicartagena.model.ListenerServer;
import co.edu.unicartagena.model.order.Order_Controller;
import co.edu.unicartagena.view.observer.Observer_view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Alan M.E
 * @version 1.0
 */

public class Blocked_view extends javax.swing.JFrame implements ListenerOrder {

    private Order_Controller controller;
    
    public Blocked_view() {
        setExtendedState(MAXIMIZED_BOTH);
        setAlwaysOnTop(true);
        setUndecorated(true);
        initComponents();
        
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setBackground(new ImageIcon(getClass().getResource("/co/edu/unicartagena/view/image/fondo.png")),
                dimension);
        block();
        configClose();
        
        setService();
    }
    
    public Blocked_view setController(Order_Controller controller) {
        this.controller = controller;
        return this;
    }
    
    @Override
    public void processOrder(String order) {
        if(order.equals("Desbloquear")) {
            dispose();
            new Open_view().setController(controller)
                    .setVisible(true);
        } else {
            Filter_Controller.getInstance().changeState();
            this.controller.setCommand(order);
            this.controller.invoke();
        }
    }
   
    private void block() {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(() -> {
            front();
        }, 500, 50, TimeUnit.MILLISECONDS );
    }
    
    private void setService() {
        ListenerServer listener = new ListenerServer(Filter_Controller.getInstance());
        listener.addObserver(new Observer_view(this));
        
        new Thread(listener).start();
    }
    
    private void front() {
        setExtendedState(MAXIMIZED_BOTH);//maximizado
        toFront();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUser = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jLabel1.setText("www.EasyAdmin.ga");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/unicartagena/view/image/logo.png"))); // NOI18N

        txtUser.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        txtUser.setText("Esasy AdminPRO - V1.0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(txtUser))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(txtUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setBackground(ImageIcon image, Dimension dimension) {
        JPanel fondo = new JPanel_Fondo(image, dimension);
        this.add(fondo, BorderLayout.CENTER);
        fondo.repaint();
    }
    
    private void configClose() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Filter_Controller.getInstance().changeState();
            }
        });
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel txtUser;
    // End of variables declaration//GEN-END:variables

}
