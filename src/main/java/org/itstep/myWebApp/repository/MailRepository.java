package org.itstep.myWebApp.repository;

import org.itstep.myWebApp.model.Mail;
import org.itstep.myWebApp.model.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class MailRepository {

    private Map<Integer, Map<Integer, Mail>> mails = new ConcurrentHashMap<>();

    private AtomicInteger counter = new AtomicInteger(1);

    {
        save(new Mail(counter.getAndIncrement(),"Stas","Hello Stas!","Vlad", LocalDateTime.now(),1));
        save(new Mail(counter.getAndIncrement(),"Vlad","Hello Vlad!","Yurij", LocalDateTime.now(),2));
        save(new Mail(counter.getAndIncrement(),"Yurij","Hello Yurij!","Roman", LocalDateTime.now(),3));
        save(new Mail(counter.getAndIncrement(),"Roman","Hello Roman!","Julia", LocalDateTime.now(),4));
        save(new Mail(counter.getAndIncrement(),"Julia","Hello Julia!","Kolia", LocalDateTime.now(),5));
        save(new Mail(counter.getAndIncrement(),"Kolia","Hello Kolia!","Stas", LocalDateTime.now(),6));
    }

    public List<Mail> getAll(Integer userId){
        Map<Integer, Mail> mailMap = mails.get(userId);
        System.out.println(mailMap);
        return new ArrayList<Mail>(mailMap.values());
    }

    public void delete(Integer userId) {
        mails.remove(userId);
    }

    public void save(Mail mail) {
        Map<Integer, Mail> map = mails.computeIfAbsent(mail.getUserId(), ConcurrentHashMap<Integer, Mail>::new);
        map.put(mail.getId(),mail);
    }

}
