package org.itstep.myWebApp.service;

import org.itstep.myWebApp.UserTestData;
import org.itstep.myWebApp.model.User;
import org.itstep.myWebApp.util.NotFoundException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@ContextConfiguration({"classpath:spring.xml","classpath:spring-db.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = "classpath:script.sql")
public class UserServiceTest {

    @Autowired
    private UserService service;

    @Test
    public void getAll() throws Exception {
        List<User> users = service.getAll();
        Assert.assertEquals(3, users.size());
    }

    @Test
    @DirtiesContext
    public void delete() throws Exception {
        int size = service.getAll().size();
        service.delete(1);
        Assert.assertEquals(size-1, service.getAll().size());
    }

    @Test(expected = NotFoundException.class)
    public void deleteNotFound() throws Exception {
        int size = service.getAll().size();
        service.delete(2);
        Assert.assertEquals(size-1, service.getAll().size());
    }

    @Test
    public void save() throws Exception {
        int size = service.getAll().size();
        User user = new User();
        user.setName("1");
        user.setLastname("1");
        user.setCity("1");
        user.setEmail("1@1");
        service.save(user);
        Assert.assertEquals(size+1, service.getAll().size());
    }

    @Test(expected = NotFoundException.class)
    public void updateNotFound() throws Exception {
        service.update(UserTestData.USER_3);
    }

    @Test
    public void getById() throws Exception {
        User user = service.getById(1);
        assert user != null;
    }

}