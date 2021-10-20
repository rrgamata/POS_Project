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
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
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
@Table(name = "transaction")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transaction.findAll", query = "SELECT t FROM Transaction t"),
    @NamedQuery(name = "Transaction.findByTransactionId", query = "SELECT t FROM Transaction t WHERE t.transactionId = :transactionId"),
    @NamedQuery(name = "Transaction.findByTransactionInvoiceId", query = "SELECT t FROM Transaction t WHERE t.transactionInvoiceId = :transactionInvoiceId"),
    @NamedQuery(name = "Transaction.findByTransactionItemNumber", query = "SELECT t FROM Transaction t WHERE t.transactionItemNumber = :transactionItemNumber"),
    @NamedQuery(name = "Transaction.findByTransactionPrice", query = "SELECT t FROM Transaction t WHERE t.transactionPrice = :transactionPrice"),
    @NamedQuery(name = "Transaction.findByTransactionDate", query = "SELECT t FROM Transaction t WHERE t.transactionDate = :transactionDate"),
    @NamedQuery(name = "Transaction.findByTransactionQuantity", query = "SELECT t FROM Transaction t WHERE t.transactionQuantity = :transactionQuantity"),
    @NamedQuery(name = "Transaction.findByInvoiceTransactionFlag", query = "SELECT t FROM Transaction t WHERE t.invoiceTransactionFlag = :invoiceTransactionFlag"),
    @NamedQuery(name = "Transaction.findByTransactionDelFlag", query = "SELECT t FROM Transaction t WHERE t.transactionDelFlag = :transactionDelFlag"),
    @NamedQuery(name = "Transaction.findByTransactionDelDate", query = "SELECT t FROM Transaction t WHERE t.transactionDelDate = :transactionDelDate"),
    @NamedQuery(name = "Transaction.findByTransactionQuantityAsOf", query = "SELECT t FROM Transaction t WHERE t.transactionQuantityAsOf = :transactionQuantityAsOf")})
