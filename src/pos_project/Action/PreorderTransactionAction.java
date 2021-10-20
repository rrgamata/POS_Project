/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pos_project.Action;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import pos_project.classes.Formats;
import pos_project.classes.PreorderTransaction;
import pos_project.classes.Transaction;

/**
 *
 * @author Cif3r
 */
public class PreorderTransactionAction {
    
    
    
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
//        Double quantity = 0.0;
        ArrayList<PreorderTransaction> arrClients = PreorderTransaction.getTransactions(invoiceId+"");
        for(PreorderTransaction emp: arrClients){
            
           
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
            
            String faquant = FractionAction.convertToFraction(emp.getPreorderTransactionQuantity());
            mod.addRow(new String[] {emp.getPreorderItemName(),emp.getPreorderSupplierName()+"",faquant+"",Formats.centavoDecimal.format(emp.getPreorderTransactionPrice())
                   ,emp.getPreorderTransactionId()+""});
            
        }
        return mod;
    }
    
    
}
