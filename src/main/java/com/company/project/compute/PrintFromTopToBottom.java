package com.company.project.compute;

import java.util.ArrayList;

public class PrintFromTopToBottom {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode treeNode){

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<TreeNode> queue = new ArrayList<>();

        if(treeNode ==null){
            return list;
        }

        queue.add(treeNode);

        while (queue.size() !=0){
            TreeNode temp = queue.remove(0);
            if(temp.left != null){
                queue.add(temp.left);
            }
            if(temp.right != null){
                queue.add(temp.right);
            }
            list.add(temp.val);
        }

        return list;

    }





}

class TreeNode{
    int val = 0;
    Treenode left = null;
    Treenode right =null;
    public TreeNode(int val){
        this.val =val;
    }
}
