package com.jxd.purchase.service;

import com.jxd.purchase.model.MaterialPurchaseItem;

import java.util.List;

public interface IMaterialPurchaseItemService {
    List<MaterialPurchaseItem> getAll(String id);
    List<MaterialPurchaseItem> getAllByPage(String id,String page,String limit);
    boolean deleteById(String id);
    double addItem(String id,String purchaseId,String calcUnit,String materialName,String purchaseNumber,String remark,String uintPrice);
}
