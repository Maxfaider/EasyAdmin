
package co.edu.unicartagena.view;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Alan M.E
 * @version 1.0
 */

public class Time implements Runnable {
    
    private int hour;
    private int minutes;
    private int seconds;
    
    private JLabel label;
    
    public Time(JLabel label) {
        this.label = label;
        
        hour = 0;
        minutes = 0;
        seconds = 0;
    }

    private String convert(int value) {
        if(value < 10) {
            return "0"+String.valueOf(value);
        }
        return String.valueOf(value);
    }
    
    @Override
    public void run() {
        while(true) {
            if(minutes == 59) {
                hour++;
                minutes = 0;
                seconds = 0;
                continue;
            }
            if(seconds == 59) {
                minutes++;
                seconds = 0;
                continue;
            }
            try {
                seconds++;
                Thread.sleep(1000);
                this.label.setText(toString());
            } catch (InterruptedException ex) {
                Logger.getLogger(Time.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public int getHour() {
        return hour;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }
   
    @Override
    public String toString() {
        return convert(hour)+":"
                +convert(minutes)+":"
                +convert(seconds); 
    }
    
}
