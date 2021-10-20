/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pos_project.classes;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Cif3r
 */
public final class Formats {
    public static final SimpleDateFormat dateFormatSeconds = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat dateFormatSeconds2 = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");
    public static final SimpleDateFormat dateFormatMinutes = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    public static final SimpleDateFormat dateFormatMinutes2 = new SimpleDateFormat("yyyy-MMM-dd HH:mm");
    public static final SimpleDateFormat dateFormatDays = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat dateFormatDays2 = new SimpleDateFormat("yyyy-MMM-dd");
    public static final SimpleDateFormat dateFormatMonths = new SimpleDateFormat("yyyy-MM");
    public static final SimpleDateFormat dateFormatMonths2 = new SimpleDateFormat("yyyy-MMM");
    public static final SimpleDateFormat dateFormatYears = new SimpleDateFormat("yyyy");
    public static final SimpleDateFormat dateFormatDaysUK = new SimpleDateFormat("yyyy-MM-dd", Locale.UK);
    public static final DecimalFormat pesoDecimal = new DecimalFormat("#,### ");
    public static final DecimalFormat centavoDecimal = new DecimalFormat("###,##0.00 ");
    
   public static final DefaultTableCellRenderer getTableRenderer(){
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment( DefaultTableCellRenderer.RIGHT );
        return rightRenderer;
    }
    
        
}
