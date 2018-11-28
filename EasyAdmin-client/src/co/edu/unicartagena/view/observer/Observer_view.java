
package co.edu.unicartagena.view.observer;

import co.edu.unicartagena.model.ListenerOrder;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Alan M.E
 * @version 1.0
 */

public class Observer_view implements Observer {
    
    private ListenerOrder listener;
    
    public Observer_view(ListenerOrder listener) {
        this.listener = listener;
    }
    
    public void setListenerOrder(ListenerOrder listener) {
        this.listener = listener;
    }

    @Override
    public void update(Observable o, Object arg) {
        this.listener.processOrder((String) arg);
    }
    
}
