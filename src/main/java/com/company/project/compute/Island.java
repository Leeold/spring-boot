package com.company.project.compute;


/**
 * 在一个地图中，找出一共有多少个岛屿。
 我们用一个二维数组表示这个地图，地图中的 1 表示陆地，0 表示水域。一个岛屿是指由上下左右相连的陆地，并且被水域包围的区域。
 你可以假设地图的四周都是水域。
 { 0, 0, 0, 0, 0, 0, 0, 0 },
 { 0, 0, 1, 0, 0, 0, 0, 0 },
 { 0, 1, 1, 1, 0, 0, 0, 0 },
 { 0, 0, 1, 0, 0, 1, 1, 0 },
 { 0, 0, 0, 0, 0, 1, 1, 0 },
 { 0, 0, 1, 0, 0, 0, 0, 0 },
 { 0, 0, 0, 0, 0, 0, 0, 1 },

 */
public class Island {

    static int isLandArray [][] = {
            { 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 1, 0, 0, 0, 0, 0 },
            { 0, 1, 1, 1, 0, 0, 0, 0 },
            { 0, 0, 1, 0, 0, 1, 1, 0 },
            { 0, 0, 0, 0, 0, 1, 1, 0 },
            { 0, 0, 1, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 1, 0, 0, 0, 1 },
        };

    public static void main(String[] args) {
        int count = 0;
        for(int i=0;i<isLandArray.length;i++){
            for(int j=0;j<isLandArray[i].length;j++){
                 if(isLandArray[i][j] == 1){
                     count ++;
                    lj(i,j);
                 }
            }
        }
        System.out.println(count);
    }

    //递归修改附近的值

    static void lj(int i, int j){
        isLandArray[i][j] = 2;
        //上边
        if(i-1>=0 && isLandArray[i-1][j] == 1){
            lj(i-1,j);
        }
        //下边
        if(i+1<isLandArray.length && isLandArray[i+1][j] ==1){
            lj(i+1,j);
        }
        //左边
        if(j-1>=0 && isLandArray[i][j-1] == 1){
            lj(i,j-1);
        }
        //右边
        if(j+1<isLandArray.length && isLandArray[i][j+1] == 1){
             lj(i,j+1);
        }

    }

}
