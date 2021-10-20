/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Main_UI_prot.java
 *
 * Created on Jul 17, 2013, 7:05:24 AM
 */
package pos_project.UI;

import javax.persistence.EntityManager;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import org.eclipse.persistence.annotations.Convert;
import pos_project.classes.ErrorMessages;
import pos_project.classes.TimeClock;
import pos_project.classes.User;
import pos_project.classes.UserTypeAccess;

/**
 *
 * @author Cif3r
 */
public class MainUi extends javax.swing.JFrame {
 private int panelOpen;
 private boolean loginFlg = false;
 private User user;
    /** Creates new form MainUi */
    public MainUi() {
        initComponents();
        
        initializePanel(0);
        setDisabled();
        setInvisible();
        this.setResizable(false);
        TimeClock time = new TimeClock(lblTime1);
    }
    
    
    /**
     * initializes panel of main meu 
     */
    
    private void initializePanel(int panelFlg){
        JPanel mainPanel;
        switch(panelFlg){
            case 1: 
                    if(user.getUserType().equals(new Short("1"))){
                    mainPanel = new ClientMainUi(true);
                    } else {
                    mainPanel = new ClientMainUi();
                    }
            
                    itemButton.setSelected(false);
                    reportButton.setSelected(false);
                    arReportButton.setSelected(false);
                    userButton.setSelected(false);
                    locationButton.setSelected(false);
                    salesPersonButton.setSelected(false);
                    break;
            case 2: mainPanel = new ItemMainUi();
                    clientButton.setSelected(false);
                    reportButton.setSelected(false);
                    arReportButton.setSelected(false);
                    userButton.setSelected(false);
                    locationButton.setSelected(false);
                    salesPersonButton.setSelected(false);
                    break;
            case 3: 
//                    if(user.getUserType().equals(new Short("1"))){
//                    mainPanel = new OtherReportsMainUi(true);
//                    } else {
//                    mainPanel = new OtherReportsMainUi();
//                    }
                    mainPanel = new OtherReportsMainUi(user.getUserType());
                
                    clientButton.setSelected(false);
                    itemButton.setSelected(false);
                    arReportButton.setSelected(false);
                    userButton.setSelected(false);
                    locationButton.setSelected(false);
                    salesPersonButton.setSelected(false);
                    break;
            case 4: mainPanel = new UserMainUi();
                    clientButton.setSelected(false);
                    itemButton.setSelected(false);
                    reportButton.setSelected(false);
                    arReportButton.setSelected(false);
                    locationButton.setSelected(false);
                    salesPersonButton.setSelected(false);
                    break;
            case 5: mainPanel = new LocationMainUi();
                    clientButton.setSelected(false);
                    itemButton.setSelected(false);
                    reportButton.setSelected(false);
                    arReportButton.setSelected(false);
                    userButton.setSelected(false);
                    salesPersonButton.setSelected(false);
                    break;
            case 6: 
//                if(user.getUserType().equals(new Short("1"))){
//                    mainPanel = new AccountsReportMainUi(true);
//                } else if(user.getUserType().equals(new Short("2"))){
//                    mainPanel = new AccountsReportMainUi(false);
//                } else {
//                    mainPanel = new AccountsReportMainUi();
//                }
                    mainPanel = new AccountsReportMainUi(user.getUserType());
                    clientButton.setSelected(false);
                    itemButton.setSelected(false);
                    reportButton.setSelected(false);
                    userButton.setSelected(false);
                    locationButton.setSelected(false);
                    salesPersonButton.setSelected(false);
                    break;
                
            case 7: 
                    if(user.getUserType().equals(new Short("1"))){
                    mainPanel = new SalesPersonMainUi(true);
                    } else {
                    mainPanel = new SalesPersonMainUi();
                    }
                    clientButton.setSelected(false);
                    itemButton.setSelected(false);
                    reportButton.setSelected(false);
                    arReportButton.setSelected(false);
                    userButton.setSelected(false);
                    locationButton.setSelected(false);
                    break;
            default: 
                    clientButton.setSelected(false);
                    itemButton.setSelected(false);
                    arReportButton.setSelected(false);
                    reportButton.setSelected(false);
                    userButton.setSelected(false);
                    locationButton.setSelected(false);
                    salesPersonButton.setSelected(false);
                    mainPanel = new MainUiPanel();
                    break;
        }
        
        panelView.removeAll();
        panelView.add(mainPanel);
        panelView.validate();
        panelView.repaint();
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

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        accountSettingsButton = new javax.swing.JButton();
        loginButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lblClubName1 = new javax.swing.JLabel();
        lblWelcomeUser1 = new javax.swing.JLabel();
        lblTime1 = new javax.swing.JLabel();
        panelView = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        inButton = new javax.swing.JButton();
        outButton = new javax.swing.JButton();
        adjustButton = new javax.swing.JButton();
        paymentButton = new javax.swing.JButton();
        collectionButton = new javax.swing.JButton();
        poButton = new javax.swing.JButton();
        transferButton = new javax.swing.JButton();
        editPoButton = new javax.swing.JButton();
        editInvoiceButton = new javax.swing.JButton();
        editCollectionButton = new javax.swing.JButton();
        editTransferButton = new javax.swing.JButton();
        returnButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        userButton = new javax.swing.JToggleButton();
        clientButton = new javax.swing.JToggleButton();
        itemButton = new javax.swing.JToggleButton();
        locationButton = new javax.swing.JToggleButton();
        reportButton = new javax.swing.JToggleButton();
        arReportButton = new javax.swing.JToggleButton();
        jSeparator2 = new javax.swing.JSeparator();
        homeButton = new javax.swing.JButton();
        creditMemoButton = new javax.swing.JButton();
        debitMemoButton = new javax.swing.JButton();
        convertButton = new javax.swing.JButton();
        salesPersonButton = new javax.swing.JToggleButton();
        checkVoucherButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        accountSettingsButton.setText("Change Password");
        accountSettingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountSettingsButtonActionPerformed(evt);
            }
        });
        jPanel1.add(accountSettingsButton);

        loginButton.setText("Log-Off");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        loginButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                loginButtonKeyReleased(evt);
            }
        });
        jPanel1.add(loginButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        jPanel2.add(jPanel1, gridBagConstraints);

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        lblClubName1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblClubName1.setForeground(new java.awt.Color(255, 255, 255));
        lblClubName1.setText("POS_PROJ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel4.add(lblClubName1, gridBagConstraints);

        lblWelcomeUser1.setBackground(new java.awt.Color(255, 255, 255));
        lblWelcomeUser1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblWelcomeUser1.setForeground(new java.awt.Color(255, 255, 255));
        lblWelcomeUser1.setText("Welcome[Guest].");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel4.add(lblWelcomeUser1, gridBagConstraints);

        lblTime1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTime1.setForeground(new java.awt.Color(255, 255, 255));
        lblTime1.setText("00:00");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel4.add(lblTime1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 550);
        jPanel2.add(jPanel4, gridBagConstraints);

        panelView.setBackground(new java.awt.Color(255, 255, 255));
        panelView.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelView.setMinimumSize(new java.awt.Dimension(755, 325));
        panelView.setPreferredSize(new java.awt.Dimension(755, 528));
        panelView.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("by Crazy Innovations 2013");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(979, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setAutoscrolls(true);

        jPanel6.setAutoscrolls(true);

        jPanel7.setAutoscrolls(true);
        jPanel7.setLayout(new java.awt.GridBagLayout());

        inButton.setText("In");
        inButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel7.add(inButton, gridBagConstraints);

        outButton.setText("Out");
        outButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel7.add(outButton, gridBagConstraints);

        adjustButton.setText("Adjustments");
        adjustButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adjustButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel7.add(adjustButton, gridBagConstraints);

        paymentButton.setText("Payment");
        paymentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel7.add(paymentButton, gridBagConstraints);

        collectionButton.setText("Collection");
        collectionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                collectionButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel7.add(collectionButton, gridBagConstraints);

        poButton.setText("PO");
        poButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                poButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel7.add(poButton, gridBagConstraints);

        transferButton.setText("Transfer");
        transferButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transferButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel7.add(transferButton, gridBagConstraints);

        editPoButton.setText("Edit PO");
        editPoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editPoButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel7.add(editPoButton, gridBagConstraints);

        editInvoiceButton.setText("Edit Invoice");
        editInvoiceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editInvoiceButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel7.add(editInvoiceButton, gridBagConstraints);

        editCollectionButton.setText("Edit Collections");
        editCollectionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCollectionButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel7.add(editCollectionButton, gridBagConstraints);

        editTransferButton.setText("Edit Transfer");
        editTransferButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editTransferButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel7.add(editTransferButton, gridBagConstraints);

        returnButton.setText("Return");
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel7.add(returnButton, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 25;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel7.add(jSeparator1, gridBagConstraints);

        userButton.setText("User");
        userButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel7.add(userButton, gridBagConstraints);

        clientButton.setText("Client");
        clientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel7.add(clientButton, gridBagConstraints);

        itemButton.setText("Item");
        itemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 20;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel7.add(itemButton, gridBagConstraints);

        locationButton.setText("Location");
        locationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locationButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 21;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel7.add(locationButton, gridBagConstraints);

        reportButton.setText("Reports");
        reportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 22;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel7.add(reportButton, gridBagConstraints);

        arReportButton.setText("AR/AP Reports");
        arReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arReportButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 23;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel7.add(arReportButton, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel7.add(jSeparator2, gridBagConstraints);

        homeButton.setText("Home");
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 26;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel7.add(homeButton, gridBagConstraints);

        creditMemoButton.setText("Credit Memo");
        creditMemoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creditMemoButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel7.add(creditMemoButton, gridBagConstraints);

        debitMemoButton.setText("Debit Memo");
        debitMemoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                debitMemoButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel7.add(debitMemoButton, gridBagConstraints);

        convertButton.setText("Convert");
        convertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                convertButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel7.add(convertButton, gridBagConstraints);

        salesPersonButton.setText("SalesPerson");
        salesPersonButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salesPersonButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 19;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel7.add(salesPersonButton, gridBagConstraints);

        checkVoucherButton.setText("Check Voucher");
        checkVoucherButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkVoucherButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 24;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel7.add(checkVoucherButton, gridBagConstraints);

        jPanel6.add(jPanel7);

        jScrollPane1.setViewportView(jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1140, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelView, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void accountSettingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountSettingsButtonActionPerformed
        // TODO add your handling code here:
        if(user != null && loginFlg){
            ChangePasswordUi detailsPopUp = new ChangePasswordUi(new JFrame(), true, user);
                detailsPopUp.setLocationRelativeTo(null);
                detailsPopUp.pack();
                detailsPopUp.setVisible(true);
                if(detailsPopUp.getUser()!= null){
                    user = detailsPopUp.getUser();
                }
//                else {
//                    JOptionPane.showMessageDialog(this, ErrorMessages.ERROR_USER_NAME__NOT_FOUND, ErrorMessages.TITLE_ERROR, JOptionPane.WARNING_MESSAGE);
//                }
                initializePanel(panelOpen);
                
                
        }
        
    }//GEN-LAST:event_accountSettingsButtonActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        // TODO add your handling code here:
        if(!loginFlg){
         LoginUi detailsPopUp = new LoginUi(new JFrame(), true, true);
                detailsPopUp.setLocationRelativeTo(null);
                detailsPopUp.pack();
                detailsPopUp.setVisible(true);
                if(detailsPopUp.getUser()!= null){
                    User u = detailsPopUp.getUser();
                    lblWelcomeUser1.setText("Welcome ["+u.getUserUsername() +"].");
                    checkUserRights(u.getUserType());
                    user = detailsPopUp.getUser();
                }
//                else {
//                    JOptionPane.showMessageDialog(this, ErrorMessages.ERROR_USER_NAME__NOT_FOUND, ErrorMessages.TITLE_ERROR, JOptionPane.WARNING_MESSAGE);
//                }
                initializePanel(panelOpen);
                
                
        } else {
            int confirm = JOptionPane.showConfirmDialog(this, ErrorMessages.CONFIRM_LOGOFF_USER, ErrorMessages.TITLE_LOGOFF, JOptionPane.YES_NO_OPTION);
            if(confirm == JOptionPane.YES_OPTION){
                      setDisabled();
                      setInvisible();
                      lblWelcomeUser1.setText("Welcome [Guest].");
//                      lblTime1.setText("");
                      loginFlg = false;
                      panelOpen = 0;
                      user = null;
                      initializePanel(panelOpen);
            }
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void loginButtonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginButtonKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_loginButtonKeyReleased

    private void clientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientButtonActionPerformed
        // TODO add your handling code here:
        if(clientButton.isSelected()){
            panelOpen = 1;
        }else{
           panelOpen =0; 
        }
           initializePanel(panelOpen);
                
    }//GEN-LAST:event_clientButtonActionPerformed

    private void itemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemButtonActionPerformed
        // TODO add your handling code here:
        if(itemButton.isSelected()){
           panelOpen = 2;
        }else{
          panelOpen = 0;
        }
          initializePanel(panelOpen);
                
    }//GEN-LAST:event_itemButtonActionPerformed

    private void arReportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arReportButtonActionPerformed
        // TODO add your handling code here:
        if(arReportButton.isSelected()){
           panelOpen = 6;
        }else{
            panelOpen = 0;
        }
                
           initializePanel(panelOpen);
    }//GEN-LAST:event_arReportButtonActionPerformed

    private void inButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inButtonActionPerformed
        // TODO add your handling code here:
         int confirm = JOptionPane.showConfirmDialog(this, ErrorMessages.CONFIRM_ADD_INVOICE_PO, ErrorMessages.TITLE_INFORMATION, JOptionPane.YES_NO_OPTION);
            if(confirm == JOptionPane.YES_OPTION){
                EditUi detailsPopUp = new EditUi(this, true, 1);
                detailsPopUp.setLocationRelativeTo(null);
                detailsPopUp.pack();
                detailsPopUp.setVisible(true);
                initializePanel(panelOpen);
            } else { 
                AddIvoiceDetailsUi detailsPopUp = new AddIvoiceDetailsUi(new JFrame(),true,false);
                detailsPopUp.setLocationRelativeTo(null);
                detailsPopUp.pack();
                detailsPopUp.setVisible(true);
                initializePanel(panelOpen);
            }
        
    }//GEN-LAST:event_inButtonActionPerformed

    private void outButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outButtonActionPerformed
        // TODO add your handling code here:
         AddIvoiceDetailsUi detailsPopUp = new AddIvoiceDetailsUi(new JFrame(),true,true);
                
                detailsPopUp.setLocationRelativeTo(null);
                detailsPopUp.pack();
                detailsPopUp.setVisible(true);
                initializePanel(panelOpen);
    }//GEN-LAST:event_outButtonActionPerformed

    private void collectionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_collectionButtonActionPerformed
        // TODO add your handling code here:
          CollectionUi detailsPopUp = new CollectionUi(new JFrame(),true,true);
                
                detailsPopUp.setLocationRelativeTo(null);
                detailsPopUp.pack();
                detailsPopUp.setVisible(true);
                initializePanel(panelOpen);
    }//GEN-LAST:event_collectionButtonActionPerformed

    private void userButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userButtonActionPerformed
        // TODO add your handling code here:
                   // TODO add your handling code here:
        if(userButton.isSelected()){
            panelOpen = 4;
        }else{
           panelOpen =0; 
        }
           initializePanel(panelOpen);
    }//GEN-LAST:event_userButtonActionPerformed

    private void editInvoiceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editInvoiceButtonActionPerformed
        // TODO add your handling code here:
        
         LoginUi detailsPopUp = new LoginUi(new JFrame(), true);
                detailsPopUp.setLocationRelativeTo(null);
                detailsPopUp.pack();
                detailsPopUp.setVisible(true);
                if(detailsPopUp.getUser()!= null){
                    User u = detailsPopUp.getUser();
//                    lblWelcomeUser1.setText("Welcome ["+u.getUserUsername() +"].");
//                    checkRights(u.getUserType());
                    if(detailsPopUp.getVerification()){
                        EditUi detailsPopUp2 = new EditUi(new JFrame(), true, false);
                        detailsPopUp2.setLocationRelativeTo(null);
                        detailsPopUp2.pack();
                        detailsPopUp2.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(this,ErrorMessages.ERROR_AUTHORIZATION ,ErrorMessages.TITLE_ERROR,JOptionPane.ERROR_MESSAGE);
                    }
                }
            initializePanel(panelOpen);

