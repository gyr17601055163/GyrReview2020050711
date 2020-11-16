package com.example.demo.Ajava.for并发包.forReentrantReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReentrantReadWriteLock实现了ReadWriteLock接口【并发包下面得读写锁】
 */
public class TestReentrantReadWriteLockObj {

    public static void main(String[] args) throws InterruptedException {

        ReentrantReadWriteLock lock=new ReentrantReadWriteLock();

        /**
         * 案例一：可重入锁
         * 一个线程获取多少次锁，就必须释放多少次锁
         */
        /*Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                lock.writeLock().lock();
                System.out.println("-------one write");
                lock.writeLock().unlock();
            }
        });

        //可重入锁
        lock.writeLock().lock();
        lock.writeLock().lock();
        thread.start();
        thread.sleep(200);

        System.out.println("---------two write");
        //一个线程获取多少次锁，就必须释放多少次锁
        lock.writeLock().unlock();
        lock.writeLock().unlock();*/

        /**
         * 案例二：锁升级
         * 同一个线程中，在没有释放读锁的情况下，就去申请写锁，这属于锁升级，ReentrantReadWriteLock是不支持的
         */
         /*lock.readLock().lock();
         System.out.println("-----------readLock");
         lock.writeLock().lock();
         System.out.println("-----------writeLock");*/

        /**
         * 案例三：锁降级
         * ReentrantReadWriteLock支持锁降级.
         * 这段代码虽然不会导致死锁，但没有正确的释放锁。从写锁降级成读锁，并不会自动释放当前线程获取的写锁，
         * 仍然需要显示的释放，否则别的线程永远也获取不到写锁
         */
        lock.writeLock().lock();
        System.out.println("-----------锁降级---writeLock");
        lock.readLock().lock();
        System.out.println("-----------锁降级---readLock");
        lock.readLock().unlock();

        lock.writeLock().lock();
        System.out.println("-----------=====---writeLock");
        lock.writeLock().unlock();


    }
}
