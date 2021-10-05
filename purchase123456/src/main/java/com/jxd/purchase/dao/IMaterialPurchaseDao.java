package com.jxd.purchase.dao;

import com.jxd.purchase.model.MaterialPurchase;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IMaterialPurchaseDao {
    List<MaterialPurchase> selectAll(@Param("pname") String pname,@Param("type") String type);
    List<MaterialPurchase> selectAllByPage(@Param("pname") String pname,@Param("type") String type,@Param("page") int page,@Param("limit") int limit);
    boolean deleteById(int[] id);
    boolean deleteItemById(int[] id);
    MaterialPurchase selectById(int id);
    boolean updatePurchase(MaterialPurchase mp);
    boolean insertPurchase(MaterialPurchase mp);
    int selectId();
}
