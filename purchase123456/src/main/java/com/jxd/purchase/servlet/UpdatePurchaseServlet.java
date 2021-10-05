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

@WebServlet("/updatePurchase")
public class UpdatePurchaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
        MaterialPurchase mp = new MaterialPurchase(idInt,applyUser,applyDate,purchaseType,preCostDouble,purchaseReason,deptAuti,companyAuti);
        IMaterialPurchaseService mps = new MaterialPurchaseServiceImpl();
        boolean isSuccess = mps.updatePurchase(mp);
        if (isSuccess){
            resp.sendRedirect("purchaseList.jsp");
        }
    }
}
/**
 * @Author:zhangyuliang
 * @Date:2021/9/16
 */