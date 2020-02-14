package com.company.project.demo;

public class Find {
    /**
     * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * @param target
     * @param array
     * @return
     */
    public static boolean Find(int target, int [][] array) {
        for(int i = 0; i<array.length;i++){
            int startIndex = 0;
            int endIndex = array[i].length-1;
            while(startIndex <= endIndex){
                int mid = (startIndex + endIndex)/2;
                if(array[i][mid] > target){
                    startIndex = mid+1;
                }else if(array[i][mid] < target){
                    endIndex = mid-1;
                }else{
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] numseven = new int[][]{{10,20,30},{40,50},{60}};
        boolean is  = Find(60,numseven);
        System.out.println(is);
    }
}
