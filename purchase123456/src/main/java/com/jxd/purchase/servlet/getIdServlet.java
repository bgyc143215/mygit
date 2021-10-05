package com.jxd.purchase.servlet;

import com.jxd.purchase.service.IMaterialPurchaseItemService;
import com.jxd.purchase.service.IMaterialPurchaseService;
import com.jxd.purchase.service.impl.MaterialPurchaseItemServiceImpl;
import com.jxd.purchase.service.impl.MaterialPurchaseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getId")
public class getIdServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IMaterialPurchaseService mps = new MaterialPurchaseServiceImpl();
        int id = mps.selectId();
        req.setAttribute("id",id);
        req.getRequestDispatcher("addPurchase.jsp").forward(req,resp);
    }
}
/**
 * @Author:zhangyuliang
 * @Date:2021/9/16
 */