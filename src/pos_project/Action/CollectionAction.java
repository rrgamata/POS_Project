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
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import pos_project.classes.CheckInvoiceList;
import pos_project.classes.CheckVoucher;
import pos_project.classes.CheckVoucherList;
import pos_project.classes.Collections;
import pos_project.classes.Formats;
import pos_project.classes.Invoice;
import pos_project.classes.SQLConnection;

/**
 *
 * @author Cif3r
 */
public class CollectionAction {
    
    
    public static void collectionSQLLogic(Collections c, boolean textFieldFlag, int selectedIndex, double balance, String chekNumber, int invoiceId){
    Connection con = SQLConnection.getSQLConnection();
    try{
//        Connection con = SQLConnection.getSQLConnection();
        con.setAutoCommit(false);
        c.setCollectionAddDate(new GregorianCalendar().getTime());
        c.setCollectionAddUser(System.getProperty("userName"));
        
            Short paidFlag;
            if(balance < 1 ){
                paidFlag = new Short("1");
            } else {
                paidFlag = new Short("0");
            }
            
            
            if(textFieldFlag && selectedIndex == 1){
                Collections.addCollectionCheck(c, chekNumber, con);
                if(c.getCollectionClearedFlag().equals(new Short("1"))){
                    Invoice.updateInvoiceBalance(invoiceId, balance, paidFlag, Formats.dateFormatDays.format(c.getCollectionDate()), con);
                }
            }else if(textFieldFlag && selectedIndex == 2){
                Collections.addCollectionCheck(c, chekNumber, con);
                if(c.getCollectionClearedFlag().equals(new Short("1"))){
                    Invoice.updateInvoiceBalance(invoiceId, balance, paidFlag, Formats.dateFormatDays.format(c.getCollectionDate()), con);
                }
            }else {
                Collections.addCollectionCash(c,con);
                Invoice.updateInvoiceBalance(invoiceId, balance, paidFlag, Formats.dateFormatDays.format(c.getCollectionDate()), con);
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
    
    
    public static void collectionEditSQLLogic(Collections c, boolean textFieldFlag, int selectedIndex, double balance, String chekNumber, int invoiceId){
    Connection con = SQLConnection.getSQLConnection();
    try{
//        Connection con = SQLConnection.getSQLConnection();
        con.setAutoCommit(false);
        c.setCollectionEditDate(new GregorianCalendar().getTime());
        c.setCollectionEditUser(System.getProperty("userName"));
        
            Short paidFlag;
            if(balance < 1){
                paidFlag = new Short("1");
            } else {
                paidFlag = new Short("0");
            }
            
            if(textFieldFlag && selectedIndex == 1){
                Collections.updateCheckCollection(c,con);
                if(c.getCollectionClearedFlag().equals(new Short("1"))){
                    Invoice.updateInvoiceBalance(invoiceId, balance, paidFlag, Formats.dateFormatDays.format(c.getCollectionDate()), con);
                }
            } else {
                Collections.updateCashCollection(c,con);
                Invoice.updateInvoiceBalance(invoiceId, balance, paidFlag, Formats.dateFormatDays.format(c.getCollectionDate()), con);
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
    
    public static void collectionClearSQLLogic(Collections c, String invoiceNumber){
    Connection con = SQLConnection.getSQLConnection();
    try{
//        Connection con = SQLConnection.getSQLConnection();
        con.setAutoCommit(false);
        c.setCollectionEditDate(new GregorianCalendar().getTime());
        c.setCollectionEditUser(System.getProperty("userName"));
//        Invoice i = Invoice.getInvoiceWithName(invoiceNumber);
        Invoice i = Invoice.getInvoiceWithId(c.getCollectionInvoiceId().toString());
//        Double balance = i.getInvoiceCurrentBalance();
        Double balance = i.getInvoiceTotalPrice()-Collections.getCollectionAmountUsingId(i.getInvoiceId()+"") - c.getCollectionAmount();
//        balance -= c.getCollectionAmount();
            Short paidFlag;
            if(balance < 1){
                paidFlag = new Short("1");
            } else {
                paidFlag = new Short("0");
            }
            Collections.clearCollection(c.getCollectionId()+"");
            Invoice.updateInvoiceBalance(i.getInvoiceId(), balance, paidFlag, Formats.dateFormatDays.format(c.getCollectionDate()), con);
            
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
    
    
    public static void collectionDeleteSQLLogic(Collections c, String invoiceNumber){
    Connection con = SQLConnection.getSQLConnection();
    try{
//        Connection con = SQLConnection.getSQLConnection();
        con.setAutoCommit(false);
        c.setCollectionEditDate(new GregorianCalendar().getTime());
        c.setCollectionEditUser(System.getProperty("userName"));
//        Invoice i = Invoice.getInvoiceWithName(invoiceNumber);
        Invoice i = Invoice.getInvoiceWithId(c.getCollectionInvoiceId().toString());
        Double balance = i.getInvoiceTotalPrice()-Collections.getCollectionAmountUsingId(i.getInvoiceId()+"");
        
        if(c.getCollectionClearedFlag().equals(new Short("1"))){
            balance+=c.getCollectionAmount();
        }
//                + c.getCollectionAmount();
            Short paidFlag;
            if(balance < 1){
                paidFlag = new Short("1");
            } else {
                paidFlag = new Short("0");
            }
            Collections.deleteCollection(c.getCollectionId()+"",new GregorianCalendar().getTime());
            Invoice.updateInvoiceBalance(i.getInvoiceId(), balance, paidFlag, Formats.dateFormatDays.format(c.getCollectionDate()), con);
            
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
    
    
    
    
    public static DefaultTableModel getReceivableLedgerTableData(int itemNumber, String fromCal, String toCal){
       DefaultTableModel mod = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
      
//        mod.setColumnIdentifiers(new String[] {"Date","Particulars","Check Date","Charge","Credit","Balance"});
//        ArrayList<Collections> arrItems = Collections.getAccountsReceivableLedgerWithDate(itemNumber, fromCal, toCal);
//        Double balance = new Double("0");
//        for(Collections emp: arrItems){
//                balance += emp.getCharge();
//                balance -= emp.getCredit();
////                String sCharge;
//                if(emp.getCharge() == 0){
//                    mod.addRow(new String[] {Formats.dateFormatDays.format(emp.getLedgerDate())+"",emp.getParticular()+"",emp.getCheckDate()+"", "-", emp.getCredit()+"",balance+""});
//                } else {
//                    mod.addRow(new String[] {Formats.dateFormatDays.format(emp.getLedgerDate())+"",emp.getParticular()+"",emp.getCheckDate()+"", emp.getCharge()+"", "-",balance+""});
//                }
//               
//        }
       
//        mod.setColumnCount(3);
       mod.setColumnIdentifiers(new String[] {"Date","OR #","Particulars","Check Date","Charge","Credit","Balance"});
       ArrayList<Collections> arrInvoice = Collections.getCollectionInvoiceWithDate(itemNumber, fromCal, toCal);
       Double balance = new Double("0");
       for(Collections emp: arrInvoice){
                balance += emp.getCharge();
                balance -= emp.getCredit();
                if(emp.getCharge() == 0){
                    mod.addRow(new String[] {Formats.dateFormatDays2.format(emp.getLedgerDate())+"","-",emp.getParticular()+"",emp.getCheckDate()+"", "-", emp.getCredit()+"",balance+""});
                } else {
                    mod.addRow(new String[] {Formats.dateFormatDays2.format(emp.getLedgerDate())+"","-",emp.getParticular()+"",emp.getCheckDate()+"", emp.getCharge()+"", "-",balance+""});
                }
           ArrayList<Collections> arrItems = Collections.getCollectionWithDate(emp.getCollectionInvoiceNumber(), itemNumber, fromCal, toCal);
            for(Collections col: arrItems){
                balance += col.getCharge();
                balance -= col.getCredit();
                if(col.getCharge() == 0){
                    mod.addRow(new String[] {Formats.dateFormatDays2.format(col.getLedgerDate())+"",col.getCollectionOrNumber(),col.getParticular()+"",col.getCheckDate()+"", "-", col.getCredit()+"",balance+""});
                } else {
                    mod.addRow(new String[] {Formats.dateFormatDays2.format(col.getLedgerDate())+"",col.getCollectionOrNumber(),col.getParticular()+"",col.getCheckDate()+"", col.getCharge()+"", "-",balance+""});
                }
            }    
               
        }
        return mod;
    }
    
    
    public static DefaultTableModel getPayableLedgerTableData(int itemNumber, String fromCal, String toCal){
       DefaultTableModel mod = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
      
//        mod.setColumnIdentifiers(new String[] {"Date","Particulars","Check Date","Charge","Credit","Balance"});
//        ArrayList<Collections> arrItems = Collections.getAccountsReceivableLedgerWithDate(itemNumber, fromCal, toCal);
//        Double balance = new Double("0");
//        for(Collections emp: arrItems){
//                balance += emp.getCharge();
//                balance -= emp.getCredit();
////                String sCharge;
//                if(emp.getCharge() == 0){
//                    mod.addRow(new String[] {Formats.dateFormatDays.format(emp.getLedgerDate())+"",emp.getParticular()+"",emp.getCheckDate(), "-", emp.getCredit()+"",balance+""});
//                } else {
//                    mod.addRow(new String[] {Formats.dateFormatDays.format(emp.getLedgerDate())+"",emp.getParticular()+"",emp.getCheckDate(), emp.getCharge()+"", "-",balance+""});
//                }
//               
//        }
////        mod.setColumnCount(3);
//        return mod;
       
         mod.setColumnIdentifiers(new String[] {"Date","Particulars","Check Date","Charge","Credit","Balance"});
       ArrayList<Collections> arrInvoice = Collections.getCollectionInvoiceWithDate(itemNumber, fromCal, toCal);
       Double balance = new Double("0");
       for(Collections emp: arrInvoice){
                balance += emp.getCharge();
                balance -= emp.getCredit();
                if(emp.getCharge() == 0){
                    mod.addRow(new String[] {Formats.dateFormatDays2.format(emp.getLedgerDate())+"",emp.getParticular()+"",emp.getCheckDate()+"", "-", emp.getCredit()+"",balance+""});
                } else {
                    mod.addRow(new String[] {Formats.dateFormatDays2.format(emp.getLedgerDate())+"",emp.getParticular()+"",emp.getCheckDate()+"", emp.getCharge()+"", "-",balance+""});
                }
           ArrayList<Collections> arrItems = Collections.getCollectionWithDate(emp.getCollectionInvoiceNumber(), itemNumber, fromCal, toCal);
            for(Collections col: arrItems){
                balance += col.getCharge();
                balance -= col.getCredit();
                if(col.getCharge() == 0){
                    mod.addRow(new String[] {Formats.dateFormatDays2.format(col.getLedgerDate())+"",col.getParticular()+"",col.getCheckDate()+"", "-", col.getCredit()+"",balance+""});
                } else {
                    mod.addRow(new String[] {Formats.dateFormatDays2.format(col.getLedgerDate())+"",col.getParticular()+"",col.getCheckDate()+"", col.getCharge()+"", "-",balance+""});
                }
            }    
               
        }
        return mod;
    }
    
    public static DefaultTableModel getAccountsLedgerTableData(int itemNumber, String fromCal, String toCal){
       DefaultTableModel mod = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
      
//        mod.setColumnIdentifiers(new String[] {"Date","Particulars","Check Date","Charge","Credit","Balance"});
//        ArrayList<Collections> arrItems = Collections.getAccountsReceivableLedgerWithDate(itemNumber, fromCal, toCal);
//        Double balance = new Double("0");
//        for(Collections emp: arrItems){
//                balance += emp.getCharge();
//                balance -= emp.getCredit();
////                String sCharge;
//                if(emp.getCharge() == 0){
//                    mod.addRow(new String[] {Formats.dateFormatDays.format(emp.getLedgerDate())+"",emp.getParticular()+"",emp.getCheckDate()+"", "-", emp.getCredit()+"",balance+""});
//                } else {
//                    mod.addRow(new String[] {Formats.dateFormatDays.format(emp.getLedgerDate())+"",emp.getParticular()+"",emp.getCheckDate()+"", emp.getCharge()+"", "-",balance+""});
//                }
//               
//        }
       
//        mod.setColumnCount(3);
//       mod.setColumnIdentifiers(new String[] {"Invoice_id","Date","OR #","Particulars","Check Date","Charge","Credit","Balance"});
//       ArrayList<Collections> arrInvoice = Collections.getAccountWithDate(itemNumber, fromCal, toCal);
//       double balanceAsOf =0;
//       for(Collections emp: arrInvoice){
//                if(emp.getCharge() == 0){
//                    balanceAsOf-=emp.getCredit();
////                    mod.addRow(new String[] {Formats.dateFormatDays2.format(emp.getLedgerDate())+"",emp.getCollectionOrNumber(),emp.getParticular()+"",emp.getCheckDate()+"", "-", Formats.centavoDecimal.format(emp.getCredit())+"",Formats.centavoDecimal.format(emp.getCollectionBalanceAsOf())+""});
//                    mod.addRow(new String[] {emp.getCollectionInvoiceNumber()+"",Formats.dateFormatDays2.format(emp.getLedgerDate())+"",emp.getCollectionOrNumber(),emp.getParticular()+" - "+ emp.getCollectionInvoiceNumber(),emp.getCheckDate()+"", "-", Formats.centavoDecimal.format(emp.getCredit())+"",Formats.centavoDecimal.format(balanceAsOf)+""});
//                } else {
//                    balanceAsOf+=emp.getCharge();
//                    mod.addRow(new String[] {emp.getCollectionInvoiceNumber()+"",Formats.dateFormatDays2.format(emp.getLedgerDate())+"",emp.getCollectionOrNumber(),emp.getParticular()+" - "+emp.getCollectionInvoiceNumber(),emp.getCheckDate()+"", Formats.centavoDecimal.format(emp.getCharge())+"", "-",Formats.centavoDecimal.format(balanceAsOf)+""});
//                }
//           
//        }
       mod.setColumnIdentifiers(new String[] {"Invoice_id","Invoice_Date","Payment_Date","Invoice_Number","Particulars","Check Date","Charge","Credit","Balance"});
       ArrayList<Collections> arrInvoice = Collections.getAccountWithDate(itemNumber, fromCal, toCal);
       double balanceAsOf =0;
       for(Collections emp: arrInvoice){
           
                String invoiceDate;
                String collectionDate;
                invoiceDate = emp.getCollectionDelDate()==null? "-":Formats.dateFormatDays2.format(emp.getCollectionDelDate());
                collectionDate = emp.getCollectionDate()==null? "-":Formats.dateFormatDays2.format(emp.getCollectionDate());
                
                if(emp.getCharge() == 0){
                    balanceAsOf-=emp.getCredit();
//                    mod.addRow(new String[] {Formats.dateFormatDays2.format(emp.getLedgerDate())+"",emp.getCollectionOrNumber(),emp.getParticular()+"",emp.getCheckDate()+"", "-", Formats.centavoDecimal.format(emp.getCredit())+"",Formats.centavoDecimal.format(emp.getCollectionBalanceAsOf())+""});
                    mod.addRow(new String[] {emp.getCollectionInvoiceNumber()+"",invoiceDate,collectionDate,emp.getParticular(),"-",emp.getCheckDate()+"", "-", Formats.centavoDecimal.format(emp.getCredit())+"",Formats.centavoDecimal.format(balanceAsOf)+""});
                } else {
                    balanceAsOf+=emp.getCharge();
                    mod.addRow(new String[] {emp.getCollectionInvoiceNumber()+"",invoiceDate,collectionDate,"-",emp.getParticular(),emp.getCheckDate()+"", Formats.centavoDecimal.format(emp.getCharge())+"", "-",Formats.centavoDecimal.format(balanceAsOf)+""});
                }
           
        }
        return mod;
    }
    
    
    
     public static DefaultTableModel getCollectionListTableData(String invoiceNumber){
       DefaultTableModel mod = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
      
//        mod.setColumnIdentifiers(new String[] {"Collection Date","Particulars","Amount","Check Date","Cleared","Add Date","Added by", "Edited Date", "Edited by", "collection id"});
        mod.setColumnIdentifiers(new String[] {"Collection Date","Particulars","Amount","Check Date","Cleared","Add Date","Added by", "collection id"});
        ArrayList<Collections> arrItems = Collections.getInvoiceCollectionsUsingId(invoiceNumber);
//        Double balance = new Double("0");
        for(Collections emp: arrItems){
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
            String checkDate = "-";
            String cleared = "-";
            if(emp.getCollectionClearedFlag() == 1){
//                if(emp.getCollectionTypeFlag() == 1 && emp.getCollectionClearedFlag() == 1){
                cleared = "\u2713";
            }
            if(emp.getCollectionAddDate() != null){
                addDate = Formats.dateFormatDays.format(emp.getCollectionAddDate());
            }
            if(emp.getCollectionCheckDate() != null){
                checkDate = Formats.dateFormatDays.format(emp.getCollectionCheckDate());
            }
            if(emp.getCollectionEditDate() != null){
                editDate = Formats.dateFormatDays.format(emp.getCollectionEditDate());
            }
            if(emp.getCollectionDate() != null){
                collectionDate = Formats.dateFormatDays.format(emp.getCollectionDate());
            }
//                mod.addRow(new String[] {collectionDate+"",emp.getParticular()+"", emp.getCollectionAmount()+"", checkDate, cleared,
//                    addDate,emp.getCollectionAddUser(), editDate, emp.getCollectionEditUser(), emp.getCollectionId()+""});
            mod.addRow(new String[] {collectionDate+"",emp.getParticular()+"", emp.getCollectionAmount()+"", checkDate, cleared,
                    addDate,emp.getCollectionAddUser(), emp.getCollectionId()+""});
                
               
        }
//        mod.setColumnCount(3);
        return mod;
    }
     
     
       public static DefaultTableModel getCollectionPostDatedTableData(int clientId){
       DefaultTableModel mod = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
      
//        mod.setColumnIdentifiers(new String[] {"Collection Date","Particulars","Amount","Check Date","Cleared","Add Date","Added by", "Edited Date", "Edited by", "collection id"});
//        mod.setColumnIdentifiers(new String[] {"Collection Date","Particulars","Amount","Check Date","Cleared","Add Date","Added by", "collection id"});
        mod.setColumnIdentifiers(new String[] {"Collection Date","Particulars","Amount","Check Date","Cleared","Add Date","Added by"});
        ArrayList<Collections> arrItems = Collections.getPostDatedCollections(clientId);
//        Double balance = new Double("0");
        for(Collections emp: arrItems){
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
            String checkDate = "-";
            String cleared = "-";
            if(emp.getCollectionClearedFlag() == 1){
//                if(emp.getCollectionTypeFlag() == 1 && emp.getCollectionClearedFlag() == 1){
                cleared = "\u2713";
            }
            if(emp.getCollectionAddDate() != null){
                addDate = Formats.dateFormatDays2.format(emp.getCollectionAddDate());
            }
            if(emp.getCollectionCheckDate() != null){
                checkDate = Formats.dateFormatDays2.format(emp.getCollectionCheckDate());
            }
            if(emp.getCollectionEditDate() != null){
                editDate = Formats.dateFormatDays2.format(emp.getCollectionEditDate());
            }
            if(emp.getCollectionDate() != null){
                collectionDate = Formats.dateFormatDays2.format(emp.getCollectionDate());
            }
//                mod.addRow(new String[] {collectionDate+"",emp.getParticular()+"", emp.getCollectionAmount()+"", checkDate, cleared,
//                    addDate,emp.getCollectionAddUser(), editDate, emp.getCollectionEditUser(), emp.getCollectionId()+""});
            mod.addRow(new String[] {collectionDate+"",emp.getParticular()+"", Formats.centavoDecimal.format(emp.getCollectionAmount())+"", checkDate, cleared,
                    addDate,emp.getCollectionAddUser()});
                
               
        }
//        mod.setColumnCount(3);
        return mod;
    }
       
       
     public static DefaultTableModel getCollectionDailyTableData(int year, int day, int month){
       DefaultTableModel mod = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
      GregorianCalendar c = new GregorianCalendar(year, month, day);
//        mod.setColumnIdentifiers(new String[] {"Collection Date","Particulars","Amount","Check Date","Cleared","Add Date","Added by", "Edited Date", "Edited by", "collection id"});
        mod.setColumnIdentifiers(new String[] {"Customer Name","OR #","Particulars","Amount"});
        ArrayList<Collections> arrItems = Collections.getCollectionsWithDate(Formats.dateFormatDays.format(c.getTime()));
        Double balance = new Double("0");
        for(Collections emp: arrItems){
                
//                balance -= emp.getCredit();
//                String sCharge;
//                if(emp.getCharge() == 0){
//                    mod.addRow(new String[] {Formats.dateFormatDays.format(emp.getLedgerDate())+"",emp.getParticular()+"", "-", emp.getCredit()+"",balance+""});
//                } else {
//                    mod.addRow(new String[] {Formats.dateFormatDays.format(emp.getLedgerDate())+"",emp.getParticular()+"", emp.getCharge()+"", "-",balance+""});
            String addDate = "-";
            String editDate = "-";
            String collectionDate = "-";
            String checkDate = "-";
            String cleared = "-";
            if(emp.getCollectionClearedFlag() == 1){
//                if(emp.getCollectionTypeFlag() == 1 && emp.getCollectionClearedFlag() == 1){
                cleared = "\u2713";
            }
            if(emp.getCollectionAddDate() != null){
                addDate = Formats.dateFormatDays2.format(emp.getCollectionAddDate());
            }
            if(emp.getCollectionCheckDate() != null){
                checkDate = Formats.dateFormatDays2.format(emp.getCollectionCheckDate());
            }
            if(emp.getCollectionEditDate() != null){
                editDate = Formats.dateFormatDays2.format(emp.getCollectionEditDate());
            }
            if(emp.getCollectionDate() != null){
                collectionDate = Formats.dateFormatDays2.format(emp.getCollectionDate());
            }
//                mod.addRow(new String[] {collectionDate+"",emp.getParticular()+"", emp.getCollectionAmount()+"", checkDate, cleared,
//                    addDate,emp.getCollectionAddUser(), editDate, emp.getCollectionEditUser(), emp.getCollectionId()+""});
            mod.addRow(new String[] {emp.getClientName()+"",emp.getCollectionOrNumber(),emp.getParticular()+"", Formats.centavoDecimal.format(emp.getCollectionAmount())+""});
            balance += emp.getCollectionAmount();
              
        }
         mod.addRow(new String[] {"","","Total: ", Formats.centavoDecimal.format(balance)+""});
//        mod.setColumnCount(3);
        return mod;
    }
         
           public static DefaultTableModel getPaymentDailyTableData(int year, int day, int month){
       DefaultTableModel mod = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
      GregorianCalendar c = new GregorianCalendar(year, month, day);
//        mod.setColumnIdentifiers(new String[] {"Collection Date","Particulars","Amount","Check Date","Cleared","Add Date","Added by", "Edited Date", "Edited by", "collection id"});
        mod.setColumnIdentifiers(new String[] {"Supplier Name","OR #","Particulars","Amount"});
        ArrayList<Collections> arrItems = Collections.getPaymentsWithDate(Formats.dateFormatDays.format(c.getTime()));
        Double balance = new Double("0");
        for(Collections emp: arrItems){
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
            String checkDate = "-";
            String cleared = "-";
            if(emp.getCollectionClearedFlag() == 1){
//                if(emp.getCollectionTypeFlag() == 1 && emp.getCollectionClearedFlag() == 1){
                cleared = "\u2713";
            }
            if(emp.getCollectionAddDate() != null){
                addDate = Formats.dateFormatDays2.format(emp.getCollectionAddDate());
            }
            if(emp.getCollectionCheckDate() != null){
                checkDate = Formats.dateFormatDays2.format(emp.getCollectionCheckDate());
            }
            if(emp.getCollectionEditDate() != null){
                editDate = Formats.dateFormatDays2.format(emp.getCollectionEditDate());
            }
            if(emp.getCollectionDate() != null){
                collectionDate = Formats.dateFormatDays2.format(emp.getCollectionDate());
            }
//                mod.addRow(new String[] {collectionDate+"",emp.getParticular()+"", emp.getCollectionAmount()+"", checkDate, cleared,
//                    addDate,emp.getCollectionAddUser(), editDate, emp.getCollectionEditUser(), emp.getCollectionId()+""});
            mod.addRow(new String[] {emp.getClientName()+"",emp.getCollectionOrNumber(),emp.getParticular()+"", Formats.centavoDecimal.format(emp.getCollectionAmount())+""});
                
                               balance += emp.getCollectionAmount();
        }
//        mod.setColumnCount(3);
         mod.addRow(new String[] {"","","Total: ", Formats.centavoDecimal.format(balance)+""});
        return mod;
    }
           
           
 public static DefaultTableModel getDailySalesXTableData(int year, int day, int month, boolean isCollection, int reportType){
       DefaultTableModel mod = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
      GregorianCalendar cFrom = new GregorianCalendar(year, month, day);
        String firstColumn = new String();
        int collectionType = 0;
        if(isCollection){
            firstColumn = "Customer Name";
        }else{
            firstColumn = "Supplier Name";
            collectionType =1;
        }
        GregorianCalendar cTo = new GregorianCalendar(year, month, day,23,59);
        switch(reportType){
            case 1:
                    cFrom.set(GregorianCalendar.DAY_OF_MONTH, 1);
                    cTo.set(GregorianCalendar.DAY_OF_MONTH, cFrom.getActualMaximum(GregorianCalendar.DAY_OF_MONTH));
                    break;
            case 2: 
                    cFrom.set(GregorianCalendar.MONTH, 0);
                    cTo.set(GregorianCalendar.MONTH, 11);
                    cFrom.set(GregorianCalendar.DAY_OF_MONTH, 1);
                    cTo.set(GregorianCalendar.DAY_OF_MONTH, cTo.getActualMaximum(GregorianCalendar.DAY_OF_MONTH));
                    
                    
                    break;
            default: 
                    
        }
        System.out.println("From Date: "+Formats.dateFormatMinutes.format(cFrom.getTime())+" To Date: "+Formats.dateFormatMinutes.format(cTo.getTime()));
        
        mod.setColumnIdentifiers(new String[] {firstColumn,"OR #","Particulars","Amount"});
        ArrayList<Collections> arrItems = Collections.getCollectionPaymentsWithDate(Formats.dateFormatMinutes.format(cFrom.getTime()),Formats.dateFormatMinutes.format(cTo.getTime()),collectionType);
        Double balance = new Double("0");
        for(Collections emp: arrItems){
                
//                balance -= emp.getCredit();
//                String sCharge;
//                if(emp.getCharge() == 0){
//                    mod.addRow(new String[] {Formats.dateFormatDays.format(emp.getLedgerDate())+"",emp.getParticular()+"", "-", emp.getCredit()+"",balance+""});
//                } else {
//                    mod.addRow(new String[] {Formats.dateFormatDays.format(emp.getLedgerDate())+"",emp.getParticular()+"", emp.getCharge()+"", "-",balance+""});
            String addDate = "-";
            String editDate = "-";
            String collectionDate = "-";
            String checkDate = "-";
            String cleared = "-";
            String orNumber = emp.getCollectionOrNumber();
            if(emp.getCollectionClearedFlag() == 1){
//                if(emp.getCollectionTypeFlag() == 1 && emp.getCollectionClearedFlag() == 1){
                cleared = "\u2713";
            }
            if(emp.getCollectionAddDate() != null){
                addDate = Formats.dateFormatDays2.format(emp.getCollectionAddDate());
            }
            if(emp.getCollectionCheckDate() != null){
                checkDate = Formats.dateFormatDays2.format(emp.getCollectionCheckDate());
            }
            if(emp.getCollectionEditDate() != null){
                editDate = Formats.dateFormatDays2.format(emp.getCollectionEditDate());
            }
            if(emp.getCollectionDate() != null){
                collectionDate = Formats.dateFormatDays2.format(emp.getCollectionDate());
            }
            
             if(orNumber.isEmpty()){
                orNumber = "-";
            }
//                mod.addRow(new String[] {collectionDate+"",emp.getParticular()+"", emp.getCollectionAmount()+"", checkDate, cleared,
//                    addDate,emp.getCollectionAddUser(), editDate, emp.getCollectionEditUser(), emp.getCollectionId()+""});
            mod.addRow(new String[] {emp.getClientName()+"",orNumber,emp.getParticular()+"", Formats.centavoDecimal.format(emp.getCollectionAmount())+""});
            balance += emp.getCollectionAmount();
              
        }
         mod.addRow(new String[] {"","","Total: ", Formats.centavoDecimal.format(balance)+""});
//        mod.setColumnCount(3);
        return mod;
    }
 
 //check voucher
public static DefaultTableModel getCheckVoucherTableData(int clientNumber){
       DefaultTableModel mod = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
       
        mod.setColumnIdentifiers(new String[] {"Invoice Date", "Invoice No.", "Amount", "Particulars" ,"Check Date" ,"Amount"});
        ArrayList<CheckVoucher> arrItems = CheckVoucher.getCheckVoucher(clientNumber);
//        double grandTotal =0.0;
//        String checkNumber = new String();
        Double totalCheckAmount = 0.0;
        Double totalInvoiceAmount = 0.0;
        int forwardCounter = 0;
        for(CheckVoucher emp: arrItems){
             String invoiceDate = "-";
            String particularDate = "-";
            if(emp.getInvoiceDate() != null){
                invoiceDate = Formats.dateFormatDays2.format(emp.getInvoiceDate());
            }
              if(emp.getCollectionCheckDate()!= null){
                particularDate = Formats.dateFormatDays2.format(emp.getCollectionCheckDate());
              }
            totalCheckAmount += emp.getCollectionAmount();
            totalInvoiceAmount += emp.getInvoiceTotalPrice();
            if(forwardCounter == arrItems.size()-1){
                mod.addRow(new String[] {invoiceDate, emp.getInvoiceNumber()+"", Formats.centavoDecimal.format(emp.getInvoiceTotalPrice()).toString()+"", " ", " ", particularDate});
                mod.addRow(new String[] {" ", "TOTAL:", Formats.centavoDecimal.format(totalInvoiceAmount).toString(), emp.getCollectionNumber()+"", Formats.centavoDecimal.format(totalCheckAmount)+"", " "});
           } else{
            CheckVoucher forward = arrItems.get(forwardCounter+1);
           
           if(!emp.getCollectionNumber().equals(forward.getCollectionNumber())){
               mod.addRow(new String[] {invoiceDate, emp.getInvoiceNumber()+"", Formats.centavoDecimal.format(emp.getInvoiceTotalPrice()).toString()+"", " ", " ", particularDate});
                mod.addRow(new String[] {" ", "TOTAL:", Formats.centavoDecimal.format(totalInvoiceAmount).toString(), emp.getCollectionNumber()+"", Formats.centavoDecimal.format(totalCheckAmount)+"", " "});
//              mod.addRow(new String[] {invoiceDate, emp.getInvoiceNumber()+"", Formats.centavoDecimal.format(emp.getInvoiceTotalPrice()).toString()+"", emp.getCollectionNumber()+"", Formats.centavoDecimal.format(totalCheckAmount)+"", particularDate}); 
              totalCheckAmount = 0.0;
              totalInvoiceAmount = 0.0;
           } else{
               mod.addRow(new String[] {invoiceDate, emp.getInvoiceNumber()+"", Formats.centavoDecimal.format(emp.getInvoiceTotalPrice()).toString()+""," "," ", particularDate});
           }
           forwardCounter++;
           
          }
        }
//        mod.addRow(new String[] {" "," ", "Grand Total", Formats.centavoDecimal.format(grandTotal), " "}); 
//        mod.setColumnCount(3);
        return mod;
    }
public static CheckVoucherList getCheckVoucherListData(int clientNumber){
        DefaultTableModel invoiceListMod = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        DefaultTableModel checkListMod = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        invoiceListMod.setColumnIdentifiers(new String[] {"Invoice No.", "Row"});
        checkListMod.setColumnIdentifiers(new String[] {"Check No.", "Row"});
//        DefaultListModel<CheckInvoiceList> invoiceListMod = new DefaultListModel();
//        DefaultListModel<CheckInvoiceList> checkListMod = new DefaultListModel();
        CheckVoucherList checkVoucherList = new CheckVoucherList();
//        mod.setColumnIdentifiers(new String[] {"Invoice Date", "Invoice No.", "Amount", "Particulars" ,"Amount" ,"Date"});

        ArrayList<CheckVoucher> invoiceArrItems = CheckVoucher.getInvoiceCheckVoucher(clientNumber);
        ArrayList<CheckVoucher> collectionArrItems = CheckVoucher.getCollectionCheckVoucher(clientNumber);
        checkVoucherList.setCheckVoucherList(invoiceArrItems);
        Double invoiceTotalCheckAmount = 0.0;
        Double invoiceTotalInvoiceAmount = 0.0;
        Double checkTotalCheckAmount = 0.0;
        Double checkTotalInvoiceAmount = 0.0;
        int forwardCounter = 0;
        String invoiceNumber = new String();
        String checkNumber = new String();
        int invoiceId =0;
        ArrayList<CheckInvoiceList> invoiceList = new ArrayList();
        ArrayList<CheckInvoiceList> checkList = new ArrayList();
        for(CheckVoucher emp: invoiceArrItems){
             String invoiceDate = "-";
            String particularDate = "-";
            if(emp.getInvoiceDate() != null){
                invoiceDate = Formats.dateFormatDays2.format(emp.getInvoiceDate());
            }
              if(emp.getCollectionCheckDate()!= null){
                particularDate = Formats.dateFormatDays2.format(emp.getCollectionCheckDate());
              }
           
            //If invoice is null Ex. Start of list
            if(invoiceNumber.isEmpty()||invoiceNumber == null){
                CheckInvoiceList invoice = new CheckInvoiceList();
                invoiceNumber = emp.getInvoiceNumber();
                invoiceId = emp.getInvoiceId();
                invoice.setName(invoiceNumber);
                //0 + =current invoice amount
                invoiceTotalInvoiceAmount += emp.getInvoiceTotalPrice();
                invoiceTotalCheckAmount += emp.getCollectionAmount();
                invoice.addCheckVoucher(new String[] {invoiceDate, invoiceNumber, Formats.centavoDecimal.format(emp.getInvoiceTotalPrice())+"", emp.getCollectionNumber(), particularDate, Formats.centavoDecimal.format(emp.getCollectionAmount())});
                invoiceList.add(invoice);
            }else if(emp.getCollectionCreditMemoFlag().equals(new Short("1"))){
                invoiceTotalInvoiceAmount -= emp.getCollectionAmount();
                invoiceList.get(invoiceList.size()-1).addCheckVoucher(new String[] {" ", emp.getCollectionNumber(), "- "+Formats.centavoDecimal.format(emp.getCollectionAmount())+"", " ", " "," "});
            }else if(invoiceNumber.equals(emp.getInvoiceNumber()) && invoiceId == emp.getInvoiceId()){
                invoiceTotalCheckAmount += emp.getCollectionAmount();
                invoiceList.get(invoiceList.size()-1).addCheckVoucher(new String[] {" ", " ", " ", emp.getCollectionNumber(), particularDate, Formats.centavoDecimal.format(emp.getCollectionAmount())});
            }else if(invoiceNumber.equals(emp.getInvoiceNumber())){
                invoiceTotalCheckAmount += emp.getCollectionAmount();
                invoiceTotalInvoiceAmount += emp.getInvoiceTotalPrice();
                invoiceList.get(invoiceList.size()-1).addCheckVoucher(new String[] {" ", " ", Formats.centavoDecimal.format(emp.getInvoiceTotalPrice()), emp.getCollectionNumber(), particularDate, Formats.centavoDecimal.format(emp.getCollectionAmount())});
            }else {
                invoiceList.get(invoiceList.size()-1).addCheckVoucher(new String[] {" ", "TOTAL:", Formats.centavoDecimal.format(invoiceTotalInvoiceAmount), " ", " ",Formats.centavoDecimal.format(invoiceTotalCheckAmount)});
                invoiceTotalCheckAmount = 0.0;
                invoiceTotalInvoiceAmount = 0.0;
                CheckInvoiceList invoice = new CheckInvoiceList();
                invoiceNumber = emp.getInvoiceNumber();
                invoiceId = emp.getInvoiceId();
                invoice.setName(invoiceNumber);
                invoiceTotalInvoiceAmount += emp.getInvoiceTotalPrice();
                invoiceTotalCheckAmount += emp.getCollectionAmount();
                invoice.addCheckVoucher(new String[] {invoiceDate, emp.getInvoiceNumber()+"", Formats.centavoDecimal.format(emp.getInvoiceTotalPrice())+"", emp.getCollectionNumber(), particularDate, Formats.centavoDecimal.format(emp.getCollectionAmount())});
                invoiceList.add(invoice);
            }
            
//            if(checkNumber.isEmpty()||checkNumber.equals(null)){
//                CheckInvoiceList check = new CheckInvoiceList();
//                checkNumber = emp.getCollectionNumber();
//                check.setName(checkNumber);
//                checkTotalCheckAmount += emp.getCollectionAmount();
//                checkTotalInvoiceAmount += emp.getInvoiceTotalPrice();
//                check.addCheckVoucher(new String[] {invoiceDate, emp.getInvoiceNumber()+"", Formats.centavoDecimal.format(emp.getInvoiceTotalPrice()).toString()+"", " ", " ", particularDate});
//                checkList.add(check);
//            } else if(emp.getCollectionCreditMemoFlag().equals(new Short("1"))){
//                checkTotalInvoiceAmount -= emp.getCollectionAmount();
//                checkList.get(checkList.size()-1).addCheckVoucher(new String[] {particularDate, emp.getInvoiceNumber()+" "+emp.getCollectionNumber(), "-"+Formats.centavoDecimal.format(emp.getCollectionAmount()).toString()+"", " ", " ", particularDate});
//            }else if(checkNumber.equals(emp.getCollectionNumber())){
//                checkTotalInvoiceAmount += emp.getInvoiceTotalPrice();
//                checkList.get(checkList.size()-1).addCheckVoucher(new String[] {invoiceDate, emp.getInvoiceNumber()+"", Formats.centavoDecimal.format(emp.getInvoiceTotalPrice()).toString()+"", " ", " ", particularDate});
//            }else {
//                checkList.get(checkList.size()-1).addCheckVoucher(new String[] {" ", "TOTAL:", Formats.centavoDecimal.format(checkTotalInvoiceAmount), checkNumber+"", Formats.centavoDecimal.format(checkTotalCheckAmount)+"", " "});
////                invoiceTotalCheckAmount = 0.0;
////                invoiceTotalInvoiceAmount = 0.0;
//                CheckInvoiceList check = new CheckInvoiceList();
//                checkNumber = emp.getCollectionNumber();
//                check.setName(checkNumber);
//                check.addCheckVoucher(new String[] {invoiceDate, emp.getInvoiceNumber()+"", Formats.centavoDecimal.format(emp.getInvoiceTotalPrice()).toString()+"", " ", " ", particularDate});
//                checkList.add(check);
//            }
            
            
            
            
//                mod.addRow();
//                mod.addRow(new String[] {" ", "TOTAL:", Formats.centavoDecimal.format(totalInvoiceAmount).toString(), emp.getCollectionNumber()+"", Formats.centavoDecimal.format(totalCheckAmount)+"", " "});
//           } else{
//            CheckVoucher forward = arrItems.get(forwardCounter+1);
//           
//           if(!emp.getCollectionNumber().equals(forward.getCollectionNumber())){
//               mod.addRow(new String[] {invoiceDate, emp.getInvoiceNumber()+"", Formats.centavoDecimal.format(emp.getInvoiceTotalPrice()).toString()+"", " ", " ", particularDate});
//                mod.addRow(new String[] {" ", "TOTAL:", Formats.centavoDecimal.format(totalInvoiceAmount).toString(), emp.getCollectionNumber()+"", Formats.centavoDecimal.format(totalCheckAmount)+"", " "});
////              mod.addRow(new String[] {invoiceDate, emp.getInvoiceNumber()+"", Formats.centavoDecimal.format(emp.getInvoiceTotalPrice()).toString()+"", emp.getCollectionNumber()+"", Formats.centavoDecimal.format(totalCheckAmount)+"", particularDate}); 
//              totalCheckAmount = 0.0;
//              totalInvoiceAmount = 0.0;
//           } else{
//               mod.addRow(new String[] {invoiceDate, emp.getInvoiceNumber()+"", Formats.centavoDecimal.format(emp.getInvoiceTotalPrice()).toString()+""," "," ", particularDate});
//           }
//           forwardCounter++;
//           
//          }
        }
        int arrCount = 0;
        for(CheckVoucher emp: collectionArrItems){
            String invoiceDate = "-";
            String particularDate = "-";
            if(emp.getInvoiceDate() != null){
                invoiceDate = Formats.dateFormatDays2.format(emp.getInvoiceDate());
            }
              if(emp.getCollectionCheckDate()!= null){
                particularDate = Formats.dateFormatDays2.format(emp.getCollectionCheckDate());
              }
              if(checkNumber.isEmpty()||checkNumber==null){
                  System.out.println(emp.getCollectionNumber());
                CheckInvoiceList check = new CheckInvoiceList();
                //checkNumber = emp.getCollectionNumber();
                checkNumber = (emp.getCollectionNumber() == null)? "none": emp.getCollectionNumber();
                check.setName(checkNumber);
                check.addSubCategory(emp.getInvoiceNumber());
                checkTotalCheckAmount += emp.getCollectionAmount();
                checkTotalInvoiceAmount += emp.getInvoiceTotalPrice();
//                check.setCheckTotalAmount(checkTotalCheckAmount);
//                check.setInvoiceTotalAmount(checkTotalInvoiceAmount);
                check.addCheckVoucher(new String[] {invoiceDate, emp.getInvoiceNumber()+"", Formats.centavoDecimal.format(emp.getInvoiceTotalPrice()).toString()+"", checkNumber, particularDate, Formats.centavoDecimal.format(emp.getCollectionAmount())});
                checkList.add(check);
            } else if(emp.getCollectionCreditMemoFlag().equals(new Short("1"))){
                
                int index = searchListIndex(checkList, emp.getInvoiceNumber());
                double checkTotalInvoice = checkList.get(index).getInvoiceTotalAmount();
                checkList.get(index).setInvoiceTotalAmount(checkTotalInvoice -= emp.getCollectionAmount());
//                checkList.get(checkList.size()-1).addCheckVoucher(new String[] {particularDate, emp.getInvoiceNumber()+" "+emp.getCollectionNumber(), "-"+Formats.centavoDecimal.format(emp.getCollectionAmount()).toString()+"", " ", " ", particularDate});
                checkList.get(index).addCheckVoucher(new String[] {" ", emp.getCollectionNumber(), "- "+Formats.centavoDecimal.format(emp.getCollectionAmount()).toString()+"", " ", " ", " "});
            }else if(checkNumber.equals(emp.getCollectionNumber())){
                checkTotalInvoiceAmount += emp.getInvoiceTotalPrice();
                checkTotalCheckAmount += emp.getCollectionAmount();
                checkList.get(checkList.size()-1).addSubCategory(emp.getInvoiceNumber());
                checkList.get(checkList.size()-1).addCheckVoucher(new String[] {invoiceDate, emp.getInvoiceNumber()+"", Formats.centavoDecimal.format(emp.getInvoiceTotalPrice()).toString()+"", " ", particularDate, Formats.centavoDecimal.format(emp.getCollectionAmount())});
            }else {
                checkList.get(checkList.size()-1).setCheckTotalAmount(checkTotalCheckAmount);
                checkList.get(checkList.size()-1).setInvoiceTotalAmount(checkTotalInvoiceAmount);
//                checkList.get(checkList.size()-1).addCheckVoucher(new String[] {" ", "TOTAL:", Formats.centavoDecimal.format(checkTotalInvoiceAmount), " ", Formats.centavoDecimal.format(checkTotalCheckAmount)+"", " "});
                checkTotalCheckAmount = 0.0;
                checkTotalInvoiceAmount = 0.0;
                CheckInvoiceList check = new CheckInvoiceList();
                checkNumber = emp.getCollectionNumber();
                check.addSubCategory(emp.getInvoiceNumber());
                check.setName(checkNumber);
                 checkTotalCheckAmount += emp.getCollectionAmount();
                checkTotalInvoiceAmount += emp.getInvoiceTotalPrice();
                check.addCheckVoucher(new String[] {invoiceDate, emp.getInvoiceNumber()+"", Formats.centavoDecimal.format(emp.getInvoiceTotalPrice()).toString()+"", checkNumber, particularDate, Formats.centavoDecimal.format(emp.getCollectionAmount())});
                checkList.add(check);
            }
         System.out.println("Error Happening at "+arrCount+" Invoice is "+emp.getCollectionInvoiceId());     
         arrCount++;     
        }
//        checkList.get(checkList.size()-1).addCheckVoucher(new String[] {" ", "TOTAL:", Formats.centavoDecimal.format(checkTotalInvoiceAmount).toString(), " ", Formats.centavoDecimal.format(checkTotalCheckAmount)+"", " "});
        
        invoiceList.get(invoiceList.size()-1).addCheckVoucher(new String[] {" ", "TOTAL:", Formats.centavoDecimal.format(invoiceTotalInvoiceAmount).toString(), " "," ", Formats.centavoDecimal.format(invoiceTotalCheckAmount)});
        
        
        int invoiceCnt = 0;
        for(CheckInvoiceList cList:checkList){
            checkListMod.addRow(new String[] {cList.getName(), invoiceCnt+""});
            invoiceCnt++;
        }
        int checkCnt = 0;
        checkVoucherList.setCheckListModel(checkListMod);
        for(CheckInvoiceList iList:invoiceList){
            invoiceListMod.addRow(new String[] {iList.getName(), checkCnt+""});
            checkCnt++;
        }
        checkVoucherList.setInvoiceListModel(invoiceListMod);
        checkVoucherList.setInvoiceList(invoiceList);
        checkVoucherList.setCheckNumberList(checkList);
//        mod.addRow(new String[] {" "," ", "Grand Total", Formats.centavoDecimal.format(grandTotal), " "}); 
//        mod.setColumnCount(3);
        return checkVoucherList;
    }

private static int searchListIndex(ArrayList<CheckInvoiceList> arr, String id){
    int index = -1;
    int i =0;
    for(CheckInvoiceList emp: arr){
        if(emp.getSubCategoryList().contains(id)){
            return i;
        }
        i++;
    }
    return index;
}
}

