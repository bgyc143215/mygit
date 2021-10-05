package com.jxd.mybatis.test;

/**
 * @Author:qixiaokun
 * @DAte:2021/9/14
 */

import com.jxd.mybatis.model.Emp;
import com.jxd.mybatis.service.IEmpService;
import com.jxd.mybatis.service.impl.EmpServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        IEmpService empService = new EmpServiceImpl();
//        List<Emp> list = empService.getAll();
//        for(Emp emp:list){
//            System.out.println(emp.getEname());
//        }

//        Emp emp = new Emp();
//        emp.setEname("liming");
//        emp.setJob("coder");
//        emp.setHiredate("2021-09-14");
//        boolean flag = empService.addEmp(emp);
//        if(flag){
//            System.out.println("新增成功");
//        }
        //mybatis会将传递过来的实参封装为一个key-value键值对
        //value值就是我们要传递的实参，key值为param后者param1
        //mybatis
        List<Emp> list = empService.getByEname("刘");
        System.out.println(list.get(0).getEname()+" "+list.get(0).getJob());
//        List<Emp> list = empService.selectByEnameAndJob("liming","coder");
//        System.out.println(list.get(0).getEname()+" "+list.get(0).getJob());
    }
}
