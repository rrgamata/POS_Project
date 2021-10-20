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
 * @author Cifer
 */
@Entity
@Table(name = "preorder")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Preorder.findAll", query = "SELECT p FROM Preorder p"),
    @NamedQuery(name = "Preorder.findByPreorderId", query = "SELECT p FROM Preorder p WHERE p.preorderId = :preorderId"),
    @NamedQuery(name = "Preorder.findByPreorderNumber", query = "SELECT p FROM Preorder p WHERE p.preorderNumber = :preorderNumber"),
    @NamedQuery(name = "Preorder.findByPreorderClientId", query = "SELECT p FROM Preorder p WHERE p.preorderClientId = :preorderClientId"),
    @NamedQuery(name = "Preorder.findByPreorderDate", query = "SELECT p FROM Preorder p WHERE p.preorderDate = :preorderDate"),
    @NamedQuery(name = "Preorder.findByPreorderPrice", query = "SELECT p FROM Preorder p WHERE p.preorderPrice = :preorderPrice"),
    @NamedQuery(name = "Preorder.findByPreorderLocationId", query = "SELECT p FROM Preorder p WHERE p.preorderLocationId = :preorderLocationId"),
    @NamedQuery(name = "Preorder.findByPreorderAddDate", query = "SELECT p FROM Preorder p WHERE p.preorderAddDate = :preorderAddDate"),
    @NamedQuery(name = "Preorder.findByPreorderAddUser", query = "SELECT p FROM Preorder p WHERE p.preorderAddUser = :preorderAddUser"),
    @NamedQuery(name = "Preorder.findByPreorderEditDate", query = "SELECT p FROM Preorder p WHERE p.preorderEditDate = :preorderEditDate"),
    @NamedQuery(name = "Preorder.findByPreorderEditUser", query = "SELECT p FROM Preorder p WHERE p.preorderEditUser = :preorderEditUser"),
    @NamedQuery(name = "Preorder.findByPreorderDelFlag", query = "SELECT p FROM Preorder p WHERE p.preorderDelFlag = :preorderDelFlag"),
    @NamedQuery(name = "Preorder.findByPreorderDelDate", query = "SELECT p FROM Preorder p WHERE p.preorderDelDate = :preorderDelDate")})
