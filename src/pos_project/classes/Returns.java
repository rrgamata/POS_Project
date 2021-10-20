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
 * @author Cif3r
 */
@Entity
@Table(name = "returns")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Returns.findAll", query = "SELECT r FROM Returns r"),
    @NamedQuery(name = "Returns.findByReturnsId", query = "SELECT r FROM Returns r WHERE r.returnsId = :returnsId"),
    @NamedQuery(name = "Returns.findByReturnsTransactionId", query = "SELECT r FROM Returns r WHERE r.returnsTransactionId = :returnsTransactionId"),
    @NamedQuery(name = "Returns.findByReturnsQuantity", query = "SELECT r FROM Returns r WHERE r.returnsQuantity = :returnsQuantity"),
    @NamedQuery(name = "Returns.findByReturnsAmount", query = "SELECT r FROM Returns r WHERE r.returnsAmount = :returnsAmount"),
    @NamedQuery(name = "Returns.findByReturnsDate", query = "SELECT r FROM Returns r WHERE r.returnsDate = :returnsDate"),
    @NamedQuery(name = "Returns.findByReturnsAddDate", query = "SELECT r FROM Returns r WHERE r.returnsAddDate = :returnsAddDate"),
    @NamedQuery(name = "Returns.findByReturnsAddUser", query = "SELECT r FROM Returns r WHERE r.returnsAddUser = :returnsAddUser")})
