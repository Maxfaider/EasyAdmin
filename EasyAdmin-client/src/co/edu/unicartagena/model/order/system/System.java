
package co.edu.unicartagena.model.order.system;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alan M.e
 * @version 1.0
 */

public class System {
    
    public static void onAction(String action) {
        execute(action);
    }
    
    private static void execute(String action) {
        try { 
            switch(action) {
                case "Apagar": 
                    String[] cmd1 = {"shutdown","-s","-t", "5"}; //Comando de apagado en windows
	            Runtime.getRuntime().exec(cmd1);
                    break;
                case "Reiniciar": 
                    String [] cmd2 = {"shutdown","-r","-t", "5"}; //Comando de Reiniciar en windows
	            Runtime.getRuntime().exec(cmd2);
                    break;
                case "Cerrar Sesion": 
                    String [] cmd3 = {"shutdown","-l","-t", "5"}; //Comando de Cerrar Sesion en windows
	            Runtime.getRuntime().exec(cmd3);
                    break;
            }
        } catch (IOException ex) {
            Logger.getLogger(System.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    
}
