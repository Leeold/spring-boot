package com.company.project.compute;

import java.util.LinkedList;

/**
 *给定一棵二叉树，判断它是不是一棵完全二叉树。
 思路：对于一棵完全二叉树采用广度优先遍历，从根节点开始，入队列，如果队列不为空，循环。遇到第一个没有左儿子或者右儿子的节点，设置标志位，如果之后再遇到有左儿子或者右儿子的节点，那么这不是一棵完全二叉树。这个方法需要遍历整棵树，复杂度为O(N)，N为节点的总数。
 ---------------------
 *
 */
public class demo2 {

        //实现广度遍历需要的队列
        private LinkedList<Node> list = new LinkedList<Node>();
        //第n层最右节点的标志
        private boolean leftMost = false;

        public boolean processChild(Node child) {
            if(child != null) {
                if(!leftMost) {
                    list.addLast(child);
                } else {
                    return false;
                }
            } else {
                leftMost = true;
            }
            return true;
        }

        public boolean isCompleteTree(Node root) {
            //空树也是完全二叉树
            if(root == null) return true;

            //首先根节点入队列
            list.addLast(root);

            while(!list.isEmpty()) {
                Node node = list.removeFirst();

                //处理左子结点
                if(!processChild(node.left))
                    return false;
                //处理右子结点
                if(!processChild(node.right))
                    return false;
            }

            //广度优先遍历完毕，此树是完全二叉树
            return true;
        }

    public static void main(String[] args) {
       Node node1 = new Node(1);
       Node node2 = new Node(2);
       Node node3 = new Node(3);
       Node node4 = new Node(4);
       node1.left = node2;
       node1.right = node3;
        node2.left = node4;
        demo2 demo2 = new demo2();
        System.out.println( demo2.isCompleteTree(node1));

    }
}
class Node {
    int data;
    Node left = null;
    Node right =null;
    Node(int data){
        this.data = data;
    }
}
