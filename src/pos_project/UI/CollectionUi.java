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
import javax.swing.JFrame;
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
public class CollectionUi extends javax.swing.JDialog {
 private boolean outFlg = false;
 private boolean checkFlg = false;
 private boolean creditMemoflag = false;
// private boolean typeFlg;
//    private String itemNumber;
    private int supplierId;
//    private Item item;
//    private Client client;
    private Transaction transaction;
    private Invoice invoice;
    /** Creates new form AddClient */
    public CollectionUi(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setCollectionComboBoxValues();
        setCheckDateComboboxValues();
        jComboBox1.setSelectedIndex(2);
        jComboBox1.setEnabled(false);
//         collectionYearComboBox.setModel(DateActions.getYearModel());
//         collectionYearComboBox.setSelectedItem(new GregorianCalendar().get(GregorianCalendar.YEAR));
//         collectionMonthComboBox.setSelectedIndex(new GregorianCalendar().get(GregorianCalendar.MONTH));
//         collectionDayComboBox.setModel(DateActions.fixDay(collectionMonthComboBox.getSelectedIndex(), collectionYearComboBox.getSelectedItem().toString()));
//         collectionDayComboBox.setSelectedIndex(new GregorianCalendar().get(GregorianCalendar.DATE)-1);
//         checkNumberLabel.setEnabled(true);
         collectionCheckTextField.setEnabled(true);
         checkDayComboBox.setEnabled(true);
         checkMonthComboBox.setEnabled(true);
         checkYearComboBox.setEnabled(true);
         checkDateLabel.setEnabled(true);
//       clearedCheckBox.setEnabled(true);
         clearedCheckBox.setSelected(true);
         checkFlg = true;
         creditMemoflag = true;
    }
    
    public CollectionUi(java.awt.Frame parent, boolean modal,boolean isOut) {
        super(parent, modal);
        initComponents();
        setCollectionComboBoxValues();
        setCheckDateComboboxValues();
        outFlg = isOut;
        jComboBox1.removeItemAt(2);
//         collectionYearComboBox.setModel(DateActions.getYearModel());
//            collectionYearComboBox.setSelectedItem(new GregorianCalendar().get(GregorianCalendar.YEAR));
//            collectionMonthComboBox.setSelectedIndex(new GregorianCalendar().get(GregorianCalendar.MONTH));
//            collectionDayComboBox.setModel(DateActions.fixDay(collectionMonthComboBox.getSelectedIndex(), collectionYearComboBox.getSelectedItem().toString()));
//            collectionDayComboBox.setSelectedIndex(new GregorianCalendar().get(GregorianCalendar.DATE)-1);
            
    }
    
    public CollectionUi(java.awt.Frame parent, boolean modal, boolean isOut, int supplierNumber) {
        super(parent, modal);
        initComponents();
        outFlg = isOut;
        jLabel5.setVisible(false);
        supplierId = supplierNumber;
//        invoiceNumberTextField.setVisible(false);
//        this.setTitle("New Invoice Details");
//        if(isOut){
//            customerNameLabel.setEnabled(true);
//            supplierLabel.setEnabled(true);
//            jButton1.setEnabled(true);
//        } else {
            customerNameLabel.setVisible(false);
            supplierLabel.setVisible(false);
            jButton1.setVisible(false);
            setCollectionComboBoxValues();
            setCheckDateComboboxValues();
            jComboBox1.removeItemAt(2);
//        }
//            collectionYearComboBox.setModel(DateActions.getYearModel());
//            collectionYearComboBox.setSelectedItem(new GregorianCalendar().get(GregorianCalendar.YEAR));
//            collectionMonthComboBox.setSelectedIndex(new GregorianCalendar().get(GregorianCalendar.MONTH));
//            collectionDayComboBox.setModel(DateActions.fixDay(collectionMonthComboBox.getSelectedIndex(), collectionYearComboBox.getSelectedItem().toString()));
//            collectionDayComboBox.setSelectedIndex(new GregorianCalendar().get(GregorianCalendar.DATE)-1);
            
                
    }
    
    
    private void setCollectionComboBoxValues(){
          collectionYearComboBox.setModel(DateActions.getYearModel());
            collectionYearComboBox.setSelectedItem(new GregorianCalendar().get(GregorianCalendar.YEAR));
            collectionMonthComboBox.setSelectedIndex(new GregorianCalendar().get(GregorianCalendar.MONTH));
            collectionDayComboBox.setModel(DateActions.fixDay(collectionMonthComboBox.getSelectedIndex(), collectionYearComboBox.getSelectedItem().toString()));
            collectionDayComboBox.setSelectedIndex(new GregorianCalendar().get(GregorianCalendar.DATE)-1);
    }
    
