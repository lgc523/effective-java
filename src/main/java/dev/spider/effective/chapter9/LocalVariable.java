package dev.spider.effective.chapter9;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

//57-局部变量作用域最小化
public class LocalVariable {

    //while 容易忽略无意义的变量
    static void loopVariable() {
        List<String> spider = Arrays.asList("spider", "2022-3-1 0:45:00");
        Iterator<String> i0 = spider.iterator();
        while (i0.hasNext()) {
            //..
        }
        Iterator<String> i1 = spider.iterator();
        //while (i1.hasNext()){
        //cv 容易出错
        while (i0.hasNext()) {
            //..
        }

        //变量有效范围在生命的语句块内
        for (Iterator<String> i2 = spider.listIterator(); i2.hasNext(); ) {

        }
        //compile error
        /*
                for (Iterator<String> i3 = spider.listIterator(); i2.hasNext(); ) {
        }
         */

    }
}
/*
 * 1.表达式延迟初始化，try-catch
 * 2.for 循环优先于 while
 */
