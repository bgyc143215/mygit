package com.jxd.purchase.service.impl;

import com.jxd.purchase.dao.IMaterialPurchaseItemDao;
import com.jxd.purchase.model.MaterialPurchaseItem;
import com.jxd.purchase.service.IMaterialPurchaseItemService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MaterialPurchaseItemServiceImpl implements IMaterialPurchaseItemService {
    IMaterialPurchaseItemDao materialPurchaseItemDao;
    @Override
    public List<MaterialPurchaseItem> getAll(String id) {
        SqlSession ss = getSession();
        materialPurchaseItemDao = ss.getMapper(IMaterialPurchaseItemDao.class);
        int idInt = Integer.parseInt(id);
        return materialPurchaseItemDao.selectAll(idInt);
    }

    @Override
    public List<MaterialPurchaseItem> getAllByPage(String id, String page, String limit) {
        SqlSession ss = getSession();
        materialPurchaseItemDao = ss.getMapper(IMaterialPurchaseItemDao.class);
        int idInt = Integer.parseInt(id);
        int pageInt = Integer.parseInt(page);
        int limitInt = Integer.parseInt(limit);
        pageInt = (pageInt-1)*limitInt;
        return materialPurchaseItemDao.selectAllByPage(idInt,pageInt,limitInt);
    }

    @Override
    public boolean deleteById(String purchaseId) {
        SqlSession ss = getSession();
        materialPurchaseItemDao = ss.getMapper(IMaterialPurchaseItemDao.class);
        String[] purchaseIdStr = purchaseId.split(",");
        int purchaseIdInt = Integer.parseInt(purchaseIdStr[0]);
        return materialPurchaseItemDao.deleteById(purchaseIdInt);
    }

    @Override
    public double addItem(String id, String purchaseId, String calcUnit, String materialName, String purchaseNumber, String remark, String uintPrice) {
        SqlSession ss = getSession();
        materialPurchaseItemDao = ss.getMapper(IMaterialPurchaseItemDao.class);
        String[] idStr = id.split(",");
        int[] idInt = new int[idStr.length];
        String[] purchaseIdStr = purchaseId.split(",");
        int[] purchaseIdInt = new int[purchaseIdStr.length];
        String[] calcUnitStr = calcUnit.split(",");
        String[] materialNameStr = materialName.split(",");
        String[] remarkStr = remark.split(",");
        String[] uintPriceStr = uintPrice.split(",");
        double[] uintPriceDouble = new double[uintPriceStr.length];
        String[] purchaseNumberStr = purchaseNumber.split(",");
        int[] purchaseNumberInt = new int[purchaseNumberStr.length];
        List<MaterialPurchaseItem> list1 = new ArrayList<>();
        List<MaterialPurchaseItem> list2 = new ArrayList<>();
        double sum=0;
        for (int i = 0; i <idStr.length ; i++) {
            idInt[i] = Integer.parseInt(idStr[i]);
            purchaseIdInt[i] = Integer.parseInt(purchaseIdStr[i]);
            purchaseNumberInt[i] = Integer.parseInt(purchaseNumberStr[i]);
            uintPriceDouble[i] = Double.parseDouble(uintPriceStr[i]);
            sum += purchaseNumberInt[i]*uintPriceDouble[i];
            MaterialPurchaseItem mpi = new MaterialPurchaseItem(idInt[i],purchaseIdInt[i],materialNameStr[i],calcUnitStr[i],uintPriceDouble[i],purchaseNumberInt[i],remarkStr[i]);
            if (idInt[i]==0) {
                list1.add(mpi);
            }else {
                list2.add(mpi);
            }
        }
        int num = 0;
        int num1 = 0;
        if (list1.size()>0) {
            num = materialPurchaseItemDao.insertItems(list1);
        }
        if (list2.size()>0) {
            num1 = materialPurchaseItemDao.insertItemsWithId(list2);
        }
        if (num+num1>0) {
            return sum;
        }else {
            return 0;
        }
    }

    public SqlSession getSession(){
        SqlSession ss = null;
        try {
            //01-加载主配置文件
            InputStream config = Resources.getResourceAsStream("config.xml");
            //02-根据参数信息创建连接池，也就是SqlSessionFactory
            SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(config);
            //03.获取会话对象，也就是连接对象
            //true代表自动提交
            ss = sf.openSession(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ss;
    }
}
/**
 * @Author:zhangyuliang
 * @Date:2021/9/15
 */