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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import pos_project.Action.FractionAction;
import pos_project.classes.Client;
import pos_project.classes.ErrorMessages;
import pos_project.classes.Item;
import pos_project.classes.Returns;
import pos_project.classes.Transaction;

/**
 *
 * @author Cif3r
 */
public class ReturnsItemUi extends javax.swing.JDialog {
 private boolean outFlg = false;
//    private String itemNumber;
    private int supplierId;
    private int locationId;
    Item item;
    Client client;
    private Transaction transaction;
    int invoiceId;
    Client location;
    boolean isTransfer = false;
    private Returns returns;
    ArrayList<Returns> deleteList;
    
    /** Creates new form AddClient */
    public ReturnsItemUi(java.awt.Frame parent, boolean modal, boolean isOut) {
        super(parent, modal);
        initComponents();
        outFlg = isOut;
        jLabel5.setVisible(false);
        transactionNumberTextField.setVisible(false);
//        this.setTitle("New Invoice Details");
//        if(isOut){
//            customerNameLabel.setEnabled(true);
//            supplierLabel.setEnabled(true);
//            jButton1.setEnabled(true);
//        } else {
            customerNameLabel.setVisible(false);
            supplierLabel.setVisible(false);
            jButton1.setVisible(false);
//        }
    }
    
    public ReturnsItemUi(java.awt.Frame parent, boolean modal, boolean isOut, int supplierNumber) {
        super(parent, modal);
        initComponents();
        outFlg = isOut;
        jLabel5.setVisible(false);
        supplierId = supplierNumber;
        transactionNumberTextField.setVisible(false);
//        this.setTitle("New Invoice Details");
//        if(isOut){
//            customerNameLabel.setEnabled(true);
//            supplierLabel.setEnabled(true);
//            jButton1.setEnabled(true);
//        } else {
            customerNameLabel.setVisible(false);
            supplierLabel.setVisible(false);
            jButton1.setVisible(false);
//        }
        
                
    }
    
    
     public ReturnsItemUi(java.awt.Frame parent, boolean modal, int invoiceNumber) {
        super(parent, modal);
        initComponents();
        jLabel5.setVisible(false);
        this.invoiceId = invoiceNumber;
        transactionNumberTextField.setVisible(false);
//        this.setTitle("New Invoice Details");
//        if(isOut){
//            customerNameLabel.setEnabled(true);
//            supplierLabel.setEnabled(true);
//            jButton1.setEnabled(true);
//        } else {
            customerNameLabel.setVisible(false);
            supplierLabel.setVisible(false);
            jButton1.setVisible(false);
            jLabel8.setVisible(false);
            transactionPriceTextField.setVisible(false);
//        }
        
                
    }
     
     
     public ReturnsItemUi(java.awt.Frame parent, boolean modal, int invoiceNumber, ArrayList<Returns> delList) {
        super(parent, modal);
        initComponents();
        jLabel5.setVisible(false);
        this.invoiceId = invoiceNumber;
        transactionNumberTextField.setVisible(false);
        deleteList = delList;
//        this.setTitle("New Invoice Details");
//        if(isOut){
//            customerNameLabel.setEnabled(true);
//            supplierLabel.setEnabled(true);
//            jButton1.setEnabled(true);
//        } else {
            customerNameLabel.setVisible(false);
            supplierLabel.setVisible(false);
            jButton1.setVisible(false);
            jLabel8.setVisible(false);
            transactionPriceTextField.setVisible(false);
//        }
        
                
    }
    
    public ReturnsItemUi(java.awt.Frame parent, boolean modal, boolean isOut, Client loc) {
        super(parent, modal);
        initComponents();
        outFlg = isOut;
        jLabel5.setVisible(false);
        transactionNumberTextField.setVisible(false);
//        this.setTitle("New Invoice Details");
//        if(isOut){
//            customerNameLabel.setEnabled(true);
//            supplierLabel.setEnabled(true);
//            jButton1.setEnabled(true);
//        } else {
            customerNameLabel.setVisible(false);
            supplierLabel.setVisible(false);
            jButton1.setVisible(false);
//        }
            location = loc;
    }
    
