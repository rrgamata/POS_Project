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
import pos_project.classes.Transfer;

/**
 *
 * @author Cif3r
 */
public class TransferUi extends javax.swing.JDialog {
 private boolean outFlg = false;
 private boolean editFlg = false;
    private String itemNumber;
    ArrayList<Transaction> transactionList;
    ArrayList<Transaction> deleteList = new ArrayList<Transaction>();
    Item item;
    Client client;
    Invoice fromInvoice;
    Invoice toInvoice;
    Transfer transfer;
    
    /** Creates new form AddClient */
    public TransferUi(java.awt.Frame parent, boolean modal, boolean isOut) {
        super(parent, modal);
        initComponents();
        locationComboBox.setModel(LocationAction.getLocationModel());
        paymentComboBox.setModel(LocationAction.getLocationModel());
        transactionList = new ArrayList<Transaction>();
        outFlg = isOut;
        this.setTitle("New Invoice Details");
        if(isOut){
            supplierLabel.setText("Customer Name");
        } else {
            supplierLabel.setText("Supplier Name");
            
        }
        itemNameLabel.setVisible(false);
            customerNameLabel.setEnabled(true);
            supplierLabel.setEnabled(true);
            jButton1.setEnabled(true);
            invoiceYearComboBox.setModel(DateActions.getYearModel());
            invoiceYearComboBox.setSelectedItem(new GregorianCalendar().get(GregorianCalendar.YEAR));
            invoiceMonthComboBox.setSelectedIndex(new GregorianCalendar().get(GregorianCalendar.MONTH));
            invoiceDayComboBox.setModel(DateActions.fixDay(invoiceMonthComboBox.getSelectedIndex(), invoiceYearComboBox.getSelectedItem().toString()));
            invoiceDayComboBox.setSelectedIndex(new GregorianCalendar().get(GregorianCalendar.DATE)-1);
            supplierLabel.setVisible(false);
            jLabel7.setVisible(false);
            customerNameLabel.setVisible(false);
            clientAddress.setVisible(false);
            jButton1.setVisible(false);
            searchTransfer.setVisible(false);
            voidTransfer.setVisible(false);
            initializeTable();
            
//        } else {
//            customerNameLabel.setVisible(false);
//            supplierLabel.setVisible(false);
//            jButton1.setVisible(false);
//        }
        
                
    }
    
    
    public TransferUi(java.awt.Frame parent, boolean modal, boolean isOut, int transferNumber) {
        super(parent, modal);
        initComponents();
        locationComboBox.setModel(LocationAction.getLocationModel());
        paymentComboBox.setModel(LocationAction.getLocationModel());
        transactionList = new ArrayList<Transaction>();
        outFlg = isOut;
        this.setTitle("New Invoice Details");
        if(isOut){
            supplierLabel.setText("Customer Name");
        } else {
            supplierLabel.setText("Supplier Name");
            
        }
        itemNameLabel.setVisible(false);
            customerNameLabel.setEnabled(true);
            supplierLabel.setEnabled(true);
            jButton1.setEnabled(true);
            invoiceYearComboBox.setModel(DateActions.getYearModel());
            invoiceYearComboBox.setSelectedItem(new GregorianCalendar().get(GregorianCalendar.YEAR));
            invoiceMonthComboBox.setSelectedIndex(new GregorianCalendar().get(GregorianCalendar.MONTH));
            invoiceDayComboBox.setModel(DateActions.fixDay(invoiceMonthComboBox.getSelectedIndex(), invoiceYearComboBox.getSelectedItem().toString()));
            invoiceDayComboBox.setSelectedIndex(new GregorianCalendar().get(GregorianCalendar.DATE)-1);
            
            initializeTable();
//        } else {
//            customerNameLabel.setVisible(false);
//            supplierLabel.setVisible(false);
//            jButton1.setVisible(false);
//        }
        
                
    }
    
