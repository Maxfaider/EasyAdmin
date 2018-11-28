
package co.edu.unicartagena.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alan M.E
 * @version 1.0
 */

class Memento {
    
    private String idAdmin;
    private String user;
    private String ipClient;
    
    private boolean token;
    private static final String file = "edb_EsasyAdmin.bin";
    
    public Memento() {
        recover();
    }
    
    public boolean authorized() {
        return this.token;
    }
    
    private void recover() {
        try {
            FileInputStream fis = new FileInputStream(file);
            
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            this.idAdmin = (String) ois.readObject();
            this.user = (String) ois.readObject();
            this.ipClient = (String) ois.readObject();
            this.token = true;
            ois.close();
            
        } catch (FileNotFoundException ex) {
            defaultValue();
        } catch (IOException ex) {
            defaultValue();
        } catch (ClassNotFoundException ex) {
            defaultValue();
        }
    }
    
    public void update() {
        
        try { 
            FileOutputStream fos = new FileOutputStream(file);
            
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeObject(idAdmin);
            oos.writeObject(user);
            oos.writeObject(ipClient);
            oos.close();
            
            this.token = true;  
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Memento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Memento.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    private void defaultValue() {
        this.token = false;
    }

    public void setIdAmin(String idAdmin) {
        this.idAdmin = idAdmin;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getIdAmin() {
        return idAdmin;
    }

    public String getUser() {
        return user;
    }

    public String getIpClient() {
        return ipClient;
    }

    public void setIpClient(String ipClient) {
        this.ipClient = ipClient;
    }
    
}
