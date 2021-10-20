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
@Table(name = "stocks")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stocks.findAll", query = "SELECT s FROM Stocks s"),
    @NamedQuery(name = "Stocks.findByStocksId", query = "SELECT s FROM Stocks s WHERE s.stocksId = :stocksId"),
    @NamedQuery(name = "Stocks.findByStocksItemId", query = "SELECT s FROM Stocks s WHERE s.stocksItemId = :stocksItemId"),
    @NamedQuery(name = "Stocks.findByStocksLocationId", query = "SELECT s FROM Stocks s WHERE s.stocksLocationId = :stocksLocationId"),
    @NamedQuery(name = "Stocks.findByStocksQuantity", query = "SELECT s FROM Stocks s WHERE s.stocksQuantity = :stocksQuantity"),
    @NamedQuery(name = "Stocks.findByStockscol", query = "SELECT s FROM Stocks s WHERE s.stockscol = :stockscol")})
public class Stocks implements Serializable {
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "stocks_quantity")
    private Double stocksQuantity;
    @Column(name = "stocks_add_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date stocksAddDate;
    @Column(name = "stocks_add_user")
    private String stocksAddUser;
    @Column(name = "stocks_del_flag")
    private Short stocksDelFlag;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "stocks_id")
    private Integer stocksId;
    @Column(name = "stocks_item_id")
    private Integer stocksItemId;
    @Column(name = "stocks_location_id")
    private Integer stocksLocationId;
    @Column(name = "stockscol")
    private String stockscol;

    public Stocks() {
    }

    public Stocks(Integer stocksId) {
        this.stocksId = stocksId;
    }

    public Integer getStocksId() {
        return stocksId;
    }

    public void setStocksId(Integer stocksId) {
        this.stocksId = stocksId;
    }

    public Integer getStocksItemId() {
        return stocksItemId;
    }

    public void setStocksItemId(Integer stocksItemId) {
        this.stocksItemId = stocksItemId;
    }

    public Integer getStocksLocationId() {
        return stocksLocationId;
    }

    public void setStocksLocationId(Integer stocksLocationId) {
        this.stocksLocationId = stocksLocationId;
    }

//    public Integer getStocksQuantity() {
//        return stocksQuantity;
//    }
//
//    public void setStocksQuantity(Integer stocksQuantity) {
//        this.stocksQuantity = stocksQuantity;
//    }

    public String getStockscol() {
        return stockscol;
    }

    public void setStockscol(String stockscol) {
        this.stockscol = stockscol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stocksId != null ? stocksId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stocks)) {
            return false;
        }
        Stocks other = (Stocks) object;
        if ((this.stocksId == null && other.stocksId != null) || (this.stocksId != null && !this.stocksId.equals(other.stocksId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pos_project.classes.Stocks[ stocksId=" + stocksId + " ]";
    }
    
    public static int checkStocksExist(String itemId, String locationId){
        int client = -1;
        try{
            Connection con = SQLConnection.getSQLConnection();
            client = Stocks.checkStocksExist(itemId, locationId, con);
            con.close();
        }catch(Exception e){
            e.getMessage();
        }
        return client;
    }
    
    public static int checkStocksExist(String itemId, String locationId, Connection con){
        int client = -1;
        try{
            Statement stmt = con.createStatement();
            String sql = SqlStatements.SELECT_STOCKS_EXIST;
             PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, itemId);
            prepStatement.setString(2, locationId);
             ResultSet rs = prepStatement.executeQuery();
            
            while(rs.next()){
                client = rs.getInt("count");
                
            }

            rs.close();
            stmt.close();
//            con.close();
        }catch(Exception e){
            e.getMessage(); 
        }
        return client;
    }
    
    public static Stocks getStocks(String itemId, String locationId){
        Stocks client = new Stocks();
        try{
            Connection con = SQLConnection.getSQLConnection();
            client = Stocks.getStocks(itemId, locationId, con);
            con.close();
        }catch(Exception e){
            e.getMessage();
        }
        return client;
    }
    
    public static Stocks getStocks(String itemId, String locationId, Connection con){
        Stocks client = new Stocks();
        try{
            Statement stmt = con.createStatement();
            String sql = SqlStatements.SELECT_STOCKS;
             PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, itemId);
            prepStatement.setString(2, locationId);
             ResultSet rs = prepStatement.executeQuery();
            
            while(rs.next()){
                
                client.setStocksId(rs.getInt("stocks_id"));
                client.setStocksLocationId(rs.getInt("stocks_location_id"));
                client.setStocksItemId(rs.getInt("stocks_item_id"));
                client.setStocksQuantity(rs.getDouble("stocks_quantity"));
                
            }

            rs.close();
            stmt.close();
//            con.close();
        }catch(Exception e){
            e.getMessage();
        }
        return client;
    }
    
    
     public static int insertStocks(String itemId, String locationId, String quantity){
        int client = -1;
        try{
            Connection con = SQLConnection.getSQLConnection();
            client = Stocks.insertStocks(itemId, locationId,quantity, con);
            con.close();
        }catch(Exception e){
            e.getMessage();
        }
        return client;
    }
    
   public static Stocks calculateStocks(String itemId, String locationId){
        Stocks client = new Stocks();
        try{
            Connection con = SQLConnection.getSQLConnection();
            client = Stocks.calculateStocks(itemId, locationId, con);
            con.close();
        }catch(Exception e){
            e.getMessage();
        }
        return client;
    }
    
    public static Stocks calculateStocks(String itemId, String locationId, Connection con){
        Stocks client = new Stocks();
        try{
            Statement stmt = con.createStatement();
            String sql = SqlStatements.CALCULATE_STOCKS;
             PreparedStatement prepStatement = con.prepareStatement(sql);
             System.out.println(prepStatement);
            prepStatement.setString(1, itemId);
            prepStatement.setString(2, locationId);
            prepStatement.setString(3, itemId);
            prepStatement.setString(4, locationId);
             ResultSet rs = prepStatement.executeQuery();
            
            while(rs.next()){
                
                client.setStocksId(rs.getInt("stocks_id"));
                client.setStocksLocationId(rs.getInt("stocks_location_id"));
                client.setStocksItemId(rs.getInt("stocks_item_id"));
                client.setStocksQuantity(rs.getDouble("stocks_quantity"));
                
            }

            rs.close();
            stmt.close();
//            con.close();
        }catch(Exception e){
            e.getMessage();
        }
        return client;
    }
     
     
