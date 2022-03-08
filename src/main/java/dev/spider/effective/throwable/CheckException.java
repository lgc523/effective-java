package dev.spider.effective.throwable;


import java.io.IOException;

public class CheckException {

    public static void main(String[] args) {
        throw0(new IOException());
    }

    static void throw0(Exception e) {
        CheckException.throw1(e);
    }

    @SuppressWarnings("unchecked")
    static <E extends Exception> void throw1(Exception e) throws E {
        throw (E) e;
    }
}
