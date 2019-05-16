package com.company.project.compute;

public class SelectSort {
    /**
     *
     * 选择排序算法 两层嵌套循环
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {2, 5, 6, 7, 0, 1, 9};
        for(int i = 0;i< arr.length;i++){
            int min = i;
            for(int j = i+1;j<arr.length;j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            System.out.println("最小值为"+ arr[min]);
            swap(arr,i,min);
        }
        print(arr);
    }

    static void swap(int[] arr,int i ,int min){
        int temp = arr[i];
        arr[i] = arr[min];
        arr[min] = temp;
    }

    static void print(int [] arr){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

}
