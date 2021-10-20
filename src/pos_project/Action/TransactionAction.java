/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pos_project.Action;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import pos_project.classes.Collections;
import pos_project.classes.Formats;
import pos_project.classes.Invoice;
import pos_project.classes.Item;
import pos_project.classes.Location;
import pos_project.classes.SQLConnection;
import pos_project.classes.Stocks;
import pos_project.classes.Transaction;

/**
 *
 * @author Cif3r
 */
public class TransactionAction {
    
    
    
    public static DefaultTableModel getAllTransactions(int invoiceId){
       DefaultTableModel mod = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
       
//        mod.setColumnIdentifiers(new String[] {"Invoice #","IN-OUT","Client","Payment Type","Total Balance", "Transaction", "Date", "Date Due", "Added by", "Add Date", "Edited by", "Edit Date", "invoice number"});
//        mod.setColumnIdentifiers(new String[] {"Invoice #","Transaction","Client","Payment Type","Total Amount","Date", "Date Due", "Added by", "Add Date", "Edited by"
//                , "Edit Date", "invoice number"});
       mod.setColumnIdentifiers(new String[] {"Item Name","Supplier Name","Quantity","Amount","Transaction Id"});
//        int quantity = 0;
        ArrayList<Transaction> arrClients = Transaction.getTransactions(invoiceId+"");
        for(Transaction emp: arrClients){
            
           
//            String payment;
//            switch (emp.getInvoicePaymentType()) {
//                case 1: payment = "7 Days";
//                    break;
//                case 2: payment = "15 Days";
//                    break;
//                case 3: payment = "30 Days";
//                    break;
//                default: payment = "Cash";
//            }
            
            String fraquant = FractionAction.convertToFraction(emp.getTransactionQuantity());
            mod.addRow(new String[] {emp.getItemName(),emp.getSupplierName()+"",fraquant+"",Formats.centavoDecimal.format(emp.getTransactionPrice())
                   ,emp.getTransactionId()+""});
            
        }
        return mod;
    }
    
    
}
