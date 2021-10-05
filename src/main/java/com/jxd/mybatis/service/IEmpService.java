package com.jxd.mybatis.service;

import com.jxd.mybatis.model.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IEmpService {
    List<Emp> getAll(String page,String limit);
    boolean addEmp(Emp emp);
    List<Emp> getByEname(String ename);
    List<Emp> selectByEnameAndJob(String ename, String job);

}
