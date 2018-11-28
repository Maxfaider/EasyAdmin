
package co.edu.unicartagena.controller;

/**
 *
 * @author Alan M.E
 * @version 1.0
 */

public class Memento {
    
    private String idAdmin;
    private String user;
    
    public Memento(String idAdmin, String user) {
        this.idAdmin = idAdmin;
        this.user = user;
    }

    public String getIdAdmin() {
        return idAdmin;
    }

    public String getUser() {
        return user;
    }
    
}
