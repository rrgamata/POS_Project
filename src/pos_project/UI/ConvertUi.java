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

import java.util.ArrayList;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import pos_project.Action.InvoiceAction;
import pos_project.Action.DateActions;
import pos_project.Action.FractionAction;
import pos_project.Action.LocationAction;
import pos_project.classes.Client;
import pos_project.classes.Convert;
import pos_project.classes.ErrorMessages;
import pos_project.classes.Formats;
import pos_project.classes.Invoice;
import pos_project.classes.Item;
import pos_project.classes.Transaction;
import pos_project.classes.Transfer;

/**
 *
 * @author Cif3r
 */
public class ConvertUi extends javax.swing.JDialog {
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
    public ConvertUi(java.awt.Frame parent, boolean modal, boolean isOut) {
        super(parent, modal);
        initComponents();
        locationComboBox.setModel(LocationAction.getLocationModel());
        transactionList = new ArrayList<Transaction>();
        outFlg = isOut;
        this.setTitle("Convert Details");
            invoiceYearComboBox.setModel(DateActions.getYearModel());
            invoiceYearComboBox.setSelectedItem(new GregorianCalendar().get(GregorianCalendar.YEAR));
            invoiceMonthComboBox.setSelectedIndex(new GregorianCalendar().get(GregorianCalendar.MONTH));
            invoiceDayComboBox.setModel(DateActions.fixDay(invoiceMonthComboBox.getSelectedIndex(), invoiceYearComboBox.getSelectedItem().toString()));
            invoiceDayComboBox.setSelectedIndex(new GregorianCalendar().get(GregorianCalendar.DATE)-1);
        
        
                
    }
    
    
    public ConvertUi(java.awt.Frame parent, boolean modal, boolean isOut, int transferNumber) {
        super(parent, modal);
        initComponents();
        locationComboBox.setModel(LocationAction.getLocationModel());
//        paymentComboBox.setModel(LocationAction.getLocationModel());
        transactionList = new ArrayList<Transaction>();
        outFlg = isOut;
        this.setTitle("New Invoice Details");
//        if(isOut){
//            supplierLabel.setText("Customer Name");
//        } else {
//            supplierLabel.setText("Supplier Name");
//            
//        }
        itemNameLabelTo.setVisible(true);
//            customerNameLabel.setEnabled(true);
//            supplierLabel.setEnabled(true);
//            jButton1.setEnabled(true);
            invoiceYearComboBox.setModel(DateActions.getYearModel());
            invoiceYearComboBox.setSelectedItem(new GregorianCalendar().get(GregorianCalendar.YEAR));
            invoiceMonthComboBox.setSelectedIndex(new GregorianCalendar().get(GregorianCalendar.MONTH));
            invoiceDayComboBox.setModel(DateActions.fixDay(invoiceMonthComboBox.getSelectedIndex(), invoiceYearComboBox.getSelectedItem().toString()));
            invoiceDayComboBox.setSelectedIndex(new GregorianCalendar().get(GregorianCalendar.DATE)-1);
//            
//            initializeTable();
//        } else {
//            customerNameLabel.setVisible(false);
//            supplierLabel.setVisible(false);
//            jButton1.setVisible(false);
//        }
        
                
    }
    
