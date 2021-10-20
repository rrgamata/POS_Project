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
 * @author Cif3r
 */
@Entity
@Table(name = "return_main")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReturnMain.findAll", query = "SELECT r FROM ReturnMain r"),
    @NamedQuery(name = "ReturnMain.findByReturnMainId", query = "SELECT r FROM ReturnMain r WHERE r.returnMainId = :returnMainId"),
    @NamedQuery(name = "ReturnMain.findByReturnMainInvoiceId", query = "SELECT r FROM ReturnMain r WHERE r.returnMainInvoiceId = :returnMainInvoiceId"),
    @NamedQuery(name = "ReturnMain.findByReturnMainNumber", query = "SELECT r FROM ReturnMain r WHERE r.returnMainNumber = :returnMainNumber"),
    @NamedQuery(name = "ReturnMain.findByReturnMainDate", query = "SELECT r FROM ReturnMain r WHERE r.returnMainDate = :returnMainDate"),
    @NamedQuery(name = "ReturnMain.findByReturnMainAddDate", query = "SELECT r FROM ReturnMain r WHERE r.returnMainAddDate = :returnMainAddDate"),
    @NamedQuery(name = "ReturnMain.findByReturnMainAddUser", query = "SELECT r FROM ReturnMain r WHERE r.returnMainAddUser = :returnMainAddUser"),
    @NamedQuery(name = "ReturnMain.findByReturnMainDelFlag", query = "SELECT r FROM ReturnMain r WHERE r.returnMainDelFlag = :returnMainDelFlag"),
    @NamedQuery(name = "ReturnMain.findByReturnMainDelUser", query = "SELECT r FROM ReturnMain r WHERE r.returnMainDelUser = :returnMainDelUser")})
