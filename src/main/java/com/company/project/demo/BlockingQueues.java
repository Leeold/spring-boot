package com.company.project.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 阻塞队列
 */
public class BlockingQueues {
    public static void main(String[] args) {
        MyBlockingQueue queue = new MyBlockingQueue(5);
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                queue.put(i);
                System.out.println("塞入" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for (; ; ) {
                System.out.println("消费"+queue.take());
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        t1.start();
        t2.start();
    }
    public static class MyBlockingQueue{
       //队列容器
        private List<Integer> list = new ArrayList<>();
        private volatile int size;
        private volatile int capacity;
        Lock lock = new ReentrantLock();
        private final Condition isFull = lock.newCondition();
        private final Condition isNull = lock.newCondition();
        MyBlockingQueue(int cap){
            this.capacity = cap;
        }

        /**
         * 添加方法
         * @param data
         */
        public void put(int data){

            try {
                lock.lock();
                try {
                    while (size > capacity) {
                        System.out.println("阻塞队列满了");
                        isFull.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ++size;
                list.add(data);
                isNull.signal();
            } finally {
              lock.unlock();
            }

        }

        public Integer take(){
            try {
                lock.lock();
                try {
                    while (size == 0){
                        System.out.println("阻塞队列空了");
                        isNull.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                --size;
                int res = list.get(0);
                list.remove(0);
                isFull.signal();
                return res;
            } finally {
                lock.unlock();
            }
        }

    }
}
