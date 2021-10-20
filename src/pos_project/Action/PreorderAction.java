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
import pos_project.classes.Formats;
import pos_project.classes.Invoice;
import pos_project.classes.Item;
import pos_project.classes.Preorder;
import pos_project.classes.PreorderTransaction;
import pos_project.classes.SQLConnection;
import pos_project.classes.Stocks;
import pos_project.classes.Transaction;

/**
 *
 * @author Cif3r
 */
public class PreorderAction {
    
    
       
       public static int insertInvoice( int clientNumber, String price, Double balance, String receiptNo, boolean isReceivable, int year, int month, int day, Connection con, int locationId, boolean isOut) throws Exception{
       
       Preorder c = new Preorder();
       c.setPreorderNumber(receiptNo);
       c.setPreorderPrice(Formats.centavoDecimal.parse(price).doubleValue());
//       c.setInvoiceCurrentBalance(balance);
       
       c.setPreorderClientId(clientNumber);
       //IN FLAG
//       c.setInvoiceTypeFlag(Short.parseShort("1"));
       //1: CREDIT 0:CASH
//       if(isReceivable){
//           c.setInvoiceReceivableFlag(new Short("1"));
//           c.setInvoicePaidFlag(new Short("0"));
//       } else {
//           c.setInvoiceReceivableFlag(new Short("0"));
//           c.setInvoicePaidFlag(new Short("1"));
//       }
//       if(isOut){
//           c.setInvoiceTypeFlag(new Short("0"));
//       } else {
//           c.setInvoiceTypeFlag(new Short("1"));
//       }
       GregorianCalendar cal = new GregorianCalendar();
       cal.set(GregorianCalendar.YEAR, year);
       cal.set(GregorianCalendar.MONTH, month);
       cal.set(GregorianCalendar.DATE, day);
       c.setPreorderDate(cal.getTime());
//       c.setInvoiceDueDate(getDueDate(cal, paymentType));
       c.setPreorderAddDate(new GregorianCalendar().getTime());
       c.setPreorderAddUser(System.getProperty("userName"));
       c.setPreorderLocationId(locationId);
//       c.setInvoiceDriver(driverName);
       return (Preorder.addPreorder(c,con));
                   
    }
       
        public static int editInvoice( int invoiceId,int clientNumber, String price, String receiptNo, int year, int month, int day,int locationId, boolean isOut, Connection con)throws Exception{
       
       Preorder c = new Preorder();
       c.setPreorderId(invoiceId);
       c.setPreorderNumber(receiptNo);
       c.setPreorderPrice(Formats.centavoDecimal.parse(price).doubleValue());
//       c.setInvoiceCurrentBalance(balance);
//       c.setInvoicePaymentType(Short.parseShort(""+paymentType));
       c.setPreorderClientId(clientNumber);
       //IN FLAG
//       c.setInvoiceTypeFlag(Short.parseShort("1"));
       //1: CREDIT 0:CASH
//       if(isReceivable){
//           c.setInvoiceReceivableFlag(new Short("1"));
//           c.setInvoicePaidFlag(new Short("0"));
//       } else {
//           c.setInvoiceReceivableFlag(new Short("0"));
//           c.setInvoicePaidFlag(new Short("1"));
//       }
//       if(isOut){
//           c.setInvoiceTypeFlag(new Short("0"));
//       } else {
//           c.setInvoiceTypeFlag(new Short("1"));
//       }
//       c.setInvoiceTypeFlag(Short.parseShort("0"));
       GregorianCalendar cal = new GregorianCalendar();
       cal.set(GregorianCalendar.YEAR, year);
       cal.set(GregorianCalendar.MONTH, month);
       cal.set(GregorianCalendar.DATE, day);
       c.setPreorderDate(cal.getTime());
//       c.setInvoiceDueDate(getDueDate(cal, paymentType));
       c.setPreorderEditDate(new GregorianCalendar().getTime());
       c.setPreorderEditUser(System.getProperty("userName"));
       c.setPreorderLocationId(locationId);
//       c.setInvoiceDriver(driverName);
       return (Preorder.editPreorder(c,con));
                   
    }   
    
    public static DefaultTableModel getMainTableData(){
       DefaultTableModel mod = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
       
//        mod.setColumnIdentifiers(new String[] {"Invoice #","IN-OUT","Client","Payment Type","Total Balance", "Transaction", "Date", "Date Due", "Added by", "Add Date", "Edited by", "Edit Date", "invoice number"});
        mod.setColumnIdentifiers(new String[] {"PO #","Client","Date", "Added by", "Add Date", "Edited by", "Edit Date", "invoice number"});
        int quantity = 0;
        ArrayList<Preorder> arrClients = Preorder.getPreorderList();
        for(Preorder emp: arrClients){
//            String cType = getInvoiceType(emp.getInvoiceTypeFlag());
           
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
//            String payment = getPaymentType(emp.getInvoicePaymentType());
//            String dueDate;
            String addDate;
            String editDate;
//            if(emp.getInvoiceDueDate() == null || emp.getInvoicePaymentType().equals(new Short("0"))){
//                dueDate = "-";
//            }else{
//                dueDate =  Formats.dateFormatDays2.format(emp.getInvoiceDueDate());
//            }
            if(emp.getPreorderAddDate() == null){
                addDate = "-";
            }else{
                addDate = Formats.dateFormatDays2.format(emp.getPreorderAddDate());
            }
            if(emp.getPreorderEditDate() == null){
                editDate = "-";
            }else{
                editDate = Formats.dateFormatDays2.format(emp.getPreorderEditDate());
            }
//           mod.addRow(new String[] {emp.getInvoiceNumber()+"",cType+"",emp.getClientName()+"",payment+"",emp.getInvoiceTotalPrice()+"",cType+"",Formats.dateFormatMinutes.format(emp.getInvoiceDate())+"",
//               dueDate, emp.getInvoiceAddUser(),addDate, emp.getInvoiceEditUser(),editDate, emp.getInvoiceId()+""});
           mod.addRow(new String[] {emp.getPreorderNumber()+"",emp.getClientName()+"",Formats.dateFormatDays2.format(emp.getPreorderDate())+"",
                emp.getPreorderAddUser(),addDate, emp.getPreorderEditUser(),editDate, emp.getPreorderId()+""});
            
        }
        return mod;
    }
    
