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
import pos_project.classes.Client;
import pos_project.classes.ErrorMessages;
import pos_project.classes.Formats;
import pos_project.classes.Invoice;
import pos_project.classes.Item;
import pos_project.classes.Location;
import pos_project.classes.Transaction;
import pos_project.classes.User;

/**
 *
 * @author Cif3r
 */
public class EditInvoiceDetailsUi extends javax.swing.JDialog {
 private boolean outFlg = false;
    private String itemNumber;
    ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
//    ArrayList<Integer> deleteList = new ArrayList<Integer>();
    ArrayList<Transaction> deleteList = new ArrayList<Transaction>();
    Item item;
    Client client;
    Invoice invoice;
    Client salesperson;
    
    /** Creates new form AddClient */
    public EditInvoiceDetailsUi(java.awt.Frame parent, boolean modal, boolean isOut, String invoiceNumber) {
        super(parent, modal);
        
        initComponents();
        deleteList.clear();
        transactionList.clear();
        invoice = Invoice.getInvoiceWithId(invoiceNumber);
        locationComboBox.setModel(LocationAction.getLocationModel());
        locationComboBox.setSelectedItem(Client.getClient(invoice.getInvoiceLocationId()+""));
        switch(invoice.getInvoiceTypeFlag()){
            case 1: outFlg = false;
                break;
            default: outFlg = true;
        }
        
       driverTextField.setText(invoice.getInvoiceDriver());
        itemNameLabel.setText(InvoiceAction.getInvoiceType(invoice.getInvoiceTypeFlag()));
        paymentComboBox.setSelectedIndex(invoice.getInvoicePaymentType());
        transactionNumberTextField.setText(invoice.getInvoiceNumber());
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(invoice.getInvoiceDate());
         invoiceYearComboBox.setModel(DateActions.getYearModel());
         
         invoiceYearComboBox.setSelectedItem(cal.get(GregorianCalendar.YEAR));
//            invoiceYearComboBox.setSelectedItem(new GregorianCalendar().get(GregorianCalendar.YEAR));
//            invoiceMonthComboBox.setSelectedIndex(new GregorianCalendar().get(GregorianCalendar.MONTH));
            invoiceDayComboBox.setModel(DateActions.fixDay(invoiceMonthComboBox.getSelectedIndex(), invoiceYearComboBox.getSelectedItem().toString()));
//            invoiceDayComboBox.setSelectedIndex(new GregorianCalendar().get(GregorianCalendar.DATE)-1);
            
        
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
        transactionList = Transaction.getTransactions(""+invoice.getInvoiceId());
        if(invoice.getInvoiceSalespersonId() != null){
            salesperson = Client.getClient(invoice.getInvoiceSalespersonId().toString());
            salesPersonNameLabel.setText(salesperson.getClientName());
        }
        
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
        transactionNumberTextField = new javax.swing.JTextField();
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
        jLabel8 = new javax.swing.JLabel();
        dueDate = new javax.swing.JLabel();
        locationComboBox = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemTable = new javax.swing.JTable();
        supplierNumberLabel = new javax.swing.JLabel();
        customerNumberLabel = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        driverTextField = new javax.swing.JTextField();
        supplierLabel1 = new javax.swing.JLabel();
        salesPersonNameLabel = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(550, 205));
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setPreferredSize(new java.awt.Dimension(700, 725));
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
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(supplierLabel, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Item List");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
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

        transactionNumberTextField.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        getContentPane().add(transactionNumberTextField, gridBagConstraints);

        customerNameLabel.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        getContentPane().add(customerNameLabel, gridBagConstraints);

        itemNameLabel.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        getContentPane().add(itemNameLabel, gridBagConstraints);

        jButton1.setText("Search");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
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
        gridBagConstraints.gridy = 5;
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
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
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
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 0, 5);
        getContentPane().add(jLabel7, gridBagConstraints);

        clientAddress.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        getContentPane().add(clientAddress, gridBagConstraints);

