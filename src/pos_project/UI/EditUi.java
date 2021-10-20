/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EditUi.java
 *
 * Created on Oct 2, 2013, 9:07:10 PM
 */
package pos_project.UI;

import java.awt.Color;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import pos_project.Action.CollectionAction;
import pos_project.Action.InvoiceAction;
import pos_project.Action.PreorderAction;
import pos_project.Action.ReturnAction;
import pos_project.classes.Client;
import pos_project.classes.Collections;
import pos_project.classes.ErrorMessages;
import pos_project.classes.Invoice;
import pos_project.classes.Returns;

/**
 *
 * @author Cif3r
 */

//
public class EditUi extends javax.swing.JDialog {
Client client;
TableRowSorter<DefaultTableModel> invoiceSorter;
TableRowSorter<DefaultTableModel> collectionSorter;
TableRowSorter<DefaultTableModel> balanceSorter;
TableRowSorter<DefaultTableModel> returnSorter;
boolean bCollection = false;
boolean bReturn = false;
boolean isPo = false;
boolean isIn = false;
int invoiceId;
    /** Creates new form EditUi */
// Search po
    public EditUi(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jTabbedPane1.remove(0);
        jTabbedPane1.remove(1);
        jTabbedPane1.remove(1);
        isPo = true;
        jTabbedPane1.setTitleAt(0, "Place Order");
        customerRadioButton.setEnabled(false);
        supplierRadioButton.setSelected(true);
    }
    //Edit po
     public EditUi(java.awt.Frame parent, boolean modal, int inNum) {
        super(parent, modal);
        initComponents();
        jTabbedPane1.remove(0);
        jTabbedPane1.remove(1);
        jTabbedPane1.remove(1);
        isPo = true;
        jTabbedPane1.setTitleAt(0, "Place Order");
        customerRadioButton.setEnabled(false);
        supplierRadioButton.setSelected(true);
        isIn = true;
    }
    
     
     //Edit Invoice/ Collection
     public EditUi(java.awt.Frame parent, boolean modal, boolean isCollection) {
        super(parent, modal);
        initComponents();
        bCollection = isCollection;
        if(!isCollection){
            jTabbedPane1.remove(0);
            jTabbedPane1.remove(1);
            jTabbedPane1.remove(1);
            
//            initializeInvoiceTable();
        } else{
            jTabbedPane1.remove(3);
        }
        
    }
     //Edit return
     public EditUi(java.awt.Frame parent, boolean modal, boolean isCollection, boolean isReturn) {
        super(parent, modal);
        initComponents();
        bCollection = isCollection;
        bReturn = true;
        if(!isCollection){
            jTabbedPane1.remove(0);
            jTabbedPane1.remove(1);
//            initializeInvoiceTable();
        }
        
    }

     
      private void initializeInvoiceTable(int clientId){
        mainTable.getTableHeader().setReorderingAllowed(false);
        DefaultTableModel mod;
        if(bCollection){
            initializeInvoiceBalanceTable(clientId);
            mod = InvoiceAction.getInvoiceCollectionTableData(clientId);
        }else if(bReturn){
            mod = InvoiceAction.getInvoiceTableDataWithoutDebit(clientId);   
        } else {
            mod = InvoiceAction.getInvoiceTableData(clientId);   
        }
         
        txtSearch.addKeyListener(new KeyListener(){
            public void keyReleased(java.awt.event.KeyEvent e){
                String text = txtSearch.getText();
                if (text.length() == 0) {
                    invoiceSorter.setRowFilter(null);
                } else {
                    invoiceSorter.setRowFilter(RowFilter.regexFilter("(?i)"+text));
                }
            }

            public void keyPressed(java.awt.event.KeyEvent e){
            }

            public void keyTyped(java.awt.event.KeyEvent e){
                
            }

            });
        invoiceSorter = new TableRowSorter<DefaultTableModel>(mod);
//        mainTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        mainTable.setModel(mod);
        mainTable.setRowSorter(invoiceSorter);
        mainTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        mainTable.setShowGrid(true);
        mainTable.setGridColor(Color.black);
        mainTable.getColumnModel().removeColumn(mainTable.getColumnModel().getColumn(mainTable.getColumnCount()-1));
        mainTable.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
//        if(System.getProperty("userName") == null){
//            mainTable.setEnabled(false);
//        } else {
//            mainTable.setEnabled(true);
//        }
        
    }
      
