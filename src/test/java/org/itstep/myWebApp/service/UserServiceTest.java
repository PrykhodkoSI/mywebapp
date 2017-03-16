package org.itstep.myWebApp.service;

import org.itstep.myWebApp.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.swing.*;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by student on 16.03.2017.
 */

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class UserServiceTest {

    @Autowired
    UserService service;

    @Test
    public void getAll() throws Exception {
        List<User> users = service.getAll();
        assert(users != null);
    }

    @Test
    public void delete() throws Exception {
        service.delete(2);
    }

    @Test
    public void save() throws Exception {
        service.save(new User("Stas","Prykhodko","Dnepr","prykhodko.s.i@gmail.com"));
    }

    @Test
    public void getById() throws Exception {
        User user = service.getById(1);
        assert(user != null);
    }

}