    public TransferUi(java.awt.Frame parent, boolean modal, boolean isOut, boolean isEdit) {
        super(parent, modal);
        initComponents();
        locationComboBox.setModel(LocationAction.getLocationModel());
        paymentComboBox.setModel(LocationAction.getLocationModel());
        locationComboBox.setEnabled(false);
        paymentComboBox.setEnabled(false);
        transactionList = new ArrayList<Transaction>();
        outFlg = isOut;
        this.setTitle("New Invoice Details");
        if(isOut){
            supplierLabel.setText("Customer Name");
        } else {
            supplierLabel.setText("Supplier Name");
            
        }
        itemNameLabel.setVisible(false);
            customerNameLabel.setEnabled(true);
            supplierLabel.setEnabled(true);
            jButton1.setEnabled(true);
            invoiceYearComboBox.setModel(DateActions.getYearModel());
            invoiceYearComboBox.setSelectedItem(new GregorianCalendar().get(GregorianCalendar.YEAR));
            invoiceMonthComboBox.setSelectedIndex(new GregorianCalendar().get(GregorianCalendar.MONTH));
            invoiceDayComboBox.setModel(DateActions.fixDay(invoiceMonthComboBox.getSelectedIndex(), invoiceYearComboBox.getSelectedItem().toString()));
            invoiceDayComboBox.setSelectedIndex(new GregorianCalendar().get(GregorianCalendar.DATE)-1);
            supplierLabel.setVisible(false);
            jLabel7.setVisible(false);
            customerNameLabel.setVisible(false);
            clientAddress.setVisible(false);
            jButton1.setVisible(false);
            editFlg = isEdit;
            voidTransfer.setVisible(true);
            voidTransfer.setEnabled(false);
            AddInvoiceOkButton.setEnabled(false);
            initializeTable();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        itemTable = new javax.swing.JTable();
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
        jLabel7 = new javax.swing.JLabel();
        clientAddress = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        locationComboBox = new javax.swing.JComboBox();
        searchTransfer = new javax.swing.JButton();
        voidTransfer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(550, 205));
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Transfer Details");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 0, 0);
        getContentPane().add(jLabel1, gridBagConstraints);

        supplierLabel.setText("Customer");
        supplierLabel.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(supplierLabel, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Item List");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
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
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 10);
        getContentPane().add(jPanel1, gridBagConstraints);

