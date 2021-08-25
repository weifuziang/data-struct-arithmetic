package com.wfz.queue.struct;

public class Queue {

    private int arrMax;
    private int rear;
    private int front;
    private int[] arr;

    //1. 构造器
    public Queue(int arrMax) {

        this.arrMax = arrMax;
        this.arr = new int[arrMax];

    }

    //2. 极端情况，队列是否满了

    private void isFull() {
        if (rear == arrMax) {
            System.out.println("队列已满！！！");
        } else {
            System.out.println("队列可继续插入！！");
        }
    }

    //3. 添加


    //4. 展示

    //5. 返回队列首元素


}
