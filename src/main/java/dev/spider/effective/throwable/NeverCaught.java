package dev.spider.effective.throwable;

public class NeverCaught {
    static void f() {
        throw new RuntimeException("from f()");
    }

    static void g() {
        f();
    }

    public static void main(String[] args) {
        g();
        System.out.println("main over");
    }
}
