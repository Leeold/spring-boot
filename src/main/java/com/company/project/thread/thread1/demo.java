package com.company.project.thread.thread1;

public class demo {
    public static void main(String[] args) {
        int[] arr = {6,-3,-2,7,-15,1,2,2};
        int data = maxNum(arr);
        System.out.println(data);
    }

    private static int maxNum(int[] arr) {
        int result  = arr[0];
        int max = arr[0];
        for(int i=1;i<arr.length;i++){
            max = Math.max(max+arr[i],arr[i]);
            result = Math.max(max,result);
        }
        return result;
    }
}
