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
@Table(name = "ar_report_access")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArReportAccess.findAll", query = "SELECT a FROM ArReportAccess a"),
    @NamedQuery(name = "ArReportAccess.findByArReportAccessUserId", query = "SELECT a FROM ArReportAccess a WHERE a.arReportAccessUserId = :arReportAccessUserId"),
    @NamedQuery(name = "ArReportAccess.findByArReportAccessAccountReceivableLedger", query = "SELECT a FROM ArReportAccess a WHERE a.arReportAccessAccountReceivableLedger = :arReportAccessAccountReceivableLedger"),
    @NamedQuery(name = "ArReportAccess.findByArReportAccessAccountReceivableSummarry", query = "SELECT a FROM ArReportAccess a WHERE a.arReportAccessAccountReceivableSummarry = :arReportAccessAccountReceivableSummarry"),
    @NamedQuery(name = "ArReportAccess.findByArReportAccessAccountReceivable", query = "SELECT a FROM ArReportAccess a WHERE a.arReportAccessAccountReceivable = :arReportAccessAccountReceivable"),
    @NamedQuery(name = "ArReportAccess.findByArReportAccessAccountReceivableAging", query = "SELECT a FROM ArReportAccess a WHERE a.arReportAccessAccountReceivableAging = :arReportAccessAccountReceivableAging"),
    @NamedQuery(name = "ArReportAccess.findByArReportAccessAccountPayableLedger", query = "SELECT a FROM ArReportAccess a WHERE a.arReportAccessAccountPayableLedger = :arReportAccessAccountPayableLedger"),
    @NamedQuery(name = "ArReportAccess.findByArReportAccessAccountPayableSummarry", query = "SELECT a FROM ArReportAccess a WHERE a.arReportAccessAccountPayableSummarry = :arReportAccessAccountPayableSummarry"),
    @NamedQuery(name = "ArReportAccess.findByArReportAccessAccountPayable", query = "SELECT a FROM ArReportAccess a WHERE a.arReportAccessAccountPayable = :arReportAccessAccountPayable"),
    @NamedQuery(name = "ArReportAccess.findByArReportAccessAccountPayableAging", query = "SELECT a FROM ArReportAccess a WHERE a.arReportAccessAccountPayableAging = :arReportAccessAccountPayableAging")})
