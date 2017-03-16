package org.itstep.myWebApp.web.servlet;

import org.itstep.myWebApp.service.MailService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/mail")
public class MailServlet extends HttpServlet {

    private MailService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("/my.html").forward(req,resp);
        resp.sendRedirect("my.html");
    }
}
