package com.company.project.thread;

import com.alibaba.druid.support.json.JSONUtils;
import com.sun.tracing.dtrace.ArgsAttributes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.sql.SQLOutput;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class deadLock {
    public static void main(String[] args) {
       CyclicBarrier  cyclicBarrier = new CyclicBarrier(20, new Runnable() {
           @Override
           public void run() {
               System.out.println("aaaaaa");
           }
       });

    }
}
