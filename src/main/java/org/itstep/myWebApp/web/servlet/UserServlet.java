package org.itstep.myWebApp.web.servlet;

import org.itstep.myWebApp.model.User;
import org.itstep.myWebApp.service.UserService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserServlet extends HttpServlet {

    private UserService service;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        WebApplicationContext webCtx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        service = webCtx.getBean(UserService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        if (action == null) action = "getAll";

        switch (action) {
            case "create":
                req.setAttribute("user", new User("name", "lastname", "city", "email"));
                req.getRequestDispatcher("editUser.jsp").forward(req, resp);
                break;
            case "delete":
                Integer id = Integer.valueOf(req.getParameter("id"));
                service.delete(id);
                resp.sendRedirect("users");
                break;
            case "update":
                id = Integer.valueOf(req.getParameter("id"));
                User user = service.getById(id);
                req.setAttribute("user", user);
                req.getRequestDispatcher("editUser.jsp").forward(req, resp);
                break;
            case "getAll":
                List<User> users = service.getAll();
                req.setAttribute("userList", users);
                req.getRequestDispatcher("userList.jsp").forward(req, resp);
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        User user = id.isEmpty() ? new User() : service.getById(Integer.valueOf(id));

        user.setName(req.getParameter("name"));
        user.setLastname(req.getParameter("lastname"));
        user.setCity(req.getParameter("city"));
        user.setEmail(req.getParameter("email"));

        service.save(user);

        resp.sendRedirect("users");

    }

}
