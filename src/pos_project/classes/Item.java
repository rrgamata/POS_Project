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
@Table(name = "item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i"),
    @NamedQuery(name = "Item.findByItemNumber", query = "SELECT i FROM Item i WHERE i.itemId = :itemId"),
    @NamedQuery(name = "Item.findByItemName", query = "SELECT i FROM Item i WHERE i.itemName = :itemName"),
    @NamedQuery(name = "Item.findByItemClientNumber", query = "SELECT i FROM Item i WHERE i.itemClientNumber = :itemClientNumber"),
    @NamedQuery(name = "Item.findByItemQuantity", query = "SELECT i FROM Item i WHERE i.itemQuantity = :itemQuantity"),
    @NamedQuery(name = "Item.findByItemPrice", query = "SELECT i FROM Item i WHERE i.itemPrice = :itemPrice"),
    @NamedQuery(name = "Item.findByItemDelFlag", query = "SELECT i FROM Item i WHERE i.itemDelFlag = :itemDelFlag"),
    @NamedQuery(name = "Item.findByItemDelDate", query = "SELECT i FROM Item i WHERE i.itemDelDate = :itemDelDate")})

public class Item implements Serializable {
    @Column(name = "item_current_quantity")
    private Double itemCurrentQuantity;
    @Column(name =     "item_del_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date itemDelDate;
    @Column(name =     "item_date_as_of")
    @Temporal(TemporalType.TIMESTAMP)
    private Date itemDateAsOf;
    @Column(name =     "item_add_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date itemAddDate;
    @Column(name = "item_edit_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date itemEditDate;
    @Column(name = "item_add_user")
    private String itemAddUser;
    @Column(name = "item_edit_user")
    private String itemEditUser;
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "item_id")
    private Integer itemId;
    @Basic(optional = false)
    @Column(name = "item_name")
    private String itemName;
    @Column(name = "item_client_number")
    private Integer itemClientNumber;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "item_price")
    private Double itemPrice;
    @Column(name = "item_del_flag")
    private Short itemDelFlag;
    
    private String clientName;
    
    private Double quantity;
    private Double minQuantity;
   

    public Item() {
    }

    public Item(Integer itemId) {
        this.itemId = itemId;
    }

    public Item(Integer itemId, String itemName) {
        this.itemId = itemId;
        this.itemName = itemName;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Short getItemDelFlag() {
        return itemDelFlag;
    }

    public void setItemDelFlag(Short itemDelFlag) {
        this.itemDelFlag = itemDelFlag;
    }

    public Date getItemDelDate() {
        return itemDelDate;
    }

    public void setItemDelDate(Date itemDelDate) {
        this.itemDelDate = itemDelDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemId != null ? itemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.itemId == null && other.itemId != null) || (this.itemId != null && !this.itemId.equals(other.itemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pos_project.classes.Items[ itemId=" + itemId + " ]";
    }

    public Integer getItemClientNumber() {
        return itemClientNumber;
    }

    public void setItemClientNumber(Integer itemClientNumber) {
        this.itemClientNumber = itemClientNumber;
    }
    
     public  Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

   
    /**
     * Gets an ArrayList of Clients
     * @return employees
     */
    public static ArrayList<Item> getItemList(){
        ArrayList<Item> items = new ArrayList<Item>();
        try{
            Connection con = SQLConnection.getSQLConnection();
            Statement stmt = con.createStatement();
            String sql = SqlStatements.SELECT_ALL_ITEMS;
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                Item item = new Item();
                item.setItemId(rs.getInt("item_id"));
                item.setItemName(rs.getString("item_name"));
                item.setItemClientNumber(rs.getInt("item_client_number"));
                item.setItemPrice(rs.getDouble("item_price"));
                item.setClientName(rs.getString("client_name"));
                items.add(item);
            }

            rs.close();
            stmt.close();
            con.close();
        }catch(Exception e){
            e.getMessage();
        }
        return items;
    }
    
    public static ArrayList<Item> getItemListInStock(){
        ArrayList<Item> items = new ArrayList<Item>();
        try{
            Connection con = SQLConnection.getSQLConnection();
            Statement stmt = con.createStatement();
            String sql = SqlStatements.SELECT_ALL_ITEMS_IN_STOCK;
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                Item item = new Item();
                item.setItemId(rs.getInt("item_id"));
                item.setItemName(rs.getString("item_name"));
                item.setItemClientNumber(rs.getInt("item_client_number"));
                item.setItemPrice(rs.getDouble("item_price"));
                item.setClientName(rs.getString("client_name"));
                items.add(item);
            }

            rs.close();
            stmt.close();
            con.close();
        }catch(Exception e){
            e.getMessage();
        }
        return items;
    }
    
    
    public static ArrayList<Item> getItemListInStock(int locationId){
        ArrayList<Item> items = new ArrayList<Item>();
        try{
            Connection con = SQLConnection.getSQLConnection();
            Statement stmt = con.createStatement();
//            String sql = SqlStatements.SELECT_ALL_ITEMS_IN_STOCKS;
            String sql = SqlStatements.SELECT_ALL_ITEMS_WITH_STOCK;
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setInt(1, locationId);
            prepStatement.setInt(2, locationId);
                      System.out.println(prepStatement);  
            ResultSet rs = prepStatement.executeQuery();

            while(rs.next()){
                Item item = new Item();
                item.setItemId(rs.getInt("item_id"));
                item.setItemName(rs.getString("item_name"));
                item.setItemClientNumber(rs.getInt("item_client_number"));
                item.setItemPrice(rs.getDouble("item_price"));
                item.setClientName(rs.getString("client_name"));
                items.add(item);
            }

            rs.close();
            stmt.close();
            con.close();
        }catch(Exception e){
            e.getMessage();
        }
        return items;
    }
    
    public static ArrayList<Item> getItemListInStockLimit(int locationId){
        ArrayList<Item> items = new ArrayList<Item>();
        try{
            Connection con = SQLConnection.getSQLConnection();
            Statement stmt = con.createStatement();
            String sql = SqlStatements.SELECT_ALL_ITEMS_WITH_STOCKS_UNDER_LIMIT;
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setInt(1, locationId);
            prepStatement.setInt(2, locationId);
            prepStatement.setInt(3, locationId);
            
            ResultSet rs = prepStatement.executeQuery();
            System.out.println(prepStatement);
            while(rs.next()){
                Item item = new Item();
                item.setItemId(rs.getInt("item_id"));
                item.setItemName(rs.getString("item_name"));
                item.setItemClientNumber(rs.getInt("item_client_number"));
                item.setItemPrice(rs.getDouble("item_price"));
                item.setClientName(rs.getString("client_name"));
                item.setQuantity(rs.getDouble("stocks_quantity"));
                item.setMinQuantity(rs.getDouble("item_limit_quantity"));
                items.add(item);
            }

            rs.close();
            stmt.close();
            con.close();
        }catch(Exception e){
            e.getMessage();
            e.printStackTrace();
        }
        return items;
    }
    
    public static ArrayList<Item> getSupplierItemList(int supplierNumber){
        ArrayList<Item> items = new ArrayList<Item>();
        try{
            Connection con = SQLConnection.getSQLConnection();
            Statement stmt = con.createStatement();
            String sql = SqlStatements.SELECT_SUPPLIER_ITEMS;
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setInt(1, supplierNumber);
             ResultSet rs = prepStatement.executeQuery();

            while(rs.next()){
                Item item = new Item();
                item.setItemId(rs.getInt("item_id"));
                item.setItemName(rs.getString("item_name"));
                item.setItemClientNumber(rs.getInt("item_client_number"));
                item.setItemPrice(rs.getDouble("item_price"));
                item.setItemCurrentQuantity(rs.getDouble("item_current_quantity"));
                item.setItemDateAsOf(rs.getDate("item_date_as_of"));
                item.setClientName(rs.getString("client_name"));
                items.add(item);
            }

            rs.close();
            stmt.close();
            con.close();
        }catch(Exception e){
            e.getMessage();
        }
        return items;
    }
    
    public static ArrayList<Item> getAllItemList(){
        ArrayList<Item> items = new ArrayList<Item>();
        try{
            Connection con = SQLConnection.getSQLConnection();
            Statement stmt = con.createStatement();
            String sql = SqlStatements.SELECT_ALL_SUPPLIER_ITEMS;
            PreparedStatement prepStatement = con.prepareStatement(sql);
//            prepStatement.setInt(1, supplierNumber);
             ResultSet rs = prepStatement.executeQuery();

            while(rs.next()){
                Item item = new Item();
                item.setItemId(rs.getInt("item_id"));
                item.setItemName(rs.getString("item_name"));
                item.setItemClientNumber(rs.getInt("item_client_number"));
                item.setItemPrice(rs.getDouble("item_price"));
                item.setItemCurrentQuantity(rs.getDouble("item_current_quantity"));
                item.setItemDateAsOf(rs.getDate("item_date_as_of"));
                item.setClientName(rs.getString("client_name"));
                items.add(item);
            }

            rs.close();
            stmt.close();
            con.close();
        }catch(Exception e){
            e.getMessage();
        }
        return items;
    }
    
    public static ArrayList<Item> getSupplierItemList(int supplierNumber, int locationId){
        ArrayList<Item> items = new ArrayList<Item>();
        try{
            Connection con = SQLConnection.getSQLConnection();
            Statement stmt = con.createStatement();
            String sql = SqlStatements.SELECT_SUPPLIER_ITEMS_WITH_STOCK;
            PreparedStatement prepStatement = con.prepareStatement(sql);
//            prepStatement.setInt(1, supplierNumber);
//            prepStatement.setInt(2, locationId);
            prepStatement.setInt(1, locationId);
            prepStatement.setInt(2, locationId);
            prepStatement.setInt(3, supplierNumber);
            System.out.println(prepStatement);
             ResultSet rs = prepStatement.executeQuery();

            while(rs.next()){
                Item item = new Item();
                item.setItemId(rs.getInt("item_id"));
                item.setItemName(rs.getString("item_name"));
                item.setItemClientNumber(rs.getInt("item_client_number"));
                item.setItemPrice(rs.getDouble("item_price"));
                item.setItemCurrentQuantity(rs.getDouble("stocks_quantity"));
                item.setItemDateAsOf(rs.getDate("item_date_as_of"));
                item.setClientName(rs.getString("client_name"));
                items.add(item);
            }

            rs.close();
            stmt.close();
            con.close();
        }catch(Exception e){
            e.getMessage();
        }
        return items;
    }
    
       public static Item getItem(String itemNumber){
       Item item = new Item();
        try{
            Connection con = SQLConnection.getSQLConnection();
            Statement stmt = con.createStatement();
            String sql = SqlStatements.SELECT_ITEM;
             PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, itemNumber);
             ResultSet rs = prepStatement.executeQuery();
            
            while(rs.next()){
                
                item.setItemName(rs.getString("item_name"));
                item.setItemClientNumber(rs.getInt("item_client_number"));
                item.setItemPrice(rs.getDouble("item_price"));
                item.setClientName(rs.getString("client_name"));
                item.setItemCurrentQuantity(rs.getDouble("item_current_quantity"));
                
            }

            rs.close();
            stmt.close();
            con.close();
        }catch(Exception e){
            e.getMessage();
        }
        return item;
    }
       
       
       public static Item getItem(String itemNumber, Connection con) throws SQLException{
       Item item = new Item();
//        try{
//            Connection con = SQLConnection.getSQLConnection();
            Statement stmt = con.createStatement();
            String sql = SqlStatements.SELECT_ITEM;
             PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, itemNumber);
             ResultSet rs = prepStatement.executeQuery();
            
