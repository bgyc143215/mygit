package com.jxd.purchase.servlet;

import com.jxd.purchase.model.MaterialPurchase;
import com.jxd.purchase.service.IMaterialPurchaseService;
import com.jxd.purchase.service.impl.MaterialPurchaseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getPurchaseById")
public class GetPurchaseByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        IMaterialPurchaseService materialPurchaseService = new MaterialPurchaseServiceImpl();
        MaterialPurchase materialPurchase = materialPurchaseService.getPurchaseById(id);
        req.setAttribute("purchase",materialPurchase);
        req.getRequestDispatcher("updatePurchase.jsp").forward(req,resp);
    }
}
/**
 * @Author:zhangyuliang
 * @Date:2021/9/16
 */