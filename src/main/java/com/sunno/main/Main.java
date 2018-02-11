package com.sunno.main;

/**
 * Created by SQ_BXZ on 2018-02-10.
 */
public class Main {
    public static void main(String[] args) {
        int test = 1024;
        System.out.println(Integer.toBinaryString(test));
        test = test>>8;
        System.out.println(Integer.toBinaryString(test));
        System.out.println(test);
        test = test<<8;
        System.out.println(Integer.toBinaryString(test));
        System.out.println(test);
    }
}
