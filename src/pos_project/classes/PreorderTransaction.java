/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
 * @author Cifer
 */
@Entity
@Table(name = "preorder_transaction")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PreorderTransaction.findAll", query = "SELECT p FROM PreorderTransaction p"),
    @NamedQuery(name = "PreorderTransaction.findByPreorderTransactionId", query = "SELECT p FROM PreorderTransaction p WHERE p.preorderTransactionId = :preorderTransactionId"),
    @NamedQuery(name = "PreorderTransaction.findByPreorderTransactionPreorderId", query = "SELECT p FROM PreorderTransaction p WHERE p.preorderTransactionPreorderId = :preorderTransactionPreorderId"),
    @NamedQuery(name = "PreorderTransaction.findByPreorderTransactionItemId", query = "SELECT p FROM PreorderTransaction p WHERE p.preorderTransactionItemId = :preorderTransactionItemId"),
    @NamedQuery(name = "PreorderTransaction.findByPreorderTransactionPrice", query = "SELECT p FROM PreorderTransaction p WHERE p.preorderTransactionPrice = :preorderTransactionPrice"),
    @NamedQuery(name = "PreorderTransaction.findByPreorderTransactionQuantity", query = "SELECT p FROM PreorderTransaction p WHERE p.preorderTransactionQuantity = :preorderTransactionQuantity"),
    @NamedQuery(name = "PreorderTransaction.findByPreorderTransactionDate", query = "SELECT p FROM PreorderTransaction p WHERE p.preorderTransactionDate = :preorderTransactionDate"),
    @NamedQuery(name = "PreorderTransaction.findByPreorderTransactionAddDate", query = "SELECT p FROM PreorderTransaction p WHERE p.preorderTransactionAddDate = :preorderTransactionAddDate"),
    @NamedQuery(name = "PreorderTransaction.findByPreorderTransactionAddUser", query = "SELECT p FROM PreorderTransaction p WHERE p.preorderTransactionAddUser = :preorderTransactionAddUser"),
    @NamedQuery(name = "PreorderTransaction.findBypreorderTransactionDelFlag", query = "SELECT p FROM PreorderTransaction p WHERE p.preorderTransactionDelFlag = :preorderTransactionDelFlag"),
    @NamedQuery(name = "PreorderTransaction.findByPreorderTransactionDelDate", query = "SELECT p FROM PreorderTransaction p WHERE p.preorderTransactionDelDate = :preorderTransactionDelDate")})
