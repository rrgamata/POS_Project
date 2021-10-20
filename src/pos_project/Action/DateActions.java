/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pos_project.Action;

import java.util.GregorianCalendar;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Cif3r
 */
public class DateActions {
    
    
    public static DefaultComboBoxModel fixDay(int monthIndex, String year){
      Integer[] sthrty = {4,6,9,11};
      int days=31;
      for(int i = 0; i <sthrty.length;i++){
        if((monthIndex+1) == sthrty[i]){
            days =30;
        }else if((monthIndex+1)==2){
            int Year = Integer.parseInt(year);
                if((Year%4)==0){
                    days =29;
                }else{
                    days = 28;
                }
        }
      }
      DefaultComboBoxModel dayList = new DefaultComboBoxModel();
      for(int j=1; j<=days ;j++){
            dayList.addElement(j);
      }
      return dayList;
     }
    
     public static DefaultComboBoxModel getYearModel(){
      int year = new GregorianCalendar().get(GregorianCalendar.YEAR);
      int fromyear = year -50;
      int toYear = year +5;
      DefaultComboBoxModel dayList = new DefaultComboBoxModel();
      for(int  i = fromyear; i<=toYear ;i++){
            dayList.addElement(i);
      }
      return dayList;
     }
     
      public static void comboBoxDateAction(javax.swing.JComboBox yearCombo, javax.swing.JComboBox monthCombo, javax.swing.JComboBox dayCombo){
        //true From date false To date
        
             int i = dayCombo.getSelectedIndex()+1;
             dayCombo.setModel(DateActions.fixDay(monthCombo.getSelectedIndex(), yearCombo.getSelectedItem().toString()));
            checkCurrentComboBoxDay(yearCombo, monthCombo, dayCombo, i);
      }
      
       public static void checkCurrentComboBoxDay(javax.swing.JComboBox yearComboBox, javax.swing.JComboBox monthComboBox, javax.swing.JComboBox dayComboBox, int i){
         GregorianCalendar cal = new GregorianCalendar(Integer.parseInt(yearComboBox.getSelectedItem().toString()),monthComboBox.getSelectedIndex(), 1);
        if(i <=  cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH)){
            dayComboBox.setSelectedIndex(i-1);
        } 
    }
}
