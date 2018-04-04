package com.djb.javademo.threadPool;


import java.util.List;
import java.util.Vector;

/**
 * 简单线程池实现
 */
public class ThreadPoolExecutorDemo {

    private static ThreadPoolExecutorDemo instance=null;

    //空闲的线程队列
    private List<Worker> idleThreads;

    //已有的线程总数
    private int threadCounter;
    private boolean isShutDown=false;

    private ThreadPoolExecutorDemo(){
        this.idleThreads=new Vector<>(5);
        threadCounter=0;
    }

    public int getCreatedThreadsCount(){
        return  threadCounter;
    }

    //取得线程池的实例
    public synchronized  static ThreadPoolExecutorDemo getInstance(){
        if (null ==instance){
            instance=new ThreadPoolExecutorDemo();
        }
        return instance;
    }

    //将线程放入池中
    protected synchronized void repool(Worker repoolingThread){
        if (!isShutDown){
            idleThreads.add(repoolingThread);
        }else {
            repoolingThread.shutDown();//关闭线程
        }
    }

    //停止池中的所有线程池
    public synchronized void shutDown(){
        isShutDown=true;
        for (int threadIndex=0;threadIndex<idleThreads.size();threadIndex++){
            Worker idleThread=idleThreads.get(threadIndex);
            idleThread.shutDown();
        }
    }


        //执行任务
        public synchronized  void start(Runnable target){

            Worker thread=null;
            //如果有空闲线程，则直接使用
            if(idleThreads.size()>0){
                int lastIndex=idleThreads.size()-1;
                thread=idleThreads.get(lastIndex);
                idleThreads.remove(lastIndex);
                //立即执行这个任务
                thread.setTarget(target);
            }else{
                //没有空闲线程，则创建线程
                threadCounter++;
                thread=new Worker(target,"PThread #" +threadCounter,this);
                //启动这个线程
                thread.start();
            }

        }
    }

