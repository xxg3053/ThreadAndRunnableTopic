package com.kenfo.thread;

/**
 * @author kenfo
 * @version V1.0
 * @Package com.kenfo.thread
 * @Description: 应用Thread模拟卖票
 * @date 2018/3/1 下午10:56
 */
public class TicketsThread {

    public static void main(String[] args) {
        //创建三个线程，模拟三个窗口卖票
        MyThread mt1 = new MyThread("窗口1");
        MyThread mt2 = new MyThread("窗口2");
        MyThread mt3 = new MyThread("窗口3");

        //启动三个线程，开始卖票
        mt1.start();
        mt2.start();
        mt3.start();
    }
}


class MyThread extends Thread {

    private int ticketsCont = 5; //一共有五张火车票
    private String name;  //窗口，也是线程的名称

    public MyThread(String name){
        this.name = name;
    }

    @Override
    public void run() {
        while (ticketsCont > 0){
            ticketsCont--;//如果还有火车票，就卖掉一张
            System.out.println(name + "卖了一张火车票，剩余票数：" + ticketsCont);

        }
    }
}

