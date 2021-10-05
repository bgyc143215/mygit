package com.jxd.purchase.service.impl;

import com.jxd.purchase.dao.IMaterialPurchaseDao;
import com.jxd.purchase.model.MaterialPurchase;
import com.jxd.purchase.service.IMaterialPurchaseService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MaterialPurchaseServiceImpl implements IMaterialPurchaseService {
    IMaterialPurchaseDao materialPurchaseDao;
    @Override
    public List<MaterialPurchase> getPurchase(String pname,String type) {
        SqlSession ss = getSession();
        materialPurchaseDao = ss.getMapper(IMaterialPurchaseDao.class);
        return materialPurchaseDao.selectAll(pname,type);
    }

    @Override
    public List<MaterialPurchase> getPurchaseByPage(String pname,String type, String page, String limit) {
        SqlSession ss = getSession();
        materialPurchaseDao = ss.getMapper(IMaterialPurchaseDao.class);
        int pageInt = Integer.parseInt(page);
        int limitInt = Integer.parseInt(limit);
        pageInt = (pageInt-1)*limitInt;
        return materialPurchaseDao.selectAllByPage(pname,type,pageInt,limitInt);
    }

    @Override
    public boolean deleteById(String id) {
        SqlSession ss = null;
        InputStream config = null;
        try {
            config = Resources.getResourceAsStream("config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //02-根据参数信息创建连接池，也就是SqlSessionFactory
        SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(config);
        //03.获取会话对象，也就是连接对象
        //true代表自动提交
        ss = sf.openSession(false);
        materialPurchaseDao = ss.getMapper(IMaterialPurchaseDao.class);
        String[] idStr = id.split(",");
        int[] idInt = new int[idStr.length];
        for (int i = 0; i <idStr.length ; i++) {
            idInt[i] = Integer.parseInt(idStr[i]);
        }
        boolean flag = materialPurchaseDao.deleteItemById(idInt);
        boolean flag1 = materialPurchaseDao.deleteById(idInt);
        boolean isSuccess = false;
        if (flag&&flag1){
            ss.commit();
            isSuccess = true;
        }else {
            ss.rollback();
        }
        return isSuccess;
    }

    @Override
    public MaterialPurchase getPurchaseById(String id) {
        SqlSession ss = getSession();
        materialPurchaseDao = ss.getMapper(IMaterialPurchaseDao.class);
        int idInt = Integer.parseInt(id);
        return materialPurchaseDao.selectById(idInt);
    }

    @Override
    public boolean updatePurchase(MaterialPurchase mp) {
        SqlSession ss = getSession();
        materialPurchaseDao = ss.getMapper(IMaterialPurchaseDao.class);
        return materialPurchaseDao.updatePurchase(mp);
    }

    @Override
    public boolean addPurchase(MaterialPurchase mp) {
        SqlSession ss = getSession();
        materialPurchaseDao = ss.getMapper(IMaterialPurchaseDao.class);
        return materialPurchaseDao.insertPurchase(mp);
    }

    @Override
    public int selectId() {
        SqlSession ss = getSession();
        materialPurchaseDao = ss.getMapper(IMaterialPurchaseDao.class);
        return materialPurchaseDao.selectId()+1;
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