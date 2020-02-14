package com.company.project.demo;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * 使用斐波那契额数列解决问题
 */
public class Demo1 {
    public int JumpFloor(int target) {
        if (target <= 0) {
            return 0;
        } else if (target == 1) {
            return 1;
        } else if (target ==2) {
            return 2;
        }
        int first = 1;
        int second = 2;
        int third = 0;
        for(int i=3;i<=target;i++){
            third = first+second;
            second = third;
            first = second;
        }
        return third;
    }

    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        System.out.println(demo1.JumpFloor( 3));
    }
}
