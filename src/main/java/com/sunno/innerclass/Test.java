package com.sunno.innerclass;

/**
 * Created by SQ_BXZ on 2018-02-11.
 */
public class Test {

    public void test(Bird bird){
        System.out.println(bird.getName()+","+bird.fly());
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.test(new Bird() {
            @Override
            public int fly() {
                return 10000;
            }
            public String getName(){
                return "鹌鹑";
            }
        });
    }

}
