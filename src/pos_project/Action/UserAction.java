/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pos_project.Action;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import javax.swing.table.DefaultTableModel;
import pos_project.classes.User;

/**
 *
 * @author Cif3r
 */
public class UserAction {
    
    public static int createUser(int userType, String firstName, String lastName, String userName, String password){
        User u = new User();
        u.setUserFirstName(firstName);
        u.setUserLastName(lastName);
        u.setUserUsername(userName);
        u.setUserPassword(password);
        u.setUserType(new Short(""+userType));
        u.setUserAddDate(new GregorianCalendar().getTime());
        u.setUserAddUser(System.getProperty("userName"));
        
        return User.insertUser(u);
        
    }
    
     public static int editUser(int userId,int userType, String firstName, String lastName, String userName){
        User u = new User();
        u.setUserFirstName(firstName);
        u.setUserLastName(lastName);
        u.setUserUsername(userName);
//        u.setUserPassword(password);
        u.setUserType(new Short(""+userType));
        u.setUserEditDate(new GregorianCalendar().getTime());
        u.setUserEditUser(System.getProperty("userName"));
        u.setUserId(userId);
        return User.editUser(u);
        
    }
    
    public static DefaultTableModel getMainTableData(){
       DefaultTableModel mod = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
       
        mod.setColumnIdentifiers(new String[] {"Name","userName","UserType","User Number"});
        
        ArrayList<User> arrClients =User.getUserList();
        for(User emp: arrClients){
            String cType;
            switch (emp.getUserType()) {
                case 1: cType = "Cashier";
                    break;
                case 2: cType = "Purchaser";
                    break;    
                default: cType = "Admin";
            }
           mod.addRow(new String[] {emp.getUserFirstName()+" "+ emp.getUserLastName()+"",emp.getUserUsername()+"",cType+"",emp.getUserId().toString()});
            
        }
//        mod.setColumnCount(3);
        return mod;
    }
    
}
