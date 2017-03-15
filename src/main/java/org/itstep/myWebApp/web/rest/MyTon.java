package org.itstep.myWebApp.web.rest;

/**
 * Created by student on 15.03.2017.
 */
public class MyTon {
    private static MyTon ourInstance = new MyTon();

    public static MyTon getInstance() {
        return ourInstance;
    }

    private MyTon() {
    }
}
