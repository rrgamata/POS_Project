/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos_project.classes;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "convert")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Convert.findAll", query = "SELECT c FROM Convert c"),
    @NamedQuery(name = "Convert.findByConvertId", query = "SELECT c FROM Convert c WHERE c.convertId = :convertId"),
    @NamedQuery(name = "Convert.findByConvertNumber", query = "SELECT c FROM Convert c WHERE c.convertNumber = :convertNumber"),
    @NamedQuery(name = "Convert.findByConvertFromInvoiceId", query = "SELECT c FROM Convert c WHERE c.convertFromInvoiceId = :convertFromInvoiceId"),
    @NamedQuery(name = "Convert.findByConvertToInvoiceId", query = "SELECT c FROM Convert c WHERE c.convertToInvoiceId = :convertToInvoiceId"),
    @NamedQuery(name = "Convert.findByConvertDate", query = "SELECT c FROM Convert c WHERE c.convertDate = :convertDate"),
    @NamedQuery(name = "Convert.findByConvertAddUser", query = "SELECT c FROM Convert c WHERE c.convertAddUser = :convertAddUser"),
    @NamedQuery(name = "Convert.findByConvertEditUser", query = "SELECT c FROM Convert c WHERE c.convertEditUser = :convertEditUser"),
    @NamedQuery(name = "Convert.findByConvertDelFlag", query = "SELECT c FROM Convert c WHERE c.convertDelFlag = :convertDelFlag"),
    @NamedQuery(name = "Convert.findByConvertAddDate", query = "SELECT c FROM Convert c WHERE c.convertAddDate = :convertAddDate"),
    @NamedQuery(name = "Convert.findByConvertEditDate", query = "SELECT c FROM Convert c WHERE c.convertEditDate = :convertEditDate"),
    @NamedQuery(name = "Convert.findByConvertDelDate", query = "SELECT c FROM Convert c WHERE c.convertDelDate = :convertDelDate")})
public class Convert implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "convert_id")
    private Integer convertId;
    @Column(name = "convert_number")
    private String convertNumber;
    @Column(name = "convert_from_invoice_id")
    private Integer convertFromInvoiceId;
    @Column(name = "convert_to_invoice_id")
    private Integer convertToInvoiceId;
    @Column(name = "convert_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date convertDate;
    @Column(name = "convert_add_user")
    private String convertAddUser;
    @Column(name = "convert_edit_user")
    private String convertEditUser;
    @Column(name = "convert_del_flag")
    private Short convertDelFlag;
    @Column(name = "convert_add_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date convertAddDate;
    @Column(name = "convert_edit_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date convertEditDate;
    @Column(name = "convert_del_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date convertDelDate;

    public Convert() {
    }

    public Convert(Integer convertId) {
        this.convertId = convertId;
    }

    public Integer getConvertId() {
        return convertId;
    }

    public void setConvertId(Integer convertId) {
        this.convertId = convertId;
    }

    public String getConvertNumber() {
        return convertNumber;
    }

    public void setConvertNumber(String convertNumber) {
        this.convertNumber = convertNumber;
    }

    public Integer getConvertFromInvoiceId() {
        return convertFromInvoiceId;
    }

    public void setConvertFromInvoiceId(Integer convertFromInvoiceId) {
        this.convertFromInvoiceId = convertFromInvoiceId;
    }

    public Integer getConvertToInvoiceId() {
        return convertToInvoiceId;
    }

    public void setConvertToInvoiceId(Integer convertToInvoiceId) {
        this.convertToInvoiceId = convertToInvoiceId;
    }

    public Date getConvertDate() {
        return convertDate;
    }

    public void setConvertDate(Date convertDate) {
        this.convertDate = convertDate;
    }

    public String getConvertAddUser() {
        return convertAddUser;
    }

    public void setConvertAddUser(String convertAddUser) {
        this.convertAddUser = convertAddUser;
    }

    public String getConvertEditUser() {
        return convertEditUser;
    }

    public void setConvertEditUser(String convertEditUser) {
        this.convertEditUser = convertEditUser;
    }

    public Short getConvertDelFlag() {
        return convertDelFlag;
    }

    public void setConvertDelFlag(Short convertDelFlag) {
        this.convertDelFlag = convertDelFlag;
    }

    public Date getConvertAddDate() {
        return convertAddDate;
    }

    public void setConvertAddDate(Date convertAddDate) {
        this.convertAddDate = convertAddDate;
    }

    public Date getConvertEditDate() {
        return convertEditDate;
    }

    public void setConvertEditDate(Date convertEditDate) {
        this.convertEditDate = convertEditDate;
    }

    public Date getConvertDelDate() {
        return convertDelDate;
    }

    public void setConvertDelDate(Date convertDelDate) {
        this.convertDelDate = convertDelDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (convertId != null ? convertId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Convert)) {
            return false;
        }
        Convert other = (Convert) object;
        if ((this.convertId == null && other.convertId != null) || (this.convertId != null && !this.convertId.equals(other.convertId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pos_project.classes.Convert[ convertId=" + convertId + " ]";
    }
 
     public static int insertConvert(String convertNumber, String fromInvoiceId, String toInvoiceId, String date){
        int client = -1;
        try{
            Connection con = SQLConnection.getSQLConnection();
            client = Convert.insertConvert(convertNumber, fromInvoiceId, toInvoiceId,date, con);
            con.close();
        }catch(Exception e){
            e.getMessage();
        }
        return client;
    }
    
    public static int insertConvert(String transferNumber,String fromId, String toId, String date, Connection con){
        int result = -1;
        try{
            Statement stmt = con.createStatement();
            String sql = SqlStatements.INSERT_INTO_CONVERT;
             PreparedStatement prepStatement = con.prepareStatement(sql);
             prepStatement.setString(1, transferNumber);
            prepStatement.setString(2, fromId);
            prepStatement.setString(3, toId);
            prepStatement.setString(4, date);
            prepStatement.setString(5, Formats.dateFormatSeconds.format(new GregorianCalendar().getTime()));
            prepStatement.setString(6, System.getProperty("userName"));
            System.out.println(prepStatement);
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
    
}
