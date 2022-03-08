package dev.spider.effective.conditionexpression;

public class ConditionExpression {
    public static void main(String[] args) {

        Object obj0 = true ? new Integer(1) : new Double(2.0);
        Object obj1;
        if (true)
            obj1 = new Integer(1);
        else
            obj1 = new Double(2.0);

        System.out.println(obj0);//1.0
        System.out.println(obj1);//1

        Integer i = new Integer(1);
        if (i.equals(1))
            i = null;
        Double d = new Double(2.0);
        Object o = true ? i : d;
        System.out.println(o);
    }
}