        jLabel8.setText("DueDate");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        getContentPane().add(jLabel8, gridBagConstraints);

        dueDate.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        getContentPane().add(dueDate, gridBagConstraints);

        locationComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cash", "7 Days", "15 Days", "30 Days", "45 Days", "60 Days", "90 Days", "120 Days", "150 Days", "180 Days" }));
        locationComboBox.setEnabled(false);
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
        getContentPane().add(jScrollPane1, gridBagConstraints);

        supplierNumberLabel.setText("Customer Number");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(supplierNumberLabel, gridBagConstraints);

        customerNumberLabel.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        getContentPane().add(customerNumberLabel, gridBagConstraints);

        jLabel10.setText("Driver");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        getContentPane().add(jLabel10, gridBagConstraints);

        driverTextField.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        getContentPane().add(driverTextField, gridBagConstraints);

        supplierLabel1.setText("Sales Person");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(supplierLabel1, gridBagConstraints);

        salesPersonNameLabel.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        getContentPane().add(salesPersonNameLabel, gridBagConstraints);

        jButton3.setText("Search");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        getContentPane().add(jButton3, gridBagConstraints);

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
                        deleteList = transactionList;
                        transactionList.clear();
                        initializeTable();
                    }
                    client = detailsPopUp.getClient();
                customerNameLabel.setText(client.getClientName());
                }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void addItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemButtonActionPerformed
        // TODO add your handling code here:
        InItemUi detailsPopUp;
        if(outFlg){
            if(transactionList.size() < 8){
                Client loc = (Client) locationComboBox.getSelectedItem();
                detailsPopUp = new InItemUi(new JFrame(),true,outFlg, loc, transactionList, deleteList);
                detailsPopUp.setLocationRelativeTo(null);
                detailsPopUp.pack();
                detailsPopUp.setVisible(true);
                if(detailsPopUp.getTransaction() != null){
                    transactionList.add( detailsPopUp.getTransaction());
                    initializeTable();
                }
            } else {
                JOptionPane.showMessageDialog(this, ErrorMessages.WARNING_ITEM_LIMIT,ErrorMessages.TITLE_WARNING,JOptionPane.WARNING_MESSAGE);
            }
            
        } else {
           if(!checkClient()){
               Client loc = (Client) locationComboBox.getSelectedItem();
               detailsPopUp = new InItemUi(new JFrame(),true,outFlg,client.getClientId(),loc, transactionList, deleteList);
                detailsPopUp.setLocationRelativeTo(null);
                detailsPopUp.pack();
                detailsPopUp.setVisible(true);
                if(detailsPopUp.getTransaction()!= null){
                    transactionList.add( detailsPopUp.getTransaction());
                    initializeTable();
                }
           }
        }
