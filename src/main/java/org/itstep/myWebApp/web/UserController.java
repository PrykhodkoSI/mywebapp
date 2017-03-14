package org.itstep.myWebApp.web;

import org.itstep.myWebApp.model.User;
import org.itstep.myWebApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.method.annotation.RequestParamMapMethodArgumentResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by student on 13.03.2017.
 */
@Controller
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;

//    @RequestMapping(value = "/users", method= RequestMethod.GET)
//    String getAll(Model model){
//        model.addAttribute("userList",service.getAll());
//        return "userList.jsp";
//    }

    @RequestMapping(method= RequestMethod.GET)
    ModelAndView getAll(){
        return new ModelAndView("userList","userList",service.getAll());
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    ModelAndView update(@RequestParam(value = "id", required = false) Integer id){
        return new ModelAndView( "editUser","user", service.getById(id));
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    String save(@ModelAttribute User user){
        service.save(user);
        return "redirect:/users";
    }
}
