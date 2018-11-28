
package co.edu.unicartagena.model.order;

import co.edu.unicartagena.model.order.system.System;

/**
 *
 * @author Alan M.E
 * @version 1.0
 */

public class Cerrar_Sesion implements Command {

    @Override
    public void excute() {
        System.onAction("Cerrar Sesion");
    }
    
}
