/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pos_project.Action;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import pos_project.classes.Formats;
import pos_project.classes.Transaction;
import pos_project.classes.Transfer;

/**
 *
 * @author Cif3r
 */
public class TransferAction {
    
    
//    public static DefaultTableModel getMainTableData(){
//       DefaultTableModel mod = new DefaultTableModel(){
//            @Override
//            public boolean isCellEditable(int row, int column){
//                return false;
//            }
//        };
//       
//        mod.setColumnIdentifiers(new String[] {"Location Name","Address","Phone Number","Location Number"});
//        
////        ArrayList<Location> arrClients = Location.getLocationList();
//        ArrayList<Client> arrClients = Client.getClientList();
//        for(Client emp: arrClients){
//            String cType;
//            
//           mod.addRow(new String[] {emp.getClientName()+"",emp.getClientAddress()+"",emp.getClientPhone()+"",emp.getClientId().toString()});
//            
//        }
////        mod.setColumnCount(3);
//        return mod;
//    }
//    
//   public static DefaultTableModel getCustomerTableData(int clientType){
//       DefaultTableModel mod = new DefaultTableModel(){
//            @Override
//            public boolean isCellEditable(int row, int column){
//                return false;
//            }
//        };
//       
//        mod.setColumnIdentifiers(new String[] {"Client Name","Address","Phone Number","Client Number"});
//        
//        ArrayList<Client> arrClients = Client.getCustomerList(clientType);
//        for(Client emp: arrClients){
//           mod.addRow(new String[] {emp.getClientName()+"",emp.getClientAddress()+"",emp.getClientPhone()+"",emp.getClientId().toString()});
//            
//        }
////        mod.setColumnCount(3);
//        return mod;
//    }
//    
//    
//    public static int insertLocation(String name, String address, String phone){
//        Location c = createLocation(name, address, phone);
//        c.setLocationAddDate(new GregorianCalendar().getTime());
//        c.setLocationAddUser(System.clearProperty("userName"));
//       return (Location.addLocation(c));            
//    }
//    
//    public static int editLocation(String name, String address, String phone, String Id){
//       Location c = createLocation(name, address, phone);
//       c.setLocationId(Integer.parseInt(Id));
//       c.setLocationEditDate(new GregorianCalendar().getTime());
//       c.setLocationEditUser(System.clearProperty("userName"));
//       return (Location.editLocation(c));            
//        
//    }
//    
//    private static Location createLocation(String name, String address, String phone){
//       Location c = new Location();
//       c.setLocationName(name);
//       c.setLocationAddress(address);
//       c.setLocationTelNo(phone);
//       return c;
//    }
//    
//    public static DefaultComboBoxModel getLocationModel(){
//        ArrayList<Location> location = Location.getLocationList();
//        DefaultComboBoxModel mod = new DefaultComboBoxModel(location.toArray());
//        return mod;
//    }
//    
    
    public static DefaultTableModel getAllTransfer(){
       DefaultTableModel mod = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
       
//     
       mod.setColumnIdentifiers(new String[] {"Transfer #","From","To","Date","Transfer Id"});
        int quantity = 0;
        ArrayList<Transfer> arrClients = Transfer.getTransfers();
        for(Transfer emp: arrClients){
//     
            String editDate;
//     
            if(emp.getTransferDate() == null){
                editDate = "-";
            }else{
                editDate = Formats.dateFormatDays.format(emp.getTransferDate());
            }
          mod.addRow(new String[] {emp.getTransferNumber()+"",emp.getFromName(),emp.getTomName()+"",editDate, emp.getTransferId()+""});
            
        }
        return mod;
    }
    
    
    public static DefaultTableModel getTransferData(String fromDate, String toDate){
       DefaultTableModel mod = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
       
//        mod.setColumnIdentifiers(new String[] {"Invoice #","IN-OUT","Client","Payment Type","Total Balance", "Transaction", "Date", "Date Due", "Added by", "Add Date", "Edited by", "Edit Date", "invoice number"});
//        mod.setColumnIdentifiers(new String[] {"Invoice #","Transaction","Client","Payment Type","Total Amount","Date", "Date Due", "Added by", "Add Date", "Edited by"
//                , "Edit Date", "invoice number"});
       mod.setColumnIdentifiers(new String[] {" "," "," "," "," "});
        Double grandTotal = 0.0;
        ArrayList<Transfer> arrClients = Transfer.getTransfers(fromDate, toDate);
        for(Transfer emp: arrClients){
            String date;
            
            if(emp.getTransferDate() == null){
                date = "-";
            }else{
                date = Formats.dateFormatDays2.format(emp.getTransferDate());
            }
            
            mod.addRow(new String[] {"Transfer #",emp.getTransferNumber()+""});
            mod.addRow(new String[] {"From", emp.getFromName()});
//            mod.addRow(new String[] {"Payment Type",payment +"","Due Date", dueDate});
            
//            mod.addRow(new String[] {" "," "});
            mod.addRow(new String[] {"To",emp.getTomName() +""});
            mod.addRow(new String[] {"Date", date});
            mod.addRow(new String[] {" ","Item Name", "Quantity"});
             ArrayList<Transaction> transactionList = Transaction.getTransactions(""+emp.getTransferFromInvoiceId());
             for(Transaction temp: transactionList){
                 String fraquant = FractionAction.convertToFraction(temp.getTransactionQuantity());
                 mod.addRow(new String[] {" ",temp.getItemName()+"",fraquant+""});
                 
             }
//           mod.addRow(new String[] {" ", "Total", " ", " ", totalAmount+""});
           mod.addRow(new String[] {" ", " ", " ", " "," "});           
//         grandTotal += totalAmount;
        }
//        mod.addRow(new String[] {"Grand Total", " ", " ", " ", grandTotal+""});
        
       
        return mod;
    
    }
}
