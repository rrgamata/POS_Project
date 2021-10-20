/*
 * To change this template, choose Tools | Templates
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
@Table(name = "client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findByClientId", query = "SELECT c FROM Client c WHERE c.clientId = :clientId"),
    @NamedQuery(name = "Client.findByClientName", query = "SELECT c FROM Client c WHERE c.clientName = :clientName"),
    @NamedQuery(name = "Client.findByClientPhone", query = "SELECT c FROM Client c WHERE c.clientPhone = :clientPhone"),
    @NamedQuery(name = "Client.findByClientAddress", query = "SELECT c FROM Client c WHERE c.clientAddress = :clientAddress"),
    @NamedQuery(name = "Client.findByClientDelFlag", query = "SELECT c FROM Client c WHERE c.clientDelFlag = :clientDelFlag"),
    @NamedQuery(name = "Client.findByClientDateDel", query = "SELECT c FROM Client c WHERE c.clientDateDel = :clientDateDel")})
public class Client implements Serializable {

    /**
     * @return the clientTypeList
     */
    public static String[] getClientSubTypeList() {
        return clientSubTypeList;
    }

    /**
     * @param aClientTypeList the clientTypeList to set
     */
    public static void setClientSubTypeList(String[] aClientTypeList) {
        clientSubTypeList = aClientTypeList;
    }

    @Column(name = "client_sub_type")
    private Short clientSubType;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "client_credit_limit")
    private Double clientCreditLimit;
    @Column(name = "client_number")
    private String clientNumber;
    @Column(name = "client_del_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date clientDelDate;
    @Column(name = "client_add_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date clientAddDate;
    @Column(name = "client_edit_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date clientEditDate;
    @Column(name = "client_add_user")
    private String clientAddUser;
    @Column(name = "client_edit_user")
    private String clientEditUser;
    @Column(name = "client_type_flag")
    private Short clientTypeFlag;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "client_id")
    private Integer clientId;
    @Column(name = "client_name")
    private String clientName;
    @Column(name = "client_phone")
    private String clientPhone;
    @Column(name = "client_address")
    private String clientAddress;
    @Column(name = "client_del_flag")
    private Short clientDelFlag;
    @Column(name = "client_date_del")
    @Temporal(TemporalType.TIMESTAMP)
    private Date clientDateDel;
    
    private static String[] clientSubTypeList = {"N/A", "Seeds", "Feeds", "Fertilizer", "Ag-Chem"};

    public Client() {
    }

    public Client(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public Short getClientDelFlag() {
        return clientDelFlag;
    }

    public void setClientDelFlag(Short clientDelFlag) {
        this.clientDelFlag = clientDelFlag;
    }

    public Date getClientDateDel() {
        return clientDateDel;
    }

    public void setClientDateDel(Date clientDateDel) {
        this.clientDateDel = clientDateDel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientId != null ? clientId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.clientId == null && other.clientId != null) || (this.clientId != null && !this.clientId.equals(other.clientId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        return "pos_project.classes.Client[ clientId=" + clientId + " ]";
        return clientName;
    }

    public Date getClientDelDate() {
        return clientDelDate;
    }

    public void setClientDelDate(Date clientDelDate) {
        this.clientDelDate = clientDelDate;
    }

    public Short getClientTypeFlag() {
        return clientTypeFlag;
    }

    public void setClientTypeFlag(Short clientTypeFlag) {
        this.clientTypeFlag = clientTypeFlag;
    }
    
     /**
     * Gets an ArrayList of Clients
     * @return employees
     */
    public static ArrayList<Client> getClientList(){
        ArrayList<Client> clients = new ArrayList<Client>();
        try{
            Connection con = SQLConnection.getSQLConnection();
            Statement stmt = con.createStatement();
            String sql = SqlStatements.SELECT_ALL_CLIENTS;
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                Client client = new Client();
                client.setClientNumber(rs.getString("client_number"));
                client.setClientId(rs.getInt("client_Id"));
                client.setClientAddress(rs.getString("client_address"));
                client.setClientName(rs.getString("client_name"));
                client.setClientPhone(rs.getString("client_phone"));
                client.setClientTypeFlag(rs.getShort("client_type_flag"));
                client.setClientSubType(rs.getShort("client_sub_type"));
                clients.add(client);
            }

            rs.close();
            stmt.close();
            con.close();
        }catch(Exception e){
            e.getMessage();
        }
        return clients;
    }
    
    
    
//    public static ArrayList<Client> getSupplierList(){
//        ArrayList<Client> clients = new ArrayList<Client>();
//        try{
//            Connection con = SQLConnection.getSQLConnection();
//            Statement stmt = con.createStatement();
//            String sql = SqlStatements.SELECT_ALL_SUPPLIERS;
//            ResultSet rs = stmt.executeQuery(sql);
//
//            while(rs.next()){
//                Client client = new Client();
//                client.setClientId(rs.getInt("client_Id"));
//                client.setClientName(rs.getString("client_name"));
//                clients.add(client);
//            }
//
//            rs.close();
//            stmt.close();
//            con.close();
//        }catch(Exception e){
//            e.getMessage();
//        }
//        return clients;
//    }
    
    
      public static ArrayList<Client> getCustomerList(int clientType){
        ArrayList<Client> clients = new ArrayList<Client>();
        try{
            Connection con = SQLConnection.getSQLConnection();
            Statement stmt = con.createStatement();
            String sql = SqlStatements.SELECT_ALL_CUSTOMER;
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setInt(1, clientType);
            ResultSet rs = prepStatement.executeQuery();

            while(rs.next()){
                Client client = new Client();
                client.setClientId(rs.getInt("client_Id"));
                client.setClientAddress(rs.getString("client_address"));
                client.setClientName(rs.getString("client_name"));
                client.setClientPhone(rs.getString("client_phone"));
                client.setClientTypeFlag(rs.getShort("client_type_flag"));
                clients.add(client);
                
            }

            rs.close();
            stmt.close();
            con.close();
        }catch(Exception e){
            e.getMessage();
        }
        return clients;
    }
       public static Client getClient(String clientId){
       Client client = new Client();
        try{
            Connection con = SQLConnection.getSQLConnection();
            Statement stmt = con.createStatement();
            String sql = SqlStatements.SELECT_CLIENT;
             PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, clientId);
             ResultSet rs = prepStatement.executeQuery();
            
            while(rs.next()){
                client.setClientId(rs.getInt("client_Id"));
                client.setClientAddress(rs.getString("client_address"));
                client.setClientName(rs.getString("client_name"));
                client.setClientPhone(rs.getString("client_phone"));
                client.setClientTypeFlag(rs.getShort("client_type_flag"));
                client.setClientNumber(rs.getString("client_number"));
                client.setClientCreditLimit(rs.getDouble("client_credit_limit"));
                client.setClientSubType(rs.getShort("client_sub_type"));
                
            }

            rs.close();
            stmt.close();
            con.close();
        }catch(Exception e){
            e.getMessage();
        }
        return client;
    }
    
    public static int addClient(Client c){
        int result = -1;
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.INSERT_INTO_CLIENTS;
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, c.getClientName());
            prepStatement.setString(2, c.getClientAddress());
            prepStatement.setString(3, c.getClientPhone());
            prepStatement.setShort(4, c.getClientTypeFlag());
            prepStatement.setString(5, Formats.dateFormatMinutes.format(c.getClientAddDate()));
            prepStatement.setString(6, c.getClientAddUser());
            prepStatement.setString(7, c.getClientNumber());
            prepStatement.setDouble(8, c.getClientCreditLimit());
            prepStatement.setShort(9, c.getClientSubType());
            result = prepStatement.executeUpdate();
            
            prepStatement.close();
            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
    
        public static int editClient(Client c){
        int result = -1;
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.UPDATE_CLIENT;
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, c.getClientName());
            prepStatement.setString(2, c.getClientAddress());
            prepStatement.setString(3, c.getClientPhone());
            prepStatement.setShort(4, c.getClientTypeFlag());
            prepStatement.setString(5, Formats.dateFormatMinutes.format(c.getClientEditDate()));
            prepStatement.setString(6, c.getClientEditUser());
            prepStatement.setString(7, c.getClientNumber());
            prepStatement.setDouble(8, c.getClientCreditLimit());
            prepStatement.setShort(9, c.getClientSubType());
            prepStatement.setInt(10, c.getClientId());
            
            
            
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
        
        
      public static int deleteClient(String clientNumber){
        int result = -1;
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.DELETE_CLIENT;
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, Formats.dateFormatSeconds.format(new GregorianCalendar().getTime()));
            prepStatement.setInt(2, Integer.parseInt(clientNumber));
            
            
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

//    public Date getClientDelDate() {
//        return clientDelDate;
//    }
//
//    public void setClientDelDate(Date clientDelDate) {
//        this.clientDelDate = clientDelDate;
//    }

    public String getClientAddUser() {
        return clientAddUser;
    }

    public void setClientAddUser(String clientAddUser) {
        this.clientAddUser = clientAddUser;
    }

    public Date getClientAddDate() {
        return clientAddDate;
    }

    public void setClientAddDate(Date clientAddDate) {
        this.clientAddDate = clientAddDate;
    }

    public Date getClientEditDate() {
        return clientEditDate;
    }

    public void setClientEditDate(Date clientEditDate) {
        this.clientEditDate = clientEditDate;
    }

    public String getClientEditUser() {
        return clientEditUser;
    }

    public void setClientEditUser(String dlientEditUser) {
        this.clientEditUser = dlientEditUser;
    }

//    public Date getClientDelDate() {
//        return clientDelDate;
//    }
//
//    public void setClientDelDate(Date clientDelDate) {
//        this.clientDelDate = clientDelDate;
//    }
//
//    public Date getClientAddDate() {
//        return clientAddDate;
//    }
//
//    public void setClientAddDate(Date clientAddDate) {
//        this.clientAddDate = clientAddDate;
//    }
//
//    public Date getClientEditDate() {
//        return clientEditDate;
//    }
//
//    public void setClientEditDate(Date clientEditDate) {
//        this.clientEditDate = clientEditDate;
//    }
    
    
    public static ArrayList<Client> getLocationList(){
        ArrayList<Client> clients = new ArrayList<Client>();
        try{
            Connection con = SQLConnection.getSQLConnection();
            Statement stmt = con.createStatement();
            String sql = SqlStatements.SELECT_ALL_LOCATIONS;
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                Client client = new Client();
                client.setClientId(rs.getInt("client_id"));
                client.setClientAddress(rs.getString("client_address"));
                client.setClientName(rs.getString("client_name"));
                client.setClientPhone(rs.getString("client_phone"));
                clients.add(client);
            }

            rs.close();
            stmt.close();
            con.close();
        }catch(Exception e){
            e.getMessage();
        }
        return clients;
    }

    public String getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(String clientNumber) {
        this.clientNumber = clientNumber;
    }

    public Double getClientCreditLimit() {
        return clientCreditLimit;
    }

    public void setClientCreditLimit(Double clientCreditLimit) {
        this.clientCreditLimit = clientCreditLimit;
    }

    public Short getClientSubType() {
        return clientSubType;
    }

    public void setClientSubType(Short clientSubType) {
        this.clientSubType = clientSubType;
    }
}
