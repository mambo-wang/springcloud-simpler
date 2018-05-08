package com.wb.wbao.multithread.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest {

    public static void main(String[] args) {
        // 创建信号量对象，并给予3个资源
        Semaphore semaphore = new Semaphore(3);

// 开启10条线程
        for ( int i=0; i<10; i++ ) {
            new Thread(() -> {
                try {
                    // 获取资源，若此时资源被用光，则阻塞，直到有线程归还资源
                    semaphore.acquire();
                    // 任务代码
                    System.out.println("开始执行任务。。。");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("任务执行完毕。。。");
                    // 释放资源
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
