package com.wb.wbao.multithread.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {
    public static void main(String[] args) {
        // 初始化闭锁，并设置资源个数
        CountDownLatch latch = new CountDownLatch(2);

        new Thread(() -> {

            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 加载资源1
            System.out.println("加载资源的代码1……");
            // 本资源加载完后，闭锁-1
            latch.countDown();
        }).start();

        new Thread(() -> {
            // 加载资源2
            System.out.println("加载资源的代码2……");
            // 本资源加载完后，闭锁-1
            latch.countDown();
        }).start();

        new Thread( new Runnable(){
            public void run(){
                // 本线程必须等待所有资源加载完后才能执行
                try {
                    latch.await();
                    // 当闭锁数量为0时，await返回，执行接下来的任务
                    System.out.println("资源加载完毕，执行任务 ……");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        } ).start();
    }
}
/**
 *
 加载资源的代码2……
 加载资源的代码1……
 资源加载完毕，执行任务 ……
 */

