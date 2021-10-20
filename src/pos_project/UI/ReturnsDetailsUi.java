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
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.text.DateFormat;
import java.util.ArrayList;
import java.awt.print.*;
import java.io.FileInputStream;
import java.util.Locale;
import java.util.Properties;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import pos_project.Action.FractionAction;
import pos_project.Action.InvoiceAction;
import pos_project.Action.PrintAction;
import pos_project.Action.ReturnAction;
import pos_project.classes.Client;
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
public class ReturnsDetailsUi extends javax.swing.JDialog implements Printable{
 private boolean outFlg = false;
    private String itemNumber;
    ArrayList<Transaction> transactionList;
    ArrayList<Returns> returnList;
    Item item;
    Client client;
    Invoice invoice;
    ReturnMain returnMain;
    private Paper paper = new Paper();
    
    /** Creates new form AddClient */
    public ReturnsDetailsUi(java.awt.Frame parent, boolean modal, boolean isOut, String returnMainNumber) {
        super(parent, modal);
        initComponents();
        returnMain = ReturnMain.getReturnMain(Integer.parseInt(returnMainNumber));
        String mainNumber = "-";
        if(returnMain.getReturnMainNumber() != null){
            mainNumber = returnMain.getReturnMainNumber();
        }
        returnDateTextField.setText(Formats.dateFormatDays2.format(returnMain.getReturnMainDate()));
        returnNumTextField.setText(mainNumber);
        invoice = Invoice.getInvoiceWithId(returnMain.getReturnMainInvoiceId().toString());
        itemNameLabel.setText(InvoiceAction.getInvoiceType(invoice.getInvoiceTypeFlag()));
        if(invoice.getInvoiceTypeFlag().equals(new Short("0"))){
            supplierLabel.setText("Customer Name");
            supplierNumberLabel.setText("Customer #");
        } else {
            supplierLabel.setText("Supplier Name");
            supplierNumberLabel.setText("Supplier #");
        }
        
//        paymentComboBox.setSelectedIndex(invoice.getInvoicePaymentType());
        paymentTextField.setText(InvoiceAction.getPaymentType(invoice.getInvoicePaymentType()));
        invoiceNumTextField.setText(invoice.getInvoiceNumber());
//        GregorianCalendar cal = new GregorianCalendar();
//        cal.setTime(invoice.getInvoiceDate());
        invoiceDateTextField.setText(Formats.dateFormatDays2.format(invoice.getInvoiceDate()));
//        invoiceYearComboBox.setSelectedItem(""+cal.get(GregorianCalendar.YEAR));
//        invoiceMonthComboBox.setSelectedIndex(cal.get(GregorianCalendar.MONTH));
//        invoiceDayComboBox.setSelectedIndex(cal.get(GregorianCalendar.DATE)-1);
        customerNameLabel.setText(invoice.getClientName());
        clientAddress.setText(invoice.getClientAddress());
        if(invoice.getInvoicePaymentType() != 0){
            dueDate.setText(Formats.dateFormatDays2.format(invoice.getInvoiceDueDate()));
        }
        Client c = Client.getClient(invoice.getInvoiceClientNumber().toString());
        customerNumberLabel.setText(c.getClientNumber());
        transactionList = Transaction.getTransactions(""+invoice.getInvoiceId());
        returnList = Returns.getReturns(returnMainNumber);
        initializeTable();
//        transactionList =
//        transactionList = new ArrayList<Transaction>();
//        outFlg = isOut;
//        this.setTitle("New Invoice Details");
//        if(isOut){
//            supplierLabel.setText("Customer Name");
//        } else {
//            supplierLabel.setText("Supplier Name");
//            
//        }
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
        jButton1 = new javax.swing.JButton();
        AddClientCancelButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        customerNameLabel = new javax.swing.JLabel();
        itemNameLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        paymentTextField = new javax.swing.JLabel();
        invoiceNumTextField = new javax.swing.JLabel();
        invoiceDateTextField = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        totalLabel = new javax.swing.JLabel();
        totalValueLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        clientAddress = new javax.swing.JLabel();
        dueDate = new javax.swing.JLabel();
        supplierNumberLabel = new javax.swing.JLabel();
        customerNumberLabel = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        returnNumTextField = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        returnDateTextField = new javax.swing.JLabel();

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
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 0, 0);
        getContentPane().add(jLabel1, gridBagConstraints);