public class PreorderTransaction implements Serializable {
    @Column(name = "preorder_transaction_quantity")
    private Double preorderTransactionQuantity;
    @Column(name = "preorder_transaction_edit_user")
    private String preorderTransactionEditUser;
    @Column(name = "preorder_transaction_edit_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date preorderTransactionEditDate;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "preorder_transaction_id")
    private Integer preorderTransactionId;
    @Column(name = "preorder_transaction_preorder_id")
    private Integer preorderTransactionPreorderId;
    @Column(name = "preorder_transaction_item_id")
    private Integer preorderTransactionItemId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "preorder_transaction_price")
    private Double preorderTransactionPrice;
    @Column(name = "preorder_transaction_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date preorderTransactionDate;
    @Column(name = "preorder_transaction_add_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date preorderTransactionAddDate;
    @Column(name = "preorder_transaction_add_user")
    private String preorderTransactionAddUser;
    @Column(name = "preorder_transaction_del_flag")
    private Short preorderTransactionDelFlag;
    @Column(name = "preorder_transaction_del_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date preorderTransactionDelDate;
    private Double preorderTransactionSubTotal;
    private String preorderItemName;
    private String preorderSupplierName;

    public PreorderTransaction() {
    }

    public PreorderTransaction(Integer preorderTransactionId) {
        this.preorderTransactionId = preorderTransactionId;
    }

    public Integer getPreorderTransactionId() {
        return preorderTransactionId;
    }

    public void setPreorderTransactionId(Integer preorderTransactionId) {
        this.preorderTransactionId = preorderTransactionId;
    }

    public Integer getPreorderTransactionPreorderId() {
        return preorderTransactionPreorderId;
    }

    public void setPreorderTransactionPreorderId(Integer preorderTransactionPreorderId) {
        this.preorderTransactionPreorderId = preorderTransactionPreorderId;
    }

    public Integer getPreorderTransactionItemId() {
        return preorderTransactionItemId;
    }

    public void setPreorderTransactionItemId(Integer preorderTransactionItemId) {
        this.preorderTransactionItemId = preorderTransactionItemId;
    }

    public Double getPreorderTransactionPrice() {
        return preorderTransactionPrice;
    }

    public void setPreorderTransactionPrice(Double preorderTransactionPrice) {
        this.preorderTransactionPrice = preorderTransactionPrice;
    }

//    public Integer getPreorderTransactionQuantity() {
//        return preorderTransactionQuantity;
//    }
//
//    public void setPreorderTransactionQuantity(Integer preorderTransactionQuantity) {
//        this.preorderTransactionQuantity = preorderTransactionQuantity;
//    }

    public Date getPreorderTransactionDate() {
        return preorderTransactionDate;
    }

    public void setPreorderTransactionDate(Date preorderTransactionDate) {
        this.preorderTransactionDate = preorderTransactionDate;
    }

    public Date getPreorderTransactionAddDate() {
        return preorderTransactionAddDate;
    }

    public void setPreorderTransactionAddDate(Date preorderTransactionAddDate) {
        this.preorderTransactionAddDate = preorderTransactionAddDate;
    }

    public String getPreorderTransactionAddUser() {
        return preorderTransactionAddUser;
    }

    public void setPreorderTransactionAddUser(String preorderTransactionAddUser) {
        this.preorderTransactionAddUser = preorderTransactionAddUser;
    }

    public Short getpreorderTransactionDelFlag() {
        return preorderTransactionDelFlag;
    }

    public void setpreorderTransactionDelFlag(Short preorderTransactionDelFlag) {
        this.preorderTransactionDelFlag = preorderTransactionDelFlag;
    }

    public Date getPreorderTransactionDelDate() {
        return preorderTransactionDelDate;
    }

    public void setPreorderTransactionDelDate(Date preorderTransactionDelDate) {
        this.preorderTransactionDelDate = preorderTransactionDelDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (preorderTransactionId != null ? preorderTransactionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PreorderTransaction)) {
            return false;
        }
        PreorderTransaction other = (PreorderTransaction) object;
        if ((this.preorderTransactionId == null && other.preorderTransactionId != null) || (this.preorderTransactionId != null && !this.preorderTransactionId.equals(other.preorderTransactionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pos_project.classes.PreorderTransaction[ preorderTransactionId=" + preorderTransactionId + " ]";
    }
    
    public static int addPreorderTransaction(PreorderTransaction c, Connection con) throws SQLException{
        int result = -1;
//        try{
//            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.INSERT_PREORDER_TRANSACTION;
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setInt(1, c.getPreorderTransactionPreorderId());
            prepStatement.setInt(2, c.getPreorderTransactionItemId());
            
//            prepStatement.setString(3 ,Formats.dateFormatSeconds.format(c.getInvoiceDate()));
//            prepStatement.setShort(4, c.getInvoicePaymentType());
            prepStatement.setDouble(3, c.getPreorderTransactionPrice());
            prepStatement.setDouble(4, c.getPreorderTransactionQuantity());
//            prepStatement.setInt(5, c.getTransactionQuantityAsOf());
//            prepStatement.setDouble(6, c.g etInvoiceCurrentBalance());
            prepStatement.setString(5, Formats.dateFormatSeconds.format(c.getPreorderTransactionDate()));
            prepStatement.setString(6, Formats.dateFormatSeconds.format(c.getPreorderTransactionAddDate()));
            prepStatement.setString(7, c.getPreorderTransactionAddUser());
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

    /**
     * @return the preorderTransactionSubTotal
     */
    public Double getPreorderTransactionSubTotal() {
        return preorderTransactionSubTotal;
    }

    /**
     * @param preorderTransactionSubTotal the preorderTransactionSubTotal to set
     */
    public void setPreorderTransactionSubTotal(Double preorderTransactionSubTotal) {
        this.preorderTransactionSubTotal = preorderTransactionSubTotal;
    }

    /**
     * @return the preorderItemName
     */
    public String getPreorderItemName() {
        return preorderItemName;
    }

    /**
     * @param preorderItemName the preorderItemName to set
     */
    public void setPreorderItemName(String preorderItemName) {
        this.preorderItemName = preorderItemName;
    }

    /**
     * @return the preorderSupplierName
     */
    public String getPreorderSupplierName() {
        return preorderSupplierName;
    }

    /**
     * @param preorderSupplierName the preorderSupplierName to set
     */
    public void setPreorderSupplierName(String preorderSupplierName) {
        this.preorderSupplierName = preorderSupplierName;
    }
    
     public static ArrayList<PreorderTransaction> getTransactions(String invoiceId) {
        ArrayList<PreorderTransaction> result = new ArrayList<PreorderTransaction>();
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.SELECT_TRANSACTIONS_PO;
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, invoiceId);
            System.out.println(prepStatement);
            ResultSet rs = prepStatement.executeQuery();
            while(rs.next()){
                PreorderTransaction t = new PreorderTransaction();
                t.setPreorderItemName(rs.getString("item_name"));
                t.setPreorderTransactionId(rs.getInt("preorder_transaction_id"));
                t.setPreorderTransactionPrice(rs.getDouble("preorder_transaction_price"));
                t.setPreorderTransactionQuantity(rs.getDouble("preorder_transaction_quantity"));
                t.setPreorderTransactionPreorderId(rs.getInt("preorder_transaction_preorder_id"));
                t.setPreorderTransactionItemId(rs.getInt("preorder_transaction_item_id"));
                t.setPreorderSupplierName(rs.getString("client_name"));
                t.setPreorderTransactionSubTotal(t.getPreorderTransactionPrice()*t.getPreorderTransactionQuantity());
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
     
       public static int deleteTransaction(PreorderTransaction c, Connection con) throws SQLException{
        int result = -1;
//        try{
//            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.DELETE_PREORDER_TRANSACTION;
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, Formats.dateFormatSeconds.format(c.getPreorderTransactionDelDate()));
            prepStatement.setString(2, Formats.dateFormatSeconds.format(c.getPreorderTransactionEditDate()));
            prepStatement.setString(3, c.getPreorderTransactionEditUser());
            prepStatement.setInt(4, c.getPreorderTransactionId());
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
       
       
        public static PreorderTransaction getTransaction(String transactionId) {
        PreorderTransaction t = new PreorderTransaction();
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.SELECT_PREORDER_TRANSACTION;
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, transactionId);
            System.out.println(prepStatement);
            ResultSet rs = prepStatement.executeQuery();
            while(rs.next()){
                
                t.setPreorderItemName(rs.getString("item_name"));
                t.setPreorderTransactionId(rs.getInt("preorder_transaction_id"));
                t.setPreorderTransactionPrice(rs.getDouble("preorder_transaction_price"));
                t.setPreorderTransactionQuantity(rs.getDouble("preorder_transaction_quantity"));
                t.setPreorderTransactionPreorderId(rs.getInt("preorder_transaction_preorder_id"));
                t.setPreorderTransactionItemId(rs.getInt("preorder_transaction_item_id"));
                t.setPreorderSupplierName(rs.getString("client_name"));
                t.setPreorderTransactionSubTotal(t.getPreorderTransactionPrice()*t.getPreorderTransactionQuantity());
                
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


    public String getPreorderTransactionEditUser() {
        return preorderTransactionEditUser;
    }

    public void setPreorderTransactionEditUser(String preorderTransactionEditUser) {
        this.preorderTransactionEditUser = preorderTransactionEditUser;
    }

    public Date getPreorderTransactionEditDate() {
        return preorderTransactionEditDate;
    }

    public void setPreorderTransactionEditDate(Date preorderTransactionEditDate) {
        this.preorderTransactionEditDate = preorderTransactionEditDate;
    }

    public Double getPreorderTransactionQuantity() {
        return preorderTransactionQuantity;
    }

    public void setPreorderTransactionQuantity(Double preorderTransactionQuantity) {
        this.preorderTransactionQuantity = preorderTransactionQuantity;
    }
    
    
}