         private void initializeInvoiceBalanceTable(int clientId){
        mainTable1.getTableHeader().setReorderingAllowed(false);
        DefaultTableModel mod;
        
         mod = InvoiceAction.getAccountSummaryTableData(clientId);   
        
         
        txtSearch2.addKeyListener(new KeyListener(){
            public void keyReleased(java.awt.event.KeyEvent e){
                String text = txtSearch2.getText();
                if (text.length() == 0) {
                    balanceSorter.setRowFilter(null);
                } else {
                    balanceSorter.setRowFilter(RowFilter.regexFilter("(?i)"+text));
                }
            }

            public void keyPressed(java.awt.event.KeyEvent e){
            }

            public void keyTyped(java.awt.event.KeyEvent e){
                
            }

            });
        balanceSorter = new TableRowSorter<DefaultTableModel>(mod);
//        mainTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        mainTable1.setModel(mod);
        mainTable1.setRowSorter(balanceSorter);
        mainTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        mainTable1.setShowGrid(true);
        mainTable1.setGridColor(Color.black);
        mainTable1.getColumnModel().removeColumn(mainTable1.getColumnModel().getColumn(mainTable1.getColumnCount()-1));
        mainTable1.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
//        if(System.getProperty("userName") == null){
//            mainTable.setEnabled(false);
//        } else {
//            mainTable.setEnabled(true);
//        }
        
    }
      
         private void initializeCollectionTable(String invoiceNumber){
        collectionTable.getTableHeader().setReorderingAllowed(false);
        collectionTable.setModel(new DefaultTableModel());
        DefaultTableModel mod = CollectionAction.getCollectionListTableData(invoiceNumber);
        txtSearch.addKeyListener(new KeyListener(){
            public void keyReleased(java.awt.event.KeyEvent e){
                String text = txtSearch.getText();
                if (text.length() == 0) {
                    collectionSorter.setRowFilter(null);
                } else {
                    collectionSorter.setRowFilter(RowFilter.regexFilter("(?i)"+text));
                }
            }

            public void keyPressed(java.awt.event.KeyEvent e){
            }

            public void keyTyped(java.awt.event.KeyEvent e){
                
            }

            });
        invoiceSorter = new TableRowSorter<DefaultTableModel>(mod);
//        mainTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        collectionTable.setModel(mod);
        collectionTable.setRowSorter(collectionSorter);
        collectionTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        collectionTable.setShowGrid(true);
        collectionTable.setGridColor(Color.black);
        collectionTable.getColumnModel().removeColumn(collectionTable.getColumnModel().getColumn(collectionTable.getColumnCount()-1));
        collectionTable.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
//        if(System.getProperty("userName") == null){
//            mainTable.setEnabled(false);
//        } else {
//            mainTable.setEnabled(true);
//        }
        
    }
         
 private void initializeReturnsTable(String invoiceNumber){
        returnTable.getTableHeader().setReorderingAllowed(false);
        DefaultTableModel mod = ReturnAction.getReturnListTableData(invoiceNumber);
        returntxtSearch.addKeyListener(new KeyListener(){
            public void keyReleased(java.awt.event.KeyEvent e){
                String text = txtSearch.getText();
                if (text.length() == 0) {
                    returnSorter.setRowFilter(null);
                } else {
                    returnSorter.setRowFilter(RowFilter.regexFilter("(?i)"+text));
                }
            }

            public void keyPressed(java.awt.event.KeyEvent e){
            }

            public void keyTyped(java.awt.event.KeyEvent e){
                
            }

            });
        returnSorter = new TableRowSorter<DefaultTableModel>(mod);
//        mainTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        returnTable.setModel(mod);
        returnTable.setRowSorter(collectionSorter);
        returnTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        returnTable.setShowGrid(true);
        returnTable.setGridColor(Color.black);
        returnTable.getColumnModel().removeColumn(returnTable.getColumnModel().getColumn(returnTable.getColumnCount()-1));
        returnTable.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
//        if(System.getProperty("userName") == null){
//            mainTable.setEnabled(false);
//        } else {
//            mainTable.setEnabled(true);
//        }
        
    }         
         
