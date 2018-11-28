
package co.edu.unicartagena;

import co.edu.unicartagena.controller.Filter_Controller;
import co.edu.unicartagena.view.Sesion_view;

/**
 *
 * @author Alan M.E
 */

public class EasyAdminManager {
    
    public static void main(String[] args) {
        
        Filter_Controller filterController = Filter_Controller.getInstance();
        
        new Sesion_view().setController(filterController)
                .setVisible(true);
        
    }
    
}
