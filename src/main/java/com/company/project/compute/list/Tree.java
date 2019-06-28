package com.company.project.compute.list;

import java.util.Stack;

public class Tree {

    /**
     * 求二叉树的最大深度
     */


    private static int max =1;

    /**
     * 遍历递归思想
     * @param treeNode
     * @return
     */
    public static int maxDepth(TreeNode treeNode){
        if(treeNode == null){
            return 0;
        }
        helper(treeNode,1);
        return max;
    }

    private static void helper(TreeNode treeNode, int currentDepth) {
        if(treeNode == null){
            return;
        }
        max = Math.max(max,currentDepth);
        helper(treeNode.left,currentDepth+1);
        helper(treeNode.right,currentDepth+1);
    }

    /**
     * 递归分治思想
     * @param treeNode
     * @return
     */

    public static int maxDepth1(TreeNode treeNode){
        if(treeNode == null){
            return 0;
        }

        int left = maxDepth1(treeNode.left);
        int right = maxDepth1(treeNode.right);

        return Math.max(left,right)+1;
    }

    /**
     * 非递归思想，借助栈来实现
     * @param args
     */

    public static int maxDepth2(TreeNode treeNode){
        if(treeNode == null){
            return 0;
        }
        Stack<TreeNode> stackTree = new Stack<>();
        Stack<Integer> stackDepth = new Stack<>();
        stackTree.push(treeNode);
        stackDepth.push(1);
        int max =1;
        while (!stackTree.isEmpty()){
            TreeNode curNode = stackTree.pop();
            int curDepth = stackDepth.pop();
            if(curNode.left !=null){
                stackTree.push(curNode.left);
                stackDepth.push(curDepth+1);
            }
            if(curNode.right !=null){
                stackTree.push(curNode.right);
                stackDepth.push(curDepth+1);
            }
            if(curNode.left == null && curNode.right == null){
                max = Math.max(max,curDepth);
            }
        }

        return max;
    }
}
