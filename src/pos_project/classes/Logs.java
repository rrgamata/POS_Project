/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pos_project.classes;

import java.io.Serializable;
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
@Table(name = "logs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Logs.findAll", query = "SELECT l FROM Logs l"),
    @NamedQuery(name = "Logs.findByLogId", query = "SELECT l FROM Logs l WHERE l.logId = :logId"),
    @NamedQuery(name = "Logs.findByLogAction", query = "SELECT l FROM Logs l WHERE l.logAction = :logAction"),
    @NamedQuery(name = "Logs.findByLogUser", query = "SELECT l FROM Logs l WHERE l.logUser = :logUser"),
    @NamedQuery(name = "Logs.findByLogDate", query = "SELECT l FROM Logs l WHERE l.logDate = :logDate"),
    @NamedQuery(name = "Logs.findByLogTable", query = "SELECT l FROM Logs l WHERE l.logTable = :logTable"),
    @NamedQuery(name = "Logs.findByLogDetails", query = "SELECT l FROM Logs l WHERE l.logDetails = :logDetails")})
public class Logs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "log_id")
    private Integer logId;
    @Column(name = "log_action")
    private String logAction;
    @Column(name = "log_user")
    private String logUser;
    @Column(name = "log_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date logDate;
    @Column(name = "log_table")
    private String logTable;
    @Column(name = "log_details")
    private String logDetails;

    public Logs() {
    }

    public Logs(Integer logId) {
        this.logId = logId;
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public String getLogAction() {
        return logAction;
    }

    public void setLogAction(String logAction) {
        this.logAction = logAction;
    }

    public String getLogUser() {
        return logUser;
    }

    public void setLogUser(String logUser) {
        this.logUser = logUser;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public String getLogTable() {
        return logTable;
    }

    public void setLogTable(String logTable) {
        this.logTable = logTable;
    }

    public String getLogDetails() {
        return logDetails;
    }

    public void setLogDetails(String logDetails) {
        this.logDetails = logDetails;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (logId != null ? logId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Logs)) {
            return false;
        }
        Logs other = (Logs) object;
        if ((this.logId == null && other.logId != null) || (this.logId != null && !this.logId.equals(other.logId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pos_project.classes.Logs[ logId=" + logId + " ]";
    }
    
}