      private void initializePoTable(int clientId){
        mainTable.getTableHeader().setReorderingAllowed(false);
        DefaultTableModel mod;
         mod = PreorderAction.getInvoiceTableData(clientId);   
        
         
        txtSearch.addKeyListener(new KeyListener(){
            public void keyReleased(java.awt.event.KeyEvent e){
                String text = txtSearch.getText();
                if (text.length() == 0) {
                    invoiceSorter.setRowFilter(null);
                } else {
                    invoiceSorter.setRowFilter(RowFilter.regexFilter("(?i)"+text));
                }
            }

            public void keyPressed(java.awt.event.KeyEvent e){
            }

            public void keyTyped(java.awt.event.KeyEvent e){
                
            }

            });
        invoiceSorter = new TableRowSorter<DefaultTableModel>(mod);
//        mainTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        mainTable.setModel(mod);
        mainTable.setRowSorter(invoiceSorter);
        mainTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        mainTable.setShowGrid(true);
        mainTable.setGridColor(Color.black);
        mainTable.getColumnModel().removeColumn(mainTable.getColumnModel().getColumn(mainTable.getColumnCount()-1));
        mainTable.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
//        if(System.getProperty("userName") == null){
//            mainTable.setEnabled(false);
//        } else {
//            mainTable.setEnabled(true);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        mainTable1 = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtSearch2 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        collectionPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        collectionTable = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtSearch1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        invoiceNumberLabel = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        clearCollectionButton = new javax.swing.JButton();
        editCollectionButton = new javax.swing.JButton();
        cancelCollectionButton = new javax.swing.JButton();
        collectionPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        returnTable = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        returntxtSearch = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        invoiceNumberLabel1 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        clearCollectionButton1 = new javax.swing.JButton();
        editReturnsButton1 = new javax.swing.JButton();
        voidReturnButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        customerRadioButton = new javax.swing.JRadioButton();
        supplierRadioButton = new javax.swing.JRadioButton();
        inventorySupplierNameLabel = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(755, 400));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setMinimumSize(new java.awt.Dimension(755, 325));
        jPanel1.setPreferredSize(new java.awt.Dimension(755, 325));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel4.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                jPanel4CaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        jPanel4.setLayout(new java.awt.GridBagLayout());

        mainTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Invoice #", "Transaction", "Client", "Pay Type", "Total", "Date", "Date Duel", "Edited by", "Edit Date"
            }
        ));
        mainTable1.setAutoscrolls(false);
        mainTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                mainTable1MouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(mainTable1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 660;
        gridBagConstraints.ipady = 120;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 0, 10);
        jPanel4.add(jScrollPane3, gridBagConstraints);

        jPanel8.setLayout(new java.awt.GridBagLayout());

        jLabel6.setText("Search:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel8.add(jLabel6, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 2, 5, 0);
        jPanel8.add(txtSearch2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 10, 11, 0);
        jPanel4.add(jPanel8, gridBagConstraints);

        jTabbedPane1.addTab("Invoice w/ Balance", jPanel4);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        mainTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Invoice #", "Transaction", "Client", "Pay Type", "Total", "Date", "Date Duel", "Edited by", "Edit Date"
            }
        ));
        mainTable.setAutoscrolls(false);
        mainTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                mainTableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(mainTable);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 660;
        gridBagConstraints.ipady = 120;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 0, 10);
        jPanel2.add(jScrollPane1, gridBagConstraints);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Search:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel3.add(jLabel1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 2, 5, 0);
        jPanel3.add(txtSearch, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 10, 11, 0);
        jPanel2.add(jPanel3, gridBagConstraints);

        jTabbedPane1.addTab("Invoice", jPanel2);

        collectionPanel.setLayout(new java.awt.GridBagLayout());

        collectionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Collection Date", "Particulars", "Amount", "Check Date", "Cleared", "Add Date", "Add User"
            }
        ));
        collectionTable.setAutoscrolls(false);
        collectionTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                collectionTableMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(collectionTable);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 660;
        gridBagConstraints.ipady = 95;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 0, 10);
        collectionPanel.add(jScrollPane2, gridBagConstraints);

        jPanel5.setLayout(new java.awt.GridBagLayout());

        jLabel4.setText("Search:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel5.add(jLabel4, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 2, 5, 0);
        jPanel5.add(txtSearch1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 11, 0);
        collectionPanel.add(jPanel5, gridBagConstraints);

        jLabel5.setText("Invoice Number");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 0, 0);
        collectionPanel.add(jLabel5, gridBagConstraints);

        invoiceNumberLabel.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 6, 0, 0);
        collectionPanel.add(invoiceNumberLabel, gridBagConstraints);

        jPanel7.setLayout(new java.awt.GridBagLayout());

        clearCollectionButton.setText("Clear");
        clearCollectionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearCollectionButtonActionPerformed(evt);
            }
        });
        jPanel7.add(clearCollectionButton, new java.awt.GridBagConstraints());

        editCollectionButton.setText("Edit");
        editCollectionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCollectionButtonActionPerformed(evt);
            }
        });
        jPanel7.add(editCollectionButton, new java.awt.GridBagConstraints());

        cancelCollectionButton.setText("Delete");
        cancelCollectionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelCollectionButtonActionPerformed(evt);
            }
        });
        jPanel7.add(cancelCollectionButton, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        collectionPanel.add(jPanel7, gridBagConstraints);

        jTabbedPane1.addTab("Collection", collectionPanel);

        collectionPanel1.setLayout(new java.awt.GridBagLayout());

        returnTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Collection Date", "Particulars", "Amount", "Check Date", "Cleared", "Add Date", "Add User"
            }
        ));
        returnTable.setAutoscrolls(false);
        returnTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                returnTableMouseReleased(evt);
            }
        });
        jScrollPane4.setViewportView(returnTable);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 660;
        gridBagConstraints.ipady = 95;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 0, 10);
        collectionPanel1.add(jScrollPane4, gridBagConstraints);

        jPanel9.setLayout(new java.awt.GridBagLayout());

        jLabel7.setText("Search:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel9.add(jLabel7, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 2, 5, 0);
        jPanel9.add(returntxtSearch, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 11, 0);
        collectionPanel1.add(jPanel9, gridBagConstraints);

        jLabel8.setText("Invoice Number");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 0, 0);
        collectionPanel1.add(jLabel8, gridBagConstraints);

        invoiceNumberLabel1.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 6, 0, 0);
        collectionPanel1.add(invoiceNumberLabel1, gridBagConstraints);

        jPanel10.setLayout(new java.awt.GridBagLayout());

        clearCollectionButton1.setText("New");
        clearCollectionButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearCollectionButton1ActionPerformed(evt);
            }
        });
        jPanel10.add(clearCollectionButton1, new java.awt.GridBagConstraints());

        editReturnsButton1.setText("Edit");
        editReturnsButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editReturnsButton1ActionPerformed(evt);
            }
        });
        jPanel10.add(editReturnsButton1, new java.awt.GridBagConstraints());

        voidReturnButton.setText("Void");
        voidReturnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voidReturnButtonActionPerformed(evt);
            }
        });
        jPanel10.add(voidReturnButton, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        collectionPanel1.add(jPanel10, gridBagConstraints);

        jTabbedPane1.addTab("Returns", collectionPanel1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jPanel1.add(jTabbedPane1, gridBagConstraints);

        jLabel2.setText("Client Type");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 11, 0, 0);
        jPanel1.add(jLabel2, gridBagConstraints);

        jLabel3.setText("Client Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 0);
        jPanel1.add(jLabel3, gridBagConstraints);

        jPanel6.setLayout(new java.awt.GridBagLayout());

        buttonGroup1.add(customerRadioButton);
        customerRadioButton.setSelected(true);
        customerRadioButton.setText("Customer");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel6.add(customerRadioButton, gridBagConstraints);

        buttonGroup1.add(supplierRadioButton);
        supplierRadioButton.setText("Supplier");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel6.add(supplierRadioButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel1.add(jPanel6, gridBagConstraints);

        inventorySupplierNameLabel.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 50, 5, 50);
        jPanel1.add(inventorySupplierNameLabel, gridBagConstraints);

        jButton3.setText("Search...");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel1.add(jButton3, gridBagConstraints);

        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        jPanel1.add(jButton1, gridBagConstraints);

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mainTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainTableMouseReleased
        // TODO add your handling code here:
        if(isPo){
            if(isIn){
                AddIvoiceDetailsUi detailsPopUp = new AddIvoiceDetailsUi(new JFrame(),true, false, 
                Integer.parseInt(mainTable.getModel().getValueAt(mainTable.convertRowIndexToModel(mainTable.getSelectedRow()), (mainTable.getColumnCount())).toString()));
        
                detailsPopUp.setLocationRelativeTo(null);
                detailsPopUp.setVisible(true);
                initializePoTable(client.getClientId());
            } else {
            PoUi detailsPopUp = new PoUi(new JFrame(),true, false, 
                mainTable.getModel().getValueAt(mainTable.convertRowIndexToModel(mainTable.getSelectedRow()), (mainTable.getColumnCount())).toString());
        
                detailsPopUp.setLocationRelativeTo(null);
                detailsPopUp.setVisible(true);
                initializePoTable(client.getClientId());
            }
        } else{
            if(bCollection){
                try{
//                initializeCollectionTable(mainTable.getModel().getValueAt(mainTable.convertRowIndexToModel(mainTable.getSelectedRow()), 0).toString());
                    initializeCollectionTable(mainTable.getModel().getValueAt(mainTable.convertRowIndexToModel(mainTable.getSelectedRow()), mainTable.getColumnCount()).toString());
                    jTabbedPane1.setSelectedIndex(2);
                    invoiceNumberLabel.setText(mainTable.getModel().getValueAt(mainTable.convertRowIndexToModel(mainTable.getSelectedRow()), 0).toString());
               } catch (Exception e){
                    e.printStackTrace();
                }
             } else {
            
                
                if(bReturn){
                     try{
//                initializeCollectionTable(mainTable.getModel().getValueAt(mainTable.convertRowIndexToModel(mainTable.getSelectedRow()), 0).toString());
                         initializeReturnsTable(mainTable.getModel().getValueAt(mainTable.convertRowIndexToModel(mainTable.getSelectedRow()), mainTable.getColumnCount()).toString());
                    jTabbedPane1.setSelectedIndex(1);
                    invoiceNumberLabel1.setText(mainTable.getModel().getValueAt(mainTable.convertRowIndexToModel(mainTable.getSelectedRow()), 0).toString());
                    invoiceId = Integer.parseInt(mainTable.getModel().getValueAt(mainTable.convertRowIndexToModel(mainTable.getSelectedRow()), mainTable.getColumnCount()).toString());
               } catch (Exception e){
                    e.printStackTrace();
                }
//                    ReturnUi detailsPopUp = new ReturnUi(new JFrame(),true, false, 
//                    mainTable.getModel().getValueAt(mainTable.convertRowIndexToModel(mainTable.getSelectedRow()), (mainTable.getColumnCount())).toString());
//                    detailsPopUp.setLocationRelativeTo(null);
//                    detailsPopUp.setVisible(true);
                } else {
                    Invoice ie = Invoice.getInvoiceWithId(mainTable.getModel().getValueAt(mainTable.convertRowIndexToModel(mainTable.getSelectedRow()), (mainTable.getColumnCount())).toString());
                    if(ie.getInvoiceDmFlag().equals(new Short("1"))){
                         DebitMemoUi detailsPopUp = new DebitMemoUi(new JFrame(),true, true, 
                            ie.getInvoiceId());
                            detailsPopUp.setLocationRelativeTo(null);
                        detailsPopUp.setVisible(true);
                    } else {
                         EditInvoiceDetailsUi detailsPopUp = new EditInvoiceDetailsUi(new JFrame(),true, false, 
                         mainTable.getModel().getValueAt(mainTable.convertRowIndexToModel(mainTable.getSelectedRow()), (mainTable.getColumnCount())).toString());
                         detailsPopUp.setLocationRelativeTo(null);
                         detailsPopUp.setVisible(true);
                    }
                    
                   
                }
            }
            initializeInvoiceTable(client.getClientId());
     }
        
}//GEN-LAST:event_mainTableMouseReleased

    private void collectionTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_collectionTableMouseReleased
        // TODO add your handling code here:
        if(!collectionTable.getModel().getValueAt(collectionTable.convertRowIndexToModel(collectionTable.getSelectedRow()), 4).toString().equals("-")){
            clearCollectionButton.setEnabled(false);
        } else {
            clearCollectionButton.setEnabled(true);
        }
}//GEN-LAST:event_collectionTableMouseReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        SearchUi detailsPopUp; 
       if(customerRadioButton.isSelected()){
        detailsPopUp= new SearchUi(new JFrame(),true, 1,false);   
       } else{
        detailsPopUp= new SearchUi(new JFrame(),true, 2,false);
       }        
        detailsPopUp.setLocationRelativeTo(null);
        detailsPopUp.pack();
        detailsPopUp.setVisible(true);
        if(detailsPopUp.getClient() != null){
         client = detailsPopUp.getClient();
         inventorySupplierNameLabel.setText(client.getClientName());
         if(isPo){
             initializePoTable(client.getClientId());
         } else {
             initializeInvoiceTable(client.getClientId());
         }
         
        }
}//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void clearCollectionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearCollectionButtonActionPerformed
        // TODO add your handling code here:
           if (collectionTable.getSelectedRow() < 0){
            JOptionPane.showMessageDialog(this,ErrorMessages.ERROR_NO_SELECTED_ITEM ,ErrorMessages.TITLE_ERROR,JOptionPane.ERROR_MESSAGE);
        } else {
            int confirm = JOptionPane.showConfirmDialog(this, ErrorMessages.CONFIRM_CLEAR_COLLECTION, ErrorMessages.TITLE_EDIT, JOptionPane.YES_NO_OPTION);
            if(confirm == JOptionPane.YES_OPTION){
//                      Collections.clearCollection(collectionTable.getModel().getValueAt(collectionTable.convertRowIndexToModel(collectionTable.getSelectedRow()), collectionTable.getColumnCount()).toString());
                Collections c = Collections.getCollection(collectionTable.getModel().getValueAt(collectionTable.convertRowIndexToModel(collectionTable.getSelectedRow()), collectionTable.getColumnCount()).toString());
                CollectionAction.collectionClearSQLLogic(c,invoiceNumberLabel.getText());
                       initializeCollectionTable(invoiceNumberLabel.getText());
            }
        }
        
    }//GEN-LAST:event_clearCollectionButtonActionPerformed

    private void cancelCollectionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelCollectionButtonActionPerformed
        // TODO add your handling code here:
         if (collectionTable.getSelectedRow() < 0){
            JOptionPane.showMessageDialog(this,ErrorMessages.ERROR_NO_SELECTED_ITEM ,ErrorMessages.TITLE_ERROR,JOptionPane.ERROR_MESSAGE);
        } else {
            int confirm = JOptionPane.showConfirmDialog(this, ErrorMessages.CONFIRM_DELETE_COLLECTION, ErrorMessages.TITLE_DELETE, JOptionPane.YES_NO_OPTION);
            if(confirm == JOptionPane.YES_OPTION){
//                       Collections.deleteCollection(collectionTable.getModel().getValueAt(collectionTable.convertRowIndexToModel(collectionTable.getSelectedRow()), collectionTable.getColumnCount()).toString(), 
//                            new GregorianCalendar().getTime());
//                       initializeCollectionTable(invoiceNumberLabel.getText());
                  Collections c = Collections.getCollection(collectionTable.getModel().getValueAt(collectionTable.convertRowIndexToModel(collectionTable.getSelectedRow()), collectionTable.getColumnCount()).toString());
                CollectionAction.collectionDeleteSQLLogic(c,invoiceNumberLabel.getText());
                       initializeCollectionTable(invoiceNumberLabel.getText());
            }
        }
       
    }//GEN-LAST:event_cancelCollectionButtonActionPerformed

    private void editCollectionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCollectionButtonActionPerformed
        // TODO add your handling code here:
        EditCollectionUi detailsPopUp = new EditCollectionUi(new JFrame(),true, false, 
            collectionTable.getModel().getValueAt(collectionTable.convertRowIndexToModel(collectionTable.getSelectedRow()), (collectionTable.getColumnCount())).toString(), invoiceNumberLabel.getText());
        
            detailsPopUp.setLocationRelativeTo(null);
            detailsPopUp.setVisible(true);
