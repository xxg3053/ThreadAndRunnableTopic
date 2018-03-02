package com.kenfo.daemon;


import java.util.Scanner;

/**
 * @author kenfo
 * @version V1.0
 * @Package com.kenfo.daemon
 * @Description: 主线程退出，则守护线程中断
 * @date 2018/3/1 下午11:30
 */
public class DaemonTheadDemo {

    public static void main(String[] args) {
        System.out.println("进入主线程：" + Thread.currentThread().getName());
        DaemonThead daemonThead = new DaemonThead();
        Thread thread = new Thread(daemonThead);
        thread.setDaemon(true);
        thread.start();

        Scanner sc = new Scanner(System.in);
        sc.next();

        System.out.println("退出主线程：" + Thread.currentThread().getName());
    }
}


class DaemonThead implements Runnable{
    @Override
    public void run() {
        System.out.println("进入守护线程" + Thread.currentThread().getName());

        try {
            writeToFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("退出了守护线程" + Thread.currentThread().getName());
    }

    private void writeToFile() throws Exception{
        int count = 0;
        while (count < 999){
            System.out.println("守护线程" + Thread.currentThread().getName() + "打印：" + count++);
            Thread.sleep(1000);
        }
    }
}