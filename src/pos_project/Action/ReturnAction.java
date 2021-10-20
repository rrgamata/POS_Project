/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pos_project.Action;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import pos_project.classes.Collections;
import pos_project.classes.Formats;
import pos_project.classes.Invoice;
import pos_project.classes.Item;
import pos_project.classes.ReturnMain;
import pos_project.classes.Returns;
import pos_project.classes.SQLConnection;
import pos_project.classes.Stocks;

/**
 *
 * @author Cif3r
 */
public class ReturnAction {
    
    
     
      public static int insertReturnMain( int invoiceId, String total, String returnNo, int year, int month, int day, Connection con, int locationId) throws Exception{
       
       ReturnMain c = new ReturnMain();
       c.setReturnMainInvoiceId(invoiceId);
       c.setReturnMainTotal(Formats.centavoDecimal.parse(total).doubleValue());
       //IN FLAG
       GregorianCalendar cal = new GregorianCalendar();
       cal.set(GregorianCalendar.YEAR, year);
       cal.set(GregorianCalendar.MONTH, month);
       cal.set(GregorianCalendar.DATE, day);
       c.setReturnMainDate(cal.getTime());
//       c.setInvoiceDueDate(getDueDate(cal, paymentType));
       c.setReturnMainAddDate(new GregorianCalendar().getTime());
       c.setReturnMainAddUser(System.getProperty("userName").toString());
       c.setReturnMainLocationId(locationId);
       c.setReturnMainNumber(returnNo);
       return (ReturnMain.addReturnMain(c, con));
                   
    }
     
      
    public static int editReturn( int invoiceId, String total, String returnNo, int year, int month, int day,int locationId, Connection con, int returnId)throws Exception{
       
      ReturnMain c = ReturnMain.getReturnMain(returnId);
       
//       c.setReturnMainInvoiceId(invoiceId);
       c.setReturnMainTotal(Formats.centavoDecimal.parse(total).doubleValue());
       //IN FLAG
       GregorianCalendar cal = new GregorianCalendar();
       cal.set(GregorianCalendar.YEAR, year);
       cal.set(GregorianCalendar.MONTH, month);
       cal.set(GregorianCalendar.DATE, day);
       c.setReturnMainDate(cal.getTime());
//       c.setInvoiceDueDate(getDueDate(cal, paymentType));
       c.setReturnMainEditDate(new GregorianCalendar().getTime());
       c.setReturnMainEditUser(System.getProperty("userName").toString());
       c.setReturnMainLocationId(locationId);
       c.setReturnMainNumber(returnNo);
       return (ReturnMain.editReturnMain(c, con));
                   
    }   
    
    public static int voidReturn( int returnId, Connection con)throws Exception{
       
      ReturnMain c = ReturnMain.getReturnMain(returnId);
       
//       c.setReturnMainInvoiceId(invoiceId);
       
//       c.setInvoiceDueDate(getDueDate(cal, paymentType));
       c.setReturnMainEditDate(new GregorianCalendar().getTime());
       c.setReturnMainEditUser(System.getProperty("userName").toString());
       
       return (ReturnMain.deleteReturnMain(c, con));
                   
    }   
       
    public static DefaultTableModel getMainTableData(){
       DefaultTableModel mod = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
       
//        mod.setColumnIdentifiers(new String[] {"Invoice #","IN-OUT","Client","Payment Type","Total Balance", "Transaction", "Date", "Date Due", "Added by", "Add Date", "Edited by", "Edit Date", "invoice number"});
        mod.setColumnIdentifiers(new String[] {"Return #","Invoice #","Transaction","Client", "Date", "Added by", "Add Date", "return id"});
        int quantity = 0;
        ArrayList<ReturnMain> arrClients = ReturnMain.getReturnList();
        for(ReturnMain emp: arrClients){
        
           
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
        
            
            String addDate;
            String editDate;
            
            if(emp.getReturnMainAddDate() == null){
                addDate = "-";
            }else{
                addDate = Formats.dateFormatDays2.format(emp.getReturnMainAddDate());
            }
            
//           mod.addRow(new String[] {emp.getInvoiceNumber()+"",cType+"",emp.getClientName()+"",payment+"",emp.getInvoiceTotalPrice()+"",cType+"",Formats.dateFormatMinutes.format(emp.getInvoiceDate())+"",
//               dueDate, emp.getInvoiceAddUser(),addDate, emp.getInvoiceEditUser(),editDate, emp.getInvoiceId()+""});
           mod.addRow(new String[] {emp.getReturnMainNumber()+"",emp.getInvoiceNumber()+"","Return",emp.getClientName()+"",Formats.dateFormatDays2.format(emp.getReturnMainDate())+"",
                emp.getReturnMainAddUser(),addDate, emp.getReturnMainId() +""});
            
        }
        return mod;
    }
    
