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
import java.sql.Statement;
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
@Table(name = "transfer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transfer.findAll", query = "SELECT t FROM Transfer t"),
    @NamedQuery(name = "Transfer.findByTransferId", query = "SELECT t FROM Transfer t WHERE t.transferId = :transferId"),
    @NamedQuery(name = "Transfer.findByTransferFromInvoiceId", query = "SELECT t FROM Transfer t WHERE t.transferFromInvoiceId = :transferFromInvoiceId"),
    @NamedQuery(name = "Transfer.findByTransferToInvoiceId", query = "SELECT t FROM Transfer t WHERE t.transferToInvoiceId = :transferToInvoiceId"),
    @NamedQuery(name = "Transfer.findByTransferAddDate", query = "SELECT t FROM Transfer t WHERE t.transferAddDate = :transferAddDate"),
    @NamedQuery(name = "Transfer.findByTransferAddUser", query = "SELECT t FROM Transfer t WHERE t.transferAddUser = :transferAddUser")})
public class Transfer implements Serializable {
    @Column(name = "transfer_add_user")
    private String transferAddUser;
    @Column(name = "transfer_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transferDate;
    @Column(name = "transfer_number")
    private String transferNumber;
    @Column(name = "transfer_edit_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transferEditDate;
    @Column(name = "transfer_edit_user")
    private String transferEditUser;
    @Column(name = "transfer_del_flag")
    private Short transferDelFlag;
    @Column(name = "transfer_del_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transferDelDate;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "transfer_id")
    private Integer transferId;
    @Column(name = "transfer_from_invoice_id")
    private Integer transferFromInvoiceId;
    @Column(name = "transfer_to_invoice_id")
    private Integer transferToInvoiceId;
    @Column(name = "transfer_add_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transferAddDate;
//    @Column(name = "transfer_add_user")
//    private String transferAddUser;
    private String fromName;
    private String tomName;
    private int fromLocationId;
    private int toLocationId;

    public Transfer() {
    }

    public Transfer(Integer transferId) {
        this.transferId = transferId;
    }

    public Integer getTransferId() {
        return transferId;
    }

    public void setTransferId(Integer transferId) {
        this.transferId = transferId;
    }

    public Integer getTransferFromInvoiceId() {
        return transferFromInvoiceId;
    }

    public void setTransferFromInvoiceId(Integer transferFromInvoiceId) {
        this.transferFromInvoiceId = transferFromInvoiceId;
    }

    public Integer getTransferToInvoiceId() {
        return transferToInvoiceId;
    }

    public void setTransferToInvoiceId(Integer transferToInvoiceId) {
        this.transferToInvoiceId = transferToInvoiceId;
    }

    public Date getTransferAddDate() {
        return transferAddDate;
    }

    public void setTransferAddDate(Date transferAddDate) {
        this.transferAddDate = transferAddDate;
    }

    public String getTransferAddUser() {
        return transferAddUser;
    }

    public void setTransferAddUser(String transferAddUser) {
        this.transferAddUser = transferAddUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transferId != null ? transferId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transfer)) {
            return false;
        }
        Transfer other = (Transfer) object;
        if ((this.transferId == null && other.transferId != null) || (this.transferId != null && !this.transferId.equals(other.transferId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pos_project.classes.Transfer[ transferId=" + transferId + " ]";
    }
    
//    public static int checkStocksExist(String itemId, String locationId){
//        int client = -1;
//        try{
//            Connection con = SQLConnection.getSQLConnection();
//            client = Stocks.checkStocksExist(itemId, locationId, con);
//            con.close();
//        }catch(Exception e){
//            e.getMessage();
//        }
//        return client;
//    }
//    
//    public static int checkStocksExist(String itemId, String locationId, Connection con){
//        int client = -1;
//        try{
//            Statement stmt = con.createStatement();
//            String sql = SqlStatements.SELECT_STOCKS_EXIST;
//             PreparedStatement prepStatement = con.prepareStatement(sql);
//            prepStatement.setString(1, itemId);
//            prepStatement.setString(2, locationId);
//             ResultSet rs = prepStatement.executeQuery();
//            
//            while(rs.next()){
//                client = rs.getInt("count");
//                
//            }
//
//            rs.close();
//            stmt.close();
////            con.close();
//        }catch(Exception e){
//            e.getMessage(); 
//        }
//        return client;
//    }
    
//    public static Stocks getStocks(String itemId, String locationId){
//        Stocks client = new Stocks();
//        try{
//            Connection con = SQLConnection.getSQLConnection();
//            client = Stocks.getStocks(itemId, locationId, con);
//            con.close();
//        }catch(Exception e){
//            e.getMessage();
//        }
//        return client;
//    }
    
    public static ArrayList<Transfer> getTransfers(){
        ArrayList<Transfer>  trans = new ArrayList<Transfer>();
        try{
            Connection con = SQLConnection.getSQLConnection();
            Statement stmt = con.createStatement();
            String sql = SqlStatements.SELECT_TRANSFERS;
             PreparedStatement prepStatement = con.prepareStatement(sql);
             ResultSet rs = prepStatement.executeQuery();
            
            while(rs.next()){
        Transfer client = new Transfer();        
                client.setTransferNumber(rs.getString("transfer_number"));
                client.setTransferId(rs.getInt("transfer_id"));
                client.setFromName(rs.getString("from_name"));
                client.setTomName(rs.getString("to_name"));
                client.setTransferDate(rs.getDate("transfer_date"));
//                client.StocksQuantity(rs.getInt("stocks_quantity"));
//                client.setStocksQuantity(rs.getInt("stocks_quantity"));
                trans.add(client);
            }

            rs.close();
            stmt.close();
//            con.close();
        }catch(Exception e){
            e.getMessage();
        }
        return trans;
    }
    
    
    public static ArrayList<Transfer> getTransfers(String fromDate, String toDate){
        ArrayList<Transfer>  trans = new ArrayList<Transfer>();
        try{
            Connection con = SQLConnection.getSQLConnection();
            Statement stmt = con.createStatement();
            String sql = SqlStatements.SELECT_TRANSFERS_FROM;
             PreparedStatement prepStatement = con.prepareStatement(sql);
             prepStatement.setString(1, fromDate);
             prepStatement.setString(2, toDate);
             ResultSet rs = prepStatement.executeQuery();
            
            while(rs.next()){
        Transfer client = new Transfer();        
                client.setTransferNumber(rs.getString("transfer_number"));
                client.setTransferId(rs.getInt("transfer_id"));
                client.setFromName(rs.getString("from_name"));
                client.setTomName(rs.getString("to_name"));
                client.setTransferDate(rs.getDate("transfer_date"));
                client.setTransferFromInvoiceId(rs.getInt("transfer_from_invoice_id"));
                client.setTransferToInvoiceId(rs.getInt("transfer_to_invoice_id"));
                client.setTransferId(rs.getInt("transfer_id"));
                
                
                trans.add(client);
            }

            rs.close();
            stmt.close();
//            con.close();
        }catch(Exception e){
            e.getMessage();
        }
        return trans;
    }
    
    
    
     public static Transfer getTransfer(String transferId ){
        Transfer client = new Transfer();        
        try{
            Connection con = SQLConnection.getSQLConnection();
            Statement stmt = con.createStatement();
            String sql = SqlStatements.SELECT_TRANSFER;
             PreparedStatement prepStatement = con.prepareStatement(sql);
             prepStatement.setString(1, transferId);
             ResultSet rs = prepStatement.executeQuery();
            
            while(rs.next()){
        
                client.setTransferNumber(rs.getString("transfer_number"));
                client.setTransferFromInvoiceId(rs.getInt("transfer_from_invoice_id"));
                client.setTransferToInvoiceId(rs.getInt("transfer_to_invoice_id"));
                client.setTransferId(rs.getInt("transfer_id"));
                client.setFromName(rs.getString("from_name"));
                client.setTomName(rs.getString("to_name"));
                client.setTransferDate(rs.getDate("transfer_date"));
                client.setFromLocationId(rs.getInt("from_location"));
                client.setToLocationId(rs.getInt("to_location"));
             
            }
            rs.close();
            stmt.close();
//            con.close();
        }catch(Exception e){
            e.getMessage();
        }
        return client;
    }
    
    
     public static int insertTransfer(String transferNumber, String fromInvoiceId, String toInvoiceId, String date){
        int client = -1;
        try{
            Connection con = SQLConnection.getSQLConnection();
            client = Transfer.insertTransfer(transferNumber, fromInvoiceId, toInvoiceId,date, con);
            con.close();
        }catch(Exception e){
            e.getMessage();
        }
        return client;
    }
    
    public static int insertTransfer(String transferNumber,String fromId, String toId, String date, Connection con){
        int result = -1;
        try{
            Statement stmt = con.createStatement();
            String sql = SqlStatements.INSERT_INTO_TRANSFER;
             PreparedStatement prepStatement = con.prepareStatement(sql);
             prepStatement.setString(1, transferNumber);
            prepStatement.setString(2, fromId);
            prepStatement.setString(3, toId);
            prepStatement.setString(4, date);
            prepStatement.setString(5, Formats.dateFormatSeconds.format(new GregorianCalendar().getTime()));
            prepStatement.setString(6, System.getProperty("userName"));
             result = prepStatement.executeUpdate();
            
//            while(rs.next()){
//                client = rs.getInt("stocks_quantity");
//                
//            }

//            rs.close();
            stmt.close();
//            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
    
    
    public static int updateTransfer(String transferNumber, String date, int transferId ){
        int client = -1;
        try{
            Connection con = SQLConnection.getSQLConnection();
            client = Transfer.updateTransfer(transferNumber, date, transferId, con);
            con.close();
        }catch(Exception e){
            e.getMessage();
        }
        return client;
    }
    
    public static int updateTransfer(String transferNumber, String date, int transferId, Connection con){
        int result = -1;
        try{
            Statement stmt = con.createStatement();
            String sql = SqlStatements.UPDATE_TRANSFER;
             PreparedStatement prepStatement = con.prepareStatement(sql);
             prepStatement.setString(1, transferNumber);
            prepStatement.setString(2, date);
            prepStatement.setString(3, Formats.dateFormatSeconds.format(new GregorianCalendar().getTime()));
            prepStatement.setString(4, System.getProperty("userName"));
            prepStatement.setInt(5, transferId);
            
             result = prepStatement.executeUpdate();
            
//            while(rs.next()){
//                client = rs.getInt("stocks_quantity");
//                
//            }

//            rs.close();
            stmt.close();
//            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
    
       public static int deleteTransfer(String transferId){
        int client = -1;
        try{
            Connection con = SQLConnection.getSQLConnection();
            client = Transfer.deleteTransfer(transferId, con);
            con.close();
        }catch(Exception e){
            e.getMessage();
        }
        return client;
    }
    
    public static int deleteTransfer(String itemId, Connection con){
        int result = -1;
        try{
            Statement stmt = con.createStatement();
            String sql = SqlStatements.DELETE_TRANSFER;
             PreparedStatement prepStatement = con.prepareStatement(sql);
            
            prepStatement.setString(1, Formats.dateFormatSeconds.format(new GregorianCalendar().getTime()));
            prepStatement.setString(2, itemId);
             result = prepStatement.executeUpdate();
            
//            while(rs.next()){
//                client = rs.getInt("stocks_quantity");
//                
//            }

//            rs.close();
            stmt.close();
//            con.close();
        }catch(Exception e){
            e.getMessage();
        }
        return result;
    }

    public String getTransferNumber() {
        return transferNumber;
    }

    public void setTransferNumber(String transferNumber) {
        this.transferNumber = transferNumber;
    }

    public Date getTransferEditDate() {
        return transferEditDate;
    }

    public void setTransferEditDate(Date transferEditDate) {
        this.transferEditDate = transferEditDate;
    }

    public String getTransferEditUser() {
        return transferEditUser;
    }

    public void setTransferEditUser(String transferEditUser) {
        this.transferEditUser = transferEditUser;
    }

    public Short getTransferDelFlag() {
        return transferDelFlag;
    }

    public void setTransferDelFlag(Short transferDelFlag) {
        this.transferDelFlag = transferDelFlag;
    }

    public Date getTransferDelDate() {
        return transferDelDate;
    }

    public void setTransferDelDate(Date transferDelDate) {
        this.transferDelDate = transferDelDate;
    }

    /**
     * @return the fromName
     */
    public String getFromName() {
        return fromName;
    }

    /**
     * @param fromName the fromName to set
     */
    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    /**
     * @return the tomName
     */
    public String getTomName() {
        return tomName;
    }

    /**
     * @param tomName the tomName to set
     */
    public void setTomName(String tomName) {
        this.tomName = tomName;
    }

//    public String getTransferAddUser() {
//        return transferAddUser;
//    }
//
//    public void setTransferAddUser(String transferAddUser) {
//        this.transferAddUser = transferAddUser;
//    }

    public Date getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }

    /**
     * @return the fromLocationId
     */
    public int getFromLocationId() {
        return fromLocationId;
    }

    /**
     * @param fromLocationId the fromLocationId to set
     */
    public void setFromLocationId(int fromLocationId) {
        this.fromLocationId = fromLocationId;
    }

    /**
     * @return the toLocationId
     */
    public int getToLocationId() {
        return toLocationId;
    }

    /**
     * @param toLocationId the toLocationId to set
     */
    public void setToLocationId(int toLocationId) {
        this.toLocationId = toLocationId;
    }
    
}

