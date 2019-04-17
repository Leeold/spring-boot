package com.company.project.compute;

/**
 * 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {3,4,7,84,3,6,71,1};

        for(int i = 1;i<arr.length;i++){
            for(int j=i;j>0;j--){
                if(arr[j-1]>arr[j]){
                   swap(arr,j,j-1);
                }
            }
        }

        print(arr);
    }

    static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void print(int[] arr){
        for(int i =0 ;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

}
