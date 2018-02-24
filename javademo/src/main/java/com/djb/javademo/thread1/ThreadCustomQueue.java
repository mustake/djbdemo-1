package com.djb.javademo.thread1;

public class ThreadCustomQueue {

    private  Object []  objects;
    private int size=10;
    private int realSize;

    public  void add(Object object){
        if (null==objects|| objects.length<=0 ){
            objects=new Object[size];
        }
        if ((realSize+1)==size){
            //队列已经满了   等待
            while(true){

            }

        }
        objects[realSize]=object;
        this.realSize++;
    }

    public  Object get(){
        if (this.realSize<0){
            //队列已经空了，一直等待
            while (true){
                

            }
        }
        Object object=objects[0];
        this.realSize--;
        objects=copyObjects(new Object[this.size]);
        return object;

    }

    public Object[] copyObjects(Object[] newObjects) {
        for (int i=1;i<objects.length;i++){
            newObjects[i-1]=objects[i];
        }
        return newObjects;
    }
}
