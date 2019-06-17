package com.company.project.thread.thread1;

import org.omg.SendingContext.RunTime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class demo {
    public static void main(String[] args) {

        System.out.println("Java进程可以向操作系统申请到的最大内存:"+(Runtime.getRuntime().maxMemory())/(1024*1024)+"M");
        System.out.println("Java进程空闲内存:"+(Runtime.getRuntime().freeMemory())/(1024*1024)+"M");
        System.out.println("Java进程现在从操作系统那里已经申请了内存:"+(Runtime.getRuntime().totalMemory())/(1024*1024)+"M");
    }

}
