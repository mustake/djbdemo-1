package com.djb.javademo.thread1;

/**
 *   synchronized
 * 1.指定加锁对象，进入同步代码前获得给定对象的锁
 * 2.直接作用于实例方法：相当于对当前实例加锁，进入同步代码前要获得当前实例的锁
 * 3.直接作用于静态方法：相当于对当前类加锁，进入同步代码前要获得当前类的锁
 *
 */
public class SynchronizedDemoOne {
    static SynchronizedDemoOne synchronizedDemoOne=new SynchronizedDemoOne();
    public SynchronizedDemoOne() {

    }

    public  static Integer count=0;

    //作用于静态方法  相当于对当前类加锁
    public  synchronized static void addCount(){
        System.out.println(Thread.currentThread().getName()+"   start static    ---"+count);
        for (int i=0;i<10000;i++){
                count++;
       }
        System.out.println(" static   count  :"+count+"   "+Thread.currentThread().getName());
    }



    public   Integer countTwo=0;
    //作用于实例方法  相当于对实例加锁
    public synchronized void addCountTwo(){
        System.out.println(Thread.currentThread().getName()+"   start    ---"+countTwo);
        for (int i=0;i<10000;i++){
            countTwo++;
        }
        System.out.println("   count  :"+countTwo+"   "+Thread.currentThread().getName());
    }


}
class  Main{

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread t1 = new Thread() {
                @Override
                public void run() {
                    SynchronizedDemoOne synchronizedDemoOne = new SynchronizedDemoOne();
                    synchronizedDemoOne.addCount();
                }
            };

            Thread t2 = new Thread() {
                @Override
                public void run() {
                    SynchronizedDemoOne synchronizedDemoOne = new SynchronizedDemoOne();
                    synchronizedDemoOne.addCount();
                }
            };
            t1.start();
            t2.start();
            System.out.println();
            System.out.println();
            Thread.sleep(1000);
        }

        SynchronizedDemoOne synchronizedDemoTwo = new SynchronizedDemoOne();
        for (int i = 0; i < 10; i++) {
            Thread t3 = new Thread() {
                @Override
                public void run() {
                    synchronizedDemoTwo.addCountTwo();
                }
            };

            Thread t4 = new Thread() {
                @Override
                public void run() {
                    synchronizedDemoTwo.addCountTwo();
                }
            };
            t3.start();
            t4.start();
            System.out.println();
            System.out.println();
            Thread.sleep(1000);
        }
    }

    }

