package com.jxd.mybatis.test;

/**
 * @Author:qixiaokun
 * @DAte:2021/9/15
 */

import com.jxd.mybatis.model.Emp;
import com.jxd.mybatis.service.impl.EmployeeServiceImpl;
import com.jxd.mybatis.service.impl.IEmployeeService;

import java.util.List;
import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        IEmployeeService employeeService = new EmployeeServiceImpl();
//        List<Emp> list = employeeService.selectEmp("刘");
//        System.out.println(list.size());
//        List<Emp> list = employeeService.selectEmpByjob("锦衣");
//        System.out.println(list.size());
//        List<Emp> list = employeeService.selectEmpByJobandEname("锦衣","马");
//        System.out.println(list.size());
        int[] empnos = {12,15};
        int num = employeeService.deleteByEmpno(empnos);
        System.out.println("删除了"+num+"条数据");
    }
}
