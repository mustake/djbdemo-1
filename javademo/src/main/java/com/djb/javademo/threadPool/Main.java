package com.djb.javademo.threadPool;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {



    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;


    private static final int RUNNING    = -1 << COUNT_BITS;
    private static final int SHUTDOWN   =  0 << COUNT_BITS;
    private static final int STOP       =  1 << COUNT_BITS;
    private static final int TIDYING    =  2 << COUNT_BITS;
    private static final int TERMINATED =  3 << COUNT_BITS;


    private static int runStateOf(int c)     { return c & ~CAPACITY; }
    private static int workerCountOf(int c)  { return c & CAPACITY; }
    private static int ctlOf(int rs, int wc) { return rs | wc; }

    public static void main(String[] args) {

         final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));

      /*  System.out.println("COUNT_BITS:"+COUNT_BITS);
        System.out.println("CAPACITY:"+CAPACITY);
        System.out.println("RUNNING:"+RUNNING);
        System.out.println("SHUTDOWN:"+SHUTDOWN);
        System.out.println("STOP:"+STOP);
        System.out.println("TIDYING:"+TIDYING);
        System.out.println("TERMINATED:"+TERMINATED);

        int c = ctl.get();
        System.out.println("runStateOf:"+runStateOf(c));
        System.out.println("workerCountOf(c):"+workerCountOf(c));*/
      /*  System.out.println("ctlOf:"+ctlOf);*/


      for (;;){
          System.out.println("1111");
      }




    }
}
