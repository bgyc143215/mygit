package com.jxd.purchase.service;

import com.jxd.purchase.model.MaterialPurchase;

import java.util.List;

public interface IMaterialPurchaseService {
    List<MaterialPurchase> getPurchase(String pname,String type);
    List<MaterialPurchase> getPurchaseByPage(String pname,String type,String page,String limit);
    boolean deleteById(String id);
    MaterialPurchase getPurchaseById(String id);
    boolean updatePurchase(MaterialPurchase mp);
    boolean addPurchase(MaterialPurchase mp);
    int selectId();
}
