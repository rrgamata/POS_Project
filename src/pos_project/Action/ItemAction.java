/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pos_project.Action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import pos_project.classes.Client;
import pos_project.classes.Formats;
import pos_project.classes.Item;
import pos_project.classes.ItemLimit;

/**
 *
 * @author Cif3r
 */
public class ItemAction {
    
    
    public static DefaultTableModel getMainTableData(){
     return getMainTableData(false);
    }
    
     public static DefaultTableModel getMainTableData(boolean outFlag){
       DefaultTableModel mod = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
       
       
       
       String[] col = new String[] {"Item Name","Item Supplier","Item Price", "Item Number"};
       Vector column = new Vector(Arrays.asList(col));
//       for(Client cl: loc){
//           column.add(cl.getClientName());
//       }
        mod.setColumnIdentifiers(column);
        ArrayList<Item> arrItems;
//        if(outFlag){
//            arrItems = Item.getItemListInStock();
//        } else{
           arrItems = Item.getItemList();
//        }
        
        for(Item emp: arrItems){
             String[] a = new String[] {emp.getItemName()+"",emp.getClientName()+"",emp.getItemPrice().toString()+"", emp.getItemId().toString()};
             Vector ar = new Vector(Arrays.asList(a));
//            for(Client cl: loc){
//                ItemLimit itm = ItemLimit.getItemLimit(emp.getItemId().toString(),cl.getClientId().toString());
//                int limit = 0;
//                if(itm.getItemLimitQuantity() != null){
//                    limit = itm.getItemLimitQuantity();
//                }
//                ar.add(limit);
//            }
           mod.addRow(ar);
            
        }
//        mod.setColumnCount(3);
        return mod;
    }
     
     
     public static DefaultTableModel getMainTableData(boolean outFlag, int locationId){
       DefaultTableModel mod = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
       
        mod.setColumnIdentifiers(new String[] {"Item Name","Item Supplier","Item Price", "Item Number"});
        ArrayList<Item> arrItems;
//        if(outFlag){
//            arrItems = Item.getItemListInStock(locationId);
//        } else{
           arrItems = Item.getItemList();
//        }
        
        for(Item emp: arrItems){
           mod.addRow(new String[] {emp.getItemName()+"",emp.getClientName()+"",emp.getItemPrice().toString()+"", emp.getItemId().toString()});
            
        }
//        mod.setColumnCount(3);
        return mod;
    }
     
     public static DefaultTableModel getOrderTableData( int locationId){
       DefaultTableModel mod = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
       
        mod.setColumnIdentifiers(new String[] {"Item Name","Item Supplier","Item Price", "Item Limit", "Stocks Quantity"});
        ArrayList<Item> arrItems;
        
            arrItems = Item.getItemListInStockLimit(locationId);
        
        
        for(Item emp: arrItems){
            
            String fracQuant = FractionAction.convertToFraction(emp.getQuantity());
            String fracQuantMin = FractionAction.convertToFraction(emp.getMinQuantity());
           mod.addRow(new String[] {emp.getItemName()+"",emp.getClientName()+"",emp.getItemPrice().toString()+"", fracQuantMin, fracQuant});
            
        }
//        mod.setColumnCount(3);
        return mod;
    }
    
    
    public static DefaultTableModel getSpecificTableData(int supplierNumber){
       DefaultTableModel mod = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
       
        mod.setColumnIdentifiers(new String[] {"Item Name","Item Supplier","Item Price", "Item Number"});
        
        ArrayList<Item> arrItems = Item.getSupplierItemList(supplierNumber);
        for(Item emp: arrItems){
           mod.addRow(new String[] {emp.getItemName()+"",emp.getClientName()+"",emp.getItemPrice().toString()+"", emp.getItemId().toString()});
            
        }
//        mod.setColumnCount(3);
        return mod;
    }
    
    
    public static DefaultTableModel getAllItemData(int supplierNumber){
       DefaultTableModel mod = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
       
        mod.setColumnIdentifiers(new String[] {"Item Name","Item Supplier","Item Price", "Item Number"});
        
//        ArrayList<Item> arrItems = Item.getSupplierItemList(supplierNumber);
        ArrayList<Item> arrItems = Item.getAllItemList();
        for(Item emp: arrItems){
           mod.addRow(new String[] {emp.getItemName()+"",emp.getClientName()+"",emp.getItemPrice().toString()+"", emp.getItemId().toString()});
            
        }
//        mod.setColumnCount(3);
        return mod;
    }
    
    public static int insertItem(String name, int manufacturer, String price){
       Item c = new Item();
       c.setItemName(name);
       c.setItemClientNumber(manufacturer);
       c.setItemPrice(Double.parseDouble(price));
       c.setItemAddDate(new GregorianCalendar().getTime());
       c.setItemAddUser(System.getProperty("userName"));
       return (Item.addItem(c));            
    }
    
    public static int editItem(String name, int manufacturer, String price, String number){
       Item c = new Item();
       c.setItemName(name);
       c.setItemClientNumber(manufacturer);
       c.setItemPrice(Double.parseDouble(price));
       c.setItemId(Integer.parseInt(number));
       c.setItemEditDate(new GregorianCalendar().getTime());
       c.setItemEditUser(System.getProperty("userName"));
       return (Item.editItem(c));            
          
    }
    
    public static DefaultTableModel getInventoryTableData(int supplierNumber){
       DefaultTableModel mod = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
       
        mod.setColumnIdentifiers(new String[] {"Item Name","Item Price","Quantity As Of", "Date"});
        ArrayList<Item> arrItems = Item.getSupplierItemList(supplierNumber);
        for(Item emp: arrItems){
            String facQuant = FractionAction.convertToFraction(emp.getItemCurrentQuantity());
           mod.addRow(new String[] {emp.getItemName()+"",emp.getItemPrice().toString()+"", facQuant, Formats.dateFormatDays.format(emp.getItemDateAsOf())});
            
        }
//        mod.setColumnCount(3);
        return mod;
    }
    
    
    public static DefaultTableModel getInventoryTableData(int supplierNumber,int locationId){
       DefaultTableModel mod = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
       
        mod.setColumnIdentifiers(new String[] {"Item Name","Item Price (Price List)","Quantity As Of", "Date"});
        ArrayList<Item> arrItems = Item.getSupplierItemList(supplierNumber, locationId);
        for(Item emp: arrItems){
            String faquant = FractionAction.convertToFraction(emp.getItemCurrentQuantity());
           mod.addRow(new String[] {emp.getItemName()+"",Formats.centavoDecimal.format(emp.getItemPrice()), faquant, Formats.dateFormatDays2.format(emp.getItemDateAsOf())});
            
        }
//        mod.setColumnCount(3);
        return mod;
    }
}
