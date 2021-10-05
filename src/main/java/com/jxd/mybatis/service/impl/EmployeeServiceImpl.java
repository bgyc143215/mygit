package com.jxd.mybatis.service.impl;

/**
 * @Author:qixiaokun
 * @DAte:2021/9/15
 */

import com.jxd.mybatis.dao.IEmployeeDao;
import com.jxd.mybatis.model.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements IEmployeeService {
    private IEmployeeDao employeeDao;
    @Override
    public List<Emp> selectEmp(String ename) {
        SqlSession ss = getSession();
        employeeDao = ss.getMapper(IEmployeeDao.class);
        return employeeDao.selectEmp(ename);
    }

    @Override
    public List<Emp> selectEmpByjob(String job) {
        SqlSession ss = getSession();
        employeeDao = ss.getMapper(IEmployeeDao.class);
        return employeeDao.selectEmpByjob(job);
    }

    @Override
    public List<Emp> selectEmpByJobandEname(String job, String ename) {
        SqlSession ss = getSession();
        employeeDao = ss.getMapper(IEmployeeDao.class);
        return employeeDao.selectEmpByJobandEname(job,ename);
    }

    @Override
    public int deleteByEmpno(int[] empnos) {
        SqlSession ss = getSession();
        employeeDao = ss.getMapper(IEmployeeDao.class);
        return employeeDao.deleteByEmpno(empnos);
    }

    public SqlSession getSession() {
        SqlSession ss = null;
        //1加载主配置文件
        try {
            InputStream config = Resources.getResourceAsStream("config.xml");
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
