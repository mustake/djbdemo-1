package com.djb.javademo.threadPool;



import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;


public class ThreadPoolExecutorDemo {

    private int  corePoolSize;
    private int maximumPoolSize;
    private int runningPoolSize=0;

    //标记线程状态
    private static int READY=0;
    private static int RUNNING=1;
    private static int STOP=2;

    //设计线程存储池

  //  private final BlockingQueue<Runnable> workQueue;


    //执行任务
    private final class  Worker implements Runnable{
        final Thread thread;

        Runnable firstTask;

        Worker(Runnable firstTask){
            this.firstTask=firstTask;
            this.thread=getThreadFactory().newThread(this);
        }



        @Override
        public void run() {
            runWorker(this);

        }
    }



     final void  runWorker(Worker worker){


    }


    private volatile ThreadFactory threadFactory;
    public ThreadFactory getThreadFactory() {
        return threadFactory;
    }


}