    public static DefaultTableModel getInvoiceTableData(int clientId){
       DefaultTableModel mod = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
       
//        mod.setColumnIdentifiers(new String[] {"Invoice #","IN-OUT","Client","Payment Type","Total Balance", "Transaction", "Date", "Date Due", "Added by", "Add Date", "Edited by", "Edit Date", "invoice number"});
//        mod.setColumnIdentifiers(new String[] {"Invoice #","Transaction","Client","Payment Type","Total Amount","Date", "Date Due", "Added by", "Add Date", "Edited by"
//                , "Edit Date", "invoice number"});
       mod.setColumnIdentifiers(new String[] {"Invoice #","Client","Total","Date", "Edited by"
                , "Edit Date", "invoice number"});
        int quantity = 0;
        ArrayList<Preorder> arrClients = Preorder.getAllPreorderWithClient(clientId);
        for(Preorder emp: arrClients){

            String addDate;
            String editDate;
            
            if(emp.getPreorderAddDate() == null){
                addDate = "-";
            }else{
                addDate = Formats.dateFormatDays2.format(emp.getPreorderAddDate());
            }
            if(emp.getPreorderEditDate() == null){
                editDate = "-";
            }else{
                editDate = Formats.dateFormatDays2.format(emp.getPreorderEditDate());
            }

            mod.addRow(new String[] {emp.getPreorderNumber()+"",emp.getClientName()+"",Formats.centavoDecimal.format(emp.getPreorderPrice())
                   ,Formats.dateFormatDays.format(emp.getPreorderDate())+"",emp.getPreorderEditUser(),editDate, emp.getPreorderId()+""});
            
        }
        return mod;
    }
    
