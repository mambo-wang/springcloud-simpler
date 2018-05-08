package com.wb.wbao.multithread.completionservice;

import java.util.Random;
import java.util.concurrent.*;

public class CompletionServiceTest {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(10);

        final BlockingQueue<Future<String>> queue = new LinkedBlockingDeque<>(
                10);
        //实例化CompletionService
        final CompletionService<String> completionService = new ExecutorCompletionService<>(
                exec, queue);

        // 提交10个任务
        for(int i = 0; i<10; i++){
            int finalI = i;
            completionService.submit(() -> {
                try {
                    int sleepTime = new Random().nextInt(1000);
                    Thread.sleep(sleepTime);
                    return "线程" + finalI + "睡了" + sleepTime + "秒";
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "xxx";
            });
        }

        // 输出结果
        for(int i = 0; i<10; i++){
            try {
                // 获取包含返回结果的future对象（若整个阻塞队列中还没有一条线程返回结果，那么调用take将会被阻塞，当然你可以调用poll，不会被阻塞，若没有结果会返回null，poll和take返回正确的结果后会将该结果从队列中删除）
                Future<String> future = completionService.take();
                // 从future中取出执行结果，这里存储的future已经拥有执行结果，get不会被阻塞
                String result = future.get();
                System.out.println(result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
/**
 *
 线程6睡了44秒
 线程1睡了176秒
 线程7睡了194秒
 线程5睡了197秒
 线程0睡了284秒
 线程2睡了504秒
 线程3睡了652秒
 线程8睡了718秒
 线程9睡了873秒
 线程4睡了976秒
 */