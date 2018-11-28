
package co.edu.unicartagena.model;

import co.edu.unicartagena.controller.Filter_Controller;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AlanM.E
 * @version 1.0
 */

public class ListenerServer extends Observable implements Runnable {
    
    private Filter_Controller ref;
    
    public ListenerServer(Filter_Controller ref) {
        this.ref = ref;
    }

    @Override
    public void run() {
        while(true) {
            try {
                String order = ref.findOrder();
                if(!order.equals("not found")) {
                    this.setChanged();
                    this.notifyObservers(order);
                    break;
                }
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ListenerServer.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }
    }
    
}
