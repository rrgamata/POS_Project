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

import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import pos_project.Action.CollectionAction;
import pos_project.Action.DateActions;
import pos_project.classes.Client;
import pos_project.classes.Collections;
import pos_project.classes.ErrorMessages;
import pos_project.classes.Formats;
import pos_project.classes.Invoice;
import pos_project.classes.Item;
import pos_project.classes.Transaction;

/**
 *
 * @author Cif3r
 */
public class EditCollectionUi extends javax.swing.JDialog {
 private boolean outFlg = false;
 private boolean checkFlg = false;
//    private String itemNumber;
    private int supplierId;
    private String collectId;
//    private Item item;
//    private Client client;
    private Collections collection;
    private Transaction transaction;
    private Invoice invoice;
    /** Creates new form AddClient */
    public EditCollectionUi(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setCollectionComboBoxValues();
        setCheckDateComboboxValues();
//         collectionYearComboBox.setModel(DateActions.getYearModel());
//            collectionYearComboBox.setSelectedItem(new GregorianCalendar().get(GregorianCalendar.YEAR));
//            collectionMonthComboBox.setSelectedIndex(new GregorianCalendar().get(GregorianCalendar.MONTH));
//            collectionDayComboBox.setModel(DateActions.fixDay(collectionMonthComboBox.getSelectedIndex(), collectionYearComboBox.getSelectedItem().toString()));
//            collectionDayComboBox.setSelectedIndex(new GregorianCalendar().get(GregorianCalendar.DATE)-1);
            
    }
    
    public EditCollectionUi(java.awt.Frame parent, boolean modal, boolean isOut, String collectionId, String invoiceNumber) {
        super(parent, modal);
        initComponents();
        outFlg = isOut;
//        jLabel5.setVisible(false);
        collectId = collectionId;
//        invoiceNumberTextField.setVisible(false);
//        this.setTitle("New Invoice Details");
//        if(isOut){
//            customerNameLabel.setEnabled(true);
//            supplierLabel.setEnabled(true);
//            jButton1.setEnabled(true);
//        } else {
//            customerNameLabel.setVisible(false);
//            supplierLabel.setVisible(false);
//            jButton1.setVisible(false);
//        Invoice i = Invoice.getInvoiceWithName(invoiceNumber);
//        invoice = i;
//        supplierId = i.getInvoiceId();
        collection = Collections.getCollection(collectionId);
        invoice = Invoice.getInvoiceWithId(collection.getCollectionInvoiceId().toString());
        supplierId = invoice.getInvoiceId();
            setCollectionComboBoxValues();
            if(collection.getCollectionTypeFlag()<2){
                jComboBox1.setSelectedIndex(collection.getCollectionTypeFlag());    
            }else{
            jComboBox1.setSelectedIndex(collection.getCollectionTypeFlag()-1);
            }
            collectionPriceTextField.setText(collection.getCollectionAmount()+"");
            
            if(collectionDayComboBox.getSelectedIndex() != 0){
                setCheckDateComboboxValues();
                collectionCheckTextField.setText(collection.getCollectionNumber());
                if(collection.getCollectionClearedFlag() ==1){
                    clearedCheckBox.setSelected(true);
                }
            }
//        }
//            collectionYearComboBox.setModel(DateActions.getYearModel());
//            collectionYearComboBox.setSelectedItem(new GregorianCalendar().get(GregorianCalendar.YEAR));
//            collectionMonthComboBox.setSelectedIndex(new GregorianCalendar().get(GregorianCalendar.MONTH));
//            collectionDayComboBox.setModel(DateActions.fixDay(collectionMonthComboBox.getSelectedIndex(), collectionYearComboBox.getSelectedItem().toString()));
//            collectionDayComboBox.setSelectedIndex(new GregorianCalendar().get(GregorianCalendar.DATE)-1);
            
                
    }
    
    
    private void setCollectionComboBoxValues(){
          collectionYearComboBox.setModel(DateActions.getYearModel());
          GregorianCalendar cal = new GregorianCalendar();
          cal.setTime(collection.getCollectionDate());
                  
            collectionYearComboBox.setSelectedItem(cal.get(GregorianCalendar.YEAR));
            collectionMonthComboBox.setSelectedIndex(cal.get(GregorianCalendar.MONTH));
            collectionDayComboBox.setModel(DateActions.fixDay(collectionMonthComboBox.getSelectedIndex(), collectionYearComboBox.getSelectedItem().toString()));
            collectionDayComboBox.setSelectedIndex(cal.get(GregorianCalendar.DATE)-1);
    }
    
    
    
