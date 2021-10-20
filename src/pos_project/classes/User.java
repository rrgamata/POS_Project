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
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByUserId", query = "SELECT u FROM User u WHERE u.userId = :userId"),
    @NamedQuery(name = "User.findByUserName", query = "SELECT u FROM User u WHERE u.userName = :userName"),
    @NamedQuery(name = "User.findByUserPassword", query = "SELECT u FROM User u WHERE u.userPassword = :userPassword"),
    @NamedQuery(name = "User.findByUserType", query = "SELECT u FROM User u WHERE u.userType = :userType"),
    @NamedQuery(name = "User.findByUserDelFlg", query = "SELECT u FROM User u WHERE u.userDelFlg = :userDelFlg"),
    @NamedQuery(name = "User.findByUserDelDate", query = "SELECT u FROM User u WHERE u.userDelDate = :userDelDate"),
    @NamedQuery(name = "User.findByUserDate", query = "SELECT u FROM User u WHERE u.userDate = :userDate")})
public class User implements Serializable {
    @Column(name = "user_del_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date userDelDate;
    @Column(name = "user_add_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date userAddDate;
    @Column(name = "user_edit_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date userEditDate;
    @Column(name = "user_first_name")
    private String userFirstName;
    @Column(name = "user_last_name")
    private String userLastName;
    @Column(name = "user_add_user")
    private String userAddUser;
    @Column(name = "user_edit_user")
    private String userEditUser;
//    @Column(name = "user_date")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date userDate;
    @Column(name = "user_username")
    private String userUsername;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
//    @Column(name = "user_name")
//    private String userName;
    @Column(name = "user_password")
    private String userPassword;
    @Column(name = "user_type")
    private Short userType;
    @Column(name = "user_del_flg")
    private Short userDelFlg;

    public User() {
    }

    public User(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Short getUserType() {
        return userType;
    }

    public void setUserType(Short userType) {
        this.userType = userType;
    }

    public Short getUserDelFlg() {
        return userDelFlg;
    }

    public void setUserDelFlg(Short userDelFlg) {
        this.userDelFlg = userDelFlg;
    }

    public Date getUserDelDate() {
        return userDelDate;
    }

    public void setUserDelDate(Date userDelDate) {
        this.userDelDate = userDelDate;
    }

//    public Date getUserDate() {
//        return userDate;
//    }
//
//    public void setUserDate(Date userDate) {
//        this.userDate = userDate;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pos_project.classes.User[ userId=" + userId + " ]";
    }
    
    public static int checkUserName(String username){
        int value =0;
        try{
            Connection con = SQLConnection.getSQLConnection();
            Statement stmt = con.createStatement();
            String sql = SqlStatements.SELECT_USER_WITH_USERNAME;
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, username);
            ResultSet rs = prepStatement.executeQuery();

            while(rs.next()){
                value = rs.getInt("val");
//                client.setClientId(rs.getInt("client_Id"));
//                client.setClientAddress(rs.getString("client_address"));
//                client.setClientName(rs.getString("client_name"));
//                client.setClientPhone(rs.getString("client_phone"));
//                client.setClientTypeFlag(rs.getShort("client_type_flag"));
                
                
            }

            rs.close();
            stmt.close();
            con.close();
        }catch(Exception e){
            e.getMessage();
        }
        return value;
        
    }
    
    public static User getUser(int userId){
        int value =0;
        User u =new User();
        try{
            Connection con = SQLConnection.getSQLConnection();
            Statement stmt = con.createStatement();
            String sql = SqlStatements.SELECT_USER_WITH_ID;
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setInt(1, userId);
            ResultSet rs = prepStatement.executeQuery();

            while(rs.next()){
                u.setUserFirstName(rs.getString("first_name"));
                u.setUserLastName(rs.getString("last_name"));
                u.setUserUsername(rs.getString("user_username"));
                u.setUserType(rs.getShort("user_type"));
//                client.setClientId(rs.getInt("client_Id"));
//                client.setClientAddress(rs.getString("client_address"));
//                client.setClientName(rs.getString("client_name"));
//                client.setClientPhone(rs.getString("client_phone"));
//                client.setClientTypeFlag(rs.getShort("client_type_flag"));
                
                
            }

            rs.close();
            stmt.close();
            con.close();
        }catch(Exception e){
            e.getMessage();
        }
        return u;
        
    }
    
     public static ArrayList<User> getUserList(){
        ArrayList<User> users = new ArrayList<User>();
        try{
            Connection con = SQLConnection.getSQLConnection();
            Statement stmt = con.createStatement();
            String sql = SqlStatements.SELECT_ALL_USER;
//            PreparedStatement prepStatement = con.prepareStatement(sql);
//            prepStatement.setInt(1, clientType);
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                User user = new User();
                user.setUserFirstName(rs.getString("first_name"));
                user.setUserLastName(rs.getString("last_name"));
                user.setUserUsername(rs.getString("user_username"));
                user.setUserId(rs.getInt("user_id"));
                user.setUserType(rs.getShort("user_type"));
//                client.setClientId(rs.getInt("client_Id"));
//                client.setClientAddress(rs.getString("client_address"));
//                client.setClientName(rs.getString("client_name"));
//                client.setClientPhone(rs.getString("client_phone"));
//                client.setClientTypeFlag(rs.getShort("client_type_flag"));
                users.add(user);
                
            }

            rs.close();
            stmt.close();
            con.close();
        }catch(Exception e){
            e.getMessage();
        }
        return users;
    }
     
     
      public static int insertUser(User u){
        int value =-1;
        try{
            Connection con = SQLConnection.getSQLConnection();
//            Statement stmt = con.createStatement();
            String sql = SqlStatements.INSERT_USER;
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, u.getUserFirstName());
            prepStatement.setString(2, u.getUserLastName());
            prepStatement.setString(3, u.getUserPassword());
            prepStatement.setShort(4, u.getUserType());
            prepStatement.setString(5, u.getUserUsername());
            prepStatement.setString(6, Formats.dateFormatMinutes.format(u.getUserAddDate()));
            prepStatement.setString(7, u.getUserAddUser());
//            ResultSet rs = prepStatement.executeQuery();
            System.out.println(prepStatement);
            value = prepStatement.executeUpdate();
            
            prepStatement.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return value;
        
        
        
        
    }
      
      
      public static int editUser(User u){
        int value =0;
        try{
            Connection con = SQLConnection.getSQLConnection();
            Statement stmt = con.createStatement();
            String sql = SqlStatements.EDIT_USER;
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, u.getUserFirstName());
            prepStatement.setString(2, u.getUserLastName());
//            prepStatement.setString(2, u.getUserPassword());
            prepStatement.setShort(3, u.getUserType());
            prepStatement.setString(4, u.getUserUsername());
            prepStatement.setString(5,  Formats.dateFormatMinutes.format(u.getUserEditDate()));
            prepStatement.setString(6, u.getUserEditUser());
            prepStatement.setInt(7, u.getUserId());
//            ResultSet rs = prepStatement.executeQuery();

            value = prepStatement.executeUpdate();
            
            prepStatement.close();
            con.close();
        }catch(Exception e){
            e.getMessage();
        }
        return value;
        
    }
      
      
       public static int updateUserPassword(User u){
        int value =0;
        try{
            Connection con = SQLConnection.getSQLConnection();
            Statement stmt = con.createStatement();
            String sql = SqlStatements.EDIT_USER_PASSWORD;
            PreparedStatement prepStatement = con.prepareStatement(sql);
            
            prepStatement.setString(1, u.getUserPassword());
            prepStatement.setInt(2, u.getUserId());
//            ResultSet rs = prepStatement.executeQuery();

            value = prepStatement.executeUpdate();
            
            prepStatement.close();
            con.close();
        }catch(Exception e){
            e.getMessage();
        }
        return value;
        
    }
     
