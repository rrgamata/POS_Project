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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cifer
 */
@Entity
@Table(name = "item_limit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemLimit.findAll", query = "SELECT i FROM ItemLimit i"),
    @NamedQuery(name = "ItemLimit.findByItemLimitId", query = "SELECT i FROM ItemLimit i WHERE i.itemLimitId = :itemLimitId"),
    @NamedQuery(name = "ItemLimit.findByItemLimitItemId", query = "SELECT i FROM ItemLimit i WHERE i.itemLimitItemId = :itemLimitItemId"),
    @NamedQuery(name = "ItemLimit.findByItemLimitLocationId", query = "SELECT i FROM ItemLimit i WHERE i.itemLimitLocationId = :itemLimitLocationId"),
    @NamedQuery(name = "ItemLimit.findByItemLimitQuantity", query = "SELECT i FROM ItemLimit i WHERE i.itemLimitQuantity = :itemLimitQuantity")})
public class ItemLimit implements Serializable {
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "item_limit_quantity")
    private Double itemLimitQuantity;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "item_limit_id")
    private Integer itemLimitId;
    @Column(name = "item_limit_item_id")
    private Integer itemLimitItemId;
    @Column(name = "item_limit_location_id")
    private Integer itemLimitLocationId;

    public ItemLimit() {
    }

    public ItemLimit(Integer itemLimitId) {
        this.itemLimitId = itemLimitId;
    }

    public Integer getItemLimitId() {
        return itemLimitId;
    }

    public void setItemLimitId(Integer itemLimitId) {
        this.itemLimitId = itemLimitId;
    }

    public Integer getItemLimitItemId() {
        return itemLimitItemId;
    }

    public void setItemLimitItemId(Integer itemLimitItemId) {
        this.itemLimitItemId = itemLimitItemId;
    }

    public Integer getItemLimitLocationId() {
        return itemLimitLocationId;
    }

    public void setItemLimitLocationId(Integer itemLimitLocationId) {
        this.itemLimitLocationId = itemLimitLocationId;
    }

//    public Integer getItemLimitQuantity() {
//        return itemLimitQuantity;
//    }
//
//    public void setItemLimitQuantity(Integer itemLimitQuantity) {
//        this.itemLimitQuantity = itemLimitQuantity;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemLimitId != null ? itemLimitId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemLimit)) {
            return false;
        }
        ItemLimit other = (ItemLimit) object;
        if ((this.itemLimitId == null && other.itemLimitId != null) || (this.itemLimitId != null && !this.itemLimitId.equals(other.itemLimitId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pos_project.classes.ItemLimit[ itemLimitId=" + itemLimitId + " ]";
    }
    
     public static int checkItemLimitExist(String itemId, String locationId){
        int client = -1;
        try{
            Connection con = SQLConnection.getSQLConnection();
            client = ItemLimit.checkItemLimitExist(itemId, locationId, con);
            con.close();
        }catch(Exception e){
            e.getMessage();
        }
        return client;
    }
    
    
    public static int checkItemLimitExist(String itemId, String locationId, Connection con){
        int client = -1;
        try{
            Statement stmt = con.createStatement();
            String sql = SqlStatements.SELECT_ITEM_LIMIT_EXIST;
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
    
      public static int insertItemLimit(String itemId, String locationId, String quantity){
        int client = -1;
        try{
            Connection con = SQLConnection.getSQLConnection();
            client = ItemLimit.insertItemLimit(itemId, locationId,quantity, con);
            con.close();
        }catch(Exception e){
            e.getMessage();
        }
        return client;
    }
    
    public static int insertItemLimit(String itemId, String locationId, String quantity, Connection con){
        int result = -1;
        try{
            Statement stmt = con.createStatement();
            String sql = SqlStatements.INSERT_INTO_ITEM_LIMIT;
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
    
       public static int updateItemLimit(String itemId, String locationId, String quantity, String stocksId){
        int client = -1;
        try{
            Connection con = SQLConnection.getSQLConnection();
            client = ItemLimit.updateItemLimit(itemId, locationId,quantity, stocksId, con);
            con.close();
        }catch(Exception e){
            e.getMessage();
        }
        return client;
    }
    
    public static int updateItemLimit(String itemId, String locationId, String quantity, String stocksId, Connection con){
        int result = -1;
        try{
            Statement stmt = con.createStatement();
            String sql = SqlStatements.UPDATE_ITEM_LIMIT;
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
            e.printStackTrace();
        }
        return result;
    }
    
     public static ItemLimit getItemLimit(String itemId, String locationId){
        ItemLimit client = new ItemLimit();
        try{
            Connection con = SQLConnection.getSQLConnection();
            client = ItemLimit.getItemLimit(itemId, locationId, con);
            con.close();
        }catch(Exception e){
            e.getMessage();
        }
        return client;
    }
    
    public static ItemLimit getItemLimit(String itemId, String locationId, Connection con){
        ItemLimit client = new ItemLimit();
        try{
            Statement stmt = con.createStatement();
            String sql = SqlStatements.SELECT_ITEM_LIMIT;
             PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, itemId);
            prepStatement.setString(2, locationId);
             ResultSet rs = prepStatement.executeQuery();
            
            while(rs.next()){
                
                client.setItemLimitId(rs.getInt("item_limit_id"));
                client.setItemLimitLocationId(rs.getInt("item_limit_location_id"));
                client.setItemLimitItemId(rs.getInt("item_limit_item_id"));
                client.setItemLimitQuantity(rs.getDouble("item_limit_quantity"));
                
            }

            rs.close();
            stmt.close();
//            con.close();
        }catch(Exception e){
            e.getMessage();
        }
        return client;
    }

    public Double getItemLimitQuantity() {
        return itemLimitQuantity;
    }

    public void setItemLimitQuantity(Double itemLimitQuantity) {
        this.itemLimitQuantity = itemLimitQuantity;
    }
}
