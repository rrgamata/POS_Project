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
import pos_project.Action.LocationAction;
import pos_project.classes.Client;
import pos_project.classes.ErrorMessages;
import pos_project.classes.Formats;
import pos_project.classes.Invoice;
import pos_project.classes.Item;
import pos_project.classes.Location;
import pos_project.classes.Preorder;
import pos_project.classes.Transaction;
import pos_project.classes.User;

/**
 *
 * @author Cif3r
 */
public class DebitMemoUi extends javax.swing.JDialog {
 private boolean outFlg = false;
 private boolean editFlg = false;
 private boolean poFlg = false;
    private String itemNumber;
    ArrayList<Transaction> transactionList;
    Item item;
    Client client;
    Invoice invoice;
    Preorder preorder;
    
    /** Creates new form AddClient */
    public DebitMemoUi(java.awt.Frame parent, boolean modal, boolean isOut) {
        super(parent, modal);
        initComponents();
        locationComboBox.setModel(LocationAction.getLocationModel());
        transactionList = new ArrayList<Transaction>();
        outFlg = isOut;
        this.setTitle("New Invoice Details");
        if(isOut){
            supplierLabel.setText("Customer Name");
            supplierNumberLabel.setText("Customer #");
        } else {
            supplierLabel.setText("Supplier Name");
            supplierNumberLabel.setText("Supplier #");
            
        }
//        itemNameLabel.setVisible(false);
            customerNameLabel.setEnabled(true);
            supplierLabel.setEnabled(true);
            customerNumberValueLabel.setEnabled(true);
            supplierNumberLabel.setEnabled(true);
            jButton1.setEnabled(true);
            invoiceYearComboBox.setModel(DateActions.getYearModel());
            invoiceYearComboBox.setSelectedItem(new GregorianCalendar().get(GregorianCalendar.YEAR));
            invoiceMonthComboBox.setSelectedIndex(new GregorianCalendar().get(GregorianCalendar.MONTH));
            invoiceDayComboBox.setModel(DateActions.fixDay(invoiceMonthComboBox.getSelectedIndex(), invoiceYearComboBox.getSelectedItem().toString()));
            invoiceDayComboBox.setSelectedIndex(new GregorianCalendar().get(GregorianCalendar.DATE)-1);
            jLabel6.setVisible(false);
            locationComboBox.setVisible(false);
            paymentComboBox.setSelectedIndex(1);
//            initializeTable();
//        } else {
//            customerNameLabel.setVisible(false);
//            supplierLabel.setVisible(false);
//            jButton1.setVisible(false);
//        }
        voidButton.setVisible(false);
                
    }
    
    
    public DebitMemoUi(java.awt.Frame parent, boolean modal, boolean isOut, int invoiceNumber) {
        super(parent, modal);
        initComponents();
        
        transactionList = new ArrayList<Transaction>();
        outFlg = isOut;
        this.setTitle("New Invoice Details");
        if(isOut){
            supplierLabel.setText("Customer Name");
            supplierNumberLabel.setText("Customer Number");
        } else {
            supplierLabel.setText("Supplier Name");
            supplierNumberLabel.setText("Supplier Number");
            
        }
//        itemNameLabel.setVisible(false);
            customerNameLabel.setEnabled(true);
            supplierLabel.setEnabled(true);
            customerNumberValueLabel.setEnabled(true);
            supplierNumberLabel.setEnabled(true);
            jButton1.setEnabled(true);
            invoiceYearComboBox.setModel(DateActions.getYearModel());
            invoiceYearComboBox.setSelectedItem(new GregorianCalendar().get(GregorianCalendar.YEAR));
            invoiceMonthComboBox.setSelectedIndex(new GregorianCalendar().get(GregorianCalendar.MONTH));
            invoiceDayComboBox.setModel(DateActions.fixDay(invoiceMonthComboBox.getSelectedIndex(), invoiceYearComboBox.getSelectedItem().toString()));
            invoiceDayComboBox.setSelectedIndex(new GregorianCalendar().get(GregorianCalendar.DATE)-1);
            
            
        invoice = Invoice.getInvoiceWithId(invoiceNumber+"");
        locationComboBox.setModel(LocationAction.getLocationModel());
        locationComboBox.setSelectedItem(Client.getClient(invoice.getInvoiceLocationId()+""));
        transactionNumberTextField.setText(invoice.getInvoiceNumber());
        customerNameLabel.setText(invoice.getClientName());
          clientAddress.setText(invoice.getClientAddress());
        client = Client.getClient(Integer.toString(invoice.getInvoiceClientNumber()));
            supplierLabel.setText("Customer Name");
            supplierNumberLabel.setText("Customer #");
            amountTextField.setText(invoice.getInvoiceTotalPrice().toString());
            GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(invoice.getInvoiceDate());
        invoiceYearComboBox.setSelectedItem(""+cal.get(GregorianCalendar.YEAR));
        invoiceMonthComboBox.setSelectedIndex(cal.get(GregorianCalendar.MONTH));
        invoiceDayComboBox.setSelectedIndex(cal.get(GregorianCalendar.DATE)-1);
        paymentComboBox.setSelectedIndex(invoice.getInvoicePaymentType());
//            poFlg = true;
            
//            initializeTable();
        jLabel6.setVisible(false);
            locationComboBox.setVisible(false);
                editFlg = true;
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
        jPanel1 = new javax.swing.JPanel();
        AddInvoiceOkButton = new javax.swing.JButton();
        AddClientCancelButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        transactionNumberTextField = new javax.swing.JTextField();
        customerNameLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
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
        supplierNumberLabel = new javax.swing.JLabel();
        customerNumberValueLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        amountTextField = new javax.swing.JTextField();
        voidButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(550, 215));
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Transaction Details");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 0, 0);
        getContentPane().add(jLabel1, gridBagConstraints);

