/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pos_project.classes;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Queenie
 */
@Entity
@Table(name = "registered_machine")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "RegisteredMachine.findAll", query = "SELECT r FROM RegisteredMachine r"),
//    @NamedQuery(name = "RegisteredMachine.findByMachineNameHashCode", query = "SELECT r FROM RegisteredMachine r WHERE r.machineNameHashCode = :machineNameHashCode")})
public class RegisteredMachine implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "machine_name_hash_code")
//    private Integer machineNameHashCode;
    private int machineNameHashCode;

    public RegisteredMachine() {
        this.machineNameHashCode = 0;
    }

    public int getMachineNameHashCode() {
        return machineNameHashCode;
    }

    public void setMachineNameHashCode(int machineNameHashCode) {
        this.machineNameHashCode = machineNameHashCode;
    }
    public void addMachine(){
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = "INSERT INTO registered_machine (machine_name_hash_code) VALUES (?)";
            PreparedStatement prepStatement = con.prepareStatement(sql);
            
            prepStatement.setInt(1, getMachineNameHashCode());

            prepStatement.executeUpdate();

            prepStatement.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void updateMachineHashCode(){
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = "UPDATE registered_machine SET machine_name_hash_code= ?";
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setInt(1, getMachineNameHashCode());
            prepStatement.executeUpdate();

            prepStatement.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static boolean isMachineRegistered(int hashCode){
        boolean valid = false;
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = "SELECT * FROM registered_machine WHERE machine_name_hash_code = ?";
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setInt(1, hashCode);
            ResultSet rs = prepStatement.executeQuery();

            if(rs.next()){
                valid = true;
            }

            rs.close();
            prepStatement.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return valid;
    }

    public static int getMachineHashCode(){
        int machineHashCode = 0;
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = "SELECT machine_name_hash_code FROM REGISTERED_MACHINE";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                machineHashCode = rs.getInt("machine_name_hash_code");
            }

            rs.close();
            stmt.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return machineHashCode;
    }
    public static boolean getMachineHashCode2(int hash){
        //ArrayList<Integer> arrMachineHashCode = new ArrayList<Integer>();
        boolean isRegistered=false;
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = "SELECT machine_name_hash_code FROM REGISTERED_MACHINE where machine_name_hash_code = " +hash;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
               // arrMachineHashCode.add(rs.getInt("machine_name_hash_code"));
                isRegistered=true;
            }

            rs.close();
            stmt.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return isRegistered;
    }
    public static int getNumberOfRegisteredMachines(){
        int count = 0;
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = "SELECT COUNT(*) AS 'count' FROM registered_machine";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if(rs.next()){
                count = rs.getInt("count");
            }

            rs.close();
            stmt.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return count;
    }
     public static int getMachineCount(){
        int count = 0;
        try{
            Connection con = SQLConnection.getSQLConnection();
//            String sql = "SELECT COUNT(*) AS 'count' FROM registered_machine";
            String sql = "SELECT machine_cnt from machine_count";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if(rs.next()){
                count = rs.getInt("machine_cnt");
            }

            rs.close();
            stmt.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return count;
    }

    public RegisteredMachine(Integer machineNameHashCode) {
        this.machineNameHashCode = machineNameHashCode;
    }

//    public Integer getMachineNameHashCode() {
//        return machineNameHashCode;
//    }

    public void setMachineNameHashCode(Integer machineNameHashCode) {
        this.machineNameHashCode = machineNameHashCode;
    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (machineNameHashCode != null ? machineNameHashCode.hashCode() : 0);
//        return hash;
//    }

//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof RegisteredMachine)) {
//            return false;
//        }
//        RegisteredMachine other = (RegisteredMachine) object;
//        if ((this.machineNameHashCode == null && other.machineNameHashCode != null) || (this.machineNameHashCode != null && !this.machineNameHashCode.equals(other.machineNameHashCode))) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public String toString() {
        return "pos_project.classes.RegisteredMachine[ machineNameHashCode=" + machineNameHashCode + " ]";
    }
}