    public ReturnsItemUi(java.awt.Frame parent, boolean modal, boolean isOut, Client loc,boolean transferFlg) {
        super(parent, modal);
        initComponents();
        outFlg = isOut;
        jLabel5.setVisible(false);
        isTransfer = transferFlg;
        jLabel7.setVisible(false);
        actualPriceLabel1.setVisible(false);
        jLabel8.setVisible(false);
        transactionPriceTextField.setVisible(false);
        transactionNumberTextField.setVisible(false);
//        this.setTitle("New Invoice Details");
//        if(isOut){
//            customerNameLabel.setEnabled(true);
//            supplierLabel.setEnabled(true);
//            jButton1.setEnabled(true);
//        } else {
            customerNameLabel.setVisible(false);
            supplierLabel.setVisible(false);
            jButton1.setVisible(false);
//        }
            location = loc;
    }
    
    
    public ReturnsItemUi(java.awt.Frame parent, boolean modal, boolean isOut, int supplierNumber, Client loc) {
        super(parent, modal);
        initComponents();
        outFlg = isOut;
        jLabel5.setVisible(false);
        supplierId = supplierNumber;
        transactionNumberTextField.setVisible(false);
//        this.setTitle("New Invoice Details");
//        if(isOut){
//            customerNameLabel.setEnabled(true);
//            supplierLabel.setEnabled(true);
//            jButton1.setEnabled(true);
//        } else {
            customerNameLabel.setVisible(false);
            supplierLabel.setVisible(false);
            jButton1.setVisible(false);
//        }
        
                location = loc;
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
        transactionPriceTextField = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        AddClientOkButton = new javax.swing.JButton();
        AddClientCancelButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        transactionNumberTextField = new javax.swing.JTextField();
        quantityLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        actualPriceLabel1 = new javax.swing.JLabel();
        customerNameLabel = new javax.swing.JLabel();
        itemNameLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        transactionQuantityTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(supplierLabel, gridBagConstraints);

        jLabel3.setText("Item Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 10);
        getContentPane().add(jLabel3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        getContentPane().add(transactionPriceTextField, gridBagConstraints);

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
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
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
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        getContentPane().add(transactionNumberTextField, gridBagConstraints);

        quantityLabel.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        getContentPane().add(quantityLabel, gridBagConstraints);

        jLabel7.setText("Price Bought/Sold");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        getContentPane().add(jLabel7, gridBagConstraints);

        jLabel8.setText("Price per Item");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        getContentPane().add(jLabel8, gridBagConstraints);

        jLabel9.setText("Quantity Bought/Sold");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        getContentPane().add(jLabel9, gridBagConstraints);

        actualPriceLabel1.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        getContentPane().add(actualPriceLabel1, gridBagConstraints);

        customerNameLabel.setText("-");
        customerNameLabel.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        getContentPane().add(customerNameLabel, gridBagConstraints);

        itemNameLabel.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
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
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        getContentPane().add(jButton1, gridBagConstraints);

        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        getContentPane().add(jButton2, gridBagConstraints);

        jLabel6.setText("Quantity Returned");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        getContentPane().add(jLabel6, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        getContentPane().add(transactionQuantityTextField1, gridBagConstraints);

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
//            Double price = Double.parseDouble("0");
//            if(!isTransfer){
//                price = Double.parseDouble(transactionPriceTextField.getText());    
//            } 
            
            Double quantity = FractionAction.convertToDouble(transactionQuantityTextField1.getText());
//            System.out.println(item.getItemId());
            setReturns(new Returns());
            getReturns().setReturnsTransactionId(transaction.getTransactionId());
            getReturns().setReturnsAmount(transaction.getTransactionPrice());
            double price = getReturns().getReturnsAmount();
            getReturns().setReturnsQuantity(quantity);
            getReturns().setReturnsSubTotal(price*quantity);
            getReturns().setItemName(transaction.getItemName());
            getReturns().setItemId(transaction.getTransactionItemNumber());
            this.dispose();
               
            
        }
}//GEN-LAST:event_AddClientOkButtonActionPerformed

    private void AddClientCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddClientCancelButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
}//GEN-LAST:event_AddClientCancelButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        SearchUi detailsPopUp = new SearchUi(new JFrame(),true, 1,outFlg);
                detailsPopUp.setLocationRelativeTo(null);
                detailsPopUp.pack();
                detailsPopUp.setVisible(true);
                client = detailsPopUp.getClient();
                customerNameLabel.setText(client.getClientName());
                 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         // TODO add your handling code here:
        SearchUi detailsPopUp;
        detailsPopUp = new SearchUi(new JFrame(),true, invoiceId);
        
        
        
//        SearchUi detailsPopUp = new SearchUi(new JFrame(),true, 3);
                detailsPopUp.setLocationRelativeTo(null);
                detailsPopUp.pack();
                detailsPopUp.setVisible(true);
        if(detailsPopUp.getTransaction() != null){
                transaction = detailsPopUp.getTransaction();
                itemNameLabel.setText(transaction.getItemName());
//                quantityLabel.setText(item.getQuantity().toString());
                Double quantity = transaction.getTransactionQuantity();
                int deletedCount = 0;
                if(deleteList != null){
                    deletedCount = checkDelList(transaction.getTransactionItemNumber());
                }
                quantity -= Returns.computeReturns(transaction.getTransactionId());
                quantity += deletedCount;
                actualPriceLabel1.setText(transaction.getTransactionPrice().toString());
                //added jan12 2014
//               jLabel8.setVisible(false);
                quantityLabel.setText(quantity+"");
                
        }
            
    }//GEN-LAST:event_jButton2ActionPerformed

    
    private int checkDelList(int itemId){
        int count = 0;
        for(Returns ret: deleteList){
            if(ret.getItemId() == itemId){
                count+= ret.getReturnsQuantity();
            }
        }
        return count;
    }
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
        if(customerNameLabel.isEnabled()){
         if(itemNameLabel.getText().equals("-")){
            errorFlg = true;
            errMsg += "* "+ErrorMessages.ERROR_TRANSACTION_ITEM;
        }   
        }
        if(itemNameLabel.getText().equals("-")){
            errorFlg = true;
            errMsg += "* "+ErrorMessages.ERROR_TRANSACTION_ITEM;
        } else {
//            if(transactionNumberTextField.getText().isEmpty()||transactionNumberTextField.getText() == null){
//                errorFlg = true;
//                errMsg += "* "+ErrorMessages.ERROR_TRANSACTION_NUMBER;
//            }
            if(transactionQuantityTextField1.getText().isEmpty()||transactionQuantityTextField1.getText() == null){
                errorFlg = true;
                errMsg += "* "+ErrorMessages.ERROR_ITEM_QUANTITY;
            } else {
                try{
//                    Integer.parseInt(transactionQuantityTextField1.getText());
                    FractionAction.convertToDouble(transactionQuantityTextField1.getText());
                } catch (Exception e) {
                      errorFlg = true;
                    errMsg += "* "+ErrorMessages.ERROR_ITEM_QUANTITY;
                }
            }
//            if(!isTransfer){
//            if(transactionPriceTextField.getText().isEmpty()||transactionPriceTextField.getText() == null){
//                errorFlg = true;
//                errMsg += "* "+ErrorMessages.ERROR_ITEM_PRICE;
//            } else {
//                try{
//                    Double.parseDouble(transactionPriceTextField.getText());
//                } catch (Exception e) {
//                    errorFlg = true;
//                    errMsg += "* "+ErrorMessages.ERROR_ITEM_PRICE;
//                }
//            }
//            }
        }
        Double quantity = FractionAction.convertToDouble(transactionQuantityTextField1.getText());
        Double stocks = FractionAction.convertToDouble(quantityLabel.getText());
//         int quantity = Integer.parseInt(transactionQuantityTextField1.getText());
//        int stocks = Integer.parseInt(quantityLabel.getText());
         if(outFlg && stocks < quantity){
                    errorFlg = true;
                    errMsg += "* "+ErrorMessages.ERROR_TRANSACTION_QUANTITY_OFB;
                    
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
             transactionQuantityTextField1.setText("");
             transactionPriceTextField.setText("");
          }else{
             this.dispose();
         }
     }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddClientCancelButton;
    private javax.swing.JButton AddClientOkButton;
    private javax.swing.JLabel actualPriceLabel1;
    private javax.swing.JLabel customerNameLabel;
    private javax.swing.JLabel itemNameLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel quantityLabel;
    private javax.swing.JLabel supplierLabel;
    private javax.swing.JTextField transactionNumberTextField;
    private javax.swing.JTextField transactionPriceTextField;
    private javax.swing.JTextField transactionQuantityTextField1;
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

    /**
     * @return the returns
     */
    public Returns getReturns() {
        return returns;
    }

    /**
     * @param returns the returns to set
     */
    public void setReturns(Returns returns) {
        this.returns = returns;
    }
}