            while(rs.next()){
                item.setItemId(rs.getInt("item_id"));
                item.setItemName(rs.getString("item_name"));
                item.setItemClientNumber(rs.getInt("item_client_number"));
                item.setItemPrice(rs.getDouble("item_price"));
                item.setClientName(rs.getString("client_name"));
                item.setItemCurrentQuantity(rs.getDouble("item_current_quantity"));
                
            }

            rs.close();
            stmt.close();
//            con.close();
//        }catch(Exception e){
//            e.getMessage();
//        }
        return item;
    }
       
    public static Item getItemStatus(String itemNumber){
       Item item = new Item();
        try{
            Connection con = SQLConnection.getSQLConnection();
            Statement stmt = con.createStatement();
            String sql = SqlStatements.SELECT_FULL_ITEM;
             PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, itemNumber);
             ResultSet rs = prepStatement.executeQuery();
            
            while(rs.next()){
                item.setItemId(rs.getInt("item_id"));
                item.setItemClientNumber(rs.getInt("item_client_number"));
                item.setItemName(rs.getString("item_name"));
                item.setItemPrice(rs.getDouble("item_price"));
                item.setClientName(rs.getString("client_name"));
                item.setQuantity(rs.getDouble("item_current_quantity"));
                item.setItemCurrentQuantity(rs.getDouble("item_current_quantity"));
                
            }

            rs.close();
            stmt.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
//            e.getMessage();
        }
        return item;
    }
    
    public static int addItem(Item c){
        int result = -1;
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.INSERT_INTO_ITEMS;
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, c.getItemName());
            prepStatement.setInt(2, c.getItemClientNumber());
            prepStatement.setDouble(3, c.getItemPrice());
            prepStatement.setString(4, Formats.dateFormatMinutes.format(c.getItemAddDate()));
            prepStatement.setString(5, c.getItemAddUser());
            
            result = prepStatement.executeUpdate();
            
            prepStatement.close();
            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
    
        public static int editItem(Item c){
        int result = -1;
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.UPDATE_ITEM;
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, c.getItemName());
            prepStatement.setInt(2, c.getItemClientNumber());
            prepStatement.setDouble(3, c.getItemPrice());
            prepStatement.setString(4, Formats.dateFormatMinutes.format(c.getItemEditDate()));
            prepStatement.setString(5, c.getItemEditUser());
            prepStatement.setInt(6, c.getItemId());
            
            
            System.out.println(prepStatement);
            result = prepStatement.executeUpdate();
            
            prepStatement.close();
            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

        
    public static int updateItemQuantity(int itemNumber , int itemQuantity , String dateAsOf){
        int result = -1;
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.UPDATE_ITEM_QUANTITY;
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setInt(1, itemQuantity);
            prepStatement.setInt(2,  itemNumber);
            prepStatement.setString(3, dateAsOf);
//            prepStatement.setDouble(3, c.getItemPrice());
//            prepStatement.setInt(4, c.getItemId());
            
            
            System.out.println(prepStatement);
            result = prepStatement.executeUpdate();
            
            prepStatement.close();
            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
    
    
    public static int updateItemQuantity(int itemNumber , Double itemQuantity , String dateAsOf, Connection con) throws SQLException{
        int result = -1;
//        try{
//            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.UPDATE_ITEM_QUANTITY;
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setDouble(1, itemQuantity);
            prepStatement.setString(2, dateAsOf);
            prepStatement.setInt(3,  itemNumber);
            
//            prepStatement.setDouble(3, c.getItemPrice());
//            prepStatement.setInt(4, c.getItemId());
            
            
            System.out.println(prepStatement);
            result = prepStatement.executeUpdate();
            
            prepStatement.close();
//            con.close();
//        }catch(Exception e){
////            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
        return result;
    }
    
     public static int deleteItem(String itemNumber){
        int result = -1;
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.DELETE_ITEM;
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, Formats.dateFormatSeconds.format(new GregorianCalendar().getTime()));
            prepStatement.setInt(2, Integer.parseInt(itemNumber));
            
            
            System.out.println(prepStatement);
            result = prepStatement.executeUpdate();
            
            prepStatement.close();
            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return result;
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
    
//    public Integer getItemCurrentQuantity() {
//        return itemCurrentQuantity;
//    }

//    public void setItemCurrentQuantity(Integer itemCurrentQuantity) {
//        this.itemCurrentQuantity = itemCurrentQuantity;
//    }

    public Date getItemDateAsOf() {
        return itemDateAsOf;
    }

    public void setItemDateAsOf(Date itemDateAsOf) {
        this.itemDateAsOf = itemDateAsOf;
    }

//    public Date getItemDelDate() {
//        return itemDelDate;
//    }
//
//    public void setItemDelDate(Date itemDelDate) {
//        this.itemDelDate = itemDelDate;
//    }
//
//    public Date getItemDateAsOf() {
//        return itemDateAsOf;
//    }
//
//    public void setItemDateAsOf(Date itemDateAsOf) {
//        this.itemDateAsOf = itemDateAsOf;
//    }

    public Date getItemAddDate() {
        return itemAddDate;
    }

    public void setItemAddDate(Date itemAddDate) {
        this.itemAddDate = itemAddDate;
    }

    public String getItemAddUser() {
        return itemAddUser;
    }

    public void setItemAddUser(String itemAddUser) {
        this.itemAddUser = itemAddUser;
    }

    public Date getItemEditDate() {
        return itemEditDate;
    }

    public void setItemEditDate(Date itemEditDate) {
        this.itemEditDate = itemEditDate;
    }

    public String getItemEditUser() {
        return itemEditUser;
    }

    public void setItemEditUser(String itemEditUser) {
        this.itemEditUser = itemEditUser;
    }

//    public Date getItemDelDate() {
//        return itemDelDate;
//    }
//
//    public void setItemDelDate(Date itemDelDate) {
//        this.itemDelDate = itemDelDate;
//    }
//
//    public Date getItemDateAsOf() {
//        return itemDateAsOf;
//    }
//
//    public void setItemDateAsOf(Date itemDateAsOf) {
//        this.itemDateAsOf = itemDateAsOf;
//    }
//
//    public Date getItemAddDate() {
//        return itemAddDate;
//    }
//
//    public void setItemAddDate(Date itemAddDate) {
//        this.itemAddDate = itemAddDate;
//    }
//
//    public Date getItemEditDate() {
//        return itemEditDate;
//    }
//
//    public void setItemEditDate(Date itemEditDate) {
//        this.itemEditDate = itemEditDate;
//    }

    /**
     * @return the minQuantity
     */
    public Double getMinQuantity() {
        return minQuantity;
    }

    /**
     * @param minQuantity the minQuantity to set
     */
    public void setMinQuantity(Double minQuantity) {
        this.minQuantity = minQuantity;
    }

    public Double getItemCurrentQuantity() {
        return itemCurrentQuantity;
    }

    public void setItemCurrentQuantity(Double itemCurrentQuantity) {
        this.itemCurrentQuantity = itemCurrentQuantity;
    }
    
    public static ArrayList<Item> getSalesSupplier(int clientNumber, int locationId, String fromDate, String toDate ){
       ArrayList<Item> itemList = new ArrayList<Item>();
        try{
            Connection con = SQLConnection.getSQLConnection();
            Statement stmt = con.createStatement();
            String sql = SqlStatements.SELECT_DET_SALES_SUPPLIER;
             PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setInt(1, locationId);
            prepStatement.setInt(2, clientNumber);
            prepStatement.setString(3, fromDate);
            prepStatement.setString(4, toDate);
             ResultSet rs = prepStatement.executeQuery();
             System.out.println(prepStatement);
            
             while(rs.next()){
                Item item = new Item();
                item.setItemClientNumber(rs.getInt("item_client_number"));
                item.setItemName(rs.getString("item_name"));
                item.setClientName(rs.getString("client_name"));
                item.setQuantity(rs.getDouble("quantity"));
                item.setItemCurrentQuantity(rs.getDouble("returns"));
                itemList.add(item);
            }

            rs.close();
            stmt.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
//            e.getMessage();
        }
        return itemList;
    }

}