        supplierLabel.setText("Customer Name");
        supplierLabel.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(supplierLabel, gridBagConstraints);

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
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        getContentPane().add(jPanel1, gridBagConstraints);

        jLabel5.setText("Receipt/Invoice #");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        getContentPane().add(jLabel5, gridBagConstraints);

        transactionNumberTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transactionNumberTextFieldActionPerformed(evt);
            }
        });
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
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        getContentPane().add(customerNameLabel, gridBagConstraints);

        jButton1.setText("Search");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        getContentPane().add(jButton1, gridBagConstraints);

        paymentComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "OTC", "COD", "7 Days", "15 Days", "30 Days", "45 Days", "60 Days", "90 Days", "120 Days", "150 Days", "180 Days" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        getContentPane().add(paymentComboBox, gridBagConstraints);

        jLabel2.setText("Payment");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
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
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
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
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 0, 5);
        getContentPane().add(jLabel7, gridBagConstraints);

        clientAddress.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        getContentPane().add(clientAddress, gridBagConstraints);

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

        supplierNumberLabel.setText("Customer Number");
        supplierNumberLabel.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(supplierNumberLabel, gridBagConstraints);

        customerNumberValueLabel.setText("-");
        customerNumberValueLabel.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        getContentPane().add(customerNumberValueLabel, gridBagConstraints);

        jLabel8.setText("Amount");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        getContentPane().add(jLabel8, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        getContentPane().add(amountTextField, gridBagConstraints);

        voidButton.setText("Void");
        voidButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voidButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        getContentPane().add(voidButton, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddInvoiceOkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddInvoiceOkButtonActionPerformed
//        boolean receivableFlg =false;
        if(!checkItem()){
            if(editFlg){
                editInvoice();
            } else {
               addInvoice(); 
            }
            

                
               
            
        }
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
//                        initializeTable();
                    }
                    client = detailsPopUp.getClient();
                customerNameLabel.setText(client.getClientName());
                clientAddress.setText(client.getClientAddress());
                customerNumberValueLabel.setText(client.getClientNumber());
                }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void invoiceMonthComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceMonthComboBoxActionPerformed
        // TODO add your handling code here:
        invoiceDayComboBox.setModel(DateActions.fixDay(invoiceMonthComboBox.getSelectedIndex(), invoiceYearComboBox.getSelectedItem().toString()));
}//GEN-LAST:event_invoiceMonthComboBoxActionPerformed

    private void invoiceYearComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceYearComboBoxActionPerformed
        // TODO add your handling code here:
        invoiceDayComboBox.setModel(DateActions.fixDay(invoiceMonthComboBox.getSelectedIndex(), invoiceYearComboBox.getSelectedItem().toString()));
}//GEN-LAST:event_invoiceYearComboBoxActionPerformed

    private void transactionNumberTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactionNumberTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_transactionNumberTextFieldActionPerformed

    private void voidButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voidButtonActionPerformed
        // TODO add your handling code here:

        int confirm = JOptionPane.showConfirmDialog(this, ErrorMessages.CONFIRM_DELETE_INVOICE, ErrorMessages.TITLE_DELETE, JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION){

            Client loc = (Client) locationComboBox.getSelectedItem();
            InvoiceAction.voidDebitMemoSQLLogic(invoice.getInvoiceId(),outFlg, loc.getClientId());
            this.dispose();
        }

    }//GEN-LAST:event_voidButtonActionPerformed

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
//    private void initializeTable(){
//        
//        itemTable.getTableHeader().setReorderingAllowed(false);
//        DefaultTableModel mod = new DefaultTableModel(){
//            @Override
//            public boolean isCellEditable(int row, int column){
//                return false;
//            }
//        };
//       
////        mod.setColumnIdentifiers(new String[] {"Item Name","Item Supplier", "Quantity", "Amount per","Sub Total"});
//        mod.setColumnIdentifiers(new String[] {"Item Name", "Quantity", "Amount per","Sub Total"});
//        Double totalAmount = 0.00;
////        if(!transactionList.isEmpty()){
////        for(Transaction emp: transactionList){
////           mod.addRow(new String[] {emp.getItemName()+"",emp.getSupplierName()+"",emp.getTransactionQuantity().toString()+"",Formats.centavoDecimal.format(emp.getTransactionPrice())+"", Formats.centavoDecimal.format(emp.getTransactionSubTotal())});
////            totalAmount += emp.getTransactionSubTotal();
////        }
//        for(Transaction emp: transactionList){
//           mod.addRow(new String[] {emp.getItemName()+"",emp.getTransactionQuantity().toString()+"",Formats.centavoDecimal.format(emp.getTransactionPrice())+"", Formats.centavoDecimal.format(emp.getTransactionSubTotal())});
//            totalAmount += emp.getTransactionSubTotal();
//        }
//        
////        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(mod);
//        itemTable.setModel(mod);
////        itemTable.setRowSorter(sorter);
//        itemTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        itemTable.setShowGrid(true);
//        itemTable.setGridColor(Color.black);
////        itemTable.getColumnModel().removeColumn(itemTable.getColumnModel().getColumn(3));
//        System.out.println(itemTable.getModel());
//        totalValueLabel.setText(Formats.centavoDecimal.format(totalAmount));
//    }
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
//        if(transactionList.isEmpty()){
//            errorFlg = true;
//            errMsg += "* "+ErrorMessages.ERROR_TRANSACTION_ITEM;
//        } 
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
//             initializeTable();
//             transactionQuantityTextField1.setText("");
//             transactionPriceTextField.setText("");
          }else{
             this.dispose();
         }
     }
     
     private void addInvoice(){
         boolean receivableFlg = false;
         if (paymentComboBox.getSelectedIndex()>0){
                        receivableFlg =true;
                    }   int success;
                    int year = Integer.parseInt(invoiceYearComboBox.getSelectedItem().toString());
                    int month = invoiceMonthComboBox.getSelectedIndex();
                    int day = invoiceDayComboBox.getSelectedIndex()+1;
                    Client loc = (Client) locationComboBox.getSelectedItem();
                    int locationId = loc.getClientId();
                    Double price = Double.parseDouble(amountTextField.getText());
                    String fTotal = Formats.centavoDecimal.format(price);
                    success = InvoiceAction.debitMemoSQLLogic(client.getClientId(), fTotal, transactionNumberTextField.getText(), receivableFlg, paymentComboBox.getSelectedIndex(), year, month, day, outFlg, locationId);
                    if(success < 0 ){
                        this.dispose();
                    } else {
                        success();
                    }
     }
     
     
     private void editInvoice(){
         boolean receivableFlg = false;
         if (paymentComboBox.getSelectedIndex()>0){
                        receivableFlg =true;
                    }   int success;
                    int year = Integer.parseInt(invoiceYearComboBox.getSelectedItem().toString());
                    int month = invoiceMonthComboBox.getSelectedIndex();
                    int day = invoiceDayComboBox.getSelectedIndex()+1;
                    Client loc = (Client) locationComboBox.getSelectedItem();
                    int locationId = loc.getClientId();
                    Double price = Double.parseDouble(amountTextField.getText());
                    String fTotal = Formats.centavoDecimal.format(price);
                    success = InvoiceAction.editDebitMemoSQLLogic(invoice.getInvoiceId(),client.getClientId(), fTotal, transactionNumberTextField.getText(), receivableFlg, paymentComboBox.getSelectedIndex(), year, month, day, outFlg, locationId);
                    if(success < 0 ){
                        this.dispose();
                    } else {
                        success();
                    }
     }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddClientCancelButton;
    private javax.swing.JButton AddInvoiceOkButton;
    private javax.swing.JTextField amountTextField;
    private javax.swing.JLabel clientAddress;
    private javax.swing.JLabel customerNameLabel;
    private javax.swing.JLabel customerNumberValueLabel;
    private javax.swing.JComboBox invoiceDayComboBox;
    private javax.swing.JComboBox invoiceMonthComboBox;
    private javax.swing.JComboBox invoiceYearComboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JComboBox locationComboBox;
    private javax.swing.JComboBox paymentComboBox;
    private javax.swing.JLabel supplierLabel;
    private javax.swing.JLabel supplierNumberLabel;
    private javax.swing.JTextField transactionNumberTextField;
    private javax.swing.JButton voidButton;
    // End of variables declaration//GEN-END:variables
}