    private void setCheckDateComboboxValues(){
          checkYearComboBox.setModel(DateActions.getYearModel());
            checkYearComboBox.setSelectedItem(new GregorianCalendar().get(GregorianCalendar.YEAR));
            checkMonthComboBox.setSelectedIndex(new GregorianCalendar().get(GregorianCalendar.MONTH));
            checkDayComboBox.setModel(DateActions.fixDay(collectionMonthComboBox.getSelectedIndex(), collectionYearComboBox.getSelectedItem().toString()));
            checkDayComboBox.setSelectedIndex(new GregorianCalendar().get(GregorianCalendar.DATE)-1);
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
        AddClientOkButton = new javax.swing.JButton();
        AddClientCancelButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        collectionBalance = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        customerNameLabel = new javax.swing.JLabel();
        collectionTotal = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        collectionPriceTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        supplierLabel1 = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        collectionInvoiceType = new javax.swing.JLabel();
        checkNumberLabel = new javax.swing.JLabel();
        collectionCheckTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        checkDateLabel = new javax.swing.JLabel();
        clearedCheckBox = new javax.swing.JCheckBox();
        collectionInvoiceNumberLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        collectionMonthComboBox = new javax.swing.JComboBox();
        collectionDayComboBox = new javax.swing.JComboBox();
        collectionYearComboBox = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        checkMonthComboBox = new javax.swing.JComboBox();
        checkDayComboBox = new javax.swing.JComboBox();
        checkYearComboBox = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        orNumberTextBox = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setPreferredSize(new java.awt.Dimension(600, 450));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Collection Details");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 0, 0);
        getContentPane().add(jLabel1, gridBagConstraints);

        supplierLabel.setText("Date");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(supplierLabel, gridBagConstraints);

        jLabel3.setText("Total Amount");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 10);
        getContentPane().add(jLabel3, gridBagConstraints);

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
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 10);
        getContentPane().add(jPanel1, gridBagConstraints);

        jLabel5.setText("Receipt/Invoice #");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        getContentPane().add(jLabel5, gridBagConstraints);

        collectionBalance.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        getContentPane().add(collectionBalance, gridBagConstraints);

        jLabel9.setText("Payment Type");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        getContentPane().add(jLabel9, gridBagConstraints);

        customerNameLabel.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        getContentPane().add(customerNameLabel, gridBagConstraints);

        collectionTotal.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        getContentPane().add(collectionTotal, gridBagConstraints);

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(1, 0, 0, 5);
        getContentPane().add(jButton1, gridBagConstraints);

        jLabel6.setText("Amount");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        getContentPane().add(jLabel6, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        getContentPane().add(collectionPriceTextField, gridBagConstraints);

        jLabel10.setText("Remaining Balance");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        getContentPane().add(jLabel10, gridBagConstraints);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cash", "Check", "Credit Memo" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        getContentPane().add(jComboBox1, gridBagConstraints);

        supplierLabel1.setText("Client Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(supplierLabel1, gridBagConstraints);

        dateLabel.setText("yyyy-mm-dd");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 10);
        getContentPane().add(dateLabel, gridBagConstraints);

        jLabel2.setText("Invoice Type");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(jLabel2, gridBagConstraints);

        collectionInvoiceType.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(collectionInvoiceType, gridBagConstraints);

        checkNumberLabel.setText("Check Number");
        checkNumberLabel.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        getContentPane().add(checkNumberLabel, gridBagConstraints);

        collectionCheckTextField.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        getContentPane().add(collectionCheckTextField, gridBagConstraints);

        jLabel4.setText("Collection Date");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        getContentPane().add(jLabel4, gridBagConstraints);

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 400;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        getContentPane().add(jSeparator1, gridBagConstraints);

        checkDateLabel.setText("Check Date");
        checkDateLabel.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(checkDateLabel, gridBagConstraints);

        clearedCheckBox.setText("Cleared");
        clearedCheckBox.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        getContentPane().add(clearedCheckBox, gridBagConstraints);

        collectionInvoiceNumberLabel.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(collectionInvoiceNumberLabel, gridBagConstraints);

        collectionMonthComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        collectionMonthComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                collectionMonthComboBoxActionPerformed(evt);
            }
        });
        jPanel3.add(collectionMonthComboBox);

        collectionDayComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jPanel3.add(collectionDayComboBox);

        collectionYearComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2010", "2011", "2012", "2013", "2014", "2015" }));
        collectionYearComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                collectionYearComboBoxActionPerformed(evt);
            }
        });
        jPanel3.add(collectionYearComboBox);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        getContentPane().add(jPanel3, gridBagConstraints);

        checkMonthComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        checkMonthComboBox.setEnabled(false);
        checkMonthComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkMonthComboBoxActionPerformed(evt);
            }
        });
        jPanel2.add(checkMonthComboBox);

        checkDayComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        checkDayComboBox.setEnabled(false);
        jPanel2.add(checkDayComboBox);

        checkYearComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2010", "2011", "2012", "2013", "2014", "2015" }));
        checkYearComboBox.setEnabled(false);
        checkYearComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkYearComboBoxActionPerformed(evt);
            }
        });
        jPanel2.add(checkYearComboBox);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        getContentPane().add(jPanel2, gridBagConstraints);

        jLabel7.setText("O.R. Number");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        getContentPane().add(jLabel7, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        getContentPane().add(orNumberTextBox, gridBagConstraints);

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
            c.setCollectionOrNumber(orNumberTextBox.getText());
            c.setCollectionInvoiceNumber(invoice.getInvoiceNumber());
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
//            c.setCollectionDate(new GregorianCalendar().getTime());
            c.setCollectionCheckDate(checkCal.getTime());
            c.setCollectionInvoiceId(invoice.getInvoiceId());
            c.setCollectionTypeFlag(Short.parseShort(Integer.toString(jComboBox1.getSelectedIndex())));
            Double balance = invoice.getInvoiceTotalPrice()-Collections.getCollectionAmountUsingId(invoice.getInvoiceId()+"");
            
            if(clearedCheckBox.isSelected() || c.getCollectionTypeFlag().equals(new Short("0"))){
                c.setCollectionClearedFlag(Short.parseShort("1"));
                balance  -= c.getCollectionAmount();
            } else {
                c.setCollectionClearedFlag(Short.parseShort("0"));
            }
            if(creditMemoflag){
               c.setCollectionCreditMemoFlag(new Short("1"));
            }else{
                c.setCollectionCreditMemoFlag(new Short("0"));
            }
            c.setCollectionBalanceAsOf(balance);
            CollectionAction.collectionSQLLogic(c, collectionCheckTextField.isEnabled(), jComboBox1.getSelectedIndex(), balance,  collectionCheckTextField.getText(), supplierId);
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            SearchUi detailsPopUp = new SearchUi(new JFrame(),true, 6, outFlg);
//        }
       
               detailsPopUp.setLocationRelativeTo(null);
                detailsPopUp.pack();
                detailsPopUp.setVisible(true);
                if(detailsPopUp.getInvoice() != null){
                    invoice = detailsPopUp.getInvoice();
                    collectionInvoiceNumberLabel.setText(invoice.getInvoiceNumber());
                    supplierId = invoice.getInvoiceId();
                    setValues();
                }
               
                 
    }//GEN-LAST:event_jButton1ActionPerformed

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
        }else if(jComboBox1.getSelectedIndex() == 2){
            checkNumberLabel.setEnabled(true);
            collectionCheckTextField.setEnabled(true);
            checkDayComboBox.setEnabled(true);
            checkMonthComboBox.setEnabled(true);
            checkYearComboBox.setEnabled(true);
            checkDateLabel.setEnabled(true);
//            clearedCheckBox.setEnabled(true);
            clearedCheckBox.setSelected(true);
            checkFlg = true;
        }  else {
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
                 if(customerNameLabel.getText().equals("-")){
            errorFlg = true;
            errMsg += "* "+ErrorMessages.ERROR_COLLECTION_TRANSACTION_INVALID;
        }   
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
              collectionInvoiceNumberLabel.setText("");
             collectionPriceTextField.setText("");
//             transactionPriceTextField.setText("");
          }else{
             this.dispose();
         }
          
         
     }
      private void setValues(){
          collectionBalance.setText(Formats.centavoDecimal.format(invoice.getInvoiceTotalPrice() - Collections.getCollectionAmountUsingId(invoice.getInvoiceId()+"")));
          collectionTotal.setText(Formats.centavoDecimal.format(invoice.getInvoiceTotalPrice()));
          String invoiceType;
          switch(invoice.getInvoiceTypeFlag()){
              case 1: invoiceType = "IN";
                  break;
              default: invoiceType= "OUT";
          }
         if(invoice.getInvoicePaidFlag() == 1){
             collectionBalance.setText("0.00  PAID");
             collectionPriceTextField.setEnabled(false);
             collectionDayComboBox.setEnabled(false);
             collectionMonthComboBox.setEnabled(false);
             collectionYearComboBox.setEnabled(false);
             jComboBox1.setEnabled(false);
             AddClientOkButton.setEnabled(false);
         } else {
             collectionPriceTextField.setEnabled(true);
             AddClientOkButton.setEnabled(true);
             collectionDayComboBox.setEnabled(true);
             collectionMonthComboBox.setEnabled(true);
             collectionYearComboBox.setEnabled(true);
             jComboBox1.setEnabled(true);
         }
          collectionInvoiceType.setText(invoiceType);
          customerNameLabel.setText(invoice.getClientName());
          dateLabel.setText(Formats.dateFormatDays2.format(invoice.getInvoiceDate()));
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
    private javax.swing.JLabel collectionBalance;
    private javax.swing.JTextField collectionCheckTextField;
    private javax.swing.JComboBox collectionDayComboBox;
    private javax.swing.JLabel collectionInvoiceNumberLabel;
    private javax.swing.JLabel collectionInvoiceType;
    private javax.swing.JComboBox collectionMonthComboBox;
    private javax.swing.JTextField collectionPriceTextField;
    private javax.swing.JLabel collectionTotal;
    private javax.swing.JComboBox collectionYearComboBox;
    private javax.swing.JLabel customerNameLabel;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField orNumberTextBox;
    private javax.swing.JLabel supplierLabel;
    private javax.swing.JLabel supplierLabel1;
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