public class Transaction implements Serializable {
    @Column(name = "transaction_quantity")
    private Double transactionQuantity;
    @Column(name = "transaction_quantity_as_of")
    private Double transactionQuantityAsOf;
    @Column(name = "transaction_preorder_transaction_id")
    private Integer transactionPreorderTransactionId;
    @Column(name =     "transaction_del_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionDelDate;
    @Column(name =     "transaction_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionDate;
    @Column(name =     "transaction_add_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionAddDate;
    @Column(name = "transaction_edit_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionEditDate;
    @Column(name = "transaction_add_user")
    private String transactionAddUser;
    @Column(name = "transaction_edit_user")
    private String transactionEditUser;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "transaction_id")
    private Integer transactionId;
    @Column(name = "transaction_invoice_id")
    private Integer transactionInvoiceId;
    @Column(name = "transaction_item_number")
    private Integer transactionItemNumber;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "transaction_price")
    private Double transactionPrice;
    @Column(name = "invoice_transaction_flag")
    private Short invoiceTransactionFlag;
    @Column(name = "transaction_del_flag")
    private Short transactionDelFlag;
    private Double transactionSubTotal;
    private String itemName;
    private String supplierName;
    private Short doubleFlag;
    

    public Transaction() {
    }

    public Transaction(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getTransactionInvoiceId() {
        return transactionInvoiceId;
    }

    public void setTransactionInvoiceId(Integer transactionInvoiceId) {
        this.transactionInvoiceId = transactionInvoiceId;
    }

    public Integer getTransactionItemNumber() {
        return transactionItemNumber;
    }

    public void setTransactionItemNumber(Integer transactionItemNumber) {
        this.transactionItemNumber = transactionItemNumber;
    }

    public Double getTransactionPrice() {
        return transactionPrice;
    }

    public void setTransactionPrice(Double transactionPrice) {
        this.transactionPrice = transactionPrice;
    }

    public Double getTransactionQuantity() {
        return transactionQuantity;
    }

    public void setTransactionQuantity(Double transactionQuantity) {
        this.transactionQuantity = transactionQuantity;
    }

    public Short getInvoiceTransactionFlag() {
        return invoiceTransactionFlag;
    }

    public void setInvoiceTransactionFlag(Short invoiceTransactionFlag) {
        this.invoiceTransactionFlag = invoiceTransactionFlag;
    }

    public Short getTransactionDelFlag() {
        return transactionDelFlag;
    }

    public void setTransactionDelFlag(Short transactionDelFlag) {
        this.transactionDelFlag = transactionDelFlag;
    }

    public Date getTransactionDelDate() {
        return transactionDelDate;
    }

    public void setTransactionDelDate(Date transactionDelDate) {
        this.transactionDelDate = transactionDelDate;
    }

    public Double getTransactionQuantityAsOf() {
        return transactionQuantityAsOf;
    }

    public void setTransactionQuantityAsOf(Double transactionQuantityAsOf) {
        this.transactionQuantityAsOf = transactionQuantityAsOf;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transactionId != null ? transactionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transaction)) {
            return false;
        }
        Transaction other = (Transaction) object;
        if ((this.transactionId == null && other.transactionId != null) || (this.transactionId != null && !this.transactionId.equals(other.transactionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pos_project.classes.Transaction[ transactionId=" + transactionId + " ]";
    }

    /**
     * @return the transactionSubTotal
     */
    public Double getTransactionSubTotal() {
        return transactionSubTotal;
    }

    /**
     * @param transactionSubTotal the transactionSubTotal to set
     */
    public void setTransactionSubTotal(Double transactionSubTotal) {
        this.transactionSubTotal = transactionSubTotal;
    }

    /**
     * @return the itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @param itemName the itemName to set
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * @return the supplierName
     */
    public String getSupplierName() {
        return supplierName;
    }

    /**
     * @param supplierName the supplierName to set
     */
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    
    public static int addInTransaction(Transaction c){
        int result = -1;
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.INSERT_IN_TRANSACTION;
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setInt(1, c.getTransactionInvoiceId());
            prepStatement.setInt(2, c.getTransactionItemNumber());
            
//            prepStatement.setString(3 ,Formats.dateFormatSeconds.format(c.getInvoiceDate()));
//            prepStatement.setShort(4, c.getInvoicePaymentType());
            prepStatement.setDouble(3, c.getTransactionPrice());
            prepStatement.setDouble(4, c.getTransactionQuantity());
            prepStatement.setDouble(5, c.getTransactionQuantityAsOf());
//            prepStatement.setDouble(6, c.getInvoiceCurrentBalance());
            prepStatement.setString(6, Formats.dateFormatSeconds.format(c.getTransactionDate()));
//            prepStatement.setShort(8, c.getInvoiceReceivableFlag());
            
            
            result = prepStatement.executeUpdate();
            
            prepStatement.close();
            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
    
    public static int addInTransaction(Transaction c, Connection con) throws SQLException{
        int result = -1;
//        try{
//            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.INSERT_IN_TRANSACTION;
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setInt(1, c.getTransactionInvoiceId());
            prepStatement.setInt(2, c.getTransactionItemNumber());
            
//            prepStatement.setString(3 ,Formats.dateFormatSeconds.format(c.getInvoiceDate()));
//            prepStatement.setShort(4, c.getInvoicePaymentType());
            prepStatement.setDouble(3, c.getTransactionPrice());
            prepStatement.setDouble(4, c.getTransactionQuantity());
            prepStatement.setDouble(5, c.getTransactionQuantityAsOf());
//            prepStatement.setDouble(6, c.g etInvoiceCurrentBalance());
            prepStatement.setString(6, Formats.dateFormatSeconds.format(c.getTransactionDate()));
            prepStatement.setString(7, Formats.dateFormatSeconds.format(c.getTransactionAddDate()));
            prepStatement.setString(8, c.getTransactionAddUser());
            int value = 0;
            if(c.getTransactionPreorderTransactionId() != null){
                value = c.getTransactionPreorderTransactionId();
            }
            prepStatement.setInt(9, value);
//            prepStatement.setShort(8, c.getInvoiceReceivableFlag());
            
            
            result = prepStatement.executeUpdate();
            
            prepStatement.close();
//            con.close();
//        }catch(Exception e){
////            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
        return result;
    }
    
    public static int deleteTransaction(Transaction c, Connection con) throws SQLException{
        int result = -1;
//        try{
//            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.DELETE_TRANSACTION;
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, Formats.dateFormatSeconds.format(c.getTransactionDelDate()));
            prepStatement.setString(2, Formats.dateFormatSeconds.format(c.getTransactionEditDate()));
            prepStatement.setString(3, c.getTransactionEditUser());
            prepStatement.setInt(4, c.getTransactionId());
//            prepStatement.setInt(2, c.getTransactionItemNumber());
            
//            prepStatement.setString(3 ,Formats.dateFormatSeconds.format(c.getInvoiceDate()));
//            prepStatement.setShort(4, c.getInvoicePaymentType());
//            prepStatement.setDouble(3, c.getTransactionPrice());
//            prepStatement.setInt(4, c.onQuantity());
//            prepStatement.setInt(5, c.getTransactionQuantityAsOf());
////            prepStatement.setDouble(6, c.g etInvoiceCurrentBalance());
//            prepStatement.setString(6, Formats.dateFormatSeconds.format(c.getTransactionDate()));
//            prepStatement.setString(7, Formats.dateFormatSeconds.format(c.getTransactionAddDate()));
//            prepStatement.setString(8, c.getTransactionAddUser());
//            prepStatement.setShort(8, c.getInvoiceReceivableFlag());
            
            
            result = prepStatement.executeUpdate();
            
            prepStatement.close();
//            con.close();
//        }catch(Exception e){
////            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
        return result;
    }
    
        public static ArrayList<Transaction> getTransactions(String invoiceId) {
        ArrayList<Transaction> result = new ArrayList<Transaction>();
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.SELECT_TRANSACTIONS_INV;
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, invoiceId);
            ResultSet rs = prepStatement.executeQuery();
            while(rs.next()){
                Transaction t = new Transaction();
                t.setItemName(rs.getString("item_name"));
                t.setTransactionId(rs.getInt("transaction_id"));
                t.setTransactionPrice(rs.getDouble("transaction_price"));
                t.setTransactionQuantity(rs.getDouble("transaction_quantity"));
                t.setTransactionInvoiceId(rs.getInt("transaction_invoice_id"));
                t.setTransactionItemNumber(rs.getInt("transaction_item_number"));
                t.setSupplierName(rs.getString("client_name"));
                t.setTransactionSubTotal(t.getTransactionPrice()*t.getTransactionQuantity());
                result.add(t);
            }
            
//            result = prepStatement.executeUpdate();
            
            prepStatement.close();
            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
        
        
    public static Transaction getTransaction(String transactionId) {
        Transaction t = new Transaction();
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.SELECT_TRANSACTION;
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, transactionId);
            System.out.println(prepStatement);
            ResultSet rs = prepStatement.executeQuery();
            while(rs.next()){
                
                t.setItemName(rs.getString("item_name"));
                t.setTransactionId(rs.getInt("transaction_id"));
                t.setTransactionPrice(rs.getDouble("transaction_price"));
                t.setTransactionQuantity(rs.getDouble("transaction_quantity"));
                t.setTransactionInvoiceId(rs.getInt("transaction_invoice_id"));
                t.setTransactionItemNumber(rs.getInt("transaction_item_number"));
                t.setSupplierName(rs.getString("client_name"));
                t.setTransactionSubTotal(t.getTransactionPrice()*t.getTransactionQuantity());
                
            }
            
//            result = prepStatement.executeUpdate();
            
            prepStatement.close();
            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return t;
    }

    
     public static Double getTransactionWithPO(String poTransactionId) {
//        Transaction t = new Transaction();
         Double t = 0.0;
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.SELECT_QUANTITY_PO_TRANSACTIONS_INVOICE;
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, poTransactionId);
            System.out.println(prepStatement);
            ResultSet rs = prepStatement.executeQuery();
            while(rs.next()){
                
//                t.setItemName(rs.getString("item_name"));
                t = rs.getDouble("quantity");
//                t.setTransactionPrice(rs.getDouble("transaction_price"));
//                t.setTransactionQuantity(rs.getInt("transaction_quantity"));
//                t.setTransactionInvoiceId(rs.getInt("transaction_invoice_id"));
//                t.setTransactionInvoiceId(rs.getInt("transaction_invoice_id"));
//                t.setTransactionItemNumber(rs.getInt("transaction_item_number"));
//                t.setSupplierName(rs.getString("client_name"));
//                t.setTransactionSubTotal(t.getTransactionPrice()*t.getTransactionQuantity());
                
            }
            
//            result = prepStatement.executeUpdate();
            
            prepStatement.close();
            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return t;
    }

//    public Date getTransactionDelDate() {
//        return transactionDelDate;
//    }
//
//    public void setTransactionDelDate(Date transactionDelDate) {
//        this.transactionDelDate = transactionDelDate;
//    }
//
//    public Date getTransactionDate() {
//        return transactionDate;
//    }
//
//    public void setTransactionDate(Date transactionDate) {
//        this.transactionDate = transactionDate;
//    }

    public Date getTransactionAddDate() {
        return transactionAddDate;
    }

    public void setTransactionAddDate(Date transactionAddDate) {
        this.transactionAddDate = transactionAddDate;
    }

    public String getTransactionAddUser() {
        return transactionAddUser;
    }

    public void setTransactionAddUser(String transactionAddUser) {
        this.transactionAddUser = transactionAddUser;
    }

    public Date getTransactionEditDate() {
        return transactionEditDate;
    }

    public void setTransactionEditDate(Date transactionEditDate) {
        this.transactionEditDate = transactionEditDate;
    }

    public String getTransactionEditUser() {
        return transactionEditUser;
    }

    public void setTransactionEditUser(String transactionEditUser) {
        this.transactionEditUser = transactionEditUser;
    }

//    public Date getTransactionDelDate() {
//        return transactionDelDate;
//    }
//
//    public void setTransactionDelDate(Date transactionDelDate) {
//        this.transactionDelDate = transactionDelDate;
//    }
//
//    public Date getTransactionDate() {
//        return transactionDate;
//    }
//
//    public void setTransactionDate(Date transactionDate) {
//        this.transactionDate = transactionDate;
//    }
//
//    public Date getTransactionAddDate() {
//        return transactionAddDate;
//    }
//
//    public void setTransactionAddDate(Date transactionAddDate) {
//        this.transactionAddDate = transactionAddDate;
//    }
//
//    public Date getTransactionEditDate() {
//        return transactionEditDate;
//    }
//
//    public void setTransactionEditDate(Date transactionEditDate) {
//        this.transactionEditDate = transactionEditDate;
//    }

    public Integer getTransactionPreorderTransactionId() {
        return transactionPreorderTransactionId;
    }

    public void setTransactionPreorderTransactionId(Integer transactionPreorderTransactionId) {
        this.transactionPreorderTransactionId = transactionPreorderTransactionId;
    }

    /**
     * @return the doubleFlag
     */
    public Short getDoubleFlag() {
        return doubleFlag;
    }

    /**
     * @param doubleFlag the doubleFlag to set
     */
    public void setDoubleFlag(Short doubleFlag) {
        this.doubleFlag = doubleFlag;
    }

//    public Double getTransactionQuantity() {
//        return transactionQuantity;
//    }
//
//    public void setTransactionQuantity(Double transactionQuantity) {
//        this.transactionQuantity = transactionQuantity;
//    }
//
//    public Double getTransactionQuantityAsOf() {
//        return transactionQuantityAsOf;
//    }
//
//    public void setTransactionQuantityAsOf(Double transactionQuantityAsOf) {
//        this.transactionQuantityAsOf = transactionQuantityAsOf;
//    }
//    
}
