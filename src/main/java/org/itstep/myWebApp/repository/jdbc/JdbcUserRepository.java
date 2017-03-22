package org.itstep.myWebApp.repository.jdbc;

import org.itstep.myWebApp.model.User;
import org.itstep.myWebApp.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by student on 21.03.2017.
 */
@Repository
public class JdbcUserRepository implements IUserRepository {

    static final BeanPropertyRowMapper<User> mapper = BeanPropertyRowMapper.newInstance(User.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> getAll() {
        return jdbcTemplate.query("SELECT * from Users", mapper);
    }

    @Override
    public boolean delete(Integer id) {
            int update = jdbcTemplate.update("DELETE FROM Users WHERE Users.Id=?;", id);
            return update > 0 ? true : false;

    }

    @Override
    public User save(User user) {
        if(user.getId() == null){
        int update = jdbcTemplate.update("INSERT INTO Users (Name, LastName, City, Email) VALUES(?, ?, ?, ?)",
                user.getName(),
                user.getLastname(),
                user.getCity(),
                user.getEmail());
        if (update == 0)
            return null;
        return user;
        }
        else{
            User user1 = getById(user.getId());
            if(user1 != null){
                user.setId(user1.getId());
                delete(user1.getId());
                int update = jdbcTemplate.update("SET IDENTITY_INSERT Users ON; INSERT INTO Users (Id, Name, LastName, City, Email) VALUES(?, ?, ?, ?, ?); SET IDENTITY_INSERT Users OFF;",
                        user.getId(),
                        user.getName(),
                        user.getLastname(),
                        user.getCity(),
                        user.getEmail());
                if (update == 0)
                    return null;
            }
            return user;
        }

    }

    @Override
    public User getById(Integer id) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM Users WHERE Users.Id=?", mapper, id);
        }
        catch (Exception e)
        {
            return null;
        }
    }
}
