package com.wb.wbao.multithread.volatilete;

public class VolatileTest {
    // 用于控制线程当前的执行状态
    private volatile boolean running = false;

    public static void main(String[] args) {
        VolatileTest test = new VolatileTest();
        test.run();
        test.start();
    }

    public void run(){
        // 开启一条线程
        new Thread(() -> {
            // 开关
            while(!running){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("exec something...");
            }
        }).start();
    }


    // 开始执行
    public void start(){
        running = true;
    }
}
