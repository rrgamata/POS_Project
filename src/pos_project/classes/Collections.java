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
@Table(name = "collections")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Collections.findAll", query = "SELECT c FROM Collections c"),
    @NamedQuery(name = "Collections.findByPaymentId", query = "SELECT c FROM Collections c WHERE c.paymentId = :paymentId"),
    @NamedQuery(name = "Collections.findByPaymentType", query = "SELECT c FROM Collections c WHERE c.paymentType = :paymentType"),
    @NamedQuery(name = "Collections.findByPaymentInvoiceId", query = "SELECT c FROM Collections c WHERE c.paymentInvoiceId = :paymentInvoiceId"),
    @NamedQuery(name = "Collections.findByPaymentAmount", query = "SELECT c FROM Collections c WHERE c.paymentAmount = :paymentAmount"),
    @NamedQuery(name = "Collections.findByPaymentDate", query = "SELECT c FROM Collections c WHERE c.paymentDate = :paymentDate"),
    @NamedQuery(name = "Collections.findByPaymentBalanceAsOf", query = "SELECT c FROM Collections c WHERE c.paymentBalanceAsOf = :paymentBalanceAsOf")})
public class Collections implements Serializable {

    @Column(name = "collection_credit_memo_flag")
    private Short collectionCreditMemoFlag;
    @Column(name = "collection_or_number")
    private String collectionOrNumber;
    @Column(name =     "collection_invoice_number")
    private String collectionInvoiceNumber;
    @Column(name =     "collection_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date collectionDate;
    @Column(name = "collection_check_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date collectionCheckDate;
    @Column(name = "collection_cleared_flag")
    private Short collectionClearedFlag;
    @Column(name = "collection_add_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date collectionAddDate;
    @Column(name = "collection_edit_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date collectionEditDate;
    @Column(name = "collection_del_flag")
    private Short collectionDelFlag;
    @Column(name = "collection_del_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date collectionDelDate;
    @Column(name = "collection_add_user")
    private String collectionAddUser;
    @Column(name = "collection_edit_user")
    private String collectionEditUser;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "collection_id")
    private Integer collectionId;
    @Column(name = "collection_number")
    private String collectionNumber;
    @Column(name = "collection_invoice_id")
    private Integer collectionInvoiceId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "collection_amount")
    private Double collectionAmount;
    @Column(name = "collection_balance_as_of")
    private Double collectionBalanceAsOf;
    @Column(name = "collection_type_flag")
    private Short collectionTypeFlag;
    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Basic(optional = false)
//    @Column(name = "payment_id")
//    private Integer paymentId;
//    @Column(name = "payment_type")
//    private String paymentType;
//    @Column(name = "payment_invoice_id")
//    private Integer paymentInvoiceId;
//    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
//    @Column(name = "payment_amount")
//    private Double paymentAmount;
//    @Column(name = "payment_date")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date paymentDate;
//    @Column(name = "payment_balance_as_of")
//    private Double paymentBalanceAsOf;
//    
    @Temporal(TemporalType.TIMESTAMP)
    private Date ledgerDate;
    private String particular;
    private Double credit;
    private Double charge;
    private String clientName;
    private String checkDate;
            

    public Collections() {
    }

    public Collections(Integer collectionId) {
        this.collectionId = collectionId;
    }

    public Integer getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Integer collectionId) {
        this.collectionId = collectionId;
    }

    public String getCollectionNumber() {
        return collectionNumber;
    }

    public void setCollectionNumber(String collectionNumber) {
        this.collectionNumber = collectionNumber;
    }

    public Integer getCollectionInvoiceId() {
        return collectionInvoiceId;
    }

    public void setCollectionInvoiceId(Integer collectionInvoiceId) {
        this.collectionInvoiceId = collectionInvoiceId;
    }

    public Double getCollectionAmount() {
        return collectionAmount;
    }

    public void setCollectionAmount(Double collectionAmount) {
        this.collectionAmount = collectionAmount;
    }

    public Date getCollectionDate() {
        return collectionDate;
    }

    public void setCollectionDate(Date collectionDate) {
        this.collectionDate = collectionDate;
    }

    public Double getCollectionBalanceAsOf() {
        return collectionBalanceAsOf;
    }

    public void setCollectionBalanceAsOf(Double collectionBalanceAsOf) {
        this.collectionBalanceAsOf = collectionBalanceAsOf;
    }

    public Short getCollectionTypeFlag() {
        return collectionTypeFlag;
    }

    public void setCollectionTypeFlag(Short collectionTypeFlag) {
        this.collectionTypeFlag = collectionTypeFlag;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (collectionId != null ? collectionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Collections)) {
            return false;
        }
        Collections other = (Collections) object;
        if ((this.collectionId == null && other.collectionId != null) || (this.collectionId != null && !this.collectionId.equals(other.collectionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pos_project.classes.Collections[ collectionId=" + collectionId + " ]";
    }
    
     public static int addCollectionCash(Collections c){
        int result = -1;
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.INSERT_IN_COLLECTION_CASH;
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setInt(1, c.getCollectionInvoiceId());
            prepStatement.setDouble(2, c.getCollectionAmount());
            prepStatement.setString(3 ,Formats.dateFormatSeconds.format(c.getCollectionDate()));
            prepStatement.setDouble(4, c.getCollectionBalanceAsOf());
            
            result = prepStatement.executeUpdate();
            
            prepStatement.close();
            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
     
       public static int addCollectionCash(Collections c, Connection con) throws SQLException{
        int result = -1;
//        try{
//            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.INSERT_IN_COLLECTION_CASH;
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setInt(1, c.getCollectionInvoiceId());
            prepStatement.setDouble(2, c.getCollectionAmount());
            prepStatement.setString(3 ,Formats.dateFormatSeconds.format(c.getCollectionDate()));
            prepStatement.setDouble(4, c.getCollectionBalanceAsOf());
               prepStatement.setString(5 ,Formats.dateFormatDays.format(c.getCollectionAddDate()));
            prepStatement.setString(6 ,c.getCollectionAddUser());
            prepStatement.setString(7 ,c.getCollectionInvoiceNumber());
            prepStatement.setString(8 ,c.getCollectionOrNumber());
            
            result = prepStatement.executeUpdate();
            
            prepStatement.close();
//            con.close();
//        }catch(Exception e){
////            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
        return result;
    }
     
     public static int addCollectionCheck(Collections c, String checkNumber){
        int result = -1;
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.INSERT_IN_COLLECTION_CHECK;
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, checkNumber);
            prepStatement.setInt(2, c.getCollectionInvoiceId());
            prepStatement.setDouble(3, c.getCollectionAmount());
            prepStatement.setString(4 ,Formats.dateFormatSeconds.format(c.getCollectionDate()));
            prepStatement.setDouble(5, c.getCollectionBalanceAsOf());
            
            result = prepStatement.executeUpdate();
            
            prepStatement.close();
            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
     
     public static int addCollectionCheck(Collections c, String checkNumber,Connection con) throws SQLException{
        int result = -1;
//        try{
//            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.INSERT_IN_COLLECTION_CHECK;
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, checkNumber);
            prepStatement.setInt(2, c.getCollectionInvoiceId());
            prepStatement.setDouble(3, c.getCollectionAmount());
            prepStatement.setString(4 ,Formats.dateFormatSeconds.format(c.getCollectionDate()));
            prepStatement.setString(5 ,Formats.dateFormatDays.format(c.getCollectionCheckDate()));
            prepStatement.setDouble(6, c.getCollectionBalanceAsOf());
            prepStatement.setShort(7, c.getCollectionClearedFlag());
            prepStatement.setString(8 ,Formats.dateFormatDays.format(c.getCollectionAddDate()));
            prepStatement.setString(9 ,c.getCollectionAddUser());
            prepStatement.setString(10 ,c.getCollectionInvoiceNumber());
            prepStatement.setString(11 ,c.getCollectionOrNumber());
            prepStatement.setShort(12 ,c.getCollectionCreditMemoFlag());
            
            result = prepStatement.executeUpdate();
            
            prepStatement.close();
//            con.close();
//        }catch(Exception e){
////            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
        return result;
    }
     
     
     public static int addCollection(Collections c, Short collectionType, String checkNumber,Connection con) throws SQLException{
        int result = -1;
//        try{
//            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.INSERT_IN_COLLECTION;
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, checkNumber);
            prepStatement.setInt(2, c.getCollectionInvoiceId());
            prepStatement.setDouble(3, c.getCollectionAmount());
            prepStatement.setString(4 ,Formats.dateFormatDays.format(c.getCollectionDate()));
            prepStatement.setString(5 , null);
            prepStatement.setDouble(6, c.getCollectionBalanceAsOf());
            prepStatement.setShort(7, collectionType);
            prepStatement.setShort(8, c.getCollectionClearedFlag());
            prepStatement.setString(9 ,Formats.dateFormatDays.format(c.getCollectionAddDate()));
            prepStatement.setString(10 ,c.getCollectionAddUser());
            prepStatement.setString(11 ,c.getCollectionInvoiceNumber());
            prepStatement.setString(12 ,c.getCollectionOrNumber());
            
            result = prepStatement.executeUpdate();
            
            prepStatement.close();
//            con.close();
//        }catch(Exception e){
////            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
        return result;
    }

    /**
     * @return the ledgerDate
     */
    public Date getLedgerDate() {
        return ledgerDate;
    }

    /**
     * @param ledgerDate the ledgerDate to set
     */
    public void setLedgerDate(Date ledgerDate) {
        this.ledgerDate = ledgerDate;
    }

    /**
     * @return the particular
     */
    public String getParticular() {
        return particular;
    }

    /**
     * @param particular the particular to set
     */
    public void setParticular(String particular) {
        this.particular = particular;
    }

    /**
     * @return the credit
     */
    public Double getCredit() {
        return credit;
    }

    /**
     * @param credit the credit to set
     */
    public void setCredit(Double credit) {
        this.credit = credit;
    }

    /**
     * @return the charge
     */
    public Double getCharge() {
        return charge;
    }

    /**
     * @param charge the charge to set
     */
    public void setCharge(Double charge) {
        this.charge = charge;
    }
    
    
    /**
     * @return the particular
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * @param particular the particular to set
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
    
     public static ArrayList<Collections> getAccountsReceivableLedger(int clientNumber){
        int result = -1;
        ArrayList<Collections> arr = new ArrayList<Collections>();
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.SELECT_RECEIVABLE_LEDGER;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setInt(1, clientNumber);
            prepStatement.setInt(2, clientNumber);
            ResultSet rs = prepStatement.executeQuery();
            while(rs.next()){
                Collections c = new Collections();
                c.setLedgerDate(rs.getDate("nDate"));
                c.setParticular(rs.getString("particular"));
                c.setCharge(rs.getDouble("charge"));
                c.setCredit(rs.getDouble("credit"));
                arr.add(c);
            }
            
//            result = prepStatement.executeUpdate();
            
            prepStatement.close();
            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return arr;
    }
     
     public static ArrayList<Collections> getAccountsReceivableLedgerWithDate(int clientNumber, String fromDate, String toDate){
        int result = -1;
        ArrayList<Collections> arr = new ArrayList<Collections>();
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.SELECT_RECEIVABLE_LEDGER_WITH_DATE;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setInt(1, clientNumber);
            prepStatement.setString(2, fromDate);
            prepStatement.setString(3, toDate);
            prepStatement.setInt(4, clientNumber);
            prepStatement.setString(5, fromDate);
            prepStatement.setString(6, toDate);
            System.out.println(prepStatement);
            ResultSet rs = prepStatement.executeQuery();
            while(rs.next()){
                Collections c = new Collections();
                c.setLedgerDate(rs.getDate("nDate"));
                c.setParticular(rs.getString("particular"));
                c.setCharge(rs.getDouble("charge"));
                c.setCredit(rs.getDouble("credit"));
                c.setCheckDate(rs.getString("check_date"));
                arr.add(c);
            }
            
//            result = prepStatement.executeUpdate();
            
            prepStatement.close();
            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return arr;
    }
     
      public static Double getCollectionAmount (String invoiceNumber){
        Double arr = 0.0;
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.SELECT_COLLECTED_BALACE;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, invoiceNumber);
            ResultSet rs = prepStatement.executeQuery();
            while(rs.next()){
               arr = rs.getDouble("balance");
            }
            
//            result = prepStatement.executeUpdate();
            
            prepStatement.close();
            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return arr;
     }
      
      public static Double getCollectionAmountUsingId (String invoiceNumber){
        Double arr = 0.0;
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.SELECT_COLLECTED_BALACE_USING_ID;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, invoiceNumber);
            ResultSet rs = prepStatement.executeQuery();
            while(rs.next()){
               arr = rs.getDouble("balance");
            }
            
//            result = prepStatement.executeUpdate();
            
            prepStatement.close();
            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return arr;
     }
      
      public static Double getCollectionBalanceUsingId (String invoiceNumber){
        Double arr = 0.0;
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.SELECT_COLLECTED_BALACE;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, invoiceNumber);
            ResultSet rs = prepStatement.executeQuery();
            while(rs.next()){
               arr = rs.getDouble("balance");
            }
            
//            result = prepStatement.executeUpdate();
            
            prepStatement.close();
            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return arr;
     }
      
      
          public static Double getCollectionAmountNotId (String invoiceNumber, String collectionId){
        Double arr = 0.0;
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.SELECT_COLLECTED_BALACE_NOT_ID;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, invoiceNumber);
            prepStatement.setString(2, collectionId);
            ResultSet rs = prepStatement.executeQuery();
            while(rs.next()){
               arr = rs.getDouble("balance");
            }
            
//            result = prepStatement.executeUpdate();
            
            prepStatement.close();
            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return arr;
     }
      
      public static Double getCollectionAmount (String invoiceNumber, Connection con){
        Double arr = 0.0;
        try{
//            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.SELECT_COLLECTED_BALACE;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, invoiceNumber);
            ResultSet rs = prepStatement.executeQuery();
            while(rs.next()){
               arr = rs.getDouble("balance");
            }
            
//            result = prepStatement.executeUpdate();
            
            prepStatement.close();
//            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return arr;
     }
     
     
     
     public static ArrayList<Collections> getCollectionWithDate(String invoiceNumber, int clientNumber, String fromDate, String toDate){
        int result = -1;
        ArrayList<Collections> arr = new ArrayList<Collections>();
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.SELECT_COLLECTION_WITH_DATE;
           PreparedStatement prepStatement = con.prepareStatement(sql);
           prepStatement.setString(1, invoiceNumber);
            prepStatement.setString(2, fromDate);
            prepStatement.setString(3, toDate);
            System.out.println(prepStatement);
            ResultSet rs = prepStatement.executeQuery();
            while(rs.next()){
                Collections c = new Collections();
                c.setLedgerDate(rs.getDate("nDate"));
                c.setParticular(rs.getString("particular"));
                c.setCharge(rs.getDouble("charge"));
                c.setCredit(rs.getDouble("credit"));
                c.setCheckDate(rs.getString("check_date"));
                c.setCollectionOrNumber(rs.getString("collection_or_number"));
                arr.add(c);
            }
            
//            result = prepStatement.executeUpdate();
            
            prepStatement.close();
            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return arr;
    }
     
     
     public static ArrayList<Collections> getCollectionInvoiceWithDate(int clientNumber, String fromDate, String toDate){
        int result = -1;
        ArrayList<Collections> arr = new ArrayList<Collections>();
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.SELECT_INVOICE_WITH_DATE;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setInt(1, clientNumber);
            prepStatement.setString(2, fromDate);
            prepStatement.setString(3, toDate);
            System.out.println(prepStatement);
            ResultSet rs = prepStatement.executeQuery();
            while(rs.next()){
                Collections c = new Collections();
                c.setLedgerDate(rs.getDate("nDate"));
                c.setParticular(rs.getString("particular"));
                c.setCharge(rs.getDouble("charge"));
                c.setCredit(rs.getDouble("credit"));
                c.setCheckDate(rs.getString("check_date"));
                c.setCollectionInvoiceNumber(rs.getString("nNum"));
                arr.add(c);
            }
            
//            result = prepStatement.executeUpdate();
            
            prepStatement.close();
            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return arr;
    }
     
     public static ArrayList<Collections> getAccountWithDate(int clientNumber, String fromDate, String toDate){
        int result = -1;
        ArrayList<Collections> arr = new ArrayList<Collections>();
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.SELECT_ACCOUNTS_RECEIVABLE_PAYABLE;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setInt(1, clientNumber);
            prepStatement.setInt(2, clientNumber);
            prepStatement.setString(3, fromDate);
            prepStatement.setString(4, toDate);
            System.out.println(prepStatement);
            ResultSet rs = prepStatement.executeQuery();
            while(rs.next()){
                Collections c = new Collections();
                c.setLedgerDate(rs.getDate("nDate"));
                c.setParticular(rs.getString("particular"));
                c.setCharge(rs.getDouble("charge"));
                c.setCredit(rs.getDouble("credit"));
                c.setCheckDate(rs.getString("check_date"));
                c.setCollectionInvoiceNumber(rs.getString("nNum"));
                c.setCollectionBalanceAsOf(rs.getDouble("balance"));
                c.setCollectionNumber(rs.getString("nId"));
                c.setCollectionDate(rs.getDate("collection_date"));
                c.setCollectionDelDate(rs.getDate("invoice_date"));
                arr.add(c);
            }
            
//            result = prepStatement.executeUpdate();
            
            prepStatement.close();
            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return arr;
    }
     
     
     public static ArrayList<Collections> getInvoiceCollections(String invoiceNumber){
        int result = -1;
        ArrayList<Collections> arr = new ArrayList<Collections>();
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.SELECT_COLLECTION_LIST;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, invoiceNumber);
            ResultSet rs = prepStatement.executeQuery();
            while(rs.next()){
                Collections c = new Collections();
                c.setCollectionId(rs.getInt("collection_id"));
                c.setCollectionDate(rs.getDate("collection_date"));
                c.setCollectionCheckDate(rs.getDate("collection_check_date"));
                c.setCollectionTypeFlag(rs.getShort("collection_type_flag"));
                c.setCollectionClearedFlag(rs.getShort("collection_cleared_flag"));
                c.setParticular(rs.getString("particular"));
                c.setCollectionAmount(rs.getDouble("collection_amount"));
                c.setCollectionAddDate(rs.getDate("collection_add_date"));
                c.setCollectionAddUser(rs.getString("add_user"));
                c.setCollectionEditDate(rs.getDate("collection_edit_date"));
                c.setCollectionEditUser(rs.getString("edit_user"));
                arr.add(c);
            }
            
//            result = prepStatement.executeUpdate();
            
            prepStatement.close();
            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return arr;
    }
     
     
     public static ArrayList<Collections> getInvoiceCollectionsUsingId(String invoiceNumber){
        int result = -1;
        ArrayList<Collections> arr = new ArrayList<Collections>();
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.SELECT_COLLECTION_LIST_USING_ID;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, invoiceNumber);
            ResultSet rs = prepStatement.executeQuery();
            while(rs.next()){
                Collections c = new Collections();
                c.setCollectionId(rs.getInt("collection_id"));
                c.setCollectionDate(rs.getDate("collection_date"));
                c.setCollectionCheckDate(rs.getDate("collection_check_date"));
                c.setCollectionTypeFlag(rs.getShort("collection_type_flag"));
                c.setCollectionClearedFlag(rs.getShort("collection_cleared_flag"));
                c.setParticular(rs.getString("particular"));
                c.setCollectionAmount(rs.getDouble("collection_amount"));
                c.setCollectionAddDate(rs.getDate("collection_add_date"));
                c.setCollectionAddUser(rs.getString("add_user"));
                c.setCollectionEditDate(rs.getDate("collection_edit_date"));
                c.setCollectionEditUser(rs.getString("edit_user"));
                arr.add(c);
            }
            
//            result = prepStatement.executeUpdate();
            
            prepStatement.close();
            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return arr;
    }
     
     public static ArrayList<Collections> getPostDatedCollections(int clientId){
        int result = -1;
        ArrayList<Collections> arr = new ArrayList<Collections>();
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.SELECT_POST_DATED_COLLECTION_LIST;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setInt(1, clientId);
            ResultSet rs = prepStatement.executeQuery();
            while(rs.next()){
                Collections c = new Collections();
                c.setCollectionId(rs.getInt("collection_id"));
                c.setCollectionDate(rs.getDate("collection_date"));
                c.setCollectionCheckDate(rs.getDate("collection_check_date"));
                c.setCollectionTypeFlag(rs.getShort("collection_type_flag"));
                c.setCollectionClearedFlag(rs.getShort("collection_cleared_flag"));
                c.setParticular(rs.getString("particular"));
                c.setCollectionAmount(rs.getDouble("collection_amount"));
                c.setCollectionAddDate(rs.getDate("collection_add_date"));
                c.setCollectionAddUser(rs.getString("add_user"));
                c.setCollectionEditDate(rs.getDate("collection_edit_date"));
                c.setCollectionEditUser(rs.getString("edit_user"));
                arr.add(c);
            }
            
//            result = prepStatement.executeUpdate();
            
            prepStatement.close();
            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return arr;
    }
     
     
     public static ArrayList<Collections> getCollectionsWithDate(String date){
        int result = -1;
        ArrayList<Collections> arr = new ArrayList<Collections>();
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.SELECT_COLLECTION_LIST_DATE;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, date+"%");
            System.out.println(prepStatement);
            ResultSet rs = prepStatement.executeQuery();
            while(rs.next()){
                Collections c = new Collections();
                c.setCollectionId(rs.getInt("collection_id"));
                c.setCollectionDate(rs.getDate("collection_date"));
                c.setCollectionCheckDate(rs.getDate("collection_check_date"));
                c.setCollectionTypeFlag(rs.getShort("collection_type_flag"));
                c.setCollectionClearedFlag(rs.getShort("collection_cleared_flag"));
                c.setParticular(rs.getString("particular"));
                c.setCollectionAmount(rs.getDouble("collection_amount"));
                c.setCollectionAddDate(rs.getDate("collection_add_date"));
                c.setCollectionAddUser(rs.getString("add_user"));
                c.setCollectionEditDate(rs.getDate("collection_edit_date"));
                c.setCollectionEditUser(rs.getString("edit_user"));
                c.setClientName(rs.getString("client_name"));
                c.setCollectionOrNumber(rs.getString("collection_or_number"));
                arr.add(c);
            }
            
//            result = prepStatement.executeUpdate();
            
            prepStatement.close();
            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return arr;
    }
     
     public static ArrayList<Collections> getPaymentsWithDate(String date){
        int result = -1;
        ArrayList<Collections> arr = new ArrayList<Collections>();
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.SELECT_PAYMENT_LIST_DATE;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, date+"%");
            ResultSet rs = prepStatement.executeQuery();
            while(rs.next()){
                Collections c = new Collections();
                c.setCollectionId(rs.getInt("collection_id"));
                c.setCollectionDate(rs.getDate("collection_date"));
                c.setCollectionCheckDate(rs.getDate("collection_check_date"));
                c.setCollectionTypeFlag(rs.getShort("collection_type_flag"));
                c.setCollectionClearedFlag(rs.getShort("collection_cleared_flag"));
                c.setParticular(rs.getString("particular"));
                c.setCollectionAmount(rs.getDouble("collection_amount"));
                c.setCollectionAddDate(rs.getDate("collection_add_date"));
                c.setCollectionAddUser(rs.getString("add_user"));
                c.setCollectionEditDate(rs.getDate("collection_edit_date"));
                c.setCollectionEditUser(rs.getString("edit_user"));
                c.setClientName(rs.getString("client_name"));
                arr.add(c);
            }
            
//            result = prepStatement.executeUpdate();
            
            prepStatement.close();
            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return arr;
    }
     
 public static ArrayList<Collections> getCollectionPaymentsWithDate(String fromDate, String toDate, int collectionType){
        int result = -1;
        ArrayList<Collections> arr = new ArrayList<Collections>();
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.SELECT_COLLECTION_PAYMENT_LIST_DATE;
           PreparedStatement prepStatement = con.prepareStatement(sql);
           prepStatement.setInt(1, collectionType);
            prepStatement.setString(2, fromDate);
            prepStatement.setString(3, toDate);
            System.out.println(prepStatement);
            ResultSet rs = prepStatement.executeQuery();
            
            while(rs.next()){
                Collections c = new Collections();
                c.setCollectionId(rs.getInt("collection_id"));
                c.setCollectionDate(rs.getDate("collection_date"));
                c.setCollectionOrNumber(rs.getString("or_number"));
                c.setCollectionCheckDate(rs.getDate("collection_check_date"));
                c.setCollectionTypeFlag(rs.getShort("collection_type_flag"));
                c.setCollectionClearedFlag(rs.getShort("collection_cleared_flag"));
                c.setParticular(rs.getString("particular"));
                c.setCollectionAmount(rs.getDouble("collection_amount"));
                c.setCollectionAddDate(rs.getDate("collection_add_date"));
                c.setCollectionAddUser(rs.getString("add_user"));
                c.setCollectionEditDate(rs.getDate("collection_edit_date"));
                c.setCollectionEditUser(rs.getString("edit_user"));
                c.setClientName(rs.getString("client_name"));
                arr.add(c);
            }
            
//            result = prepStatement.executeUpdate();
            
            prepStatement.close();
            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return arr;
    }
     
      public static int clearCollection(String collectionId){
        int result = -1;
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.CLEAR_COLLECTION;
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, collectionId);
            
            
            result = prepStatement.executeUpdate();
            
            prepStatement.close();
            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
      
      
      public static int deleteCollection(String collectionId, Date collectionDelDate){
        int result = -1;
        try{
            Connection con = SQLConnection.getSQLConnection();
            result = deleteCollection(collectionId, collectionDelDate,con);
            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
      
      public static int deleteCollection(String collectionId, Date collectionDelDate, Connection con){
        int result = -1;
        try{
//            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.DELETE_COLLECTION;
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, Formats.dateFormatSeconds.format(collectionDelDate));
            prepStatement.setString(2, collectionId);
            
            
            result = prepStatement.executeUpdate();
            
            prepStatement.close();
//            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
      
    public static int deleteCollectionWithInvoice(String invoiceId, Date collectionDelDate){
        int result = -1;
        try{
            Connection con = SQLConnection.getSQLConnection();
            result = deleteCollectionWithInvoice(invoiceId, collectionDelDate, con);
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }  
     
    
    public static int deleteCollectionWithInvoice(String invoiceId, Date collectionDelDate, Connection con){
        int result = -1;
        try{
            
            String sql = SqlStatements.DELETE_COLLECTION_WITH_INVOICE_ID;
            PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, Formats.dateFormatSeconds.format(collectionDelDate));
            prepStatement.setString(2, invoiceId);
            
            
            result = prepStatement.executeUpdate();
            
            prepStatement.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }  
      
      public static Collections getCollection(String collectionId){
        int result = -1;
        Collections c = new Collections();
        try{
            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.SELECT_COLLECTION;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            prepStatement.setString(1, collectionId);
            ResultSet rs = prepStatement.executeQuery();
            System.out.println(prepStatement);
            while(rs.next()){

//                c.setLedgerDate(rs.getDate("nDate"));
//                c.setParticular(rs.getString("particular"));
//                c.setCharge(rs.getDouble("charge"));
//                c.setCredit(rs.getDouble("credit"));
                c.setCollectionDate(rs.getDate("collection_date"));
                c.setCollectionCheckDate(rs.getDate("collection_check_date"));
                c.setCollectionId(rs.getInt("collection_id"));
                c.setCollectionTypeFlag(rs.getShort("collection_type_flag"));
                c.setCollectionNumber(rs.getString("collection_number"));
                c.setCollectionClearedFlag(rs.getShort("collection_cleared_flag"));
                c.setCollectionAmount(rs.getDouble("collection_amount"));
                c.setCollectionInvoiceId(rs.getInt("collection_invoice_id"));
                
            }
            
//            result = prepStatement.executeUpdate();
            
            prepStatement.close();
            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return c;
    }
     
        
          public static int updateCheckCollection(Collections c, Connection con){
        int result = -1;
//        Collections c = new Collections();
        try{
//            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.UPDATE_CHECK_COLLECTION;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            
            prepStatement.setString(1, Formats.dateFormatDays.format(c.getCollectionDate()));
            prepStatement.setString(2, Formats.dateFormatDays.format(c.getCollectionCheckDate()));
//                c.setCollectionCheckDate(rs.getDate("collection_check_date"));
            prepStatement.setShort(3, c.getCollectionTypeFlag());                
            prepStatement.setString(4, c.getCollectionNumber());    
            prepStatement.setShort(5, c.getCollectionClearedFlag());                
            prepStatement.setDouble(6, c.getCollectionAmount());                
            prepStatement.setString(7, Formats.dateFormatSeconds.format(c.getCollectionEditDate()));                
            prepStatement.setString(8, c.getCollectionEditUser());                
            prepStatement.setString(9, c.getCollectionOrNumber());                
            prepStatement.setInt(10, c.getCollectionId());
            result = prepStatement.executeUpdate();
            
                
            
            
//            result = prepStatement.executeUpdate();
            
            prepStatement.close();
//            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
          
          public static int updateCashCollection(Collections c, Connection con){
        int result = -1;
//        Collections c = new Collections();
        try{
//            Connection con = SQLConnection.getSQLConnection();
            String sql = SqlStatements.UPDATE_CASH_COLLECTION;
           PreparedStatement prepStatement = con.prepareStatement(sql);
            
            prepStatement.setString(1, Formats.dateFormatDays.format(c.getCollectionDate()));
//            prepStatement.setString(2, Formats.dateFormatDays.format(c.getCollectionCheckDate()));
//                c.setCollectionCheckDate(rs.getDate("collection_check_date"));
            prepStatement.setShort(2, c.getCollectionTypeFlag());                
//            prepStatement.setString(4, c.getCollectionNumber());    
            prepStatement.setShort(3, c.getCollectionClearedFlag());                
            prepStatement.setDouble(4, c.getCollectionAmount());                
            prepStatement.setString(5, Formats.dateFormatSeconds.format(c.getCollectionEditDate()));                
            prepStatement.setString(6, c.getCollectionEditUser());                
            prepStatement.setString(7, c.getCollectionOrNumber()); 
            prepStatement.setInt(8, c.getCollectionId());
            result = prepStatement.executeUpdate();
            
                
            
            
//            result = prepStatement.executeUpdate();
            
            prepStatement.close();
//            con.close();
        }catch(Exception e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
     
     

//    public Date getCollectionDate() {
//        return collectionDate;
//    }
//
//    public void setCollectionDate(Date collectionDate) {
//        this.collectionDate = collectionDate;
//    }

    public Date getCollectionAddDate() {
        return collectionAddDate;
    }

    public void setCollectionAddDate(Date collectionAddDate) {
        this.collectionAddDate = collectionAddDate;
    }

    public String getCollectionAddUser() {
        return collectionAddUser;
    }

    public void setCollectionAddUser(String collectionAddUser) {
        this.collectionAddUser = collectionAddUser;
    }

    public Date getCollectionEditDate() {
        return collectionEditDate;
    }

    public void setCollectionEditDate(Date collectionEditDate) {
        this.collectionEditDate = collectionEditDate;
    }

    public String getCollectionEditUser() {
        return collectionEditUser;
    }

    public void setCollectionEditUser(String collectionEditUser) {
        this.collectionEditUser = collectionEditUser;
    }

    public String getCollectionInvoiceNumber() {
        return collectionInvoiceNumber;
    }

    public void setCollectionInvoiceNumber(String collectionInvoiceNumber) {
        this.collectionInvoiceNumber = collectionInvoiceNumber;
    }

//    public Date getCollectionDate() {
//        return collectionDate;
//    }
//
//    public void setCollectionDate(Date collectionDate) {
//        this.collectionDate = collectionDate;
//    }

    public Date getCollectionCheckDate() {
        return collectionCheckDate;
    }

    public void setCollectionCheckDate(Date collectionCheckDate) {
        this.collectionCheckDate = collectionCheckDate;
    }

    public Short getCollectionClearedFlag() {
        return collectionClearedFlag;
    }

    public void setCollectionClearedFlag(Short collectionClearedFlag) {
        this.collectionClearedFlag = collectionClearedFlag;
    }

//    public Date getCollectionAddDate() {
//        return collectionAddDate;
//    }
//
//    public void setCollectionAddDate(Date collectionAddDate) {
//        this.collectionAddDate = collectionAddDate;
//    }
//
//    public Date getCollectionEditDate() {
//        return collectionEditDate;
//    }
//
//    public void setCollectionEditDate(Date collectionEditDate) {
//        this.collectionEditDate = collectionEditDate;
//    }

    public Short getCollectionDelFlag() {
        return collectionDelFlag;
    }

    public void setCollectionDelFlag(Short collectionDelFlag) {
        this.collectionDelFlag = collectionDelFlag;
    }

    public Date getCollectionDelDate() {
        return collectionDelDate;
    }

    public void setCollectionDelDate(Date collectionDelDate) {
        this.collectionDelDate = collectionDelDate;
    }

    /**
     * @return the checkDate
     */
    public String getCheckDate() {
        return checkDate;
    }

    /**
     * @param checkDate the checkDate to set
     */
    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
    }

    public String getCollectionOrNumber() {
        return collectionOrNumber;
    }

    public void setCollectionOrNumber(String collectionOrNumber) {
        this.collectionOrNumber = collectionOrNumber;
    }
    
    
    public static int getLatestCollection(Connection con) throws SQLException{
        int invoiceId = 0;;
//        try{
//            Connection con = SQLConnection.getSQLConnection();
            Statement stmt = con.createStatement();
            String sql = SqlStatements.SELECT_LATEST_COLLECTION;
            System.out.print(sql);
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                invoiceId = rs.getInt("collection_id");
            }

            rs.close();
            stmt.close();
//            con.close();
//        }catch(Exception e){
//            e.printStackTrace();
////            e.getMessage();
//        }
        return invoiceId;
    }

    public Short getCollectionCreditMemoFlag() {
        return collectionCreditMemoFlag;
    }

    public void setCollectionCreditMemoFlag(Short collectionCreditMemoFlag) {
        this.collectionCreditMemoFlag = collectionCreditMemoFlag;
    }
}

