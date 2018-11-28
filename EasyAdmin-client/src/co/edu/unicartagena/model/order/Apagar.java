
package co.edu.unicartagena.model.order;

import co.edu.unicartagena.model.order.system.System;

/**
 *
 * @author Alan M.E
 * @version 1.2
 */

public class Apagar implements Command {

    @Override
    public void excute() {
       System.onAction("Apagar");
    }
    
}
