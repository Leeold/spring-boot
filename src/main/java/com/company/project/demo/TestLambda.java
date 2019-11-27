package com.company.project.demo;

import sun.misc.BASE64Encoder;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.*;
import java.util.stream.Collectors;

public class TestLambda {
    public static String reverseWords(String s) {
        String[] strs = s.split(" ");
        System.out.println(strs);
        StringBuilder res = new StringBuilder();
        for(int i = strs.length - 1; i >= 0; i--)
        {
            if(strs[i].length() > 0)
            {
                res.append(strs[i]);
                res.append(" ");
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String str = "www.toutiao.com";
        String[] arr = str.split(" . ");
        System.out.println(Arrays.toString(arr));
    }

}
class singleton{


    private static singleton instance;

    private singleton(){}

    public static singleton getInstance(){
       if (instance == null) {
           instance = new singleton();
       }
       return instance;
    }





}