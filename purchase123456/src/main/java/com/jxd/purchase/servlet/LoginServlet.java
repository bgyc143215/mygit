package com.jxd.purchase.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sno = req.getParameter("sno");
        String pwd = req.getParameter("pwd");
        PrintWriter out = resp.getWriter();
        if ("123456".equals(pwd)){
            HttpSession session = req.getSession();
            session.setAttribute("name",sno);
            out.print("true");
        }else {
            out.print("false");
        }
    }
}
/**
 * @Author:zhangyuliang
 * @Date:2021/9/15
 */