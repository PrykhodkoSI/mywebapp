package org.itstep.myWebApp;

import org.itstep.myWebApp.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class SpringExample {

    public static void main(String[] args) {

        try (ClassPathXmlApplicationContext appCtx = new ClassPathXmlApplicationContext("spring.xml")) {
            System.out.println(Arrays.toString(appCtx.getBeanDefinitionNames()));

            UserService service = appCtx.getBean(UserService.class);
            System.out.println(service.getAll());
        }

    }
}
