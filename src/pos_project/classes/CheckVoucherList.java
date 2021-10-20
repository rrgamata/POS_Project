/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos_project.classes;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cifer
 */
public class CheckVoucherList {
    private ArrayList<CheckVoucher> checkVoucherList;
    private ArrayList<CheckInvoiceList> invoiceList;
    private ArrayList<CheckInvoiceList> checkNumberList;
    private DefaultTableModel invoiceListModel;
    private DefaultTableModel checkListModel;

    /**
     * @return the checkVoucherList
     */
    public ArrayList<CheckVoucher> getCheckVoucherList() {
        return checkVoucherList;
    }

    /**
     * @param checkVoucherList the checkVoucherList to set
     */
    public void setCheckVoucherList(ArrayList<CheckVoucher> checkVoucherList) {
        this.checkVoucherList = checkVoucherList;
    }

    /**
     * @return the invoiceList
     */
    public ArrayList<CheckInvoiceList> getInvoiceList() {
        return invoiceList;
    }

    /**
     * @param invoiceList the invoiceList to set
     */
    public void setInvoiceList(ArrayList<CheckInvoiceList> invoiceList) {
        this.invoiceList = invoiceList;
    }

    /**
     * @return the checkNumberList
     */
    public ArrayList<CheckInvoiceList> getCheckNumberList() {
        return checkNumberList;
    }

    /**
     * @param checkNumberList the checkNumberList to set
     */
    public void setCheckNumberList(ArrayList<CheckInvoiceList> checkNumberList) {
        this.checkNumberList = checkNumberList;
    }
    
    public void CheckInvoiceList(){
        checkVoucherList = new ArrayList();
        invoiceList = new ArrayList();
        checkNumberList = new ArrayList();
        checkListModel = new DefaultTableModel();
        invoiceListModel = new DefaultTableModel();
    }

    /**
     * @return the invoiceListModel
     */
    public DefaultTableModel getInvoiceListModel() {
        return invoiceListModel;
    }

    /**
     * @param invoiceListModel the invoiceListModel to set
     */
    public void setInvoiceListModel(DefaultTableModel invoiceListModel) {
        this.invoiceListModel = invoiceListModel;
    }

    /**
     * @return the checkListModel
     */
    public DefaultTableModel getCheckListModel() {
        return checkListModel;
    }

    /**
     * @param checkListModel the checkListModel to set
     */
    public void setCheckListModel(DefaultTableModel checkListModel) {
        this.checkListModel = checkListModel;
    }
}
