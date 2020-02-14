package com.company.project.demo;

/**
 *
 *冒泡排序 两层循环嵌套
 * 样本小且基本有序的时候效率比较高
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {2,4,9,5,4,67,54,6};

        for(int i=arr.length-1;i>0;i--){

            for(int j =0; j<i;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr, j, j+1);
                }
            }

        }

        print(arr);
    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void print(int[] arr){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

}
