package com.company.project.demo;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型
 */
public class queue {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        public void push(int node){
            stack1.push(node);

        }

        public int pop(){
            if(stack2.empty()){
                while (!stack1.empty()){
                   stack2.push(stack1.pop());
                }
            }
            System.out.println(stack2);
            return stack2.pop();
        }

    public static void main(String[] args) {
        queue q =new queue();
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        q.pop();
        q.pop();
        System.out.println(q);

    }

}
