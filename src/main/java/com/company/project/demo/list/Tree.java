package com.company.project.demo.list;

import java.util.LinkedList;
import java.util.Queue;
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
     * @param
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

    /**
     * 判断一棵二叉树是不是完全二叉树
     */

    public static boolean isTree(TreeNode treeNode){
        if(treeNode == null){
            return false;
        }
        boolean isT = false;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(treeNode);
        while (queue.size() > 0){
            TreeNode node = queue.poll();
            if(isT && (node.left !=null || node.right != null)){
                return false;
            }
            if(node.left ==null && node.right!=null){
                return false;
            }
            if(node.left !=null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }else{
                isT = true;
            }
        }
        return true;
    }

    /**
     * 判断一颗二叉树是否为镜像二叉树，或是对称的
     * @param
     */

    private boolean isSymmetrical(TreeNode left, TreeNode right) {
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }

        if(left.val == right.val){
            return isSymmetrical(left.left,right.right) && isSymmetrical(left.right,right.left);
        }

        return false;
    }
    /**
     * 判断一颗二叉树是否为镜像二叉树，或是对称的 利用DFS
     * @param
     */
    boolean isSymmetricalDFS(TreeNode pRoot)
    {
        if(pRoot == null) return true;
        Stack<TreeNode> s = new Stack<>();
        s.push(pRoot.left);
        s.push(pRoot.right);
        while(!s.empty()) {
            TreeNode right = s.pop();//成对取出
            TreeNode left = s.pop();
            if(left == null && right == null) continue;
            if(left == null || right == null) return false;
            if(left.val != right.val) return false;
            //成对插入
            s.push(left.left);
            s.push(right.right);
            s.push(left.right);
            s.push(right.left);
        }
        return true;
    }
    /**
     * 判断一颗二叉树是否为镜像二叉树，或是对称的 利用BFS
     * @param
     */
    boolean isSymmetricalBFS(TreeNode pRoot)
    {
        if(pRoot == null) return true;
        Queue<TreeNode> s = new LinkedList<>();
        s.offer(pRoot.left);
        s.offer(pRoot.right);
        while(!s.isEmpty()) {
            TreeNode left= s.poll();//成对取出
            TreeNode right= s.poll();
            if(left == null && right == null) continue;
            if(left == null || right == null) return false;
            if(left.val != right.val) return false;
            //成对插入
            s.offer(left.left);
            s.offer(right.right);
            s.offer(left.right);
            s.offer(right.left);
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
//        node2.left = node4;
        node2.right = node5;
        boolean is = isTree(node1);
        System.out.println(is);
    }
}
