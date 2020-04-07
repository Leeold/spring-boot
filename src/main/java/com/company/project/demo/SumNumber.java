package com.company.project.demo;


import java.util.HashSet;

/**
 * 求递增数组中相加等于10的元素对(使用冒泡排序)
 */
public class SumNumber {
    public static void main(String[] args) {
        int[] arr = {1,3,5,6,7,8,9};
        int num = 0;
        for(int i=arr.length-1;i>0;i--){
            for(int j =0; j<i;j++){
                if(arr[i]+arr[j] == 10){
                    num++;
                }
            }
        }
        System.out.println(num);
    }
}
