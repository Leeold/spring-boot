package com.company.project.thread.thread1;

public class T {
    volatile boolean running = true;
    void m (){
        System.out.println("m start");
        while(running){

        }
        System.out.println("m end");
    }

    public static void main(String[] args) {
        T t = new T();
        new Thread(()->t.m(),"t1").start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.running = false;
    }
}
