package com.jxd.mybatis.dao;

/**
 * @Author:qixiaokun
 * @DAte:2021/9/14
 */

import com.jxd.mybatis.model.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Scanner;

public interface IEmpDao {
    List<Emp> selectAll(@Param("pageStart") int pageStart,@Param("pageLimit") int pageLimit);
    boolean insertEmp(Emp emp);
    List<Emp> selectByEname(String ename);
    //两个或多个参数，mybatis封装的key值是param1,param2或arg0,arg1
    //通过Param注解去指定参数的key值
    List<Emp> selectByEnameAndJob(@Param("ename") String ename, @Param("job") String job);
    List<Emp> selectByOrder(String colName);
}
