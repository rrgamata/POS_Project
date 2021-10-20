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
import org.joda.time.DateTime;
import pos_project.classes.Collections;
import static pos_project.classes.Collections.deleteCollectionWithInvoice;
import pos_project.classes.Formats;
import pos_project.classes.Invoice;
import pos_project.classes.Item;
import pos_project.classes.SQLConnection;
import pos_project.classes.Stocks;
import pos_project.classes.Transaction;

/**
 *
 * @author Cif3r
 */
public class InvoiceAction {
    
    
    public static int insertInInvoice( int clientNumber, String price, String receiptNo, boolean isReceivable, int paymentType){
       Invoice c = new Invoice();
       c.setInvoiceNumber(receiptNo);
       
       c.setInvoiceTotalPrice(Double.parseDouble(price));
       c.setInvoiceCurrentBalance(Double.parseDouble(price));
       c.setInvoicePaymentType(Short.parseShort(""+paymentType));
       c.setInvoiceClientNumber(clientNumber);
       //IN FLAG
       c.setInvoiceTypeFlag(Short.parseShort("1"));
       //1: CREDIT 0:CASH
        if(isReceivable){
           c.setInvoiceReceivableFlag(new Short("1"));
           c.setInvoicePaidFlag(new Short("0"));
       } else {
           c.setInvoiceReceivableFlag(new Short("0"));
           c.setInvoicePaidFlag(new Short("1"));
       }
       GregorianCalendar cal = new GregorianCalendar();
       c.setInvoiceDate(cal.getTime());
       switch(paymentType){
           case 1:
               cal.add(GregorianCalendar.DAY_OF_MONTH, 7);
               c.setInvoiceDueDate(cal.getTime());
               break;
           case 2:
               cal.add(GregorianCalendar.DAY_OF_MONTH, 15);
               c.setInvoiceDueDate(cal.getTime());
               break;
           case 3:
               cal.add(GregorianCalendar.DAY_OF_MONTH, 30);
               c.setInvoiceDueDate(cal.getTime());
               break;
           default:
               c.setInvoiceDueDate(cal.getTime());
       }
       return (Invoice.addInInvoice(c));
                   
    }
    
    public static int insertInInvoice( int clientNumber, String price, String receiptNo, boolean isReceivable, int paymentType, Connection con) throws SQLException{
       Invoice c = new Invoice();
       c.setInvoiceNumber(receiptNo);
       
       c.setInvoiceTotalPrice(Double.parseDouble(price));
       c.setInvoiceCurrentBalance(Double.parseDouble(price));
       c.setInvoicePaymentType(Short.parseShort(""+paymentType));
       c.setInvoiceClientNumber(clientNumber);
       //IN FLAG
       c.setInvoiceTypeFlag(Short.parseShort("1"));
       //1: CREDIT 0:CASH
        if(isReceivable){
           c.setInvoiceReceivableFlag(new Short("1"));
           c.setInvoicePaidFlag(new Short("0"));
       } else {
           c.setInvoiceReceivableFlag(new Short("0"));
           c.setInvoicePaidFlag(new Short("1"));
       }
       GregorianCalendar cal = new GregorianCalendar();
       c.setInvoiceDate(cal.getTime());
       switch(paymentType){
           case 1:
               cal.add(GregorianCalendar.DAY_OF_MONTH, 7);
               c.setInvoiceDueDate(cal.getTime());
               break;
           case 2:
               cal.add(GregorianCalendar.DAY_OF_MONTH, 15);
               c.setInvoiceDueDate(cal.getTime());
               break;
           case 3:
               cal.add(GregorianCalendar.DAY_OF_MONTH, 30);
               c.setInvoiceDueDate(cal.getTime());
               break;
           default:
               c.setInvoiceDueDate(cal.getTime());
       }
       return (Invoice.addInInvoice(c,con));
                   
    }
    
    public static int insertInInvoice( int clientNumber, String price,Double balance, String receiptNo, boolean isReceivable, int paymentType, int year, int month, int day, Connection con) throws SQLException{
       Invoice c = new Invoice();
       c.setInvoiceNumber(receiptNo);
       
       c.setInvoiceTotalPrice(Double.parseDouble(price));
       c.setInvoiceCurrentBalance(balance);
       c.setInvoicePaymentType(Short.parseShort(""+paymentType));
       c.setInvoiceClientNumber(clientNumber);
       //IN FLAG
       c.setInvoiceTypeFlag(Short.parseShort("1"));
       //1: CREDIT 0:CASH
        if(isReceivable){
           c.setInvoiceReceivableFlag(new Short("1"));
           c.setInvoicePaidFlag(new Short("0"));
       } else {
           c.setInvoiceReceivableFlag(new Short("0"));
           c.setInvoicePaidFlag(new Short("1"));
       }
       GregorianCalendar cal = new GregorianCalendar();
       cal.set(GregorianCalendar.YEAR, year);
       cal.set(GregorianCalendar.MONTH, month);
       cal.set(GregorianCalendar.DATE, day);
       
       c.setInvoiceDate(cal.getTime());
//       switch(paymentType){
//           case 1:
//               cal.add(GregorianCalendar.DAY_OF_MONTH, 7);
//               c.setInvoiceDueDate(cal.getTime());
//               break;
//           case 2:
//               cal.add(GregorianCalendar.DAY_OF_MONTH, 15);
//               c.setInvoiceDueDate(cal.getTime());
//               break;
//           case 3:
//               cal.add(GregorianCalendar.DAY_OF_MONTH, 30);
//               c.setInvoiceDueDate(cal.getTime());
//               break;
//           default:
//               c.setInvoiceDueDate(cal.getTime());
//       }
       c.setInvoiceDueDate(getDueDate(cal, paymentType));
              c.setInvoiceAddDate(new GregorianCalendar().getTime());
       c.setInvoiceAddUser(System.getProperty("userName"));
       return (Invoice.addInInvoice(c,con));
                   
    }
    
    public static int insertOutInvoice( int clientNumber, String price, String receiptNo, boolean isReceivable, int paymentType){
       
       Invoice c = new Invoice();
       c.setInvoiceNumber(receiptNo);
       c.setInvoiceTotalPrice(Double.parseDouble(price));
       c.setInvoiceCurrentBalance(Double.parseDouble(price));
       c.setInvoicePaymentType(Short.parseShort(""+paymentType));
       c.setInvoiceClientNumber(clientNumber);
       //IN FLAG
       c.setInvoiceTypeFlag(Short.parseShort("1"));
       //1: CREDIT 0:CASH
       if(isReceivable){
           c.setInvoiceReceivableFlag(new Short("1"));
           c.setInvoicePaidFlag(new Short("0"));
       } else {
           c.setInvoiceReceivableFlag(new Short("0"));
           c.setInvoicePaidFlag(new Short("1"));
       }
       GregorianCalendar cal = new GregorianCalendar();
       c.setInvoiceDate(cal.getTime());
       switch(paymentType){
           case 1:
               cal.add(GregorianCalendar.DAY_OF_MONTH, 7);
               c.setInvoiceDueDate(cal.getTime());
               break;
           case 2:
               cal.add(GregorianCalendar.DAY_OF_MONTH, 15);
               c.setInvoiceDueDate(cal.getTime());
               break;
           case 3:
               cal.add(GregorianCalendar.DAY_OF_MONTH, 30);
               c.setInvoiceDueDate(cal.getTime());
               break;
           default:
               c.setInvoiceDueDate(cal.getTime());
               
       }
       return (Invoice.addOutInvoice(c));
                   
    }
    
    public static int insertOutInvoice( int clientNumber, String price, String receiptNo, boolean isReceivable, int paymentType, Connection con){
       
       Invoice c = new Invoice();
       c.setInvoiceNumber(receiptNo);
       c.setInvoiceTotalPrice(Double.parseDouble(price));
       c.setInvoiceCurrentBalance(Double.parseDouble(price));
       c.setInvoicePaymentType(Short.parseShort(""+paymentType));
       c.setInvoiceClientNumber(clientNumber);
       //IN FLAG
       c.setInvoiceTypeFlag(Short.parseShort("1"));
       //1: CREDIT 0:CASH
       if(isReceivable){
           c.setInvoiceReceivableFlag(new Short("1"));
           c.setInvoicePaidFlag(new Short("0"));
       } else {
           c.setInvoiceReceivableFlag(new Short("0"));
           c.setInvoicePaidFlag(new Short("1"));
       }
       GregorianCalendar cal = new GregorianCalendar();
       c.setInvoiceDate(cal.getTime());
       switch(paymentType){
           case 1:
               cal.add(GregorianCalendar.DAY_OF_MONTH, 7);
               c.setInvoiceDueDate(cal.getTime());
               break;
           case 2:
               cal.add(GregorianCalendar.DAY_OF_MONTH, 15);
               c.setInvoiceDueDate(cal.getTime());
               break;
           case 3:
               cal.add(GregorianCalendar.DAY_OF_MONTH, 30);
               c.setInvoiceDueDate(cal.getTime());
               break;
           default:
               c.setInvoiceDueDate(cal.getTime());
               
       }
       return (Invoice.addOutInvoice(c,con));
                   
    }
    
     public static int insertOutInvoice( int clientNumber, String price, Double balance, String receiptNo, boolean isReceivable, int paymentType, int year, int month, int day, Connection con){
       
       Invoice c = new Invoice();
       c.setInvoiceNumber(receiptNo);
       c.setInvoiceTotalPrice(Double.parseDouble(price));
       c.setInvoiceCurrentBalance(balance);
       c.setInvoicePaymentType(Short.parseShort(""+paymentType));
       c.setInvoiceClientNumber(clientNumber);
       //IN FLAG
       c.setInvoiceTypeFlag(Short.parseShort("1"));
       //1: CREDIT 0:CASH
       if(isReceivable){
           c.setInvoiceReceivableFlag(new Short("1"));
           c.setInvoicePaidFlag(new Short("0"));
       } else {
           c.setInvoiceReceivableFlag(new Short("0"));
           c.setInvoicePaidFlag(new Short("1"));
       }
       GregorianCalendar cal = new GregorianCalendar();
       cal.set(GregorianCalendar.YEAR, year);
       cal.set(GregorianCalendar.MONTH, month);
       cal.set(GregorianCalendar.DATE, day);
       c.setInvoiceDate(cal.getTime());
       c.setInvoiceDueDate(getDueDate(cal, paymentType));
       c.setInvoiceAddDate(new GregorianCalendar().getTime());
       c.setInvoiceAddUser(System.getProperty("userName"));
       return (Invoice.addOutInvoice(c,con));
                   
    }
     
     
     public static int insertInvoice( int clientNumber, String price, Double balance, String receiptNo, boolean isReceivable, int paymentType, int year, int month, int day, Connection con, int locationId, boolean isOut, String driverName, Integer salespersonId) throws Exception{
       
       Invoice c = new Invoice();
       c.setInvoiceNumber(receiptNo);
       c.setInvoiceTotalPrice(Formats.centavoDecimal.parse(price).doubleValue());
       c.setInvoiceCurrentBalance(balance);
       c.setInvoicePaymentType(Short.parseShort(""+paymentType));
       c.setInvoiceClientNumber(clientNumber);
       //IN FLAG
       c.setInvoiceTypeFlag(Short.parseShort("1"));
       //1: CREDIT 0:CASH
       if(isReceivable){
           c.setInvoiceReceivableFlag(new Short("1"));
           c.setInvoicePaidFlag(new Short("0"));
       } else {
           c.setInvoiceReceivableFlag(new Short("0"));
           c.setInvoicePaidFlag(new Short("1"));
       }
       if(isOut){
           c.setInvoiceTypeFlag(new Short("0"));
       } else {
           c.setInvoiceTypeFlag(new Short("1"));
       }
       GregorianCalendar cal = new GregorianCalendar();
       cal.set(GregorianCalendar.YEAR, year);
       cal.set(GregorianCalendar.MONTH, month);
       cal.set(GregorianCalendar.DATE, day);
       c.setInvoiceDate(cal.getTime());
       c.setInvoiceDueDate(getDueDate(cal, paymentType));
       c.setInvoiceAddDate(new GregorianCalendar().getTime());
       c.setInvoiceAddUser(System.getProperty("userName"));
       c.setInvoiceLocationId(locationId);
       c.setInvoiceDriver(driverName);
       c.setInvoiceSalespersonId(salespersonId);
       return (Invoice.addInvoice(c,con));
     }
     
   //for debitmemo  
   public static int insertInvoice( int clientNumber, String price, Double balance, String receiptNo, boolean isReceivable, int paymentType, int year, int month, int day, Connection con, int locationId, boolean isOut, String driverName, Short dmFlag) throws Exception{
       
       Invoice c = new Invoice();
       c.setInvoiceNumber(receiptNo);
       c.setInvoiceTotalPrice(Formats.centavoDecimal.parse(price).doubleValue());
       c.setInvoiceCurrentBalance(balance);
       c.setInvoicePaymentType(Short.parseShort(""+paymentType));
       c.setInvoiceClientNumber(clientNumber);
       //IN FLAG
       c.setInvoiceTypeFlag(Short.parseShort("1"));
       //1: CREDIT 0:CASH
       if(isReceivable){
           c.setInvoiceReceivableFlag(new Short("1"));
           c.setInvoicePaidFlag(new Short("0"));
       } else {
           c.setInvoiceReceivableFlag(new Short("0"));
           c.setInvoicePaidFlag(new Short("1"));
       }
       if(isOut){
           c.setInvoiceTypeFlag(new Short("0"));
       } else {
           c.setInvoiceTypeFlag(new Short("1"));
       }
       GregorianCalendar cal = new GregorianCalendar();
       cal.set(GregorianCalendar.YEAR, year);
       cal.set(GregorianCalendar.MONTH, month);
       cal.set(GregorianCalendar.DATE, day);
       c.setInvoiceDate(cal.getTime());
       c.setInvoiceDueDate(getDueDate(cal, paymentType));
       c.setInvoiceAddDate(new GregorianCalendar().getTime());
       c.setInvoiceAddUser(System.getProperty("userName"));
       c.setInvoiceLocationId(locationId);
       c.setInvoiceDriver(driverName);
       c.setInvoiceDmFlag(dmFlag);
       return (Invoice.addDebitMemo(c,con));
     }
   
