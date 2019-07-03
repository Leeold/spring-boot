package com.company.project.thread;

import java.util.ArrayList;
import java.util.List;

public class SingleThread implements calculator {
    @Override
    public long sumUp(int[] calcData){
        // 此句代码只是为了延长程序运行时间，和程序逻辑无关
        List<SingleThread> tasks = new ArrayList<SingleThread>();

        int calcDataLength = calcData.length;
        long sum = 0l;
        for (int i = 0; i < calcDataLength; i++) {
            sum += calcData[i];

            // 此句代码只是为了延长程序运行时间，和程序逻辑无关
            tasks.add(new SingleThread());
        }
        return sum;

    }
}
