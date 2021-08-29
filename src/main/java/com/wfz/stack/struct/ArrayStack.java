package com.wfz.stack.struct;


/**
 * 使用数组来模拟栈
 */
public class ArrayStack {
    /* 一. 栈的应用：
     * 1. 子程序的调用；
     * 2. 递归方法处理；
     * 3. 算数表达式的处理；
     * 4. 二叉树的遍历；
     */

    /*二. 栈的特性
     * 1. 先进后出
     * 2. 栈顶指针：top
     * 3. 进栈：push
     * 4. 出栈：pop
     */

    private int maxSize; //栈的大小
    private int[] stack; //栈
    private int top = -1; //栈针


    //构造器

    public ArrayStack(int maxSize) {

        this.maxSize = maxSize;
        this.stack = new int[this.maxSize];

    }

    //栈满

    public Boolean isFull() {

        return top == maxSize - 1;
    }

    //栈空

    public Boolean isEmpty() {
        return top == -1;
    }


    //入栈push

    public void push(int x) {


        if (isFull()) {
            throw new RuntimeException("stack is full");
        }

        top++;
        stack[top] = x;

    }


    //出栈pop

    public int pop() {

        if (isEmpty()) {
            throw new RuntimeException("stack is empty!!");
        }
        int tmp = stack[top];
        top--;
        return tmp;

    }

    //栈的展示

    public void show() {


        if (isEmpty()) {
            System.out.println("栈为空，没有可以输出的数据！！");
            return;
        }

            for (int i = top; i>= 0; i--) {
                System.out.println(stack[i]);
            }

    }


}

