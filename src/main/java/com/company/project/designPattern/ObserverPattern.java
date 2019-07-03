package com.company.project.designPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 分离观察者与被观察者
 */

class child{
    private boolean cry = false;
    private List<Observer> observers = new ArrayList<>();
    {
        observers.add(new Dad());
        observers.add(new Mother());
        observers.add(new Dog());
    }
    public void wakeUp(){
        cry =true;
        for(Observer o:observers){
            o.actionOnWakeUp();
        }
    }
}

interface Observer{
    void actionOnWakeUp();
}

class Dad implements Observer{

    @Override
    public void actionOnWakeUp() {
        feed();
    }

    private void feed() {
        System.out.println("dad 开始喂奶了");
    }
}

class Mother implements Observer{

    @Override
    public void actionOnWakeUp() {
        hung();
    }

    private void hung() {
        System.out.println("mother 开始喂奶了");
    }
}

class Dog implements Observer{

    @Override
    public void actionOnWakeUp() {
        wang();
    }

    private void wang() {
        System.out.println("dog 开始叫了");
    }
}
public class ObserverPattern {
    public static void main(String[] args) {
        child c = new child();
//        do sth
        c.wakeUp();
    }
}

