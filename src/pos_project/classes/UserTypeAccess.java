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
@Table(name = "user_type_access")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserTypeAccess.findAll", query = "SELECT u FROM UserTypeAccess u"),
    @NamedQuery(name = "UserTypeAccess.findByUserTypeId", query = "SELECT u FROM UserTypeAccess u WHERE u.userTypeId = :userTypeId"),
    @NamedQuery(name = "UserTypeAccess.findByUserTypeDebitMemo", query = "SELECT u FROM UserTypeAccess u WHERE u.userTypeDebitMemo = :userTypeDebitMemo"),
    @NamedQuery(name = "UserTypeAccess.findByUserTypeCreditMemo", query = "SELECT u FROM UserTypeAccess u WHERE u.userTypeCreditMemo = :userTypeCreditMemo"),
    @NamedQuery(name = "UserTypeAccess.findByUserTypeEditPoM", query = "SELECT u FROM UserTypeAccess u WHERE u.userTypeEditPoM = :userTypeEditPoM"),
    @NamedQuery(name = "UserTypeAccess.findByUserTypeEditTransfer", query = "SELECT u FROM UserTypeAccess u WHERE u.userTypeEditTransfer = :userTypeEditTransfer"),
    @NamedQuery(name = "UserTypeAccess.findByUserTypeEditInvoice", query = "SELECT u FROM UserTypeAccess u WHERE u.userTypeEditInvoice = :userTypeEditInvoice"),
    @NamedQuery(name = "UserTypeAccess.findByUserTypeEditCollection", query = "SELECT u FROM UserTypeAccess u WHERE u.userTypeEditCollection = :userTypeEditCollection"),
    @NamedQuery(name = "UserTypeAccess.findByUserTypeUser", query = "SELECT u FROM UserTypeAccess u WHERE u.userTypeUser = :userTypeUser"),
    @NamedQuery(name = "UserTypeAccess.findByUserTypeHome", query = "SELECT u FROM UserTypeAccess u WHERE u.userTypeHome = :userTypeHome"),
    @NamedQuery(name = "UserTypeAccess.findByUserTypeLocation", query = "SELECT u FROM UserTypeAccess u WHERE u.userTypeLocation = :userTypeLocation"),
    @NamedQuery(name = "UserTypeAccess.findByUserTypeReport", query = "SELECT u FROM UserTypeAccess u WHERE u.userTypeReport = :userTypeReport"),
    @NamedQuery(name = "UserTypeAccess.findByUserTypeClient", query = "SELECT u FROM UserTypeAccess u WHERE u.userTypeClient = :userTypeClient"),
    @NamedQuery(name = "UserTypeAccess.findByUserTypeItem", query = "SELECT u FROM UserTypeAccess u WHERE u.userTypeItem = :userTypeItem"),
    @NamedQuery(name = "UserTypeAccess.findByUserTypeOut", query = "SELECT u FROM UserTypeAccess u WHERE u.userTypeOut = :userTypeOut"),
    @NamedQuery(name = "UserTypeAccess.findByUserTypeCollection", query = "SELECT u FROM UserTypeAccess u WHERE u.userTypeCollection = :userTypeCollection"),
    @NamedQuery(name = "UserTypeAccess.findByUserTypeAccountSettings", query = "SELECT u FROM UserTypeAccess u WHERE u.userTypeAccountSettings = :userTypeAccountSettings"),
    @NamedQuery(name = "UserTypeAccess.findByUserTypeTransfer", query = "SELECT u FROM UserTypeAccess u WHERE u.userTypeTransfer = :userTypeTransfer"),
    @NamedQuery(name = "UserTypeAccess.findByUserTypeAdjust", query = "SELECT u FROM UserTypeAccess u WHERE u.userTypeAdjust = :userTypeAdjust"),
    @NamedQuery(name = "UserTypeAccess.findByUserTypeIn", query = "SELECT u FROM UserTypeAccess u WHERE u.userTypeIn = :userTypeIn"),
    @NamedQuery(name = "UserTypeAccess.findByUserTypePayment", query = "SELECT u FROM UserTypeAccess u WHERE u.userTypePayment = :userTypePayment"),
    @NamedQuery(name = "UserTypeAccess.findByUserTypePo", query = "SELECT u FROM UserTypeAccess u WHERE u.userTypePo = :userTypePo"),
    @NamedQuery(name = "UserTypeAccess.findByUserTypeReturn", query = "SELECT u FROM UserTypeAccess u WHERE u.userTypeReturn = :userTypeReturn"),
    @NamedQuery(name = "UserTypeAccess.findByUserTypeArReport", query = "SELECT u FROM UserTypeAccess u WHERE u.userTypeArReport = :userTypeArReport")})
public class UserTypeAccess implements Serializable {