public class Preorder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "preorder_id")
    private Integer preorderId;
    @Column(name = "preorder_number")
    private String preorderNumber;
    @Column(name = "preorder_client_id")
    private Integer preorderClientId;
    @Column(name = "preorder_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date preorderDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "preorder_price")
    private Double preorderPrice;
    @Column(name = "preorder_location_id")
    private Integer preorderLocationId;
    @Column(name = "preorder_add_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date preorderAddDate;
    @Column(name = "preorder_add_user")
    private String preorderAddUser;
    @Column(name = "preorder_edit_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date preorderEditDate;
    @Column(name = "preorder_edit_user")
    private String preorderEditUser;
    @Column(name = "preorder_del_flag")
    private Short preorderDelFlag;
    @Column(name = "preorder_del_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date preorderDelDate;
    private String clientName;
    private String clientNumber;
    private String clientAddress;
    

    public Preorder() {
    }

    public Preorder(Integer preorderId) {
        this.preorderId = preorderId;
    }

    public Integer getPreorderId() {
        return preorderId;
    }

    public void setPreorderId(Integer preorderId) {
        this.preorderId = preorderId;
    }

    public String getPreorderNumber() {
        return preorderNumber;
    }

    public void setPreorderNumber(String preorderNumber) {
        this.preorderNumber = preorderNumber;
    }

    public Integer getPreorderClientId() {
        return preorderClientId;
    }

    public void setPreorderClientId(Integer preorderClientId) {
        this.preorderClientId = preorderClientId;
    }

    public Date getPreorderDate() {
        return preorderDate;
    }

    public void setPreorderDate(Date preorderDate) {
        this.preorderDate = preorderDate;
    }

    public Double getPreorderPrice() {
        return preorderPrice;
    }

    public void setPreorderPrice(Double preorderPrice) {
        this.preorderPrice = preorderPrice;
    }

    public Integer getPreorderLocationId() {
        return preorderLocationId;
    }

    public void setPreorderLocationId(Integer preorderLocationId) {
        this.preorderLocationId = preorderLocationId;
    }

    public Date getPreorderAddDate() {
        return preorderAddDate;
    }

    public void setPreorderAddDate(Date preorderAddDate) {
        this.preorderAddDate = preorderAddDate;
    }

    public String getPreorderAddUser() {
        return preorderAddUser;
    }

    public void setPreorderAddUser(String preorderAddUser) {
        this.preorderAddUser = preorderAddUser;
    }

    public Date getPreorderEditDate() {
        return preorderEditDate;
    }

    public void setPreorderEditDate(Date preorderEditDate) {
        this.preorderEditDate = preorderEditDate;
    }

    public String getPreorderEditUser() {
        return preorderEditUser;
    }

    public void setPreorderEditUser(String preorderEditUser) {
        this.preorderEditUser = preorderEditUser;
    }

    public Short getPreorderDelFlag() {
        return preorderDelFlag;
    }

    public void setPreorderDelFlag(Short preorderDelFlag) {
        this.preorderDelFlag = preorderDelFlag;
    }

    public Date getPreorderDelDate() {
        return preorderDelDate;
    }

    public void setPreorderDelDate(Date preorderDelDate) {
        this.preorderDelDate = preorderDelDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (preorderId != null ? preorderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Preorder)) {
            return false;
        }
        Preorder other = (Preorder) object;
        if ((this.preorderId == null && other.preorderId != null) || (this.preorderId != null && !this.preorderId.equals(other.preorderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pos_project.classes.Preorder[ preorderId=" + preorderId + " ]";
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
 
    
    public static int addPreorder(Preorder c, Connection con){
        int result = -1;
        try{
//            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.INSERT_PREORDER;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, c.getPreorderNumber());
            prepStatement.setInt(2, c.getPreorderClientId());
            prepStatement.setString(3 ,Formats.dateFormatSeconds.format(c.getPreorderDate()));
            prepStatement.setDouble(4, c.getPreorderPrice());
            
            prepStatement.setString(5, Formats.dateFormatDays.format(c.getPreorderAddDate()));
            prepStatement.setString(6, c.getPreorderAddUser());
            prepStatement.setInt(7, c.getPreorderLocationId());
            
            
            
            
            
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
    
    public static ArrayList<Preorder> getAllPreorderWithClient(int invoiceName){
//        int result = -1;
        ArrayList<Preorder> arr = new ArrayList<Preorder>();
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.SELECT_ALL_PREORDER_WITH_CLIENT;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setInt(1, invoiceName);
            System.out.println(prepStatement);
            ResultSet rs = prepStatement.executeQuery();
            
            while(rs.next()){
                Preorder c = new Preorder();
                c.setPreorderId(rs.getInt("preorder_id"));
                c.setPreorderNumber(rs.getString("preorder_number"));
                c.setClientName(rs.getString("client_name"));
                c.setPreorderClientId(rs.getInt("preorder_client_id"));
                c.setPreorderDate(rs.getTimestamp("preorder_date"));
//                c.setInvoiceDueDate(rs.getDate("invoice_due_date"));
//                c.setInvoiceTypeFlag(rs.getShort("invoice_type_flag"));
                c.setPreorderPrice(rs.getDouble("preorder_price"));
//                c.setInvoiceCurrentBalance(rs.getDouble("invoice_current_balance"));
//                c.setInvoicePaidFlag(rs.getShort("invoice_paid_flag"));
//                c.setInvoiceReceivableFlag(rs.getShort("invoice_receivable_flag"));
//                c.setInvoicePaymentType(rs.getShort("invoice_payment_type"));
                c.setPreorderAddDate(rs.getTimestamp("preorder_add_date"));
                c.setPreorderEditDate(rs.getTimestamp("preorder_edit_date"));
                c.setPreorderAddUser(rs.getString("add_user"));
                c.setPreorderEditUser(rs.getString("edit_user"));
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
    
     public static Preorder getPreorderWithId(String poId){
        int result = -1;
        Preorder c = new Preorder();
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.SELECT_PREORDER_WITH_ID;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, poId);
            ResultSet rs = prepStatement.executeQuery();
            while(rs.next()){
                c.setPreorderId(rs.getInt("preorder_id"));
                c.setPreorderNumber(rs.getString("preorder_number"));
                c.setPreorderClientId(rs.getInt("preorder_client_id"));
                c.setClientName(rs.getString("client_name"));
                c.setClientNumber(rs.getString("client_number"));
//                c.setInvoicePaymentType(rs.getShort("invoice_payment_type"));
                c.setPreorderDate(rs.getDate("preorder_date"));
//                c.setInvoiceDueDate(rs.getDate("invoice_due_date"));
//                c.setInvoiceTypeFlag(rs.getShort("invoice_type_flag"));
                c.setPreorderPrice(rs.getDouble("preorder_price"));
//                c.setInvoiceCurrentBalance(rs.getDouble("invoice_current_balance"));
//                c.setInvoicePaidFlag(rs.getShort("invoice_paid_flag"));
                c.setPreorderAddDate(rs.getTimestamp("preorder_add_date"));
                c.setPreorderAddUser(rs.getString("preorder_add_user"));
                c.setPreorderLocationId(rs.getInt("preorder_location_id"));
                c.setClientAddress(rs.getString("client_address"));
//                c.setInvoiceDriver(rs.getString("invoice_driver"));
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
     
     
       public static int editPreorder(Preorder c, Connection con){
        int result = -1;
        try{
//            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.EDIT_PREORDER;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, c.getPreorderNumber());
            prepStatement.setInt(2, c.getPreorderClientId());
            prepStatement.setString(3 ,Formats.dateFormatSeconds.format(c.getPreorderDate()));
            prepStatement.setDouble(4, c.getPreorderPrice());
            prepStatement.setInt(5, c.getPreorderLocationId());
            prepStatement.setString(6, Formats.dateFormatDays.format(c.getPreorderEditDate()));
            prepStatement.setString(7, c.getPreorderEditUser());
            prepStatement.setInt(8, c.getPreorderId());
            
            
            
            
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
       
       
       public static int getLatestPreorder(Connection con) throws SQLException{
        int invoiceId = 0;;
//        try{
//            Connection con = SQLConnection.getSQLConnection();
            Statement stmt = con.createStatement();
            String sql = SqlStatements.SELECT_LATEST_PREORDER;
            System.out.print(sql);
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                invoiceId = rs.getInt("preorder_id");
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
       
       public static int deletePreorder(Preorder c, Connection con){
        int result = -1;
        try{
//            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.DELETE_PREORDER;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, Formats.dateFormatDays.format(c.getPreorderEditDate()));
            prepStatement.setString(2, c.getPreorderEditUser());
            prepStatement.setString(3, Formats.dateFormatDays.format(c.getPreorderDelDate()));
            prepStatement.setInt(4, c.getPreorderId());
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
       
       public static ArrayList<Preorder> getPreorderList(){
        ArrayList<Preorder> invoices = new ArrayList<Preorder>();
        try{
            Connection con = SQLConnection.getSQLConnection();
            Statement stmt = con.createStatement();
            String sql = SqlStatements.SELECT_ALL_PREORDER;
            System.out.print(sql);
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                Preorder invoice = new Preorder();
                invoice.setPreorderId(rs.getInt("preorder_id"));
                invoice.setClientName(rs.getString("client_name"));
//                invoice.setSupplierName(rs.getString("supplier_name"));
//                invoice.setItemName(rs.getString("item_name"));
//                invoice.setItemPrice(rs.getDouble("item_price"));
//                invoice.setInvoicePrice(rs.getDouble("invoice_price"));
//                invoice.setInvoiceQuantity(rs.getInt("invoice_quantity"));
                invoice.setPreorderPrice(rs.getDouble("preorder_price"));
                invoice.setPreorderDate(rs.getTimestamp("preorder_date"));
//                invoice.setInvoiceDueDate(rs.getDate("invoice_due_date"));
//                invoice.setInvoiceTypeFlag(rs.getShort("invoice_type_flag"));
//                invoice.setInvoiceReceivableFlag(rs.getShort("invoice_receivable_flag"));
//                invoice.setInvoicePaymentType(rs.getShort("invoice_payment_type"));
                invoice.setPreorderNumber(rs.getString("preorder_number"));
                invoice.setPreorderAddDate(rs.getTimestamp("preorder_add_date"));
                invoice.setPreorderEditDate(rs.getTimestamp("preorder_edit_date"));
                invoice.setPreorderAddUser(rs.getString("add_user"));
                invoice.setPreorderEditUser(rs.getString("edit_user"));
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
}