//                else {
//                    JOptionPane.showMessageDialog(this, ErrorMessages.ERROR_USER_NAME__NOT_FOUND, ErrorMessages.TITLE_ERROR, JOptionPane.WARNING_MESSAGE);
//                }
                
    }//GEN-LAST:event_editInvoiceButtonActionPerformed

    private void editCollectionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCollectionButtonActionPerformed
        // TODO add your handling code here:
        LoginUi detailsPopUp = new LoginUi(new JFrame(), true);
                detailsPopUp.setLocationRelativeTo(null);
                detailsPopUp.pack();
                detailsPopUp.setVisible(true);
                if(detailsPopUp.getUser()!= null){
                    User u = detailsPopUp.getUser();
//                    lblWelcomeUser1.setText("Welcome ["+u.getUserUsername() +"].");
//                    checkRights(u.getUserType());
                    if(detailsPopUp.getVerification()){
                        EditUi detailsPopUp2 = new EditUi(new JFrame(), true, true);
                        detailsPopUp2.setLocationRelativeTo(null);
                        detailsPopUp2.pack();
                        detailsPopUp2.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(this,ErrorMessages.ERROR_AUTHORIZATION ,ErrorMessages.TITLE_ERROR,JOptionPane.ERROR_MESSAGE);
                    }
                }
            initializePanel(panelOpen);
    }//GEN-LAST:event_editCollectionButtonActionPerformed

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        // TODO add your handling code here:
        panelOpen = 0;
        initializePanel(panelOpen);
    }//GEN-LAST:event_homeButtonActionPerformed

    private void locationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locationButtonActionPerformed
        if(locationButton.isSelected()){
            panelOpen = 5;
        }else{
           panelOpen =0; 
        }
           initializePanel(panelOpen);
    }//GEN-LAST:event_locationButtonActionPerformed

    private void paymentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentButtonActionPerformed
        // TODO add your handling code here:
         CollectionUi detailsPopUp = new CollectionUi(new JFrame(),true,false);
                
                detailsPopUp.setLocationRelativeTo(null);
                detailsPopUp.pack();
                detailsPopUp.setVisible(true);
                initializePanel(panelOpen);
    }//GEN-LAST:event_paymentButtonActionPerformed

    private void transferButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transferButtonActionPerformed
        // TODO add your handling code here:
                // TODO add your handling code here:
        TransferUi detailsPopUp = new TransferUi(new JFrame(),true,true);
                detailsPopUp.setLocationRelativeTo(null);
                detailsPopUp.pack();
                detailsPopUp.setVisible(true);
                initializePanel(panelOpen);
    }//GEN-LAST:event_transferButtonActionPerformed

    private void editTransferButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editTransferButtonActionPerformed
     
        
        LoginUi detailsPopUp = new LoginUi(new JFrame(), true);
                detailsPopUp.setLocationRelativeTo(null);
                detailsPopUp.pack();
                detailsPopUp.setVisible(true);
                if(detailsPopUp.getUser()!= null){
                    User u = detailsPopUp.getUser();
//                    lblWelcomeUser1.setText("Welcome ["+u.getUserUsername() +"].");
//                    checkRights(u.getUserType());
                    if(detailsPopUp.getVerification()){
                           TransferUi detailsPopUp2 = new TransferUi(new JFrame(),true,true, true);
                                 detailsPopUp2.setLocationRelativeTo(null);
                                    detailsPopUp2.pack();
                                    detailsPopUp2.setVisible(true);
//                initializePanel(panelOpen);
                    } else {
                        JOptionPane.showMessageDialog(this,ErrorMessages.ERROR_AUTHORIZATION ,ErrorMessages.TITLE_ERROR,JOptionPane.ERROR_MESSAGE);
                    }
                }
            initializePanel(panelOpen);
     
    }//GEN-LAST:event_editTransferButtonActionPerformed

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
        // TODO add your handling code here:
        LoginUi detailsPopUp = new LoginUi(new JFrame(), true);
                detailsPopUp.setLocationRelativeTo(null);
                detailsPopUp.pack();
                detailsPopUp.setVisible(true);
                if(detailsPopUp.getUser()!= null){
                    User u = detailsPopUp.getUser();
//                    lblWelcomeUser1.setText("Welcome ["+u.getUserUsername() +"].");
//                    checkRights(u.getUserType());
                    if(detailsPopUp.getVerification()){
                        EditUi detailsPopUp2 = new EditUi(new JFrame(), true, false, true);
                        detailsPopUp2.setLocationRelativeTo(null);
                        detailsPopUp2.pack();
                        detailsPopUp2.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(this,ErrorMessages.ERROR_AUTHORIZATION ,ErrorMessages.TITLE_ERROR,JOptionPane.ERROR_MESSAGE);
                    }
                }
            initializePanel(panelOpen);
    }//GEN-LAST:event_returnButtonActionPerformed

    private void reportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportButtonActionPerformed
        // TODO add your handling code here:
         if(reportButton.isSelected()){
           panelOpen = 3;
        }else{
            panelOpen = 0;
        }
                
           initializePanel(panelOpen);
    }//GEN-LAST:event_reportButtonActionPerformed

    private void poButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_poButtonActionPerformed
        // TODO add your handling code here:
        
          PoUi detailsPopUp = new PoUi(new JFrame(),true,false);
                detailsPopUp.setLocationRelativeTo(null);
                detailsPopUp.pack();
                detailsPopUp.setVisible(true);
                initializePanel(panelOpen);
    }//GEN-LAST:event_poButtonActionPerformed

    private void editPoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editPoButtonActionPerformed
        // TODO add your handling code here:
        
        LoginUi detailsPopUp = new LoginUi(new JFrame(), true);
                detailsPopUp.setLocationRelativeTo(null);
                detailsPopUp.pack();
                detailsPopUp.setVisible(true);
                if(detailsPopUp.getUser()!= null){
                    User u = detailsPopUp.getUser();
//                    lblWelcomeUser1.setText("Welcome ["+u.getUserUsername() +"].");
//                    checkRights(u.getUserType());
                    if(detailsPopUp.getVerification()){
                        EditUi detailsPopUp2 = new EditUi(new JFrame(), true);
                        detailsPopUp2.setLocationRelativeTo(null);
                        detailsPopUp2.pack();
                        detailsPopUp2.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(this,ErrorMessages.ERROR_AUTHORIZATION ,ErrorMessages.TITLE_ERROR,JOptionPane.ERROR_MESSAGE);
                    }
                }
            initializePanel(panelOpen);
    }//GEN-LAST:event_editPoButtonActionPerformed

    private void adjustButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adjustButtonActionPerformed
        // TODO add your handling code here:
          
        LoginUi detailsPopUp = new LoginUi(new JFrame(), true);
                detailsPopUp.setLocationRelativeTo(null);
                detailsPopUp.pack();
                detailsPopUp.setVisible(true);
                if(detailsPopUp.getUser()!= null){
                    User u = detailsPopUp.getUser();
//                    lblWelcomeUser1.setText("Welcome ["+u.getUserUsername() +"].");
//                    checkRights(u.getUserType());
                    if(detailsPopUp.getVerification()){
                            AdjustmentItemUi detailsPopUp2 = new AdjustmentItemUi(new JFrame(),true);
                                detailsPopUp2.setLocationRelativeTo(null);
                                detailsPopUp2.pack();
                                detailsPopUp2.setVisible(true);
                
                    }else {
                        JOptionPane.showMessageDialog(this,ErrorMessages.ERROR_AUTHORIZATION ,ErrorMessages.TITLE_ERROR,JOptionPane.ERROR_MESSAGE);
                    }
                }
                                initializePanel(panelOpen);
    }//GEN-LAST:event_adjustButtonActionPerformed

    private void creditMemoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creditMemoButtonActionPerformed
        // TODO add your handling code here:
                // TODO add your handling code here:
         CollectionUi detailsPopUp = new CollectionUi(new JFrame(),true);
                
                detailsPopUp.setLocationRelativeTo(null);
                detailsPopUp.pack();
                detailsPopUp.setVisible(true);
                initializePanel(panelOpen);
    }//GEN-LAST:event_creditMemoButtonActionPerformed

    private void debitMemoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_debitMemoButtonActionPerformed
        // TODO add your handling code here:
        DebitMemoUi detailsPopUp = new DebitMemoUi(new JFrame(),true, true);
                
                detailsPopUp.setLocationRelativeTo(null);
                detailsPopUp.pack();
                detailsPopUp.setVisible(true);
                initializePanel(panelOpen);
    }//GEN-LAST:event_debitMemoButtonActionPerformed

    private void convertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_convertButtonActionPerformed
        // TODO add your handling code here:
           ConvertUi detailsPopUp = new ConvertUi(new JFrame(),true,true);
                detailsPopUp.setLocationRelativeTo(null);
                detailsPopUp.pack();
                detailsPopUp.setVisible(true);
                initializePanel(panelOpen);
    }//GEN-LAST:event_convertButtonActionPerformed

    private void salesPersonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesPersonButtonActionPerformed
        // TODO add your handling code here:
           if(salesPersonButton.isSelected()){
            panelOpen = 7;
        }else{
           panelOpen =0; 
        }
           initializePanel(panelOpen);
                
    }//GEN-LAST:event_salesPersonButtonActionPerformed

    private void checkVoucherButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkVoucherButtonActionPerformed
        // TODO add your handling code here:
         CheckVoucherUi detailsPopUp = new CheckVoucherUi(new JFrame(),true);
                detailsPopUp.setLocationRelativeTo(null);
                detailsPopUp.pack();
                detailsPopUp.setVisible(true);
                initializePanel(panelOpen);
    }//GEN-LAST:event_checkVoucherButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            try {
                for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())){
                        UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (Exception e) {
                // If Nimbus is not available, you can set the GUI to another look and feel.
            }
                new MainUi().setVisible(true);
            }
        });
    }
    
    
    private void setEnabled(){
        inButton.setEnabled(true);
        paymentButton.setEnabled(true);
        returnButton.setEnabled(true);
        arReportButton.setEnabled(true);
        poButton.setEnabled(true);
        homeButton.setEnabled(true);
        convertButton.setEnabled(true);
    }
    
    private void setInvisible(){
        
        editPoButton.setVisible(false);
        editTransferButton.setVisible(false);
        editInvoiceButton.setVisible(false);
        editCollectionButton.setVisible(false);
        userButton.setVisible(false);
        jSeparator1.setVisible(false);
        jSeparator2.setVisible(false);
        locationButton.setVisible(false);
        reportButton.setVisible(false);
        clientButton.setVisible(false);
        itemButton.setVisible(false);
        outButton.setVisible(false);
        collectionButton.setVisible(false);
        accountSettingsButton.setVisible(false);
        transferButton.setVisible(false);
        adjustButton.setVisible(false);
        debitMemoButton.setVisible(false);
        creditMemoButton.setVisible(false);
        salesPersonButton.setVisible(false);
        checkVoucherButton.setVisible(false);
    }
    
    private void checkRights(Short userType){
        int i = userType;
        setEnabled();
        switch(i){
            case 1 :
                reportButton.setVisible(true);
                outButton.setVisible(true);
                collectionButton.setVisible(true);
                accountSettingsButton.setVisible(true);
                transferButton.setVisible(true);
                clientButton.setVisible(true);
                itemButton.setVisible(true);
                adjustButton.setVisible(true);

                break;
           case 2 :
               
                break;
            default :
        debitMemoButton.setVisible(true);
        creditMemoButton.setVisible(true);        
        editPoButton.setVisible(true);
        editTransferButton.setVisible(true);
        editInvoiceButton.setVisible(true);
        editCollectionButton.setVisible(true);
        userButton.setVisible(true);
        jSeparator1.setVisible(true);
        jSeparator2.setVisible(true);
        locationButton.setVisible(true);
        reportButton.setVisible(true);
        clientButton.setVisible(true);
        itemButton.setVisible(true);
        outButton.setVisible(true);
        collectionButton.setVisible(true);
        accountSettingsButton.setVisible(true);
        transferButton.setVisible(true);
        adjustButton.setVisible(true);
        }
        loginButton.setText("Log-Out");
        loginFlg = true;
    }
    
     private void checkUserRights(Short userType){
        int i = userType;
        setEnabled();
        UserTypeAccess u = UserTypeAccess.getUserTypeAccess(userType);
        inButton.setVisible(u.getUserTypeIn().equals(new Short("1")));
        paymentButton.setVisible(u.getUserTypePayment().equals(new Short("1")));
        returnButton.setVisible(u.getUserTypeReport().equals(new Short("1")));
        arReportButton.setVisible(u.getUserTypeArReport().equals(new Short("1")));
        poButton.setVisible(u.getUserTypePo().equals(new Short("1")));
        homeButton.setVisible(u.getUserTypeHome().equals(new Short("1")));
        debitMemoButton.setVisible(u.getUserTypeDebitMemo().equals(new Short("1")));
        creditMemoButton.setVisible(u.getUserTypeCreditMemo().equals(new Short("1")));        
        editPoButton.setVisible(u.getUserTypeEditPoM().equals(new Short("1")));
        editTransferButton.setVisible(u.getUserTypeEditTransfer().equals(new Short("1")));
        editInvoiceButton.setVisible(u.getUserTypeEditInvoice().equals(new Short("1")));
        editCollectionButton.setVisible(u.getUserTypeEditCollection().equals(new Short("1")));
        userButton.setVisible(u.getUserTypeUser().equals(new Short("1")));
        jSeparator1.setVisible(true);
        jSeparator2.setVisible(true);
        locationButton.setVisible(u.getUserTypeLocation().equals(new Short("1")));
        reportButton.setVisible(u.getUserTypeReport().equals(new Short("1")));
        clientButton.setVisible(u.getUserTypeClient().equals(new Short("1")));
        itemButton.setVisible(u.getUserTypeItem().equals(new Short("1")));
        outButton.setVisible(u.getUserTypeOut().equals(new Short("1")));
        collectionButton.setVisible(u.getUserTypeCollection().equals(new Short("1")));
        accountSettingsButton.setVisible(u.getUserTypeAccountSettings().equals(new Short("1")));
        transferButton.setVisible(u.getUserTypeTransfer().equals(new Short("1")));
        adjustButton.setVisible(u.getUserTypeAdjust().equals(new Short("1")));
        userButton.setVisible(u.getUserTypeUser().equals(new Short("1")));
        salesPersonButton.setVisible(u.getUserTypeSalesperson().equals(new Short("1")));
       checkVoucherButton.setVisible(u.getUserTypeCheckVoucher().equals(new Short("1")));
        
        loginButton.setText("Log-Out");
        loginFlg = true;
    }
    
    private void setDisabled(){
      
//        clientButton.setVisible(false);
//        itemButton.setVisible(false);
//        arReportButton.setVisible(false);
        
        
        
//        reportButton.setEnabled(false);
//        reportButton.setVisible(false);
//        
//        clientButton.setEnabled(false);
//        itemButton.setEnabled(false);
//
//        outButton.setEnabled(false);
//        collectionButton.setEnabled(false);
//        
//        accountSettingsButton.setEnabled(false);
//        transferButton.setEnabled(false);
//        adjustButton.setEnabled(false);
        convertButton.setEnabled(false);
        homeButton.setEnabled(false);
        inButton.setEnabled(false);
        paymentButton.setEnabled(false);
        poButton.setEnabled(false);
        returnButton.setEnabled(false);
        arReportButton.setEnabled(false);
        
//        editPoButton.setEnabled(false);
//        editTransferButton.setEnabled(false);
        loginButton.setText("Log-In");
        
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accountSettingsButton;
    private javax.swing.JButton adjustButton;
    private javax.swing.JToggleButton arReportButton;
    private javax.swing.JButton checkVoucherButton;
    private javax.swing.JToggleButton clientButton;
    private javax.swing.JButton collectionButton;
    private javax.swing.JButton convertButton;
    private javax.swing.JButton creditMemoButton;
    private javax.swing.JButton debitMemoButton;
    private javax.swing.JButton editCollectionButton;
    private javax.swing.JButton editInvoiceButton;
    private javax.swing.JButton editPoButton;
    private javax.swing.JButton editTransferButton;
    private javax.swing.JButton homeButton;
    private javax.swing.JButton inButton;
    private javax.swing.JToggleButton itemButton;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblClubName1;
    private javax.swing.JLabel lblTime1;
    private javax.swing.JLabel lblWelcomeUser1;
    private javax.swing.JToggleButton locationButton;
    private javax.swing.JButton loginButton;
    private javax.swing.JButton outButton;
    private javax.swing.JPanel panelView;
    private javax.swing.JButton paymentButton;
    private javax.swing.JButton poButton;
    private javax.swing.JToggleButton reportButton;
    private javax.swing.JButton returnButton;
    private javax.swing.JToggleButton salesPersonButton;
    private javax.swing.JButton transferButton;
    private javax.swing.JToggleButton userButton;
    // End of variables declaration//GEN-END:variables
}
