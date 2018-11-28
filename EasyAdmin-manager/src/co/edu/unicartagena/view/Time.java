
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
   
    private Gestion_view ref;
    private String timeFinal;
    private int row;
    private int column;
    
    public Time(Gestion_view ref, int row, int column, String timeFinal) {
        this.ref = ref;
        this.column = column;
        this.row = row;
        this.timeFinal = timeFinal;
    }

    private String convert(int value) {
        if(value < 10) {
            return "0"+String.valueOf(value);
        }
        return String.valueOf(value);
    }
    
    private boolean condicion(String time) {
        return time.equals(timeFinal);
    }
    
    @Override
    public void run() {
        int hour = 0;
        int minutes = 0;
        int seconds = 0;
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
                String t = time(hour, minutes, seconds);
                ref.getTable().setValueAt(t, row, column);
                if(condicion(t)) {
                    ref.getTable().setValueAt("Block", row, 4);
                    ref.send("Bloquear", row, column);
                    break;
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Time.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        ref.getTable().setValueAt("00:00:00", row, column);
    }

    public String time(int hour, int minutes, int seconds) {
        return convert(hour)+":"
                +convert(minutes)+":"
                +convert(seconds); 
    }
    
}