//                initializeCollectionTable(invoiceNumberLabel.getText());
                initializeCollectionTable(Integer.toString(invoiceId));
                    
                    
    }//GEN-LAST:event_editCollectionButtonActionPerformed

    private void mainTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainTable1MouseReleased
                try{
//                initializeCollectionTable(mainTable.getModel().getValueAt(mainTable.convertRowIndexToModel(mainTable.getSelectedRow()), 0).toString());
                    initializeCollectionTable(mainTable1.getModel().getValueAt(mainTable1.convertRowIndexToModel(mainTable1.getSelectedRow()), mainTable1.getColumnCount()).toString());
                    jTabbedPane1.setSelectedIndex(2);
                    invoiceId = Integer.parseInt(mainTable1.getModel().getValueAt(mainTable1.convertRowIndexToModel(mainTable1.getSelectedRow()), mainTable1.getColumnCount()).toString());
                    invoiceNumberLabel.setText(mainTable1.getModel().getValueAt(mainTable1.convertRowIndexToModel(mainTable1.getSelectedRow()), 0).toString());
               } catch (Exception e){
                    e.printStackTrace();
                }
    }//GEN-LAST:event_mainTable1MouseReleased

    private void jPanel4CaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jPanel4CaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel4CaretPositionChanged

    private void returnTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnTableMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_returnTableMouseReleased

    private void clearCollectionButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearCollectionButton1ActionPerformed
        // TODO add your handling code here:
        ReturnUi detailsPopUp = new ReturnUi(new JFrame(),true, false, 
                    invoiceId+"");
                    detailsPopUp.setLocationRelativeTo(null);
                    detailsPopUp.setVisible(true);
              
        initializeReturnsTable(invoiceId+"");
    }//GEN-LAST:event_clearCollectionButton1ActionPerformed

    private void editReturnsButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editReturnsButton1ActionPerformed
        // TODO add your handling code here:
        if (returnTable.getSelectedRow() < 0){
            JOptionPane.showMessageDialog(this,ErrorMessages.ERROR_NO_SELECTED_ITEM ,ErrorMessages.TITLE_ERROR,JOptionPane.ERROR_MESSAGE);
        } else {
        ReturnUi detailsPopUp = new ReturnUi(new JFrame(),true, true, invoiceId+"", 
            returnTable.getModel().getValueAt(returnTable.convertRowIndexToModel(returnTable.getSelectedRow()), (returnTable.getColumnCount())).toString());
        
            detailsPopUp.setLocationRelativeTo(null);
            detailsPopUp.setVisible(true);
                initializeReturnsTable(invoiceId+"");
        }    
    }//GEN-LAST:event_editReturnsButton1ActionPerformed

    private void voidReturnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voidReturnButtonActionPerformed
          if (returnTable.getSelectedRow() < 0){
            JOptionPane.showMessageDialog(this,ErrorMessages.ERROR_NO_SELECTED_ITEM ,ErrorMessages.TITLE_ERROR,JOptionPane.ERROR_MESSAGE);
        } else {
            int confirm = JOptionPane.showConfirmDialog(this, ErrorMessages.CONFIRM_DELETE_RETURN, ErrorMessages.TITLE_DELETE, JOptionPane.YES_NO_OPTION);
            if(confirm == JOptionPane.YES_OPTION){
                voidReturn();
                initializeReturnsTable(invoiceId+"");
            }
            
        }
    }//GEN-LAST:event_voidReturnButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                EditUi dialog = new EditUi(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    
    private void voidReturn(){
        Invoice inv = Invoice.getInvoiceWithId(Integer.toString(invoiceId));
        int returnId = Integer.parseInt(returnTable.getModel().getValueAt(returnTable.convertRowIndexToModel(returnTable.getSelectedRow()), (returnTable.getColumnCount())).toString());
        ArrayList<Returns> delList  = Returns.getReturns(returnId+"");
        boolean outFlg = false;
        if(inv.getInvoiceTypeFlag().equals(new Short("0"))){
            outFlg = true;
        }
        ReturnAction.voidReturnSQLLogic(invoiceId, returnId, delList, inv.getInvoiceLocationId(),outFlg, inv);
        
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelCollectionButton;
    private javax.swing.JButton clearCollectionButton;
    private javax.swing.JButton clearCollectionButton1;
    private javax.swing.JPanel collectionPanel;
    private javax.swing.JPanel collectionPanel1;
    private javax.swing.JTable collectionTable;
    private javax.swing.JRadioButton customerRadioButton;
    private javax.swing.JButton editCollectionButton;
    private javax.swing.JButton editReturnsButton1;
    private javax.swing.JLabel inventorySupplierNameLabel;
    private javax.swing.JLabel invoiceNumberLabel;
    private javax.swing.JLabel invoiceNumberLabel1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable mainTable;
    private javax.swing.JTable mainTable1;
    private javax.swing.JTable returnTable;
    private javax.swing.JTextField returntxtSearch;
    private javax.swing.JRadioButton supplierRadioButton;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSearch1;
    private javax.swing.JTextField txtSearch2;
    private javax.swing.JButton voidReturnButton;
    // End of variables declaration//GEN-END:variables
}
