package com.company.project.compute;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 n<=39
 */
public class Fibonacci {
    public int Fibo(int n) {
        int first=1,second=1,third=0;
        if(n<0){
            return 0;
        }else if(n==1||n==2){
            return 1;
        }else{
            for (int i=3;i<=n;i++){
                third=first+second;//第三项等于前两项的和
                first=second;// 第一项等于第二项
                second=third;// 第二项等于第三项
            }
            return third;
        }
    }

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        System.out.println(f.Fibo(8));
    }
}
