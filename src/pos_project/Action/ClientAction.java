/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pos_project.Action;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import javax.swing.ComboBoxModel;
import javax.swing.table.DefaultTableModel;
import pos_project.classes.Client;


/**
 *
 * @author Cif3r
 */
public class ClientAction {
    
    
    public static DefaultTableModel getMainTableData(){
       DefaultTableModel mod = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
       
        mod.setColumnIdentifiers(new String[] {"Client #","Client Name","Address","Phone Number","Client Type","Sub-Type","Client Number"});
        
        ArrayList<Client> arrClients = Client.getClientList();
        for(Client emp: arrClients){
            String cType;
            switch (emp.getClientTypeFlag()) {
                case 1: cType = "Supplier";
                    break;
                default: cType = "Customer";
            }
           mod.addRow(new String[] {emp.getClientNumber(), emp.getClientName()+"",emp.getClientAddress()+"",emp.getClientPhone()+"",cType+"",getSubtype(emp.getClientSubType()),emp.getClientId().toString()});
            
        }
//        mod.setColumnCount(3);
        return mod;
    }
    
   public static DefaultTableModel getCustomerTableData(int clientType){
       DefaultTableModel mod = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
       
        mod.setColumnIdentifiers(new String[] {"Client Name","Address","Phone Number","Client Number"});
        
        ArrayList<Client> arrClients = Client.getCustomerList(clientType);
        for(Client emp: arrClients){
           mod.addRow(new String[] {emp.getClientName()+"",emp.getClientAddress()+"",emp.getClientPhone()+"",emp.getClientId().toString()});
            
        }
//        mod.setColumnCount(3);
        return mod;
    }
    
    
    public static int insertClient(String name, String address, String phone, int clientType,String clientNumber, String creditLimit, int subtype){
        Client c = createClient(name, address, phone, clientType);
        c.setClientCreditLimit(Double.parseDouble(creditLimit));
        c.setClientAddDate(new GregorianCalendar().getTime());
        c.setClientAddUser(System.clearProperty("userName"));
        c.setClientNumber(clientNumber);
        c.setClientSubType((short) subtype);
       return (Client.addClient(c));            
    }
    
    public static int editClient(String name, String address, String phone, String Id, int clientType, String clientNumber, String creditLimit, int subtype){
       Client c = createClient(name, address, phone, clientType);
       c.setClientId(Integer.parseInt(Id));
       c.setClientEditDate(new GregorianCalendar().getTime());
       c.setClientEditUser(System.clearProperty("userName"));
       c.setClientCreditLimit(Double.parseDouble(creditLimit));
       c.setClientPhone(phone);
       c.setClientNumber(clientNumber);
       c.setClientSubType((short) subtype);
       return (Client.editClient(c));            
        
    }
    
    private static Client createClient(String name, String address, String phone, int clientType){
       Client c = new Client();
       c.setClientName(name);
       c.setClientAddress(address);
       c.setClientPhone(phone);
       c.setClientTypeFlag((short) clientType);
       return c;
    }
    
    public static String getSubtype(Short subtype){
//        String[] subTypeString = Constants.getClieSubTypeArray();
//        return subTypeString[subtype]; 
//          switch(subtype){
//              case 1: return "seeds";
//              case 2: return "feeds";
//              case 3: return "fertilizer";
//              case 4: return "ag-chem";
//              default: return "n/a";
//                              
//          }
           return Client.getClientSubTypeList()[subtype];
    }
    
    
}