    @Column(name = "user_type_convert")
    private Short userTypeConvert;
    @Column(name = "user_type_check_voucher")
    private Short userTypeCheckVoucher;
    @Column(name = "user_type_salesperson")
    private Short userTypeSalesperson;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "user_type_id")
    private Short userTypeId;
    @Column(name = "user_type_debit_memo")
    private Short userTypeDebitMemo;
    @Column(name = "user_type_credit_memo")
    private Short userTypeCreditMemo;
    @Column(name = "user_type_edit_po_m")
    private Short userTypeEditPoM;
    @Column(name = "user_type_edit_transfer")
    private Short userTypeEditTransfer;
    @Column(name = "user_type_edit_invoice")
    private Short userTypeEditInvoice;
    @Column(name = "user_type_edit_collection")
    private Short userTypeEditCollection;
    @Column(name = "user_type_user")
    private Short userTypeUser;
    @Column(name = "user_type_home")
    private Short userTypeHome;
    @Column(name = "user_type_location")
    private Short userTypeLocation;
    @Column(name = "user_type_report")
    private Short userTypeReport;
    @Column(name = "user_type_client")
    private Short userTypeClient;
    @Column(name = "user_type_item")
    private Short userTypeItem;
    @Column(name = "user_type_out")
    private Short userTypeOut;
    @Column(name = "user_type_collection")
    private Short userTypeCollection;
    @Column(name = "user_type_account_settings")
    private Short userTypeAccountSettings;
    @Column(name = "user_type_transfer")
    private Short userTypeTransfer;
    @Column(name = "user_type_adjust")
    private Short userTypeAdjust;
    @Column(name = "user_type_in")
    private Short userTypeIn;
    @Column(name = "user_type_payment")
    private Short userTypePayment;
    @Column(name = "user_type_po")
    private Short userTypePo;
    @Column(name = "user_type_return")
    private Short userTypeReturn;
    @Column(name = "user_type_ar_report")
    private Short userTypeArReport;

    public UserTypeAccess() {
    }

    public UserTypeAccess(Short userTypeId) {
        this.userTypeId = userTypeId;
    }

    public Short getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(Short userTypeId) {
        this.userTypeId = userTypeId;
    }

    public Short getUserTypeDebitMemo() {
        return userTypeDebitMemo;
    }

    public void setUserTypeDebitMemo(Short userTypeDebitMemo) {
        this.userTypeDebitMemo = userTypeDebitMemo;
    }

    public Short getUserTypeCreditMemo() {
        return userTypeCreditMemo;
    }

    public void setUserTypeCreditMemo(Short userTypeCreditMemo) {
        this.userTypeCreditMemo = userTypeCreditMemo;
    }

    public Short getUserTypeEditPoM() {
        return userTypeEditPoM;
    }

    public void setUserTypeEditPoM(Short userTypeEditPoM) {
        this.userTypeEditPoM = userTypeEditPoM;
    }

    public Short getUserTypeEditTransfer() {
        return userTypeEditTransfer;
    }

    public void setUserTypeEditTransfer(Short userTypeEditTransfer) {
        this.userTypeEditTransfer = userTypeEditTransfer;
    }

    public Short getUserTypeEditInvoice() {
        return userTypeEditInvoice;
    }

    public void setUserTypeEditInvoice(Short userTypeEditInvoice) {
        this.userTypeEditInvoice = userTypeEditInvoice;
    }

    public Short getUserTypeEditCollection() {
        return userTypeEditCollection;
    }

    public void setUserTypeEditCollection(Short userTypeEditCollection) {
        this.userTypeEditCollection = userTypeEditCollection;
    }

    public Short getUserTypeUser() {
        return userTypeUser;
    }

    public void setUserTypeUser(Short userTypeUser) {
        this.userTypeUser = userTypeUser;
    }

    public Short getUserTypeHome() {
        return userTypeHome;
    }

    public void setUserTypeHome(Short userTypeHome) {
        this.userTypeHome = userTypeHome;
    }

    public Short getUserTypeLocation() {
        return userTypeLocation;
    }

    public void setUserTypeLocation(Short userTypeLocation) {
        this.userTypeLocation = userTypeLocation;
    }

    public Short getUserTypeReport() {
        return userTypeReport;
    }

    public void setUserTypeReport(Short userTypeReport) {
        this.userTypeReport = userTypeReport;
    }

    public Short getUserTypeClient() {
        return userTypeClient;
    }

    public void setUserTypeClient(Short userTypeClient) {
        this.userTypeClient = userTypeClient;
    }

    public Short getUserTypeItem() {
        return userTypeItem;
    }

    public void setUserTypeItem(Short userTypeItem) {
        this.userTypeItem = userTypeItem;
    }

    public Short getUserTypeOut() {
        return userTypeOut;
    }

    public void setUserTypeOut(Short userTypeOut) {
        this.userTypeOut = userTypeOut;
    }

    public Short getUserTypeCollection() {
        return userTypeCollection;
    }

    public void setUserTypeCollection(Short userTypeCollection) {
        this.userTypeCollection = userTypeCollection;
    }

    public Short getUserTypeAccountSettings() {
        return userTypeAccountSettings;
    }

    public void setUserTypeAccountSettings(Short userTypeAccountSettings) {
        this.userTypeAccountSettings = userTypeAccountSettings;
    }

    public Short getUserTypeTransfer() {
        return userTypeTransfer;
    }

    public void setUserTypeTransfer(Short userTypeTransfer) {
        this.userTypeTransfer = userTypeTransfer;
    }

    public Short getUserTypeAdjust() {
        return userTypeAdjust;
    }

    public void setUserTypeAdjust(Short userTypeAdjust) {
        this.userTypeAdjust = userTypeAdjust;
    }

    public Short getUserTypeIn() {
        return userTypeIn;
    }

    public void setUserTypeIn(Short userTypeIn) {
        this.userTypeIn = userTypeIn;
    }

    public Short getUserTypePayment() {
        return userTypePayment;
    }

    public void setUserTypePayment(Short userTypePayment) {
        this.userTypePayment = userTypePayment;
    }

    public Short getUserTypePo() {
        return userTypePo;
    }

    public void setUserTypePo(Short userTypePo) {
        this.userTypePo = userTypePo;
    }

    public Short getUserTypeReturn() {
        return userTypeReturn;
    }

    public void setUserTypeReturn(Short userTypeReturn) {
        this.userTypeReturn = userTypeReturn;
    }

    public Short getUserTypeArReport() {
        return userTypeArReport;
    }

    public void setUserTypeArReport(Short userTypeArReport) {
        this.userTypeArReport = userTypeArReport;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userTypeId != null ? userTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserTypeAccess)) {
            return false;
        }
        UserTypeAccess other = (UserTypeAccess) object;
        if ((this.userTypeId == null && other.userTypeId != null) || (this.userTypeId != null && !this.userTypeId.equals(other.userTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pos_project.classes.UserTypeAccess[ userTypeId=" + userTypeId + " ]";
    }
    
     public static UserTypeAccess getUserTypeAccess(Short userTypeId){
       UserTypeAccess userType = new UserTypeAccess();
        try{
            Connection con = SQLConnection.getSQLConnection();
            Statement stmt = con.createStatement();
            String sql = SqlStatements.SELECT_USER_RIGHTS;
             PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setShort(1, userTypeId);
             ResultSet rs = prepStatement.executeQuery();
            
            while(rs.next()){
                
                userType.setUserTypeId(rs.getShort("user_type_id"));
                userType.setUserTypeDebitMemo(rs.getShort("user_type_debit_memo"));
                userType.setUserTypeCreditMemo(rs.getShort("user_type_credit_memo"));
                userType.setUserTypeEditPoM(rs.getShort("user_type_edit_po_m"));
                userType.setUserTypeEditTransfer(rs.getShort("user_type_edit_transfer"));
                userType.setUserTypeEditInvoice(rs.getShort("user_type_edit_invoice"));
                userType.setUserTypeEditCollection(rs.getShort("user_type_edit_collection"));
                userType.setUserTypeUser(rs.getShort("user_type_user"));
                userType.setUserTypeHome(rs.getShort("user_type_home"));
                userType.setUserTypeLocation(rs.getShort("user_type_location"));
                userType.setUserTypeReport(rs.getShort("user_type_report"));
                userType.setUserTypeClient(rs.getShort("user_type_client"));
                userType.setUserTypeItem(rs.getShort("user_type_item"));
                userType.setUserTypeOut(rs.getShort("user_type_out"));
                userType.setUserTypeCollection(rs.getShort("user_type_collection"));
                userType.setUserTypeAccountSettings(rs.getShort("user_type_account_settings"));
                userType.setUserTypeTransfer(rs.getShort("user_type_transfer"));
                userType.setUserTypeAdjust(rs.getShort("user_type_adjust"));
                userType.setUserTypeIn(rs.getShort("user_type_in"));
                userType.setUserTypePayment(rs.getShort("user_type_payment"));
                userType.setUserTypePo(rs.getShort("user_type_po"));
                userType.setUserTypeReturn(rs.getShort("user_type_return"));
                userType.setUserTypeArReport(rs.getShort("user_type_ar_report"));
                userType.setUserTypeSalesperson(rs.getShort("user_type_salesperson"));
                userType.setUserTypeCheckVoucher(rs.getShort("user_type_check_voucher"));
                
                
            }

            rs.close();
            stmt.close();
            con.close();
        }catch(Exception e){
            e.getMessage();
        }
        return userType;
    }

    public Short getUserTypeSalesperson() {
        return userTypeSalesperson;
    }

    public void setUserTypeSalesperson(Short userTypeSalesperson) {
        this.userTypeSalesperson = userTypeSalesperson;
    }

    public Short getUserTypeConvert() {
        return userTypeConvert;
    }

    public void setUserTypeConvert(Short userTypeConvert) {
        this.userTypeConvert = userTypeConvert;
    }

    public Short getUserTypeCheckVoucher() {
        return userTypeCheckVoucher;
    }

    public void setUserTypeCheckVoucher(Short userTypeCheckVoucher) {
        this.userTypeCheckVoucher = userTypeCheckVoucher;
    }
}
