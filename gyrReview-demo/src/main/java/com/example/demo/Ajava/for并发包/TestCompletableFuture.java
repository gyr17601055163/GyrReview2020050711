/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: TestCompletableFuture
 * Author:   gyr
 * Date:     2020/6/27 10:36
 * Description:
 */
package com.example.demo.Ajava.for并发包;

import java.util.Hashtable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;

public class TestCompletableFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println("---------");

        //1.后一个依赖前一个的结果
        /*CompletableFuture.supplyAsync(()->{
            //System.out.println("---------1");
            return "ok1";
        }).thenAccept(x->{
            System.out.println(x+"===>");
        });*/


        //2.合并返回结果
        /*CompletableFuture.supplyAsync(()->{
            System.out.println("---------1");
            return "ok11";
        }).thenCombineAsync(
                CompletableFuture.supplyAsync(()->{
                    return "ok22";
                }),(x1,x2)->{
                    return x1+x2;
                }
        ).thenCombineAsync(
                CompletableFuture.supplyAsync(()->{
                    return "ok33";
                }),(x12,x3)->{
                    return x12+x3;
                }
        ).thenAccept(x->{
            System.out.println(x+"--<");
        });*/

        CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "ok111";
        });

        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "ok222";
        });

        CompletableFuture<String> completableFuture3 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "ok333";
        });

        //3.抢答，谁运行时间短，先返回谁的结果
        /*CompletableFuture<Object> completableFutureResult = CompletableFuture.anyOf(completableFuture1, completableFuture2, completableFuture3);
        System.out.println(completableFutureResult.get());
        System.out.println("------------000");*/

        //4.等待所以的线程全部运行完成之后，返回所有的运行结果
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(completableFuture1, completableFuture2, completableFuture3);
        voidCompletableFuture.get();    //阻塞到这里，直到所有的线程全部运行完成
        System.out.println(completableFuture1.get()+", "+completableFuture2.get()+", "+completableFuture3.get());


    }
}