public class Returns implements Serializable {
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "returns_quantity")
    private Double returnsQuantity;
    @Column(name = "retun_edit_user")
    private String retunEditUser;
    @Column(name = "return_collection_number")
    private Integer returnCollectionNumber;
    @Column(name = "return_del_flag")
    private Short returnDelFlag;
    @Column(name = "return_edit_user")
    private String returnEditUser;
    @Column(name = "return_edit_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date returnEditDate;
    @Column(name = "return_main_id")
    private Integer returnMainId;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "returns_id")
    private Integer returnsId;
    @Column(name = "returns_transaction_id")
    private Integer returnsTransactionId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "returns_amount")
    private Double returnsAmount;
    @Column(name = "returns_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date returnsDate;
    @Column(name = "returns_add_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date returnsAddDate;
    @Column(name = "returns_add_user")
    private String returnsAddUser;
    private Double returnsSubTotal;
    private String itemName;
    private int itemId;
    private short doubleFlag;
    
    
    public Returns() {
    }

    public Returns(Integer returnsId) {
        this.returnsId = returnsId;
    }

    public Integer getReturnsId() {
        return returnsId;
    }

    public void setReturnsId(Integer returnsId) {
        this.returnsId = returnsId;
    }

    public Integer getReturnsTransactionId() {
        return returnsTransactionId;
    }

    public void setReturnsTransactionId(Integer returnsTransactionId) {
        this.returnsTransactionId = returnsTransactionId;
    }

//    public Integer getReturnsQuantity() {
//        return returnsQuantity;
//    }
//
//    public void setReturnsQuantity(Integer returnsQuantity) {
//        this.returnsQuantity = returnsQuantity;
//    }

    public Double getReturnsAmount() {
        return returnsAmount;
    }

    public void setReturnsAmount(Double returnsAmount) {
        this.returnsAmount = returnsAmount;
    }

    public Date getReturnsDate() {
        return returnsDate;
    }

    public void setReturnsDate(Date returnsDate) {
        this.returnsDate = returnsDate;
    }

    public Date getReturnsAddDate() {
        return returnsAddDate;
    }

    public void setReturnsAddDate(Date returnsAddDate) {
        this.returnsAddDate = returnsAddDate;
    }

    public String getReturnsAddUser() {
        return returnsAddUser;
    }

    public void setReturnsAddUser(String returnsAddUser) {
        this.returnsAddUser = returnsAddUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (returnsId != null ? returnsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Returns)) {
            return false;
        }
        Returns other = (Returns) object;
        if ((this.returnsId == null && other.returnsId != null) || (this.returnsId != null && !this.returnsId.equals(other.returnsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pos_project.classes.Returns[ returnsId=" + returnsId + " ]";
    }

    /**
     * @return the returnsSubTotal
     */
    public Double getReturnsSubTotal() {
        return returnsSubTotal;
    }

    /**
     * @param returnsSubTotal the returnsSubTotal to set
     */
    public void setReturnsSubTotal(Double returnsSubTotal) {
        this.returnsSubTotal = returnsSubTotal;
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

    public Integer getReturnMainId() {
        return returnMainId;
    }

    public void setReturnMainId(Integer returnMainId) {
        this.returnMainId = returnMainId;
    }

    /**
     * @return the itemId
     */
    public int getItemId() {
        return itemId;
    }

    /**
     * @param itemId the itemId to set
     */
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    
    
    
    public static int addReturns(Returns c, Connection con) throws SQLException{
        int result = -1;
//        try{
//            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.INSERT_RETURNS;
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setInt(1, c.getReturnsTransactionId());
            prepStatement.setDouble(2, c.getReturnsQuantity());
            
//            prepStatement.setString(3 ,Formats.dateFormatSeconds.format(c.getInvoiceDate()));
//            prepStatement.setShort(4, c.getInvoicePaymentType());
            
            prepStatement.setDouble(3, c.getReturnsAmount());
            prepStatement.setString(4, Formats.dateFormatSeconds.format(c.getReturnsDate()));
            prepStatement.setString(5, Formats.dateFormatSeconds.format(c.getReturnsAddDate()));
            prepStatement.setString(6, c.getReturnsAddUser());
            prepStatement.setInt(7, c.getReturnMainId());
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
    
    
    
    public static int deleteReturns(Returns c) throws SQLException{
        int result = -1;
        try{
            Connection con = SQLConnection.getSQLConnection();
             result = deleteReturns(c, con);
            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
    
    
    public static int deleteReturns(Returns c, Connection con) throws SQLException{
        int result = -1;
//        try{
//            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.DELETE_RETURNS;
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, c.getReturnEditUser());
            prepStatement.setString(2,Formats.dateFormatSeconds.format(c.getReturnEditDate()));
            prepStatement.setInt(3, c.getReturnsId());
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
    
    public static int addReturnsWithCollection(Returns c, int collectionId, Connection con) throws SQLException{
        int result = -1;
//        try{
//            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.INSERT_RETURNS_WITH_COLLECTION;
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setInt(1, c.getReturnsTransactionId());
            prepStatement.setDouble(2, c.getReturnsQuantity());
            
//            prepStatement.setString(3 ,Formats.dateFormatSeconds.format(c.getInvoiceDate()));
//            prepStatement.setShort(4, c.getInvoicePaymentType());
            
            prepStatement.setDouble(3, c.getReturnsAmount());
            prepStatement.setString(4, Formats.dateFormatSeconds.format(c.getReturnsDate()));
            prepStatement.setString(5, Formats.dateFormatSeconds.format(c.getReturnsAddDate()));
            prepStatement.setString(6, c.getReturnsAddUser());
            prepStatement.setInt(7, c.getReturnMainId());
            prepStatement.setInt(8, collectionId);
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
    
     public static int computeReturns(int transactionId) {
        int result = -1;
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.SELECT_RETURNS_QUANTITY;
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setInt(1, transactionId);
            
            ResultSet rs = prepStatement.executeQuery();
            while(rs.next()){
                result = rs.getInt("quantity");
            }
            
            prepStatement.close();
            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
     
     public static ArrayList<Returns> getReturns(String returnMainId) {
        ArrayList<Returns> result = new ArrayList<Returns>();
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.SELECT_RETURNS_INV;
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, returnMainId);
            ResultSet rs = prepStatement.executeQuery();
            while(rs.next()){
                Returns t = new Returns();
                t.setItemName(rs.getString("item_name"));
                t.setReturnsId(rs.getInt("returns_id"));
                t.setReturnsAmount(rs.getDouble("returns_amount"));
                t.setReturnsQuantity(rs.getDouble("returns_quantity"));
                t.setReturnsTransactionId(rs.getInt("returns_transaction_id"));
                t.setReturnCollectionNumber(rs.getInt("return_collection_number"));
                t.setItemId(rs.getInt("item_id"));
                t.setItemName(rs.getString("item_name"));
//                t.setTransactionItemNumber(rs.getInt("transaction_item_number"));
//                t.setSupplierName(rs.getString("client_name"));
                t.setReturnsSubTotal(t.getReturnsAmount()*t.getReturnsQuantity());
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

    public Short getReturnDelFlag() {
        return returnDelFlag;
    }

    public void setReturnDelFlag(Short returnDelFlag) {
        this.returnDelFlag = returnDelFlag;
    }

    public String getReturnEditUser() {
        return returnEditUser;
    }

    public void setReturnEditUser(String returnEditUser) {
        this.returnEditUser = returnEditUser;
    }

    public Date getReturnEditDate() {
        return returnEditDate;
    }

    public void setReturnEditDate(Date returnEditDate) {
        this.returnEditDate = returnEditDate;
    }

    /**
     * @return the doubleFlag
     */
    public short getDoubleFlag() {
        return doubleFlag;
    }

    /**
     * @param doubleFlag the doubleFlag to set
     */
    public void setDoubleFlag(short doubleFlag) {
        this.doubleFlag = doubleFlag;
    }

    public Integer getReturnCollectionNumber() {
        return returnCollectionNumber;
    }

    public void setReturnCollectionNumber(Integer returnCollectionNumber) {
        this.returnCollectionNumber = returnCollectionNumber;
    }

    public String getRetunEditUser() {
        return retunEditUser;
    }

    public void setRetunEditUser(String retunEditUser) {
        this.retunEditUser = retunEditUser;
    }

    public Double getReturnsQuantity() {
        return returnsQuantity;
    }

    public void setReturnsQuantity(Double returnsQuantity) {
        this.returnsQuantity = returnsQuantity;
    }
    
}
