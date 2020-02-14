package com.company.project.demo;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {

    public static void sort(int[] arr){
       for(int i=0;i<arr.length;i++){
           for(int j=arr.length-1;j>i;j--){
               if(arr[j]%2==1 && arr[j-1]%2==0){
                   swap(arr,j-1,j);
               }
           }
       }
       print(arr);
    }
    public static void swap(int[] arr ,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static void print(int[] arr){
        for(int i =0 ;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,4,5,6,9,3,4,6,2};
        sort(arr);
    }
}
