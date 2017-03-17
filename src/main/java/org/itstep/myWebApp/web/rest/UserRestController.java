package org.itstep.myWebApp.web.rest;

import org.itstep.myWebApp.model.User;
import org.itstep.myWebApp.service.UserService;
import org.itstep.myWebApp.util.ErrorInfo;
import org.itstep.myWebApp.util.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/rest/users")
public class UserRestController {

    @Autowired
    private UserService service;

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    @ResponseBody ErrorInfo handle(HttpServletRequest request, Exception exception){
        return new ErrorInfo(request.getRequestURL().toString(), exception.getMessage());
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAll() {
        return service.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public User getbyId(@PathVariable(value = "id") Integer id) {
        return service.getById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") Integer id) {
        service.delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@PathVariable Integer id, @RequestBody User user) {
        user.setId(id);
        service.save(user);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    private void create(@RequestBody User user) {
        service.save(user);
    }

}