//                = new InItemUi(new JFrame(),true,false);
//                detailsPopUp.setLocationRelativeTo(null);
//                detailsPopUp.pack();
//                detailsPopUp.setVisible(true);
//                transactionList.add( detailsPopUp.getTransaction());

    }//GEN-LAST:event_addItemButtonActionPerformed

    private void removeItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeItemButtonActionPerformed
        // TODO add your handling code here:
        if(-1<itemTable.getSelectedRow()){
//            transactionList.get(itemTable.getSelectedRow()).setTransactionDelFlag(Short.parseShort("1"));
//            deleteList.add(transactionList.get(itemTable.getSelectedRow()).getTransactionId());
            Transaction t = transactionList.get(itemTable.getSelectedRow());
            if(t.getTransactionId()!= null){
                deleteList.add(transactionList.get(itemTable.getSelectedRow()));   
            }
            
            transactionList.remove(itemTable.getSelectedRow());
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
//        boolean receivableFlg =false;
        if(!checkItem()){
            if(InvoiceAction.checkTotalBalance(client.getClientId(), totalValueLabel.getText()) >= 0.0){
               editInvoice();
               this.dispose();
            } else {
               int confirm = JOptionPane.showConfirmDialog(this, ErrorMessages.WARNING_CREDIT_LIMIT+Formats.centavoDecimal.format(client.getClientCreditLimit())+ErrorMessages.WARNING_CREDIT_LIMIT_MESSAGE, ErrorMessages.TITLE_WARNING, JOptionPane.YES_NO_CANCEL_OPTION);
               if( confirm == JOptionPane.YES_OPTION){
                LoginUi detailsPopUp = new LoginUi(new JFrame(), true);
                detailsPopUp.setLocationRelativeTo(null);
                detailsPopUp.pack();
                detailsPopUp.setVisible(true);
                if(detailsPopUp.getUser()!= null){
                    User u = detailsPopUp.getUser();
//                    lblWelcomeUser1.setText("Welcome ["+u.getUserUsername() +"].");
//                    checkRights(u.getUserType());
                    if(detailsPopUp.getVerification()){
                        editInvoice();
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(this,ErrorMessages.ERROR_AUTHORIZATION ,ErrorMessages.TITLE_ERROR,JOptionPane.ERROR_MESSAGE);
                    }
    
               } else if (confirm == JOptionPane.NO_OPTION){
                 this.dispose();
               } 
               
            } 
        }
//        this.dispose();
        
        
        //        if(outFlg){
        //
        //            InvoiceAction.insertOutInvoice(client.getClientId(), totalValueLabel.getText(), transactionNumberTextField.getText(), receivableFlg, paymentComboBox.getSelectedIndex());
        //            int invoiceId = Invoice.getLatestInvoice();
        //            for(Transaction t: transactionList){
        //                Item i = Item.getItem(t.getTransactionItemNumber().toString());
        //                t.setTransactionInvoiceId(invoiceId);
        //                t.setTransactionQuantityAsOf(i.getItemCurrentQuantity()-t.getTransactionQuantity());
        //                Transaction.addInTransaction(t);
        //                Item.updateItemQuantity(t.getTransactionItemNumber(), t.getTransactionQuantityAsOf(), Formats.dateFormatDays.format(t.getTransactionDate()));
        //            }
        //
        //            this.dispose();
        //
        //        } else {
        //            InvoiceAction.insertInInvoice(client.getClientId(), totalValueLabel.getText(), transactionNumberTextField.getText(), receivableFlg, paymentComboBox.getSelectedIndex());
        //            int invoiceId = Invoice.getLatestInvoice();
        //            for(Transaction t: transactionList){
        //                Item i = Item.getItem(t.getTransactionItemNumber().toString());
        //                t.setTransactionInvoiceId(invoiceId);
        //                t.setTransactionQuantityAsOf(i.getItemCurrentQuantity()+t.getTransactionQuantity());
        //                Transaction.addInTransaction(t);
        //                Item.updateItemQuantity(t.getTransactionItemNumber(), t.getTransactionQuantityAsOf(), Formats.dateFormatDays.format(t.getTransactionDate()));
        //            }
        //            this.dispose();
        //        }
        //        }
        
        //        if(!checkItem()){
        //           if(outFlg){
        //                int result = InvoiceAction.insertOutInvoice(item.getItemId(), client.getClientId(), transactionQuantityTextField1.getText(),transactionPriceTextField.getText(),transactionNumberTextField.getText());
        //                if(!(result < 0) ){
        //                    success();
        //                }
        //           } else {
        //                int result = InvoiceAction.insertInInvoice(item.getItemId(),transactionQuantityTextField1.getText(),transactionPriceTextField.getText(),transactionNumberTextField.getText());
        //                if(!(result < 0) ){
        //                    success();
        //                }
        //           }
        
        
                }
}//GEN-LAST:event_AddInvoiceOkButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
         int confirm = JOptionPane.showConfirmDialog(this, ErrorMessages.CONFIRM_DELETE_INVOICE, ErrorMessages.TITLE_DELETE, JOptionPane.YES_NO_OPTION);
            if(confirm == JOptionPane.YES_OPTION){
                
                Client loc = (Client) locationComboBox.getSelectedItem();
                      InvoiceAction.voidSQLLogic(invoice.getInvoiceId(),transactionList,outFlg, loc.getClientId());
                      this.dispose();
            }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        SearchUi detailsPopUp;

        detailsPopUp = new SearchUi(new JFrame(),true, 9,outFlg);

        detailsPopUp.setLocationRelativeTo(null);
        detailsPopUp.pack();
        detailsPopUp.setVisible(true);
        if(detailsPopUp.getClient() != null){
//            if(client != null && client.getClientId() != detailsPopUp.getClient().getClientId()){
//                transactionList.clear();
//                initializeTable();
//            }
            salesperson = detailsPopUp.getClient();
            salesPersonNameLabel.setText(salesperson.getClientName());
            //                clientAddress.setText(client.getClientAddress());
            //                clientAddressTextArea.setText(client.getClientAddress());
            //                customerNumberValueLabel.setText(client.getClientNumber());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//
//            public void run() {
//                AddClient dialog = new AddClient(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }
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
        for(Transaction emp: transactionList){
            String fraquant = FractionAction.convertToFraction(emp.getTransactionQuantity());
           mod.addRow(new String[] {emp.getItemName()+"",fraquant+"",Formats.centavoDecimal.format(emp.getTransactionPrice())+"", Formats.centavoDecimal.format(emp.getTransactionSubTotal())});
            totalAmount += emp.getTransactionSubTotal();
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
        if(transactionList.isEmpty()){
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
     
     private void editInvoice(){
         boolean receivableFlg = false;
            if (paymentComboBox.getSelectedIndex()>0){
                receivableFlg =true;
            }
            int year = Integer.parseInt(invoiceYearComboBox.getSelectedItem().toString());
            int month = invoiceMonthComboBox.getSelectedIndex();
            int day = invoiceDayComboBox.getSelectedIndex()+1;
            Client loc = (Client) locationComboBox.getSelectedItem();
            Integer salesId = null;
                    if(salesperson != null && salesperson.getClientId() != null){
                        salesId = salesperson.getClientId();
                    }
//            InvoiceAction.invoiceEditSQLLogic(invoice.getInvoiceId(),client.getClientId(),totalValueLabel.getText(), transactionNumberTextField.getText(), receivableFlg, paymentComboBox.getSelectedIndex(), transactionList,year, month, day, outFlg, deleteList);
            InvoiceAction.invoiceEditSQLLogic(invoice.getInvoiceId(),client.getClientId(),totalValueLabel.getText(), transactionNumberTextField.getText(), receivableFlg, paymentComboBox.getSelectedIndex(), transactionList,year, month, day, outFlg, deleteList, loc.getClientId(), driverTextField.getText(), salesId);
     }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddClientCancelButton;
    private javax.swing.JButton AddInvoiceOkButton;
    private javax.swing.JButton addItemButton;
    private javax.swing.JLabel clientAddress;
    private javax.swing.JLabel customerNameLabel;
    private javax.swing.JLabel customerNumberLabel;
    private javax.swing.JTextField driverTextField;
    private javax.swing.JLabel dueDate;
    private javax.swing.JComboBox invoiceDayComboBox;
    private javax.swing.JComboBox invoiceMonthComboBox;
    private javax.swing.JComboBox invoiceYearComboBox;
    private javax.swing.JLabel itemNameLabel;
    private javax.swing.JTable itemTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox locationComboBox;
    private javax.swing.JComboBox paymentComboBox;
    private javax.swing.JButton removeItemButton;
    private javax.swing.JLabel salesPersonNameLabel;
    private javax.swing.JLabel supplierLabel;
    private javax.swing.JLabel supplierLabel1;
    private javax.swing.JLabel supplierNumberLabel;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JLabel totalValueLabel;
    private javax.swing.JTextField transactionNumberTextField;
    // End of variables declaration//GEN-END:variables
}
