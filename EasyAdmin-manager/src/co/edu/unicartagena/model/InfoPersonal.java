
package co.edu.unicartagena.model;

/**
 *
 * @author Alan M.E
 * @version 1.0
 */

public class InfoPersonal {
    
    private String names;
    private String lastNames;
    private String email;
    private String phone;

    public InfoPersonal(String names, String lastNames, String email, String phone) {
        this.names = names;
        this.lastNames = lastNames;
        this.email = email;
        this.phone = phone;
    }
    
    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLastNames() {
        return lastNames;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
}
