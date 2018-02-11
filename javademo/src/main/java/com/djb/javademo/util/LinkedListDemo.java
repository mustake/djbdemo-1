package com.djb.javademo.util;


import java.util.LinkedList;

public class LinkedListDemo {

    public void add(Object object){

    }


    //实际容量   还有一个默认容量
    private int size;//
    private int capacity=1<<8;//

    private Node [] nodes;
    LinkedListDemo(int size){
        this.size=size;
        nodes=new Node[size];
        if (size>capacity){
            //给存储地址扩容
            capacity=(size/capacity+1)*capacity;
        }
    }

    void isCapacity(int i){
        if (i>capacity){
            //给存储地址扩容
            this.capacity=(i/capacity+1)*capacity;
        }

    }


    private class Node<E>{
        E item;
        Node<E> next;
        Node<E> prev;
        Node(Node<E> node){
            item=node.item;
            next=node.next;
            prev=node.prev;
        }
    }
}
