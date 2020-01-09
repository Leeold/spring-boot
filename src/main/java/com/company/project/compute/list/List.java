package com.company.project.compute.list;

import java.util.ArrayList;
import java.util.Stack;

public class List {
    /**
     *输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
     */

    private static ArrayList<Integer> print(ListNode listNode){
        Stack<Integer> stack = new Stack<>();
        while (listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }

    /**
     * 输入一个链表，反转链表后，输出新链表的头
     * @param head
     * @return
     */

    public static ListNode ReverseList(ListNode head) {
       if(head == null){
           return null;
       }
       ListNode pre = null;
       ListNode newHead = null;
       ListNode current = head;
       while (current != null){
           ListNode pNext = current.next;
           if(pNext == null){
               newHead = current;
           }

           current.next = pre; // 反转链表指针,把当前节点的指针指向前一位
           pre = current;
           current = pNext;

       }

       return newHead;
    }

    /**
     * 递归反转链表
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {

        if(head == null || head.next ==null){
            return head;
        }

        ListNode temp = head.next;
        ListNode newHead  = reverseList(head.next);
        temp.next = head;
        return newHead;
    }


    /**
     * 输入一个链表，输出链表倒数第K个节点
     * @param args
     */

     //代码思路如下：两个指针，先让第一个指针和第二个指针都指向
     //头节点然后让第一个走（k-1）步，到达第k个节点，然后连个指针同时往后移动，
     // 当第一个节点到达末尾的时候，第二个节点所在的位置就是倒数第K个节点

    public static ListNode find(ListNode listNode,int k){

        ListNode pre = listNode;
        ListNode last = listNode;
        for(int i = 1;i<k;i++){
            if(pre.next != null){
                pre = pre.next;
            }else {
                return null;
            }
        }

        while (pre.next != null){
            pre = pre.next;
            last = last.next;
        }

        return last;

    }

    public static ListNode find1(ListNode listNode,int k){
        if(listNode ==null){
            return null;
        }
        ListNode node = listNode;
        int num =1;
        while (node.next !=null){
            num++;
            node = node.next;
        }
        if(num < k){
            return null;
        }

        ListNode head = listNode;
        for(int i=0;i< num-k ;i++){
            head = head.next;
        }

        return head;
    }

    /**
     * 给一个链表，若其中包含环，请找出链表环的入口地点，否则输出null
     * @param args
     *
     */

    public static ListNode listLoop(ListNode listNode1){

        if(listNode1 == null || listNode1.next == null){
            return null;
        }

        boolean isLoop = false;
      //使用快慢指针，慢指针每次向前一步，快指针每次两步
        ListNode pre = listNode1;
        ListNode next = listNode1;

        //两指针相遇则有环
        while (next != null && next.next !=null){
            pre = pre.next;
            next = next.next.next;
            if(pre == next){
                isLoop = true;
                break;
            }
        }
      //一个指针从链表头开始，一个从相遇点开始，每次一步，再次相遇的点即是入口节点
        if(isLoop){
            pre = listNode1;
            while (next != null && next.next != null){
                //两指针相遇的点即是入口节点
                if(pre == next){
                    System.out.println(pre.val);
                    return pre;
                }
                pre =pre.next;
                next = next.next;
            }
        }



       return null;

    }






    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.setNext(listNode2);
        listNode2.setNext(listNode3);
        listNode3.setNext(listNode4);
        System.out.println(reverseList(listNode1).next.val);
    }
}
