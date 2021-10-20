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
@Table(name = "location")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Location.findAll", query = "SELECT l FROM Location l"),
    @NamedQuery(name = "Location.findByLocationId", query = "SELECT l FROM Location l WHERE l.locationId = :locationId"),
    @NamedQuery(name = "Location.findByLocationName", query = "SELECT l FROM Location l WHERE l.locationName = :locationName"),
    @NamedQuery(name = "Location.findByLocationAddress", query = "SELECT l FROM Location l WHERE l.locationAddress = :locationAddress"),
    @NamedQuery(name = "Location.findByLocationTelNo", query = "SELECT l FROM Location l WHERE l.locationTelNo = :locationTelNo")})
public class Location implements Serializable {
    @Column(name = "location_del_flag")
    private Short locationDelFlag;
    @Column(name = "location_del_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date locationDelDate;
    @Column(name = "location_add_user")
    private String locationAddUser;
    @Column(name = "location_add_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date locationAddDate;
    @Column(name = "location_edit_user")
    private String locationEditUser;
    @Column(name = "location_edit_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date locationEditDate;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "location_id")
    private Integer locationId;
    @Column(name = "location_name")
    private String locationName;
    @Column(name = "location_address")
    private String locationAddress;
    @Column(name = "location_tel_no")
    private String locationTelNo;

    public Location() {
    }

    public Location(Integer locationId) {
        this.locationId = locationId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public String getLocationTelNo() {
        return locationTelNo;
    }

    public void setLocationTelNo(String locationTelNo) {
        this.locationTelNo = locationTelNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (locationId != null ? locationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Location)) {
            return false;
        }
        Location other = (Location) object;
        if ((this.locationId == null && other.locationId != null) || (this.locationId != null && !this.locationId.equals(other.locationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        return "pos_project.classes.Location[ locationId=" + locationId + " ]";
        return locationName;
    }

    public Short getLocationDelFlag() {
        return locationDelFlag;
    }

    public void setLocationDelFlag(Short locationDelFlag) {
        this.locationDelFlag = locationDelFlag;
    }
    
    public Date getLocationDelDate() {
        return locationDelDate;
    }

    public void setLocationDelDate(Date locationDelDate) {
        this.locationDelDate = locationDelDate;
    }

    public String getLocationAddUser() {
        return locationAddUser;
    }

    public void setLocationAddUser(String locationAddUser) {
        this.locationAddUser = locationAddUser;
    }

    public Date getLocationAddDate() {
        return locationAddDate;
    }

    public void setLocationAddDate(Date locationAddDate) {
        this.locationAddDate = locationAddDate;
    }

    public String getLocationEditUser() {
        return locationEditUser;
    }

    public void setLocationEditUser(String locationEditUser) {
        this.locationEditUser = locationEditUser;
    }

    public Date getLocationEditDate() {
        return locationEditDate;
    }

    public void setLocationEditDate(Date locationEditDate) {
        this.locationEditDate = locationEditDate;
    }
    
    public static ArrayList<Location> getLocationList(){
        ArrayList<Location> clients = new ArrayList<Location>();
        try{
            Connection con = SQLConnection.getSQLConnection();
            Statement stmt = con.createStatement();
            String sql = SqlStatements.SELECT_ALL_LOCATIONS;
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                Location client = new Location();
                client.setLocationId(rs.getInt("location_id"));
                client.setLocationAddress(rs.getString("location_address"));
                client.setLocationName(rs.getString("location_name"));
                client.setLocationTelNo(rs.getString("location_tel_no"));
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
    
    
    public static Location getLocation(String clientId){
       Location client = new Location();
        try{
            Connection con = SQLConnection.getSQLConnection();
            Statement stmt = con.createStatement();
            String sql = SqlStatements.SELECT_LOCATION;
             PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, clientId);
             ResultSet rs = prepStatement.executeQuery();
            
            while(rs.next()){
                client.setLocationId(rs.getInt("location_id"));
                client.setLocationAddress(rs.getString("location_address"));
                client.setLocationName(rs.getString("location_name"));
                client.setLocationTelNo(rs.getString("location_tel_no"));
                
            }

            rs.close();
            stmt.close();
            con.close();
        }catch(Exception e){
            e.getMessage();
        }
        return client;
    }
    
    public static int addLocation(Location c){
        int result = -1;
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.INSERT_INTO_LOCATION;
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, c.getLocationName());
            prepStatement.setString(2, c.getLocationAddress());
            prepStatement.setString(3, c.getLocationTelNo());
            prepStatement.setString(4, Formats.dateFormatMinutes.format(c.getLocationAddDate()));
            prepStatement.setString(5, c.getLocationAddUser());
            
            result = prepStatement.executeUpdate();
            
            prepStatement.close();
            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
    
        public static int editLocation(Location c){
        int result = -1;
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.UPDATE_LOCATION;
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, c.getLocationName());
            prepStatement.setString(2, c.getLocationAddress());
            prepStatement.setString(3, c.getLocationTelNo());
            prepStatement.setString(4, Formats.dateFormatMinutes.format(c.getLocationEditDate()));
            prepStatement.setString(5, c.getLocationEditUser());
            prepStatement.setInt(6, c.getLocationId());
            
            
            
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
        
        
      public static int deleteLocation(String locationNumber){
        int result = -1;
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.DELETE_LOCATION;
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, Formats.dateFormatSeconds.format(new GregorianCalendar().getTime()));
            prepStatement.setInt(2, Integer.parseInt(locationNumber));
            
            
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
}
