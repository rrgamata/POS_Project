/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AddClient.java
 *
 * Created on Jul 17, 2013, 2:38:44 PM
 */
package pos_project.UI;

import java.awt.Color;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import pos_project.Action.InvoiceAction;
import pos_project.Action.DateActions;
import pos_project.Action.FractionAction;
import pos_project.Action.LocationAction;
import pos_project.Action.ReturnAction;
import pos_project.classes.Client;
import pos_project.classes.Collections;
import pos_project.classes.ErrorMessages;
import pos_project.classes.Formats;
import pos_project.classes.Invoice;
import pos_project.classes.Item;
import pos_project.classes.ReturnMain;
import pos_project.classes.Returns;
import pos_project.classes.Transaction;

/**
 *
 * @author Cif3r
 */
public class ReturnUi extends javax.swing.JDialog {
 private boolean outFlg = false;
 private boolean editFlg = false;
    private String itemNumber;
//    ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
//    ArrayList<Integer> deleteList = new ArrayList<Integer>();
    ArrayList<Returns> deleteList = new ArrayList<Returns>();
    ArrayList<Returns> returnList = new ArrayList<Returns>();
    Item item;
    Client client;
    Invoice invoice;
    ReturnMain returnItem;
    
    /** Creates new form AddClient */
    public ReturnUi(java.awt.Frame parent, boolean modal, boolean isEdit, String invoiceNumber) {
        super(parent, modal);
        
        
        
        initComponents();
        invoice = Invoice.getInvoiceWithId(invoiceNumber);
        locationComboBox.setModel(LocationAction.getLocationModel());
        locationComboBox.setSelectedItem(Client.getClient(invoice.getInvoiceLocationId()+""));
        switch(invoice.getInvoiceTypeFlag()){
            case 1: outFlg = false;
                break;
            default: outFlg = true;
        }
        editFlg = isEdit;
      
        itemNameLabel.setText(InvoiceAction.getInvoiceType(invoice.getInvoiceTypeFlag()));
        paymentComboBox.setSelectedIndex(invoice.getInvoicePaymentType());
        transactionNumberTextField.setText(invoice.getInvoiceNumber());
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(invoice.getInvoiceDate());
        invoiceDate.setText(Formats.dateFormatDays2.format(invoice.getInvoiceDate()));
//        invoiceYearComboBox.setSelectedItem(""+cal.get(GregorianCalendar.YEAR));
//        invoiceMonthComboBox.setSelectedIndex(cal.get(GregorianCalendar.MONTH));
//        invoiceDayComboBox.setSelectedIndex(cal.get(GregorianCalendar.DATE)-1);
            invoiceYearComboBox.setModel(DateActions.getYearModel());
            invoiceYearComboBox.setSelectedItem(new GregorianCalendar().get(GregorianCalendar.YEAR));
            invoiceMonthComboBox.setSelectedIndex(new GregorianCalendar().get(GregorianCalendar.MONTH));
            invoiceDayComboBox.setModel(DateActions.fixDay(invoiceMonthComboBox.getSelectedIndex(), invoiceYearComboBox.getSelectedItem().toString()));
            invoiceDayComboBox.setSelectedIndex(new GregorianCalendar().get(GregorianCalendar.DATE)-1);
            
        customerNameLabel.setText(invoice.getClientName());
          clientAddress.setText(invoice.getClientAddress());
        if(invoice.getInvoicePaymentType() != 0){
            dueDate.setText(Formats.dateFormatDays2.format(invoice.getInvoiceDueDate()));
        }
        client = Client.getClient(Integer.toString(invoice.getClientId()));
          if(outFlg){
            supplierLabel.setText("Customer Name");
            supplierNumberLabel.setText("Customer #");
        } else {
            supplierLabel.setText("Supplier Name");
            supplierNumberLabel.setText("Supplier #");
            
        }
        customerNumberLabel.setText(client.getClientNumber());
        jButton2.setVisible(false);
        jButton1.setVisible(false);
//        transactionList = Transaction.getTransactions(""+invoice.getInvoiceId());
        initializeTable();
//        transactionList =
//        transactionList = new ArrayList<Transaction>();
//        outFlg = isOut;
//        this.setTitle("New Invoice Details");
        
//        itemNameLabel.setVisible(false);
//            customerNameLabel.setEnabled(true);
//            supplierLabel.setEnabled(true);
//            jButton1.setEnabled(true);
//            invoiceYearComboBox.setModel(DateActions.getYearModel());
//            invoiceYearComboBox.setSelectedItem(new GregorianCalendar().get(GregorianCalendar.YEAR));
//            invoiceMonthComboBox.setSelectedIndex(new GregorianCalendar().get(GregorianCalendar.MONTH));
//            invoiceDayComboBox.setModel(DateActions.fixDay(invoiceMonthComboBox.getSelectedIndex(), invoiceYearComboBox.getSelectedItem().toString()));
//            invoiceDayComboBox.setSelectedIndex(new GregorianCalendar().get(GregorianCalendar.DATE)-1);
//            
//            initializeTable();
//        } else {
//            customerNameLabel.setVisible(false);
//            supplierLabel.setVisible(false);
//            jButton1.setVisible(false);
//        }
        
                
    }
    
