package com.jxd.mybatis.dao;

import com.jxd.mybatis.model.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IEmployeeDao {
    List<Emp> selectEmp(@Param("ename") String ename);
    List<Emp> selectEmpByjob(@Param("job") String job);
    List<Emp> selectEmpByJobandEname(@Param("job") String job,@Param("ename") String ename);
    int  deleteByEmpno(int[] empnos);
}
