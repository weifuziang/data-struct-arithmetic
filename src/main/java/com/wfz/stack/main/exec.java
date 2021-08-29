package com.wfz.stack.main;

import com.wfz.stack.struct.ArrayStack;

public class exec {
    public static void main(String[] args) {

//1. 数组模拟栈测试
        ArrayStack arrayStack = new ArrayStack(3);
        //入栈
        arrayStack.push(1);
        arrayStack.push(2);
        //栈的展示
        arrayStack.show();
        //出栈
        arrayStack.pop();
        // System.out.println(arrayStack.pop());
        //栈的展示
        arrayStack.show();


    }
}
