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
@Table(name = "ot_report_access")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OtReportAccess.findAll", query = "SELECT o FROM OtReportAccess o"),
    @NamedQuery(name = "OtReportAccess.findByOtReportAccessUserId", query = "SELECT o FROM OtReportAccess o WHERE o.otReportAccessUserId = :otReportAccessUserId"),
    @NamedQuery(name = "OtReportAccess.findByOtReportAccessItemLedger", query = "SELECT o FROM OtReportAccess o WHERE o.otReportAccessItemLedger = :otReportAccessItemLedger"),
    @NamedQuery(name = "OtReportAccess.findByOtReportAccessInventory", query = "SELECT o FROM OtReportAccess o WHERE o.otReportAccessInventory = :otReportAccessInventory"),
    @NamedQuery(name = "OtReportAccess.findByOtReportAccessPostDated", query = "SELECT o FROM OtReportAccess o WHERE o.otReportAccessPostDated = :otReportAccessPostDated"),
    @NamedQuery(name = "OtReportAccess.findByOtReportAccessDailySalesCollection", query = "SELECT o FROM OtReportAccess o WHERE o.otReportAccessDailySalesCollection = :otReportAccessDailySalesCollection"),
    @NamedQuery(name = "OtReportAccess.findByOtReportAccessDailySalesPayment", query = "SELECT o FROM OtReportAccess o WHERE o.otReportAccessDailySalesPayment = :otReportAccessDailySalesPayment"),
    @NamedQuery(name = "OtReportAccess.findByOtReportAccessDailySales", query = "SELECT o FROM OtReportAccess o WHERE o.otReportAccessDailySales = :otReportAccessDailySales"),
    @NamedQuery(name = "OtReportAccess.findByOtReportAccessDailySalesReCust", query = "SELECT o FROM OtReportAccess o WHERE o.otReportAccessDailySalesReCust = :otReportAccessDailySalesReCust"),
    @NamedQuery(name = "OtReportAccess.findByOtReportAccessDailySalesReSupp", query = "SELECT o FROM OtReportAccess o WHERE o.otReportAccessDailySalesReSupp = :otReportAccessDailySalesReSupp"),
    @NamedQuery(name = "OtReportAccess.findByOtReportAccessDetailedTransfer", query = "SELECT o FROM OtReportAccess o WHERE o.otReportAccessDetailedTransfer = :otReportAccessDetailedTransfer"),
    @NamedQuery(name = "OtReportAccess.findByOtReportAccessDailyOtc", query = "SELECT o FROM OtReportAccess o WHERE o.otReportAccessDailyOtc = :otReportAccessDailyOtc")})
public class OtReportAccess implements Serializable {
    @Column(name = "ot_report_access_detailed_salesperson")
    private Short otReportAccessDetailedSalesperson;
    @Column(name = "ot_report_access_detailed_sales")
    private Short otReportAccessDetailedSales;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ot_report_access_user_id")
    private Short otReportAccessUserId;
    @Column(name = "ot_report_access_item_ledger")
    private Short otReportAccessItemLedger;
    @Column(name = "ot_report_access_inventory")
    private Short otReportAccessInventory;
    @Column(name = "ot_report_access_post_dated")
    private Short otReportAccessPostDated;
    @Column(name = "ot_report_access_daily_sales_collection")
    private Short otReportAccessDailySalesCollection;
    @Column(name = "ot_report_access_daily_sales_payment")
    private Short otReportAccessDailySalesPayment;
    @Column(name = "ot_report_access_daily_sales")
    private Short otReportAccessDailySales;
    @Column(name = "ot_report_access_daily_sales_re_cust")
    private Short otReportAccessDailySalesReCust;
    @Column(name = "ot_report_access_daily_sales_re_supp")
    private Short otReportAccessDailySalesReSupp;
    @Column(name = "ot_report_access_detailed_transfer")
    private Short otReportAccessDetailedTransfer;
    @Column(name = "ot_report_access_daily_otc")
    private Short otReportAccessDailyOtc;

    public OtReportAccess() {
    }

    public OtReportAccess(Short otReportAccessUserId) {
        this.otReportAccessUserId = otReportAccessUserId;
    }

    public Short getOtReportAccessUserId() {
        return otReportAccessUserId;
    }

    public void setOtReportAccessUserId(Short otReportAccessUserId) {
        this.otReportAccessUserId = otReportAccessUserId;
    }

    public Short getOtReportAccessItemLedger() {
        return otReportAccessItemLedger;
    }

    public void setOtReportAccessItemLedger(Short otReportAccessItemLedger) {
        this.otReportAccessItemLedger = otReportAccessItemLedger;
    }

    public Short getOtReportAccessInventory() {
        return otReportAccessInventory;
    }

    public void setOtReportAccessInventory(Short otReportAccessInventory) {
        this.otReportAccessInventory = otReportAccessInventory;
    }

    public Short getOtReportAccessPostDated() {
        return otReportAccessPostDated;
    }

    public void setOtReportAccessPostDated(Short otReportAccessPostDated) {
        this.otReportAccessPostDated = otReportAccessPostDated;
    }