      /** Loads Return from */
    public ReturnUi(java.awt.Frame parent, boolean modal, boolean isEdit ,String invoiceNumber, String returnNumber) {
        super(parent, modal);
        
        initComponents();
        invoice = Invoice.getInvoiceWithId(invoiceNumber);
        locationComboBox.setModel(LocationAction.getLocationModel());
        locationComboBox.setSelectedItem(Client.getClient(invoice.getInvoiceLocationId()+""));
        switch(invoice.getInvoiceTypeFlag()){
            case 1: outFlg = false;
                break;
            default: outFlg = true;
        }
        
        editFlg = isEdit;
        returnItem = ReturnMain.getReturnMain(Integer.parseInt(returnNumber));
        itemNameLabel.setText(InvoiceAction.getInvoiceType(invoice.getInvoiceTypeFlag()));
        paymentComboBox.setSelectedIndex(invoice.getInvoicePaymentType());
        transactionNumberTextField.setText(invoice.getInvoiceNumber());
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(returnItem.getReturnMainDate());
//        cal.setTime(invoice.getInvoiceDate());
        invoiceDate.setText(Formats.dateFormatDays2.format(invoice.getInvoiceDate()));
        invoiceYearComboBox.setSelectedItem(""+cal.get(GregorianCalendar.YEAR));
        invoiceMonthComboBox.setSelectedIndex(cal.get(GregorianCalendar.MONTH));
        invoiceDayComboBox.setSelectedIndex(cal.get(GregorianCalendar.DATE)-1);
        customerNameLabel.setText(invoice.getClientName());
          clientAddress.setText(invoice.getClientAddress());
        if(invoice.getInvoicePaymentType() != 0){
            dueDate.setText(Formats.dateFormatDays2.format(invoice.getInvoiceDueDate()));
        }
        client = Client.getClient(Integer.toString(invoice.getClientId()));
          if(outFlg){
            supplierLabel.setText("Customer Name");
            supplierNumberLabel.setText("Customer #");
        } else {
            supplierLabel.setText("Supplier Name");
            supplierNumberLabel.setText("Supplier #");
            
        }
        customerNumberLabel.setText(client.getClientNumber());
        jButton2.setVisible(false);
        jButton1.setVisible(false);
        returnNumberTextField.setText(returnItem.getReturnMainNumber());
        returnList = Returns.getReturns(returnNumber);
        initializeTable();
                
    }
    
  

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        supplierLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        AddInvoiceOkButton = new javax.swing.JButton();
        AddClientCancelButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        customerNameLabel = new javax.swing.JLabel();
        itemNameLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        totalLabel = new javax.swing.JLabel();
        totalValueLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        addItemButton = new javax.swing.JButton();
        removeItemButton = new javax.swing.JButton();
        paymentComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        invoiceMonthComboBox = new javax.swing.JComboBox();
        invoiceDayComboBox = new javax.swing.JComboBox();
        invoiceYearComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        clientAddress = new javax.swing.JLabel();
        jLabelSomething = new javax.swing.JLabel();
        dueDate = new javax.swing.JLabel();
        locationComboBox = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemTable = new javax.swing.JTable();
        supplierNumberLabel = new javax.swing.JLabel();
        customerNumberLabel = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        returnNumberTextField = new javax.swing.JTextField();
        transactionNumberTextField = new javax.swing.JLabel();
        invoiceDate = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(550, 205));
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Invoice Details");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 0, 0);
        getContentPane().add(jLabel1, gridBagConstraints);

        supplierLabel.setText("Customer Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(supplierLabel, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Item List");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 10);
        getContentPane().add(jLabel3, gridBagConstraints);

        AddInvoiceOkButton.setText("OK");
        AddInvoiceOkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddInvoiceOkButtonActionPerformed(evt);
            }
        });
        jPanel1.add(AddInvoiceOkButton);

        AddClientCancelButton.setText("Cancel");
        AddClientCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddClientCancelButtonActionPerformed(evt);
            }
        });
        jPanel1.add(AddClientCancelButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 10);
        getContentPane().add(jPanel1, gridBagConstraints);

        jLabel5.setText("Receipt/Invoice #");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        getContentPane().add(jLabel5, gridBagConstraints);

        customerNameLabel.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(customerNameLabel, gridBagConstraints);

        itemNameLabel.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        getContentPane().add(itemNameLabel, gridBagConstraints);

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        getContentPane().add(jButton1, gridBagConstraints);

        totalLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        totalLabel.setText("Total:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        getContentPane().add(totalLabel, gridBagConstraints);

        totalValueLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        totalValueLabel.setText("0.00");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        getContentPane().add(totalValueLabel, gridBagConstraints);

        addItemButton.setText("Add Item");
        addItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemButtonActionPerformed(evt);
            }
        });
        jPanel2.add(addItemButton);

        removeItemButton.setText("Remove Item");
        removeItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeItemButtonActionPerformed(evt);
            }
        });
        jPanel2.add(removeItemButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        getContentPane().add(jPanel2, gridBagConstraints);

        paymentComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "OTC", "COD", "7 Days", "15 Days", "30 Days", "45 Days", "60 Days", "90 Days", "120 Days", "150 Days", "180 Days" }));
        paymentComboBox.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        getContentPane().add(paymentComboBox, gridBagConstraints);

        jLabel2.setText("Payment");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        getContentPane().add(jLabel2, gridBagConstraints);

        jPanel5.setLayout(new java.awt.GridBagLayout());

        invoiceMonthComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        invoiceMonthComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceMonthComboBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        jPanel5.add(invoiceMonthComboBox, gridBagConstraints);

        invoiceDayComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel5.add(invoiceDayComboBox, gridBagConstraints);

        invoiceYearComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2010", "2011", "2012", "2013", "2014", "2015" }));
        invoiceYearComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceYearComboBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel5.add(invoiceYearComboBox, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        getContentPane().add(jPanel5, gridBagConstraints);

        jLabel4.setText("Invoice Date");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(jLabel4, gridBagConstraints);

        jLabel6.setText("Invoice Type");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(jLabel6, gridBagConstraints);

        jButton2.setText("Void");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        getContentPane().add(jButton2, gridBagConstraints);

        jLabel7.setText("Address");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 0, 5);
        getContentPane().add(jLabel7, gridBagConstraints);

        clientAddress.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(clientAddress, gridBagConstraints);

        jLabelSomething.setText("DueDate");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 0, 5);
        getContentPane().add(jLabelSomething, gridBagConstraints);

        dueDate.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(dueDate, gridBagConstraints);

        locationComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cash", "7 Days", "15 Days", "30 Days", "45 Days", "60 Days", "90 Days", "120 Days", "150 Days", "180 Days" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        getContentPane().add(locationComboBox, gridBagConstraints);

        jLabel9.setText("Location");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        getContentPane().add(jLabel9, gridBagConstraints);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(452, 200));

        itemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        itemTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(itemTable);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        supplierNumberLabel.setText("Customer Number");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(supplierNumberLabel, gridBagConstraints);

        customerNumberLabel.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(customerNumberLabel, gridBagConstraints);

        jLabel10.setText("Return #");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        getContentPane().add(jLabel10, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        getContentPane().add(returnNumberTextField, gridBagConstraints);

        transactionNumberTextField.setText("jLabel11");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(transactionNumberTextField, gridBagConstraints);

        invoiceDate.setText("jLabel8");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(invoiceDate, gridBagConstraints);

        jLabel8.setText("Return Date");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(jLabel8, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddClientCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddClientCancelButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
}//GEN-LAST:event_AddClientCancelButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        SearchUi detailsPopUp;
        if(outFlg){
            detailsPopUp = new SearchUi(new JFrame(),true, 1,outFlg);
        } else {
            detailsPopUp = new SearchUi(new JFrame(),true, 2,outFlg);
        }
        
                detailsPopUp.setLocationRelativeTo(null);
                detailsPopUp.pack();
                detailsPopUp.setVisible(true);
                if(detailsPopUp.getClient() != null){
                    if(client != null && client.getClientId() != detailsPopUp.getClient().getClientId()){
                        deleteList = returnList;
                        returnList.clear();
                        initializeTable();
                    }
                    client = detailsPopUp.getClient();
                customerNameLabel.setText(client.getClientName());
                }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void addItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemButtonActionPerformed
        // TODO add your handling code here:
        ReturnsItemUi detailsPopUp;
        
          if(editFlg){
              detailsPopUp = new ReturnsItemUi(new JFrame(),true,invoice.getInvoiceId(),deleteList);
          } else {
              detailsPopUp = new ReturnsItemUi(new JFrame(),true,invoice.getInvoiceId());
          }
            
                detailsPopUp.setLocationRelativeTo(null);
                detailsPopUp.pack();
                detailsPopUp.setVisible(true);
                if( detailsPopUp.getReturns() != null){
                    returnList.add( detailsPopUp.getReturns());
                    
                }
                initializeTable();

        
        
    }//GEN-LAST:event_addItemButtonActionPerformed

    private void removeItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeItemButtonActionPerformed
        // TODO add your handling code here:
        if(-1<itemTable.getSelectedRow()){
//            transactionList.get(itemTable.getSelectedRow()).setTransactionDelFlag(Short.parseShort("1"));
//            deleteList.add(transactionList.get(itemTable.getSelectedRow()).getTransactionId());
            deleteList.add(returnList.get(itemTable.getSelectedRow()));
            returnList.remove(itemTable.getSelectedRow());
            initializeTable();
        } else {
            JOptionPane.showMessageDialog(this,ErrorMessages.ERROR_TRANSACTION_ITEM ,ErrorMessages.TITLE_ERROR,JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_removeItemButtonActionPerformed

    private void invoiceMonthComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceMonthComboBoxActionPerformed
        // TODO add your handling code here:
        invoiceDayComboBox.setModel(DateActions.fixDay(invoiceMonthComboBox.getSelectedIndex(), invoiceYearComboBox.getSelectedItem().toString()));
}//GEN-LAST:event_invoiceMonthComboBoxActionPerformed

    private void invoiceYearComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceYearComboBoxActionPerformed
        // TODO add your handling code here:
        invoiceDayComboBox.setModel(DateActions.fixDay(invoiceMonthComboBox.getSelectedIndex(), invoiceYearComboBox.getSelectedItem().toString()));
}//GEN-LAST:event_invoiceYearComboBoxActionPerformed

    private void AddInvoiceOkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddInvoiceOkButtonActionPerformed
        boolean receivableFlg =false;
        if(!checkItem()){
            if(editFlg){
                int year = Integer.parseInt(invoiceYearComboBox.getSelectedItem().toString());
                int month = invoiceMonthComboBox.getSelectedIndex();
                int day = invoiceDayComboBox.getSelectedIndex()+1;
                Client loc = (Client) locationComboBox.getSelectedItem(); 
                ReturnAction.editReturnSQLLogic(invoice.getInvoiceId(), returnItem.getReturnMainId(), totalValueLabel.getText(), returnNumberTextField.getText(), returnList, year, month, day, deleteList , outFlg, loc.getClientId(), invoice);
            } else {
                addReturnOptions(false);
            }
                    
//            int year = Integer.parseInt(invoiceYearComboBox.getSelectedItem().toString());
//            int month = invoiceMonthComboBox.getSelectedIndex();
//            int day = invoiceDayComboBox.getSelectedIndex()+1;
//            Client loc = (Client) locationComboBox.getSelectedItem();
//            ReturnAction.returnSQLLogic(invoice.getInvoiceId(), totalValueLabel.getText(), returnNumberTextField.getText(), returnList, year, month, day, loc.getClientId(), outFlg, invoice);
        }
        this.dispose();
        
       
}//GEN-LAST:event_AddInvoiceOkButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
         int confirm = JOptionPane.showConfirmDialog(this, ErrorMessages.CONFIRM_DELETE_INVOICE, ErrorMessages.TITLE_DELETE, JOptionPane.YES_NO_OPTION);
            if(confirm == JOptionPane.YES_OPTION){
                Client loc = (Client) locationComboBox.getSelectedItem();
//                      InvoiceAction.voidSQLLogic(invoice.getInvoiceId(),transactionList,outFlg, loc.getClientId());
                      this.dispose();
            }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */

    private void initializeTable(){
        
        itemTable.getTableHeader().setReorderingAllowed(false);
        DefaultTableModel mod = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
       

        mod.setColumnIdentifiers(new String[] {"Item Name", "Quantity", "Amount per","Sub Total"});
        Double totalAmount = 0.00;
        for(Returns emp: returnList){
            String fraquant = FractionAction.convertToFraction(emp.getReturnsQuantity());
           mod.addRow(new String[] {emp.getItemName()+"",fraquant+"",Formats.centavoDecimal.format(emp.getReturnsAmount())+"", Formats.centavoDecimal.format(emp.getReturnsSubTotal())});
            totalAmount += emp.getReturnsSubTotal();
        }
        

        itemTable.setModel(mod);
        itemTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        itemTable.setShowGrid(true);
        itemTable.setGridColor(Color.black);
        System.out.println(itemTable.getModel());
        totalValueLabel.setText(Formats.centavoDecimal.format(totalAmount));
    }
