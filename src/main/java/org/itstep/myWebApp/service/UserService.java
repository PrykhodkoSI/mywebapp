package org.itstep.myWebApp.service;

import org.itstep.myWebApp.model.User;
import org.itstep.myWebApp.repository.UserRepository;
import org.itstep.myWebApp.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> getAll() {
        return repository.getAll();
    }

    public void delete(Integer id) {
        ExceptionUtil.check(repository.getById(id), id);
        repository.delete(id);
    }

    public User save(User user) {
        return repository.save(user);
    }

    public void update(User user) {
        ExceptionUtil.check(repository.getById(user.getId()), user.getId());
        repository.save(user);
    }

    public User getById(Integer id) {
        return ExceptionUtil.check(repository.getById(id), id);
    }
}
