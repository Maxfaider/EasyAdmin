
package co.edu.unicartagena;

import co.com.amecodetech.infoclient.Client;
import co.edu.unicartagena.controller.Filter_Controller;
import co.edu.unicartagena.model.order.Order_Controller;
import co.edu.unicartagena.view.Blocked_view;
import co.edu.unicartagena.view.Sesion_view;

/**
 * @author Alan M.E
 */

public class EasyAdminClient {
    
    public static void main(String[] args) {
        Filter_Controller filterController = Filter_Controller.getInstance();
        
        System.out.println(filterController.getIp());
        
        if(!filterController.getLinked()) {
            new Sesion_view().setController(filterController)
                    .setVisible(true);
        } else {
            
            filterController.RegisterClient(new Client());
            
            Order_Controller controller = new Order_Controller();
            new Blocked_view().setController(controller)
                    .setVisible(true);
        }
    }
    
}
