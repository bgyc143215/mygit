package com.jxd.purchase.servlet;

import com.jxd.purchase.service.IMaterialPurchaseItemService;
import com.jxd.purchase.service.impl.MaterialPurchaseItemServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteItem")
public class DeleteItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ids = req.getParameter("id");
        IMaterialPurchaseItemService mpis = new MaterialPurchaseItemServiceImpl();
        boolean isSuccess = mpis.deleteById(ids);
        if (isSuccess){

        }
    }
}
/**
 * @Author:zhangyuliang
 * @Date:2021/9/16
 */