     //For remarks
       public static int insertInvoice( int clientNumber, String price, Double balance, String receiptNo, boolean isReceivable, int paymentType, int year, int month, int day, Connection con, int locationId, boolean isOut, String driverName, String remarks) throws Exception{
       
       Invoice c = new Invoice();
       c.setInvoiceNumber(receiptNo);
       c.setInvoiceTotalPrice(Formats.centavoDecimal.parse(price).doubleValue());
       c.setInvoiceCurrentBalance(balance);
       c.setInvoicePaymentType(Short.parseShort(""+paymentType));
       c.setInvoiceClientNumber(clientNumber);
       //IN FLAG
       c.setInvoiceTypeFlag(Short.parseShort("1"));
       //1: CREDIT 0:CASH
       if(isReceivable){
           c.setInvoiceReceivableFlag(new Short("1"));
           c.setInvoicePaidFlag(new Short("0"));
       } else {
           c.setInvoiceReceivableFlag(new Short("0"));
           c.setInvoicePaidFlag(new Short("1"));
       }
       if(isOut){
           c.setInvoiceTypeFlag(new Short("0"));
       } else {
           c.setInvoiceTypeFlag(new Short("1"));
       }
       GregorianCalendar cal = new GregorianCalendar();
       cal.set(GregorianCalendar.YEAR, year);
       cal.set(GregorianCalendar.MONTH, month);
       cal.set(GregorianCalendar.DATE, day);
       c.setInvoiceDate(cal.getTime());
       c.setInvoiceDueDate(getDueDate(cal, paymentType));
       c.setInvoiceAddDate(new GregorianCalendar().getTime());
       c.setInvoiceAddUser(System.getProperty("userName"));
       c.setInvoiceLocationId(locationId);
       c.setInvoiceDriver(driverName);
       c.setInvoiceRemarks(remarks);
       return (Invoice.addInvoiceRemarks(c,con));
                   
    }
     
     //for debit memo
     public static int insertTransfer( int clientNumber, String price, Double balance, String receiptNo, boolean isReceivable, int paymentType, int year, int month, int day, Connection con, int locationId, boolean isOut) throws Exception{
       
       Invoice c = new Invoice();
       c.setInvoiceNumber(receiptNo);
       c.setInvoiceTotalPrice(Formats.centavoDecimal.parse(price).doubleValue());
       c.setInvoiceCurrentBalance(balance);
       c.setInvoicePaymentType(Short.parseShort(""+paymentType));
       c.setInvoiceClientNumber(clientNumber);
       //IN FLAG
       c.setInvoiceTypeFlag(Short.parseShort("1"));
       //1: CREDIT 0:CASH
       if(isReceivable){
           c.setInvoiceReceivableFlag(new Short("1"));
           c.setInvoicePaidFlag(new Short("0"));
       } else {
           c.setInvoiceReceivableFlag(new Short("0"));
           c.setInvoicePaidFlag(new Short("1"));
       }
       if(isOut){
           c.setInvoiceTypeFlag(new Short("0"));
       } else {
           c.setInvoiceTypeFlag(new Short("1"));
       }
       GregorianCalendar cal = new GregorianCalendar();
       cal.set(GregorianCalendar.YEAR, year);
       cal.set(GregorianCalendar.MONTH, month);
       cal.set(GregorianCalendar.DATE, day);
       c.setInvoiceDate(cal.getTime());
       c.setInvoiceDueDate(getDueDate(cal, paymentType));
       c.setInvoiceAddDate(new GregorianCalendar().getTime());
       c.setInvoiceAddUser(System.getProperty("userName"));
       c.setInvoiceLocationId(locationId);
       c.setInvoiceTransferFlag(new Short("1"));
       return (Invoice.addTransfer(c,con));
                   
    }
     
       public static int editOutInvoice( int invoiceId,int clientNumber, String price, Double balance, String receiptNo, boolean isReceivable, int paymentType, int year, int month, int day, Connection con){
       
       Invoice c = new Invoice();
       c.setInvoiceId(invoiceId);
       c.setInvoiceNumber(receiptNo);
       c.setInvoiceTotalPrice(Double.parseDouble(price));
       c.setInvoiceCurrentBalance(balance);
       c.setInvoicePaymentType(Short.parseShort(""+paymentType));
       c.setInvoiceClientNumber(clientNumber);
       //IN FLAG
       c.setInvoiceTypeFlag(Short.parseShort("1"));
       //1: CREDIT 0:CASH
       if(isReceivable){
           c.setInvoiceReceivableFlag(new Short("1"));
           c.setInvoicePaidFlag(new Short("0"));
       } else {
           c.setInvoiceReceivableFlag(new Short("0"));
           c.setInvoicePaidFlag(new Short("1"));
       }
       c.setInvoiceTypeFlag(Short.parseShort("0"));
       GregorianCalendar cal = new GregorianCalendar();
       cal.set(GregorianCalendar.YEAR, year);
       cal.set(GregorianCalendar.MONTH, month);
       cal.set(GregorianCalendar.DATE, day);
       c.setInvoiceDate(cal.getTime());
       c.setInvoiceDueDate(getDueDate(cal, paymentType));
       c.setInvoiceEditDate(new GregorianCalendar().getTime());
       c.setInvoiceEditUser(System.getProperty("userName"));
       return (Invoice.editInvoice(c,con));
                   
    }
       
       public static int editInInvoice( int invoiceId, int clientNumber, String price,Double balance, String receiptNo, boolean isReceivable, int paymentType, int year, int month, int day, Connection con){
       
       Invoice c = new Invoice();
       c.setInvoiceId(invoiceId);
       c.setInvoiceNumber(receiptNo);
       c.setInvoiceTotalPrice(Double.parseDouble(price));
       c.setInvoiceCurrentBalance(balance);
       c.setInvoicePaymentType(Short.parseShort(""+paymentType));
       c.setInvoiceClientNumber(clientNumber);
       //IN FLAG
       c.setInvoiceTypeFlag(Short.parseShort("1"));
       //1: CREDIT 0:CASH
       if(isReceivable){
           c.setInvoiceReceivableFlag(new Short("1"));
           c.setInvoicePaidFlag(new Short("0"));
       } else {
           c.setInvoiceReceivableFlag(new Short("0"));
           c.setInvoicePaidFlag(new Short("1"));
       }
       c.setInvoiceTypeFlag(Short.parseShort("1"));
       GregorianCalendar cal = new GregorianCalendar();
       cal.set(GregorianCalendar.YEAR, year);
       cal.set(GregorianCalendar.MONTH, month);
       cal.set(GregorianCalendar.DATE, day);
       c.setInvoiceDate(cal.getTime());
       c.setInvoiceDueDate(getDueDate(cal, paymentType));
       c.setInvoiceEditDate(new GregorianCalendar().getTime());
       c.setInvoiceEditUser(System.getProperty("userName"));
       return (Invoice.editInvoice(c,con));
                   
    }
    
    public static int editInvoice( int invoiceId,int clientNumber, String price, Double balance, String receiptNo, boolean isReceivable, int paymentType, int year, int month, int day,int locationId, boolean isOut, Connection con, String driverName, Integer salespersonId)throws Exception{
       
       Invoice c = new Invoice();
       c.setInvoiceId(invoiceId);
       c.setInvoiceNumber(receiptNo);
       c.setInvoiceTotalPrice(Formats.centavoDecimal.parse(price).doubleValue());
       c.setInvoiceCurrentBalance(balance);
       c.setInvoicePaymentType(Short.parseShort(""+paymentType));
       c.setInvoiceClientNumber(clientNumber);
       //IN FLAG
//       c.setInvoiceTypeFlag(Short.parseShort("1"));
       //1: CREDIT 0:CASH
       if(isReceivable){
           c.setInvoiceReceivableFlag(new Short("1"));
           c.setInvoicePaidFlag(new Short("0"));
       } else {
           c.setInvoiceReceivableFlag(new Short("0"));
           c.setInvoicePaidFlag(new Short("1"));
       }
       if(isOut){
           c.setInvoiceTypeFlag(new Short("0"));
       } else {
           c.setInvoiceTypeFlag(new Short("1"));
       }
//       c.setInvoiceTypeFlag(Short.parseShort("0"));
       GregorianCalendar cal = new GregorianCalendar();
       cal.set(GregorianCalendar.YEAR, year);
       cal.set(GregorianCalendar.MONTH, month);
       cal.set(GregorianCalendar.DATE, day);
       c.setInvoiceDate(cal.getTime());
       c.setInvoiceDueDate(getDueDate(cal, paymentType));
       c.setInvoiceEditDate(new GregorianCalendar().getTime());
       c.setInvoiceEditUser(System.getProperty("userName"));
       c.setInvoiceLocationId(locationId);
       c.setInvoiceDriver(driverName);
       c.setInvoiceSalespersonId(salespersonId);
       return (Invoice.editInvoice(c,con));
                   
    }   
       
