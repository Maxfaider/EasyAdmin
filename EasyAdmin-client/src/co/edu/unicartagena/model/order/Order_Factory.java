
package co.edu.unicartagena.model.order;

/**
 *
 * @author Alan M.E
 * @version 1.0
 */

public enum Order_Factory {
    
    APAGAR("Apagar"),
    CERRAR_SESION("Cerrar Sesion"),
    REINICIAR("Reiniciar");
    
    private String value;
    
    private Order_Factory(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
    
    public static Command getInstance(String order) {
        switch(order) {
            case "Apagar":
                return new Apagar();
            case "Cerrar Sesion":
                return new Cerrar_Sesion();
            case "Reiniciar":
                return new Reiniciar();  
            default:
                return new Apagar();
        }
    }
    
}
