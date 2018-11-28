
package co.edu.unicartagena.model.order;

/**
 *
 * @author Alan M.E
 */

public class Order_Controller {
    
    private Command command;
    
    public Order_Controller() {
        
    }
    
    public void setCommand(String order) {
        this.command = Order_Factory.getInstance(order);
    }
    
    public void setCommand(Order_Factory order) {
        this.command = Order_Factory.getInstance(order.getValue());
    }
    
    public void invoke() {
        this.command.excute();  
    }
    
}