     public static User checkBoth(String uName,String pass){
        User loggingUser = new User();
        try{
            Connection con = SQLConnection.getSQLConnection();
            Statement stmt = null;
            ResultSet rs = null;
            
            PreparedStatement pstmt = con.prepareStatement(SqlStatements.CHECK_USERPASS);
            pstmt.setString(1, uName);
            pstmt.setString(2, pass);
            
            stmt = con.createStatement();
            rs = pstmt.executeQuery();
            while(rs.next()){
               loggingUser.setUserPassword(rs.getString("user_password"));
               loggingUser.setUserId(rs.getInt("user_id"));
               loggingUser.setUserFirstName(rs.getString("first_name"));
               loggingUser.setUserLastName(rs.getString("last_name"));
               loggingUser.setUserUsername(rs.getString("user_Username"));
               loggingUser.setUserType(rs.getShort("user_type"));
            }
            stmt.close();
        } catch (SQLException e) {
            System.out.println("SQL Exception: "+ e.toString());
        } catch (Exception e) {
                e.getMessage();
        }
        return loggingUser;
    }

//        private boolean checkUsername(String uName){
//            boolean userExists = false;
//            try{
//                Connection  con = SQLConnection.getSQLConnection();
//                String sql = "SELECT * from user where user_name LIKE BINARY ?";
//                PreparedStatement prepStatement = con.prepareStatement(sql);
//                prepStatement.setString(1, uName);
//                ResultSet rs = prepStatement.executeQuery();
//
//                if(rs.next()){
//                    userExists = true;
//                }
//                rs.close();
//                prepStatement.close();
//                //con.close();
//                
//            }catch(Exception e){
//                System.out.println(e.getMessage());
//            }
//            return userExists;
//        }

     public static int deleteUser(String userNumber){
        int result = -1;
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.DELETE_USER;
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, Formats.dateFormatSeconds.format(new GregorianCalendar().getTime()));
            prepStatement.setInt(2, Integer.parseInt(userNumber));
            
            
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
   
    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

//    public Date getUserDelDate() {
//        return userDelDate;
//    }
//
//    public void setUserDelDate(Date userDelDate) {
//        this.userDelDate = userDelDate;
//    }

    public Date getUserAddDate() {
        return userAddDate;
    }

    public void setUserAddDate(Date userAddDate) {
        this.userAddDate = userAddDate;
    }

    public String getUserAddUser() {
        return userAddUser;
    }

    public void setUserAddUser(String userAddUser) {
        this.userAddUser = userAddUser;
    }

    public Date getUserEditDate() {
        return userEditDate;
    }

    public void setUserEditDate(Date userEditDate) {
        this.userEditDate = userEditDate;
    }

    public String getUserEditUser() {
        return userEditUser;
    }

    public void setUserEditUser(String userEditUser) {
        this.userEditUser = userEditUser;
    }

//    public Date getUserDelDate() {
//        return userDelDate;
//    }
//
//    public void setUserDelDate(Date userDelDate) {
//        this.userDelDate = userDelDate;
//    }
//
//    public Date getUserAddDate() {
//        return userAddDate;
//    }
//
//    public void setUserAddDate(Date userAddDate) {
//        this.userAddDate = userAddDate;
//    }
//
//    public Date getUserEditDate() {
//        return userEditDate;
//    }
//
//    public void setUserEditDate(Date userEditDate) {
//        this.userEditDate = userEditDate;
//    }
    
}
