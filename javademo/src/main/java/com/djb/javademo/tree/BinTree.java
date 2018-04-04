package com.djb.javademo.tree;

import java.lang.invoke.LambdaConversionException;

public class BinTree {

    static class Node{
        Node leftChild;
        Node rightChild;
        int data;
        Node(int newData){
            leftChild=null;
            rightChild=null;
            data=newData;
        }
    }
  /*  void travel_3(Node r) {
        if (r != null) {
            cout << r->key << ' ';
            travel_3(r->left);
            travel_3(r->right);
        }
    }
*/
  public static void main(String[] args) {

      //LambdaConversionException;
      System.out.print("test");
      Runnable noArguments = () -> System.out.println("Hello World");

      Runnable multiStatement = () -> {
          System.out.print("Hello");
          System.out.println(" World");
      };

  }



}