        supplierLabel.setText("Customer Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 3, 0);
        getContentPane().add(supplierLabel, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Return Details");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 10);
        getContentPane().add(jLabel3, gridBagConstraints);

        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

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
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 3, 5);
        getContentPane().add(jLabel5, gridBagConstraints);

        customerNameLabel.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(customerNameLabel, gridBagConstraints);

        itemNameLabel.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        getContentPane().add(itemNameLabel, gridBagConstraints);

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
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(jScrollPane1, gridBagConstraints);

        jLabel2.setText("Payment");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(4, 5, 3, 5);
        getContentPane().add(jLabel2, gridBagConstraints);

        jLabel4.setText("Invoice Date");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 3, 0);
        getContentPane().add(jLabel4, gridBagConstraints);

        jLabel6.setText("Invoice Type");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 3, 0);
        getContentPane().add(jLabel6, gridBagConstraints);

        paymentTextField.setText("jLabel7");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        getContentPane().add(paymentTextField, gridBagConstraints);

        invoiceNumTextField.setText("jLabel8");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        getContentPane().add(invoiceNumTextField, gridBagConstraints);

        invoiceDateTextField.setText("jLabel9");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        getContentPane().add(invoiceDateTextField, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        totalLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        totalLabel.setText("Total:");
        jPanel2.add(totalLabel, new java.awt.GridBagConstraints());

        totalValueLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        totalValueLabel.setText("0.00");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel2.add(totalValueLabel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        getContentPane().add(jPanel2, gridBagConstraints);

        jLabel7.setText("Address");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        getContentPane().add(jLabel7, gridBagConstraints);

        jLabel8.setText("Due Date");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        getContentPane().add(jLabel8, gridBagConstraints);

        clientAddress.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        getContentPane().add(clientAddress, gridBagConstraints);

        dueDate.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        getContentPane().add(dueDate, gridBagConstraints);

        supplierNumberLabel.setText("Customer #");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 3, 0);
        getContentPane().add(supplierNumberLabel, gridBagConstraints);

        customerNumberLabel.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(customerNumberLabel, gridBagConstraints);

        jLabel9.setText("Return #");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 3, 5);
        getContentPane().add(jLabel9, gridBagConstraints);

        returnNumTextField.setText("jLabel8");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        getContentPane().add(returnNumTextField, gridBagConstraints);

        jLabel10.setText("Return Date");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        getContentPane().add(jLabel10, gridBagConstraints);

        returnDateTextField.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        getContentPane().add(returnDateTextField, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddClientCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddClientCancelButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
}//GEN-LAST:event_AddClientCancelButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
          JOptionPane.setDefaultLocale(Locale.ENGLISH);
        if (JOptionPane.showConfirmDialog(this, "Are you sure you want to print receipt?", "Confirm Print", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
            PrinterJob job = PrinterJob.getPrinterJob();
            PageFormat pageFormat = job.defaultPage();
            //default margin size
            double margin = 36;    //half inch
//            try {
//                Properties prop = new Properties();
//                prop.load(new FileInputStream("nightclub_config.properties"));
//                margin = Double.parseDouble(prop.getProperty("receiptMargin"));
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//            if (!isValidation){//if this window is in validation mode, no updating will happen.
//                if (checkRecNo()) {                    
//                        this.UpdateStatusAndReceiptNo(1, Receipt.getLastReceiptNumber());
//                } else {                    
//                        this.UpdateStatus(1);
//                }
//            }
//            lblReceiptNoR.setText(Integer.toString(Receipt.getCurrentReceiptNo(receiptNumber)));
            paper.setImageableArea(margin, margin, paper.getWidth() - margin * 2, paper.getHeight() - margin * 2);
            pageFormat.setPaper(paper);
            job.setPrintable(this, pageFormat);
//            RCM0001.setPinilit();
            try {
//                prin = false;
//                job.print();
//                prin = true;
                job.print();
//                short cashCardFlg = 0;
//                if (radioCard.isSelected()) {
//                    cashCardFlg = 1;
//                }
//                Receipt.updatePaymentMethod(receiptNumber, cashCardFlg);
////             Receipt.addGuideFeeAndDiscountToReceipt(Double.parseDouble(txtGuideFee.getText().replace(",", "")),
////                                                     Double.parseDouble(txtDiscount.getText().replace(",","")),
////                                                     receiptNumber);
//                Receipt.addGuideFeeAndDiscountToReceipt(gfee, dfee, receiptNumber);
////             CustomerTable.updateCustomerTable(tableNumber);
////             Receipt.freeTalent(receiptNumber);


                this.dispose();

            } catch (PrinterException ex) {
                /* The job did not successfully complete */
                JOptionPane.setDefaultLocale(Locale.ENGLISH);
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Print Status", JOptionPane.ERROR_MESSAGE);
            }
//            if (!isSplitReceipt) {
//                outDialog.dispose();
//            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    
     public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
//        BufferedImage img = null;
//        try {
//            img = ImageIO.read(getClass().getResource("/icons/angelHeartLogo.png"));
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//         this.print(graphics);
         int quantityLabel = 0;
         int quantityValue = 0;
         int amountLabel = 0;
         int amountValue = 0;
         int subTotalLabel = 0;
         int subTotalValue = 0;
         int totalLabel = 0;
         int totalValue = 0;
         int fontSize = 0;
         String fontStyle = new String();
          try {
                Properties prop = new Properties();
                prop.load(new FileInputStream("pos_config.properties"));
                fontStyle = (prop.getProperty("font")).toString();
                quantityLabel = Integer.parseInt(prop.getProperty("printQuantityLabel"));
                quantityValue = Integer.parseInt(prop.getProperty("printQuantityValue"));
                amountLabel = Integer.parseInt(prop.getProperty("printAmountLabel"));
                amountValue = Integer.parseInt(prop.getProperty("printAmountValue"));
                subTotalLabel = Integer.parseInt(prop.getProperty("printSubtotalLabel"));
                subTotalValue = Integer.parseInt(prop.getProperty("printSubtotalValue"));
                totalLabel = Integer.parseInt(prop.getProperty("printTotalLabel"));
                totalValue = Integer.parseInt(prop.getProperty("printTotalValue"));
                fontSize = Integer.parseInt(prop.getProperty("fontSize"));
                        
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
         
        Font font = new Font(fontStyle, Font.PLAIN, fontSize);
        Font fontBold = new Font(fontStyle, Font.BOLD, fontSize);
        FontMetrics metrics = graphics.getFontMetrics(font);
        int lineHeight = metrics.getHeight();
        graphics.setFont(font);
        Graphics2D g2d = (Graphics2D) graphics;
        int[] pageBreaks = null;

        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

        int totalOrderLine = itemTable.getRowCount();
        int limit = 0;
        if(invoice.getInvoiceTypeFlag().equals(new Short("1"))){
            limit = 35;
        } else {
            limit = 35;
        }
        int numOfPageBreaks = (int)totalOrderLine/limit;

        pageBreaks = new int[numOfPageBreaks];

        for(int a = 0; a<pageBreaks.length;a++){
            pageBreaks[a] = (a+1)*limit;

        }

        if (pageIndex > pageBreaks.length) {
            return NO_SUCH_PAGE;
        }

        //content printing starts here.
        int y = 0;
        y+=lineHeight;
        y+=lineHeight*3;
//        g2d.drawImage(img,1,18,null);
//        y+=img.getHeight();
//        g2d.drawString("by: "+clubDetails.getClubOwner(), 1, y);
//        y+=lineHeight;
//        g2d.drawString(clubDetails.getClubAddress(), 1, y);
//        y+=lineHeight;
//        g2d.drawString("TIN No: "+clubDetails.getClubTIN(), 1, y);
//        y+=lineHeight;
//        g2d.drawString("Receipt No: "+lblReceiptNoR.getText(),1,y);
//        g2d.drawString("Invoice No: "+invoiceNumTextField.getText(),1,y);
        
//        g2d.drawString(PrintAction.addAfterSpaces("INVOICE NO: "+invoiceNumTextField.getText(),75)
//                +PrintAction.addAfterSpaces("DATE: ", 5)+invoiceDateTextField.getText(),1,y);
        g2d.drawString("Invoice No.: "+invoiceNumTextField.getText(), 1, y);
        g2d.drawString("Invoice Date: "+invoiceDateTextField.getText(), 385, y);
        y+=lineHeight;
//        g2d.drawString("Cashier: "+invoice.getInvoiceAddUser(), 1, y);
//        y+=lineHeight;

//        g2d.drawString("XXXXXXXXXXXXXXXXXXXXXXXXXXXX", 1, y);
//        y+=lineHeight;
//        g2d.drawString(PrintAction.addAfterSpaces("Date: ", 14)+invoiceDateTextField.getText(), 1, y);
//        g2d.drawString(PrintAction.addAfterSpaces(PrintAction.addAfterSpaces("PAYMENT TYPE: ", 14)+paymentTextField.getText(),75)
//                +PrintAction.addAfterSpaces("DUE DATE: ", 5)+dueDate.getText(), 1, y);
        g2d.drawString("Return No.: "+returnNumTextField.getText(), 1, y);
        g2d.drawString("Return Date: "+returnDateTextField.getText(), 385, y);
//        y+=lineHeight;
//        g2d.drawString(PrintAction.addAfterSpaces("Due Date: ", 14)+dueDate.getText(), 1, y);
//        y+=lineHeight;
        y+=lineHeight*2;
        
        String iType;
        if(invoice.getInvoiceTypeFlag().equals(new Short("1"))){
            iType = "Supplier";
        } else {
            iType = "Customer";
        }
        g2d.drawString(iType+" No.: "+customerNumberLabel.getText(), 1, y);
        y+=lineHeight;
        g2d.drawString(iType+" Name: "+customerNameLabel.getText(), 1, y);
        y+=lineHeight;
        g2d.drawString("Address: "+clientAddress.getText(), 1, y);
        y+=lineHeight*3;
//        String previousFdN = "";
        
//         itemTable.getTableHeader().paint(g2d);
//         itemTable.paint(g2d);
//        y+=lineHeight;
//        g2d.drawString("Items: ", 1, y);
//        y+=lineHeight*2;
//        g2d.drawString(PrintAction.addAfterSpaces("Item Name",39)
//                +PrintAction.addAfterSpaces("Quantity ", 24)
//                +PrintAction.addAfterSpaces("Amount ", 25)
//                +PrintAction.addAfterSpaces("Subtotal ", 24), 1, y);
        g2d.drawString("Item Name", 1, y);
        g2d.drawString("Quantity ", quantityLabel, y);
        g2d.drawString("Amount ", amountLabel, y);
        g2d.drawString("Subtotal ", subTotalLabel, y);
        y+=lineHeight;
        int loops = 0;
        if (invoice.getInvoiceTypeFlag().equals(new Short("1"))){
           loops = itemTable.getRowCount();
        } else{
            loops = itemTable.getRowCount();
        }
        
        for(int i = 0; i < loops; i++){
          if(i < itemTable.getRowCount()){
//             g2d.drawString(PrintAction.addAfterSpaces(itemTable.getValueAt(i, 0).toString(),39)
//                +PrintAction.addAfterSpaces(PrintAction.rightAlignString(itemTable.getValueAt(i, 1).toString(),6), 21)
//                +PrintAction.addAfterSpaces(PrintAction.rightAlignString(itemTable.getValueAt(i, 2).toString(), 10), 24)
//                +PrintAction.addAfterSpaces(PrintAction.rightAlignString(itemTable.getValueAt(i, 3).toString(), 13), 24), 1, y);
//             }  
              
               g2d.drawString(itemTable.getValueAt(i, 0).toString(), 1, y);
               g2d.drawString(PrintAction.rightAlignString(itemTable.getValueAt(i, 1).toString(),7), quantityValue, y);
               g2d.drawString(PrintAction.rightAlignString(itemTable.getValueAt(i, 2).toString(), 10), amountValue, y);
               g2d.drawString(PrintAction.rightAlignString(itemTable.getValueAt(i, 3).toString(), 13), subTotalValue, y);
          }
              y+=lineHeight;
        }

//        int start = (pageIndex==0) ? 0:pageBreaks[pageIndex-1];
//
//        int end = (pageIndex==pageBreaks.length) ? totalOrderLine : pageBreaks[pageIndex];
//        itemTable.print(graphics);
//        for(int i=start;i<end;i++){
//            String strItem = arrOrders.get(i);
//            int nSpaceIndex = 0;
//            String fdN = "";
//            String unitPrice = "";
//            String quantity = "";
//            String totalPrice = "";
//            String finalItemLine = "";
//
//            for(int j=0;j<3;j++){
//                nSpaceIndex = strItem.indexOf(" ");
//
//                if(j==0){
//                    fdN = strItem.substring(0,nSpaceIndex);
//                }else if(j==1){
//                    unitPrice = strItem.substring(0,nSpaceIndex);
//                }else{
//                     quantity = strItem.substring(0,nSpaceIndex);
//                }
//                    strItem = strItem.substring(nSpaceIndex+1);
//            }
//            if(prin==false){
//                if(!fdN.equals("LDPoint")&&!previousFdN.equals("LDPoint")){
//                    y+=lineHeight;
//                    fdN = TextFormatter.addAfterSpaces(fdN, 12);
//
//                    unitPrice = TextFormatter.rightAlignString(unitPrice, 10);
//                    unitPrice = TextFormatter.addAfterSpaces(unitPrice, 13);
//
//                    quantity = TextFormatter.rightAlignString(quantity, 3);
//                    quantity = TextFormatter.addAfterSpaces(quantity, 7);
//
//                    totalPrice = TextFormatter.rightAlignString(strItem.trim(), 9);
//
//                    finalItemLine = fdN + unitPrice + quantity + totalPrice;
//
//                    g2d.drawString(finalItemLine, 1, y);
//                }
//            }else{
//                y+=lineHeight;
//                fdN = TextFormatter.addAfterSpaces(fdN, 12);
//
//                unitPrice = TextFormatter.rightAlignString(unitPrice, 10);
//                unitPrice = TextFormatter.addAfterSpaces(unitPrice, 13);
//
//                quantity = TextFormatter.rightAlignString(quantity, 3);
//                quantity = TextFormatter.addAfterSpaces(quantity, 7);
//
//                totalPrice = TextFormatter.rightAlignString(strItem.trim(), 9);
//
//                finalItemLine = fdN + unitPrice + quantity + totalPrice;
//
//                g2d.drawString(finalItemLine, 1, y);
            
//            }
//            y+=lineHeight;
//            String row = itemTable.getValueAt(i, 0).toString();
//            
//
//            String quantity = PrintAction.rightAlignString(itemTable.getValueAt(i, 1).toString(), 10);
//                quantity = PrintAction.addAfterSpaces(quantity, 13);
//            
//            String amount = PrintAction.rightAlignString(quantity, 3);
////                quantity = TextFormatter.addAfterSpaces(quantity, 7);
////
////                totalPrice = TextFormatter.rightAlignString(strItem.trim(), 9);
////
////                finalItemLine = fdN + unitPrice + quantity + totalPrice;
////
////                g2d.drawString(finalItemLine, 1, y);
////            previousFdN = fdN;
//        }
//        if(end==arrOrders.size()&&pageIndex==pageBreaks.length){
//            y+=lineHeight*2;
//            g2d.drawString(TextFormatter.addAfterSpaces("SUB-TOTAL:", 11)+TextFormatter.rightAlignString(lblSubTotal.getText(), 30), 1, y);
//            y+=lineHeight;
//            if(receipt.getCashCardFlg()==1){
//                g2d.drawString(TextFormatter.addAfterSpaces("CARD CHRG:", 11)+TextFormatter.rightAlignString(lblCardFee.getText(), 30), 1, y);
//                y+=lineHeight;
//            }
//            if(!lblServiceCharge.getText().equals("0.00")){
//                g2d.drawString(TextFormatter.addAfterSpaces("SRVCE CHRG:", 11)+TextFormatter.rightAlignString(lblServiceCharge.getText(), 30), 1, y);
//                y+=lineHeight;
//            }
//            if(!lblVat.getText().equals("0.00")){
//                 g2d.drawString(TextFormatter.addAfterSpaces("VAT:",11)+TextFormatter.rightAlignString(lblVat.getText(), 30), 1, y);
//                y+=lineHeight;
//            }
//            double dis = Double.parseDouble(txtDiscount.getText().replace(",",""));
//            if(dis>0){
//                g2d.drawString(TextFormatter.addAfterSpaces("DISCOUNT:", 11)+TextFormatter.rightAlignString("("+df.format(dfee)+")", 30), 1, y);
//                y+=lineHeight;
//            }
//            if(prin == true){
//                double gui = Double.parseDouble(txtGuideFee.getText().replace(",",""));
//                    if(gui>0){
//                    g2d.drawString(TextFormatter.addAfterSpaces("GUIDEFEE:", 11)+TextFormatter.rightAlignString("("+df.format(gfee)+")", 30), 1, y);
//                    y+=lineHeight;
//                }
//            }
//            y+=10;
//            g2d.setFont(fontBold);
//            g2d.drawString(PrintAction.addAfterSpaces("",78)
//                +PrintAction.addAfterSpaces("TOTAL: ", 8)+PrintAction.rightAlignString(totalValueLabel.getText(), 0), 1, y);
//        g2d.drawString(PrintAction.addAfterSpaces("",78)
//                +PrintAction.addAfterSpaces("TOTAL: ", 8)+PrintAction.rightAlignString(totalValueLabel.getText(), 0), 1, y);
        g2d.drawString("Total: ", totalLabel, y);
        g2d.drawString(PrintAction.rightAlignString(totalValueLabel.getText(), 13), totalValue, y);
        
        y+=lineHeight*3;            
//        y+=lineHeight*2;                       
//            g2d.drawString(PrintAction.addAfterSpaces("Cashier: "+invoice.getInvoiceAddUser(),64)+"APPROVED BY:: ", 1, y);
//        y+=lineHeight;
        g2d.drawString("Cashier: "+invoice.getInvoiceAddUser(), 1, y);
        g2d.drawString("  _______________________________", 35, y);
        g2d.drawString("Approved By: ", 345, y);
//        g2d.drawString(PrintAction.rightAlignString(totalValueLabel.getText(), 13), 425, y);
        g2d.drawString("  _______________________________", 400, y);
        y+=lineHeight*2;            
                   
//        g2d.drawString(PrintAction.addAfterSpaces("Driver:     ___________________________",64)+"RECEIVED", 1, y);
//            g2d.drawString(PrintAction.addAfterSpaces("     ",64)+"          _______________________________", 1, y);
        g2d.drawString("Driver: ", 1, y);
        g2d.drawString("  ________________________________", 30, y);
        g2d.drawString("Received By: ", 345, y);
        g2d.drawString("  _______________________________", 400, y);
                    
//            g2d.drawString(PrintAction.addAfterSpaces("TOTAL:", 11)+PrintAction.rightAlignString(totalValueLabel.getText(), 14), 1, y);
//            g2d.setFont(font);
//            y+=lineHeight+5;
//            g2d.drawString("XXXXXXXXXXXXXXXXXXXXXXXX", 1, y);
//        }
//        y+=lineHeight*2;
//        g2d.drawString("(Page "+(pageIndex+1)+" of "+(pageBreaks.length+1)+")", 1, y);
        return PAGE_EXISTS;
    }
    
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
        
        for(Returns emp: returnList){
            String fraquant = FractionAction.convertToFraction(emp.getReturnsQuantity());
           mod.addRow(new String[] {emp.getItemName()+"",fraquant+"",Formats.centavoDecimal.format(emp.getReturnsAmount())+"", Formats.centavoDecimal.format(emp.getReturnsSubTotal())});
            totalAmount += emp.getReturnsSubTotal();
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
        
//        if(transactionNumberLabel.getText().isEmpty()||transactionNumberLabel.getText() == null){
//                errorFlg = true;
//                errMsg += "* "+ErrorMessages.ERROR_TRANSACTION_NUMBER;
//        }
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
//             transactionNumberLabel.requestFocus();
//             transactionNumberLabel.setText("");
//             transactionQuantityTextField1.setText("");
//             transactionPriceTextField.setText("");
          }else{
             this.dispose();
         }
     }
     
     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddClientCancelButton;
    private javax.swing.JLabel clientAddress;
    private javax.swing.JLabel customerNameLabel;
    private javax.swing.JLabel customerNumberLabel;
    private javax.swing.JLabel dueDate;
    private javax.swing.JLabel invoiceDateTextField;
    private javax.swing.JLabel invoiceNumTextField;
    private javax.swing.JLabel itemNameLabel;
    private javax.swing.JTable itemTable;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel paymentTextField;
    private javax.swing.JLabel returnDateTextField;
    private javax.swing.JLabel returnNumTextField;
    private javax.swing.JLabel supplierLabel;
    private javax.swing.JLabel supplierNumberLabel;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JLabel totalValueLabel;
    // End of variables declaration//GEN-END:variables
}