public class ReturnMain implements Serializable {
    @Column(name = "return_main_del_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date returnMainDelDate;
    @Column(name = "return_main_edit_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date returnMainEditDate;
    @Column(name = "return_main_edit_user")
    private String returnMainEditUser;
    @Column(name = "return_main_location_id")
    private Integer returnMainLocationId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "return_main_total")
    private Double returnMainTotal;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "return_main_id")
    private Integer returnMainId;
    @Column(name = "return_main_invoice_id")
    private Integer returnMainInvoiceId;
    @Column(name = "return_main_number")
    private String returnMainNumber;
    @Column(name = "return_main_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date returnMainDate;
    @Column(name = "return_main_add_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date returnMainAddDate;
    @Column(name = "return_main_add_user")
    private String returnMainAddUser;
    @Column(name = "return_main_del_flag")
    private Short returnMainDelFlag;
    @Column(name = "return_main_del_user")
    private String returnMainDelUser;
    private String clientName;
    private String invoiceNumber;
    

    public ReturnMain() {
    }

    public ReturnMain(Integer returnMainId) {
        this.returnMainId = returnMainId;
    }

    public Integer getReturnMainId() {
        return returnMainId;
    }

    public void setReturnMainId(Integer returnMainId) {
        this.returnMainId = returnMainId;
    }

    public Integer getReturnMainInvoiceId() {
        return returnMainInvoiceId;
    }

    public void setReturnMainInvoiceId(Integer returnMainInvoiceId) {
        this.returnMainInvoiceId = returnMainInvoiceId;
    }

    public String getReturnMainNumber() {
        return returnMainNumber;
    }

    public void setReturnMainNumber(String returnMainNumber) {
        this.returnMainNumber = returnMainNumber;
    }

    public Date getReturnMainDate() {
        return returnMainDate;
    }

    public void setReturnMainDate(Date returnMainDate) {
        this.returnMainDate = returnMainDate;
    }

    public Date getReturnMainAddDate() {
        return returnMainAddDate;
    }

    public void setReturnMainAddDate(Date returnMainAddDate) {
        this.returnMainAddDate = returnMainAddDate;
    }

    public String getReturnMainAddUser() {
        return returnMainAddUser;
    }

    public void setReturnMainAddUser(String returnMainAddUser) {
        this.returnMainAddUser = returnMainAddUser;
    }

    public Short getReturnMainDelFlag() {
        return returnMainDelFlag;
    }

    public void setReturnMainDelFlag(Short returnMainDelFlag) {
        this.returnMainDelFlag = returnMainDelFlag;
    }

    public String getReturnMainDelUser() {
        return returnMainDelUser;
    }

    public void setReturnMainDelUser(String returnMainDelUser) {
        this.returnMainDelUser = returnMainDelUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (returnMainId != null ? returnMainId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReturnMain)) {
            return false;
        }
        ReturnMain other = (ReturnMain) object;
        if ((this.returnMainId == null && other.returnMainId != null) || (this.returnMainId != null && !this.returnMainId.equals(other.returnMainId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pos_project.classes.ReturnMain[ returnMainId=" + returnMainId + " ]";
    }

    public Double getReturnMainTotal() {
        return returnMainTotal;
    }

    public void setReturnMainTotal(Double returnMainTotal) {
        this.returnMainTotal = returnMainTotal;
    }
    
    
    public static int addReturnMain(ReturnMain c, Connection con){
        int result = -1;
        try{
//            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.INSERT_RETURN_MAIN;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setInt(1, c.getReturnMainInvoiceId());
            prepStatement.setString(2, c.getReturnMainNumber());
            
            prepStatement.setString(3 ,Formats.dateFormatSeconds.format(c.getReturnMainDate()));
            prepStatement.setDouble(4, c.getReturnMainTotal());
            prepStatement.setString(5, Formats.dateFormatDays.format(c.getReturnMainAddDate()));
            prepStatement.setString(6, c.getReturnMainAddUser());
            prepStatement.setInt(7, c.getReturnMainLocationId());
            
            
            
            
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

    
        public static int editReturnMain(ReturnMain c, Connection con){
        int result = -1;
        try{
//            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.UPDATE_RETURN_MAIN;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setInt(1, c.getReturnMainInvoiceId());
            prepStatement.setString(2, c.getReturnMainNumber());
            prepStatement.setString(3 ,Formats.dateFormatSeconds.format(c.getReturnMainDate()));
            prepStatement.setDouble(4, c.getReturnMainTotal());
            prepStatement.setString(5, Formats.dateFormatDays.format(c.getReturnMainEditDate()));
            prepStatement.setString(6, c.getReturnMainEditUser());
            prepStatement.setInt(7, c.getReturnMainLocationId());
            prepStatement.setInt(8, c.getReturnMainId());
            
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

    public static int deleteReturnMain(ReturnMain c, Connection con){
        int result = -1;
        try{
//            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.DELETE_RETURN_MAIN;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, c.getReturnMainEditUser());
            prepStatement.setString(2, c.getReturnMainEditUser());
            prepStatement.setString(3, Formats.dateFormatDays.format(c.getReturnMainEditDate()));
            prepStatement.setInt(4, c.getReturnMainId());
            
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
   
        
    
    public Integer getReturnMainLocationId() {
        return returnMainLocationId;
    }

    public void setReturnMainLocationId(Integer returnMainLocationId) {
        this.returnMainLocationId = returnMainLocationId;
    }
    
    
    public static int getLatestReturn(Connection con) throws SQLException{
        int invoiceId = 0;;
//        try{
//            Connection con = SQLConnection.getSQLConnection();
            Statement stmt = con.createStatement();
            String sql = SqlStatements.SELECT_LATEST_RETURN_MAIN;
            System.out.print(sql);
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                invoiceId = rs.getInt("return_main_id");
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
    
    public static ArrayList<ReturnMain> getReturnList(){
        ArrayList<ReturnMain> invoices = new ArrayList<ReturnMain>();
        try{
            Connection con = SQLConnection.getSQLConnection();
            Statement stmt = con.createStatement();
            String sql = SqlStatements.SELECT_ALL_RETURNS;
            System.out.print(sql);
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                ReturnMain invoice = new ReturnMain();
                invoice.setReturnMainId(rs.getInt("return_main_id"));
                invoice.setClientName(rs.getString("client_name"));
//                invoice.setSupplierName(rs.getString("supplier_name"));
//                invoice.setItemName(rs.getString("item_name"));
//                invoice.setItemPrice(rs.getDouble("item_price"));
//                invoice.setInvoicePrice(rs.getDouble("invoice_price"));
//                invoice.setInvoiceQuantity(rs.getInt("invoice_quantity"));
                invoice.setReturnMainTotal(rs.getDouble("return_main_total"));
                invoice.setReturnMainDate(rs.getTimestamp("return_main_date"));
                invoice.setInvoiceNumber(rs.getString("invoice_number"));
                invoice.setReturnMainNumber(rs.getString("return_main_number"));
                invoice.setReturnMainAddDate(rs.getTimestamp("return_main_add_date"));
                invoice.setReturnMainAddUser(rs.getString("add_user"));
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
     * @return the invoiceNumber
     */
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    /**
     * @param invoiceNumber the invoiceNumber to set
     */
    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }
    
    
    public static ReturnMain getReturnMain(int returnMainId){
//        ArrayList<ReturnMain> invoices = new ArrayList<ReturnMain>();
        ReturnMain invoice = new ReturnMain();
        try{
            Connection con = SQLConnection.getSQLConnection();
            Statement stmt = con.createStatement();
            String sql = SqlStatements.SELECT_RETURN_MAIN;
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setInt(1, returnMainId);
//            System.out.print(sql);
            ResultSet rs = prepStatement.executeQuery();
            
            while(rs.next()){
                
                invoice.setReturnMainId(rs.getInt("return_main_id"));
                invoice.setClientName(rs.getString("client_name"));
                invoice.setReturnMainInvoiceId(rs.getInt("return_main_invoice_id"));
                
//                invoice.setSupplierName(rs.getString("supplier_name"));
//                invoice.setItemName(rs.getString("item_name"));
//                invoice.setItemPrice(rs.getDouble("item_price"));
//                invoice.setInvoicePrice(rs.getDouble("invoice_price"));
//                invoice.setInvoiceQuantity(rs.getInt("invoice_quantity"));
                invoice.setReturnMainTotal(rs.getDouble("return_main_total"));
                invoice.setReturnMainDate(rs.getTimestamp("return_main_date"));
                invoice.setInvoiceNumber(rs.getString("invoice_number"));
                invoice.setReturnMainNumber(rs.getString("return_main_number"));
                invoice.setReturnMainAddDate(rs.getTimestamp("return_main_add_date"));
                invoice.setReturnMainAddUser(rs.getString("add_user"));
          
            }

            rs.close();
            stmt.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
//            e.getMessage();
        }
        return invoice;
//        return invoices;
    }
    
    public static ArrayList<ReturnMain> getInvoiceRetuirnsUsingId(String invoiceNumber){
        int result = -1;
        ArrayList<ReturnMain> arr = new ArrayList<ReturnMain>();
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.SELECT_RETURN_MAIN_LIST_USING_ID;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, invoiceNumber);
            ResultSet rs = prepStatement.executeQuery();
            while(rs.next()){
               ReturnMain r = new ReturnMain();
                r.setReturnMainId(rs.getInt("return_main_id"));
                r.setReturnMainNumber(rs.getString("return_main_number"));
                r.setReturnMainDate(rs.getDate("return_main_date"));
                r.setReturnMainAddDate(rs.getDate("return_main_add_date"));
                r.setReturnMainAddUser(rs.getString("add_user"));
                r.setReturnMainEditDate(rs.getDate("return_main_edit_date"));
                r.setReturnMainEditUser(rs.getString("edit_user"));
                arr.add(r);
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

    public Date getReturnMainDelDate() {
        return returnMainDelDate;
    }

    public void setReturnMainDelDate(Date returnMainDelDate) {
        this.returnMainDelDate = returnMainDelDate;
    }

    public Date getReturnMainEditDate() {
        return returnMainEditDate;
    }

    public void setReturnMainEditDate(Date returnMainEditDate) {
        this.returnMainEditDate = returnMainEditDate;
    }

    public String getReturnMainEditUser() {
        return returnMainEditUser;
    }

    public void setReturnMainEditUser(String returnMainEditUser) {
        this.returnMainEditUser = returnMainEditUser;
    }
}
