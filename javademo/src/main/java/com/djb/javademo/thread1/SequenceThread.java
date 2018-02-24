package com.djb.javademo.thread1;

/**
 * 现在有T1、T2、T3三个线程，你怎样保证T2在T1执行完后执行，T3在T2执行完后执行
 */
public class SequenceThread extends Thread {


    private Thread targe;

    public SequenceThread(String name) {
        super.setName(name);
    }

    public void setTarge(Thread targe) {
        this.targe = targe;
    }

    public Thread getTarge() {
        return targe;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + "开始执行");
            if (!Thread.currentThread().getName().equals("t1")) {
                if (null != getTarge()) getTarge().join();
            }
          //  sleep(2000);
            System.out.println(Thread.currentThread().getName() + "执行完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //   super.run();

    }

    public static void main(String[] args) {

        SequenceThread t1 = new SequenceThread("t1"),
                t2 = new SequenceThread("t2"),
                t3 = new SequenceThread("t3");

        t2.setTarge(t1);
        t3.setTarge(t2);
        t3.start();
        t2.start();
        t1.start();
    }
}
