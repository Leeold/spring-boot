package com.company.project.compute;

public class helper {

    /**
     * 二分查找算法递归版
     * @param args
     */

    public static int binarySearch(int[] arr,int target,int left,int right){
        if(target < arr[left] || target >arr[right] || left > right){
            return -1;
        }
        int middle = (left+right)/2;
        if(arr[middle] > target){
            return binarySearch(arr,target,left,middle-1);
        }else if(arr[middle] < target){
            return binarySearch(arr,target,middle+1,right);
        }else{
            return middle;
        }

    }

    /**
     * 二分查找算法，非递归版
     * @param args
     */

    public static int binarySearch1(int[] arr,int target){
        int left =0;
        int right =arr.length-1;
        if(target < arr[left] || target >arr[right] || left > right){
            return -1;
        }

        while (left <= right){
            int middle = (left+right)/2;
            if(arr[middle] > target){
                right = middle-1;
            }else if(arr[middle] < target){
                left = middle +1;
            }else{
                return middle;
            }
        }

        return -1;

    }
}
