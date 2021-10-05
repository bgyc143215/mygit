package com.jxd.purchase.dao;

import com.jxd.purchase.model.MaterialPurchase;
import com.jxd.purchase.model.MaterialPurchaseItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IMaterialPurchaseItemDao {
    List<MaterialPurchaseItem> selectAll(int id);
    List<MaterialPurchaseItem> selectAllByPage(@Param("id") int id,@Param("page") int page,@Param("limit") int limit);
    boolean deleteById(int purchaseId);
    int insertItems(List<MaterialPurchaseItem> list);
    int insertItemsWithId(List<MaterialPurchaseItem> list);
}
