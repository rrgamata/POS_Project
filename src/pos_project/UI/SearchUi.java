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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import pos_project.Action.ClientAction;
import pos_project.Action.InvoiceAction;
import pos_project.Action.ItemAction;
import pos_project.Action.PreorderTransactionAction;
import pos_project.Action.TransactionAction;
import pos_project.Action.TransferAction;
import pos_project.classes.Client;
import pos_project.classes.ErrorMessages;
import pos_project.classes.Invoice;
import pos_project.classes.Item;
import pos_project.classes.Preorder;
import pos_project.classes.PreorderTransaction;
import pos_project.classes.Transaction;
import pos_project.classes.Transfer;

/**
 *
 * @author Cif3r
 */
public class SearchUi extends javax.swing.JDialog {
 private int searchType = 0;
 private boolean outflag;
 TableRowSorter<DefaultTableModel> sorter;
 private Client client;
 private Item item;
 private Invoice invoice;
 private Transfer transfer;
 DefaultTableModel mod;
 private Transaction transaction;
 private PreorderTransaction poTransaction;
 int supplierNumber = 0;
// private Transaction transaction;
    /** Creates new form AddClient */
    public SearchUi(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public SearchUi(java.awt.Frame parent, Boolean modal, int searchType,boolean outFlag) {
        initComponents();
       this.searchType = searchType;
       outflag= outFlag;
       switch(searchType){
           //Customer Search
           case 1: 
                   mod = ClientAction.getCustomerTableData(0);
                   clientTableAdjust(mod,3);
                   this.setTitle("Search Customer");
               break;
          //Supplier Search
           case 2:
                   mod = ClientAction.getCustomerTableData(1);
                   clientTableAdjust(mod,3);
                   this.setTitle("Search Supplier");
               break;
          //all customers
           case 3:
                   mod = ClientAction.getCustomerTableData(1);
                   clientTableAdjust(mod,3);
                   this.setTitle("Search Client");
                   jButton4.setEnabled(false);
               break;
               //search sales person
           case 9:
                   mod = ClientAction.getCustomerTableData(2);
                   clientTableAdjust(mod,3);
                   this.setTitle("Search SalesPerson");
                   jButton4.setEnabled(false);
               break;
               //search transfer
           case 5:
               mod = TransferAction.getAllTransfer();
                   clientTableAdjust(mod,4);
                   this.setTitle("Search Transfer");
                   jButton4.setEnabled(false);
               break;
               
            case 6:
                if(outFlag){
                    mod = InvoiceAction.getAllInvoice(0);
                } else {
                    mod = InvoiceAction.getAllInvoice(1);
                }
                   clientTableAdjust(mod,6);
                   this.setTitle("Search Invoice");
                   jButton4.setEnabled(false);
               break;   
           //Item Search
           default:
               if(outflag){
                   mod = ItemAction.getMainTableData(true);    
               } else {
                    mod = ItemAction.getMainTableData();    
               }
               clientTableAdjust(mod,3);
               this.setTitle("Search Item");
               
       }
    }
       public SearchUi(java.awt.Frame parent, Boolean modal, int searchType, int supplierNumber){
               initComponents();
               this.searchType = searchType;
//               mod = ItemAction.getSpecificTableData(supplierNumber);
               mod = ItemAction.getAllItemData(supplierNumber);
               clientTableAdjust(mod,3);
               this.supplierNumber = supplierNumber;
               this.setTitle("Search Items");
       
               
     }
      
     public SearchUi(java.awt.Frame parent, Boolean modal, int invoiceNumber){
               initComponents();
               this.searchType = 7;
               mod = TransactionAction.getAllTransactions(invoiceNumber);
               clientTableAdjust(mod,4);
               this.setTitle("Search Items");
       
               
     }  
     
       
       
        public SearchUi(java.awt.Frame parent, Boolean modal, int searchType, boolean outFlag, int locationNumber){
               initComponents();
               this.searchType = searchType;
               mod = ItemAction.getMainTableData(true, locationNumber);   
               clientTableAdjust(mod,3);
               this.setTitle("Search Items");
       
               
     }
        
        public SearchUi(java.awt.Frame parent, Boolean modal, int searchType, boolean outFlag, Preorder po){
               initComponents();
               this.searchType = searchType;
               mod  = PreorderTransactionAction.getAllTransactions(po.getPreorderId());   
               clientTableAdjust(mod,4);
               this.setTitle("Search PO Items");
       
               
     }
        
   //SEarch all Invoice of client       
    public SearchUi(java.awt.Frame parent, Boolean modal, boolean outFlag, int clientNumber){
               initComponents();
               this.searchType = 6;
               mod  = InvoiceAction.getAllInvoice(Integer.toString(clientNumber));   
               clientTableAdjust(mod,6);
                this.setTitle("Search Invoice");
                   jButton4.setEnabled(false);
       
               
    }
       
      private void clientTableAdjust(DefaultTableModel mod, int column){
            txtSearch.addKeyListener(new KeyListener(){
            public void keyReleased(java.awt.event.KeyEvent e){
                String text = txtSearch.getText();
                if (text.length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)"+text));
                }
            }

            public void keyPressed(java.awt.event.KeyEvent e){
            }

            public void keyTyped(java.awt.event.KeyEvent e){
                
            }

            });
            sorter = new TableRowSorter<DefaultTableModel>(mod);
            clientTable.setModel(mod);
            clientTable.setRowSorter(sorter);
            clientTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            clientTable.setShowGrid(true);
            clientTable.setGridColor(Color.black);
            clientTable.getColumnModel().removeColumn(clientTable.getColumnModel().getColumn(column));
            

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

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        clientTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jButton3.setText("OK");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 10);
        getContentPane().add(jPanel1, gridBagConstraints);

        clientTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Client Name", "Address", "Phone Number"
            }
        ));
        clientTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                clientTableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(clientTable);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.ipady = 20;
        getContentPane().add(jScrollPane1, gridBagConstraints);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Search:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel2.add(jLabel1, gridBagConstraints);

        txtSearch.setNextFocusableComponent(clientTable);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 2, 5, 0);
        jPanel2.add(txtSearch, gridBagConstraints);

        jButton4.setText("New...");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel2.add(jButton4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        getContentPane().add(jPanel2, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
       getSearchedData();
          
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        switch(searchType){
           //Customer Search
           case 1:  AddClientUi detailsPopUp = new AddClientUi(new JFrame(),true, false, false);
                detailsPopUp.setLocationRelativeTo(null);
                detailsPopUp.pack();
                detailsPopUp.setVisible(true);
                mod = ClientAction.getCustomerTableData(0);
                clientTableAdjust(mod,3);
                this.setTitle("Search Customer");
               break;
          //Supplier Search
           case 2: AddClientUi detailsPopUp2 = new AddClientUi(new JFrame(),true, false, true);
                detailsPopUp2.setLocationRelativeTo(null);
                detailsPopUp2.pack();
                detailsPopUp2.setVisible(true);
                   mod = ClientAction.getCustomerTableData(1);
                   clientTableAdjust(mod,3);
                   this.setTitle("Search Supplier");
               break;
           //Item Search
           default:
               AddItemUi detailsPopUp3;
               if(supplierNumber == 0){
                    detailsPopUp3 = new AddItemUi(new JFrame(),true, false);
                    detailsPopUp3.setLocationRelativeTo(null);
                    detailsPopUp3.pack();
                    detailsPopUp3.setVisible(true);
                   mod = ItemAction.getMainTableData();
               } else {
                    detailsPopUp3 = new AddItemUi(new JFrame(),true, false, ""+supplierNumber);
                     detailsPopUp3.setLocationRelativeTo(null);
                    detailsPopUp3.pack();
                    detailsPopUp3.setVisible(true);
                    mod = ItemAction.getSpecificTableData(supplierNumber);
               }
//                AddItemUi detailsPopUp3 = new AddItemUi(new JFrame(),true, false);
                
               clientTableAdjust(mod,3);
               this.setTitle("Search Item");
               
       }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void clientTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_clientTableKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            getSearchedData();
        }
    }//GEN-LAST:event_clientTableKeyPressed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        txtSearch.requestFocusInWindow();
    }//GEN-LAST:event_formComponentShown

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
    
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable clientTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * @return the item
     */
    public Item getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(Item item) {
        this.item = item;
    }

    /**
     * @return the invoice
     */
    public Invoice getInvoice() {
        return invoice;
    }

    /**
     * @param invoice the invoice to set
     */
    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    /**
     * @return the transfer
     */
    public Transfer getTransfer() {
        return transfer;
    }

    /**
     * @param transfer the transfer to set
     */
    public void setTransfer(Transfer transfer) {
        this.transfer = transfer;
    }

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
     * @return the poTransaction
     */
    public PreorderTransaction getPoTransaction() {
        return poTransaction;
    }

    /**
     * @param poTransaction the poTransaction to set
     */
    public void setPoTransaction(PreorderTransaction poTransaction) {
        this.poTransaction = poTransaction;
    }
    
    public void getSearchedData(){
           if (clientTable.getSelectedRow() < 0){
            JOptionPane.showMessageDialog(this,ErrorMessages.ERROR_NO_SELECTED_ITEM ,ErrorMessages.TITLE_ERROR,JOptionPane.ERROR_MESSAGE);
        } else {
              switch(searchType){
                case 1:
                case 2:
                case 3:
                case 9:
                    String supplierNumber = clientTable.getModel().getValueAt(clientTable.convertRowIndexToModel(clientTable.getSelectedRow()), 3).toString();
                    client = Client.getClient(supplierNumber);
                    break;
                case 5:
                    String transferNumber = clientTable.getModel().getValueAt(clientTable.convertRowIndexToModel(clientTable.getSelectedRow()), 4).toString();
                    transfer = Transfer.getTransfer(transferNumber);
                    break;
                case 6:
                    String invoiceNumber = clientTable.getModel().getValueAt(clientTable.convertRowIndexToModel(clientTable.getSelectedRow()), 6).toString();
                    setInvoice(Invoice.getInvoiceWithId(invoiceNumber));
                    break;
                case 7:
                    String transactionNumber = clientTable.getModel().getValueAt(clientTable.convertRowIndexToModel(clientTable.getSelectedRow()), clientTable.getColumnCount()).toString();
                    Transaction t = Transaction.getTransaction(transactionNumber); 
                    setTransaction(t);
                            break;
                  case 8:
                    String poTransactionNumber = clientTable.getModel().getValueAt(clientTable.convertRowIndexToModel(clientTable.getSelectedRow()), clientTable.getColumnCount()).toString();
                    PreorderTransaction poT = PreorderTransaction.getTransaction(poTransactionNumber); 
                    setPoTransaction(poT);
                            break;   
                    
                default:
                    String itemNumber = clientTable.getModel().getValueAt(clientTable.convertRowIndexToModel(clientTable.getSelectedRow()), 3).toString();
                    item = Item.getItemStatus(itemNumber);
            }
             this.dispose();
        }
        
    }
}