//    }
    
    private boolean checkClient(){
         boolean errorFlg = false;
        String errMsg = new String();
        if(customerNameLabel.isEnabled()){
         if(customerNameLabel.getText().equals("-")){
            errorFlg = true;
            errMsg += "* "+ErrorMessages.ERROR_TRANSACTION_CUSTOMER;
        }  
         if(errorFlg){
            
            JOptionPane.showMessageDialog(this,errMsg ,ErrorMessages.TITLE_ERROR,JOptionPane.ERROR_MESSAGE);
        }
        
       
    }
         return errorFlg;
        }
    private boolean checkItem(){
        boolean errorFlg = false;
        String errMsg = new String();
        
        if(transactionNumberTextField.getText().isEmpty()||transactionNumberTextField.getText() == null){
                errorFlg = true;
                errMsg += "* "+ErrorMessages.ERROR_TRANSACTION_NUMBER;
        }
         if(customerNameLabel.isEnabled()){
         if(customerNameLabel.getText().equals("-")){
            errorFlg = true;
            errMsg += "* "+ErrorMessages.ERROR_TRANSACTION_CUSTOMER;
        }  
//        checkClient();
         }
        if(returnList.isEmpty()){
            errorFlg = true;
            errMsg += "* "+ErrorMessages.ERROR_TRANSACTION_ITEM;
        } 
        if(errorFlg){
            
            JOptionPane.showMessageDialog(this,errMsg ,ErrorMessages.TITLE_ERROR,JOptionPane.ERROR_MESSAGE);
        }
        
        return errorFlg;
        
        
    }
     
     private void success(){
      int answer = JOptionPane.showConfirmDialog(this,ErrorMessages.CONFIRM_ADDED_ITEM,ErrorMessages.TITLE_SUCCESS,JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
          if(answer==0){
             transactionNumberTextField.requestFocus();
             transactionNumberTextField.setText("");
//             transactionQuantityTextField1.setText("");
//             transactionPriceTextField.setText("");
          }else{
             this.dispose();
         }
     }
     
    private void addReturnOptions(boolean isChecked){
      int answer = JOptionPane.showConfirmDialog(this,ErrorMessages.CONFIRM_CREATE_RETURN_COLLECTION,ErrorMessages.TITLE_INFORMATION,JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
      int year = Integer.parseInt(invoiceYearComboBox.getSelectedItem().toString());
      int month = invoiceMonthComboBox.getSelectedIndex();
      int day = invoiceDayComboBox.getSelectedIndex()+1;
      Client loc = (Client) locationComboBox.getSelectedItem();    
      switch(answer){
              // NO_OPTION
              case 1:    
                    ReturnAction.returnSQLLogic(invoice.getInvoiceId(), totalValueLabel.getText(), returnNumberTextField.getText(), returnList, year, month, day, loc.getClientId(), outFlg, invoice);
              break;
              // YES_OPTION    
              case 0:
                  if(isChecked){
                    ReturnAction.returnSQLLogic(invoice.getInvoiceId(), totalValueLabel.getText(), returnNumberTextField.getText(), returnList, year, month, day, loc.getClientId(), outFlg, true, invoice);
                   
                  }else {
                      checkInvoice();
                  }
                  break;
                  
         }
     }
    
    private void checkInvoice(){
        try{
        double collection = Collections.getCollectionAmountUsingId(invoice.getInvoiceId().toString());
        double value = invoice.getInvoiceTotalPrice() - collection;
        int year = Integer.parseInt(invoiceYearComboBox.getSelectedItem().toString());
        int month = invoiceMonthComboBox.getSelectedIndex();
        int day = invoiceDayComboBox.getSelectedIndex()+1;
        Client loc = (Client) locationComboBox.getSelectedItem();   
        double totalVal = Formats.centavoDecimal.parse(totalValueLabel.getText()).doubleValue();
        double totalMinusValue = value-totalVal;
            if(value < 1 || invoice.getInvoicePaymentType().equals(new Short("0"))){
                int changeInvoice = JOptionPane.showConfirmDialog(this,ErrorMessages.WARNING_INVOICE_FULLY_PAID+ErrorMessages.WARNING_ASSIGN_COLLECTION,ErrorMessages.TITLE_WARNING,JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
                   switch (changeInvoice){
                       // YES_OPTION
                       case 0:
                            SearchUi detailsPopUp = new SearchUi(new JFrame(),false, outFlg, client.getClientId());
                            detailsPopUp.setLocationRelativeTo(null);
                            detailsPopUp.pack();
                            detailsPopUp.setVisible(true);
                            Invoice newInvoice = new Invoice();
                            if(detailsPopUp.getInvoice()!= null){
                                newInvoice = detailsPopUp.getInvoice();
                                double newCollection = Collections.getCollectionAmountUsingId(newInvoice.getInvoiceId().toString());
                                double newInvoiceValue =  newInvoice.getInvoiceTotalPrice() - newCollection;
                                double totalminusNew = newInvoiceValue - totalVal;
                                if(totalminusNew < 0){
                                    JOptionPane.showConfirmDialog(this,ErrorMessages.WARNING_INVOICE_BALANCE+totalminusNew+" "+ErrorMessages.WARNING_ERROR_COLLECTION,ErrorMessages.TITLE_WARNING,JOptionPane.CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
                                } else {
                                    ReturnAction.returnSQLLogic(invoice.getInvoiceId(), totalValueLabel.getText(), returnNumberTextField.getText(), returnList, year, month, day, loc.getClientId(), outFlg, true, newInvoice);
                                }
                                
                            }
                            break;
                       // NO_OPTION
                       case 1:
                           addReturnOptions(true);
                           break;
                   }          
            }else if(totalMinusValue < 0 ){
                JOptionPane.showConfirmDialog(this,ErrorMessages.WARNING_INVOICE_BALANCE+totalMinusValue+" "+ErrorMessages.WARNING_ERROR_COLLECTION,ErrorMessages.TITLE_WARNING,JOptionPane.CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
            }else {
                ReturnAction.returnSQLLogic(invoice.getInvoiceId(), totalValueLabel.getText(), returnNumberTextField.getText(), returnList, year, month, day, loc.getClientId(), outFlg, true, invoice);
            }
        }catch(Exception e){
            e.printStackTrace();
        }        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddClientCancelButton;
    private javax.swing.JButton AddInvoiceOkButton;
    private javax.swing.JButton addItemButton;
    private javax.swing.JLabel clientAddress;
    private javax.swing.JLabel customerNameLabel;
    private javax.swing.JLabel customerNumberLabel;
    private javax.swing.JLabel dueDate;
    private javax.swing.JLabel invoiceDate;
    private javax.swing.JComboBox invoiceDayComboBox;
    private javax.swing.JComboBox invoiceMonthComboBox;
    private javax.swing.JComboBox invoiceYearComboBox;
    private javax.swing.JLabel itemNameLabel;
    private javax.swing.JTable itemTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelSomething;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox locationComboBox;
    private javax.swing.JComboBox paymentComboBox;
    private javax.swing.JButton removeItemButton;
    private javax.swing.JTextField returnNumberTextField;
    private javax.swing.JLabel supplierLabel;
    private javax.swing.JLabel supplierNumberLabel;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JLabel totalValueLabel;
    private javax.swing.JLabel transactionNumberTextField;
    // End of variables declaration//GEN-END:variables
}