        jLabel5.setText("Transfer #");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        getContentPane().add(jLabel5, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        getContentPane().add(transactionNumberTextField, gridBagConstraints);

        customerNameLabel.setText("-");
        customerNameLabel.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        getContentPane().add(customerNameLabel, gridBagConstraints);

        itemNameLabel.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
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
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        getContentPane().add(jButton1, gridBagConstraints);

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
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(jScrollPane1, gridBagConstraints);

        totalLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        totalLabel.setText("Total:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        getContentPane().add(totalLabel, gridBagConstraints);

        totalValueLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        totalValueLabel.setText("0.00");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 11;
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
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        getContentPane().add(jPanel2, gridBagConstraints);

        paymentComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "OTC", "COD", "7 Days", "15 Days", "30 Days", "45 Days", "60 Days", "90 Days", "120 Days", "150 Days", "180 Days" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        getContentPane().add(paymentComboBox, gridBagConstraints);

        jLabel2.setText("To:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
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
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(jPanel5, gridBagConstraints);

        jLabel4.setText("Invoice Date");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        getContentPane().add(jLabel4, gridBagConstraints);

        jLabel7.setText("Address");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 0, 5);
        getContentPane().add(jLabel7, gridBagConstraints);

        clientAddress.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        getContentPane().add(clientAddress, gridBagConstraints);

        jLabel6.setText("From:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        getContentPane().add(jLabel6, gridBagConstraints);

        locationComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cash", "7 Days", "15 Days", "30 Days", "45 Days", "60 Days", "90 Days", "120 Days", "150 Days", "180 Days" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        getContentPane().add(locationComboBox, gridBagConstraints);

        searchTransfer.setText("Search");
        searchTransfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTransferActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        getContentPane().add(searchTransfer, gridBagConstraints);

        voidTransfer.setText("Void");
        voidTransfer.setEnabled(false);
        voidTransfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voidTransferActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        getContentPane().add(voidTransfer, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddInvoiceOkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddInvoiceOkButtonActionPerformed
        boolean receivableFlg =false;
        if(!checkItem()){
//            if (paymentComboBox.getSelectedIndex()>0){
//            receivableFlg =true;
//        }  
            if(!editFlg){
                addFunction();
            } else {
                editFunction();
            }
          
//            this.dispose();
        }
        
        
        
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
               
            
//        }
}//GEN-LAST:event_AddInvoiceOkButtonActionPerformed

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
                        transactionList.clear();
                        initializeTable();
                    }
                    client = detailsPopUp.getClient();
                customerNameLabel.setText(client.getClientName());
                clientAddress.setText(client.getClientAddress());
                }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void addItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemButtonActionPerformed
        // TODO add your handling code here:
        InItemUi detailsPopUp;
        if(outFlg){
//            detailsPopUp = new InItemUi(new JFrame(),true,outFlg);
            Client loc = (Client) locationComboBox.getSelectedItem();
            detailsPopUp = new InItemUi(new JFrame(),true,outFlg,(Client) locationComboBox.getSelectedItem(), true, transactionList, deleteList);
                detailsPopUp.setLocationRelativeTo(null);
                detailsPopUp.pack();
                detailsPopUp.setVisible(true);
                if(detailsPopUp.getTransaction() != null){
                  transactionList.add( detailsPopUp.getTransaction());  
                }
                initializeTable();
        } else {
           if(!checkClient()){
               detailsPopUp = new InItemUi(new JFrame(),true,outFlg,client.getClientId(),(Client) locationComboBox.getSelectedItem(), transactionList, deleteList);
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
            if(!editFlg){
                transactionList.remove(itemTable.getSelectedRow());
                initializeTable();    
            } else{
                deleteList.add(transactionList.get(itemTable.getSelectedRow()));
                transactionList.remove(itemTable.getSelectedRow());
                initializeTable();
            } 
        }else {
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

    private void searchTransferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTransferActionPerformed
        // TODO add your handling code here:
          SearchUi detailsPopUp;
//        if(outFlg){
//            detailsPopUp = new SearchUi(new JFrame(),true, 1,outFlg);
//        } else {
//            detailsPopUp = new SearchUi(new JFrame(),true, 2,outFlg);
//        }
                detailsPopUp = new SearchUi(new JFrame(),true, 5,outFlg);
                detailsPopUp.setLocationRelativeTo(null);
                detailsPopUp.pack();
                detailsPopUp.setVisible(true);
                if(detailsPopUp.getTransfer() != null){
                    transfer = detailsPopUp.getTransfer();
                    fillData();
                }
    }//GEN-LAST:event_searchTransferActionPerformed

    private void voidTransferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voidTransferActionPerformed
        // TODO add your handling code here:
          int confirm = JOptionPane.showConfirmDialog(this, ErrorMessages.CONFIRM_DELETE_INVOICE, ErrorMessages.TITLE_DELETE, JOptionPane.YES_NO_OPTION);
            if(confirm == JOptionPane.YES_OPTION){
                Client fromLoc = (Client) locationComboBox.getSelectedItem();
                Client toLoc = (Client) paymentComboBox.getSelectedItem();
                      //FROM
                      InvoiceAction.voidSQLLogic(fromInvoice.getInvoiceId(),transactionList,true, fromLoc.getClientId());
                      
                      //TO
                      InvoiceAction.voidSQLLogic(toInvoice.getInvoiceId(),transactionList,false, toLoc.getClientId());
                      Transfer.deleteTransfer(transfer.getTransferId().toString());
                      this.dispose();
            }
        
    }//GEN-LAST:event_voidTransferActionPerformed

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
       
//        mod.setColumnIdentifiers(new String[] {"Item Name","Item Supplier", "Quantity", "Amount per","Sub Total"});
        mod.setColumnIdentifiers(new String[] {"Item Name", "Quantity", "Amount per","Sub Total"});
        Double totalAmount = 0.00;
//        if(!transactionList.isEmpty()){
//        for(Transaction emp: transactionList){
//           mod.addRow(new String[] {emp.getItemName()+"",emp.getSupplierName()+"",emp.getTransactionQuantity().toString()+"",Formats.centavoDecimal.format(emp.getTransactionPrice())+"", Formats.centavoDecimal.format(emp.getTransactionSubTotal())});
//            totalAmount += emp.getTransactionSubTotal();
//        }
        for(Transaction emp: transactionList){
            String fraquant = FractionAction.convertToFraction(emp.getTransactionQuantity());
           mod.addRow(new String[] {emp.getItemName()+"",fraquant+"",Formats.centavoDecimal.format(emp.getTransactionPrice())+"", Formats.centavoDecimal.format(emp.getTransactionSubTotal())});
            totalAmount += emp.getTransactionSubTotal();
        }
        
//        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(mod);
        itemTable.setModel(mod);
//        itemTable.setRowSorter(sorter);
        itemTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        itemTable.setShowGrid(true);
        itemTable.setGridColor(Color.black);
//        itemTable.getColumnModel().removeColumn(itemTable.getColumnModel().getColumn(3));
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
//         if(customerNameLabel.isEnabled()){
//         if(customerNameLabel.getText().equals("-")){
//            errorFlg = true;
//            errMsg += "* "+ErrorMessages.ERROR_TRANSACTION_CUSTOMER;
//        }  
////        checkClient();
//         }
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
             transactionList.clear();
             initializeTable();
//             transactionQuantityTextField1.setText("");
//             transactionPriceTextField.setText("");
          }else{
             this.dispose();
         }
     }
     
     private void fillData(){
         voidTransfer.setEnabled(true);
         AddInvoiceOkButton.setEnabled(true);
        fromInvoice = Invoice.getInvoiceWithId(transfer.getTransferFromInvoiceId().toString());
        toInvoice = Invoice.getInvoiceWithId(transfer.getTransferToInvoiceId().toString());
        locationComboBox.setSelectedItem(Client.getClient(transfer.getFromLocationId()+""));
        paymentComboBox.setSelectedItem(Client.getClient(transfer.getTransferToInvoiceId()+""));
//        switch(invoice.getInvoiceTypeFlag()){
//            case 1: outFlg = false;
//                break;
//            default: outFlg = true;
//        }
//        itemNameLabel.setText(InvoiceAction.getInvoiceType(invoice.getInvoiceTypeFlag()));
//        paymentComboBox.setSelectedIndex(invoice.getInvoicePaymentType());
        transactionNumberTextField.setText(transfer.getTransferNumber());
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(fromInvoice.getInvoiceDate());
        invoiceYearComboBox.setSelectedItem(""+cal.get(GregorianCalendar.YEAR));
        invoiceMonthComboBox.setSelectedIndex(cal.get(GregorianCalendar.MONTH));
        invoiceDayComboBox.setSelectedIndex(cal.get(GregorianCalendar.DATE)-1);
//        customerNameLabel.setText(invoice.getClientName());
//          clientAddress.setText(invoice.getClientAddress());
//        if(invoice.getInvoicePaymentType() != 0){
//            dueDate.setText(Formats.dateFormatDays2.format(invoice.getInvoiceDueDate()));
//        }
//        client = Client.getClient(Integer.toString(invoice.getClientId()));
        transactionList = Transaction.getTransactions(""+fromInvoice.getInvoiceId());
        initializeTable();
     }
     
     
     private void addFunction(){
           int success;
            int year = Integer.parseInt(invoiceYearComboBox.getSelectedItem().toString());
            int month = invoiceMonthComboBox.getSelectedIndex();
            int day = invoiceDayComboBox.getSelectedIndex()+1;
            Client fromLoc = (Client) locationComboBox.getSelectedItem();
            Client toLoc = (Client) paymentComboBox.getSelectedItem();
            int fromLocationId = fromLoc.getClientId();
            int toLocationId = toLoc.getClientId();
            //OUT so FROM
            success = InvoiceAction.transferSQLLogic(toLoc.getClientId(),totalValueLabel.getText(), transactionNumberTextField.getText()+"-A", false, 69, transactionList,year, month, day, true, fromLocationId);
            //ININ so TO
            success = InvoiceAction.transferSQLLogic(fromLoc.getClientId(),totalValueLabel.getText(), transactionNumberTextField.getText()+"-B", false, 69, transactionList,year, month, day, false, toLocationId);
            Invoice fromInvoice = Invoice.getInvoiceWithName(transactionNumberTextField.getText()+"-A");
            Invoice toInvoice = Invoice.getInvoiceWithName(transactionNumberTextField.getText()+"-B");
            GregorianCalendar cal = new GregorianCalendar();
            cal.set(GregorianCalendar.YEAR, year);
            cal.set(GregorianCalendar.MONTH, month);
            cal.set(GregorianCalendar.DATE, day);
            success = Transfer.insertTransfer(transactionNumberTextField.getText(), fromInvoice.getInvoiceId().toString(), toInvoice.getInvoiceId().toString(), Formats.dateFormatDays.format(cal.getTime()));
            
            if(success < 0 ){
                this.dispose();
            } else {
                success();
            }
     }
     
     private void editFunction(){
          
            int year = Integer.parseInt(invoiceYearComboBox.getSelectedItem().toString());
            int month = invoiceMonthComboBox.getSelectedIndex();
            int day = invoiceDayComboBox.getSelectedIndex()+1;
            Client fromLoc = (Client) locationComboBox.getSelectedItem();
            Client toLoc = (Client) paymentComboBox.getSelectedItem();
            int fromLocationId = fromLoc.getClientId();
            int toLocationId = toLoc.getClientId();
            
            //OUT so FROM
            InvoiceAction.invoiceEditSQLLogic(fromInvoice.getInvoiceId(),toLocationId,totalValueLabel.getText(), transactionNumberTextField.getText()+"-A", false, 69, transactionList,year, month, day, true, deleteList, fromLocationId, "-", null);
            
            //ININ so TO
            InvoiceAction.invoiceEditSQLLogic(toInvoice.getInvoiceId(),fromLocationId,totalValueLabel.getText(), transactionNumberTextField.getText()+"-B", false, 69, transactionList,year, month, day, false, deleteList, toLocationId, "-", null);
              GregorianCalendar cal = new GregorianCalendar();
            cal.set(GregorianCalendar.YEAR, year);
            cal.set(GregorianCalendar.MONTH, month);
            cal.set(GregorianCalendar.DATE, day);
            Transfer.updateTransfer(transactionNumberTextField.getText(), Formats.dateFormatDays.format(cal.getTime()), transfer.getTransferId());
            this.dispose();
     }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddClientCancelButton;
    private javax.swing.JButton AddInvoiceOkButton;
    private javax.swing.JButton addItemButton;
    private javax.swing.JLabel clientAddress;
    private javax.swing.JLabel customerNameLabel;
    private javax.swing.JComboBox invoiceDayComboBox;
    private javax.swing.JComboBox invoiceMonthComboBox;
    private javax.swing.JComboBox invoiceYearComboBox;
    private javax.swing.JLabel itemNameLabel;
    private javax.swing.JTable itemTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox locationComboBox;
    private javax.swing.JComboBox paymentComboBox;
    private javax.swing.JButton removeItemButton;
    private javax.swing.JButton searchTransfer;
    private javax.swing.JLabel supplierLabel;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JLabel totalValueLabel;
    private javax.swing.JTextField transactionNumberTextField;
    private javax.swing.JButton voidTransfer;
    // End of variables declaration//GEN-END:variables
}
