package com.jxd.purchase.servlet;

import com.jxd.purchase.service.IMaterialPurchaseService;
import com.jxd.purchase.service.impl.MaterialPurchaseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ids = req.getParameter("id");
        IMaterialPurchaseService materialPurchaseService = new MaterialPurchaseServiceImpl();
        boolean isSuccess = materialPurchaseService.deleteById(ids);
        if (isSuccess){
            resp.sendRedirect("purchaseList.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
/**
 * @Author:zhangyuliang
 * @Date:2021/9/16
 */