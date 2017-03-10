package org.itstep.myWebApp.web;

import org.itstep.myWebApp.model.Mail;
import org.itstep.myWebApp.model.User;
import org.itstep.myWebApp.service.MailService;
import org.itstep.myWebApp.service.UserService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/mail")
public class MailServlet extends HttpServlet {

    private MailService service;// = new UserService();

    private WebApplicationContext context;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        service = context.getBean(MailService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String userId = req.getParameter("userId");
            if (userId != null) {
                int id = Integer.parseInt(userId);
                List<Mail> mails = service.getAll(id);
                req.setAttribute("mailList", mails);
                req.getRequestDispatcher("mailList.jsp").forward(req, resp);
            }
//        String action = req.getParameter("action");
//        if (action == null) action = "getAll";
//
//        switch (action) {
//            case "create":
//                req.setAttribute("user", new User("name", "lastname", "city", "email"));
//                req.getRequestDispatcher("editUser.jsp").forward(req, resp);
//                break;
//            case "delete":
//                Integer id = Integer.valueOf(req.getParameter("id"));
//                service.delete(id);
//                resp.sendRedirect("users");
//                break;
//            case "update":
//                id = Integer.valueOf(req.getParameter("id"));
//                User user = service.getById(id);
//                req.setAttribute("user", user);
//                req.getRequestDispatcher("editUser.jsp").forward(req, resp);
//                break;
//            case "getAll":
//                List<User> users = service.getAll();
//                req.setAttribute("userList", users);
//                req.getRequestDispatcher("userList.jsp").forward(req, resp);
//                break;
//        }
        }
        catch (Exception e){
            //TODO
        }
//
    }
}
