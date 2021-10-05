package com.jxd.purchase.model;

public class MaterialPurchase {
    private int id ;
    private String applyUser;
    private String applyDate;
    private String purchaseType;
    private double preCost;
    private String purchaseReason;
    private String deptAuti;
    private String companyAuti;

    public String getPurchaseReason() {
        return purchaseReason;
    }

    public MaterialPurchase(String applyUser, String applyDate, String purchaseType, double preCost, String purchaseReason, String deptAuti, String companyAuti) {
        this.applyUser = applyUser;
        this.applyDate = applyDate;
        this.purchaseType = purchaseType;
        this.preCost = preCost;
        this.purchaseReason = purchaseReason;
        this.deptAuti = deptAuti;
        this.companyAuti = companyAuti;
    }

    public MaterialPurchase() {
    }

    public MaterialPurchase(int id, String applyUser, String applyDate, String purchaseType, double preCost, String purchaseReason, String deptAuti, String companyAuti) {
        this.id = id;
        this.applyUser = applyUser;
        this.applyDate = applyDate;
        this.purchaseType = purchaseType;
        this.preCost = preCost;
        this.purchaseReason = purchaseReason;
        this.deptAuti = deptAuti;
        this.companyAuti = companyAuti;
    }

    public void setPurchaseReason(String purchaseReason) {
        this.purchaseReason = purchaseReason;
    }

    public String getPurchaseType() {
        return purchaseType;
    }

    public void setPurchaseType(String purchaseType) {
        this.purchaseType = purchaseType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }

    public double getPreCost() {
        return preCost;
    }

    public void setPreCost(double preCost) {
        this.preCost = preCost;
    }

    public String getDeptAuti() {
        return deptAuti;
    }

    public void setDeptAuti(String deptAuti) {
        this.deptAuti = deptAuti;
    }

    public String getCompanyAuti() {
        return companyAuti;
    }

    public void setCompanyAuti(String companyAuti) {
        this.companyAuti = companyAuti;
    }
}
/**
 * @Author:zhangyuliang
 * @Date:2021/9/15
 */