    private void setCheckDateComboboxValues(){
        if(collection.getCollectionCheckDate() != null){
          checkYearComboBox.setModel(DateActions.getYearModel());
          GregorianCalendar cal = new GregorianCalendar();
          cal.setTime(collection.getCollectionCheckDate());
         checkYearComboBox.setSelectedItem(cal.get(GregorianCalendar.YEAR));
         checkMonthComboBox.setSelectedIndex(cal.get(GregorianCalendar.MONTH));
         checkDayComboBox.setModel(DateActions.fixDay(collectionMonthComboBox.getSelectedIndex(), collectionYearComboBox.getSelectedItem().toString()));
         checkDayComboBox.setSelectedIndex(cal.get(GregorianCalendar.DATE)-1);
        }
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

        jPanel1 = new javax.swing.JPanel();
        AddClientOkButton = new javax.swing.JButton();
        AddClientCancelButton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        collectionPriceTextField = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        checkNumberLabel = new javax.swing.JLabel();
        collectionCheckTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        collectionMonthComboBox = new javax.swing.JComboBox();
        collectionDayComboBox = new javax.swing.JComboBox();
        collectionYearComboBox = new javax.swing.JComboBox();
        checkDateLabel = new javax.swing.JLabel();
        checkMonthComboBox = new javax.swing.JComboBox();
        checkDayComboBox = new javax.swing.JComboBox();
        checkYearComboBox = new javax.swing.JComboBox();
        clearedCheckBox = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        orNumberTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        AddClientOkButton.setText("OK");
        AddClientOkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddClientOkButtonActionPerformed(evt);
            }
        });
        jPanel1.add(AddClientOkButton);

        AddClientCancelButton.setText("Cancel");
        AddClientCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddClientCancelButtonActionPerformed(evt);
            }
        });
        jPanel1.add(AddClientCancelButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 10);
        getContentPane().add(jPanel1, gridBagConstraints);

        jLabel9.setText("Payment Type");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        getContentPane().add(jLabel9, gridBagConstraints);

        jLabel6.setText("Amount");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        getContentPane().add(jLabel6, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        getContentPane().add(collectionPriceTextField, gridBagConstraints);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cash", "Check", "Others" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        getContentPane().add(jComboBox1, gridBagConstraints);

        checkNumberLabel.setText("Check Number");
        checkNumberLabel.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        getContentPane().add(checkNumberLabel, gridBagConstraints);

        collectionCheckTextField.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        getContentPane().add(collectionCheckTextField, gridBagConstraints);

        jLabel4.setText("Collection Date");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(jLabel4, gridBagConstraints);

        collectionMonthComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        collectionMonthComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                collectionMonthComboBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        getContentPane().add(collectionMonthComboBox, gridBagConstraints);

        collectionDayComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(collectionDayComboBox, gridBagConstraints);

        collectionYearComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2010", "2011", "2012", "2013", "2014", "2015" }));
        collectionYearComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                collectionYearComboBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(collectionYearComboBox, gridBagConstraints);

        checkDateLabel.setText("Check Date");
        checkDateLabel.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(checkDateLabel, gridBagConstraints);

        checkMonthComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        checkMonthComboBox.setEnabled(false);
        checkMonthComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkMonthComboBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        getContentPane().add(checkMonthComboBox, gridBagConstraints);

        checkDayComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        checkDayComboBox.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(checkDayComboBox, gridBagConstraints);

        checkYearComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2010", "2011", "2012", "2013", "2014", "2015" }));
        checkYearComboBox.setEnabled(false);
        checkYearComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkYearComboBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(checkYearComboBox, gridBagConstraints);

        clearedCheckBox.setText("Cleared");
        clearedCheckBox.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        getContentPane().add(clearedCheckBox, gridBagConstraints);

        jLabel1.setText("O.R. Number");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        getContentPane().add(jLabel1, gridBagConstraints);

        orNumberTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orNumberTextFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        getContentPane().add(orNumberTextField, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddClientOkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddClientOkButtonActionPerformed
        
        if(!checkItem()){
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
//            Double price = Double.parseDouble(transactionPriceTextField.getText());
            Collections c = new Collections();
            c.setCollectionOrNumber(orNumberTextField.getText());
            c.setCollectionAmount(Double.parseDouble(collectionPriceTextField.getText()));
            GregorianCalendar cal = new GregorianCalendar();
            cal.set(GregorianCalendar.YEAR, Integer.parseInt(collectionYearComboBox.getSelectedItem().toString()));
            cal.set(GregorianCalendar.MONTH, collectionMonthComboBox.getSelectedIndex());
            cal.set(GregorianCalendar.DATE, collectionDayComboBox.getSelectedIndex()+1);
//            c.setCollectionDate(new GregorianCalendar().getTime());
            c.setCollectionDate(cal.getTime());
            GregorianCalendar checkCal = new GregorianCalendar();
            checkCal.set(GregorianCalendar.YEAR, Integer.parseInt(checkYearComboBox.getSelectedItem().toString()));
            checkCal.set(GregorianCalendar.MONTH, checkMonthComboBox.getSelectedIndex());
            checkCal.set(GregorianCalendar.DATE, checkDayComboBox.getSelectedIndex()+1);
            c.setCollectionNumber(collectionCheckTextField.getText());
//            c.setCollectionDate(new GregorianCalendar().getTime());
            c.setCollectionCheckDate(checkCal.getTime());
//            c.setCollectionInvoiceId(invoice.getInvoiceId());
            c.setCollectionTypeFlag(Short.parseShort(Integer.toString(jComboBox1.getSelectedIndex())));
//            Double balance = invoice.getInvoiceCurrentBalance() + collection.getCollectionAmount();
            Double balance = invoice.getInvoiceTotalPrice()-Collections.getCollectionAmountNotId(invoice.getInvoiceId()+"",c.getCollectionId()+""); 
//                    if- c.getCollectionAmount();
            
            c.setCollectionId(collection.getCollectionId());
            if(clearedCheckBox.isSelected() || c.getCollectionTypeFlag().equals(new Short("0"))){
                c.setCollectionClearedFlag(Short.parseShort("1"));
                balance -= c.getCollectionAmount();
            } else {
                c.setCollectionClearedFlag(Short.parseShort("0"));
            }
            c.setCollectionBalanceAsOf(balance);
            
            CollectionAction.collectionEditSQLLogic(c, collectionCheckTextField.isEnabled(), jComboBox1.getSelectedIndex(), balance,  collectionCheckTextField.getText(), supplierId);
            this.dispose();
//            if(collectionCheckTextField.isEnabled() && jComboBox1.getSelectedIndex() == 1){
//                Collections.addCollectionCheck(c, collectionCheckTextField.getText());
//            } else {
//                Collections.addCollectionCash(c);
//            }
//            Short paidFlag;
//            if(balance < 1){
//                paidFlag = new Short("1");
//            } else {
//                paidFlag = new Short("0");
//            }
//            Invoice.updateInvoiceBalance(supplierId, balance, paidFlag, Formats.dateFormatDays.format(c.getCollectionDate()));
//            this.dispose();
               
            
        }
}//GEN-LAST:event_AddClientOkButtonActionPerformed

    private void AddClientCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddClientCancelButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
}//GEN-LAST:event_AddClientCancelButtonActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        if(jComboBox1.getSelectedIndex() == 1){
            checkNumberLabel.setEnabled(true);
            collectionCheckTextField.setEnabled(true);
            checkDayComboBox.setEnabled(true);
            checkMonthComboBox.setEnabled(true);
            checkYearComboBox.setEnabled(true);
            checkDateLabel.setEnabled(true);
            clearedCheckBox.setEnabled(true);
            checkFlg = true;
        } else {
            checkNumberLabel.setEnabled(false);
            collectionCheckTextField.setEnabled(false);
            checkDayComboBox.setEnabled(false);
            checkMonthComboBox.setEnabled(false);
            checkYearComboBox.setEnabled(false);
            checkDateLabel.setEnabled(false);
            clearedCheckBox.setEnabled(false);
            checkFlg = false;
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void collectionMonthComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_collectionMonthComboBoxActionPerformed
        // TODO add your handling code here:
        collectionDayComboBox.setModel(DateActions.fixDay(collectionMonthComboBox.getSelectedIndex(), collectionYearComboBox.getSelectedItem().toString()));
}//GEN-LAST:event_collectionMonthComboBoxActionPerformed

    private void collectionYearComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_collectionYearComboBoxActionPerformed
        // TODO add your handling code here:
        collectionDayComboBox.setModel(DateActions.fixDay(collectionMonthComboBox.getSelectedIndex(), collectionYearComboBox.getSelectedItem().toString()));
}//GEN-LAST:event_collectionYearComboBoxActionPerformed

    private void checkMonthComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkMonthComboBoxActionPerformed
        // TODO add your handling code here:
        checkDayComboBox.setModel(DateActions.fixDay(checkMonthComboBox.getSelectedIndex(), checkYearComboBox.getSelectedItem().toString()));
    }//GEN-LAST:event_checkMonthComboBoxActionPerformed

    private void checkYearComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkYearComboBoxActionPerformed
        // TODO add your handling code here:
        checkDayComboBox.setModel(DateActions.fixDay(checkMonthComboBox.getSelectedIndex(), checkYearComboBox.getSelectedItem().toString()));
    }//GEN-LAST:event_checkYearComboBoxActionPerformed

    private void orNumberTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orNumberTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_orNumberTextFieldActionPerformed

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
    
    private boolean checkItem(){
        boolean errorFlg = false;
        String errMsg = new String();
//                 if(customerNameLabel.getText().equals("-")){
//            errorFlg = true;
//            errMsg += "* "+ErrorMessages.ERROR_COLLECTION_TRANSACTION_INVALID;
//        }   
        if(collectionCheckTextField.isEnabled()){
            if(collectionPriceTextField.getText().isEmpty()||collectionPriceTextField.getText() == null){
               errorFlg = true;
               errMsg += "* "+ErrorMessages.ERROR_COLLECTION_CHECK_INVALID;
        }
        }
       
        if(collectionPriceTextField.getText().isEmpty()||collectionPriceTextField.getText() == null){
               errorFlg = true;
               errMsg += "* "+ErrorMessages.ERROR_ITEM_PRICE;
        } else {
                try{
                    Double.parseDouble(collectionPriceTextField.getText());
                } catch (Exception e) {
                     errorFlg = true;
                    errMsg += "* "+ErrorMessages.ERROR_ITEM_PRICE;
                }
            }
           
        
        
        if(errorFlg){
            
            JOptionPane.showMessageDialog(this,errMsg ,ErrorMessages.TITLE_ERROR,JOptionPane.ERROR_MESSAGE);
        }
        
        return errorFlg;
        
        
    }
     
     private void success(){
      int answer = JOptionPane.showConfirmDialog(this,ErrorMessages.CONFIRM_ADDED_ITEM,ErrorMessages.TITLE_SUCCESS,JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
          if(answer==0){
//             invoiceNumberTextField.requestFocus();
//             invoiceNumberTextField.setText("");
             collectionPriceTextField.setText("");
//             transactionPriceTextField.setText("");
          }else{
             this.dispose();
         }
          
         
     }
      private void setValues(){
//          collectionBalance.setText(Formats.centavoDecimal.format(invoice.getInvoiceCurrentBalance()));
//          collectionTotal.setText(Formats.centavoDecimal.format(invoice.getInvoiceTotalPrice()));
          String invoiceType;
          switch(invoice.getInvoiceTypeFlag()){
              case 1: invoiceType = "IN";
                  break;
              default: invoiceType= "OUT";
          }
         if(invoice.getInvoicePaidFlag() == 1){
//             collectionBalance.setText("0.00  PAID");
             collectionPriceTextField.setEnabled(false);
             AddClientOkButton.setEnabled(false);
         } else {
             collectionPriceTextField.setEnabled(true);
             AddClientOkButton.setEnabled(true);
         }
//          collectionInvoiceType.setText(invoiceType);
//          customerNameLabel.setText(invoice.getClientName());
//          dateLabel.setText(Formats.dateFormatDays.format(invoice.getInvoiceDate()));
      }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddClientCancelButton;
    private javax.swing.JButton AddClientOkButton;
    private javax.swing.JLabel checkDateLabel;
    private javax.swing.JComboBox checkDayComboBox;
    private javax.swing.JComboBox checkMonthComboBox;
    private javax.swing.JLabel checkNumberLabel;
    private javax.swing.JComboBox checkYearComboBox;
    private javax.swing.JCheckBox clearedCheckBox;
    private javax.swing.JTextField collectionCheckTextField;
    private javax.swing.JComboBox collectionDayComboBox;
    private javax.swing.JComboBox collectionMonthComboBox;
    private javax.swing.JTextField collectionPriceTextField;
    private javax.swing.JComboBox collectionYearComboBox;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField orNumberTextField;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the transaction
     */
    public Transaction getTransaction() {
        return transaction;
    }

    /**
     * @param transaction the transaction to set
     */
    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
