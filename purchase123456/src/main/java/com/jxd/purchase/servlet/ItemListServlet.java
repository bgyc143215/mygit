package com.jxd.purchase.servlet;

import com.jxd.purchase.model.MaterialPurchaseItem;
import com.jxd.purchase.service.IMaterialPurchaseItemService;
import com.jxd.purchase.service.impl.MaterialPurchaseItemServiceImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/itemList")
public class ItemListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page = req.getParameter("page");
        String limit = req.getParameter("limit");
        String id = req.getParameter("id");
        if (id == null){
            id = "0";
        }
        IMaterialPurchaseItemService materialPurchaseItemService = new MaterialPurchaseItemServiceImpl();
        List<MaterialPurchaseItem> list = materialPurchaseItemService.getAll(id);
        List<MaterialPurchaseItem> listPage = materialPurchaseItemService.getAllByPage(id,page,limit);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        JSONArray jsonArray = JSONArray.fromObject(listPage);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("msg","");
        jsonObject.put("count",list.size());//全部的数据条数
        jsonObject.put("data",jsonArray);//当前页的数据
        //将数据响应回前台
        out.print(jsonObject.toString());
        out.flush();
        out.close();
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