package com.company.project.designPattern;


import com.company.project.model.User;
import com.sun.media.jfxmediaimpl.HostUtils;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


class ShareResource{
    private int number =1;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();
    public void print5(){
        lock.lock();
        try {
            while(number != 1){
                c1.await();
            }

            for (int i=1;i<= 5;i++){
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }

            number =2;
            c2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
    public void print10(){
        lock.lock();
        try {
            while(number != 2){
                c2.await();
            }

            for (int i=1;i<= 10;i++){
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }

            number =3;
            c3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
    public void print15(){
        lock.lock();
        try {
            while(number != 3){
                c3.await();
            }

            for (int i=1;i<= 15;i++){
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }

            number =1;
            c1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

}


public class Demo {
    private static Demo instance = null;
    private Demo(){
        System.out.println(Thread.currentThread().getName()+"我是构造方法");
    }
    public static Demo getInstance(){
        if(instance == null){
            synchronized (Demo.class){
                if(instance ==null){
                    instance = new Demo();
                }
            }
        }
        return instance;
    }
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        StringBuffer s = new StringBuffer();


    }


}
