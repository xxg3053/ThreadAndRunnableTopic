package com.kenfo.runnable;

/**
 * @author kenfo
 * @version V1.0
 * @Package com.kenfo.runnable
 * @Description: TODO
 * @date 2018/3/1 下午11:05
 */
public class TicketsRunnable {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        //创建三个线程
        Thread th1 = new Thread(mt, "窗口1");
        Thread th2 = new Thread(mt, "窗口2");
        Thread th3 = new Thread(mt, "窗口3");

        th1.start();
        th2.start();
        th3.start();

    }
}

class MyThread implements Runnable{

    private int ticketsCont = 5; //一共有五张火车票

    @Override
    public void run() {
        while (ticketsCont > 0){
            ticketsCont--;//如果还有火车票，就卖掉一张
            System.out.println(Thread.currentThread().getName() + "卖了一张火车票，剩余票数：" + ticketsCont);

        }
    }
}