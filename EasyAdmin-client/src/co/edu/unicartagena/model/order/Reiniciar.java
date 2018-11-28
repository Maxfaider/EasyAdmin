
package co.edu.unicartagena.model.order;

import co.edu.unicartagena.model.order.system.System;

/**
 *
 * @author Alan M.E
 * @version 1.2
 */

public class Reiniciar implements Command {

    @Override
    public void excute() {
        System.onAction("Reiniciar");
    }
    
}