public class ArReportAccess implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ar_report_access_user_id")
    private Short arReportAccessUserId;
    @Column(name = "ar_report_access_account_receivable_ledger")
    private Short arReportAccessAccountReceivableLedger;
    @Column(name = "ar_report_access_account_receivable_summarry")
    private Short arReportAccessAccountReceivableSummarry;
    @Column(name = "ar_report_access_account_receivable")
    private Short arReportAccessAccountReceivable;
    @Column(name = "ar_report_access_account_receivable_aging")
    private Short arReportAccessAccountReceivableAging;
    @Column(name = "ar_report_access_account_payable_ledger")
    private Short arReportAccessAccountPayableLedger;
    @Column(name = "ar_report_access_account_payable_summarry")
    private Short arReportAccessAccountPayableSummarry;
    @Column(name = "ar_report_access_account_payable")
    private Short arReportAccessAccountPayable;
    @Column(name = "ar_report_access_account_payable_aging")
    private Short arReportAccessAccountPayableAging;

    public ArReportAccess() {
    }

    public ArReportAccess(Short arReportAccessUserId) {
        this.arReportAccessUserId = arReportAccessUserId;
    }

    public Short getArReportAccessUserId() {
        return arReportAccessUserId;
    }

    public void setArReportAccessUserId(Short arReportAccessUserId) {
        this.arReportAccessUserId = arReportAccessUserId;
    }

    public Short getArReportAccessAccountReceivableLedger() {
        return arReportAccessAccountReceivableLedger;
    }

    public void setArReportAccessAccountReceivableLedger(Short arReportAccessAccountReceivableLedger) {
        this.arReportAccessAccountReceivableLedger = arReportAccessAccountReceivableLedger;
    }

    public Short getArReportAccessAccountReceivableSummarry() {
        return arReportAccessAccountReceivableSummarry;
    }

    public void setArReportAccessAccountReceivableSummarry(Short arReportAccessAccountReceivableSummarry) {
        this.arReportAccessAccountReceivableSummarry = arReportAccessAccountReceivableSummarry;
    }

    public Short getArReportAccessAccountReceivable() {
        return arReportAccessAccountReceivable;
    }

    public void setArReportAccessAccountReceivable(Short arReportAccessAccountReceivable) {
        this.arReportAccessAccountReceivable = arReportAccessAccountReceivable;
    }

    public Short getArReportAccessAccountReceivableAging() {
        return arReportAccessAccountReceivableAging;
    }

    public void setArReportAccessAccountReceivableAging(Short arReportAccessAccountReceivableAging) {
        this.arReportAccessAccountReceivableAging = arReportAccessAccountReceivableAging;
    }

    public Short getArReportAccessAccountPayableLedger() {
        return arReportAccessAccountPayableLedger;
    }

    public void setArReportAccessAccountPayableLedger(Short arReportAccessAccountPayableLedger) {
        this.arReportAccessAccountPayableLedger = arReportAccessAccountPayableLedger;
    }

    public Short getArReportAccessAccountPayableSummarry() {
        return arReportAccessAccountPayableSummarry;
    }

    public void setArReportAccessAccountPayableSummarry(Short arReportAccessAccountPayableSummarry) {
        this.arReportAccessAccountPayableSummarry = arReportAccessAccountPayableSummarry;
    }

    public Short getArReportAccessAccountPayable() {
        return arReportAccessAccountPayable;
    }

    public void setArReportAccessAccountPayable(Short arReportAccessAccountPayable) {
        this.arReportAccessAccountPayable = arReportAccessAccountPayable;
    }

    public Short getArReportAccessAccountPayableAging() {
        return arReportAccessAccountPayableAging;
    }

    public void setArReportAccessAccountPayableAging(Short arReportAccessAccountPayableAging) {
        this.arReportAccessAccountPayableAging = arReportAccessAccountPayableAging;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (arReportAccessUserId != null ? arReportAccessUserId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArReportAccess)) {
            return false;
        }
        ArReportAccess other = (ArReportAccess) object;
        if ((this.arReportAccessUserId == null && other.arReportAccessUserId != null) || (this.arReportAccessUserId != null && !this.arReportAccessUserId.equals(other.arReportAccessUserId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pos_project.classes.ArReportAccess[ arReportAccessUserId=" + arReportAccessUserId + " ]";
    }
    
    
    
     public static ArReportAccess getArReportAccess(Short userTypeId){
       ArReportAccess userType = new ArReportAccess();
        try{
            Connection con = SQLConnection.getSQLConnection();
            Statement stmt = con.createStatement();
            String sql = SqlStatements.SELECT_ARP_REPORT_RIGHTS;
             PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setShort(1, userTypeId);
             ResultSet rs = prepStatement.executeQuery();
            
            while(rs.next()){
                
                userType.setArReportAccessAccountPayable(rs.getShort("ar_report_access_account_payable"));
                userType.setArReportAccessAccountPayableAging(rs.getShort("ar_report_access_account_payable_aging"));
                userType.setArReportAccessAccountPayableLedger(rs.getShort("ar_report_access_account_payable_ledger"));
                userType.setArReportAccessAccountPayableSummarry(rs.getShort("ar_report_access_account_payable_summarry"));
                userType.setArReportAccessAccountReceivable(rs.getShort("ar_report_access_account_receivable"));
                userType.setArReportAccessAccountReceivableAging(rs.getShort("ar_report_access_account_receivable_aging"));
                userType.setArReportAccessAccountReceivableLedger(rs.getShort("ar_report_access_account_receivable_ledger"));
                userType.setArReportAccessAccountReceivableSummarry(rs.getShort("ar_report_access_account_receivable_summarry"));
                userType.setArReportAccessUserId(rs.getShort("ar_report_access_user_id"));
                }

            rs.close();
            stmt.close();
            con.close();
        }catch(Exception e){
            e.getMessage();
        }
        return userType;
    }
}
