
package co.edu.unicartagena.model;

/**
 *
 * @author Alan M.E
 * @version 1.0
 */

public class Admin {
    
    private String user;
    private String password;
    private InfoPersonal infoPersonal;

    public Admin(String user, String password) {
        this.user = user;
        this.password = password;
    }
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public InfoPersonal getInfoPersonal() {
        return infoPersonal;
    }

    public void setInfoPersonal(InfoPersonal infoPersonal) {
        this.infoPersonal = infoPersonal;
    }
    
}
