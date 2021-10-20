/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos_project.classes;

import java.util.ArrayList;

/**
 *
 * @author Cifer
 */
public class CheckInvoiceList {
    
    private String name;
    private ArrayList<String []> checkVoucherList;
    private ArrayList<String> subCategoryList;
    private Double invoiceTotalAmount;
    private Double checkTotalAmount;
    
    public CheckInvoiceList() {
        checkVoucherList= new ArrayList();
        subCategoryList = new ArrayList();
        invoiceTotalAmount = 0.0;
        checkTotalAmount = 0.0;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the checkVoucherList
     */
    public ArrayList<String[]> getCheckVoucherList() {
        return checkVoucherList;
    }

    /**
     * @param checkVoucherList the checkVoucherList to set
     */
    public void setCheckVoucherList(ArrayList<String[]> checkVoucherList) {
        this.checkVoucherList = checkVoucherList;
    }
    
    public void addCheckVoucher(String[] checkVoucher) {
        this.checkVoucherList.add(checkVoucher);
    }

    /**
     * @return the subCategoryList
     */
    public ArrayList<String> getSubCategoryList() {
        return subCategoryList;
    }

    /**
     * @param subCategoryList the subCategoryList to set
     */
    public void setSubCategoryList(ArrayList<String> subCategoryList) {
        this.subCategoryList = subCategoryList;
    }
    
    public void addSubCategory(String subCategory) {
        this.subCategoryList.add(subCategory);
    }

    /**
     * @return the invoiceTotalAmount
     */
    public Double getInvoiceTotalAmount() {
        return invoiceTotalAmount;
    }

    /**
     * @param invoiceTotalAmount the invoiceTotalAmount to set
     */
    public void setInvoiceTotalAmount(Double invoiceTotalAmount) {
        this.invoiceTotalAmount = invoiceTotalAmount;
    }

    /**
     * @return the checkTotalAmount
     */
    public Double getCheckTotalAmount() {
        return checkTotalAmount;
    }

    /**
     * @param checkTotalAmount the checkTotalAmount to set
     */
    public void setCheckTotalAmount(Double checkTotalAmount) {
        this.checkTotalAmount = checkTotalAmount;
    }
    
}

