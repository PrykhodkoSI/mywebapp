package org.itstep.myWebApp.service;


import org.itstep.myWebApp.model.Mail;
import org.itstep.myWebApp.model.User;
import org.itstep.myWebApp.repository.MailRepository;
import org.itstep.myWebApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class MailService {

    @Autowired
    private MailRepository repository;


    public List<Mail> getAll(Integer userId) {
        return repository.getAll(userId);
    }

    public void delete(Integer userId) {
        repository.delete(userId);
    }

}
