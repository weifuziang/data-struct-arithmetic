package com.wfz.linked_list.struct;

public class SingleLinkedList {

    //声明头节点
    private SingleLinkedListNode head = new SingleLinkedListNode(0, "", 0);


    //1. 链表的展示


    //2. 链表添加


    //3. 链表的有序添加


    //4. 链表的删除


    //5. 链表的修改


    //6. 链表的查询


    //7. 获取单链表的有效节点个数（头节点除外）


    //8. 查找链表中的倒数第K个节点


}


class SingleLinkedListNode {

    private int id;
    private String name;
    private int age;
    private SingleLinkedListNode next;

    SingleLinkedListNode(int id, String name, int age) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.next = null;

    }



}
