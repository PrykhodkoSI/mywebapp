package org.itstep.myWebApp.repository;

import org.itstep.myWebApp.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UserRepository {

    private Map<Integer, User> users = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(1);

    {
        save(new User("nick", "dalls", "dnipro", "user@gmail.com"));
        save(new User("angela", "hike", "kyiv", "ang@yahoo.com"));
    }

    public List<User> getAll() {
        return new ArrayList<>(users.values());
    }

    public void delete(Integer id) {
        users.remove(id);
    }

    public void save(User user) {
        if (user.getId() == null) {
            user.setId(counter.getAndIncrement());
        }

        users.put(user.getId(), user);
    }

    public User getById(Integer id) {
        return users.get(id);
    }
}
