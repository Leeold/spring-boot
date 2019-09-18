package com.company.project.designPattern.demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 */
public class SpinLock {
    AtomicReference<Thread> atomicReference = new AtomicReference<>();
    public void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread);
        System.out.println(Thread.currentThread().getName()+"-----come in");
        while (!atomicReference.compareAndSet(null,thread)){

        }
    }
    public void unLock(){
        Thread thread  = Thread.currentThread();
        System.out.println(thread);
        atomicReference.compareAndSet(thread,null);
        System.out.println(Thread.currentThread().getName()+"invoked myUnlock");
    }
    public static void main(String[] args) {
        SpinLock spinLock = new SpinLock();
        new Thread(()->{
            spinLock.myLock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLock.unLock();
        },"AA").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
          spinLock.myLock();
          spinLock.unLock();
        },"BB").start();
    }
}
