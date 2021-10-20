/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pos_project.classes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.Timer;
import javax.swing.JLabel;

/**
 * Time Clock Class
 * Used to display time
 * @author Queenie
 */

public class TimeClock implements ActionListener{
    Timer clock;
    JLabel labelTime,labelDate;
//    WorkHour wh;
    boolean isMain = true;

    /**
     * Time Clock Constructor
     * @param lblTime
     */
    public TimeClock(JLabel lblTime) {
        labelTime = lblTime;
        isMain = true;
        labelTime.setText(" "+(DateFormat.getDateInstance(DateFormat.MEDIUM,Locale.US).format(new Date()))+" - "+
                         (DateFormat.getTimeInstance(DateFormat.MEDIUM,Locale.US).format(new Date())));
        clock = new Timer(1000, this);
        clock.start();

    }


     public TimeClock(JLabel lblTime, JLabel lblDate) {
        labelTime = lblTime;
        isMain = false;
        labelDate =lblDate;
//        labelTime.setText("Today is "+(DateFormat.getDateInstance(DateFormat.MEDIUM,Locale.US).format(new Date()))+" - "+
//                         (DateFormat.getTimeInstance(DateFormat.MEDIUM,Locale.UK).format(new Date())));
        labelTime.setText((DateFormat.getTimeInstance(DateFormat.SHORT,Locale.UK).format(new Date())));
        labelDate.setText((DateFormat.getDateInstance(DateFormat.FULL,Locale.UK).format(new Date())));
        clock = new Timer(1000, this);
        clock.start();
    }
    
    /**
     * Action Performed Method Implementation
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        if(isMain){
        labelTime.setText(" "+(DateFormat.getDateInstance(DateFormat.MEDIUM,Locale.US).format(new Date()))+" - "+
                         (DateFormat.getTimeInstance(DateFormat.MEDIUM,Locale.US).format(new Date())));
        }else{
            labelTime.setText((DateFormat.getTimeInstance(DateFormat.SHORT,Locale.UK).format(new Date())));
        labelDate.setText((DateFormat.getDateInstance(DateFormat.FULL,Locale.UK).format(new Date())));
        }
    }
}
