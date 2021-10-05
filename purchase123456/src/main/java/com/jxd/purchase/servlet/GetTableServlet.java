package com.jxd.purchase.servlet;

import com.jxd.purchase.service.IMaterialPurchaseItemService;
import com.jxd.purchase.service.impl.MaterialPurchaseItemServiceImpl;
import net.sf.json.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/gettable")
public class GetTableServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String purchaseId = req.getParameter("purchaseId");
        String calcUnit = req.getParameter("calcUnit");
        String materialName = req.getParameter("materialName");
        String purchaseNumber = req.getParameter("purchaseNumber");
        String remark = req.getParameter("remark");
        String uintPrice = req.getParameter("uintPrice");
        IMaterialPurchaseItemService mpis = new MaterialPurchaseItemServiceImpl();
        boolean isSuccess = mpis.deleteById(purchaseId);
        double num = mpis.addItem(id,purchaseId,calcUnit,materialName,purchaseNumber,remark,uintPrice);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.print(num);
    }
}
/**
 * @Author:zhangyuliang
 * @Date:2021/9/17
 */