    public static DefaultTableModel getMainTableData(){
       DefaultTableModel mod = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
       
//        mod.setColumnIdentifiers(new String[] {"Invoice #","IN-OUT","Client","Payment Type","Total Balance", "Transaction", "Date", "Date Due", "Added by", "Add Date", "Edited by", "Edit Date", "invoice number"});
        mod.setColumnIdentifiers(new String[] {"Invoice #","Transaction","Client","Payment Type","Date", "Date Due", "Added by", "Add Date", "Edited by", "Edit Date", "invoice number"});
        int quantity = 0;
        GregorianCalendar cal = new GregorianCalendar();
        cal.add(GregorianCalendar.DAY_OF_MONTH, 1);
        String to = Formats.dateFormatDays.format(cal.getTime());
        cal.set(GregorianCalendar.MONTH, 0);
        cal.set(GregorianCalendar.DAY_OF_MONTH, 1);
        cal.add(GregorianCalendar.YEAR, -1);
        String from = Formats.dateFormatDays.format(cal.getTime());
       
        
        ArrayList<Invoice> arrClients = Invoice.getInvoiceListWithDates(from, to);
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
           mod.addRow(new String[] {emp.getInvoiceNumber()+"",cType+"",emp.getClientName()+"",payment+"",Formats.dateFormatDays2.format(emp.getInvoiceDate())+"",
               dueDate, emp.getInvoiceAddUser(),addDate, emp.getInvoiceEditUser(),editDate, emp.getInvoiceId()+""});
            
        }
        return mod;
    }
    
    
    public static DefaultTableModel searchInvoiceDataForMainTable(String itemNumber){
       DefaultTableModel mod = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
       
//        mod.setColumnIdentifiers(new String[] {"Invoice #","IN-OUT","Client","Payment Type","Total Balance", "Transaction", "Date", "Date Due", "Added by", "Add Date", "Edited by", "Edit Date", "invoice number"});
        mod.setColumnIdentifiers(new String[] {"Invoice #","Transaction","Client","Payment Type","Date", "Date Due", "Added by", "Add Date", "Edited by", "Edit Date", "invoice number"});
        int quantity = 0;
        ArrayList<Invoice> arrClients = Invoice.getInvoiceListWithNumber(itemNumber);
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
           mod.addRow(new String[] {emp.getInvoiceNumber()+"",cType+"",emp.getClientName()+"",payment+"",Formats.dateFormatDays2.format(emp.getInvoiceDate())+"",
               dueDate, emp.getInvoiceAddUser(),addDate, emp.getInvoiceEditUser(),editDate, emp.getInvoiceId()+""});
            
        }
        return mod;
    }
    
     public static DefaultTableModel getDebitMemoTableData(){
       DefaultTableModel mod = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
       
//        mod.setColumnIdentifiers(new String[] {"Invoice #","IN-OUT","Client","Payment Type","Total Balance", "Transaction", "Date", "Date Due", "Added by", "Add Date", "Edited by", "Edit Date", "invoice number"});
        mod.setColumnIdentifiers(new String[] {"Invoice #","Transaction","Client","Payment Type","Date", "Date Due", "Added by", "Add Date", "Edited by", "Edit Date", "invoice number"});
        int quantity = 0;
        ArrayList<Invoice> arrClients = Invoice.getDebitMemoList();
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
           mod.addRow(new String[] {emp.getInvoiceNumber()+"",cType+"",emp.getClientName()+"",payment+"",Formats.dateFormatDays2.format(emp.getInvoiceDate())+"",
               dueDate, emp.getInvoiceAddUser(),addDate, emp.getInvoiceEditUser(),editDate, emp.getInvoiceId()+""});
            
        }
        return mod;
    }
    
    
    public static DefaultTableModel getDailySalesReportData(int year, int month, int day, int reportType){
       DefaultTableModel mod = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
       GregorianCalendar from = new GregorianCalendar(year, month, day);
       GregorianCalendar to = new GregorianCalendar(year, month, day,23,59);
       
       switch(reportType){
            case 1:
                    from.set(GregorianCalendar.DAY_OF_MONTH, 1);
                    to.set(GregorianCalendar.DAY_OF_MONTH, from.getActualMaximum(GregorianCalendar.DAY_OF_MONTH));
                    break;
            case 2: 
                    from.set(GregorianCalendar.MONTH, 0);
                    to.set(GregorianCalendar.MONTH, 11);
                    from.set(GregorianCalendar.DAY_OF_MONTH, 1);
                    to.set(GregorianCalendar.DAY_OF_MONTH, to.getActualMaximum(GregorianCalendar.DAY_OF_MONTH));
                    
                    
                    break;
            default: 
                    
        }
       
//        mod.setColumnIdentifiers(new String[] {"Invoice #","IN-OUT","Client","Payment Type","Total Balance", "Transaction", "Date", "Date Due", "Added by", "Add Date", "Edited by", "Edit Date", "invoice number"});
        mod.setColumnIdentifiers(new String[] {"Invoice #","Transaction","Client","Payment Type","Date", "Date Due", "Total"});
        double total = 0.0;
        ArrayList<Invoice> arrClients = Invoice.getInvoiceList(Formats.dateFormatMinutes.format(from.getTime()),Formats.dateFormatMinutes.format(to.getTime()));
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
           mod.addRow(new String[] {emp.getInvoiceNumber()+"",cType+"",emp.getClientName()+"",payment+"",Formats.dateFormatDays2.format(emp.getInvoiceDate())+"",
               dueDate, Formats.centavoDecimal.format(emp.getInvoiceTotalPrice())+""});
            total += emp.getInvoiceTotalPrice();
        }
        mod.addRow(new String[] {"","","","","",
               "Total: ", Formats.centavoDecimal.format(total)+""});
        return mod;
    }
    
    
    public static DefaultTableModel getDailyOtcReportData(int year, int month, int day, int reportType){
       DefaultTableModel mod = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
       GregorianCalendar from = new GregorianCalendar(year, month, day);
       GregorianCalendar to = new GregorianCalendar(year, month, day,23,59);
       
       
       switch(reportType){
            case 1:
                    from.set(GregorianCalendar.DAY_OF_MONTH, 1);
                    to.set(GregorianCalendar.DAY_OF_MONTH, from.getActualMaximum(GregorianCalendar.DAY_OF_MONTH));
                    break;
            case 2: 
                    from.set(GregorianCalendar.MONTH, 0);
                    to.set(GregorianCalendar.MONTH, 11);
                    from.set(GregorianCalendar.DAY_OF_MONTH, 1);
                    to.set(GregorianCalendar.DAY_OF_MONTH, to.getActualMaximum(GregorianCalendar.DAY_OF_MONTH));
                    
                    
                    break;
            default: 
                    
        }
//        mod.setColumnIdentifiers(new String[] {"Invoice #","IN-OUT","Client","Payment Type","Total Balance", "Transaction", "Date", "Date Due", "Added by", "Add Date", "Edited by", "Edit Date", "invoice number"});
        mod.setColumnIdentifiers(new String[] {"Invoice #","Transaction","Client","Payment Type","Date", "Date Due", "Total"});
        double total = 0.0;
        ArrayList<Invoice> arrClients = Invoice.getOtcList(Formats.dateFormatMinutes.format(from.getTime()),Formats.dateFormatMinutes.format(to.getTime()));
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
           mod.addRow(new String[] {emp.getInvoiceNumber()+"",cType+"",emp.getClientName()+"",payment+"",Formats.dateFormatDays2.format(emp.getInvoiceDate())+"",
               dueDate, Formats.centavoDecimal.format(emp.getInvoiceTotalPrice())+""});
            total+=emp.getInvoiceTotalPrice();
        }
        mod.addRow(new String[] {"","","","","",
               "Total: ", Formats.centavoDecimal.format(total)+""});
        
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
       mod.setColumnIdentifiers(new String[] {"Invoice #","Transaction","Client","Pay Type","Total","Date", "Date Due","Edited by"
                , "Edit Date", "invoice number"});
        int quantity = 0;
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
    
    public static DefaultTableModel getInvoiceTableDataWithoutDebit(int clientId){
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
        ArrayList<Invoice> arrClients = Invoice.getAllInvoiceWithClientNotDebit(clientId);
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
    
    
    public static DefaultTableModel getAllInvoice(String clientId){
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
        ArrayList<Invoice> arrClients = Invoice.getAllInvoiceWithClient(Integer.parseInt(clientId));
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
    
 public static void invoiceSQLLogic(int clientId, String total, String invoiceNumber, boolean receivableFlg, int paymentType, ArrayList<Transaction> transactionList, boolean outFlg ){
    Connection con = SQLConnection.getSQLConnection();
    try{
//        Connection con = SQLConnection.getSQLConnection();
        con.setAutoCommit(false);
        if(outFlg){
         InvoiceAction.insertOutInvoice(clientId, total, invoiceNumber, receivableFlg, paymentType,con);   
        } else {
         InvoiceAction.insertInInvoice(clientId, total, invoiceNumber, receivableFlg, paymentType,con);   
        }
         
            int invoiceId = Invoice.getLatestInvoice(con);
            for(Transaction t: transactionList){
                Item i = Item.getItem(t.getTransactionItemNumber().toString(), con);
                t.setTransactionInvoiceId(invoiceId);
                if(outFlg){
                    t.setTransactionQuantityAsOf(i.getItemCurrentQuantity()-t.getTransactionQuantity());
                } else {
                    t.setTransactionQuantityAsOf(i.getItemCurrentQuantity()+t.getTransactionQuantity());
                }
                
                Transaction.addInTransaction(t,con);
                Item.updateItemQuantity(t.getTransactionItemNumber(), t.getTransactionQuantityAsOf(), Formats.dateFormatDays.format(new GregorianCalendar().getTime()), con);
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
 
 
 public static int invoiceSQLLogic(int clientId, String total, String invoiceNumber, boolean receivableFlg, int paymentType, ArrayList<Transaction> transactionList, int year, int month, int day,boolean outFlg ){
    Connection con = SQLConnection.getSQLConnection();
    int success = 1;
    try{
//        Connection con = SQLConnection.getSQLConnection();
        ArrayList<Item> itemList = new ArrayList<Item>();
        con.setAutoCommit(false);
        Double balance = Double.parseDouble(total);
        balance-= Invoice.getInvoiceBalance(invoiceNumber,con);
        if(outFlg){
         success = InvoiceAction.insertOutInvoice(clientId, total,balance, invoiceNumber, receivableFlg, paymentType,year, month, day,con);   
        } else {
         success = InvoiceAction.insertInInvoice(clientId, total, balance, invoiceNumber, receivableFlg, paymentType,year, month, day, con);   
        }
         GregorianCalendar cal = new GregorianCalendar();
         cal.set(GregorianCalendar.YEAR, year);
         cal.set(GregorianCalendar.MONTH, month);
         cal.set(GregorianCalendar.DATE, day);
            int invoiceId = Invoice.getLatestInvoice(con);
            for(Transaction t: transactionList){
                boolean exist = false;
                Double quantityAsOf = 0.0;
                Item i = Item.getItem(t.getTransactionItemNumber().toString(), con);
                for(Item item : itemList){
                    if(item.getItemId().equals( i.getItemId())){
                        exist = true;
                        if(outFlg){
                            quantityAsOf = item.getItemCurrentQuantity()-t.getTransactionQuantity();
                        } else {
                            quantityAsOf = item.getItemCurrentQuantity()+t.getTransactionQuantity();
                        }
                        item.setItemCurrentQuantity(quantityAsOf);
                    }
                }
                if(!exist){
                   if(outFlg){
                      quantityAsOf = i.getItemCurrentQuantity()-t.getTransactionQuantity();
                   } else {
                      quantityAsOf = i.getItemCurrentQuantity()+t.getTransactionQuantity();
                   }
                   i.setItemCurrentQuantity(quantityAsOf);
                   itemList.add(i);
                }
                t.setTransactionDate(cal.getTime());
                t.setTransactionInvoiceId(invoiceId);
                t.setTransactionAddDate(new GregorianCalendar().getTime());
                t.setTransactionAddUser(System.getProperty("userName"));
                t.setTransactionQuantityAsOf(quantityAsOf);
                
                success = Transaction.addInTransaction(t,con);
//                success = Item.updateItemQuantity(t.getTransactionItemNumber(), t.getTransactionQuantityAsOf(), Formats.dateFormatDays.format(new GregorianCalendar().getTime()), con);
                
                
            }
            for(Item items: itemList){
                   success = Item.updateItemQuantity(items.getItemId(), items.getItemCurrentQuantity(), Formats.dateFormatDays.format(new GregorianCalendar().getTime()), con);
            }
            con.commit();
    } catch (Exception e){
            try {
                e.printStackTrace();
                con.rollback();
                return success;
            } catch (SQLException ex) {
                Logger.getLogger(InvoiceAction.class.getName()).log(Level.SEVERE, null, ex);
            }
    } finally {
            try {
                
                con.close();
                return success;
            } catch (SQLException ex) {
                Logger.getLogger(InvoiceAction.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
        return success;
//            this.dispose();
    }
 
 
 //INVOICE INPUT
 public static int invoiceSQLLogic(int clientId, String total, String invoiceNumber, boolean receivableFlg, int paymentType, ArrayList<Transaction> transactionList, int year, int month, int day,boolean outFlg, int locationId, String driverName, Integer salespersonId ){
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
        
        success = InvoiceAction.insertInvoice(clientId, total,balance, invoiceNumber, receivableFlg, paymentType,year, month, day,con, locationId, outFlg, driverName, salespersonId);   
        
         GregorianCalendar cal = new GregorianCalendar();
         cal.set(GregorianCalendar.YEAR, year);
         cal.set(GregorianCalendar.MONTH, month);
         cal.set(GregorianCalendar.DATE, day);
            int invoiceId = Invoice.getLatestInvoice(con);
            for(Transaction t: transactionList){
                boolean exist = false;
                Double quantityAsOf = 0.0;
                Double stockQuantity = 0.0;
                Item i = Item.getItem(t.getTransactionItemNumber().toString(), con);
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
                            quantityAsOf = item.getItemCurrentQuantity()-t.getTransactionQuantity();
                            stockQuantity = stockQuantity-t.getTransactionQuantity();
                        } else {
                            quantityAsOf = item.getItemCurrentQuantity()+t.getTransactionQuantity();
                            stockQuantity = stockQuantity+t.getTransactionQuantity();
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
//                      s = Stocks.calculateStocks(i.getItemId().toString(), locationId+"");
                    stockQuantity = s.getStocksQuantity();
                  } 
                   if(outFlg){
                      quantityAsOf = i.getItemCurrentQuantity()-t.getTransactionQuantity();
                      stockQuantity = stockQuantity-t.getTransactionQuantity();
                   } else {
                      quantityAsOf = i.getItemCurrentQuantity()+t.getTransactionQuantity();
                      stockQuantity = stockQuantity+t.getTransactionQuantity();
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
                
                t.setTransactionDate(cal.getTime());
                t.setTransactionInvoiceId(invoiceId);
                t.setTransactionAddDate(new GregorianCalendar().getTime());
                t.setTransactionAddUser(System.getProperty("userName"));
                t.setTransactionQuantityAsOf(quantityAsOf);
                
                
                success = Transaction.addInTransaction(t,con);
//                success = Item.updateItemQuantity(t.getTransactionItemNumber(), t.getTransactionQuantityAsOf(), Formats.dateFormatDays.format(new GregorianCalendar().getTime()), con);
                
                
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
                Logger.getLogger(InvoiceAction.class.getName()).log(Level.SEVERE, null, ex);
            }
    } finally {
            try {
                
                con.close();
                return success;
            } catch (SQLException ex) {
                Logger.getLogger(InvoiceAction.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
        return success;
//            this.dispose();
    }
 
 
 public static int debitMemoSQLLogic(int clientId, String total, String invoiceNumber, boolean receivableFlg, int paymentType, int year, int month, int day, boolean outFlg, int locationId ){
    Connection con = SQLConnection.getSQLConnection();
    int success = 1;
    try{
//        Connection con = SQLConnection.getSQLConnection();
        con.setAutoCommit(false);
        
//        Double balance = Double.parseDouble(total);
        
        Double balance = Formats.centavoDecimal.parse(total).doubleValue();
//        balance-= Invoice.getInvoiceBalance(invoiceNumber,con);
        
        success = InvoiceAction.insertInvoice(clientId, total,balance, invoiceNumber, receivableFlg, paymentType,year, month, day,con, locationId, outFlg," ", new Short("1"));   
        
         GregorianCalendar cal = new GregorianCalendar();
         cal.set(GregorianCalendar.YEAR, year);
         cal.set(GregorianCalendar.MONTH, month);
         cal.set(GregorianCalendar.DATE, day);
//            int invoiceId = Invoice.getLatestInvoice(con);
    
            con.commit();
    } catch (Exception e){
            try {
                e.printStackTrace();
                con.rollback();
                return success;
            } catch (SQLException ex) {
                Logger.getLogger(InvoiceAction.class.getName()).log(Level.SEVERE, null, ex);
            }
    } finally {
            try {
                
                con.close();
                return success;
            } catch (SQLException ex) {
                Logger.getLogger(InvoiceAction.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
        return success;
//            this.dispose();
    }
 
 
 public static int editDebitMemoSQLLogic(int invoiceId, int clientId, String total, String invoiceNumber, boolean receivableFlg, int paymentType, int year, int month, int day, boolean outFlg, int locationId ){
    Connection con = SQLConnection.getSQLConnection();
    int success = 1;
    try{
//        Connection con = SQLConnection.getSQLConnection();
        con.setAutoCommit(false);
        
//        Double balance = Double.parseDouble(total);
        
        Double balance = Formats.centavoDecimal.parse(total).doubleValue();
//        balance-= Invoice.getInvoiceBalance(invoiceNumber,con);
        
//        success = InvoiceAction.insertInvoice(clientId, total,balance, invoiceNumber, receivableFlg, paymentType,year, month, day,con, locationId, outFlg," ");   
        InvoiceAction.editInvoice(invoiceId, clientId, total, balance, invoiceNumber, receivableFlg, paymentType, year, month, day, locationId, outFlg, con , " ", null);
         GregorianCalendar cal = new GregorianCalendar();
         cal.set(GregorianCalendar.YEAR, year);
         cal.set(GregorianCalendar.MONTH, month);
         cal.set(GregorianCalendar.DATE, day);
//            int invoiceId = Invoice.getLatestInvoice(con);
    
            con.commit();
    } catch (Exception e){
            try {
                e.printStackTrace();
                con.rollback();
                return success;
            } catch (SQLException ex) {
                Logger.getLogger(InvoiceAction.class.getName()).log(Level.SEVERE, null, ex);
            }
    } finally {
            try {
                
                con.close();
                return success;
            } catch (SQLException ex) {
                Logger.getLogger(InvoiceAction.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
        return success;
//            this.dispose();
    }
 
 public static int voidDebitMemoSQLLogic(int invoiceId, boolean outFlg, int locationId ){
    Connection con = SQLConnection.getSQLConnection();
    int success = 1;
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
        Invoice in = new Invoice();
        in.setInvoiceId(invoiceId);
        in.setInvoiceDelDate(new GregorianCalendar().getTime());
        in.setInvoiceEditDate(new GregorianCalendar().getTime());
        in.setInvoiceEditUser(System.getProperty("userName"));
        Invoice.deleteInvoice(in, con);
//         GregorianCalendar cal = new GregorianCalendar();
//         cal.set(GregorianCalendar.YEAR, year);
//         cal.set(GregorianCalendar.MONTH, month);
//         cal.set(GregorianCalendar.DATE, day);
//            int invoiceId = Invoice.getLatestInvoice(con);
         
        
//            int invoiceId = Invoice.getLatestInvoice(con);
    
            con.commit();
    } catch (Exception e){
            try {
                e.printStackTrace();
                con.rollback();
                return success;
            } catch (SQLException ex) {
                Logger.getLogger(InvoiceAction.class.getName()).log(Level.SEVERE, null, ex);
            }
    } finally {
            try {
                
                con.close();
                return success;
            } catch (SQLException ex) {
                Logger.getLogger(InvoiceAction.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
        return success;
//            this.dispose();
    }
 
 public static int transferSQLLogic(int clientId, String total, String invoiceNumber, boolean receivableFlg, int paymentType, ArrayList<Transaction> transactionList, int year, int month, int day,boolean outFlg, int locationId ){
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
//        balance-= Invoice.getInvoiceBalance(invoiceId+"",con);
        
        success = InvoiceAction.insertTransfer(clientId, total,balance, invoiceNumber, receivableFlg, paymentType,year, month, day,con, locationId, outFlg);   
        
         GregorianCalendar cal = new GregorianCalendar();
         cal.set(GregorianCalendar.YEAR, year);
         cal.set(GregorianCalendar.MONTH, month);
         cal.set(GregorianCalendar.DATE, day);
            int invoiceId = Invoice.getLatestInvoice(con);
            for(Transaction t: transactionList){
                boolean exist = false;
                Double quantityAsOf = 0.0;
                Double stockQuantity = 0.0;
                Item i = Item.getItem(t.getTransactionItemNumber().toString(), con);
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
                            quantityAsOf = item.getItemCurrentQuantity()-t.getTransactionQuantity();
                            stockQuantity = stockQuantity-t.getTransactionQuantity();
                        } else {
                            quantityAsOf = item.getItemCurrentQuantity()+t.getTransactionQuantity();
                            stockQuantity = stockQuantity+t.getTransactionQuantity();
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
                      quantityAsOf = i.getItemCurrentQuantity()-t.getTransactionQuantity();
                      stockQuantity = stockQuantity-t.getTransactionQuantity();
                   } else {
                      quantityAsOf = i.getItemCurrentQuantity()+t.getTransactionQuantity();
                      stockQuantity = stockQuantity+t.getTransactionQuantity();
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
                
                t.setTransactionDate(cal.getTime());
                t.setTransactionInvoiceId(invoiceId);
                t.setTransactionAddDate(new GregorianCalendar().getTime());
                t.setTransactionAddUser(System.getProperty("userName"));
                t.setTransactionQuantityAsOf(quantityAsOf);
                
                
                success = Transaction.addInTransaction(t,con);
//                success = Item.updateItemQuantity(t.getTransactionItemNumber(), t.getTransactionQuantityAsOf(), Formats.dateFormatDays.format(new GregorianCalendar().getTime()), con);
                
                
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
                Logger.getLogger(InvoiceAction.class.getName()).log(Level.SEVERE, null, ex);
            }
    } finally {
            try {
                
                con.close();
                return success;
            } catch (SQLException ex) {
                Logger.getLogger(InvoiceAction.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
        return success;
//            this.dispose();
    }
 
 
 //EDIT INVOICE
 public static void invoiceEditSQLLogic(int invoiceId,int clientId, String total, String invoiceNumber, boolean receivableFlg, int paymentType, ArrayList<Transaction> transactionList, int year, int month, int day,boolean outFlg, ArrayList<Transaction> delList){
    Connection con = SQLConnection.getSQLConnection();
    try{
//        Connection con = SQLConnection.getSQLConnection();
        ArrayList<Item> itemList = new ArrayList<Item>();
        con.setAutoCommit(false);
        Double balance = Double.parseDouble(total);
//        balance -= Invoice.getInvoiceBalance(invoiceNumber,con);
        
        if(outFlg){
         InvoiceAction.editOutInvoice(invoiceId, clientId, total, balance, invoiceNumber, receivableFlg, paymentType,year, month, day,con);   
        } else {
         InvoiceAction.editInInvoice(invoiceId, clientId, total, balance, invoiceNumber, receivableFlg, paymentType,year, month, day, con);   
        }
         GregorianCalendar cal = new GregorianCalendar();
         cal.set(GregorianCalendar.YEAR, year);
         cal.set(GregorianCalendar.MONTH, month);
         cal.set(GregorianCalendar.DATE, day);
//            int invoiceId = Invoice.getLatestInvoice(con);
         
         for(Transaction t: delList){
                Item i = Item.getItem(t.getTransactionItemNumber().toString(), con);
                t.setTransactionDate(cal.getTime());
                t.setTransactionInvoiceId(invoiceId);
                t.setTransactionDelDate(new GregorianCalendar().getTime());
                t.setTransactionEditDate(new GregorianCalendar().getTime());
                t.setTransactionEditUser(System.getProperty("userName"));
                boolean exist = false;
                Double quantityAsOf = 0.0;
//                if(outFlg){
//                    t.setTransactionQuantityAsOf(i.getItemCurrentQuantity()+t.getTransactionQuantity());
//                } else {
//                    t.setTransactionQuantityAsOf(i.getItemCurrentQuantity()-t.getTransactionQuantity());
//                }
                 for(Item item : itemList){
                    if(item.getItemId().equals( i.getItemId())){
                        exist = true;
                        if(outFlg){
                            quantityAsOf = item.getItemCurrentQuantity()+t.getTransactionQuantity();
                        } else {
                            quantityAsOf = item.getItemCurrentQuantity()-t.getTransactionQuantity();
                        }
                        item.setItemCurrentQuantity(quantityAsOf);
                    }
                }
                if(!exist){
                   if(outFlg){
                      quantityAsOf = i.getItemCurrentQuantity()+t.getTransactionQuantity();
                   } else {
                      quantityAsOf = i.getItemCurrentQuantity()-t.getTransactionQuantity();
                   }
                   i.setItemCurrentQuantity(quantityAsOf);
                   itemList.add(i);
                }
                Transaction.deleteTransaction(t,con);
//                Item.updateItemQuantity(t.getTransactionItemNumber(), t.getTransactionQuantityAsOf(), Formats.dateFormatDays.format(new GregorianCalendar().getTime()), con);

                
            }
            for(Transaction t: transactionList){
                Item i = Item.getItem(t.getTransactionItemNumber().toString(), con);
                t.setTransactionDate(cal.getTime());
                t.setTransactionInvoiceId(invoiceId);
                t.setTransactionAddDate(new GregorianCalendar().getTime());
                t.setTransactionAddUser(System.getProperty("userName"));
                boolean exist = false;
                Double quantityAsOf = 0.0;
//                if(outFlg){
//                    t.setTransactionQuantityAsOf(i.getItemCurrentQuantity()+t.getTransactionQuantity());
//                } else {
//                    t.setTransactionQuantityAsOf(i.getItemCurrentQuantity()-t.getTransactionQuantity());
//                }
                 for(Item item : itemList){
                    if(item.getItemId().equals( i.getItemId())){
                        exist = true;
                        if(outFlg){
                            quantityAsOf = item.getItemCurrentQuantity()+t.getTransactionQuantity();
                        } else {
                            quantityAsOf = item.getItemCurrentQuantity()-t.getTransactionQuantity();
                        }
                        item.setItemCurrentQuantity(quantityAsOf);
                    }
                }
                if(!exist){
                   if(outFlg){
                      quantityAsOf = i.getItemCurrentQuantity()+t.getTransactionQuantity();
                   } else {
                      quantityAsOf = i.getItemCurrentQuantity()-t.getTransactionQuantity();
                   }
                   i.setItemCurrentQuantity(quantityAsOf);
                   itemList.add(i);
                }
                t.setTransactionQuantityAsOf(quantityAsOf);
//                if(outFlg){
//                    t.setTransactionQuantityAsOf(i.getItemCurrentQuantity()-t.getTransactionQuantity());
//                } else {
//                    t.setTransactionQuantityAsOf(i.getItemCurrentQuantity()+t.getTransactionQuantity());
//                }
                if(t.getTransactionId() == null){
                Transaction.addInTransaction(t,con);
//                Item.updateItemQuantity(t.getTransactionItemNumber(), t.getTransactionQuantityAsOf(), Formats.dateFormatDays.format(new GregorianCalendar().getTime()), con);
                }
                
            }
             for(Item items: itemList){
                  Item.updateItemQuantity(items.getItemId(), items.getItemCurrentQuantity(), Formats.dateFormatDays.format(new GregorianCalendar().getTime()), con);
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
 
 //NEW EDIT
  public static void invoiceEditSQLLogic(int invoiceId,int clientId, String total, String invoiceNumber, boolean receivableFlg, int paymentType, ArrayList<Transaction> transactionList, int year, int month, int day,boolean outFlg, ArrayList<Transaction> delList, int locationId, String driverName, Integer salespersonId){
    Connection con = SQLConnection.getSQLConnection();
    try{
//        Connection con = SQLConnection.getSQLConnection();
        ArrayList<Item> itemList = new ArrayList<Item>();
        ArrayList<Stocks> existingStockList = new ArrayList<Stocks>();
        ArrayList<Stocks> newStockList = new ArrayList<Stocks>();
        con.setAutoCommit(false);
        Double balance = Formats.centavoDecimal.parse(total).doubleValue();
        balance -= Invoice.getInvoiceBalance(invoiceId+"",con);
        
//        if(outFlg){
//         InvoiceAction.editOutInvoice(invoiceId, clientId, total, balance, invoiceNumber, receivableFlg, paymentType,year, month, day,con);   
//        } else {
//         InvoiceAction.editInInvoice(invoiceId, clientId, total, balance, invoiceNumber, receivableFlg, paymentType,year, month, day, con);   
//        }
        InvoiceAction.editInvoice(invoiceId, clientId, total, balance, invoiceNumber, receivableFlg, paymentType, year, month, day, locationId, outFlg, con , driverName, salespersonId);
         GregorianCalendar cal = new GregorianCalendar();
         cal.set(GregorianCalendar.YEAR, year);
         cal.set(GregorianCalendar.MONTH, month);
         cal.set(GregorianCalendar.DATE, day);
//            int invoiceId = Invoice.getLatestInvoice(con);
         ArrayList<Transaction> newDelList = checkDeletedItems(transactionList, delList);
         for(Transaction t: newDelList){
//         for(Transaction t: delList){
                Item i = Item.getItem(t.getTransactionItemNumber().toString(), con);
                t.setTransactionDate(cal.getTime());
                t.setTransactionInvoiceId(invoiceId);
                t.setTransactionDelDate(new GregorianCalendar().getTime());
                t.setTransactionEditDate(new GregorianCalendar().getTime());
                t.setTransactionEditUser(System.getProperty("userName"));
                boolean exist = false;
                Double stockQuantity = 0.0;
                int nExist = Stocks.checkStocksExist(i.getItemId().toString(), locationId+"", con);
                Stocks s = new Stocks();
                s.setStocksItemId(i.getItemId());
                s.setStocksLocationId(locationId);
                Double quantityAsOf = 0.0;
                s.setStocksDelFlag(t.getDoubleFlag());
//                if(outFlg){
//                    t.setTransactionQuantityAsOf(i.getItemCurrentQuantity()+t.getTransactionQuantity());
//                } else {
//                    t.setTransactionQuantityAsOf(i.getItemCurrentQuantity()-t.getTransactionQuantity());
//                }
                 for(Item item : itemList){
                    if(item.getItemId().equals(i.getItemId())){
//                        exist = true;
//                        if(outFlg){
//                            quantityAsOf = item.getItemCurrentQuantity()+t.getTransactionQuantity();
//                        } else {
//                            quantityAsOf = item.getItemCurrentQuantity()-t.getTransactionQuantity();
//                        }
//                        item.setItemCurrentQuantity(quantityAsOf);
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
                            quantityAsOf = item.getItemCurrentQuantity()+t.getTransactionQuantity();
                            stockQuantity = stockQuantity+t.getTransactionQuantity();
                        } else {
                            quantityAsOf = item.getItemCurrentQuantity()-t.getTransactionQuantity();
                            stockQuantity = stockQuantity-t.getTransactionQuantity();
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
                if(!exist){
//                   if(outFlg){
//                      quantityAsOf = i.getItemCurrentQuantity()+t.getTransactionQuantity();
//                   } else {
//                      quantityAsOf = i.getItemCurrentQuantity()-t.getTransactionQuantity();
//                   }
//                   i.setItemCurrentQuantity(quantityAsOf);
//                   itemList.add(i);
                     if(nExist > 0){
                    s = Stocks.getStocks(i.getItemId().toString(), locationId+"");                  
//                         s = Stocks.calculateStocks(i.getItemId().toString(), locationId+"");
                    stockQuantity = s.getStocksQuantity();
                  } 
                   if(outFlg){
                      quantityAsOf = i.getItemCurrentQuantity()+t.getTransactionQuantity();
                      stockQuantity = stockQuantity+t.getTransactionQuantity();
                   } else {
                      quantityAsOf = i.getItemCurrentQuantity()-t.getTransactionQuantity();
                      stockQuantity = stockQuantity-t.getTransactionQuantity();
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
                Transaction.deleteTransaction(t,con);
//                Item.updateItemQuantity(t.getTransactionItemNumber(), t.getTransactionQuantityAsOf(), Formats.dateFormatDays.format(new GregorianCalendar().getTime()), con);

                
            }
          for(Stocks s: newStockList){
//                 Stocks.insertStocks(s.getStocksItemId().toString(), s.getStocksLocationId().toString(), s.getStocksQuantity().toString(), con);
              Stocks.insertStocks(s, con);
            }
            for(Stocks s: existingStockList){
//                 Stocks.updateStocks(s.getStocksItemId().toString(), s.getStocksLocationId().toString(), s.getStocksQuantity().toString(),s.getStocksId().toString(), con);
                 Stocks.deleteStocks(s.getStocksId().toString(), con);
//                 Stocks.insertStocks(s.getStocksItemId().toString(), s.getStocksLocationId().toString(), s.getStocksQuantity().toString(), con);
                 Stocks.insertStocks(s, con);
            }
            for(Transaction t: transactionList){
                Item i = Item.getItem(t.getTransactionItemNumber().toString(), con);
                t.setTransactionDate(cal.getTime());
                t.setTransactionInvoiceId(invoiceId);
                t.setTransactionAddDate(new GregorianCalendar().getTime());
                t.setTransactionAddUser(System.getProperty("userName"));
                boolean exist = false;
                Double quantityAsOf = 0.0;
                Double stockQuantity = 0.0;
                int nExist = Stocks.checkStocksExist(i.getItemId().toString(), locationId+"", con);
                Stocks s = new Stocks();
                s.setStocksItemId(i.getItemId());
                s.setStocksLocationId(locationId);
//                if(outFlg){
//                    t.setTransactionQuantityAsOf(i.getItemCurrentQuantity()+t.getTransactionQuantity());
//                } else {
//                    t.setTransactionQuantityAsOf(i.getItemCurrentQuantity()-t.getTransactionQuantity());
//                }
                 for(Item item : itemList){
                    if(item.getItemId().equals(i.getItemId())){
//                        exist = true;
//                        if(outFlg){
//                            quantityAsOf = item.getItemCurrentQuantity()+t.getTransactionQuantity();
//                        } else {
//                            quantityAsOf = item.getItemCurrentQuantity()-t.getTransactionQuantity();
//                        }
//                        item.setItemCurrentQuantity(quantityAsOf);
//                    }
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
                        if(outFlg && t.getTransactionId() == null){
                            quantityAsOf = item.getItemCurrentQuantity()-t.getTransactionQuantity();
                            stockQuantity = stockQuantity-t.getTransactionQuantity();
                        } else if( t.getTransactionId() == null) {
                            quantityAsOf = item.getItemCurrentQuantity()+t.getTransactionQuantity();
                            stockQuantity = stockQuantity+t.getTransactionQuantity();
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
                if(!exist){
//                   if(outFlg){
//                      quantityAsOf = i.getItemCurrentQuantity()+t.getTransactionQuantity();
//                   } else {
//                      quantityAsOf = i.getItemCurrentQuantity()-t.getTransactionQuantity();
//                   }
//                   i.setItemCurrentQuantity(quantityAsOf);
//                   itemList.add(i);
                     if(nExist > 0){
                    s = Stocks.getStocks(i.getItemId().toString(), locationId+"");            
//                         s = Stocks.calculateStocks(i.getItemId().toString(), locationId+"");
                    stockQuantity = s.getStocksQuantity();
                  } 
                   if(outFlg && t.getTransactionId()== null){
                      quantityAsOf = i.getItemCurrentQuantity()-t.getTransactionQuantity();
                      stockQuantity = stockQuantity-t.getTransactionQuantity();
                   } else if(t.getTransactionId()== null){
                      quantityAsOf = i.getItemCurrentQuantity()+t.getTransactionQuantity();
                      stockQuantity = stockQuantity+t.getTransactionQuantity();
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
                t.setTransactionQuantityAsOf(quantityAsOf);
//                if(outFlg){
//                    t.setTransactionQuantityAsOf(i.getItemCurrentQuantity()-t.getTransactionQuantity());
//                } else {
//                    t.setTransactionQuantityAsOf(i.getItemCurrentQuantity()+t.getTransactionQuantity());
//                }
                if(t.getTransactionId() == null){
                Transaction.addInTransaction(t,con);
//                Item.updateItemQuantity(t.getTransactionItemNumber(), t.getTransactionQuantityAsOf(), Formats.dateFormatDays.format(new GregorianCalendar().getTime()), con);
                }
                
            }
             for(Item items: itemList){
                  Item.updateItemQuantity(items.getItemId(), items.getItemCurrentQuantity(), Formats.dateFormatDays.format(new GregorianCalendar().getTime()), con);
            }
             for(Stocks s: newStockList){
                 Stocks.insertStocks(s.getStocksItemId().toString(), s.getStocksLocationId().toString(), s.getStocksQuantity().toString(), con);
            }
            for(Stocks s: existingStockList){
//                 Stocks.updateStocks(s.getStocksItemId().toString(), s.getStocksLocationId().toString(), s.getStocksQuantity().toString(),s.getStocksId().toString(), con);
                 Stocks.deleteStocks(s.getStocksId().toString(), con);
                 Stocks.insertStocks(s.getStocksItemId().toString(), s.getStocksLocationId().toString(), s.getStocksQuantity().toString(), con);
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
  
    public static void transferEditSQLLogic(int invoiceId,int clientId, String total, String invoiceNumber, boolean receivableFlg, int paymentType, ArrayList<Transaction> transactionList, int year, int month, int day,boolean outFlg, ArrayList<Transaction> delList, int locationId){
    Connection con = SQLConnection.getSQLConnection();
    try{
//        Connection con = SQLConnection.getSQLConnection();
        ArrayList<Item> itemList = new ArrayList<Item>();
        ArrayList<Stocks> existingStockList = new ArrayList<Stocks>();
        ArrayList<Stocks> newStockList = new ArrayList<Stocks>();
        con.setAutoCommit(false);
        Double balance = Formats.centavoDecimal.parse(total).doubleValue();
        balance -= Invoice.getInvoiceBalance(invoiceId+"",con);
        
//        if(outFlg){
//         InvoiceAction.editOutInvoice(invoiceId, clientId, total, balance, invoiceNumber, receivableFlg, paymentType,year, month, day,con);   
//        } else {
//         InvoiceAction.editInInvoice(invoiceId, clientId, total, balance, invoiceNumber, receivableFlg, paymentType,year, month, day, con);   
//        }
        InvoiceAction.editInvoice(invoiceId, clientId, total, balance, invoiceNumber, receivableFlg, paymentType, year, month, day, locationId, outFlg, con, "-" , null);
         GregorianCalendar cal = new GregorianCalendar();
         cal.set(GregorianCalendar.YEAR, year);
         cal.set(GregorianCalendar.MONTH, month);
         cal.set(GregorianCalendar.DATE, day);
//            int invoiceId = Invoice.getLatestInvoice(con);
         
         for(Transaction t: delList){
                Item i = Item.getItem(t.getTransactionItemNumber().toString(), con);
                t.setTransactionDate(cal.getTime());
                t.setTransactionInvoiceId(invoiceId);
                t.setTransactionDelDate(new GregorianCalendar().getTime());
                t.setTransactionEditDate(new GregorianCalendar().getTime());
                t.setTransactionEditUser(System.getProperty("userName"));
                boolean exist = false;
                Double stockQuantity = 0.0;
                int nExist = Stocks.checkStocksExist(i.getItemId().toString(), locationId+"", con);
                Stocks s = new Stocks();
                s.setStocksItemId(i.getItemId());
                s.setStocksLocationId(locationId);
                Double quantityAsOf = 0.0;
//                if(outFlg){
//                    t.setTransactionQuantityAsOf(i.getItemCurrentQuantity()+t.getTransactionQuantity());
//                } else {
//                    t.setTransactionQuantityAsOf(i.getItemCurrentQuantity()-t.getTransactionQuantity());
//                }
                 for(Item item : itemList){
                    if(item.getItemId().equals( i.getItemId())){
//                        exist = true;
//                        if(outFlg){
//                            quantityAsOf = item.getItemCurrentQuantity()+t.getTransactionQuantity();
//                        } else {
//                            quantityAsOf = item.getItemCurrentQuantity()-t.getTransactionQuantity();
//                        }
//                        item.setItemCurrentQuantity(quantityAsOf);
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
                            quantityAsOf = item.getItemCurrentQuantity()+t.getTransactionQuantity();
                            stockQuantity = stockQuantity+t.getTransactionQuantity();
                        } else {
                            quantityAsOf = item.getItemCurrentQuantity()-t.getTransactionQuantity();
                            stockQuantity = stockQuantity-t.getTransactionQuantity();
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
                if(!exist){
//                   if(outFlg){
//                      quantityAsOf = i.getItemCurrentQuantity()+t.getTransactionQuantity();
//                   } else {
//                      quantityAsOf = i.getItemCurrentQuantity()-t.getTransactionQuantity();
//                   }
//                   i.setItemCurrentQuantity(quantityAsOf);
//                   itemList.add(i);
                     if(nExist > 0){
                    s = Stocks.getStocks(i.getItemId().toString(), locationId+"");                
//                         s = Stocks.calculateStocks(i.getItemId().toString(), locationId+"");
                    stockQuantity = s.getStocksQuantity();
                  } 
                   if(outFlg){
                      quantityAsOf = i.getItemCurrentQuantity()+t.getTransactionQuantity();
                      stockQuantity = stockQuantity+t.getTransactionQuantity();
                   } else {
                      quantityAsOf = i.getItemCurrentQuantity()-t.getTransactionQuantity();
                      stockQuantity = stockQuantity-t.getTransactionQuantity();
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
                Transaction.deleteTransaction(t,con);
//                Item.updateItemQuantity(t.getTransactionItemNumber(), t.getTransactionQuantityAsOf(), Formats.dateFormatDays.format(new GregorianCalendar().getTime()), con);

                
            }
            for(Transaction t: transactionList){
                Item i = Item.getItem(t.getTransactionItemNumber().toString(), con);
                t.setTransactionDate(cal.getTime());
                t.setTransactionInvoiceId(invoiceId);
                t.setTransactionAddDate(new GregorianCalendar().getTime());
                t.setTransactionAddUser(System.getProperty("userName"));
                boolean exist = false;
                Double quantityAsOf = 0.0;
                Double stockQuantity = 0.0;
                int nExist = Stocks.checkStocksExist(i.getItemId().toString(), locationId+"", con);
                Stocks s = new Stocks();
                s.setStocksItemId(i.getItemId());
                s.setStocksLocationId(locationId);
//                if(outFlg){
//                    t.setTransactionQuantityAsOf(i.getItemCurrentQuantity()+t.getTransactionQuantity());
//                } else {
//                    t.setTransactionQuantityAsOf(i.getItemCurrentQuantity()-t.getTransactionQuantity());
//                }
                 for(Item item : itemList){
                    if(item.getItemId().equals( i.getItemId())){
//                        exist = true;
//                        if(outFlg){
//                            quantityAsOf = item.getItemCurrentQuantity()+t.getTransactionQuantity();
//                        } else {
//                            quantityAsOf = item.getItemCurrentQuantity()-t.getTransactionQuantity();
//                        }
//                        item.setItemCurrentQuantity(quantityAsOf);
//                    }
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
                        if(outFlg && t.getTransactionId() == null){
                            quantityAsOf = item.getItemCurrentQuantity()-t.getTransactionQuantity();
                            stockQuantity = stockQuantity-t.getTransactionQuantity();
                        } else if(t.getTransactionId()== null) {
                            quantityAsOf = item.getItemCurrentQuantity()+t.getTransactionQuantity();
                            stockQuantity = stockQuantity+t.getTransactionQuantity();
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
                if(!exist){
//                   if(outFlg){
//                      quantityAsOf = i.getItemCurrentQuantity()+t.getTransactionQuantity();
//                   } else {
//                      quantityAsOf = i.getItemCurrentQuantity()-t.getTransactionQuantity();
//                   }
//                   i.setItemCurrentQuantity(quantityAsOf);
//                   itemList.add(i);
                     if(nExist > 0){
                    s = Stocks.getStocks(i.getItemId().toString(), locationId+"");                
//                         s = Stocks.calculateStocks(i.getItemId().toString(), locationId+"");
                    stockQuantity = s.getStocksQuantity();
                  } 
                   if(outFlg && t.getTransactionId() == null){
                      quantityAsOf = i.getItemCurrentQuantity()-t.getTransactionQuantity();
                      stockQuantity = stockQuantity-t.getTransactionQuantity();
                   } else if( t.getTransactionId() == null) {
                      quantityAsOf = i.getItemCurrentQuantity()+t.getTransactionQuantity();
                      stockQuantity = stockQuantity+t.getTransactionQuantity();
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
                t.setTransactionQuantityAsOf(quantityAsOf);
//                if(outFlg){
//                    t.setTransactionQuantityAsOf(i.getItemCurrentQuantity()-t.getTransactionQuantity());
//                } else {
//                    t.setTransactionQuantityAsOf(i.getItemCurrentQuantity()+t.getTransactionQuantity());
//                }
                if(t.getTransactionId() == null){
                Transaction.addInTransaction(t,con);
//                Item.updateItemQuantity(t.getTransactionItemNumber(), t.getTransactionQuantityAsOf(), Formats.dateFormatDays.format(new GregorianCalendar().getTime()), con);
                }
                
            }
             for(Item items: itemList){
                  Item.updateItemQuantity(items.getItemId(), items.getItemCurrentQuantity(), Formats.dateFormatDays.format(new GregorianCalendar().getTime()), con);
            }
             for(Stocks s: newStockList){
                 Stocks.insertStocks(s.getStocksItemId().toString(), s.getStocksLocationId().toString(), s.getStocksQuantity().toString(), con);
            }
            for(Stocks s: existingStockList){
//                 Stocks.updateStocks(s.getStocksItemId().toString(), s.getStocksLocationId().toString(), s.getStocksQuantity().toString(),s.getStocksId().toString(), con);
                Stocks.deleteStocks(s.getStocksId().toString(), con);
                Stocks.insertStocks(s.getStocksItemId().toString(), s.getStocksLocationId().toString(), s.getStocksQuantity().toString(), con);
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
 
  public static void voidSQLLogic(int invoiceId,ArrayList<Transaction> transactionList,boolean outFlg){
    Connection con = SQLConnection.getSQLConnection();
    try{
//        Connection con = SQLConnection.getSQLConnection();
        ArrayList<Item> itemList = new ArrayList<Item>();
        con.setAutoCommit(false);
//        if(outFlg){
//         InvoiceAction.editOutInvoice(clientId, total, invoiceNumber, receivableFlg, paymentType,year, month, day,con);   
//        } else {
//         InvoiceAction.editInInvoice(clientId, total, invoiceNumber, receivableFlg, paymentType,year, month, day, con);   
//        }
        Invoice in = new Invoice();
        in.setInvoiceId(invoiceId);
        in.setInvoiceDelDate(new GregorianCalendar().getTime());
        in.setInvoiceEditDate(new GregorianCalendar().getTime());
        in.setInvoiceEditUser(System.getProperty("userName"));
        Invoice.deleteInvoice(in, con);
//         GregorianCalendar cal = new GregorianCalendar();
//         cal.set(GregorianCalendar.YEAR, year);
//         cal.set(GregorianCalendar.MONTH, month);
//         cal.set(GregorianCalendar.DATE, day);
//            int invoiceId = Invoice.getLatestInvoice(con);
         
         for(Transaction t: transactionList){
                Item i = Item.getItem(t.getTransactionItemNumber().toString(), con);
//                t.setTransactionDate(cal.getTime());
                t.setTransactionInvoiceId(invoiceId);
                t.setTransactionDelDate(new GregorianCalendar().getTime());
                t.setTransactionEditDate(new GregorianCalendar().getTime());
                t.setTransactionEditUser(System.getProperty("userName"));
//                if(outFlg){
//                    t.setTransactionQuantityAsOf(i.getItemCurrentQuantity()+t.getTransactionQuantity());
//                } else {
//                    t.setTransactionQuantityAsOf(i.getItemCurrentQuantity()-t.getTransactionQuantity());
//                }
                 boolean exist = false;
                Double quantityAsOf = 0.0;
//                if(outFlg){
//                    t.setTransactionQuantityAsOf(i.getItemCurrentQuantity()+t.getTransactionQuantity());
//                } else {
//                    t.setTransactionQuantityAsOf(i.getItemCurrentQuantity()-t.getTransactionQuantity());
//                }
                 for(Item item : itemList){
                    if(item.getItemId().equals( i.getItemId())){
                        exist = true;
                        if(outFlg){
                            quantityAsOf = item.getItemCurrentQuantity()+t.getTransactionQuantity();
                        } else {
                            quantityAsOf = item.getItemCurrentQuantity()-t.getTransactionQuantity();
                        }
                        item.setItemCurrentQuantity(quantityAsOf);
                    }
                }
                if(!exist){
                   if(outFlg){
                      quantityAsOf = i.getItemCurrentQuantity()+t.getTransactionQuantity();
                   } else {
                      quantityAsOf = i.getItemCurrentQuantity()-t.getTransactionQuantity();
                   }
                   i.setItemCurrentQuantity(quantityAsOf);
                   itemList.add(i);
                }
                t.setTransactionQuantityAsOf(quantityAsOf);
                Transaction.deleteTransaction(t,con);
//                Item.updateItemQuantity(t.getTransactionItemNumber(), t.getTransactionQuantityAsOf(), Formats.dateFormatDays.format(new GregorianCalendar().getTime()), con);
            
            }
         for(Item items: itemList){
                  Item.updateItemQuantity(items.getItemId(), items.getItemCurrentQuantity(), Formats.dateFormatDays.format(new GregorianCalendar().getTime()), con);
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

//VOID SQL  
   public static void voidSQLLogic(int invoiceId,ArrayList<Transaction> transactionList,boolean outFlg, int locationId){
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
        Invoice in = new Invoice();
        in.setInvoiceId(invoiceId);
        in.setInvoiceDelDate(new GregorianCalendar().getTime());
        in.setInvoiceEditDate(new GregorianCalendar().getTime());
        in.setInvoiceEditUser(System.getProperty("userName"));
        Invoice.deleteInvoice(in, con);
//         GregorianCalendar cal = new GregorianCalendar();
//         cal.set(GregorianCalendar.YEAR, year);
//         cal.set(GregorianCalendar.MONTH, month);
//         cal.set(GregorianCalendar.DATE, day);
//            int invoiceId = Invoice.getLatestInvoice(con);
         
         for(Transaction t: transactionList){
                Item i = Item.getItem(t.getTransactionItemNumber().toString(), con);
//                t.setTransactionDate(cal.getTime());
                t.setTransactionInvoiceId(invoiceId);
                t.setTransactionDelDate(new GregorianCalendar().getTime());
                t.setTransactionEditDate(new GregorianCalendar().getTime());
                t.setTransactionEditUser(System.getProperty("userName"));
//                if(outFlg){
//                    t.setTransactionQuantityAsOf(i.getItemCurrentQuantity()+t.getTransactionQuantity());
//                } else {
//                    t.setTransactionQuantityAsOf(i.getItemCurrentQuantity()-t.getTransactionQuantity());
//                }
                 boolean exist = false;
                Double quantityAsOf = 0.0;
                Double stockQuantity = 0.0;
                int nExist = Stocks.checkStocksExist(i.getItemId().toString(), locationId+"", con);
                Stocks s = new Stocks();
                s.setStocksItemId(i.getItemId());
                s.setStocksLocationId(locationId);
//                if(outFlg){
//                    t.setTransactionQuantityAsOf(i.getItemCurrentQuantity()+t.getTransactionQuantity());
//                } else {
//                    t.setTransactionQuantityAsOf(i.getItemCurrentQuantity()-t.getTransactionQuantity());
//                }
                 for(Item item : itemList){
                    if(item.getItemId().equals( i.getItemId())){
//                        exist = true;
//                        if(outFlg){
//                            quantityAsOf = item.getItemCurrentQuantity()+t.getTransactionQuantity();
//                        } else {
//                            quantityAsOf = item.getItemCurrentQuantity()-t.getTransactionQuantity();
//                        }
//                        item.setItemCurrentQuantity(quantityAsOf);
//                    }
                        exist = true;
                        int existingCheck = checkStockArrayList(i.getItemId(), locationId, stockList);
                         s = stockList.get(existingCheck);
                        
                        stockQuantity = s.getStocksQuantity();
                        if(outFlg){
                            quantityAsOf = item.getItemCurrentQuantity()+t.getTransactionQuantity();
                            stockQuantity = stockQuantity+t.getTransactionQuantity();
                        } else {
                            quantityAsOf = item.getItemCurrentQuantity()-t.getTransactionQuantity();
                            stockQuantity = stockQuantity-t.getTransactionQuantity();
                        }
                        s.setStocksQuantity(stockQuantity);
                        item.setItemCurrentQuantity(quantityAsOf);
                        
                            stockList.remove(existingCheck);
                            stockList.add(s);
                    }
                        
                }
                if(!exist){
//                   if(outFlg){
//                      quantityAsOf = i.getItemCurrentQuantity()+t.getTransactionQuantity();
//                   } else {
//                      quantityAsOf = i.getItemCurrentQuantity()-t.getTransactionQuantity();
//                   }
//                   i.setItemCurrentQuantity(quantityAsOf);
//                   itemList.add(i);
                    
                    s = Stocks.getStocks(i.getItemId().toString(), locationId+"");                  
//                    s = Stocks.calculateStocks(i.getItemId().toString(), locationId+"");
                    stockQuantity = s.getStocksQuantity();
                  
                   if(outFlg){
                      quantityAsOf = i.getItemCurrentQuantity()+t.getTransactionQuantity();
                      stockQuantity = stockQuantity+t.getTransactionQuantity();
                   } else {
                      quantityAsOf = i.getItemCurrentQuantity()-t.getTransactionQuantity();
                      stockQuantity = stockQuantity-t.getTransactionQuantity();
                   }
                   i.setItemCurrentQuantity(quantityAsOf);
                   s.setStocksQuantity(stockQuantity);
                   itemList.add(i);
                   
                      stockList.add(s);
                   
                }
                t.setTransactionQuantityAsOf(quantityAsOf);
                Transaction.deleteTransaction(t,con);
//                Item.updateItemQuantity(t.getTransactionItemNumber(), t.getTransactionQuantityAsOf(), Formats.dateFormatDays.format(new GregorianCalendar().getTime()), con);
            
            }
         for(Item items: itemList){
                  Item.updateItemQuantity(items.getItemId(), items.getItemCurrentQuantity(), Formats.dateFormatDays.format(new GregorianCalendar().getTime()), con);
            }
         for(Stocks s: stockList){
//                 Stocks.updateStocks(s.getStocksItemId().toString(), s.getStocksLocationId().toString(), s.getStocksQuantity().toString(),s.getStocksId().toString(), con);
                Stocks.deleteStocks(s.getStocksId().toString(), con);
                Stocks.insertStocks(s.getStocksItemId().toString(), s.getStocksLocationId().toString(), s.getStocksQuantity().toString(), con);
            }
           deleteCollectionWithInvoice(Integer.toString(in.getInvoiceId()),new GregorianCalendar().getTime(), con);
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

public static DefaultTableModel getReceivableSummaryTableData(int supplierNumber){
       DefaultTableModel mod = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
       
        mod.setColumnIdentifiers(new String[] {"Date","Invoice No.","Amount", "Balance", "Due Date"});
        ArrayList<Invoice> arrItems = Invoice.getInvoiceWithClient(supplierNumber);
        double grandTotal =0.0;
        for(Invoice emp: arrItems){
//           mod.addRow(new String[] {Formats.dateFormatMinutes.format(emp.getInvoiceDate())+"",emp.getInvoiceNumber()+"", emp.getInvoiceTotalPrice().toString()+"",emp.getInvoiceCurrentBalance().toString()+"", Formats.dateFormatDays.format(emp.getInvoiceDueDate())});
//            Double balance = emp.getInvoiceTotalPrice() - Collections.getCollectionAmount(emp.getInvoiceNumber());
//           mod.addRow(new String[] {Formats.dateFormatMinutes.format(emp.getInvoiceDate())+"",emp.getInvoiceNumber()+"", emp.getInvoiceTotalPrice().toString()+"",emp.getInvoiceCurrentBalance().toString()+"", Formats.dateFormatDays.format(emp.getInvoiceDueDate())});
            Double balance = emp.getInvoiceTotalPrice() - Collections.getCollectionBalanceUsingId(emp.getInvoiceId().toString());
            grandTotal += balance;
           mod.addRow(new String[] {Formats.dateFormatMinutes2.format(emp.getInvoiceDate())+"",emp.getInvoiceNumber()+"", Formats.centavoDecimal.format(emp.getInvoiceTotalPrice()),Formats.centavoDecimal.format(balance), Formats.dateFormatDays2.format(emp.getInvoiceDueDate())}); 
        }
        mod.addRow(new String[] {" "," ", "Grand Total", Formats.centavoDecimal.format(grandTotal), " "}); 
//        mod.setColumnCount(3);
        return mod;
    }

public static DefaultTableModel getReceivableAgingTableData(int supplierNumber){
       DefaultTableModel mod = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
       
        mod.setColumnIdentifiers(new String[] {"Date","Invoice No.","Amount", "0-30", "31-60", "61-90", "91-120","120-UP"});
        ArrayList<Invoice> arrItems = Invoice.getInvoiceWithClient(supplierNumber);
//        double grandTotal =0.0;
                    double grandT = 0.0;
            double oneTwent = 0.0;
            double ninet = 0.0;
            double sixt = 0.0;
            double thirt = 0.0;
            double zer = 0.0;
        for(Invoice emp: arrItems){
//           mod.addRow(new String[] {Formats.dateFormatMinutes.format(emp.getInvoiceDate())+"",emp.getInvoiceNumber()+"", emp.getInvoiceTotalPrice().toString()+"",emp.getInvoiceCurrentBalance().toString()+"", Formats.dateFormatDays.format(emp.getInvoiceDueDate())});
//            Double balance = emp.getInvoiceTotalPrice() - Collections.getCollectionAmount(emp.getInvoiceNumber());
//           mod.addRow(new String[] {Formats.dateFormatMinutes.format(emp.getInvoiceDate())+"",emp.getInvoiceNumber()+"", emp.getInvoiceTotalPrice().toString()+"",emp.getInvoiceCurrentBalance().toString()+"", Formats.dateFormatDays.format(emp.getInvoiceDueDate())});
            Double balance = emp.getInvoiceTotalPrice() - Collections.getCollectionBalanceUsingId(emp.getInvoiceId().toString());
//            grandTotal += balance;
            DateTime now = new DateTime();
            DateTime dt = new DateTime(emp.getInvoiceDate().getTime());
//            GregorianCalendar gcdt = new GregorianCalendar();
//            gcdt.setTime(emp.getInvoiceDate());
            DateTime oneTwenty = new DateTime(emp.getInvoiceDate().getTime());
            oneTwenty = oneTwenty.plusDays(120);
            DateTime ninety = new DateTime(emp.getInvoiceDate().getTime());
            ninety = ninety.plusDays(90);
            DateTime sixty = new DateTime(emp.getInvoiceDate().getTime());
            sixty = sixty.plusDays(60);
            DateTime thirty = new DateTime(emp.getInvoiceDate().getTime());
            thirty = thirty.plusDays(30);
            

            grandT +=emp.getInvoiceTotalPrice();
            if( now.isAfter(oneTwenty)){
                mod.addRow(new String[] {Formats.dateFormatDays2.format(emp.getInvoiceDate())+"",emp.getInvoiceNumber()+"", Formats.centavoDecimal.format(emp.getInvoiceTotalPrice()), " "," "," "," ", Formats.centavoDecimal.format(balance)});
                oneTwent += balance;
            } else if( now.isAfter(ninety) && now.isBefore(oneTwenty.plusDays(1))){
                mod.addRow(new String[] {Formats.dateFormatDays2.format(emp.getInvoiceDate())+"",emp.getInvoiceNumber()+"", Formats.centavoDecimal.format(emp.getInvoiceTotalPrice()), " "," "," ", Formats.centavoDecimal.format(balance)," "});    
                ninet += balance;
            } else if(now.isAfter(sixty) && now.isBefore(ninety.plusDays(1))){
                mod.addRow(new String[] {Formats.dateFormatDays2.format(emp.getInvoiceDate())+"",emp.getInvoiceNumber()+"", Formats.centavoDecimal.format(emp.getInvoiceTotalPrice()), " "," ", Formats.centavoDecimal.format(balance)," "," "});    
                sixt+= balance;
            } else if (now.isAfter(thirty) && now.isBefore(sixty.plusDays(1))){
                mod.addRow(new String[] {Formats.dateFormatDays2.format(emp.getInvoiceDate())+"",emp.getInvoiceNumber()+"", Formats.centavoDecimal.format(emp.getInvoiceTotalPrice()), " ", Formats.centavoDecimal.format(balance)," "," "," "});    
                thirt += balance;
            } else if (now.isAfter(dt) && now.isBefore(thirty.plusDays(1))){
                mod.addRow(new String[] {Formats.dateFormatDays2.format(emp.getInvoiceDate())+"",emp.getInvoiceNumber()+"", Formats.centavoDecimal.format(emp.getInvoiceTotalPrice()), Formats.centavoDecimal.format(balance), " "," "," "," "});    
                zer +=balance;
            } else {
                mod.addRow(new String[] {Formats.dateFormatDays2.format(emp.getInvoiceDate())+"",emp.getInvoiceNumber()+"", Formats.centavoDecimal.format(emp.getInvoiceTotalPrice()), Formats.centavoDecimal.format(balance), " "," "," "," "});
                zer +=balance;
            }
//            dt.
            
//           mod.addRow(new String[] {Formats.dateFormatMinutes2.format(emp.getInvoiceDate())+"",emp.getInvoiceNumber()+"", Formats.centavoDecimal.format(emp.getInvoiceTotalPrice()),Formats.centavoDecimal.format(balance), Formats.dateFormatDays2.format(emp.getInvoiceDueDate())}); 
        }
        mod.addRow(new String[] {"Grand Total"," ", Formats.centavoDecimal.format(grandT), Formats.centavoDecimal.format(zer), Formats.centavoDecimal.format(thirt),Formats.centavoDecimal.format(sixt),Formats.centavoDecimal.format(ninet),Formats.centavoDecimal.format(oneTwent)});
//        mod.addRow(new String[] {" "," ", "Grand Total", Formats.centavoDecimal.format(grandTotal), " "}); 
//        mod.setColumnCount(3);
        return mod;
    }

public static DefaultTableModel getReceivableBalance(int clientType){
     DefaultTableModel mod = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
       
//       ArrayList<Client> cl = Client.getCustomerList(0);
    
//       for(Client clients: cl){
        mod.setColumnIdentifiers(new String[] {"Client No.","Client Name.","Client Address","SubType","Balance"});
            ArrayList<Invoice> arrItems = Invoice.getInvoicesWithPayments(clientType);
        double grandTotal =0.0;
        for(Invoice emp: arrItems){
//           mod.addRow(new String[] {Formats.dateFormatMinutes.format(emp.getInvoiceDate())+"",emp.getInvoiceNumber()+"", emp.getInvoiceTotalPrice().toString()+"",emp.getInvoiceCurrentBalance().toString()+"", Formats.dateFormatDays.format(emp.getInvoiceDueDate())});
            Double balance = emp.getInvoiceTotalPrice() - emp.getPayments();
//           mod.addRow(new String[] {Formats.dateFormatMinutes.format(emp.getInvoiceDate())+"",emp.getInvoiceNumber()+"", emp.getInvoiceTotalPrice().toString()+"",emp.getInvoiceCurrentBalance().toString()+"", Formats.dateFormatDays.format(emp.getInvoiceDueDate())});
//            Double balance = emp.getInvoiceTotalPrice() - Collections.getCollectionAmountUsingId(emp.getInvoiceId().toString());
//            grandTotal += balance;
//            mod.addRow(new String[] {emp.getClientNumber(),emp.getClientName(),emp.getClientAddress() ,ClientAction.getSubtype(emp.getClientSubType()),Formats.centavoDecimal.format(balance)}); 
            if(balance > 0.0){
                grandTotal += balance;
            mod.addRow(new String[] {emp.getClientNumber(),emp.getClientName(),emp.getClientAddress() ,ClientAction.getSubtype(emp.getClientSubType()),Formats.centavoDecimal.format(balance)}); 
            }
        }
        mod.addRow(new String[] {" "," "," ", "Grand Total", Formats.centavoDecimal.format(grandTotal)}); 
//        mod.setColumnCount(3);
        
//       }
    return mod;
//            this.dispose();
    }



public static DefaultTableModel getReceivableBalanceSubtype(int clientType, Short subType){
     DefaultTableModel mod = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
       
//       ArrayList<Client> cl = Client.getCustomerList(0);
    
//       for(Client clients: cl){
        mod.setColumnIdentifiers(new String[] {"Client No.","Client Name.","Client Address","SubType","Balance"});
            ArrayList<Invoice> arrItems = Invoice.getInvoicesWithPaymentsSubType(clientType,subType);
        double grandTotal =0.0;
        for(Invoice emp: arrItems){
//           mod.addRow(new String[] {Formats.dateFormatMinutes.format(emp.getInvoiceDate())+"",emp.getInvoiceNumber()+"", emp.getInvoiceTotalPrice().toString()+"",emp.getInvoiceCurrentBalance().toString()+"", Formats.dateFormatDays.format(emp.getInvoiceDueDate())});
            Double balance = emp.getInvoiceTotalPrice() - emp.getPayments();
//           mod.addRow(new String[] {Formats.dateFormatMinutes.format(emp.getInvoiceDate())+"",emp.getInvoiceNumber()+"", emp.getInvoiceTotalPrice().toString()+"",emp.getInvoiceCurrentBalance().toString()+"", Formats.dateFormatDays.format(emp.getInvoiceDueDate())});
//            Double balance = emp.getInvoiceTotalPrice() - Collections.getCollectionAmountUsingId(emp.getInvoiceId().toString());
            if(balance > 0.0){
                grandTotal += balance;
            mod.addRow(new String[] {emp.getClientNumber(),emp.getClientName(),emp.getClientAddress() ,ClientAction.getSubtype(emp.getClientSubType()),Formats.centavoDecimal.format(balance)}); 
            }
        }
        mod.addRow(new String[] {" "," "," ", "Grand Total", Formats.centavoDecimal.format(grandTotal)}); 
//        mod.setColumnCount(3);
        
//       }
    return mod;
//            this.dispose();
    }

public static DefaultTableModel getPayableSummaryTableData(int supplierNumber){
       DefaultTableModel mod = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
       
        mod.setColumnIdentifiers(new String[] {"InvoiceID","Date","Invoice No.","Amount", "Balance", "Due Date"});
        ArrayList<Invoice> arrItems = Invoice.getInvoiceWithClient(supplierNumber);
        double grandTotal =0.0;
        for(Invoice emp: arrItems){
            Double balance = emp.getInvoiceTotalPrice() - Collections.getCollectionBalanceUsingId(emp.getInvoiceId().toString());
            grandTotal += balance;
//            Double balance = emp.getInvoiceTotalPrice() - Collections.getCollectionAmount(emp.getInvoiceNumber());
//           mod.addRow(new String[] {Formats.dateFormatMinutes.format(emp.getInvoiceDate())+"",emp.getInvoiceNumber()+"", emp.getInvoiceTotalPrice().toString()+"",emp.getInvoiceCurrentBalance().toString()+"", Formats.dateFormatDays.format(emp.getInvoiceDueDate())});
           mod.addRow(new String[] {emp.getInvoiceId()+"",Formats.dateFormatMinutes2.format(emp.getInvoiceDate())+"",emp.getInvoiceNumber()+" - " +emp.getInvoiceId(), Formats.centavoDecimal.format(emp.getInvoiceTotalPrice()).toString()+"",Formats.centavoDecimal.format(balance)+"", Formats.dateFormatDays2.format(emp.getInvoiceDueDate())});
            
        }
        mod.addRow(new String[] {" "," ", "Grand Total", Formats.centavoDecimal.format(grandTotal), " "}); 
//        mod.setColumnCount(3);
        return mod;
    }


public static DefaultTableModel getAccountSummaryTableData(int clientNumber){
       DefaultTableModel mod = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
       
        mod.setColumnIdentifiers(new String[] {"Invoice No.","Amount", "Balance","Date", "Due Date", "Edited By", "Edit Date", "Invoice id"});
        ArrayList<Invoice> arrItems = Invoice.getInvoiceWithClient(clientNumber);
//        double grandTotal =0.0;
        
        
        for(Invoice emp: arrItems){
            String editDate = "-";
            if(emp.getInvoiceEditDate() != null){
                editDate = Formats.dateFormatDays2.format(emp.getInvoiceEditDate());
            }
            Double balance = emp.getInvoiceTotalPrice() - Collections.getCollectionBalanceUsingId(emp.getInvoiceId().toString());
//            grandTotal += balance;
//            Double balance = emp.getInvoiceTotalPrice() - Collections.getCollectionAmount(emp.getInvoiceNumber());
//           mod.addRow(new String[] {Formats.dateFormatMinutes.format(emp.getInvoiceDate())+"",emp.getInvoiceNumber()+"", emp.getInvoiceTotalPrice().toString()+"",emp.getInvoiceCurrentBalance().toString()+"", Formats.dateFormatDays.format(emp.getInvoiceDueDate())});
           mod.addRow(new String[] {emp.getInvoiceNumber()+"", Formats.centavoDecimal.format(emp.getInvoiceTotalPrice()).toString()+"",Formats.centavoDecimal.format(balance)+"",Formats.dateFormatMinutes2.format(emp.getInvoiceDate())+"", Formats.dateFormatDays2.format(emp.getInvoiceDueDate()),
               emp.getInvoiceEditUser(), editDate, emp.getInvoiceId()+""});
            
        }
//        mod.addRow(new String[] {" "," ", "Grand Total", Formats.centavoDecimal.format(grandTotal), " "}); 
//        mod.setColumnCount(3);
        return mod;
    }

public static DefaultTableModel getItemLedgerTableData(int itemNumber, String fromCal, String toCal){
       DefaultTableModel mod = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
      
        mod.setColumnIdentifiers(new String[] {"Date","Invoice No.","Particulars","Price","IN","OUT","Balance"});
        ArrayList<Invoice> arrItems = Invoice.getInvoiceListWithItem(itemNumber, fromCal, toCal);
        Double quantityAs =0.0;
        String fracQuant = new String();
        String fracQuantAs = new String();
        for(Invoice emp: arrItems){
            fracQuant = FractionAction.convertToFraction(emp.getQuantity());
           if(emp.getInvoiceTypeFlag().equals(new Short("1"))){
               quantityAs+=emp.getQuantity();
               fracQuantAs = FractionAction.convertToFraction(quantityAs);
//               mod.addRow(new String[] {Formats.dateFormatDays.format(emp.getInvoiceDate())+"",emp.getInvoiceNumber()+"", emp.getClientName()+"", emp.getPrice()+"",emp.getQuantity()+"","-", emp.getQuantityAsOf()+""});
               mod.addRow(new String[] {Formats.dateFormatDays2.format(emp.getInvoiceDate())+"",emp.getInvoiceNumber()+"", emp.getClientName()+"", emp.getPrice()+"",fracQuant+"","-", fracQuantAs+""});
           } else {
               quantityAs-=emp.getQuantity();
               fracQuantAs = FractionAction.convertToFraction(quantityAs);
//               mod.addRow(new String[] {Formats.dateFormatDays.format(emp.getInvoiceDate())+"",emp.getInvoiceNumber()+"", emp.getClientName()+"", emp.getPrice()+"","-",emp.getQuantity()+"", emp.getQuantityAsOf()+""});
               mod.addRow(new String[] {Formats.dateFormatDays2.format(emp.getInvoiceDate())+"",emp.getInvoiceNumber()+"", emp.getClientName()+"", emp.getPrice()+"","-",fracQuant+"", fracQuantAs+""});
           }
           
            
        }
//        mod.setColumnCount(3);
        return mod;
    }

public static DefaultTableModel getItemLedgerTableData(int itemNumber, String fromCal, String toCal, int locationId){
       DefaultTableModel mod = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
      
        mod.setColumnIdentifiers(new String[] {"Date","Invoice No.","Particulars","Price Sold","IN  ","OUT  ","Stocks", "Remarks"});
        ArrayList<Invoice> arrItems = Invoice.getInvoiceListWithItem(itemNumber, fromCal, toCal, locationId);
        int quantityAs =0;
        String fracQuant = new String();
        String fracQuantAs = new String();
        for(Invoice emp: arrItems){
             fracQuant = FractionAction.convertToFraction(emp.getQuantity());
                   fracQuantAs = FractionAction.convertToFraction(emp.getQuantityAsOf());
           if(emp.getInvoiceTypeFlag().equals(new Short("1"))){
                  
//               quantityAs+=emp.getQuantity();
//               mod.addRow(new String[] {Formats.dateFormatDays.format(emp.getInvoiceDate())+"",emp.getInvoiceNumber()+"", emp.getClientName()+"", emp.getPrice()+"",emp.getQuantity()+"","-", emp.getQuantityAsOf()+""});
//               mod.addRow(new String[] {Formats.dateFormatDays2.format(emp.getInvoiceDate())+"",emp.getInvoiceNumber()+"", emp.getClientName()+"", emp.getPrice()+"",emp.getQuantity()+"","-", quantityAs+""});
//               mod.addRow(new String[] {Formats.dateFormatDays2.format(emp.getInvoiceDate())+"",emp.getInvoiceNumber()+"", emp.getClientName()+"", Formats.centavoDecimal.format(emp.getPrice())+"",Formats.pesoDecimal.format(emp.getQuantity()),"-", Formats.pesoDecimal.format(emp.getQuantityAsOf()), emp.getInvoiceRemarks()});
                   mod.addRow(new String[] {Formats.dateFormatDays2.format(emp.getInvoiceDate())+"",emp.getInvoiceNumber()+"", emp.getClientName()+"", Formats.centavoDecimal.format(emp.getPrice())+"",fracQuant,"-", fracQuantAs, emp.getInvoiceRemarks()});
           } else {
//               fracQuant = FractionAction.convertToFraction(emp.getQuantity());
//                   fracQuantAs = FractionAction.convertToFraction(emp.getQuantityAsOf());
//               quantityAs-=emp.getQuantity();
//               mod.addRow(new String[] {Formats.dateFormatDays.format(emp.getInvoiceDate())+"",emp.getInvoiceNumber()+"", emp.getClientName()+"", emp.getPrice()+"","-",emp.getQuantity()+"", emp.getQuantityAsOf()+""});
//               mod.addRow(new String[] {Formats.dateFormatDays2.format(emp.getInvoiceDate())+"",emp.getInvoiceNumber()+"", emp.getClientName()+"", emp.getPrice()+"","-",emp.getQuantity()+"", quantityAs+""});
//               mod.addRow(new String[] {Formats.dateFormatDays2.format(emp.getInvoiceDate())+"",emp.getInvoiceNumber()+"", emp.getClientName()+"", Formats.centavoDecimal.format(emp.getPrice())+"","-",Formats.pesoDecimal.format(emp.getQuantity())+"", Formats.pesoDecimal.format(emp.getQuantityAsOf())+"", emp.getInvoiceRemarks()});
                   mod.addRow(new String[] {Formats.dateFormatDays2.format(emp.getInvoiceDate())+"",emp.getInvoiceNumber()+"", emp.getClientName()+"", Formats.centavoDecimal.format(emp.getPrice())+"","-",fracQuant+"", fracQuantAs+"", emp.getInvoiceRemarks()});
           }
           
            
        }
//        mod.setColumnCount(3);
        return mod;
    }

public static DefaultTableModel getItemLedgerTableData(int itemNumber){
       DefaultTableModel mod = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
       
        mod.setColumnIdentifiers(new String[] {"Date","Invoice No.","Client Name","Price Sold","IN","OUT","Balance"});
        ArrayList<Invoice> arrItems = Invoice.getInvoiceListWithItem(itemNumber);
         String fracQuant = new String();
        String fracQuantAs = new String();
        for(Invoice emp: arrItems){
             fracQuant = FractionAction.convertToFraction(emp.getQuantity());
                   fracQuantAs = FractionAction.convertToFraction(emp.getQuantityAsOf());
           if(emp.getInvoiceTypeFlag().equals(new Short("1"))){
//               mod.addRow(new String[] {Formats.dateFormatMinutes.format(emp.getInvoiceDate())+"",emp.getInvoiceNumber()+"", emp.getClientName()+"", emp.getPrice()+"",emp.getQuantity()+"","-", emp.getQuantityAsOf()+""});
               mod.addRow(new String[] {Formats.dateFormatMinutes.format(emp.getInvoiceDate())+"",emp.getInvoiceNumber()+"", emp.getClientName()+"", emp.getPrice()+"",fracQuant+"","-", fracQuantAs+""});
           } else {
//               mod.addRow(new String[] {Formats.dateFormatMinutes.format(emp.getInvoiceDate())+"",emp.getInvoiceNumber()+"", emp.getClientName()+"", emp.getPrice()+"","-",emp.getQuantity()+"", emp.getQuantityAsOf()+""});
               mod.addRow(new String[] {Formats.dateFormatMinutes.format(emp.getInvoiceDate())+"",emp.getInvoiceNumber()+"", emp.getClientName()+"", emp.getPrice()+"","-",fracQuant+"",fracQuantAs+""});
           }
           
            
        }
//        mod.setColumnCount(3);
        return mod;
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
               
           case 96:
               return("Convert");
                   
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
            String fracQuant = FractionAction.convertToFraction(emp.getQuantity());
        
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
//                 mod.addRow(new String[] {" ",temp.getItemName()+"",temp.getTransactionQuantity().toString()+"",Formats.centavoDecimal.format(temp.getTransactionPrice())+"", Formats.centavoDecimal.format(temp.getTransactionSubTotal())});
                 mod.addRow(new String[] {" ",temp.getItemName()+"",fracQuant+"",Formats.centavoDecimal.format(temp.getTransactionPrice())+"", Formats.centavoDecimal.format(temp.getTransactionSubTotal())});
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
//            if(emp.getQuantity() == null){
//                
//            }
              
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
                 String fracQuant = FractionAction.convertToFraction(temp.getTransactionQuantity());
                 mod.addRow(new String[] {" ",temp.getItemName()+"",fracQuant+"",Formats.centavoDecimal.format(temp.getTransactionPrice())+"", Formats.centavoDecimal.format(temp.getTransactionSubTotal())});
                 totalAmount += temp.getTransactionSubTotal();
             }
           mod.addRow(new String[] {" ", "Total", " ", " ", Formats.centavoDecimal.format(totalAmount)+""});
           mod.addRow(new String[] {" ", " ", " ", " "," "});           
         grandTotal += totalAmount;
        }
        mod.addRow(new String[] {"Grand Total", " ", " ", " ", Formats.centavoDecimal.format(grandTotal)+""});
        
       
        return mod;
    }

public static DefaultTableModel getInvoiceDetailedSalesPersonData(int clientId, String fromDate, String toDate){
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
        ArrayList<Invoice> arrClients = Invoice.getAllInvoiceWithSalesPerson(clientId, fromDate, toDate);
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
//            if(emp.getQuantity() == null){
//                
//            }
              
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
                 String fracQuant = FractionAction.convertToFraction(temp.getTransactionQuantity());
                 mod.addRow(new String[] {" ",temp.getItemName()+"",fracQuant+"",Formats.centavoDecimal.format(temp.getTransactionPrice())+"", Formats.centavoDecimal.format(temp.getTransactionSubTotal())});
                 totalAmount += temp.getTransactionSubTotal();
             }
           mod.addRow(new String[] {" ", "Total", " ", " ", Formats.centavoDecimal.format(totalAmount)+""});
           mod.addRow(new String[] {" ", " ", " ", " "," "});           
         grandTotal += totalAmount;
        }
        mod.addRow(new String[] {"Grand Total", " ", " ", " ", Formats.centavoDecimal.format(grandTotal)+""});
        
       
        return mod;
    }


// Gets new Sales Report per supplier per location
public static DefaultTableModel getInvoiceSalesReportSupplier(int clientId, String fromDate, String toDate, int locationId){
       DefaultTableModel mod = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
       
//        mod.setColumnIdentifiers(new String[] {"Invoice #","IN-OUT","Client","Payment Type","Total Balance", "Transaction", "Date", "Date Due", "Added by", "Add Date", "Edited by", "Edit Date", "invoice number"});
//        mod.setColumnIdentifiers(new String[] {"Invoice #","Transaction","Client","Payment Type","Total Amount","Date", "Date Due", "Added by", "Add Date", "Edited by"
//                , "Edit Date", "invoice number"});
       mod.setColumnIdentifiers(new String[] {"Item Name","Quantity", "Returns", "Total"});
        Double grandTotal = 0.0;
        ArrayList<Item> arrClients = Item.getSalesSupplier(clientId, locationId, fromDate, toDate) ;
        for(Item emp: arrClients){
            String quantity = FractionAction.convertToFraction(emp.getQuantity());
            String returns = FractionAction.convertToFraction(emp.getItemCurrentQuantity());
            String total = FractionAction.convertToFraction(emp.getQuantity()-emp.getItemCurrentQuantity());
            mod.addRow(new String[] {emp.getItemName(), quantity, returns, total});
            
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
//              String fracQuant = FractionAction.convertToFraction(emp.getQuantity());
//            String dueDate;
//            String date;
//            if(emp.getInvoiceDueDate() == null || emp.getInvoicePaymentType().equals(new Short("0"))){
//                dueDate = "-";
//            }else{
//                dueDate =  Formats.dateFormatDays2.format(emp.getInvoiceDueDate());
//            }
//            if(emp.getInvoiceDate() == null){
//                date = "-";
//            }else{
//                date = Formats.dateFormatDays2.format(emp.getInvoiceDate());
//            }
//            Double totalAmount = 0.00;
////        if(!transactionList.isEmpty()){
//        
////        for(Transaction emp: transactionList){
////           mod.addRow(new String[] {emp.getItemName()+"",emp.getSupplierName()+"",emp.getTransactionQuantity().toString()+"",Formats.centavoDecimal.format(emp.getTransactionPrice())+"", Formats.centavoDecimal.format(emp.getTransactionSubTotal())});
////            totalAmount += emp.getTransactionSubTotal();
////        }
//       
////           mod.addRow(new String[] {emp.getInvoiceNumber()+"",cType+"",emp.getClientName()+"",payment+"",emp.getInvoiceTotalPrice()+"",cType+"",Formats.dateFormatMinutes.format(emp.getInvoiceDate())+"",
////               dueDate, emp.getInvoiceAddUser(),addDate, emp.getInvoiceEditUser(),editDate, emp.getInvoiceId()+""});
////           mod.addRow(new String[] {emp.getInvoiceNumber()+"",cType+"",emp.getClientName()+"",payment+"",Formats.centavoDecimal.format(emp.getInvoiceTotalPrice())
////                   ,Formats.dateFormatDays.format(emp.getInvoiceDate())+"",dueDate, emp.getInvoiceAddUser(),addDate, emp.getInvoiceEditUser(),editDate, emp.getInvoiceId()+""});
////            mod.addRow(new String[] {"Invoice #",emp.getInvoiceNumber()+"","Date",date});
//            mod.addRow(new String[] {"Invoice #",emp.getInvoiceNumber()+""});
//            mod.addRow(new String[] {"Date",date});
////            mod.addRow(new String[] {"Payment Type",payment +"","Due Date", dueDate});
//            
////            mod.addRow(new String[] {" "," "});
//            mod.addRow(new String[] {"Payment Type",payment +""});
//            mod.addRow(new String[] {"Due Date", dueDate});
//            mod.addRow(new String[] {" ","Item Name", "Quantity", "Amount per","Sub Total"});
//             ArrayList<Transaction> transactionList = Transaction.getTransactions(""+emp.getInvoiceId());
//             for(Transaction temp: transactionList){
//                 mod.addRow(new String[] {" ",temp.getItemName()+"",fracQuant+"",Formats.centavoDecimal.format(temp.getTransactionPrice())+"", Formats.centavoDecimal.format(temp.getTransactionSubTotal())});
//                 totalAmount += temp.getTransactionSubTotal();
//             }
//           mod.addRow(new String[] {" ", "Total", " ", " ", Formats.centavoDecimal.format(totalAmount)+""});
//           mod.addRow(new String[] {" ", " ", " ", " "," "});           
//         grandTotal += totalAmount;
        }
//        mod.addRow(new String[] {"Grand Total", " ", " ", " ", Formats.centavoDecimal.format(grandTotal)+""});
        
       
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
             String fracQuant = FractionAction.convertToFraction(emp.getQuantity());
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
                 mod.addRow(new String[] {" ",temp.getItemName()+"",fracQuant+"",Formats.centavoDecimal.format(temp.getTransactionPrice())+"", Formats.centavoDecimal.format(temp.getTransactionSubTotal())});
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
                creditBalance = t.getCreditLimit() - (t.getInvoiceTotalPrice()+ tot- t.getPayments());
                return creditBalance;
            }
        
        
    } catch (Exception e){
            try {
                e.printStackTrace();
                con.rollback();
//                return success;
            } catch (SQLException ex) {
                Logger.getLogger(InvoiceAction.class.getName()).log(Level.SEVERE, null, ex);
            }
    } finally {
            try {
                
                con.close();
//                return success;
            } catch (SQLException ex) {
                Logger.getLogger(InvoiceAction.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
        return creditBalance;
//            this.dispose();
    }

public static int adjustmentSQLLogic(int clientId, String total, boolean receivableFlg, int paymentType, Transaction transaction, boolean outFlg, int locationId, String remarks ){
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
        int curId = Invoice.getLatestInvoice(con);
                 GregorianCalendar cal = new GregorianCalendar();
                                                          InvoiceAction.insertInvoice(clientId, total,balance, "ADJ"+curId, receivableFlg, paymentType,cal.get(GregorianCalendar.YEAR), cal.get(GregorianCalendar.MONTH), cal.get(GregorianCalendar.DAY_OF_MONTH),con, locationId, outFlg, " ", remarks);   
        
        int invoiceId = Invoice.getLatestInvoice(con);
//         cal.set(GregorianCalendar.YEAR, year);
//         cal.set(GregorianCalendar.MONTH, month);
//         cal.set(GregorianCalendar.DATE, day);
            
            Transaction t = transaction;
                boolean exist = false;
                Double quantityAsOf = 0.0;
                Double stockQuantity = 0.0;
                Item i = Item.getItem(t.getTransactionItemNumber().toString(), con);
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
                            quantityAsOf = item.getItemCurrentQuantity()-t.getTransactionQuantity();
                            stockQuantity = stockQuantity-t.getTransactionQuantity();
                        } else {
                            quantityAsOf = item.getItemCurrentQuantity()+t.getTransactionQuantity();
                            stockQuantity = stockQuantity+t.getTransactionQuantity();
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
//                      s = Stocks.calculateStocks(i.getItemId().toString(), locationId+"");
                    stockQuantity = s.getStocksQuantity();
                  } 
                   if(outFlg){
                      quantityAsOf = i.getItemCurrentQuantity()-t.getTransactionQuantity();
                      stockQuantity = stockQuantity-t.getTransactionQuantity();
                   } else {
                      quantityAsOf = i.getItemCurrentQuantity()+t.getTransactionQuantity();
                      stockQuantity = stockQuantity+t.getTransactionQuantity();
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
                
                t.setTransactionDate(cal.getTime());
                t.setTransactionInvoiceId(invoiceId);
                t.setTransactionAddDate(new GregorianCalendar().getTime());
                t.setTransactionAddUser(System.getProperty("userName"));
                t.setTransactionQuantityAsOf(quantityAsOf);
                
                
                success = Transaction.addInTransaction(t,con);
//                success = Item.updateItemQuantity(t.getTransactionItemNumber(), t.getTransactionQuantityAsOf(), Formats.dateFormatDays.format(new GregorianCalendar().getTime()), con);
                
                
            
            for(Item items: itemList){
                   success = Item.updateItemQuantity(items.getItemId(), items.getItemCurrentQuantity(), Formats.dateFormatDays.format(new GregorianCalendar().getTime()), con);
            }
            for(Stocks s2: newStockList){
                success = Stocks.insertStocks(s2.getStocksItemId().toString(), s2.getStocksLocationId().toString(), s2.getStocksQuantity().toString(), con);
            }
            for(Stocks s2: existingStockList){
//                success = Stocks.updateStocks(s2.getStocksItemId().toString(), s2.getStocksLocationId().toString(), s2.getStocksQuantity().toString(),s2.getStocksId().toString(), con);
                success = Stocks.deleteStocks(s2.getStocksId().toString(), con);
                success = Stocks.insertStocks(s2.getStocksItemId().toString(), s2.getStocksLocationId().toString(), s2.getStocksQuantity().toString(), con);
            }
            con.commit();
    } catch (Exception e){
            try {
                e.printStackTrace();
                con.rollback();
                return success;
            } catch (SQLException ex) {
                Logger.getLogger(InvoiceAction.class.getName()).log(Level.SEVERE, null, ex);
            }
    } finally {
            try {
                
                con.close();
                return success;
            } catch (SQLException ex) {
                Logger.getLogger(InvoiceAction.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
        return success;
//            this.dispose();
    }


public static ArrayList<Transaction> checkDeletedItems(ArrayList<Transaction> addList, ArrayList<Transaction> delList){
        ArrayList<Transaction> nDelList = new ArrayList<Transaction>();
        nDelList = delList;
         for(Transaction add: addList){
            for(int i =0; i< delList.size(); i++){
                Transaction del = delList.get(i);
                int addNum = add.getTransactionItemNumber();
                int delNum = del.getTransactionItemNumber();
                if( addNum == delNum){
                    nDelList.get(i).setDoubleFlag(new Short("1"));
                }
            } 
         }
       
        return nDelList;
    }

public static int convertSQLLogic(int clientId, String total, String invoiceNumber, boolean receivableFlg, int paymentType, ArrayList<Transaction> transactionList, int year, int month, int day,boolean outFlg, int locationId ){
    Connection con = SQLConnection.getSQLConnection();
    int success = 1;
    try{
//        Connection con = SQLConnection.getSQLConnection();
        ArrayList<Item> itemList = new ArrayList<Item>();
        ArrayList<Stocks> newStockList = new ArrayList<Stocks>();
        ArrayList<Stocks> existingStockList = new ArrayList<Stocks>();
        con.setAutoCommit(false);
//        Double balance = Double.parseDouble(Formats.centavoDecimal.parse(total));
        Double balance = 0.0;
//        balance-= Invoice.getInvoiceBalance(invoiceId+"",con);
        
        success = InvoiceAction.insertConvert(clientId, total,balance, invoiceNumber, receivableFlg, paymentType,year, month, day,con, locationId, outFlg);   
        
         GregorianCalendar cal = new GregorianCalendar();
         cal.set(GregorianCalendar.YEAR, year);
         cal.set(GregorianCalendar.MONTH, month);
         cal.set(GregorianCalendar.DATE, day);
            int invoiceId = Invoice.getLatestInvoice(con);
            for(Transaction t: transactionList){
                boolean exist = false;
                Double quantityAsOf = 0.0;
                Double stockQuantity = 0.0;
                Item i = Item.getItem(t.getTransactionItemNumber().toString(), con);
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
                            quantityAsOf = item.getItemCurrentQuantity()-t.getTransactionQuantity();
                            stockQuantity = stockQuantity-t.getTransactionQuantity();
                        } else {
                            quantityAsOf = item.getItemCurrentQuantity()+t.getTransactionQuantity();
                            stockQuantity = stockQuantity+t.getTransactionQuantity();
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
                      quantityAsOf = i.getItemCurrentQuantity()-t.getTransactionQuantity();
                      stockQuantity = stockQuantity-t.getTransactionQuantity();
                   } else {
                      quantityAsOf = i.getItemCurrentQuantity()+t.getTransactionQuantity();
                      stockQuantity = stockQuantity+t.getTransactionQuantity();
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
                
                t.setTransactionDate(cal.getTime());
                t.setTransactionInvoiceId(invoiceId);
                t.setTransactionAddDate(new GregorianCalendar().getTime());
                t.setTransactionAddUser(System.getProperty("userName"));
                t.setTransactionQuantityAsOf(quantityAsOf);
                
                
                success = Transaction.addInTransaction(t,con);
//                success = Item.updateItemQuantity(t.getTransactionItemNumber(), t.getTransactionQuantityAsOf(), Formats.dateFormatDays.format(new GregorianCalendar().getTime()), con);
                
                
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
                Logger.getLogger(InvoiceAction.class.getName()).log(Level.SEVERE, null, ex);
            }
    } finally {
            try {
                
                con.close();
                return success;
            } catch (SQLException ex) {
                Logger.getLogger(InvoiceAction.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
        return success;
//            this.dispose();
    }
 
public static int insertConvert( int clientNumber, String price, Double balance, String receiptNo, boolean isReceivable, int paymentType, int year, int month, int day, Connection con, int locationId, boolean isOut) throws Exception{
       
       Invoice c = new Invoice();
       c.setInvoiceNumber(receiptNo);
       c.setInvoiceTotalPrice(balance);
       c.setInvoiceCurrentBalance(balance);
       c.setInvoicePaymentType(Short.parseShort(""+paymentType));
       c.setInvoiceClientNumber(clientNumber);
       //IN FLAG
       c.setInvoiceTypeFlag(Short.parseShort("1"));
       //1: CREDIT 0:CASH
       if(isReceivable){
           c.setInvoiceReceivableFlag(new Short("1"));
           c.setInvoicePaidFlag(new Short("0"));
       } else {
           c.setInvoiceReceivableFlag(new Short("0"));
           c.setInvoicePaidFlag(new Short("1"));
       }
       if(isOut){
           c.setInvoiceTypeFlag(new Short("0"));
       } else {
           c.setInvoiceTypeFlag(new Short("1"));
       }
       GregorianCalendar cal = new GregorianCalendar();
       cal.set(GregorianCalendar.YEAR, year);
       cal.set(GregorianCalendar.MONTH, month);
       cal.set(GregorianCalendar.DATE, day);
       c.setInvoiceDate(cal.getTime());
       c.setInvoiceDueDate(getDueDate(cal, paymentType));
       c.setInvoiceAddDate(new GregorianCalendar().getTime());
       c.setInvoiceAddUser(System.getProperty("userName"));
       c.setInvoiceLocationId(locationId);
       c.setInvoiceTransferFlag(new Short("0"));
       return (Invoice.addInvoice(c, con));
                   
    }




}
