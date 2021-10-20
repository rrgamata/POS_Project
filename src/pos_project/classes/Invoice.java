/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pos_project.classes;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cif3r
 */
@Entity
@Table(name = "invoice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invoice.findAll", query = "SELECT i FROM Invoice i"),
    @NamedQuery(name = "Invoice.findByInvoiceId", query = "SELECT i FROM Invoice i WHERE i.invoiceId = :invoiceId"),
    @NamedQuery(name = "Invoice.findByInvoiceNumber", query = "SELECT i FROM Invoice i WHERE i.invoiceNumber = :invoiceNumber"),
    @NamedQuery(name = "Invoice.findByInvoiceClientNumber", query = "SELECT i FROM Invoice i WHERE i.invoiceClientNumber = :invoiceClientNumber"),
    @NamedQuery(name = "Invoice.findByInvoiceDate", query = "SELECT i FROM Invoice i WHERE i.invoiceDate = :invoiceDate"),
    @NamedQuery(name = "Invoice.findByInvoicePaymentType", query = "SELECT i FROM Invoice i WHERE i.invoicePaymentType = :invoicePaymentType"),
    @NamedQuery(name = "Invoice.findByInvoiceTotalPrice", query = "SELECT i FROM Invoice i WHERE i.invoiceTotalPrice = :invoiceTotalPrice"),
    @NamedQuery(name = "Invoice.findByInvoiceCurrentBalance", query = "SELECT i FROM Invoice i WHERE i.invoiceCurrentBalance = :invoiceCurrentBalance"),
    @NamedQuery(name = "Invoice.findByInvoiceDueDate", query = "SELECT i FROM Invoice i WHERE i.invoiceDueDate = :invoiceDueDate"),
    @NamedQuery(name = "Invoice.findByInvoiceReceivableFlag", query = "SELECT i FROM Invoice i WHERE i.invoiceReceivableFlag = :invoiceReceivableFlag"),
    @NamedQuery(name = "Invoice.findByInvoiceTypeFlag", query = "SELECT i FROM Invoice i WHERE i.invoiceTypeFlag = :invoiceTypeFlag")})
