package com.company.project.compute;

import java.util.Stack;

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
