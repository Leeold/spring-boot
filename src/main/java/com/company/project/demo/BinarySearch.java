package com.company.project.demo;


/**
 * 二分查找算法
 */
public class BinarySearch {
    public static void main(String[] args) {
        int [] arr = {1,3,4,5,7,8,9,12,14,16,78};
        int result = search1(arr,4,0,arr.length-1);
        System.out.println(result);
    }

    /**
     * 二分查找（非递归）
     * @param arr
     * @param data
     * @return
     */
    public static int search(int[] arr, int data) {
           int min = 0;
           int max = arr.length -1;
           int mid;
           while (min <= max) {
               mid = (min + max) / 2;
               if (arr[mid] > data){
                   max = mid -1;
               }else if(arr[mid] < data){
                   min = mid + 1;
               }else{
                   return mid;
               }
           }
           return -1;
    }

    /**
     * 二分查找（递归实现）
     * @param arr
     * @param data
     * @param min
     * @param max
     * @return
     */
    public static int search1(int[] arr, int data,int min,int max){
        while (min <= max){
            int mid = (min + max) /2;
            if(arr[mid] == data){
                return mid;
            }else if(arr[mid] > data) {
                return search1(arr,data,min,mid-1);
            }else if(arr[mid] < data){
                return search1(arr,data,mid+1,max);
            }
        }

        return -1;
    }
}
