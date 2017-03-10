package org.itstep.myWebApp.service;

import org.itstep.myWebApp.model.User;
import org.itstep.myWebApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;// = new UserRepository();

    public List<User> getAll() {
        return repository.getAll();
    }

    public void delete(Integer id) {
        repository.delete(id);
    }

    public void save(User user) {
        repository.save(user);
    }

    public User getById(Integer id) {
        return repository.getById(id);
    }
}
