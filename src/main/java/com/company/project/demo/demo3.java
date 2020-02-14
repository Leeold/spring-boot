package com.company.project.demo;

/**
 * 给定一个二叉树，判断它是不是二叉搜索树。

 思路：对于一棵二叉树，最简单的方法就是中序遍历，看是不是一个递增数列，如果是，则是一棵二叉搜索树，如果不是，则不是二叉搜索树。在这里用一个lastVisit去记录上一次搜索的节点。这个过程就是先找到最左下角的节点，更新lastVisit为这个节点的值，然后按照中序遍历依次更新即可。
 ---------------------
 */
public class demo3 {

    class Node {
        int data;
        Node left;
        Node right;
    }
    private static int lastVisit = Integer.MIN_VALUE;

    public static boolean isBST(Node root) {
        if(root == null) return true;

        boolean judgeLeft = isBST(root.left); // 先判断左子树

        if(root.data >= lastVisit && judgeLeft) { // 当前节点比上次访问的数值要大
            lastVisit = root.data;
        } else {
            return false;
        }

        boolean judgeRight = isBST(root.right); // 后判断右子树

        return judgeRight;
    }

}
