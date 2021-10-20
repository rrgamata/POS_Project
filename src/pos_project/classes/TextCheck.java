/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pos_project.classes;

import java.awt.Component;
import java.awt.Frame;
import java.util.Locale;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import java.util.regex.*;

/**
 *
 * @author Ton
 */
public class TextCheck {
//All returns true if error
    public static boolean checkMax(int max, String s, JDialog j, String title){

       
        if(s.length()>max){
            JOptionPane.setDefaultLocale(Locale.ENGLISH);
            JOptionPane.showMessageDialog(j, title+" length should be less than "+max, "Max length", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        return false;


    }
    /** isPhoneNumberValid: Validate phone number using Java reg ex.
* This method checks if the input string is a valid phone number.
* @param email String. Phone number to validate
* @return boolean: true if phone number is valid, false otherwise.
*/
public static boolean isPhoneNumberValid(String phoneNumber, JDialog j, String title ){
    boolean notValid = true;
   
   try{

          Long.parseLong(phoneNumber);
          notValid=false;

   }catch(Exception e){

    JOptionPane.setDefaultLocale(Locale.ENGLISH);
    JOptionPane.showMessageDialog(j, title+" can only contain numbers", "Format Error", JOptionPane.ERROR_MESSAGE);
   }
    return notValid;
}

    
    public static boolean checkInt(String s, JDialog j, String title){
        try{
            int i = Integer.parseInt(s);

            return false;

        }catch(Exception e){
            JOptionPane.setDefaultLocale(Locale.ENGLISH);
            JOptionPane.showMessageDialog(j, title+" can only contain numbers", "Format Error", JOptionPane.ERROR_MESSAGE);
            return true;
        }

   }
    public static boolean checkLong(String s, JDialog j, String title){
        try{
            long l = Long.parseLong(s);

            return false;

        }catch(Exception e){
            JOptionPane.setDefaultLocale(Locale.ENGLISH);
            JOptionPane.showMessageDialog(j, title+" can only contain numbers", "Format Error", JOptionPane.ERROR_MESSAGE);
            return true;
        }

    }
}
