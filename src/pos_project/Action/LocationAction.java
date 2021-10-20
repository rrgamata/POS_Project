/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pos_project.Action;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import pos_project.classes.Client;
import pos_project.classes.Location;

/**
 *
 * @author Cif3r
 */
public class LocationAction {
    
    
    public static DefaultTableModel getMainTableData(){
       DefaultTableModel mod = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
       
        mod.setColumnIdentifiers(new String[] {"Location Name","Address","Phone Number","Location Number"});
        
//        ArrayList<Location> arrClients = Location.getLocationList();
        ArrayList<Client> arrClients = Client.getLocationList();
        for(Client emp: arrClients){
            String cType;
            
           mod.addRow(new String[] {emp.getClientName()+"",emp.getClientAddress()+"",emp.getClientPhone()+"",emp.getClientId().toString()});
            
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
    
    
    public static int insertLocation(String name, String address, String phone){
        Client c = createLocation(name, address, phone);
        c.setClientCreditLimit(0.0);
        c.setClientAddDate(new GregorianCalendar().getTime());
        c.setClientAddUser(System.clearProperty("userName"));
       return (Client.addClient(c));            
    }
    
    public static int editLocation(String name, String address, String phone, String Id){
       Client c = createLocation(name, address, phone);
       c.setClientId(Integer.parseInt(Id));
       c.setClientEditDate(new GregorianCalendar().getTime());
       c.setClientEditUser(System.clearProperty("userName"));
       return (Client.editClient(c));            
        
    }
    
    private static Client createLocation(String name, String address, String phone){
       Client c = new Client();
       c.setClientName(name);
       c.setClientAddress(address);
       c.setClientPhone(phone);
       c.setClientTypeFlag(new Short("3"));
       return c;
    }
    
    public static DefaultComboBoxModel getLocationModel(){
        ArrayList<Client> location = Client.getLocationList();
        DefaultComboBoxModel mod = new DefaultComboBoxModel(location.toArray());
        return mod;
    }
    
    public static ArrayList<Client> getLocationList(){
        ArrayList<Client> location = Client.getLocationList();
//        DefaultComboBoxModel mod = new DefaultComboBoxModel(location.toArray());
     return location;
    }
}