    public static String getInvoiceType(int invoiceType){
        
         switch (invoiceType) {
                case 1: return ("IN");
//                    break;
                default: return("OUT");
            }
//        return type;
    }
     
 //Return Input
 public static int returnSQLLogic(int invoiceId, String total, String returnNumber, ArrayList<Returns> returnList, int year, int month, int day, int locationId, boolean outFlg, Invoice inv ){   
     
     return returnSQLLogic(invoiceId, total, returnNumber, returnList, year, month, day, locationId, outFlg,  false, inv );
 }
    
    
 //New Return INPUT with create collection logic
 public static int returnSQLLogic(int invoiceId, String total, String returnNumber, ArrayList<Returns> returnList, int year, int month, int day, int locationId, boolean outFlg, boolean hasCreateCollection, Invoice inv ){
    Connection con = SQLConnection.getSQLConnection();
    int success = 1;
    try{
//        Connection con = SQLConnection.getSQLConnection();
        ArrayList<Item> itemList = new ArrayList<Item>();
        ArrayList<Stocks> newStockList = new ArrayList<Stocks>();
        ArrayList<Stocks> existingStockList = new ArrayList<Stocks>();
        con.setAutoCommit(false);
//        Double balance = Double.parseDouble(Formats.centavoDecimal.parse(total));
        Double totalAmount = Formats.centavoDecimal.parse(total).doubleValue();
//        balance-= Invoice.getInvoiceBalance(invoiceNumber,con);
        
        success = ReturnAction.insertReturnMain(invoiceId, total, returnNumber, year, month, day,con, locationId);   
        
         GregorianCalendar cal = new GregorianCalendar();
         cal.set(GregorianCalendar.YEAR, year);
         cal.set(GregorianCalendar.MONTH, month);
         cal.set(GregorianCalendar.DATE, day);
         
            int returnId = ReturnMain.getLatestReturn(con);
            for(Returns t: returnList){
                boolean exist = false;
                Double quantityAsOf = 0.0;
                Double stockQuantity = 0.0;
                Item i = Item.getItem(t.getItemId()+"", con);
                int nExist = Stocks.checkStocksExist(i.getItemId().toString(), locationId+"", con);
                Stocks s = new Stocks();
                s.setStocksItemId(i.getItemId());
                s.setStocksLocationId(locationId);
               
                
                //for example 2 bananas with different prices
                for(Item item : itemList){
                    if(item.getItemId().equals( i.getItemId())){
                        exist = true;
                        boolean isNew = false;
                        int newCheck = checkStockArrayList(i.getItemId(), locationId, newStockList);
                        int existingCheck = checkStockArrayList(i.getItemId(), locationId, existingStockList);
                        if(newCheck > -1){
                            isNew = true;
                        }
                        if(isNew){
                            s = newStockList.get(newCheck);
                        } else{
                            s = existingStockList.get(existingCheck);
                        }
                        stockQuantity = s.getStocksQuantity();
                        if(outFlg){
                            quantityAsOf = item.getItemCurrentQuantity()+t.getReturnsQuantity();
                            stockQuantity = stockQuantity+t.getReturnsQuantity();
                        } else {
                            quantityAsOf = item.getItemCurrentQuantity()-t.getReturnsQuantity();
                            stockQuantity = stockQuantity-t.getReturnsQuantity();
                        }
                        s.setStocksQuantity(stockQuantity);
                        item.setItemCurrentQuantity(quantityAsOf);
                        if(isNew){
                            newStockList.remove(newCheck);
                            newStockList.add(s);
                        } else {
                            existingStockList.remove(existingCheck);
                            existingStockList.add(s);
                        }
                        
                    }
                }
                
                //FirstTime input for example one case of banana
                if(!exist){
                  if(nExist > 0 ){
                    s = Stocks.getStocks(i.getItemId().toString(), locationId+"");
//                    s = Stocks.calculateStocks(i.getItemId().toString(), locationId+"");
                    stockQuantity = s.getStocksQuantity();
                  } 
                   if(outFlg){
                      quantityAsOf = i.getItemCurrentQuantity()+t.getReturnsQuantity();
                      stockQuantity = stockQuantity+t.getReturnsQuantity();
                   } else {
                      quantityAsOf = i.getItemCurrentQuantity()-t.getReturnsQuantity();
                      stockQuantity = stockQuantity-t.getReturnsQuantity();
                   }
                   i.setItemCurrentQuantity(quantityAsOf);
                   s.setStocksQuantity(stockQuantity);
                   itemList.add(i);
                   if(nExist > 0){
                      existingStockList.add(s);
                   } else{
                      newStockList.add(s);
                   }
                }
                
                t.setReturnsDate(cal.getTime());
                t.setReturnMainId(returnId);
                t.setReturnsAddDate(new GregorianCalendar().getTime());
                t.setReturnsAddUser(System.getProperty("userName"));
//                t.setTransactionQuantityAsOf(quantityAsOf);
                
                 
//              success = Item.updateItemQuantity(t.getTransactionItemNumber(), t.getTransactionQuantityAsOf(), Formats.dateFormatDays.format(new GregorianCalendar().getTime()), con);
               if(hasCreateCollection){
                    Collections c = new Collections();
                    c.setCollectionInvoiceId(inv.getInvoiceId());
                    c.setCollectionInvoiceNumber(inv.getInvoiceNumber());
                    c.setCollectionOrNumber("RTN");
//                c.setCollectionNumber(i.getItemName()+"("+t.getReturnsQuantity()+")");
                    c.setCollectionAddUser(System.getProperty("username"));
                    c.setCollectionDate(cal.getTime());
                    c.setCollectionAmount(t.getReturnsAmount()*t.getReturnsQuantity());
                    c.setCollectionAddDate(new GregorianCalendar().getTime());
                    c.setCollectionClearedFlag(new Short("1"));
                    Double balance = Collections.getCollectionAmountUsingId(inv.getInvoiceId()+""); 
                    balance = inv.getInvoiceTotalPrice() - balance - c.getCollectionAmount();
                    c.setCollectionBalanceAsOf(balance);
                    Collections.addCollection(c, new Short("3"), i.getItemName()+"("+t.getReturnsQuantity()+")", con);
                
                    int collectionId = Collections.getLatestCollection(con);
                
                        success = Returns.addReturnsWithCollection(t,collectionId, con);
                 
                
                
                    Short paidFlag;
                    if(balance <= 0){
                        paidFlag = new Short("1");
                    }else{
                        paidFlag = new Short("0");
                    }
                
                    Invoice.updateInvoiceBalance(invoiceId, balance, paidFlag, Formats.dateFormatDays.format(c.getCollectionDate()), con);
               } else {
                     success = Returns.addReturns(t, con);
               }
                 
            }
            for(Item items: itemList){
                   success = Item.updateItemQuantity(items.getItemId(), items.getItemCurrentQuantity(), Formats.dateFormatDays.format(new GregorianCalendar().getTime()), con);
            }
            for(Stocks s: newStockList){
                success = Stocks.insertStocks(s.getStocksItemId().toString(), s.getStocksLocationId().toString(), s.getStocksQuantity().toString(), con);
            }
            for(Stocks s: existingStockList){
//                success = Stocks.updateStocks(s.getStocksItemId().toString(), s.getStocksLocationId().toString(), s.getStocksQuantity().toString(),s.getStocksId().toString(), con);
                success = Stocks.deleteStocks(s.getStocksId().toString(), con);
                success = Stocks.insertStocks(s.getStocksItemId().toString(), s.getStocksLocationId().toString(), s.getStocksQuantity().toString(), con);
            }
            con.commit();
    } catch (Exception e){
            try {
                e.printStackTrace();
                con.rollback();
                return success;
            } catch (SQLException ex) {
                Logger.getLogger(ReturnAction.class.getName()).log(Level.SEVERE, null, ex);
            }
    } finally {
            try {
                
                con.close();
                return success;
            } catch (SQLException ex) {
                Logger.getLogger(ReturnAction.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
        return success;
//            this.dispose();
    }

public static String getPaymentType( int paymentType){
//    GregorianCalendar cal = calendar;
    switch(paymentType){
            case 1:
//               cal.add(GregorianCalendar.DAY_OF_MONTH, 7);
               return("COD");
           case 2:
//               cal.add(GregorianCalendar.DAY_OF_MONTH, 7);
               return("7 days");
//               c.setInvoiceDueDate(cal.getTime());
//               break;
           case 3:
//               cal.add(GregorianCalendar.DAY_OF_MONTH, 15);
               return("15 days");
//               c.setInvoiceDueDate(cal.getTime());
//               break;
           case 4:
//               cal.add(GregorianCalendar.DAY_OF_MONTH, 30);
               return("30 days");
//               c.setInvoiceDueDate(cal.getTime());
//               break;
           case 5:
//               cal.add(GregorianCalendar.DAY_OF_MONTH, 45);
               return("45 days");
//               c.setInvoiceDueDate(cal.getTime());
//               break;
           case 6:
//               cal.add(GregorianCalendar.DAY_OF_MONTH, 60);
               return("60 days");
//               c.setInvoiceDueDate(cal.getTime());
//               break;
           case 7:
//               cal.add(GregorianCalendar.DAY_OF_MONTH, 90);
               return("90 days");
//               c.setInvoiceDueDate(cal.getTime());
//               break;
           case 8:
//               cal.add(GregorianCalendar.DAY_OF_MONTH, 120);
               return("120 days");
//               c.setInvoiceDueDate(cal.getTime());
//               break;
           case 9:
//               cal.add(GregorianCalendar.DAY_OF_MONTH, 150);
               return("150 days");
//               c.setInvoiceDueDate(cal.getTime());
//               break;
           case 10:
//               cal.add(GregorianCalendar.DAY_OF_MONTH, 180);
               return("180 days");
//               c.setInvoiceDueDate(cal.getTime());
//               break;
           case 69:
               return("Transfer");
               
           default:
               return("OTC");
//               c.setInvoiceDueDate(cal.getTime());
               
       }
    
    
//    return cal.getTime();
    }

private static int checkStockArrayList(int itemId, int locationid, ArrayList<Stocks> locationArray){
   int result = -1;
   for(int i = 0; i< locationArray.size(); i++){
       Stocks s = locationArray.get(i);
       if( itemId == s.getStocksItemId() && locationid == s.getStocksLocationId()){
           return result = i;
       }
   }
   return result;
}

public static DefaultTableModel getReturnListTableData(String invoiceNumber){
       DefaultTableModel mod = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
      
//        mod.setColumnIdentifiers(new String[] {"Collection Date","Particulars","Amount","Check Date","Cleared","Add Date","Added by", "Edited Date", "Edited by", "collection id"});
        mod.setColumnIdentifiers(new String[] {"Return #" ,"Return Date","Add Date","Added by","Edit Date","Edited by" , "return id"});
//        ArrayList<Collections> arrItems = Collections.getInvoiceCollectionsUsingId(invoiceNumber);
        ArrayList<ReturnMain> arrItems = ReturnMain.getInvoiceRetuirnsUsingId(invoiceNumber);
//        Double balance = new Double("0");
        for(ReturnMain emp: arrItems){
//                balance += emp.getCharge();
//                balance -= emp.getCredit();
//                String sCharge;
//                if(emp.getCharge() == 0){
//                    mod.addRow(new String[] {Formats.dateFormatDays.format(emp.getLedgerDate())+"",emp.getParticular()+"", "-", emp.getCredit()+"",balance+""});
//                } else {
//                    mod.addRow(new String[] {Formats.dateFormatDays.format(emp.getLedgerDate())+"",emp.getParticular()+"", emp.getCharge()+"", "-",balance+""});
            String addDate = "-";
            String editDate = "-";
            String collectionDate = "-";
            
            if(emp.getReturnMainDate() != null){
                collectionDate = Formats.dateFormatDays.format(emp.getReturnMainDate());
            }
            
            if(emp.getReturnMainAddDate() != null){
                addDate = Formats.dateFormatDays.format(emp.getReturnMainAddDate());
            }
            if(emp.getReturnMainEditDate() != null){
                editDate = Formats.dateFormatDays.format(emp.getReturnMainEditDate());
            }
            
//                mod.addRow(new String[] {collectionDate+"",emp.getParticular()+"", emp.getCollectionAmount()+"", checkDate, cleared,
//                    addDate,emp.getCollectionAddUser(), editDate, emp.getCollectionEditUser(), emp.getCollectionId()+""});
            mod.addRow(new String[] {emp.getReturnMainNumber(),collectionDate+"", addDate,emp.getReturnMainAddUser(), 
                editDate,emp.getReturnMainEditUser(), emp.getReturnMainId()+""});
                
               
        }
//        mod.setColumnCount(3);
        return mod;
    }

public static ArrayList<Returns> checkDeletedItems(ArrayList<Returns> addList, ArrayList<Returns> delList){
        ArrayList<Returns> nDelList = new ArrayList<Returns>();
        nDelList = delList;
         for(Returns add: addList){
            for(int i =0; i< delList.size(); i++){
                Returns del = delList.get(i);
                int addNum = add.getItemId();
                int delNum = del.getItemId();
                if( addNum == delNum){
                    nDelList.get(i).setDoubleFlag(new Short("1"));
                }
            } 
         }
        return nDelList;
    }

 public static void editReturnSQLLogic(int invoiceId, int returnId, String total, String returnNumber, ArrayList<Returns> returnList, int year, int month, int day,ArrayList<Returns> delList,boolean outFlg, int locationId, Invoice inv ){
    Connection con = SQLConnection.getSQLConnection();
    try{
//        Connection con = SQLConnection.getSQLConnection();
        ArrayList<Item> itemList = new ArrayList<Item>();
        ArrayList<Stocks> existingStockList = new ArrayList<Stocks>();
        ArrayList<Stocks> newStockList = new ArrayList<Stocks>();
        con.setAutoCommit(false);
        Double totalAmount = Formats.centavoDecimal.parse(total).doubleValue();
//        balance -= Invoice.getInvoiceBalance(invoiceId+"",con);
        int success = -1; 
//        if(outFlg){
//         InvoiceAction.editOutInvoice(invoiceId, clientId, total, balance, invoiceNumber, receivableFlg, paymentType,year, month, day,con);   
//        } else {
//         InvoiceAction.editInInvoice(invoiceId, clientId, total, balance, invoiceNumber, receivableFlg, paymentType,year, month, day, con);   
//        }
        ReturnAction.editReturn(invoiceId, total, total, year, month, day, locationId, con, returnId);
         GregorianCalendar cal = new GregorianCalendar();
         cal.set(GregorianCalendar.YEAR, year);
         cal.set(GregorianCalendar.MONTH, month);
         cal.set(GregorianCalendar.DATE, day);
//            int invoiceId = Invoice.getLatestInvoice(con);
         ArrayList<Returns> newDelList = checkDeletedItems(returnList, delList);
         for(Returns t: newDelList){
                boolean exist = false;
                Double quantityAsOf = 0.0;
                Double stockQuantity = 0.0;
                Item i = Item.getItem(t.getItemId()+"", con);
                int nExist = Stocks.checkStocksExist(i.getItemId().toString(), locationId+"", con);
                Stocks s = new Stocks();
                s.setStocksItemId(i.getItemId());
                s.setStocksLocationId(locationId);
               
                
                //for example 2 bananas with different prices
                for(Item item : itemList){
                    if(item.getItemId().equals( i.getItemId())){
                        exist = true;
                        boolean isNew = false;
                        int newCheck = checkStockArrayList(i.getItemId(), locationId, newStockList);
                        int existingCheck = checkStockArrayList(i.getItemId(), locationId, existingStockList);
                        if(newCheck > -1){
                            isNew = true;
                        }
                        if(isNew){
                            s = newStockList.get(newCheck);
                        } else{
                            s = existingStockList.get(existingCheck);
                        }
                        stockQuantity = s.getStocksQuantity();
                        if(outFlg){
                            quantityAsOf = item.getItemCurrentQuantity()-t.getReturnsQuantity();
                            stockQuantity = stockQuantity-t.getReturnsQuantity();
                        } else {
                            quantityAsOf = item.getItemCurrentQuantity()+t.getReturnsQuantity();
                            stockQuantity = stockQuantity+t.getReturnsQuantity();
                        }
                        s.setStocksQuantity(stockQuantity);
                        item.setItemCurrentQuantity(quantityAsOf);
                        if(isNew){
                            newStockList.remove(newCheck);
                            newStockList.add(s);
                        } else {
                            existingStockList.remove(existingCheck);
                            existingStockList.add(s);
                        }
                        
                    }
                }
                
                //FirstTime input for example one case of banana
                if(!exist){
                  if(nExist > 0 ){
                    s = Stocks.getStocks(i.getItemId().toString(), locationId+"");
//                    s = Stocks.calculateStocks(i.getItemId().toString(), locationId+"");
                    stockQuantity = s.getStocksQuantity();
                  } 
                   if(outFlg){
                      quantityAsOf = i.getItemCurrentQuantity()-t.getReturnsQuantity();
                      stockQuantity = stockQuantity-t.getReturnsQuantity();
                   } else {
                      quantityAsOf = i.getItemCurrentQuantity()+t.getReturnsQuantity();
                      stockQuantity = stockQuantity+t.getReturnsQuantity();
                   }
                   i.setItemCurrentQuantity(quantityAsOf);
                   s.setStocksQuantity(stockQuantity);
                   itemList.add(i);
                   if(nExist > 0){
                      existingStockList.add(s);
                   } else{
                      newStockList.add(s);
                   }
                }
                
                t.setReturnsDate(cal.getTime());
                t.setReturnMainId(returnId);
                t.setReturnEditDate(new GregorianCalendar().getTime());
                t.setReturnEditUser(System.getProperty("userName"));
//                t.setTransactionQuantityAsOf(quantityAsOf);
                
                
//                Invoice invo = Invoice.getInvoiceWithId(invoiceId+"");
//                success = Item.updateItemQuantity(t.getTransactionItemNumber(), t.getTransactionQuantityAsOf(), Formats.dateFormatDays.format(new GregorianCalendar().getTime()), con);
//                Collections c = new Collections();
//                c.setCollectionInvoiceId(invoiceId);
//                c.setCollectionInvoiceNumber(inv.getInvoiceNumber());
//                c.setCollectionOrNumber("RTN");
////                c.setCollectionNumber(i.getItemName()+"("+t.getReturnsQuantity()+")");
//                c.setCollectionAddUser(System.getProperty("username"));
//                c.setCollectionDate(cal.getTime());
//                c.setCollectionAmount(t.getReturnsAmount()*t.getReturnsQuantity());
//                c.setCollectionAddDate(new GregorianCalendar().getTime());
//                c.setCollectionClearedFlag(new Short("1"));
                
                
                if(t.getReturnCollectionNumber() != null){
         
                    Collections c = Collections.getCollection(t.getReturnCollectionNumber()+"");
                    Double balance = Collections.getCollectionAmountUsingId(invoiceId+""); 
                    balance = inv.getInvoiceTotalPrice() - balance + c.getCollectionAmount();
                                        
                    Collections.deleteCollection(t.getReturnCollectionNumber()+"", new GregorianCalendar().getTime(),con);
                    Short paidFlag;
                    if(balance <= 0){
                        paidFlag = new Short("1");
                    }else{
                        paidFlag = new Short("0");
                    }
                
                    Invoice.updateInvoiceBalance(invoiceId, balance, paidFlag, Formats.dateFormatDays.format(c.getCollectionDate()), con);
                }
                
                success = Returns.deleteReturns(t, con);
                
                
            }
            for(Item items: itemList){
                   success = Item.updateItemQuantity(items.getItemId(), items.getItemCurrentQuantity(), Formats.dateFormatDays.format(new GregorianCalendar().getTime()), con);
            }
            for(Stocks s: newStockList){
                success = Stocks.insertStocks(s.getStocksItemId().toString(), s.getStocksLocationId().toString(), s.getStocksQuantity().toString(), con);
            }
            for(Stocks s: existingStockList){
//                success = Stocks.updateStocks(s.getStocksItemId().toString(), s.getStocksLocationId().toString(), s.getStocksQuantity().toString(),s.getStocksId().toString(), con);
                success = Stocks.deleteStocks(s.getStocksId().toString(), con);
                success = Stocks.insertStocks(s.getStocksItemId().toString(), s.getStocksLocationId().toString(), s.getStocksQuantity().toString(), con);
            }
            
            
             for(Returns t: returnList){
                 if(t.getReturnsId()==null){
                boolean exist = false;
                Double quantityAsOf = 0.0;
                Double stockQuantity = 0.0;
                Item i = Item.getItem(t.getItemId()+"", con);
                int nExist = Stocks.checkStocksExist(i.getItemId().toString(), locationId+"", con);
                Stocks s = new Stocks();
                s.setStocksItemId(i.getItemId());
                s.setStocksLocationId(locationId);
               
                
                //for example 2 bananas with different prices
                for(Item item : itemList){
                    if(item.getItemId().equals( i.getItemId())){
                        exist = true;
                        boolean isNew = false;
                        int newCheck = checkStockArrayList(i.getItemId(), locationId, newStockList);
                        int existingCheck = checkStockArrayList(i.getItemId(), locationId, existingStockList);
                        if(newCheck > -1){
                            isNew = true;
                        }
                        if(isNew){
                            s = newStockList.get(newCheck);
                        } else{
                            s = existingStockList.get(existingCheck);
                        }
                        stockQuantity = s.getStocksQuantity();
                        if(outFlg){
                            quantityAsOf = item.getItemCurrentQuantity()+t.getReturnsQuantity();
                            stockQuantity = stockQuantity+t.getReturnsQuantity();
                        } else {
                            quantityAsOf = item.getItemCurrentQuantity()-t.getReturnsQuantity();
                            stockQuantity = stockQuantity-t.getReturnsQuantity();
                        }
                        s.setStocksQuantity(stockQuantity);
                        item.setItemCurrentQuantity(quantityAsOf);
                        if(isNew){
                            newStockList.remove(newCheck);
                            newStockList.add(s);
                        } else {
                            existingStockList.remove(existingCheck);
                            existingStockList.add(s);
                        }
                        
                    }
                }
                
                //FirstTime input for example one case of banana
                if(!exist){
                  if(nExist > 0 ){
                    s = Stocks.getStocks(i.getItemId().toString(), locationId+"");
//                    s = Stocks.calculateStocks(i.getItemId().toString(), locationId+"");
                    stockQuantity = s.getStocksQuantity();
                  } 
                   if(outFlg){
                      quantityAsOf = i.getItemCurrentQuantity()+t.getReturnsQuantity();
                      stockQuantity = stockQuantity+t.getReturnsQuantity();
                   } else {
                      quantityAsOf = i.getItemCurrentQuantity()-t.getReturnsQuantity();
                      stockQuantity = stockQuantity-t.getReturnsQuantity();
                   }
                   i.setItemCurrentQuantity(quantityAsOf);
                   s.setStocksQuantity(stockQuantity);
                   itemList.add(i);
                   if(nExist > 0){
                      existingStockList.add(s);
                   } else{
                      newStockList.add(s);
                   }
                }
                
                t.setReturnsDate(cal.getTime());
                t.setReturnMainId(returnId);
                t.setReturnsAddDate(new GregorianCalendar().getTime());
                t.setReturnsAddUser(System.getProperty("userName"));
//                t.setTransactionQuantityAsOf(quantityAsOf);
                
                
                    Collections c = new Collections();
                    c.setCollectionInvoiceId(inv.getInvoiceId());
                    c.setCollectionInvoiceNumber(inv.getInvoiceNumber());
                    c.setCollectionOrNumber("RTN");
//                c.setCollectionNumber(i.getItemName()+"("+t.getReturnsQuantity()+")");
                    c.setCollectionAddUser(System.getProperty("username"));
                    c.setCollectionDate(cal.getTime());
                    c.setCollectionAmount(t.getReturnsAmount()*t.getReturnsQuantity());
                    c.setCollectionAddDate(new GregorianCalendar().getTime());
                    c.setCollectionClearedFlag(new Short("1"));
                    Double balance = Collections.getCollectionAmountUsingId(inv.getInvoiceId()+""); 
                    balance = inv.getInvoiceTotalPrice() - balance - c.getCollectionAmount();
                    c.setCollectionBalanceAsOf(balance);
                    Collections.addCollection(c, new Short("3"), i.getItemName()+"("+t.getReturnsQuantity()+")", con);
                
                    int collectionId = Collections.getLatestCollection(con);
                
                    success = Returns.addReturnsWithCollection(t,collectionId, con);
                 
                
                
                Short paidFlag;
                if(balance <= 0){
                    paidFlag = new Short("1");
                }else{
                    paidFlag = new Short("0");
                }
                
                Invoice.updateInvoiceBalance(invoiceId, balance, paidFlag, Formats.dateFormatDays.format(c.getCollectionDate()), con);
                
            }
            for(Item items: itemList){
                   success = Item.updateItemQuantity(items.getItemId(), items.getItemCurrentQuantity(), Formats.dateFormatDays.format(new GregorianCalendar().getTime()), con);
            }
            for(Stocks s: newStockList){
                success = Stocks.insertStocks(s.getStocksItemId().toString(), s.getStocksLocationId().toString(), s.getStocksQuantity().toString(), con);
            }
            for(Stocks s: existingStockList){
//                success = Stocks.updateStocks(s.getStocksItemId().toString(), s.getStocksLocationId().toString(), s.getStocksQuantity().toString(),s.getStocksId().toString(), con);
                success = Stocks.deleteStocks(s.getStocksId().toString(), con);
                success = Stocks.insertStocks(s.getStocksItemId().toString(), s.getStocksLocationId().toString(), s.getStocksQuantity().toString(), con);
            }
             }
            
            con.commit();
    } catch (Exception e){
            try {
                e.printStackTrace();
                con.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(InvoiceAction.class.getName()).log(Level.SEVERE, null, ex);
            }
    } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(InvoiceAction.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
        
//            this.dispose();
    }
  
 
 
 public static void voidReturnSQLLogic(int invoiceId, int returnId, ArrayList<Returns> delList,int locationId, boolean outFlg, Invoice inv ){
    Connection con = SQLConnection.getSQLConnection();
    try{
//        Connection con = SQLConnection.getSQLConnection();
        ArrayList<Item> itemList = new ArrayList<Item>();
        ArrayList<Stocks> existingStockList = new ArrayList<Stocks>();
        ArrayList<Stocks> newStockList = new ArrayList<Stocks>();
        con.setAutoCommit(false);
       
//        balance -= Invoice.getInvoiceBalance(invoiceId+"",con);
        int success = -1; 
//        if(outFlg){
//         InvoiceAction.editOutInvoice(invoiceId, clientId, total, balance, invoiceNumber, receivableFlg, paymentType,year, month, day,con);   
//        } else {
//         InvoiceAction.editInInvoice(invoiceId, clientId, total, balance, invoiceNumber, receivableFlg, paymentType,year, month, day, con);   
//        }
        ReturnAction.voidReturn( returnId, con);
         GregorianCalendar cal = new GregorianCalendar();
         
//            int invoiceId = Invoice.getLatestInvoice(con);
         
         for(Returns t: delList){
                boolean exist = false;
                Double quantityAsOf = 0.0;
                Double stockQuantity = 0.0;
                Item i = Item.getItem(t.getItemId()+"", con);
                int nExist = Stocks.checkStocksExist(i.getItemId().toString(), locationId+"", con);
                Stocks s = new Stocks();
                s.setStocksItemId(i.getItemId());
                s.setStocksLocationId(locationId);
               
                
                //for example 2 bananas with different prices
                for(Item item : itemList){
                    if(item.getItemId().equals( i.getItemId())){
                        exist = true;
                        boolean isNew = false;
                        int newCheck = checkStockArrayList(i.getItemId(), locationId, newStockList);
                        int existingCheck = checkStockArrayList(i.getItemId(), locationId, existingStockList);
                        if(newCheck > -1){
                            isNew = true;
                        }
                        if(isNew){
                            s = newStockList.get(newCheck);
                        } else{
                            s = existingStockList.get(existingCheck);
                        }
                        stockQuantity = s.getStocksQuantity();
                        if(outFlg){
                            quantityAsOf = item.getItemCurrentQuantity()-t.getReturnsQuantity();
                            stockQuantity = stockQuantity-t.getReturnsQuantity();
                        } else {
                            quantityAsOf = item.getItemCurrentQuantity()+t.getReturnsQuantity();
                            stockQuantity = stockQuantity+t.getReturnsQuantity();
                        }
                        s.setStocksQuantity(stockQuantity);
                        item.setItemCurrentQuantity(quantityAsOf);
                        if(isNew){
                            newStockList.remove(newCheck);
                            newStockList.add(s);
                        } else {
                            existingStockList.remove(existingCheck);
                            existingStockList.add(s);
                        }
                        
                    }
                }
                
                //FirstTime input for example one case of banana
                if(!exist){
                  if(nExist > 0 ){
                    s = Stocks.getStocks(i.getItemId().toString(), locationId+"");
//                    s = Stocks.calculateStocks(i.getItemId().toString(), locationId+"");
                    stockQuantity = s.getStocksQuantity();
                  } 
                   if(outFlg){
                      quantityAsOf = i.getItemCurrentQuantity()-t.getReturnsQuantity();
                      stockQuantity = stockQuantity-t.getReturnsQuantity();
                   } else {
                      quantityAsOf = i.getItemCurrentQuantity()+t.getReturnsQuantity();
                      stockQuantity = stockQuantity+t.getReturnsQuantity();
                   }
                   i.setItemCurrentQuantity(quantityAsOf);
                   s.setStocksQuantity(stockQuantity);
                   itemList.add(i);
                   if(nExist > 0){
                      existingStockList.add(s);
                   } else{
                      newStockList.add(s);
                   }
                }
                
                t.setReturnsDate(cal.getTime());
                t.setReturnMainId(returnId);
                t.setReturnEditDate(new GregorianCalendar().getTime());
                t.setReturnEditUser(System.getProperty("userName"));
//                t.setTransactionQuantityAsOf(quantityAsOf);
                
                
//                Invoice invo = Invoice.getInvoiceWithId(invoiceId+"");
//                success = Item.updateItemQuantity(t.getTransactionItemNumber(), t.getTransactionQuantityAsOf(), Formats.dateFormatDays.format(new GregorianCalendar().getTime()), con);
//                Collections c = new Collections();
//                c.setCollectionInvoiceId(invoiceId);
//                c.setCollectionInvoiceNumber(inv.getInvoiceNumber());
//                c.setCollectionOrNumber("RTN");
////                c.setCollectionNumber(i.getItemName()+"("+t.getReturnsQuantity()+")");
//                c.setCollectionAddUser(System.getProperty("username"));
//                c.setCollectionDate(cal.getTime());
//                c.setCollectionAmount(t.getReturnsAmount()*t.getReturnsQuantity());
//                c.setCollectionAddDate(new GregorianCalendar().getTime());
//                c.setCollectionClearedFlag(new Short("1"));
                
                
                if(t.getReturnCollectionNumber() != null){
         
                    Collections c = Collections.getCollection(t.getReturnCollectionNumber()+"");
                    Double balance = Collections.getCollectionAmountUsingId(invoiceId+""); 
                    balance = inv.getInvoiceTotalPrice() - balance + c.getCollectionAmount();
                                        
                    Collections.deleteCollection(t.getReturnCollectionNumber()+"", new GregorianCalendar().getTime(),con);
                    Short paidFlag;
                    if(balance <= 0){
                        paidFlag = new Short("1");
                    }else{
                        paidFlag = new Short("0");
                    }
                
                    Invoice.updateInvoiceBalance(invoiceId, balance, paidFlag, Formats.dateFormatDays.format(c.getCollectionDate()), con);
                }
                
                success = Returns.deleteReturns(t, con);
                
                
            }
            for(Item items: itemList){
                   success = Item.updateItemQuantity(items.getItemId(), items.getItemCurrentQuantity(), Formats.dateFormatDays.format(new GregorianCalendar().getTime()), con);
            }
            for(Stocks s: newStockList){
                success = Stocks.insertStocks(s.getStocksItemId().toString(), s.getStocksLocationId().toString(), s.getStocksQuantity().toString(), con);
            }
            for(Stocks s: existingStockList){
//                success = Stocks.updateStocks(s.getStocksItemId().toString(), s.getStocksLocationId().toString(), s.getStocksQuantity().toString(),s.getStocksId().toString(), con);
                success = Stocks.deleteStocks(s.getStocksId().toString(), con);
                success = Stocks.insertStocks(s.getStocksItemId().toString(), s.getStocksLocationId().toString(), s.getStocksQuantity().toString(), con);
            }
            
            con.commit();
    } catch (Exception e){
            try {
                e.printStackTrace();
                con.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(InvoiceAction.class.getName()).log(Level.SEVERE, null, ex);
            }
    } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(InvoiceAction.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
        
//            this.dispose();
    }

}
