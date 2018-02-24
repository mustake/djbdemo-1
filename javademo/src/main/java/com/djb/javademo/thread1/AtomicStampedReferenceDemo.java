package com.djb.javademo.thread1;

import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampedReferenceDemo {
    static AtomicStampedReference<Integer> money = new AtomicStampedReference<>(19, 0);

    public static void main(String[] args) {

        //三个充值线程
        for (int i = 0; i < 3; i++) {
            final int timeStamp=money.getStamp();
            new Thread() {
                @Override
                public void run() {

                    while (true) {
                        Integer m = money.getReference();
                        if (m < 20) {
                            if (money.compareAndSet(m, m + 20, timeStamp, timeStamp + 1)) {
                                System.out.println(" 余额小于 20，充值成功，余额:" + money.getReference() + "元");
                                break;
                            }
                        }else {
                            System.out.println("余额大于 20 ，无需充值， 余额："+money.getReference());
                            break;
                        }

                    }

                }
            }.start();
        }
        //一个消费线程
        new Thread(){
            final int timeStamp=money.getStamp();
            @Override
            public void run() {
                while (true) {
                    Integer m = money.getReference();
                    if (m>10){
                        if (money.compareAndSet(m,m+10,timeStamp,timeStamp+1)){
                            System.out.println(" 余额大于 10，消费成功，余额："+money.getReference());
                        }else {
                            System.out.println("消费预期失败..... "+money.getReference());
                        }
                    }else {
                        System.out.println(" 余额小于 10，无法消费，余额："+money.getReference());
                    }


                }

            }
        }.start();

    }


}
