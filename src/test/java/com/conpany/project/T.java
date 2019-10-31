package com.conpany.project;

import org.junit.Test;

public class T {

    @Test
    public void test(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                test2();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test2();
            }
        }).start();
    }

    public void test2(){
        int b = 2;
        System.out.println(b);
    }
}
