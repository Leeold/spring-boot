package com.company.project.thread.thread1;

import org.omg.SendingContext.RunTime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class demo {
    public demo() {
    }

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("apple","123");
        map.put("apple","456");
        map.put(null,"456");
        map.put("null","1");
        System.out.println(map.get(null));


    }

}
