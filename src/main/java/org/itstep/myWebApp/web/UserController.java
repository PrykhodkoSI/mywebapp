package org.itstep.myWebApp.web;

import org.itstep.myWebApp.model.User;
import org.itstep.myWebApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by student on 13.03.2017.
 */
@Controller
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping(value = "/users", method= RequestMethod.GET)
    String getAll(Model model)
    {
        model.addAttribute("userList",service.getAll());
        return "userList.jsp";
    }

    @RequestMapping(value = "/users/update", method = RequestMethod.GET)
    String update(HttpServletRequest request, Model model){
        String id = request.getParameter("id");
        User user = service.getById(Integer.parseInt(id));
        model.addAttribute("user", user);
        return "editUser.jsp";
    }
}