public class Invoice implements Serializable {
    @Column(name = "invoice_salesperson_id")
    private Integer invoiceSalespersonId;
    @Column(name = "invoice_dm_flag")
    private Short invoiceDmFlag;
    @Column(name = "invoice_remarks")
    private String invoiceRemarks;
    @Column(name = "invoice_driver")
    private String invoiceDriver;
    @Column(name = "invoice_transfer_flag")
    private Short invoiceTransferFlag;
    @Column(name = "invoice_location_id")
    private Integer invoiceLocationId;
    @Column(name =     "invoice_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date invoiceDate;
    @Column(name =     "invoice_due_date")
    @Temporal(TemporalType.DATE)
    private Date invoiceDueDate;
    @Column(name =     "invoice_date_as_of")
    @Temporal(TemporalType.TIMESTAMP)
    private Date invoiceDateAsOf;
    @Column(name =     "invoice_add_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date invoiceAddDate;
    @Column(name = "invoice_edit_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date invoiceEditDate;
    @Column(name = "invoice_del_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date invoiceDelDate;
    @Column(name = "invoice_add_user")
    private String invoiceAddUser;
    @Column(name = "invoice_edit_user")
    private String invoiceEditUser;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "invoice_id")
    private Integer invoiceId;
    @Column(name = "invoice_number")
    private String invoiceNumber;
    @Column(name = "invoice_client_number")
    private Integer invoiceClientNumber;
    @Column(name = "invoice_payment_type")
    private Short invoicePaymentType;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "invoice_total_price")
    private Double invoiceTotalPrice;
    @Column(name = "invoice_current_balance")
    private Double invoiceCurrentBalance;
    @Column(name = "invoice_receivable_flag")
    private Short invoiceReceivableFlag;
    @Column(name = "invoice_type_flag")
    private Short invoiceTypeFlag;
     @Column(name = "invoice_paid_flag")
    private Short invoicePaidFlag;
        @Column(name = "invoice_del_flag")
    private Short invoiceDelFlag;
    private String clientName;
    private Double quantity;
    private Double quantityAsOf;
    private Double price;
    private int clientId;
    private String clientAddress;
    private String clientNumber;
    private Double creditLimit;
    private Double payments;
    private Short clientSubType;
    

    public Invoice() {
    }

    public Invoice(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Integer getInvoiceClientNumber() {
        return invoiceClientNumber;
    }

    public void setInvoiceClientNumber(Integer invoiceClientNumber) {
        this.invoiceClientNumber = invoiceClientNumber;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Short getInvoicePaymentType() {
        return invoicePaymentType;
    }

    public void setInvoicePaymentType(Short invoicePaymentType) {
        this.invoicePaymentType = invoicePaymentType;
    }

    public Double getInvoiceTotalPrice() {
        return invoiceTotalPrice;
    }

    public void setInvoiceTotalPrice(Double invoiceTotalPrice) {
        this.invoiceTotalPrice = invoiceTotalPrice;
    }

    public Double getInvoiceCurrentBalance() {
        return invoiceCurrentBalance;
    }

    public void setInvoiceCurrentBalance(Double invoiceCurrentBalance) {
        this.invoiceCurrentBalance = invoiceCurrentBalance;
    }

    public Date getInvoiceDueDate() {
        return invoiceDueDate;
    }

    public void setInvoiceDueDate(Date invoiceDueDate) {
        this.invoiceDueDate = invoiceDueDate;
    }

    public Short getInvoiceReceivableFlag() {
        return invoiceReceivableFlag;
    }

    public void setInvoiceReceivableFlag(Short invoiceReceivableFlag) {
        this.invoiceReceivableFlag = invoiceReceivableFlag;
    }

    public Short getInvoiceTypeFlag() {
        return invoiceTypeFlag;
    }

    public void setInvoiceTypeFlag(Short invoiceTypeFlag) {
        this.invoiceTypeFlag = invoiceTypeFlag;
    }
    
     public Short getInvoicePaidFlag() {
        return invoicePaidFlag;
    }

    public void setInvoicePaidFlag(Short invoicePaidFlag) {
        this.invoicePaidFlag = invoicePaidFlag;
    }
    
      public Short getInvoiceDelFlag() {
        return invoiceDelFlag;
    }

    public void setInvoiceDelFlag(Short invoiceDelFlag) {
        this.invoiceDelFlag = invoiceDelFlag;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invoiceId != null ? invoiceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invoice)) {
            return false;
        }
        Invoice other = (Invoice) object;
        if ((this.invoiceId == null && other.invoiceId != null) || (this.invoiceId != null && !this.invoiceId.equals(other.invoiceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pos_project.classes.Invoice[ invoiceId=" + invoiceId + " ]";
    }

    /**
     * @return the clientName
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * @param clientName the clientName to set
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
    
    public static ArrayList<Invoice> getInvoiceList(){
        ArrayList<Invoice> invoices = new ArrayList<Invoice>();
        try{
            Connection con = SQLConnection.getSQLConnection();
            Statement stmt = con.createStatement();
            String sql = SqlStatements.SELECT_ALL_INVOICE;
//            System.out.print(sql);
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                Invoice invoice = new Invoice();
                invoice.setInvoiceId(rs.getInt("invoice_id"));
                invoice.setClientName(rs.getString("client_name"));
//                invoice.setSupplierName(rs.getString("supplier_name"));
//                invoice.setItemName(rs.getString("item_name"));
//                invoice.setItemPrice(rs.getDouble("item_price"));
//                invoice.setInvoicePrice(rs.getDouble("invoice_price"));
//                invoice.setInvoiceQuantity(rs.getInt("invoice_quantity"));
                invoice.setInvoiceTotalPrice(rs.getDouble("invoice_total_price"));
                invoice.setInvoiceDate(rs.getTimestamp("invoice_date"));
                invoice.setInvoiceDueDate(rs.getDate("invoice_due_date"));
                invoice.setInvoiceTypeFlag(rs.getShort("invoice_type_flag"));
                invoice.setInvoiceReceivableFlag(rs.getShort("invoice_receivable_flag"));
                invoice.setInvoicePaymentType(rs.getShort("invoice_payment_type"));
                invoice.setInvoiceNumber(rs.getString("invoice_number"));
                invoice.setInvoiceAddDate(rs.getTimestamp("invoice_add_date"));
                invoice.setInvoiceEditDate(rs.getTimestamp("invoice_edit_date"));
                invoice.setInvoiceAddUser(rs.getString("add_user"));
                invoice.setInvoiceEditUser(rs.getString("edit_user"));
                invoices.add(invoice);
            }

            rs.close();
            stmt.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
//            e.getMessage();
        }
        return invoices;
    }
    
    public static ArrayList<Invoice> getInvoiceListWithDates(String from, String to){
        ArrayList<Invoice> invoices = new ArrayList<Invoice>();
        try{
            Connection con = SQLConnection.getSQLConnection();
//            Statement stmt = con.createStatement();
            String sql = SqlStatements.SELECT_ALL_INVOICE_BETWEEN;
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, from);
            prepStatement.setString(2, to);
            System.out.println(prepStatement);
//            System.out.print(sql);
            ResultSet rs = prepStatement.executeQuery();

            while(rs.next()){
                Invoice invoice = new Invoice();
                invoice.setInvoiceId(rs.getInt("invoice_id"));
                invoice.setClientName(rs.getString("client_name"));
//                invoice.setSupplierName(rs.getString("supplier_name"));
//                invoice.setItemName(rs.getString("item_name"));
//                invoice.setItemPrice(rs.getDouble("item_price"));
//                invoice.setInvoicePrice(rs.getDouble("invoice_price"));
//                invoice.setInvoiceQuantity(rs.getInt("invoice_quantity"));
                invoice.setInvoiceTotalPrice(rs.getDouble("invoice_total_price"));
                invoice.setInvoiceDate(rs.getTimestamp("invoice_date"));
                invoice.setInvoiceDueDate(rs.getDate("invoice_due_date"));
                invoice.setInvoiceTypeFlag(rs.getShort("invoice_type_flag"));
                invoice.setInvoiceReceivableFlag(rs.getShort("invoice_receivable_flag"));
                invoice.setInvoicePaymentType(rs.getShort("invoice_payment_type"));
                invoice.setInvoiceNumber(rs.getString("invoice_number"));
                invoice.setInvoiceAddDate(rs.getTimestamp("invoice_add_date"));
                invoice.setInvoiceEditDate(rs.getTimestamp("invoice_edit_date"));
                invoice.setInvoiceAddUser(rs.getString("add_user"));
                invoice.setInvoiceEditUser(rs.getString("edit_user"));
                invoices.add(invoice);
            }

            rs.close();
            prepStatement.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
//            e.getMessage();
        }
        return invoices;
    }
    
    public static ArrayList<Invoice> getInvoiceListWithNumber(String itemNumber){
        ArrayList<Invoice> invoices = new ArrayList<Invoice>();
        try{
            Connection con = SQLConnection.getSQLConnection();
//            Statement stmt = con.createStatement();
            String sql = SqlStatements.SELECT_ALL_INVOICE_WITH_NUMBER;
//            System.out.print(sql);
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, itemNumber);
            System.out.println(prepStatement);
            ResultSet rs = prepStatement.executeQuery();
            while(rs.next()){
                Invoice invoice = new Invoice();
                invoice.setInvoiceId(rs.getInt("invoice_id"));
                invoice.setClientName(rs.getString("client_name"));
//                invoice.setSupplierName(rs.getString("supplier_name"));
//                invoice.setItemName(rs.getString("item_name"));
//                invoice.setItemPrice(rs.getDouble("item_price"));
//                invoice.setInvoicePrice(rs.getDouble("invoice_price"));
//                invoice.setInvoiceQuantity(rs.getInt("invoice_quantity"));
                invoice.setInvoiceTotalPrice(rs.getDouble("invoice_total_price"));
                invoice.setInvoiceDate(rs.getTimestamp("invoice_date"));
                invoice.setInvoiceDueDate(rs.getDate("invoice_due_date"));
                invoice.setInvoiceTypeFlag(rs.getShort("invoice_type_flag"));
                invoice.setInvoiceReceivableFlag(rs.getShort("invoice_receivable_flag"));
                invoice.setInvoicePaymentType(rs.getShort("invoice_payment_type"));
                invoice.setInvoiceNumber(rs.getString("invoice_number"));
                invoice.setInvoiceAddDate(rs.getTimestamp("invoice_add_date"));
                invoice.setInvoiceEditDate(rs.getTimestamp("invoice_edit_date"));
                invoice.setInvoiceAddUser(rs.getString("add_user"));
                invoice.setInvoiceEditUser(rs.getString("edit_user"));
                invoices.add(invoice);
            }

            rs.close();
            prepStatement.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
//            e.getMessage();
        }
        return invoices;
    }
    
    public static int getInvoiceCountWithNumber(String itemNumber){
//        ArrayList<Invoice> invoices = new ArrayList<Invoice>();
        int invoiceCount = 0;
        try{
            Connection con = SQLConnection.getSQLConnection();
//            Statement stmt = con.createStatement();
            String sql = SqlStatements.COUNT_ALL_INVOICE_WITH_NUMBER;
//            sql.replace("n.*,IFNULL(n.invoice_edit_user,'-')AS edit_user,IFNULL(n.invoice_add_user,'-')AS add_user,c.client_name", "Count(*) as number");
//            System.out.print(sql);
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, itemNumber);
            System.out.println(prepStatement);
            ResultSet rs = prepStatement.executeQuery();
            
            
            while(rs.next()){
                invoiceCount = rs.getInt("number");
//                Invoice invoice = new Invoice();
//                invoice.setInvoiceId(rs.getInt("invoice_id"));
//                invoice.setClientName(rs.getString("client_name"));
////                invoice.setSupplierName(rs.getString("supplier_name"));
////                invoice.setItemName(rs.getString("item_name"));
////                invoice.setItemPrice(rs.getDouble("item_price"));
////                invoice.setInvoicePrice(rs.getDouble("invoice_price"));
////                invoice.setInvoiceQuantity(rs.getInt("invoice_quantity"));
//                invoice.setInvoiceTotalPrice(rs.getDouble("invoice_total_price"));
//                invoice.setInvoiceDate(rs.getTimestamp("invoice_date"));
//                invoice.setInvoiceDueDate(rs.getDate("invoice_due_date"));
//                invoice.setInvoiceTypeFlag(rs.getShort("invoice_type_flag"));
//                invoice.setInvoiceReceivableFlag(rs.getShort("invoice_receivable_flag"));
//                invoice.setInvoicePaymentType(rs.getShort("invoice_payment_type"));
//                invoice.setInvoiceNumber(rs.getString("invoice_number"));
//                invoice.setInvoiceAddDate(rs.getTimestamp("invoice_add_date"));
//                invoice.setInvoiceEditDate(rs.getTimestamp("invoice_edit_date"));
//                invoice.setInvoiceAddUser(rs.getString("add_user"));
//                invoice.setInvoiceEditUser(rs.getString("edit_user"));
//                invoices.add(invoice);
            }

            rs.close();
            prepStatement.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
//            e.getMessage();
        }
        return invoiceCount;
    }
    
    public static ArrayList<Invoice> getDebitMemoList(){
        ArrayList<Invoice> invoices = new ArrayList<Invoice>();
        try{
            Connection con = SQLConnection.getSQLConnection();
            Statement stmt = con.createStatement();
            String sql = SqlStatements.SELECT_ALL_DEBIT_MEMO;
            System.out.print(sql);
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                Invoice invoice = new Invoice();
                invoice.setInvoiceId(rs.getInt("invoice_id"));
                invoice.setClientName(rs.getString("client_name"));
//                invoice.setSupplierName(rs.getString("supplier_name"));
//                invoice.setItemName(rs.getString("item_name"));
//                invoice.setItemPrice(rs.getDouble("item_price"));
//                invoice.setInvoicePrice(rs.getDouble("invoice_price"));
//                invoice.setInvoiceQuantity(rs.getInt("invoice_quantity"));
                invoice.setInvoiceTotalPrice(rs.getDouble("invoice_total_price"));
                invoice.setInvoiceDate(rs.getTimestamp("invoice_date"));
                invoice.setInvoiceDueDate(rs.getDate("invoice_due_date"));
                invoice.setInvoiceTypeFlag(rs.getShort("invoice_type_flag"));
                invoice.setInvoiceReceivableFlag(rs.getShort("invoice_receivable_flag"));
                invoice.setInvoicePaymentType(rs.getShort("invoice_payment_type"));
                invoice.setInvoiceNumber(rs.getString("invoice_number"));
                invoice.setInvoiceAddDate(rs.getTimestamp("invoice_add_date"));
                invoice.setInvoiceEditDate(rs.getTimestamp("invoice_edit_date"));
                invoice.setInvoiceAddUser(rs.getString("add_user"));
                invoice.setInvoiceEditUser(rs.getString("edit_user"));
                invoices.add(invoice);
            }

            rs.close();
            stmt.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
//            e.getMessage();
        }
        return invoices;
    }
    
    public static ArrayList<Invoice> getInvoiceList(String fromDate, String toDate){
        ArrayList<Invoice> invoices = new ArrayList<Invoice>();
        try{
            Connection con = SQLConnection.getSQLConnection();
            Statement stmt = con.createStatement();
            String sql = SqlStatements.SELECT_ALL_DAILY_SALES_REPORT;
//            System.out.print(sql);
             PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, fromDate);
            prepStatement.setString(2 , toDate);
            
            
            
//            result = prepStatement.executeUpdate();
            
            System.out.println(prepStatement);
            ResultSet rs = prepStatement.executeQuery();

            while(rs.next()){
                Invoice invoice = new Invoice();
                invoice.setInvoiceId(rs.getInt("invoice_id"));
                invoice.setClientName(rs.getString("client_name"));
//                invoice.setSupplierName(rs.getString("supplier_name"));
//                invoice.setItemName(rs.getString("item_name"));
//                invoice.setItemPrice(rs.getDouble("item_price"));
//                invoice.setInvoicePrice(rs.getDouble("invoice_price"));
//                invoice.setInvoiceQuantity(rs.getInt("invoice_quantity"));
                invoice.setInvoiceTotalPrice(rs.getDouble("invoice_total_price"));
                invoice.setInvoiceDate(rs.getTimestamp("invoice_date"));
                invoice.setInvoiceDueDate(rs.getDate("invoice_due_date"));
                invoice.setInvoiceTypeFlag(rs.getShort("invoice_type_flag"));
                invoice.setInvoiceReceivableFlag(rs.getShort("invoice_receivable_flag"));
                invoice.setInvoicePaymentType(rs.getShort("invoice_payment_type"));
                invoice.setInvoiceNumber(rs.getString("invoice_number"));
                invoice.setInvoiceAddDate(rs.getTimestamp("invoice_add_date"));
                invoice.setInvoiceEditDate(rs.getTimestamp("invoice_edit_date"));
                invoice.setInvoiceAddUser(rs.getString("add_user"));
                invoice.setInvoiceEditUser(rs.getString("edit_user"));
                invoices.add(invoice);
            }

            rs.close();
            stmt.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
//            e.getMessage();
        }
        return invoices;
    }
    
    public static ArrayList<Invoice> getOtcList(String fromDate, String toDate){
        ArrayList<Invoice> invoices = new ArrayList<Invoice>();
        try{
            Connection con = SQLConnection.getSQLConnection();
            Statement stmt = con.createStatement();
            String sql = SqlStatements.SELECT_ALL_DAILY_OTC_REPORT;
//            System.out.print(sql);
             PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, fromDate);
            prepStatement.setString(2 , toDate);
            
            
            
//            result = prepStatement.executeUpdate();
            
            System.out.println(prepStatement);
            ResultSet rs = prepStatement.executeQuery();

            while(rs.next()){
                Invoice invoice = new Invoice();
                invoice.setInvoiceId(rs.getInt("invoice_id"));
                invoice.setClientName(rs.getString("client_name"));
//                invoice.setSupplierName(rs.getString("supplier_name"));
//                invoice.setItemName(rs.getString("item_name"));
//                invoice.setItemPrice(rs.getDouble("item_price"));
//                invoice.setInvoicePrice(rs.getDouble("invoice_price"));
//                invoice.setInvoiceQuantity(rs.getInt("invoice_quantity"));
                invoice.setInvoiceTotalPrice(rs.getDouble("invoice_total_price"));
                invoice.setInvoiceDate(rs.getTimestamp("invoice_date"));
                invoice.setInvoiceDueDate(rs.getDate("invoice_due_date"));
                invoice.setInvoiceTypeFlag(rs.getShort("invoice_type_flag"));
                invoice.setInvoiceReceivableFlag(rs.getShort("invoice_receivable_flag"));
                invoice.setInvoicePaymentType(rs.getShort("invoice_payment_type"));
                invoice.setInvoiceNumber(rs.getString("invoice_number"));
                invoice.setInvoiceAddDate(rs.getTimestamp("invoice_add_date"));
                invoice.setInvoiceEditDate(rs.getTimestamp("invoice_edit_date"));
                invoice.setInvoiceAddUser(rs.getString("add_user"));
                invoice.setInvoiceEditUser(rs.getString("edit_user"));
                invoices.add(invoice);
            }

            rs.close();
            stmt.close();
            prepStatement.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
//            e.getMessage();
        }
        return invoices;
    }
    
    
    public static int addInInvoice(Invoice c){
        int result = -1;
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.INSERT_IN_INVOICE;
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, c.getInvoiceNumber());
            prepStatement.setInt(2, c.getInvoiceClientNumber());
            prepStatement.setString(3 ,Formats.dateFormatSeconds.format(c.getInvoiceDate()));
            prepStatement.setShort(4, c.getInvoicePaymentType());
            prepStatement.setDouble(5, c.getInvoiceTotalPrice());
            prepStatement.setDouble(6, c.getInvoiceCurrentBalance());
            prepStatement.setString(7, Formats.dateFormatDays.format(c.getInvoiceDueDate()));
            prepStatement.setShort(8, c.getInvoiceReceivableFlag());
            prepStatement.setShort(9, c.getInvoicePaidFlag());
            
            
            result = prepStatement.executeUpdate();
            
            prepStatement.close();
            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
    
    public static int addInInvoice(Invoice c, Connection con) throws SQLException{
        int result = -1;
//        try{
//            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.INSERT_IN_INVOICE;
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, c.getInvoiceNumber());
            prepStatement.setInt(2, c.getInvoiceClientNumber());
            prepStatement.setString(3 ,Formats.dateFormatSeconds.format(c.getInvoiceDate()));
            prepStatement.setShort(4, c.getInvoicePaymentType());
            prepStatement.setDouble(5, c.getInvoiceTotalPrice());
            prepStatement.setDouble(6, c.getInvoiceCurrentBalance());
            prepStatement.setString(7, Formats.dateFormatDays.format(c.getInvoiceDueDate()));
            prepStatement.setShort(8, c.getInvoiceReceivableFlag());
            prepStatement.setShort(9, c.getInvoicePaidFlag());
            prepStatement.setString(10, Formats.dateFormatDays.format(c.getInvoiceAddDate()));
            prepStatement.setString(11, c.getInvoiceAddUser());
            
            result = prepStatement.executeUpdate();
            
            prepStatement.close();
//            con.close();
//        }catch(Exception e){
////            System.out.println(e.getMessage());
//            e.printStackTrace();
//            try {
//                con.rollback();
//            } catch (SQLException ex) {
//                Logger.getLogger(Invoice.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
        return result;
    }
    
    public static int addOutInvoice(Invoice c){
        int result = -1;
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.INSERT_OUT_INVOICE;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, c.getInvoiceNumber());
            prepStatement.setInt(2, c.getInvoiceClientNumber());
            
            prepStatement.setString(3 ,Formats.dateFormatSeconds.format(c.getInvoiceDate()));
            prepStatement.setShort(4, c.getInvoicePaymentType());
            prepStatement.setDouble(5, c.getInvoiceTotalPrice());
            prepStatement.setDouble(6, c.getInvoiceCurrentBalance());
            prepStatement.setString(7, Formats.dateFormatDays.format(c.getInvoiceDueDate()));
            prepStatement.setShort(8, c.getInvoiceReceivableFlag());
            prepStatement.setShort(9, c.getInvoicePaidFlag());
            
            
            
            
            result = prepStatement.executeUpdate();
            
            prepStatement.close();
            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
    
    public static int addOutInvoice(Invoice c, Connection con){
        int result = -1;
        try{
//            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.INSERT_OUT_INVOICE;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, c.getInvoiceNumber());
            prepStatement.setInt(2, c.getInvoiceClientNumber());
            
            prepStatement.setString(3 ,Formats.dateFormatSeconds.format(c.getInvoiceDate()));
            prepStatement.setShort(4, c.getInvoicePaymentType());
            prepStatement.setDouble(5, c.getInvoiceTotalPrice());
            prepStatement.setDouble(6, c.getInvoiceCurrentBalance());
            prepStatement.setString(7, Formats.dateFormatDays.format(c.getInvoiceDueDate()));
            prepStatement.setShort(8, c.getInvoiceReceivableFlag());
            prepStatement.setShort(9, c.getInvoicePaidFlag());
            prepStatement.setString(10, Formats.dateFormatDays.format(c.getInvoiceAddDate()));
            prepStatement.setString(11, c.getInvoiceAddUser());
            
            
            
            
            result = prepStatement.executeUpdate();
            
            prepStatement.close();
//            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(Invoice.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
    
    public static int addInvoice(Invoice c, Connection con){
        int result = -1;
        try{
//            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.INSERT_INVOICE;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, c.getInvoiceNumber());
            prepStatement.setInt(2, c.getInvoiceClientNumber());
            
            prepStatement.setString(3 ,Formats.dateFormatSeconds.format(c.getInvoiceDate()));
            prepStatement.setShort(4, c.getInvoicePaymentType());
            prepStatement.setDouble(5, c.getInvoiceTotalPrice());
            prepStatement.setDouble(6, c.getInvoiceCurrentBalance());
            prepStatement.setString(7, Formats.dateFormatDays.format(c.getInvoiceDueDate()));
            prepStatement.setShort(8, c.getInvoiceReceivableFlag());
            prepStatement.setShort(9, c.getInvoiceTypeFlag());
            prepStatement.setShort(10, c.getInvoicePaidFlag());
            prepStatement.setString(11, Formats.dateFormatDays.format(c.getInvoiceAddDate()));
            prepStatement.setString(12, c.getInvoiceAddUser());
            prepStatement.setInt(13, c.getInvoiceLocationId());
            prepStatement.setString(14, c.getInvoiceDriver());
            prepStatement.setObject(15, c.getInvoiceSalespersonId());
            
            
            
            
            result = prepStatement.executeUpdate();
            
            prepStatement.close();
//            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(Invoice.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
    
    public static int addInvoiceRemarks(Invoice c, Connection con){
        int result = -1;
        try{
//            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.INSERT_INVOICE_REMARKS;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, c.getInvoiceNumber());
            prepStatement.setInt(2, c.getInvoiceClientNumber());
            
            prepStatement.setString(3 ,Formats.dateFormatSeconds.format(c.getInvoiceDate()));
            prepStatement.setShort(4, c.getInvoicePaymentType());
            prepStatement.setDouble(5, c.getInvoiceTotalPrice());
            prepStatement.setDouble(6, c.getInvoiceCurrentBalance());
            prepStatement.setString(7, Formats.dateFormatDays.format(c.getInvoiceDueDate()));
            prepStatement.setShort(8, c.getInvoiceReceivableFlag());
            prepStatement.setShort(9, c.getInvoiceTypeFlag());
            prepStatement.setShort(10, c.getInvoicePaidFlag());
            prepStatement.setString(11, Formats.dateFormatDays.format(c.getInvoiceAddDate()));
            prepStatement.setString(12, c.getInvoiceAddUser());
            prepStatement.setInt(13, c.getInvoiceLocationId());
            prepStatement.setString(14, c.getInvoiceDriver());
            prepStatement.setString(15, c.getInvoiceRemarks());
            
            
            
            
            result = prepStatement.executeUpdate();
            
            prepStatement.close();
//            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(Invoice.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
    
    public static int addDebitMemo(Invoice c, Connection con){
        int result = -1;
        try{
//            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.INSERT_INVOICE_DEBIT_MEMO;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, c.getInvoiceNumber());
            prepStatement.setInt(2, c.getInvoiceClientNumber());
            
            prepStatement.setString(3 ,Formats.dateFormatSeconds.format(c.getInvoiceDate()));
            prepStatement.setShort(4, c.getInvoicePaymentType());
            prepStatement.setDouble(5, c.getInvoiceTotalPrice());
            prepStatement.setDouble(6, c.getInvoiceCurrentBalance());
            prepStatement.setString(7, Formats.dateFormatDays.format(c.getInvoiceDueDate()));
            prepStatement.setShort(8, c.getInvoiceReceivableFlag());
            prepStatement.setShort(9, c.getInvoiceTypeFlag());
            prepStatement.setShort(10, c.getInvoicePaidFlag());
            prepStatement.setString(11, Formats.dateFormatDays.format(c.getInvoiceAddDate()));
            prepStatement.setString(12, c.getInvoiceAddUser());
            prepStatement.setInt(13, c.getInvoiceLocationId());
            prepStatement.setString(14, c.getInvoiceDriver());
            prepStatement.setShort(15, c.getInvoiceDmFlag());
            
            
            
            
            result = prepStatement.executeUpdate();
            
            prepStatement.close();
//            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(Invoice.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
    
    public static int addTransfer(Invoice c, Connection con){
        int result = -1;
        try{
//            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.INSERT_INVOICE_TRANSFER;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, c.getInvoiceNumber());
            prepStatement.setInt(2, c.getInvoiceClientNumber());
            
            prepStatement.setString(3 ,Formats.dateFormatSeconds.format(c.getInvoiceDate()));
            prepStatement.setShort(4, c.getInvoicePaymentType());
            prepStatement.setDouble(5, c.getInvoiceTotalPrice());
            prepStatement.setDouble(6, c.getInvoiceCurrentBalance());
            prepStatement.setString(7, Formats.dateFormatDays.format(c.getInvoiceDueDate()));
            prepStatement.setShort(8, c.getInvoiceReceivableFlag());
            prepStatement.setShort(9, c.getInvoiceTypeFlag());
            prepStatement.setShort(10, c.getInvoicePaidFlag());
            prepStatement.setString(11, Formats.dateFormatDays.format(c.getInvoiceAddDate()));
            prepStatement.setString(12, c.getInvoiceAddUser());
            prepStatement.setInt(13, c.getInvoiceLocationId());
            
            
            
            
            result = prepStatement.executeUpdate();
            
            prepStatement.close();
//            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(Invoice.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
    
    
    public static int deleteInvoice(Invoice c, Connection con){
        int result = -1;
        try{
//            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.DELETE_INVOICE;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, Formats.dateFormatDays.format(c.getInvoiceEditDate()));
            prepStatement.setString(2, c.getInvoiceEditUser());
            prepStatement.setString(3, Formats.dateFormatDays.format(c.getInvoiceDelDate()));
            prepStatement.setInt(4, c.getInvoiceId());
            result = prepStatement.executeUpdate();
            
            prepStatement.close();
//            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(Invoice.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
    
    public static int editInvoice(Invoice c, Connection con){
        int result = -1;
        try{
//            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.EDIT_INVOICE;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, c.getInvoiceNumber());
            prepStatement.setInt(2, c.getInvoiceClientNumber());
            prepStatement.setString(3 ,Formats.dateFormatSeconds.format(c.getInvoiceDate()));
            prepStatement.setShort(4, c.getInvoicePaymentType());
            prepStatement.setDouble(5, c.getInvoiceTotalPrice());
            prepStatement.setDouble(6, c.getInvoiceCurrentBalance());
            prepStatement.setString(7, Formats.dateFormatDays.format(c.getInvoiceDueDate()));
            prepStatement.setShort(8, c.getInvoiceReceivableFlag());
            prepStatement.setShort(9, c.getInvoiceTypeFlag());
            prepStatement.setShort(10, c.getInvoicePaidFlag());
            prepStatement.setInt(11, c.getInvoiceLocationId());
            prepStatement.setString(12, Formats.dateFormatDays.format(c.getInvoiceEditDate()));
            prepStatement.setString(13, c.getInvoiceEditUser());
            prepStatement.setString(14, c.getInvoiceDriver());
            prepStatement.setObject(15, c.getInvoiceSalespersonId());
            prepStatement.setInt(16, c.getInvoiceId());
            
            
            
            
            result = prepStatement.executeUpdate();
            
            prepStatement.close();
//            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(Invoice.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
    
    
    public static int getLatestInvoice(){
        int invoiceId = 0;;
        try{
            Connection con = SQLConnection.getSQLConnection();
            Statement stmt = con.createStatement();
            String sql = SqlStatements.SELECT_LATEST_INVOICE;
            System.out.print(sql);
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                invoiceId = rs.getInt("invoice_id");
            }

            rs.close();
            stmt.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
//            e.getMessage();
        }
        return invoiceId;
    }
    
    public static int getLatestInvoice(Connection con) throws SQLException{
        int invoiceId = 0;;
//        try{
//            Connection con = SQLConnection.getSQLConnection();
            Statement stmt = con.createStatement();
            String sql = SqlStatements.SELECT_LATEST_INVOICE;
            System.out.print(sql);
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                invoiceId = rs.getInt("invoice_id");
            }

            rs.close();
            stmt.close();
//            con.close();
//        }catch(Exception e){
//            e.printStackTrace();
////            e.getMessage();
//        }
        return invoiceId;
    }
    
    
     public static Invoice getInvoiceWithName(String invoiceName){
        int result = -1;
        Invoice c = new Invoice();
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.SELECT_INVOICE_WITH_NAME;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, invoiceName);
            ResultSet rs = prepStatement.executeQuery();
            while(rs.next()){
                c.setInvoiceId(rs.getInt("invoice_id"));
                c.setInvoiceNumber(rs.getString("invoice_number"));
                c.setClientName(rs.getString("client_name"));
                c.setInvoiceClientNumber(rs.getInt("invoice_client_number"));
                c.setInvoiceDate(rs.getDate("invoice_date"));
                c.setInvoiceDueDate(rs.getDate("invoice_due_date"));
                c.setInvoiceTypeFlag(rs.getShort("invoice_type_flag"));
                c.setInvoiceTotalPrice(rs.getDouble("invoice_total_price"));
                c.setInvoiceCurrentBalance(rs.getDouble("invoice_current_balance"));
                c.setInvoicePaidFlag(rs.getShort("invoice_paid_flag"));
            }
            
//            result = prepStatement.executeUpdate();
            
            prepStatement.close();
            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return c;
    }
     
     public static Invoice getInvoiceWithId(String invoiceId){
        int result = -1;
        Invoice c = new Invoice();
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.SELECT_INVOICE_WITH_ID;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, invoiceId);
            ResultSet rs = prepStatement.executeQuery();
            while(rs.next()){
                c.setInvoiceId(rs.getInt("invoice_id"));
                c.setInvoiceNumber(rs.getString("invoice_number"));
                c.setClientId(rs.getInt("client_id"));
                c.setClientName(rs.getString("client_name"));
                c.setInvoiceClientNumber(rs.getInt("invoice_client_number"));
                c.setInvoicePaymentType(rs.getShort("invoice_payment_type"));
                c.setInvoiceDate(rs.getDate("invoice_date"));
                c.setInvoiceDueDate(rs.getDate("invoice_due_date"));
                c.setInvoiceTypeFlag(rs.getShort("invoice_type_flag"));
                c.setInvoiceTotalPrice(rs.getDouble("invoice_total_price"));
                c.setInvoiceCurrentBalance(rs.getDouble("invoice_current_balance"));
                c.setInvoicePaidFlag(rs.getShort("invoice_paid_flag"));
                c.setInvoiceAddDate(rs.getTimestamp("invoice_add_date"));
                c.setInvoiceAddUser(rs.getString("invoice_add_user"));
                c.setInvoiceLocationId(rs.getInt("invoice_location_id"));
                c.setClientAddress(rs.getString("client_address"));
                c.setInvoiceDriver(rs.getString("invoice_driver"));
                c.setInvoiceDmFlag(rs.getShort("invoice_dm_flag"));
                c.setInvoiceSalespersonId(rs.getInt("invoice_salesperson_id"));
            }
            
//            result = prepStatement.executeUpdate();
            
            prepStatement.close();
            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return c;
    }
     
     public static Double getInvoiceBalance(String invoiceNumber,Connection con) throws SQLException{
        Double balance = 0.0;
        Invoice c = new Invoice();
        try{
//            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.SELECT_INVOICE_BALANCE;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, invoiceNumber);
            ResultSet rs = prepStatement.executeQuery();
            while(rs.next()){
             balance = rs.getDouble("invoice_balance");
            }
            
//            result = prepStatement.executeUpdate();
            
            prepStatement.close();
//            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return balance;
    }
     
     public static int updateInvoiceBalance(int invoiceId, Double balance, Short paidFlag, String dateUpdated){
        int result = -1;
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.UPDATE_INVOICE_BALANCE;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setDouble(1, balance);
            prepStatement.setInt(2, invoiceId);
            prepStatement.setShort(3, paidFlag);
            
            
            
            result = prepStatement.executeUpdate();
            
            prepStatement.close();
            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
     
     public static int updateInvoiceBalance(int invoiceId, Double balance, Short paidFlag, String dateUpdated, Connection con) throws SQLException{
        int result = -1;
//        try{
//            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.UPDATE_INVOICE_BALANCE;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setDouble(1, balance);
            prepStatement.setShort(2, paidFlag);
            prepStatement.setString(3, dateUpdated);
            prepStatement.setInt(4, invoiceId);
            
            
            result = prepStatement.executeUpdate();
            
            prepStatement.close();
//            con.close();
//        }catch(Exception e){
////            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
        return result;
    }
     
    public static ArrayList<Invoice> getInvoiceWithClient(int invoiceName){
//        int result = -1;
        ArrayList<Invoice> arr = new ArrayList<Invoice>();
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.SELECT_INVOICE_WITH_CLIENT;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setInt(1, invoiceName);
            System.out.println(prepStatement);
            ResultSet rs = prepStatement.executeQuery();
            
            while(rs.next()){
                Invoice c = new Invoice();
                c.setInvoiceId(rs.getInt("invoice_id"));
                c.setInvoiceNumber(rs.getString("invoice_number"));
                c.setClientName(rs.getString("client_name"));
                c.setInvoiceClientNumber(rs.getInt("invoice_client_number"));
                c.setInvoiceDate(rs.getTimestamp("invoice_date"));
                c.setInvoiceDueDate(rs.getDate("invoice_due_date"));
                c.setInvoiceTypeFlag(rs.getShort("invoice_type_flag"));
                c.setInvoiceTotalPrice(rs.getDouble("invoice_total_price"));
                c.setInvoiceCurrentBalance(rs.getDouble("invoice_current_balance"));
                c.setInvoicePaidFlag(rs.getShort("invoice_paid_flag"));
                c.setInvoiceReceivableFlag(rs.getShort("invoice_receivable_flag"));
                c.setInvoicePaymentType(rs.getShort("invoice_payment_type"));
                c.setInvoiceAddDate(rs.getTimestamp("invoice_add_date"));
                c.setInvoiceEditDate(rs.getTimestamp("invoice_edit_date"));
                c.setInvoiceAddUser(rs.getString("add_user"));
                c.setInvoiceEditUser(rs.getString("edit_user"));
                arr.add(c);
            }
            
//            result = prepStatement.executeUpdate();
            
            prepStatement.close();
            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return arr;
    }
    
    public static ArrayList<Invoice> getAllInvoice(){
//        int result = -1;
        ArrayList<Invoice> arr = new ArrayList<Invoice>();
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.SELECT_ALL_INVOICE_SEARCH;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            ResultSet rs = prepStatement.executeQuery();
            
            while(rs.next()){
                Invoice c = new Invoice();
                c.setInvoiceId(rs.getInt("invoice_id"));
                c.setInvoiceNumber(rs.getString("invoice_number"));
                c.setClientName(rs.getString("client_name"));
                c.setInvoiceClientNumber(rs.getInt("invoice_client_number"));
                c.setInvoiceDate(rs.getTimestamp("invoice_date"));
                c.setInvoiceDueDate(rs.getDate("invoice_due_date"));
                c.setInvoiceTypeFlag(rs.getShort("invoice_type_flag"));
                c.setInvoiceTotalPrice(rs.getDouble("invoice_total_price"));
                c.setInvoiceCurrentBalance(rs.getDouble("invoice_current_balance"));
                c.setInvoicePaidFlag(rs.getShort("invoice_paid_flag"));
                c.setInvoiceReceivableFlag(rs.getShort("invoice_receivable_flag"));
                c.setInvoicePaymentType(rs.getShort("invoice_payment_type"));
                c.setInvoiceAddDate(rs.getTimestamp("invoice_add_date"));
                c.setInvoiceEditDate(rs.getTimestamp("invoice_edit_date"));
                c.setInvoiceAddUser(rs.getString("invoice_add_user"));
                c.setInvoiceEditUser(rs.getString("invoice_edit_user"));
                arr.add(c);
            }
            
//            result = prepStatement.executeUpdate();
            
            prepStatement.close();
            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return arr;
    }
    
    public static ArrayList<Invoice> getAllInvoice(int i){
//        int result = -1;
        ArrayList<Invoice> arr = new ArrayList<Invoice>();
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.SELECT_ALL_INVOICE_SEARCH_WITH_TYPE;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setInt(1, i);
            ResultSet rs = prepStatement.executeQuery();
            
            while(rs.next()){
                Invoice c = new Invoice();
                c.setInvoiceId(rs.getInt("invoice_id"));
                c.setInvoiceNumber(rs.getString("invoice_number"));
                c.setClientName(rs.getString("client_name"));
                c.setInvoiceClientNumber(rs.getInt("invoice_client_number"));
                c.setInvoiceDate(rs.getTimestamp("invoice_date"));
                c.setInvoiceDueDate(rs.getDate("invoice_due_date"));
                c.setInvoiceTypeFlag(rs.getShort("invoice_type_flag"));
                c.setInvoiceTotalPrice(rs.getDouble("invoice_total_price"));
                c.setInvoiceCurrentBalance(rs.getDouble("invoice_current_balance"));
                c.setInvoicePaidFlag(rs.getShort("invoice_paid_flag"));
                c.setInvoiceReceivableFlag(rs.getShort("invoice_receivable_flag"));
                c.setInvoicePaymentType(rs.getShort("invoice_payment_type"));
                c.setInvoiceAddDate(rs.getTimestamp("invoice_add_date"));
                c.setInvoiceEditDate(rs.getTimestamp("invoice_edit_date"));
                c.setInvoiceAddUser(rs.getString("invoice_add_user"));
                c.setInvoiceEditUser(rs.getString("invoice_edit_user"));
                arr.add(c);
            }
            
//            result = prepStatement.executeUpdate();
            
            prepStatement.close();
            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return arr;
    }
    
     public static ArrayList<Invoice> getAllInvoiceWithClient(int invoiceName){
//        int result = -1;
        ArrayList<Invoice> arr = new ArrayList<Invoice>();
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.SELECT_ALL_INVOICE_WITH_CLIENT;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setInt(1, invoiceName);
            ResultSet rs = prepStatement.executeQuery();
            
            while(rs.next()){
                Invoice c = new Invoice();
                c.setInvoiceId(rs.getInt("invoice_id"));
                c.setInvoiceNumber(rs.getString("invoice_number"));
                c.setClientName(rs.getString("client_name"));
                c.setInvoiceClientNumber(rs.getInt("invoice_client_number"));
                c.setInvoiceDate(rs.getTimestamp("invoice_date"));
                c.setInvoiceDueDate(rs.getDate("invoice_due_date"));
                c.setInvoiceTypeFlag(rs.getShort("invoice_type_flag"));
                c.setInvoiceTotalPrice(rs.getDouble("invoice_total_price"));
                c.setInvoiceCurrentBalance(rs.getDouble("invoice_current_balance"));
                c.setInvoicePaidFlag(rs.getShort("invoice_paid_flag"));
                c.setInvoiceReceivableFlag(rs.getShort("invoice_receivable_flag"));
                c.setInvoicePaymentType(rs.getShort("invoice_payment_type"));
                c.setInvoiceAddDate(rs.getTimestamp("invoice_add_date"));
                c.setInvoiceEditDate(rs.getTimestamp("invoice_edit_date"));
                c.setInvoiceAddUser(rs.getString("add_user"));
                c.setInvoiceEditUser(rs.getString("edit_user"));
                arr.add(c);
            }
            
//            result = prepStatement.executeUpdate();
            
            prepStatement.close();
            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return arr;
    }
     
     public static ArrayList<Invoice> getAllInvoiceWithClientNotDebit(int invoiceName){
//        int result = -1;
        ArrayList<Invoice> arr = new ArrayList<Invoice>();
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.SELECT_ALL_INVOICE_WITH_CLIENT_NOT_DEBIT;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setInt(1, invoiceName);
            ResultSet rs = prepStatement.executeQuery();
            
            while(rs.next()){
                Invoice c = new Invoice();
                c.setInvoiceId(rs.getInt("invoice_id"));
                c.setInvoiceNumber(rs.getString("invoice_number"));
                c.setClientName(rs.getString("client_name"));
                c.setInvoiceClientNumber(rs.getInt("invoice_client_number"));
                c.setInvoiceDate(rs.getTimestamp("invoice_date"));
                c.setInvoiceDueDate(rs.getDate("invoice_due_date"));
                c.setInvoiceTypeFlag(rs.getShort("invoice_type_flag"));
                c.setInvoiceTotalPrice(rs.getDouble("invoice_total_price"));
                c.setInvoiceCurrentBalance(rs.getDouble("invoice_current_balance"));
                c.setInvoicePaidFlag(rs.getShort("invoice_paid_flag"));
                c.setInvoiceReceivableFlag(rs.getShort("invoice_receivable_flag"));
                c.setInvoicePaymentType(rs.getShort("invoice_payment_type"));
                c.setInvoiceAddDate(rs.getTimestamp("invoice_add_date"));
                c.setInvoiceEditDate(rs.getTimestamp("invoice_edit_date"));
                c.setInvoiceAddUser(rs.getString("add_user"));
                c.setInvoiceEditUser(rs.getString("edit_user"));
                arr.add(c);
            }
            
//            result = prepStatement.executeUpdate();
            
            prepStatement.close();
            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return arr;
    }
     
     
     public static ArrayList<Invoice> getAllInvoiceWithClient(int invoiceName, String fromDate, String toDate){
//        int result = -1;
        ArrayList<Invoice> arr = new ArrayList<Invoice>();
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.SELECT_ALL_INVOICE_WITH_CLIENT_DATE;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setInt(1, invoiceName);
            prepStatement.setString(2, fromDate);
            prepStatement.setString(3, toDate);
            System.out.println(prepStatement);
            ResultSet rs = prepStatement.executeQuery();
            
            while(rs.next()){
                Invoice c = new Invoice();
                c.setInvoiceId(rs.getInt("invoice_id"));
                c.setInvoiceNumber(rs.getString("invoice_number"));
                c.setClientName(rs.getString("client_name"));
                c.setInvoiceClientNumber(rs.getInt("invoice_client_number"));
                c.setInvoiceDate(rs.getTimestamp("invoice_date"));
                c.setInvoiceDueDate(rs.getDate("invoice_due_date"));
                c.setInvoiceTypeFlag(rs.getShort("invoice_type_flag"));
                c.setInvoiceTotalPrice(rs.getDouble("invoice_total_price"));
                c.setInvoiceCurrentBalance(rs.getDouble("invoice_current_balance"));
                c.setInvoicePaidFlag(rs.getShort("invoice_paid_flag"));
                c.setInvoiceReceivableFlag(rs.getShort("invoice_receivable_flag"));
                c.setInvoicePaymentType(rs.getShort("invoice_payment_type"));
                c.setInvoiceAddDate(rs.getTimestamp("invoice_add_date"));
                c.setInvoiceEditDate(rs.getTimestamp("invoice_edit_date"));
                c.setInvoiceAddUser(rs.getString("add_user"));
                c.setInvoiceEditUser(rs.getString("edit_user"));
                arr.add(c);
            }
            
//            result = prepStatement.executeUpdate();
            
            prepStatement.close();
            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return arr;
    }
     
     
     public static ArrayList<Invoice> getAllInvoiceWithSalesPerson(int invoiceName, String fromDate, String toDate){
//        int result = -1;
        ArrayList<Invoice> arr = new ArrayList<Invoice>();
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.SELECT_ALL_INVOICE_WITH_SALES_PERSON;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setInt(1, invoiceName);
            prepStatement.setString(2, fromDate);
            prepStatement.setString(3, toDate);
            System.out.println(prepStatement);
            ResultSet rs = prepStatement.executeQuery();
            
            while(rs.next()){
                Invoice c = new Invoice();
                c.setInvoiceId(rs.getInt("invoice_id"));
                c.setInvoiceNumber(rs.getString("invoice_number"));
                c.setClientName(rs.getString("client_name"));
                c.setInvoiceClientNumber(rs.getInt("invoice_client_number"));
                c.setInvoiceDate(rs.getTimestamp("invoice_date"));
                c.setInvoiceDueDate(rs.getDate("invoice_due_date"));
                c.setInvoiceTypeFlag(rs.getShort("invoice_type_flag"));
                c.setInvoiceTotalPrice(rs.getDouble("invoice_total_price"));
                c.setInvoiceCurrentBalance(rs.getDouble("invoice_current_balance"));
                c.setInvoicePaidFlag(rs.getShort("invoice_paid_flag"));
                c.setInvoiceReceivableFlag(rs.getShort("invoice_receivable_flag"));
                c.setInvoicePaymentType(rs.getShort("invoice_payment_type"));
                c.setInvoiceAddDate(rs.getTimestamp("invoice_add_date"));
                c.setInvoiceEditDate(rs.getTimestamp("invoice_edit_date"));
                c.setInvoiceAddUser(rs.getString("add_user"));
                c.setInvoiceEditUser(rs.getString("edit_user"));
                arr.add(c);
            }
            
//            result = prepStatement.executeUpdate();
            
            prepStatement.close();
            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return arr;
    }
     
     public static ArrayList<Invoice> getAllInvoiceWithDate(String date){
//        int result = -1;
        ArrayList<Invoice> arr = new ArrayList<Invoice>();
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.SELECT_ALL_INVOICE_WITH_CLIENT;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, date+"%");
            ResultSet rs = prepStatement.executeQuery();
            
            while(rs.next()){
                Invoice c = new Invoice();
                c.setInvoiceId(rs.getInt("invoice_id"));
                c.setInvoiceNumber(rs.getString("invoice_number"));
                c.setClientName(rs.getString("client_name"));
                c.setInvoiceClientNumber(rs.getInt("invoice_client_number"));
                c.setInvoiceDate(rs.getTimestamp("invoice_date"));
                c.setInvoiceDueDate(rs.getDate("invoice_due_date"));
                c.setInvoiceTypeFlag(rs.getShort("invoice_type_flag"));
                c.setInvoiceTotalPrice(rs.getDouble("invoice_total_price"));
                c.setInvoiceCurrentBalance(rs.getDouble("invoice_current_balance"));
                c.setInvoicePaidFlag(rs.getShort("invoice_paid_flag"));
                c.setInvoiceReceivableFlag(rs.getShort("invoice_receivable_flag"));
                c.setInvoicePaymentType(rs.getShort("invoice_payment_type"));
                c.setInvoiceAddDate(rs.getTimestamp("invoice_add_date"));
                c.setInvoiceEditDate(rs.getTimestamp("invoice_edit_date"));
                c.setInvoiceAddUser(rs.getString("add_user"));
                c.setInvoiceEditUser(rs.getString("edit_user"));
                arr.add(c);
            }
            
//            result = prepStatement.executeUpdate();
            
            prepStatement.close();
            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return arr;
    }
     
     public static ArrayList<Invoice> getAllInvoiceCollectionWithClient(int invoiceName){
//        int result = -1;
        ArrayList<Invoice> arr = new ArrayList<Invoice>();
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.SELECT_ALL_INVOICE_COLLECTION_WITH_CLIENT;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setInt(1, invoiceName);
            ResultSet rs = prepStatement.executeQuery();
            
            while(rs.next()){
                Invoice c = new Invoice();
                c.setInvoiceId(rs.getInt("invoice_id"));
                c.setInvoiceNumber(rs.getString("invoice_number"));
                c.setClientName(rs.getString("client_name"));
                c.setInvoiceClientNumber(rs.getInt("invoice_client_number"));
                c.setInvoiceDate(rs.getTimestamp("invoice_date"));
                c.setInvoiceDueDate(rs.getDate("invoice_due_date"));
                c.setInvoiceTypeFlag(rs.getShort("invoice_type_flag"));
                c.setInvoiceTotalPrice(rs.getDouble("invoice_total_price"));
                c.setInvoiceCurrentBalance(rs.getDouble("invoice_current_balance"));
                c.setInvoicePaidFlag(rs.getShort("invoice_paid_flag"));
                c.setInvoiceReceivableFlag(rs.getShort("invoice_receivable_flag"));
                c.setInvoicePaymentType(rs.getShort("invoice_payment_type"));
                c.setInvoiceAddDate(rs.getTimestamp("invoice_add_date"));
                c.setInvoiceEditDate(rs.getTimestamp("invoice_edit_date"));
                c.setInvoiceAddUser(rs.getString("add_user"));
                c.setInvoiceEditUser(rs.getString("edit_user"));
                arr.add(c);
            }
            
//            result = prepStatement.executeUpdate();
            
            prepStatement.close();
            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return arr;
    }
    
     public static ArrayList<Invoice> getInvoiceListWithItem(int itemId){
        int result = -1;
        ArrayList<Invoice> arr = new ArrayList<Invoice>();
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.SELECT_ITEM_LEDGER;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setInt(1, itemId);
            ResultSet rs = prepStatement.executeQuery();
            while(rs.next()){
                Invoice c = new Invoice();
                c.setInvoiceDate(rs.getDate("invoice_date"));
//                c.setInvoiceId(rs.getInt("invoice_id"));
                c.setInvoiceNumber(rs.getString("invoice_number"));
                c.setClientName(rs.getString("client_name"));
                c.setInvoiceTypeFlag(rs.getShort("invoice_type_flag"));
                c.setPrice(rs.getDouble("transaction_price"));
                c.setQuantity(rs.getDouble("transaction_quantity"));
                c.setQuantityAsOf(rs.getDouble("transaction_quantity_as_of"));
//                c.setInvoiceClientNumber(rs.getInt("invoice_client_number"));
//                c.setInvoiceDueDate(rs.getDate("invoice_due_date"));
//                c.setInvoiceCurrentBalance(rs.getDouble("invoice_current_balance"));
//                c.setInvoicePaidFlag(rs.getShort("invoice_paid_flag"));
                arr.add(c);
            }
            
//            result = prepStatement.executeUpdate();
            
            prepStatement.close();
            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return arr;
    }
     
     public static ArrayList<Invoice> getInvoiceListWithItem(int itemId, String from, String to){
        int result = -1;
        ArrayList<Invoice> arr = new ArrayList<Invoice>();
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.SELECT_ITEM_LEDGER_FROM_TO;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setInt(1, itemId);
            prepStatement.setString(2, from);
            prepStatement.setString(3, to);
            ResultSet rs = prepStatement.executeQuery();
            while(rs.next()){
                Invoice c = new Invoice();
                c.setInvoiceDate(rs.getDate("invoice_date"));
//                c.setInvoiceId(rs.getInt("invoice_id"));
                c.setInvoiceNumber(rs.getString("invoice_number"));
                c.setClientName(rs.getString("client_name"));
                c.setInvoiceTypeFlag(rs.getShort("invoice_type_flag"));
                c.setPrice(rs.getDouble("transaction_price"));
                c.setQuantity(rs.getDouble("transaction_quantity"));
                c.setQuantityAsOf(rs.getDouble("transaction_quantity_as_of"));
//                c.setInvoiceClientNumber(rs.getInt("invoice_client_number"));
//                c.setInvoiceDueDate(rs.getDate("invoice_due_date"));
//                c.setInvoiceCurrentBalance(rs.getDouble("invoice_current_balance"));
//                c.setInvoicePaidFlag(rs.getShort("invoice_paid_flag"));
                arr.add(c);
            }
            
//            result = prepStatement.executeUpdate();
            
            prepStatement.close();
            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return arr;
    }
     
     public static ArrayList<Invoice> getInvoiceListWithItem(int itemId, String from, String to, int locationId){
        int result = -1;
        ArrayList<Invoice> arr = new ArrayList<Invoice>();
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.SELECT_ITEM_LEDGER_FROM_TO_WITH_LOCATION;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setInt(1, itemId);
            prepStatement.setInt(2, locationId);
            prepStatement.setInt(3, itemId);
            prepStatement.setInt(4, locationId);
            prepStatement.setString(5, from);
            prepStatement.setString(6, to);
            System.out.println (prepStatement);
            ResultSet rs = prepStatement.executeQuery();
            while(rs.next()){
                Invoice c = new Invoice();
                c.setInvoiceDate(rs.getDate("invoice_date"));
//                c.setInvoiceId(rs.getInt("invoice_id"));
                c.setInvoiceNumber(rs.getString("invoice_number"));
                c.setClientName(rs.getString("client_name"));
                c.setInvoiceTypeFlag(rs.getShort("invoice_type_flag"));
                c.setPrice(rs.getDouble("transaction_price"));
                c.setQuantity(rs.getDouble("transaction_quantity"));
                c.setQuantityAsOf(rs.getDouble("quantity_as_of"));
                c.setInvoiceRemarks(rs.getString("invoice_remarks"));
//                c.setInvoiceClientNumber(rs.getInt("invoice_client_number"));
//                c.setInvoiceDueDate(rs.getDate("invoice_due_date"));
//                c.setInvoiceCurrentBalance(rs.getDouble("invoice_current_balance"));
//                c.setInvoicePaidFlag(rs.getShort("invoice_paid_flag"));
                arr.add(c);
            }
            
//            result = prepStatement.executeUpdate();
            
            prepStatement.close();
            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return arr;
    }
     
     public static Invoice getInvoicesWithClientPayments(int invoiceName){
//        int result = -1;
//        ArrayList<Invoice> arr = new ArrayList<Invoice>();
         Invoice c = new Invoice();
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.SELECT_INVOICE_WITH_CLIENT_PAYMENTS;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setInt(1, invoiceName);
            prepStatement.setInt(2, invoiceName);
            ResultSet rs = prepStatement.executeQuery();
            
            while(rs.next()){
                
//                c.setInvoiceId(rs.getInt("invoice_id"));
//                c.setInvoiceNumber(rs.getString("invoice_number"));
                c.setClientName(rs.getString("client_name"));
                c.setClientNumber(rs.getString("client_number"));
                c.setClientAddress(rs.getString("client_address"));
//                c.setInvoiceClientNumber(rs.getInt("invoice_client_number"));
//                c.setInvoiceDate(rs.getTimestamp("invoice_date"));
//                c.setInvoiceDueDate(rs.getDate("invoice_due_date"));
//                c.setInvoiceTypeFlag(rs.getShort("invoice_type_flag"));
                c.setInvoiceTotalPrice(rs.getDouble("grandtotal_price"));
                c.setInvoiceCurrentBalance(rs.getDouble("grandcurrent_balance"));
//                c.setInvoicePaidFlag(rs.getShort("invoice_paid_flag"));
                
                c.setPayments(rs.getDouble("grand_payments"));
                c.setCreditLimit(rs.getDouble("credit_limit"));
//                arr.add(c);
            }
            
//            result = prepStatement.executeUpdate();
            
            prepStatement.close();
            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
//        return arr;
        return c;
    }
     
     public static ArrayList<Invoice> getInvoicesWithPayments(int clientType){
//        int result = -1;
        ArrayList<Invoice> arr = new ArrayList<Invoice>();
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.SELECT_INVOICE_WITH_ALL_CLIENT_PAYMENTS;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setInt(1, clientType);
//            prepStatement.setInt(1, invoiceName);
            ResultSet rs = prepStatement.executeQuery();
            
            while(rs.next()){
                Invoice c = new Invoice();
//                c.setInvoiceId(rs.getInt("invoice_id"));
//                c.setInvoiceNumber(rs.getString("invoice_number"));
                c.setClientName(rs.getString("client_name"));
                c.setClientNumber(rs.getString("client_number"));
                c.setClientAddress(rs.getString("client_address"));
//                c.setInvoiceClientNumber(rs.getInt("invoice_client_number"));
//                c.setInvoiceDate(rs.getTimestamp("invoice_date"));
//                c.setInvoiceDueDate(rs.getDate("invoice_due_date"));
//                c.setInvoiceTypeFlag(rs.getShort("invoice_type_flag"));
                c.setInvoiceTotalPrice(rs.getDouble("grandtotal_price"));
                c.setInvoiceCurrentBalance(rs.getDouble("grandcurrent_balance"));
//                c.setInvoicePaidFlag(rs.getShort("invoice_paid_flag"));
                
                c.setPayments(rs.getDouble("grand_payments"));
                c.setCreditLimit(rs.getDouble("credit_limit"));
                c.setClientSubType(rs.getShort("client_sub_type"));
                arr.add(c);
            }
            
//            result = prepStatement.executeUpdate();
            
            prepStatement.close();
            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return arr;
    }
     
     public static ArrayList<Invoice> getInvoicesWithPaymentsSubType(int clientType, Short subType){
//        int result = -1;
        ArrayList<Invoice> arr = new ArrayList<Invoice>();
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.SELECT_INVOICE_WITH_ALL_CLIENT_PAYMENTS_SUBTYPE;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setInt(1, clientType);
            prepStatement.setShort(2, subType);
//            prepStatement.setInt(1, invoiceName);
            ResultSet rs = prepStatement.executeQuery();
            
            while(rs.next()){
                Invoice c = new Invoice();
//                c.setInvoiceId(rs.getInt("invoice_id"));
//                c.setInvoiceNumber(rs.getString("invoice_number"));
                c.setClientName(rs.getString("client_name"));
                c.setClientNumber(rs.getString("client_number"));
                c.setClientAddress(rs.getString("client_address"));
//                c.setInvoiceClientNumber(rs.getInt("invoice_client_number"));
//                c.setInvoiceDate(rs.getTimestamp("invoice_date"));
//                c.setInvoiceDueDate(rs.getDate("invoice_due_date"));
//                c.setInvoiceTypeFlag(rs.getShort("invoice_type_flag"));
                c.setInvoiceTotalPrice(rs.getDouble("grandtotal_price"));
                c.setInvoiceCurrentBalance(rs.getDouble("grandcurrent_balance"));
//                c.setInvoicePaidFlag(rs.getShort("invoice_paid_flag"));
                
                c.setPayments(rs.getDouble("grand_payments"));
                c.setCreditLimit(rs.getDouble("credit_limit"));
                c.setClientSubType(rs.getShort("client_sub_type"));
                arr.add(c);
            }
            
//            result = prepStatement.executeUpdate();
            
            prepStatement.close();
            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return arr;
    }

    /**
     * @return the quantity
     */
    public Double getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the quantityAsOf
     */
    public Double getQuantityAsOf() {
        return quantityAsOf;
    }

    /**
     * @param quantityAsOf the quantityAsOf to set
     */
    public void setQuantityAsOf(Double quantityAsOf) {
        this.quantityAsOf = quantityAsOf;
    }

    /**
     * @return the price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Double price) {
        this.price = price;
    }

//    public Date getInvoiceDate() {
//        return invoiceDate;
//    }
//
//    public void setInvoiceDate(Date invoiceDate) {
//        this.invoiceDate = invoiceDate;
//    }

//    public Date getInvoiceDueDate() {
//        return invoiceDueDate;
//    }
//
//    public void setInvoiceDueDate(Date invoiceDueDate) {
//        this.invoiceDueDate = invoiceDueDate;
//    }

    public Date getInvoiceDateAsOf() {
        return invoiceDateAsOf;
    }

    public void setInvoiceDateAsOf(Date invoiceDateAsOf) {
        this.invoiceDateAsOf = invoiceDateAsOf;
    }

    public Date getInvoiceAddDate() {
        return invoiceAddDate;
    }

    public void setInvoiceAddDate(Date invoiceAddDate) {
        this.invoiceAddDate = invoiceAddDate;
    }

    public String getInvoiceAddUser() {
        return invoiceAddUser;
    }

    public void setInvoiceAddUser(String invoiceAddUser) {
        this.invoiceAddUser = invoiceAddUser;
    }

    public Date getInvoiceEditDate() {
        return invoiceEditDate;
    }

    public void setInvoiceEditDate(Date invoiceEditDate) {
        this.invoiceEditDate = invoiceEditDate;
    }

    public String getInvoiceEditUser() {
        return invoiceEditUser;
    }

    public void setInvoiceEditUser(String invoiceEditUser) {
        this.invoiceEditUser = invoiceEditUser;
    }

    /**
     * @return the clientId
     */
    public int getClientId() {
        return clientId;
    }

    /**
     * @param clientId the clientId to set
     */
    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

//    public Date getInvoiceDate() {
//        return invoiceDate;
//    }
//
//    public void setInvoiceDate(Date invoiceDate) {
//        this.invoiceDate = invoiceDate;
//    }
//
//    public Date getInvoiceDueDate() {
//        return invoiceDueDate;
//    }
//
//    public void setInvoiceDueDate(Date invoiceDueDate) {
//        this.invoiceDueDate = invoiceDueDate;
//    }
//
//    public Date getInvoiceDateAsOf() {
//        return invoiceDateAsOf;
//    }

//    public void setInvoiceDateAsOf(Date invoiceDateAsOf) {
//        this.invoiceDateAsOf = invoiceDateAsOf;
//    }
//
//    public Date getInvoiceAddDate() {
//        return invoiceAddDate;
//    }
//
//    public void setInvoiceAddDate(Date invoiceAddDate) {
//        this.invoiceAddDate = invoiceAddDate;
//    }
//
//    public Date getInvoiceEditDate() {
//        return invoiceEditDate;
//    }

//    public void setInvoiceEditDate(Date invoiceEditDate) {
//        this.invoiceEditDate = invoiceEditDate;
//    }

    public Date getInvoiceDelDate() {
        return invoiceDelDate;
    }

    public void setInvoiceDelDate(Date invoiceDelDate) {
        this.invoiceDelDate = invoiceDelDate;
    }

    /**
     * @return the clientAddress
     */
    public String getClientAddress() {
        return clientAddress;
    }

    /**
     * @param clientAddress the clientAddress to set
     */
    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public Integer getInvoiceLocationId() {
        return invoiceLocationId;
    }

    public void setInvoiceLocationId(Integer invoiceLocationId) {
        this.invoiceLocationId = invoiceLocationId;
    }

    public Short getInvoiceTransferFlag() {
        return invoiceTransferFlag;
    }

    public void setInvoiceTransferFlag(Short invoiceTransferFlag) {
        this.invoiceTransferFlag = invoiceTransferFlag;
    }

    public String getInvoiceDriver() {
        return invoiceDriver;
    }

    public void setInvoiceDriver(String invoiceDriver) {
        this.invoiceDriver = invoiceDriver;
    }

    /**
     * @return the creditLimit
     */
    public Double getCreditLimit() {
        return creditLimit;
    }

    /**
     * @param creditLimit the creditLimit to set
     */
    public void setCreditLimit(Double creditLimit) {
        this.creditLimit = creditLimit;
    }

    /**
     * @return the payments
     */
    public Double getPayments() {
        return payments;
    }

    /**
     * @param payments the payments to set
     */
    public void setPayments(Double payments) {
        this.payments = payments;
    }

    /**
     * @return the clientNumber
     */
    public String getClientNumber() {
        return clientNumber;
    }

    /**
     * @param clientNumber the clientNumber to set
     */
    public void setClientNumber(String clientNumber) {
        this.clientNumber = clientNumber;
    }

    public String getInvoiceRemarks() {
        return invoiceRemarks;
    }

    public void setInvoiceRemarks(String invoiceRemarks) {
        this.invoiceRemarks = invoiceRemarks;
    }

    public Short getInvoiceDmFlag() {
        return invoiceDmFlag;
    }

    public void setInvoiceDmFlag(Short invoiceDmFlag) {
        this.invoiceDmFlag = invoiceDmFlag;
    }

    public Integer getInvoiceSalespersonId() {
        return invoiceSalespersonId;
    }

    public void setInvoiceSalespersonId(Integer invoiceSalespersonId) {
        this.invoiceSalespersonId = invoiceSalespersonId;
    }

    /**
     * @return the clientSubType
     */
    public Short getClientSubType() {
        return clientSubType;
    }

    /**
     * @param clientSubType the clientSubType to set
     */
    public void setClientSubType(Short clientSubType) {
        this.clientSubType = clientSubType;
    }
     
     
}