    public static DefaultTableModel getAllInvoice(){
       DefaultTableModel mod = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
       
//        mod.setColumnIdentifiers(new String[] {"Invoice #","IN-OUT","Client","Payment Type","Total Balance", "Transaction", "Date", "Date Due", "Added by", "Add Date", "Edited by", "Edit Date", "invoice number"});
//        mod.setColumnIdentifiers(new String[] {"Invoice #","Transaction","Client","Payment Type","Total Amount","Date", "Date Due", "Added by", "Add Date", "Edited by"
//                , "Edit Date", "invoice number"});
       mod.setColumnIdentifiers(new String[] {"Invoice #","Transaction","Client","Payment Type","Total","Date","Invoice Id"});
        int quantity = 0;
        ArrayList<Invoice> arrClients = Invoice.getAllInvoice();
        for(Invoice emp: arrClients){
            String cType = getInvoiceType(emp.getInvoiceTypeFlag());
           
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
            String payment = getPaymentType(emp.getInvoicePaymentType());
            String dueDate;
            String addDate;
            String editDate;
            if(emp.getInvoiceDueDate() == null || emp.getInvoicePaymentType().equals(new Short("0"))){
                dueDate = "-";
            }else{
                dueDate =  Formats.dateFormatDays.format(emp.getInvoiceDueDate());
            }
            if(emp.getInvoiceAddDate() == null){
                addDate = "-";
            }else{
                addDate = Formats.dateFormatDays.format(emp.getInvoiceAddDate());
            }
            if(emp.getInvoiceEditDate() == null){
                editDate = "-";
            }else{
                editDate = Formats.dateFormatDays.format(emp.getInvoiceEditDate());
            }
//           mod.addRow(new String[] {emp.getInvoiceNumber()+"",cType+"",emp.getClientName()+"",payment+"",emp.getInvoiceTotalPrice()+"",cType+"",Formats.dateFormatMinutes.format(emp.getInvoiceDate())+"",
//               dueDate, emp.getInvoiceAddUser(),addDate, emp.getInvoiceEditUser(),editDate, emp.getInvoiceId()+""});
//           mod.addRow(new String[] {emp.getInvoiceNumber()+"",cType+"",emp.getClientName()+"",payment+"",Formats.centavoDecimal.format(emp.getInvoiceTotalPrice())
//                   ,Formats.dateFormatDays.format(emp.getInvoiceDate())+"",dueDate, emp.getInvoiceAddUser(),addDate, emp.getInvoiceEditUser(),editDate, emp.getInvoiceId()+""});
            mod.addRow(new String[] {emp.getInvoiceNumber()+"",cType+"",emp.getClientName()+"",payment+"",Formats.centavoDecimal.format(emp.getInvoiceTotalPrice())
                   ,Formats.dateFormatDays.format(emp.getInvoiceDate())+"", emp.getInvoiceId()+""});
            
        }
        return mod;
    }
    
    
    public static DefaultTableModel getAllInvoice(int invoiceType){
       DefaultTableModel mod = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
       
//        mod.setColumnIdentifiers(new String[] {"Invoice #","IN-OUT","Client","Payment Type","Total Balance", "Transaction", "Date", "Date Due", "Added by", "Add Date", "Edited by", "Edit Date", "invoice number"});
//        mod.setColumnIdentifiers(new String[] {"Invoice #","Transaction","Client","Payment Type","Total Amount","Date", "Date Due", "Added by", "Add Date", "Edited by"
//                , "Edit Date", "invoice number"});
       mod.setColumnIdentifiers(new String[] {"Invoice #","Transaction","Client","Payment Type","Total","Date","Invoice Id"});
        int quantity = 0;
        ArrayList<Invoice> arrClients = Invoice.getAllInvoice(invoiceType);
        for(Invoice emp: arrClients){
            String cType = getInvoiceType(emp.getInvoiceTypeFlag());
           
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
            String payment = getPaymentType(emp.getInvoicePaymentType());
            String dueDate;
            String addDate;
            String editDate;
            if(emp.getInvoiceDueDate() == null || emp.getInvoicePaymentType().equals(new Short("0"))){
                dueDate = "-";
            }else{
                dueDate =  Formats.dateFormatDays2.format(emp.getInvoiceDueDate());
            }
            if(emp.getInvoiceAddDate() == null){
                addDate = "-";
            }else{
                addDate = Formats.dateFormatDays2.format(emp.getInvoiceAddDate());
            }
            if(emp.getInvoiceEditDate() == null){
                editDate = "-";
            }else{
                editDate = Formats.dateFormatDays.format(emp.getInvoiceEditDate());
            }
//           mod.addRow(new String[] {emp.getInvoiceNumber()+"",cType+"",emp.getClientName()+"",payment+"",emp.getInvoiceTotalPrice()+"",cType+"",Formats.dateFormatMinutes.format(emp.getInvoiceDate())+"",
//               dueDate, emp.getInvoiceAddUser(),addDate, emp.getInvoiceEditUser(),editDate, emp.getInvoiceId()+""});
//           mod.addRow(new String[] {emp.getInvoiceNumber()+"",cType+"",emp.getClientName()+"",payment+"",Formats.centavoDecimal.format(emp.getInvoiceTotalPrice())
//                   ,Formats.dateFormatDays.format(emp.getInvoiceDate())+"",dueDate, emp.getInvoiceAddUser(),addDate, emp.getInvoiceEditUser(),editDate, emp.getInvoiceId()+""});
            mod.addRow(new String[] {emp.getInvoiceNumber()+"",cType+"",emp.getClientName()+"",payment+"",Formats.centavoDecimal.format(emp.getInvoiceTotalPrice())
                   ,Formats.dateFormatDays.format(emp.getInvoiceDate())+"", emp.getInvoiceId()+""});
            
        }
        return mod;
    }
    
    
    
    
    public static DefaultTableModel getInvoiceCollectionTableData(int clientId){
       DefaultTableModel mod = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
       
//        mod.setColumnIdentifiers(new String[] {"Invoice #","IN-OUT","Client","Payment Type","Total Balance", "Transaction", "Date", "Date Due", "Added by", "Add Date", "Edited by", "Edit Date", "invoice number"});
//        mod.setColumnIdentifiers(new String[] {"Invoice #","Transaction","Client","Payment Type","Total Amount","Date", "Date Due", "Added by", "Add Date", "Edited by"
//                , "Edit Date", "invoice number"});
       mod.setColumnIdentifiers(new String[] {"Invoice #","Transaction","Client","Pay Type","Total","Date", "Date Due","Edited by"
                , "Edit Date", "invoice number"});
        int quantity = 0;
        ArrayList<Invoice> arrClients = Invoice.getAllInvoiceCollectionWithClient(clientId);
        for(Invoice emp: arrClients){
            String cType = getInvoiceType(emp.getInvoiceTypeFlag());
           
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
            String payment = getPaymentType(emp.getInvoicePaymentType());
            String dueDate;
            String addDate;
            String editDate;
            if(emp.getInvoiceDueDate() == null || emp.getInvoicePaymentType().equals(new Short("0"))){
                dueDate = "-";
            }else{
                dueDate =  Formats.dateFormatDays2.format(emp.getInvoiceDueDate());
            }
            if(emp.getInvoiceAddDate() == null){
                addDate = "-";
            }else{
                addDate = Formats.dateFormatDays2.format(emp.getInvoiceAddDate());
            }
            if(emp.getInvoiceEditDate() == null){
                editDate = "-";
            }else{
                editDate = Formats.dateFormatDays2.format(emp.getInvoiceEditDate());
            }
//           mod.addRow(new String[] {emp.getInvoiceNumber()+"",cType+"",emp.getClientName()+"",payment+"",emp.getInvoiceTotalPrice()+"",cType+"",Formats.dateFormatMinutes.format(emp.getInvoiceDate())+"",
//               dueDate, emp.getInvoiceAddUser(),addDate, emp.getInvoiceEditUser(),editDate, emp.getInvoiceId()+""});
//           mod.addRow(new String[] {emp.getInvoiceNumber()+"",cType+"",emp.getClientName()+"",payment+"",Formats.centavoDecimal.format(emp.getInvoiceTotalPrice())
//                   ,Formats.dateFormatDays.format(emp.getInvoiceDate())+"",dueDate, emp.getInvoiceAddUser(),addDate, emp.getInvoiceEditUser(),editDate, emp.getInvoiceId()+""});
            mod.addRow(new String[] {emp.getInvoiceNumber()+"",cType+"",emp.getClientName()+"",payment+"",Formats.centavoDecimal.format(emp.getInvoiceTotalPrice())
                   ,Formats.dateFormatDays.format(emp.getInvoiceDate())+"",dueDate,emp.getInvoiceEditUser(),editDate, emp.getInvoiceId()+""});
            
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
    
 //INVOICE INPUT
 public static int invoiceSQLLogic(int clientId, String total, String invoiceNumber, boolean receivableFlg, ArrayList<PreorderTransaction> transactionList, int year, int month, int day,boolean outFlg, int locationId ){
    Connection con = SQLConnection.getSQLConnection();
    int success = 1;
    try{
//        Connection con = SQLConnection.getSQLConnection();
        ArrayList<Item> itemList = new ArrayList<Item>();
        ArrayList<Stocks> newStockList = new ArrayList<Stocks>();
        ArrayList<Stocks> existingStockList = new ArrayList<Stocks>();
        con.setAutoCommit(false);
//        Double balance = Double.parseDouble(Formats.centavoDecimal.parse(total));
        Double balance = Formats.centavoDecimal.parse(total).doubleValue();
//        balance-= Invoice.getInvoiceBalance(invoiceNumber,con);
        
        success = PreorderAction.insertInvoice(clientId, total,balance, invoiceNumber, receivableFlg, year, month, day,con, locationId, outFlg);   
        
         GregorianCalendar cal = new GregorianCalendar();
         cal.set(GregorianCalendar.YEAR, year);
         cal.set(GregorianCalendar.MONTH, month);
         cal.set(GregorianCalendar.DATE, day);
            int invoiceId = Preorder.getLatestPreorder(con);
            for(PreorderTransaction t: transactionList){
                boolean exist = false;
                int quantityAsOf = 0;
                int stockQuantity = 0;
                Item i = Item.getItem(t.getPreorderTransactionItemId().toString(), con);
                int nExist = Stocks.checkStocksExist(i.getItemId().toString(), locationId+"", con);
                Stocks s = new Stocks();
                s.setStocksItemId(i.getItemId());
                s.setStocksLocationId(locationId);
               
                
                //for example 2 bananas with different prices
//                for(Item item : itemList){
//                    if(item.getItemId().equals( i.getItemId())){
//                        exist = true;
//                        boolean isNew = false;
//                        int newCheck = checkStockArrayList(i.getItemId(), locationId, newStockList);
//                        int existingCheck = checkStockArrayList(i.getItemId(), locationId, existingStockList);
//                        if(newCheck > -1){
//                            isNew = true;
//                        }
//                        if(isNew){
//                            s = newStockList.get(newCheck);
//                        } else{
//                            s = existingStockList.get(existingCheck);
//                        }
//                        stockQuantity = s.getStocksQuantity();
//                        if(outFlg){
//                            quantityAsOf = item.getItemCurrentQuantity()-t.getPreorderTransactionQuantity();
//                            stockQuantity = stockQuantity-t.getPreorderTransactionQuantity();
//                        } else {
//                            quantityAsOf = item.getItemCurrentQuantity()+t.getPreorderTransactionQuantity();
//                            stockQuantity = stockQuantity+t.getPreorderTransactionQuantity();
//                        }
//                        s.setStocksQuantity(stockQuantity);
//                        item.setItemCurrentQuantity(quantityAsOf);
//                        if(isNew){
//                            newStockList.remove(newCheck);
//                            newStockList.add(s);
//                        } else {
//                            existingStockList.remove(existingCheck);
//                            existingStockList.add(s);
//                        }
//                        
//                    }
//                }
//                
//                //FirstTime input for example one case of banana
//                if(!exist){
//                  if(nExist > 0 ){
//                    s = Stocks.getStocks(i.getItemId().toString(), locationId+"");
//                    stockQuantity = s.getStocksQuantity();
//                  } 
//                   if(outFlg){
//                      quantityAsOf = i.getItemCurrentQuantity()-t.getPreorderTransactionQuantity();
//                      stockQuantity = stockQuantity-t.getPreorderTransactionQuantity();
//                   } else {
//                      quantityAsOf = i.getItemCurrentQuantity()+t.getPreorderTransactionQuantity();
//                      stockQuantity = stockQuantity+t.getPreorderTransactionQuantity();
//                   }
//                   i.setItemCurrentQuantity(quantityAsOf);
//                   s.setStocksQuantity(stockQuantity);
//                   itemList.add(i);
//                   if(nExist > 0){
//                      existingStockList.add(s);
//                   } else{
//                      newStockList.add(s);
//                   }
//                }
                
                t.setPreorderTransactionDate(cal.getTime());
                t.setPreorderTransactionPreorderId(invoiceId);
                t.setPreorderTransactionAddDate(new GregorianCalendar().getTime());
                t.setPreorderTransactionAddUser(System.getProperty("userName"));
//                t.setTransactionQuantityAsOf(quantityAsOf);
                
                
                success = PreorderTransaction.addPreorderTransaction(t,con);
//                success = Item.updateItemQuantity(t.getTransactionItemNumber(), t.getTransactionQuantityAsOf(), Formats.dateFormatDays.format(new GregorianCalendar().getTime()), con);
                
                
            }
//            for(Item items: itemList){
//                   success = Item.updateItemQuantity(items.getItemId(), items.getItemCurrentQuantity(), Formats.dateFormatDays.format(new GregorianCalendar().getTime()), con);
//            }
//            for(Stocks s: newStockList){
//                success = Stocks.insertStocks(s.getStocksItemId().toString(), s.getStocksLocationId().toString(), s.getStocksQuantity().toString(), con);
//            }
//            for(Stocks s: existingStockList){
//                success = Stocks.updateStocks(s.getStocksItemId().toString(), s.getStocksLocationId().toString(), s.getStocksQuantity().toString(),s.getStocksId().toString(), con);
//            }
            con.commit();
    } catch (Exception e){
            try {
                e.printStackTrace();
                con.rollback();
                return success;
            } catch (SQLException ex) {
                Logger.getLogger(PreorderAction.class.getName()).log(Level.SEVERE, null, ex);
            }
    } finally {
            try {
                
                con.close();
                return success;
            } catch (SQLException ex) {
                Logger.getLogger(PreorderAction.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
        return success;
//            this.dispose();
    }
 
 //NEW EDIT
  public static void invoiceEditSQLLogic(int invoiceId,int clientId, String total, String preorderNumber, ArrayList<PreorderTransaction> transactionList, int year, int month, int day,boolean outFlg, ArrayList<PreorderTransaction> delList, int locationId){
    Connection con = SQLConnection.getSQLConnection();
    try{
//        Connection con = SQLConnection.getSQLConnection();
//        ArrayList<Item> itemList = new ArrayList<Item>();
//        ArrayList<Stocks> existingStockList = new ArrayList<Stocks>();
//        ArrayList<Stocks> newStockList = new ArrayList<Stocks>();
        con.setAutoCommit(false);
//        Double balance = Formats.centavoDecimal.parse(total).doubleValue();
//        balance -= Invoice.getInvoiceBalance(invoiceId+"",con);
        
//        if(outFlg){
//         InvoiceAction.editOutInvoice(invoiceId, clientId, total, balance, invoiceNumber, receivableFlg, paymentType,year, month, day,con);   
//        } else {
//         InvoiceAction.editInInvoice(invoiceId, clientId, total, balance, invoiceNumber, receivableFlg, paymentType,year, month, day, con);   
//        }
        PreorderAction.editInvoice(invoiceId, clientId, total, preorderNumber, year, month, day, locationId, outFlg, con);
         GregorianCalendar cal = new GregorianCalendar();
         cal.set(GregorianCalendar.YEAR, year);
         cal.set(GregorianCalendar.MONTH, month);
         cal.set(GregorianCalendar.DATE, day);
//            int invoiceId = Invoice.getLatestInvoice(con);
         
         for(PreorderTransaction t: delList){
                Item i = Item.getItem(t.getPreorderTransactionId().toString(), con);
                t.setPreorderTransactionDate(cal.getTime());
                t.setPreorderTransactionPreorderId(invoiceId);
                t.setPreorderTransactionDelDate(new GregorianCalendar().getTime());
                t.setPreorderTransactionEditDate(new GregorianCalendar().getTime());
                t.setPreorderTransactionEditUser(System.getProperty("userName"));
                boolean exist = false;
                Double stockQuantity = 0.0;
//                int nExist = Stocks.checkStocksExist(i.getItemId().toString(), locationId+"", con);
//                Stocks s = new Stocks();
//                s.setStocksItemId(i.getItemId());
//                s.setStocksLocationId(locationId);
                Double quantityAsOf = 0.0;
//                if(outFlg){
//                    t.setTransactionQuantityAsOf(i.getItemCurrentQuantity()+t.getTransactionQuantity());
//                } else {
//                    t.setTransactionQuantityAsOf(i.getItemCurrentQuantity()-t.getTransactionQuantity());
//                }
//                 for(Item item : itemList){
//                    if(item.getItemId().equals(i.getItemId())){
////                        exist = true;
////                        if(outFlg){
////                            quantityAsOf = item.getItemCurrentQuantity()+t.getTransactionQuantity();
////                        } else {
////                            quantityAsOf = item.getItemCurrentQuantity()-t.getTransactionQuantity();
////                        }
////                        item.setItemCurrentQuantity(quantityAsOf);
//                        exist = true;
//                        boolean isNew = false;
//                        int newCheck = checkStockArrayList(i.getItemId(), locationId, newStockList);
//                        int existingCheck = checkStockArrayList(i.getItemId(), locationId, existingStockList);
//                        if(newCheck > -1){
//                            isNew = true;
//                        }
//                        if(isNew){
//                            s = newStockList.get(newCheck);
//                        } else{
//                            s = existingStockList.get(existingCheck);
//                        }
//                        stockQuantity = s.getStocksQuantity();
//                        if(outFlg){
//                            quantityAsOf = item.getItemCurrentQuantity()+t.getTransactionQuantity();
//                            stockQuantity = stockQuantity+t.getTransactionQuantity();
//                        } else {
//                            quantityAsOf = item.getItemCurrentQuantity()-t.getTransactionQuantity();
//                            stockQuantity = stockQuantity-t.getTransactionQuantity();
//                        }
//                        s.setStocksQuantity(stockQuantity);
//                        item.setItemCurrentQuantity(quantityAsOf);
//                        if(isNew){
//                            newStockList.remove(newCheck);
//                            newStockList.add(s);
//                        } else {
//                            existingStockList.remove(existingCheck);
//                            existingStockList.add(s);
//                        }
//                    }
//                }
//                if(!exist){
////                   if(outFlg){
////                      quantityAsOf = i.getItemCurrentQuantity()+t.getTransactionQuantity();
////                   } else {
////                      quantityAsOf = i.getItemCurrentQuantity()-t.getTransactionQuantity();
////                   }
////                   i.setItemCurrentQuantity(quantityAsOf);
////                   itemList.add(i);
//                     if(nExist > 0){
//                    s = Stocks.getStocks(i.getItemId().toString(), locationId+"");
//                    stockQuantity = s.getStocksQuantity();
//                  } 
//                   if(outFlg){
//                      quantityAsOf = i.getItemCurrentQuantity()+t.getTransactionQuantity();
//                      stockQuantity = stockQuantity+t.getTransactionQuantity();
//                   } else {
//                      quantityAsOf = i.getItemCurrentQuantity()-t.getTransactionQuantity();
//                      stockQuantity = stockQuantity-t.getTransactionQuantity();
//                   }
//                   i.setItemCurrentQuantity(quantityAsOf);
//                   s.setStocksQuantity(stockQuantity);
//                   itemList.add(i);
//                   if(nExist > 0){
//                      existingStockList.add(s);
//                   } else{
//                      newStockList.add(s);
//                   }
//                }
                PreorderTransaction.deleteTransaction(t,con);
//                Item.updateItemQuantity(t.getTransactionItemNumber(), t.getTransactionQuantityAsOf(), Formats.dateFormatDays.format(new GregorianCalendar().getTime()), con);

                
            }
//          for(Stocks s: newStockList){
//                 Stocks.insertStocks(s.getStocksItemId().toString(), s.getStocksLocationId().toString(), s.getStocksQuantity().toString(), con);
//            }
//            for(Stocks s: existingStockList){
//                 Stocks.updateStocks(s.getStocksItemId().toString(), s.getStocksLocationId().toString(), s.getStocksQuantity().toString(),s.getStocksId().toString(), con);
//            }
            for(PreorderTransaction t: transactionList){
                Item i = Item.getItem(t.getPreorderTransactionItemId().toString(), con);
                t.setPreorderTransactionDate(cal.getTime());
                t.setPreorderTransactionPreorderId(invoiceId);
                t.setPreorderTransactionAddDate(new GregorianCalendar().getTime());
                t.setPreorderTransactionAddUser(System.getProperty("userName"));
                boolean exist = false;
                Double quantityAsOf = 0.0;
                Double stockQuantity = 0.0;
//                int nExist = Stocks.checkStocksExist(i.getItemId().toString(), locationId+"", con);
//                Stocks s = new Stocks();
//                s.setStocksItemId(i.getItemId());
//                s.setStocksLocationId(locationId);
//                if(outFlg){
//                    t.setTransactionQuantityAsOf(i.getItemCurrentQuantity()+t.getTransactionQuantity());
//                } else {
//                    t.setTransactionQuantityAsOf(i.getItemCurrentQuantity()-t.getTransactionQuantity());
//                }
//                 for(Item item : itemList){
//                    if(item.getItemId().equals(i.getItemId())){
////                        exist = true;
////                        if(outFlg){
////                            quantityAsOf = item.getItemCurrentQuantity()+t.getTransactionQuantity();
////                        } else {
////                            quantityAsOf = item.getItemCurrentQuantity()-t.getTransactionQuantity();
////                        }
////                        item.setItemCurrentQuantity(quantityAsOf);
////                    }
//                         exist = true;
//                        boolean isNew = false;
//                        int newCheck = checkStockArrayList(i.getItemId(), locationId, newStockList);
//                        int existingCheck = checkStockArrayList(i.getItemId(), locationId, existingStockList);
//                        if(newCheck > -1){
//                            isNew = true;
//                        }
//                        if(isNew){
//                            s = newStockList.get(newCheck);
//                        } else{
//                            s = existingStockList.get(existingCheck);
//                        }
//                        stockQuantity = s.getStocksQuantity();
//                        if(outFlg && t.getTransactionId() == null){
//                            quantityAsOf = item.getItemCurrentQuantity()-t.getTransactionQuantity();
//                            stockQuantity = stockQuantity-t.getTransactionQuantity();
//                        } else if( t.getTransactionId() == null) {
//                            quantityAsOf = item.getItemCurrentQuantity()+t.getTransactionQuantity();
//                            stockQuantity = stockQuantity+t.getTransactionQuantity();
//                        }
//                        s.setStocksQuantity(stockQuantity);
//                        item.setItemCurrentQuantity(quantityAsOf);
//                        if(isNew){
//                            newStockList.remove(newCheck);
//                            newStockList.add(s);
//                        } else {
//                            existingStockList.remove(existingCheck);
//                            existingStockList.add(s);
//                        }
//                    }
//                }
//                if(!exist){
////                   if(outFlg){
////                      quantityAsOf = i.getItemCurrentQuantity()+t.getTransactionQuantity();
////                   } else {
////                      quantityAsOf = i.getItemCurrentQuantity()-t.getTransactionQuantity();
////                   }
////                   i.setItemCurrentQuantity(quantityAsOf);
////                   itemList.add(i);
//                     if(nExist > 0){
//                    s = Stocks.getStocks(i.getItemId().toString(), locationId+"");
//                    stockQuantity = s.getStocksQuantity();
//                  } 
//                   if(outFlg && t.getTransactionId()== null){
//                      quantityAsOf = i.getItemCurrentQuantity()-t.getTransactionQuantity();
//                      stockQuantity = stockQuantity-t.getTransactionQuantity();
//                   } else if(t.getTransactionId()== null){
//                      quantityAsOf = i.getItemCurrentQuantity()+t.getTransactionQuantity();
//                      stockQuantity = stockQuantity+t.getTransactionQuantity();
//                   }
//                   i.setItemCurrentQuantity(quantityAsOf);
//                   s.setStocksQuantity(stockQuantity);
//                   itemList.add(i);
//                   if(nExist > 0){
//                      existingStockList.add(s);
//                   } else{
//                      newStockList.add(s);
//                   }
//                }
//                t.setTransactionQuantityAsOf(quantityAsOf);
//                if(outFlg){
//                    t.setTransactionQuantityAsOf(i.getItemCurrentQuantity()-t.getTransactionQuantity());
//                } else {
//                    t.setTransactionQuantityAsOf(i.getItemCurrentQuantity()+t.getTransactionQuantity());
//                }
                if(t.getPreorderTransactionId() == null){
                PreorderTransaction.addPreorderTransaction(t,con);
//                Item.updateItemQuantity(t.getTransactionItemNumber(), t.getTransactionQuantityAsOf(), Formats.dateFormatDays.format(new GregorianCalendar().getTime()), con);
                }
                
            }
//             for(Item items: itemList){
//                  Item.updateItemQuantity(items.getItemId(), items.getItemCurrentQuantity(), Formats.dateFormatDays.format(new GregorianCalendar().getTime()), con);
//            }
//             for(Stocks s: newStockList){
//                 Stocks.insertStocks(s.getStocksItemId().toString(), s.getStocksLocationId().toString(), s.getStocksQuantity().toString(), con);
//            }
//            for(Stocks s: existingStockList){
//                 Stocks.updateStocks(s.getStocksItemId().toString(), s.getStocksLocationId().toString(), s.getStocksQuantity().toString(),s.getStocksId().toString(), con);
//            }
            
            con.commit();
    } catch (Exception e){
            try {
                e.printStackTrace();
                con.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(PreorderAction.class.getName()).log(Level.SEVERE, null, ex);
            }
    } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(PreorderAction.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
        
//            this.dispose();
    }
  
//VOID SQL  
   public static void voidSQLLogic(int invoiceId,ArrayList<PreorderTransaction> transactionList,boolean outFlg, int locationId){
    Connection con = SQLConnection.getSQLConnection();
    try{
//        Connection con = SQLConnection.getSQLConnection();
        ArrayList<Item> itemList = new ArrayList<Item>();
        ArrayList<Stocks> stockList = new ArrayList<Stocks>();
        con.setAutoCommit(false);
//        if(outFlg){
//         InvoiceAction.editOutInvoice(clientId, total, invoiceNumber, receivableFlg, paymentType,year, month, day,con);   
//        } else {
//         InvoiceAction.editInInvoice(clientId, total, invoiceNumber, receivableFlg, paymentType,year, month, day, con);   
//        }
        Preorder in = new Preorder();
        in.setPreorderId(invoiceId);
        in.setPreorderDelDate(new GregorianCalendar().getTime());
        in.setPreorderEditDate(new GregorianCalendar().getTime());
        in.setPreorderEditUser(System.getProperty("userName"));
        Preorder.deletePreorder(in, con);
//         GregorianCalendar cal = new GregorianCalendar();
//         cal.set(GregorianCalendar.YEAR, year);
//         cal.set(GregorianCalendar.MONTH, month);
//         cal.set(GregorianCalendar.DATE, day);
//            int invoiceId = Invoice.getLatestInvoice(con);
         
         for(PreorderTransaction t: transactionList){
                Item i = Item.getItem(t.getPreorderTransactionId().toString(), con);
//                t.setTransactionDate(cal.getTime());
                t.setPreorderTransactionPreorderId(invoiceId);
                t.setPreorderTransactionDelDate(new GregorianCalendar().getTime());
                t.setPreorderTransactionEditDate(new GregorianCalendar().getTime());
                t.setPreorderTransactionEditUser(System.getProperty("userName"));
//                if(outFlg){
//                    t.setTransactionQuantityAsOf(i.getItemCurrentQuantity()+t.getTransactionQuantity());
//                } else {
//                    t.setTransactionQuantityAsOf(i.getItemCurrentQuantity()-t.getTransactionQuantity());
//                }
                 boolean exist = false;
                
                PreorderTransaction.deleteTransaction(t,con);
//                Item.updateItemQuantity(t.getTransactionItemNumber(), t.getTransactionQuantityAsOf(), Formats.dateFormatDays.format(new GregorianCalendar().getTime()), con);
            
            }
//         for(Item items: itemList){
//                  Item.updateItemQuantity(items.getItemId(), items.getItemCurrentQuantity(), Formats.dateFormatDays.format(new GregorianCalendar().getTime()), con);
//            }
//         for(Stocks s: stockList){
//                 Stocks.updateStocks(s.getStocksItemId().toString(), s.getStocksLocationId().toString(), s.getStocksQuantity().toString(),s.getStocksId().toString(), con);
//            }
           
            con.commit();
    } catch (Exception e){
            try {
                e.printStackTrace();
                con.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(PreorderAction.class.getName()).log(Level.SEVERE, null, ex);
            }
    } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(PreorderAction.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
        
//            this.dispose();
    }

private static Date getDueDate(GregorianCalendar calendar, int paymentType){
    GregorianCalendar cal = calendar;
    switch(paymentType){
            case 1:
//               cal;
//               c.setInvoiceDueDate(cal.getTime());
               break;
           case 2:
               cal.add(GregorianCalendar.DAY_OF_MONTH, 7);
//               c.setInvoiceDueDate(cal.getTime());
               break;
           case 3:
               cal.add(GregorianCalendar.DAY_OF_MONTH, 15);
//               c.setInvoiceDueDate(cal.getTime());
               break;
           case 4:
               cal.add(GregorianCalendar.DAY_OF_MONTH, 30);
//               c.setInvoiceDueDate(cal.getTime());
               break;
           case 5:
               cal.add(GregorianCalendar.DAY_OF_MONTH, 45);
//               c.setInvoiceDueDate(cal.getTime());
               break;
           case 6:
               cal.add(GregorianCalendar.DAY_OF_MONTH, 60);
//               c.setInvoiceDueDate(cal.getTime());
               break;
           case 7:
               cal.add(GregorianCalendar.DAY_OF_MONTH, 90);
//               c.setInvoiceDueDate(cal.getTime());
               break;
           case 8:
               cal.add(GregorianCalendar.DAY_OF_MONTH, 120);
//               c.setInvoiceDueDate(cal.getTime());
               break;
           case 9:
               cal.add(GregorianCalendar.DAY_OF_MONTH, 150);
//               c.setInvoiceDueDate(cal.getTime());
               break;
           case 10:
               cal.add(GregorianCalendar.DAY_OF_MONTH, 180);
//               c.setInvoiceDueDate(cal.getTime());
               break;
           default:
//               c.setInvoiceDueDate(cal.getTime());
               
       }
    
    
    return cal.getTime();
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

public static DefaultTableModel getInvoiceDetailedSalesData(int clientId){
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
        ArrayList<Invoice> arrClients = Invoice.getAllInvoiceWithClient(clientId);
        for(Invoice emp: arrClients){
            String cType = getInvoiceType(emp.getInvoiceTypeFlag());
           
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
            String payment = getPaymentType(emp.getInvoicePaymentType());
            String dueDate;
            String date;
            if(emp.getInvoiceDueDate() == null || emp.getInvoicePaymentType().equals(new Short("0"))){
                dueDate = "-";
            }else{
                dueDate =  Formats.dateFormatDays.format(emp.getInvoiceDueDate());
            }
            if(emp.getInvoiceDate() == null){
                date = "-";
            }else{
                date = Formats.dateFormatDays.format(emp.getInvoiceDate());
            }
            Double totalAmount = 0.00;
//        if(!transactionList.isEmpty()){
        
//        for(Transaction emp: transactionList){
//           mod.addRow(new String[] {emp.getItemName()+"",emp.getSupplierName()+"",emp.getTransactionQuantity().toString()+"",Formats.centavoDecimal.format(emp.getTransactionPrice())+"", Formats.centavoDecimal.format(emp.getTransactionSubTotal())});
//            totalAmount += emp.getTransactionSubTotal();
//        }
       
//           mod.addRow(new String[] {emp.getInvoiceNumber()+"",cType+"",emp.getClientName()+"",payment+"",emp.getInvoiceTotalPrice()+"",cType+"",Formats.dateFormatMinutes.format(emp.getInvoiceDate())+"",
//               dueDate, emp.getInvoiceAddUser(),addDate, emp.getInvoiceEditUser(),editDate, emp.getInvoiceId()+""});
//           mod.addRow(new String[] {emp.getInvoiceNumber()+"",cType+"",emp.getClientName()+"",payment+"",Formats.centavoDecimal.format(emp.getInvoiceTotalPrice())
//                   ,Formats.dateFormatDays.format(emp.getInvoiceDate())+"",dueDate, emp.getInvoiceAddUser(),addDate, emp.getInvoiceEditUser(),editDate, emp.getInvoiceId()+""});
            mod.addRow(new String[] {"Date",date});
            mod.addRow(new String[] {"Invoice #",emp.getInvoiceNumber()+""});
            mod.addRow(new String[] {"Payment Type",payment+""});
            mod.addRow(new String[] {"Due Date", dueDate});
            mod.addRow(new String[] {" ","Item Name", "Quantity", "Amount per","Sub Total"});
             ArrayList<Transaction> transactionList = Transaction.getTransactions(""+emp.getInvoiceId());
             for(Transaction temp: transactionList){
                 String faquant = FractionAction.convertToFraction(temp.getTransactionQuantity());
                 mod.addRow(new String[] {" ",temp.getItemName()+"",faquant+"",Formats.centavoDecimal.format(temp.getTransactionPrice())+"", Formats.centavoDecimal.format(temp.getTransactionSubTotal())});
                 totalAmount += temp.getTransactionSubTotal();
             }
           mod.addRow(new String[] {" ", "Total", " ", " ", totalAmount+""});
           mod.addRow(new String[] {" ", " ", " ", " "," "});           
         grandTotal += totalAmount;
        }
        mod.addRow(new String[] {"Grand Total", " ", " ", " ", grandTotal+""});
        
        
        return mod;
    }

public static DefaultTableModel getInvoiceDetailedSalesData(int clientId, String fromDate, String toDate){
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
        ArrayList<Invoice> arrClients = Invoice.getAllInvoiceWithClient(clientId, fromDate, toDate);
        for(Invoice emp: arrClients){
//            String cType = getInvoiceType(emp.getInvoiceTypeFlag());
           
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
            String payment = getPaymentType(emp.getInvoicePaymentType());
            String dueDate;
            String date;
            if(emp.getInvoiceDueDate() == null || emp.getInvoicePaymentType().equals(new Short("0"))){
                dueDate = "-";
            }else{
                dueDate =  Formats.dateFormatDays2.format(emp.getInvoiceDueDate());
            }
            if(emp.getInvoiceDate() == null){
                date = "-";
            }else{
                date = Formats.dateFormatDays2.format(emp.getInvoiceDate());
            }
            Double totalAmount = 0.00;
//        if(!transactionList.isEmpty()){
        
//        for(Transaction emp: transactionList){
//           mod.addRow(new String[] {emp.getItemName()+"",emp.getSupplierName()+"",emp.getTransactionQuantity().toString()+"",Formats.centavoDecimal.format(emp.getTransactionPrice())+"", Formats.centavoDecimal.format(emp.getTransactionSubTotal())});
//            totalAmount += emp.getTransactionSubTotal();
//        }
       
//           mod.addRow(new String[] {emp.getInvoiceNumber()+"",cType+"",emp.getClientName()+"",payment+"",emp.getInvoiceTotalPrice()+"",cType+"",Formats.dateFormatMinutes.format(emp.getInvoiceDate())+"",
//               dueDate, emp.getInvoiceAddUser(),addDate, emp.getInvoiceEditUser(),editDate, emp.getInvoiceId()+""});
//           mod.addRow(new String[] {emp.getInvoiceNumber()+"",cType+"",emp.getClientName()+"",payment+"",Formats.centavoDecimal.format(emp.getInvoiceTotalPrice())
//                   ,Formats.dateFormatDays.format(emp.getInvoiceDate())+"",dueDate, emp.getInvoiceAddUser(),addDate, emp.getInvoiceEditUser(),editDate, emp.getInvoiceId()+""});
//            mod.addRow(new String[] {"Invoice #",emp.getInvoiceNumber()+"","Date",date});
            mod.addRow(new String[] {"Invoice #",emp.getInvoiceNumber()+""});
            mod.addRow(new String[] {"Date",date});
//            mod.addRow(new String[] {"Payment Type",payment +"","Due Date", dueDate});
            
//            mod.addRow(new String[] {" "," "});
            mod.addRow(new String[] {"Payment Type",payment +""});
            mod.addRow(new String[] {"Due Date", dueDate});
            mod.addRow(new String[] {" ","Item Name", "Quantity", "Amount per","Sub Total"});
             ArrayList<Transaction> transactionList = Transaction.getTransactions(""+emp.getInvoiceId());
             for(Transaction temp: transactionList){
                 String faquant = FractionAction.convertToFraction(temp.getTransactionQuantity());
                 mod.addRow(new String[] {" ",temp.getItemName()+"",faquant+"",Formats.centavoDecimal.format(temp.getTransactionPrice())+"", Formats.centavoDecimal.format(temp.getTransactionSubTotal())});
                 totalAmount += temp.getTransactionSubTotal();
             }
           mod.addRow(new String[] {" ", "Total", " ", " ", Formats.centavoDecimal.format(totalAmount)+""});
           mod.addRow(new String[] {" ", " ", " ", " "," "});           
         grandTotal += totalAmount;
        }
        mod.addRow(new String[] {"Grand Total", " ", " ", " ", Formats.centavoDecimal.format(grandTotal)+""});
        
       
        return mod;
    }

public static DefaultTableModel getInvoiceDailydSalesData(int year, int day, int month){
       DefaultTableModel mod = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
       GregorianCalendar c = new GregorianCalendar(year, month, day);
//        mod.setColumnIdentifiers(new String[] {"Invoice #","IN-OUT","Client","Payment Type","Total Balance", "Transaction", "Date", "Date Due", "Added by", "Add Date", "Edited by", "Edit Date", "invoice number"});
//        mod.setColumnIdentifiers(new String[] {"Invoice #","Transaction","Client","Payment Type","Total Amount","Date", "Date Due", "Added by", "Add Date", "Edited by"
//                , "Edit Date", "invoice number"});
       mod.setColumnIdentifiers(new String[] {" "," "," "," "," "});
        Double grandTotal = 0.0;
        ArrayList<Invoice> arrClients = Invoice.getAllInvoiceWithDate(Formats.dateFormatDays.format(c.getTime()));
        for(Invoice emp: arrClients){
            String cType = getInvoiceType(emp.getInvoiceTypeFlag());
           
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
            String payment = getPaymentType(emp.getInvoicePaymentType());
            String dueDate;
            String date;
            if(emp.getInvoiceDueDate() == null || emp.getInvoicePaymentType().equals(new Short("0"))){
                dueDate = "-";
            }else{
                dueDate =  Formats.dateFormatDays.format(emp.getInvoiceDueDate());
            }
            if(emp.getInvoiceDate() == null){
                date = "-";
            }else{
                date = Formats.dateFormatDays.format(emp.getInvoiceDate());
            }
            Double totalAmount = 0.00;
//        if(!transactionList.isEmpty()){
        
//        for(Transaction emp: transactionList){
//           mod.addRow(new String[] {emp.getItemName()+"",emp.getSupplierName()+"",emp.getTransactionQuantity().toString()+"",Formats.centavoDecimal.format(emp.getTransactionPrice())+"", Formats.centavoDecimal.format(emp.getTransactionSubTotal())});
//            totalAmount += emp.getTransactionSubTotal();
//        }
       
//           mod.addRow(new String[] {emp.getInvoiceNumber()+"",cType+"",emp.getClientName()+"",payment+"",emp.getInvoiceTotalPrice()+"",cType+"",Formats.dateFormatMinutes.format(emp.getInvoiceDate())+"",
//               dueDate, emp.getInvoiceAddUser(),addDate, emp.getInvoiceEditUser(),editDate, emp.getInvoiceId()+""});
//           mod.addRow(new String[] {emp.getInvoiceNumber()+"",cType+"",emp.getClientName()+"",payment+"",Formats.centavoDecimal.format(emp.getInvoiceTotalPrice())
//                   ,Formats.dateFormatDays.format(emp.getInvoiceDate())+"",dueDate, emp.getInvoiceAddUser(),addDate, emp.getInvoiceEditUser(),editDate, emp.getInvoiceId()+""});
            mod.addRow(new String[] {"Client",emp.getClientName()});
            mod.addRow(new String[] {"Invoice #",emp.getInvoiceNumber()+""});
            mod.addRow(new String[] {"Payment Type",payment+""});
            mod.addRow(new String[] {"Due Date", dueDate});
            mod.addRow(new String[] {" ","Item Name", "Quantity", "Amount per","Sub Total"});
             ArrayList<Transaction> transactionList = Transaction.getTransactions(""+emp.getInvoiceId());
             for(Transaction temp: transactionList){
                 String faquant = FractionAction.convertToFraction(temp.getTransactionQuantity());
                 mod.addRow(new String[] {" ",temp.getItemName()+"",faquant+"",Formats.centavoDecimal.format(temp.getTransactionPrice())+"", Formats.centavoDecimal.format(temp.getTransactionSubTotal())});
                 totalAmount += temp.getTransactionSubTotal();
             }
           mod.addRow(new String[] {" ", "Total", " ", " ", totalAmount+""});
           mod.addRow(new String[] {" ", " ", " ", " "," "});           
         grandTotal += totalAmount;
        }
        mod.addRow(new String[] {"Grand Total", " ", " ", " ", grandTotal+""});
        
        
        return mod;
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

public static Double checkTotalBalance(int clientId, String total ){
    Connection con = SQLConnection.getSQLConnection();
    int success = 1;
    Double creditBalance = 0.0;
    try{
        double tot =  Formats.centavoDecimal.parse(total).doubleValue();
        Invoice t = Invoice.getInvoicesWithClientPayments(clientId);
        
            if(t.getCreditLimit() < 1){
                return 1.0;
            } else {
                creditBalance = t.getCreditLimit() - (t.getInvoiceTotalPrice()- t.getPayments());
                return creditBalance;
            }
        
        
    } catch (Exception e){
            try {
                e.printStackTrace();
                con.rollback();
//                return success;
            } catch (SQLException ex) {
                Logger.getLogger(PreorderAction.class.getName()).log(Level.SEVERE, null, ex);
            }
    } finally {
            try {
                
                con.close();
//                return success;
            } catch (SQLException ex) {
                Logger.getLogger(PreorderAction.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
        return creditBalance;
//            this.dispose();
    }


}
