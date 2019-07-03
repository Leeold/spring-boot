package com.company.project.thread;

import java.util.concurrent.*;

public class ThreadPool {
    public static void main(String[] args) {
        FutureTask<Integer> task = new FutureTask<>(()->{
            TimeUnit.MILLISECONDS.sleep(5000);
            return 1000;
        }); //new Callable () { Integer call();}

        new Thread(task).start();
        int num = 0;
        try {
            num = task.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(num); //阻塞
    }
}
