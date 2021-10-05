package com.jxd.mybatis.service.impl;

/**
 * @Author:qixiaokun
 * @DAte:2021/9/14
 */

import com.jxd.mybatis.dao.IEmpDao;
import com.jxd.mybatis.model.Emp;
import com.jxd.mybatis.service.IEmpService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class EmpServiceImpl implements IEmpService {
    private IEmpDao empDao;
    @Override
    public List<Emp> getAll(String page,String limit) {
        //获取会话对象
        SqlSession ss = getSession();
        //获取dao层代理对象
        empDao = ss.getMapper(IEmpDao.class);
        int pageInt = Integer.parseInt(page);
        int limitInt = Integer.parseInt(limit);
        return empDao.selectAll(pageInt,limitInt);
    }

    @Override
    public boolean addEmp(Emp emp) {
        SqlSession ss = getSession();
        empDao = ss.getMapper(IEmpDao.class);
        return empDao.insertEmp(emp);
    }

    @Override
    public List<Emp> getByEname(String ename) {
        SqlSession ss = getSession();
        empDao = ss.getMapper(IEmpDao.class);
        return empDao.selectByEname(ename);
    }

    @Override
    public List<Emp> selectByEnameAndJob(String ename, String job) {
        SqlSession ss = getSession();
        empDao = ss.getMapper(IEmpDao.class);
        return empDao.selectByEnameAndJob(ename,job);
    }

    //获取会话对象
    public SqlSession getSession(){
        SqlSession ss = null;
        //1加载主配置文件
        try {
            InputStream  config = Resources.getResourceAsStream("config.xml");
            //2根据参数信息创建连接池，即SqlSessionFactory
            SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(config);
            //3 获取会话对象
            ss = sf.openSession(true);//true自动提交
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ss;
    }
}