//OLD INSERT STOCKS//
     
//    public static int insertStocks(String itemId, String locationId, String quantity, Connection con){
//        int result = -1;
//        try{
//            Statement stmt = con.createStatement();
//            String sql = SqlStatements.INSERT_INTO_STOCKS;
//             PreparedStatement prepStatement = con.prepareStatement(sql);
//            prepStatement.setString(1, itemId);
//            prepStatement.setString(2, locationId);
//            prepStatement.setString(3, quantity);
//             result = prepStatement.executeUpdate();
//            
////            while(rs.next()){
////                client = rs.getInt("stocks_quantity");
////                
////            }
//
////            rs.close();
//            stmt.close();
////            con.close();
//        }catch(Exception e){
//            e.getMessage();
//        }
//        return result;
//    }
    
     public static int insertStocks(String itemId, String locationId, String quantity, Connection con){
        int result = -1;
        try{
            Statement stmt = con.createStatement();
            String sql = SqlStatements.INSERT_INTO_STOCKS;
             PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, itemId);
            prepStatement.setString(2, locationId);
            prepStatement.setString(3, quantity);
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
     
     
     public static int insertStocks(Stocks s, Connection con){
        int result = -1;
        try{
            Statement stmt = con.createStatement();
            String sql = SqlStatements.INSERT_INTO_STOCKS;
             PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setInt(1, s.getStocksItemId());
            prepStatement.setInt(2, s.getStocksLocationId());
            prepStatement.setDouble(3, s.getStocksQuantity());
            prepStatement.setShort(4, s.getStocksDelFlag());
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
    
       public static int updateStocks(String itemId, String locationId, String quantity, String stocksId){
        int client = -1;
        try{
            Connection con = SQLConnection.getSQLConnection();
            client = Stocks.updateStocks(itemId, locationId,quantity, stocksId, con);
            con.close();
        }catch(Exception e){
            e.getMessage();
        }
        return client;
    }
    
    public static int updateStocks(String itemId, String locationId, String quantity, String stocksId, Connection con){
        int result = -1;
        try{
            Statement stmt = con.createStatement();
            String sql = SqlStatements.UPDATE_STOCKS;
             PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, itemId);
            prepStatement.setString(2, locationId);
            prepStatement.setString(3, quantity);
            prepStatement.setString(4, stocksId);
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
    
     public static int deleteStocks(String stocksId){
        int client = -1;
        try{
            Connection con = SQLConnection.getSQLConnection();
            client = Stocks.deleteStocks(stocksId, con);
            con.close();
        }catch(Exception e){
            e.getMessage();
        }
        return client;
    }
    
     public static int deleteStocks(String stocksId, Connection con){
        int result = -1;
        try{
            Statement stmt = con.createStatement();
            String sql = SqlStatements.DELETE_STOCKS;
             PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, stocksId);
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

    public Date getStocksAddDate() {
        return stocksAddDate;
    }

    public void setStocksAddDate(Date stocksAddDate) {
        this.stocksAddDate = stocksAddDate;
    }

    public String getStocksAddUser() {
        return stocksAddUser;
    }

    public void setStocksAddUser(String stocksAddUser) {
        this.stocksAddUser = stocksAddUser;
    }

    public Short getStocksDelFlag() {
        return stocksDelFlag;
    }

    public void setStocksDelFlag(Short stocksDelFlag) {
        this.stocksDelFlag = stocksDelFlag;
    }

    public Double getStocksQuantity() {
        return stocksQuantity;
    }

    public void setStocksQuantity(Double stocksQuantity) {
        this.stocksQuantity = stocksQuantity;
    }
    
}
