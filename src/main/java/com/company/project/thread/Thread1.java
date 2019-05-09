package com.company.project.thread;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Thread1<T> {

    final private LinkedList<T> lists = new LinkedList<>();
    final private int MAX = 10;
    private int count = 0;

    private Lock lock = new ReentrantLock();
    private Condition producer = lock.newCondition();
    private Condition consume = lock.newCondition();

    public void put(T t){
        try {
            lock.lock();
            while (lists.size() == MAX){
                producer.await();
            }
            lists.add(t);
            ++count;
            consume.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public T get(){
        T t = null;
        try {
            lock.lock();
            while (lists.size() == 0){
                consume.await();
            }
            t = lists.removeFirst();
            count--;
            System.out.println("消费掉了"+t);
            producer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return t;
    }

    public static void main(String[] args) {
        Thread1<String> c = new Thread1<>();
        //启动消费者线程
        for (int i=0;i<10;i++){
            new Thread(()->{
              for(int j = 0;j<5;j++){
                  c.get();
              }
            },"c"+i).start();
        }

        //启动生产者线程
        for (int i = 0;i<2;i++){
            new Thread(()->{
              for(int j=0;j<25;j++){
                  c.put(Thread.currentThread().getName()+" "+ j);
              }
            },"p"+i).start();
        }
    }

}
