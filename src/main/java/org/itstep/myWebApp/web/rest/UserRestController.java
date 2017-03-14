package org.itstep.myWebApp.web.rest;

import org.itstep.myWebApp.model.User;
import org.itstep.myWebApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by student on 14.03.2017.
 */

@Controller
@RequestMapping(value = "/rest/users")
public class UserRestController {
    @Autowired
    private UserService service;

    @RequestMapping(method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<User>> getAll(){
        ResponseEntity<List<User>> entity = new ResponseEntity<>(service.getAll(), HttpStatus.OK);
        return entity;
    }

}
