package com.jxd.mybatis.service.impl;

import com.jxd.mybatis.model.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IEmployeeService {
    List<Emp> selectEmp( String ename);
    List<Emp> selectEmpByjob(String job);
    List<Emp> selectEmpByJobandEname(String job,String ename);
    int  deleteByEmpno(int[] empnos);
}
