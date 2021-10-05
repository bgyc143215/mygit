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
import java.io.PrintWriter;

@WebServlet("/insertPurchase")
public class InsertServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int idInt = Integer.parseInt(id);
        String applyUser = req.getParameter("applyUser");
        String applyDate = req.getParameter("applyDate");
        String purchaseType = req.getParameter("purchaseType");
        String preCost = req.getParameter("preCost");
        double preCostDouble = Double.parseDouble(preCost);
        String purchaseReason = req.getParameter("purchaseReason");
        String deptAuti = req.getParameter("deptAuti");
        String companyAuti = req.getParameter("companyAuti");
        MaterialPurchase mp = new MaterialPurchase(applyUser,applyDate,purchaseType,preCostDouble,purchaseReason,deptAuti,companyAuti);
        mp.setId(idInt);
        IMaterialPurchaseService mps = new MaterialPurchaseServiceImpl();
        boolean isSuccess = mps.addPurchase(mp);
        resp.setContentType("text/html;charset=utf-8");

        if (isSuccess){
            resp.sendRedirect("purchaseList.jsp");
        }else {
            req.getRequestDispatcher("addPurchase.jsp").forward(req,resp);
        }
    }
}
/**
 * @Author:zhangyuliang
 * @Date:2021/9/16
 */