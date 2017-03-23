package org.itstep.myWebApp.repository.jpa;

import org.itstep.myWebApp.model.User;
import org.itstep.myWebApp.repository.IUserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

/**
 * Created by student on 22.03.2017.
 */
@Repository
@Transactional
public class JpaUserRepository implements IUserRepository {

    @PersistenceContext
    EntityManager manager;

    @Transactional
    @Override
    public List<User> getAll() {
            TypedQuery<User> query = manager.createNamedQuery("Users.getAll", User.class);
            return query.getResultList();
    }

    @Transactional
    @Override
    public boolean delete(Integer id) {
            User reference = manager.getReference(User.class, id);
            if(reference == null)
                return false;
            manager.remove(reference);
            return true;
    }

    @Transactional
    @Override
    public User save(User user) {
            if (user.getId() == null) {
                manager.persist(user);
            } else {
                user = manager.merge(user);
            }
            return user;
    }

    @Transactional
    @Override
    public User getById(Integer id) {
        try {
            return manager.find(User.class, id);
        }
        catch (Exception e){
            return null;
        }
    }
}