    public ConvertUi(java.awt.Frame parent, boolean modal, boolean isOut, boolean isEdit) {
        super(parent, modal);
        initComponents();
        locationComboBox.setModel(LocationAction.getLocationModel());
//        paymentComboBox.setModel(LocationAction.getLocationModel());
        locationComboBox.setEnabled(false);
//        paymentComboBox.setEnabled(false);
        transactionList = new ArrayList<Transaction>();
        outFlg = isOut;
        this.setTitle("New Invoice Details");
//        if(isOut){
//            supplierLabel.setText("Customer Name");
//        } else {
//            supplierLabel.setText("Supplier Name");
//            
//        }
        itemNameLabelTo.setVisible(false);
//            customerNameLabel.setEnabled(true);
//            supplierLabel.setEnabled(true);
//            jButton1.setEnabled(true);
            invoiceYearComboBox.setModel(DateActions.getYearModel());
            invoiceYearComboBox.setSelectedItem(new GregorianCalendar().get(GregorianCalendar.YEAR));
            invoiceMonthComboBox.setSelectedIndex(new GregorianCalendar().get(GregorianCalendar.MONTH));
            invoiceDayComboBox.setModel(DateActions.fixDay(invoiceMonthComboBox.getSelectedIndex(), invoiceYearComboBox.getSelectedItem().toString()));
            invoiceDayComboBox.setSelectedIndex(new GregorianCalendar().get(GregorianCalendar.DATE)-1);
//            supplierLabel.setVisible(false);
            jLabel7.setVisible(false);
//            customerNameLabel.setVisible(false);
//            clientAddress.setVisible(false);
//            jButton1.setVisible(false);
            editFlg = isEdit;
//            voidTransfer.setVisible(true);
//            voidTransfer.setEnabled(false);
            AddInvoiceOkButton.setEnabled(false);
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
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        AddInvoiceOkButton = new javax.swing.JButton();
        AddClientCancelButton = new javax.swing.JButton();
        itemNameLabelTo = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        invoiceMonthComboBox = new javax.swing.JComboBox();
        invoiceDayComboBox = new javax.swing.JComboBox();
        invoiceYearComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        locationComboBox = new javax.swing.JComboBox();
        quantityLabelFrom = new javax.swing.JLabel();
        addItemButton1 = new javax.swing.JButton();
        addItemButton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        itemNameLabelFrom = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        quantityLabelTo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(550, 205));
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Convert Details");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 0, 0);
        getContentPane().add(jLabel1, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("To");
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
        gridBagConstraints.gridy = 17;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 10);
        getContentPane().add(jPanel1, gridBagConstraints);

        itemNameLabelTo.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        getContentPane().add(itemNameLabelTo, gridBagConstraints);

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
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        getContentPane().add(jPanel5, gridBagConstraints);

        jLabel4.setText("Date");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        getContentPane().add(jLabel4, gridBagConstraints);

        jLabel7.setText("Quantity");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 0, 5);
        getContentPane().add(jLabel7, gridBagConstraints);

        jLabel6.setText("Location");
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

        quantityLabelFrom.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        getContentPane().add(quantityLabelFrom, gridBagConstraints);

        addItemButton1.setText("Add Item");
        addItemButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        getContentPane().add(addItemButton1, gridBagConstraints);

        addItemButton.setText("Add Item");
        addItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        getContentPane().add(addItemButton, gridBagConstraints);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel9.setText("From");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 10);
        getContentPane().add(jLabel9, gridBagConstraints);

        itemNameLabelFrom.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        getContentPane().add(itemNameLabelFrom, gridBagConstraints);

        jLabel11.setText("Item Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 0, 5);
        getContentPane().add(jLabel11, gridBagConstraints);

        jLabel12.setText("Item Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 0, 5);
        getContentPane().add(jLabel12, gridBagConstraints);

        jLabel13.setText("Quantity");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 0, 5);
        getContentPane().add(jLabel13, gridBagConstraints);

        quantityLabelTo.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        getContentPane().add(quantityLabelTo, gridBagConstraints);

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

    private void addItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemButtonActionPerformed
        // TODO add your handling code here:
        InItemUi detailsPopUp;
        if(outFlg){
//            detailsPopUp = new InItemUi(new JFrame(),true,outFlg);
            Client loc = (Client) locationComboBox.getSelectedItem();
            detailsPopUp = new InItemUi(new JFrame(),true,false,(Client) locationComboBox.getSelectedItem(), true, transactionList, deleteList);
                detailsPopUp.setLocationRelativeTo(null);
                detailsPopUp.pack();
                detailsPopUp.setVisible(true);
                 if(detailsPopUp.getTransaction()!= null){
                    transactionList.add( detailsPopUp.getTransaction());
                    setItemToValues(detailsPopUp.getTransaction());
//                    initializeTable();
                }

        } else {
//           if(!checkClient()){
               detailsPopUp = new InItemUi(new JFrame(),true,false,client.getClientId(),(Client) locationComboBox.getSelectedItem(), transactionList, deleteList);
                detailsPopUp.setLocationRelativeTo(null);
                detailsPopUp.pack();
                detailsPopUp.setVisible(true);
                if(detailsPopUp.getTransaction()!= null){
                    transactionList.add( detailsPopUp.getTransaction());
                    setItemToValues(detailsPopUp.getTransaction());
//                    initializeTable();
                }
//           }
        }
//                = new InItemUi(new JFrame(),true,false);
//                detailsPopUp.setLocationRelativeTo(null);
//                detailsPopUp.pack();
//                detailsPopUp.setVisible(true);
//                transactionList.add( detailsPopUp.getTransaction());

    }//GEN-LAST:event_addItemButtonActionPerformed

    private void invoiceMonthComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceMonthComboBoxActionPerformed
        // TODO add your handling code here:
        invoiceDayComboBox.setModel(DateActions.fixDay(invoiceMonthComboBox.getSelectedIndex(), invoiceYearComboBox.getSelectedItem().toString()));
}//GEN-LAST:event_invoiceMonthComboBoxActionPerformed

    private void invoiceYearComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceYearComboBoxActionPerformed
        // TODO add your handling code here:
        invoiceDayComboBox.setModel(DateActions.fixDay(invoiceMonthComboBox.getSelectedIndex(), invoiceYearComboBox.getSelectedItem().toString()));
}//GEN-LAST:event_invoiceYearComboBoxActionPerformed

    private void addItemButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemButton1ActionPerformed
        // TODO add your handling code here:
        
               InItemUi detailsPopUp;
        if(outFlg){
//            detailsPopUp = new InItemUi(new JFrame(),true,outFlg);
            Client loc = (Client) locationComboBox.getSelectedItem();
            detailsPopUp = new InItemUi(new JFrame(),true,outFlg,(Client) locationComboBox.getSelectedItem(), true, transactionList, deleteList);
                detailsPopUp.setLocationRelativeTo(null);
                detailsPopUp.pack();
                detailsPopUp.setVisible(true);
                 if(detailsPopUp.getTransaction()!= null){
                    deleteList.add( detailsPopUp.getTransaction());
                    setItemFromValues(detailsPopUp.getTransaction());
//                    initializeTable();
                }

        } else {
//           if(!checkClient()){
               detailsPopUp = new InItemUi(new JFrame(),true,outFlg,client.getClientId(),(Client) locationComboBox.getSelectedItem(), transactionList, deleteList);
                detailsPopUp.setLocationRelativeTo(null);
                detailsPopUp.pack();
                detailsPopUp.setVisible(true);
                if(detailsPopUp.getTransaction()!= null){
                    deleteList.add( detailsPopUp.getTransaction());
                    setItemFromValues(detailsPopUp.getTransaction());
//                    initializeTable();
                }
//           }
        }
    }//GEN-LAST:event_addItemButton1ActionPerformed

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
 
