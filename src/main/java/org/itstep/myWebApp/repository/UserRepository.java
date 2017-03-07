package org.itstep.myWebApp.repository;

import org.itstep.myWebApp.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class UserRepository {

    private Map<Integer, User> users = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(1);

    {
        add(new User("nick", "dalls", "dnipro", "user@gmail.com"));
        add(new User("angela", "hike", "kyiv", "ang@yahoo.com"));
    }

    public List<User> getAll() {
        return new ArrayList<>(users.values());
    }

    public void delete(Integer id) {
        users.remove(id);
    }

    public void add(User user) {
        if (user.getId() == null) {
            user.setId(counter.getAndIncrement());
        }

        users.put(user.getId(), user);
    }

    public User getById(int id) {
        try {
            return users.get(id);
        } catch (NullPointerException e) {
            return null;
        }
    }
}
