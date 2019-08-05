package com.example.demo.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    public static void main(String[] args) {
        Long start = System.currentTimeMillis();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000L);
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName());
                    System.out.println("Spend time: " + (System.currentTimeMillis() - start) + "ms.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000L);
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName());
                    System.out.println("Spend time: " + (System.currentTimeMillis() - start) + "ms.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });
        thread2.start();
        try {
            cyclicBarrier.await();
            System.out.println(Thread.currentThread().getName());
            System.out.println("Spend time: " + (System.currentTimeMillis() - start) + "ms.");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        cyclicBarrier.reset();
        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000L);
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });
        thread4.start();
        Thread thread5 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });
        thread5.start();
        try {
            cyclicBarrier.await();
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }

}