    public Short getOtReportAccessDailySalesCollection() {
        return otReportAccessDailySalesCollection;
    }

    public void setOtReportAccessDailySalesCollection(Short otReportAccessDailySalesCollection) {
        this.otReportAccessDailySalesCollection = otReportAccessDailySalesCollection;
    }

    public Short getOtReportAccessDailySalesPayment() {
        return otReportAccessDailySalesPayment;
    }

    public void setOtReportAccessDailySalesPayment(Short otReportAccessDailySalesPayment) {
        this.otReportAccessDailySalesPayment = otReportAccessDailySalesPayment;
    }

    public Short getOtReportAccessDailySales() {
        return otReportAccessDailySales;
    }

    public void setOtReportAccessDailySales(Short otReportAccessDailySales) {
        this.otReportAccessDailySales = otReportAccessDailySales;
    }

    public Short getOtReportAccessDailySalesReCust() {
        return otReportAccessDailySalesReCust;
    }

    public void setOtReportAccessDailySalesReCust(Short otReportAccessDailySalesReCust) {
        this.otReportAccessDailySalesReCust = otReportAccessDailySalesReCust;
    }

    public Short getOtReportAccessDailySalesReSupp() {
        return otReportAccessDailySalesReSupp;
    }

    public void setOtReportAccessDailySalesReSupp(Short otReportAccessDailySalesReSupp) {
        this.otReportAccessDailySalesReSupp = otReportAccessDailySalesReSupp;
    }

    public Short getOtReportAccessDetailedTransfer() {
        return otReportAccessDetailedTransfer;
    }

    public void setOtReportAccessDetailedTransfer(Short otReportAccessDetailedTransfer) {
        this.otReportAccessDetailedTransfer = otReportAccessDetailedTransfer;
    }

    public Short getOtReportAccessDailyOtc() {
        return otReportAccessDailyOtc;
    }

    public void setOtReportAccessDailyOtc(Short otReportAccessDailyOtc) {
        this.otReportAccessDailyOtc = otReportAccessDailyOtc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (otReportAccessUserId != null ? otReportAccessUserId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OtReportAccess)) {
            return false;
        }
        OtReportAccess other = (OtReportAccess) object;
        if ((this.otReportAccessUserId == null && other.otReportAccessUserId != null) || (this.otReportAccessUserId != null && !this.otReportAccessUserId.equals(other.otReportAccessUserId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pos_project.classes.OtReportAccess[ otReportAccessUserId=" + otReportAccessUserId + " ]";
    }
    
     public static OtReportAccess getOtReportAccess(Short userTypeId){
       OtReportAccess userType = new OtReportAccess();
        try{
            Connection con = SQLConnection.getSQLConnection();
            Statement stmt = con.createStatement();
            String sql = SqlStatements.SELECT_OT_REPORT_RIGHTS;
             PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setShort(1, userTypeId);
             ResultSet rs = prepStatement.executeQuery();
            
            while(rs.next()){
                
                userType.setOtReportAccessDailyOtc(rs.getShort("ot_report_access_daily_otc"));
                userType.setOtReportAccessDailySales(rs.getShort("ot_report_access_daily_sales"));
                userType.setOtReportAccessDailySalesCollection(rs.getShort("ot_report_access_daily_sales_collection"));
                userType.setOtReportAccessDailySalesPayment(rs.getShort("ot_report_access_daily_sales_payment"));
                userType.setOtReportAccessDailySalesReCust(rs.getShort("ot_report_access_daily_sales_re_cust"));
                userType.setOtReportAccessDailySalesReSupp(rs.getShort("ot_report_access_daily_sales_re_supp"));
                userType.setOtReportAccessDetailedTransfer(rs.getShort("ot_report_access_detailed_transfer"));
                userType.setOtReportAccessInventory(rs.getShort("ot_report_access_inventory"));
                userType.setOtReportAccessItemLedger(rs.getShort("ot_report_access_item_ledger"));
                userType.setOtReportAccessPostDated(rs.getShort("ot_report_access_post_dated"));
                userType.setOtReportAccessUserId(rs.getShort("ot_report_access_user_id"));
                userType.setOtReportAccessDetailedSales(rs.getShort("ot_report_access_detailed_sales"));
                userType.setOtReportAccessDetailedSalesperson(rs.getShort("ot_report_access_detailed_salesperson"));
                
                
                }

            rs.close();
            stmt.close();
            con.close();
        }catch(Exception e){
            e.getMessage();
        }
        return userType;
    }

    public Short getOtReportAccessDetailedSales() {
        return otReportAccessDetailedSales;
    }

    public void setOtReportAccessDetailedSales(Short otReportAccessDetailedSales) {
        this.otReportAccessDetailedSales = otReportAccessDetailedSales;
    }

    public Short getOtReportAccessDetailedSalesperson() {
        return otReportAccessDetailedSalesperson;
    }

    public void setOtReportAccessDetailedSalesperson(Short otReportAccessDetailedSalesperson) {
        this.otReportAccessDetailedSalesperson = otReportAccessDetailedSalesperson;
    }
}