//    }
    
//    private boolean checkClient(){
//         boolean errorFlg = false;
//        String errMsg = new String();
//        if(customerNameLabel.isEnabled()){
//         if(customerNameLabel.getText().equals("-")){
//            errorFlg = true;
//            errMsg += "* "+ErrorMessages.ERROR_TRANSACTION_CUSTOMER;
//        }  
//         if(errorFlg){
//            
//            JOptionPane.showMessageDialog(this,errMsg ,ErrorMessages.TITLE_ERROR,JOptionPane.ERROR_MESSAGE);
//        }
//        
//       
//    }
//         return errorFlg;
//        }
    
    
    private boolean checkItem(){
        boolean errorFlg = false;
        String errMsg = new String();
        
//        if(transactionNumberTextField.getText().isEmpty()||transactionNumberTextField.getText() == null){
//                errorFlg = true;
//                errMsg += "* "+ErrorMessages.ERROR_TRANSACTION_NUMBER;
//        }

        if(transactionList.isEmpty()){
            errorFlg = true;
            errMsg += "* "+ErrorMessages.ERROR_TRANSACTION_ITEM;
        } 
        
         if(deleteList.isEmpty()){
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
//             transactionNumberTextField.requestFocus();
//             transactionNumberTextField.setText("");
             transactionList.clear();
             
//             transactionQuantityTextField1.setText("");
//             transactionPriceTextField.setText("");
          }else{
             this.dispose();
         }
     }
     
     private void fillData(){
         
         AddInvoiceOkButton.setEnabled(true);
        fromInvoice = Invoice.getInvoiceWithId(transfer.getTransferFromInvoiceId().toString());
        toInvoice = Invoice.getInvoiceWithId(transfer.getTransferToInvoiceId().toString());
        locationComboBox.setSelectedItem(Client.getClient(transfer.getFromLocationId()+""));
        
//        switch(invoice.getInvoiceTypeFlag()){
//            case 1: outFlg = false;
//                break;
//            default: outFlg = true;
//        }
//        itemNameLabel.setText(InvoiceAction.getInvoiceType(invoice.getInvoiceTypeFlag()));
//        paymentComboBox.setSelectedIndex(invoice.getInvoicePaymentType());
//        transactionNumberTextField.setText(transfer.getTransferNumber());
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(fromInvoice.getInvoiceDate());
        invoiceYearComboBox.setSelectedItem(""+cal.get(GregorianCalendar.YEAR));
        invoiceMonthComboBox.setSelectedIndex(cal.get(GregorianCalendar.MONTH));
        invoiceDayComboBox.setSelectedIndex(cal.get(GregorianCalendar.DATE)-1);
        transactionList = Transaction.getTransactions(""+fromInvoice.getInvoiceId());
        
     }
     
     
     private void addFunction(){
           int success;
            int year = Integer.parseInt(invoiceYearComboBox.getSelectedItem().toString());
            int month = invoiceMonthComboBox.getSelectedIndex();
            int day = invoiceDayComboBox.getSelectedIndex()+1;
            Client fromLoc = (Client) locationComboBox.getSelectedItem();
            int fromLocationId = fromLoc.getClientId();
            String fName = deleteList.get(0).getItemName()+"("+deleteList.get(0).getTransactionQuantity()+")";
            String tName = "("+transactionList.get(0).getTransactionQuantity()+")";
            String convertName = "CVT"+fName+": "+tName;
            //OUT so FROM
            success = InvoiceAction.convertSQLLogic(fromLoc.getClientId(),"0.00", convertName+"-A", false, 96, deleteList,year, month, day, true, fromLocationId);
            //IN so TO
            success = InvoiceAction.convertSQLLogic(fromLoc.getClientId(),"0.00", convertName+"-B", false, 96, transactionList,year, month, day, false, fromLocationId);
            Invoice fromInvoice = Invoice.getInvoiceWithName(convertName+"-A");
            Invoice toInvoice = Invoice.getInvoiceWithName(convertName+"-B");
            GregorianCalendar cal = new GregorianCalendar();
            cal.set(GregorianCalendar.YEAR, year);
            cal.set(GregorianCalendar.MONTH, month);
            cal.set(GregorianCalendar.DATE, day);
            success = Convert.insertConvert(convertName, fromInvoice.getInvoiceId().toString(), toInvoice.getInvoiceId().toString(), Formats.dateFormatDays.format(cal.getTime()));
            
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
            int fromLocationId = fromLoc.getClientId();
                        
            //OUT so FROM
//            InvoiceAction.invoiceEditSQLLogic(fromInvoice.getInvoiceId(),fromLocationId,"0.0", transactionNumberTextField.getText()+"-A", false, 69, transactionList,year, month, day, true, deleteList, fromLocationId, "-");
            
            //ININ so TO
//            InvoiceAction.invoiceEditSQLLogic(toInvoice.getInvoiceId(),fromLocationId,"0.0", transactionNumberTextField.getText()+"-B", false, 69, transactionList,year, month, day, false, deleteList, fromLocationId, "-");
              GregorianCalendar cal = new GregorianCalendar();
            cal.set(GregorianCalendar.YEAR, year);
            cal.set(GregorianCalendar.MONTH, month);
            cal.set(GregorianCalendar.DATE, day);
//            Transfer.updateTransfer(transactionNumberTextField.getText(), Formats.dateFormatDays.format(cal.getTime()), transfer.getTransferId());
            this.dispose();
     }
     
     
     private void setItemToValues(Transaction t){
         itemNameLabelTo.setText(t.getItemName());
         quantityLabelTo.setText(FractionAction.convertToFraction(t.getTransactionQuantity()));
         
     }
     
     private void setItemFromValues(Transaction t){
         itemNameLabelFrom.setText(t.getItemName());
         quantityLabelFrom.setText(FractionAction.convertToFraction(t.getTransactionQuantity()));
     }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddClientCancelButton;
    private javax.swing.JButton AddInvoiceOkButton;
    private javax.swing.JButton addItemButton;
    private javax.swing.JButton addItemButton1;
    private javax.swing.JComboBox invoiceDayComboBox;
    private javax.swing.JComboBox invoiceMonthComboBox;
    private javax.swing.JComboBox invoiceYearComboBox;
    private javax.swing.JLabel itemNameLabelFrom;
    private javax.swing.JLabel itemNameLabelTo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JComboBox locationComboBox;
    private javax.swing.JLabel quantityLabelFrom;
    private javax.swing.JLabel quantityLabelTo;
    // End of variables declaration//GEN-END:variables
}
