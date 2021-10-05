package com.jxd.purchase.model;

public class MaterialPurchaseItem {
    private int id;
    private int purchaseId;
    private String materialName;
    private String calcUnit;
    private double uintPrice;
    private int purchaseNumber;
    private String remark;

    public MaterialPurchaseItem() {
    }

    public MaterialPurchaseItem(int id, int purchaseId, String materialName, String calcUnit, double uintPrice, int purchaseNumber, String remark) {
        this.id = id;
        this.purchaseId = purchaseId;
        this.materialName = materialName;
        this.calcUnit = calcUnit;
        this.uintPrice = uintPrice;
        this.purchaseNumber = purchaseNumber;
        this.remark = remark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getCalcUnit() {
        return calcUnit;
    }

    public void setCalcUnit(String calcUnit) {
        this.calcUnit = calcUnit;
    }

    public double getUintPrice() {
        return uintPrice;
    }

    public void setUintPrice(double uintPrice) {
        this.uintPrice = uintPrice;
    }

    public int getPurchaseNumber() {
        return purchaseNumber;
    }

    public void setPurchaseNumber(int purchaseNumber) {
        this.purchaseNumber = purchaseNumber;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
/**
 * @Author:zhangyuliang
 * @Date:2021/9/15
 */