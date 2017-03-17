package org.itstep.myWebApp.util;

public class ExceptionUtil {

    private ExceptionUtil() {
    }

    public static <T> T check(T entity, Integer id) {
        if(entity == null) {
            throw new NotFoundException("Not found entity with id = " + id);
        }
        return entity;
    }

    public static void check(boolean b, Integer id) {
        if (!b) {
            throw new NotFoundException("Not found entity with id = " + id);
        }
    }

}
