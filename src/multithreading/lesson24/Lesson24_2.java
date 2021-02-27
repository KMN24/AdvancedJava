package multithreading.lesson24;

// ПРОДОЛЖЕНИЕ Lesson24.java

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Lesson24_2 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for(int i=0; i<3; i++){
            executorService.submit(new Processor2( i, countDownLatch)); // id потока и latch
        }

        executorService.shutdown();

        for(int i=0; i<3; i++){
            Thread.sleep(1000);
            countDownLatch.countDown();
        }
    }
}

class Processor2 implements Runnable{
    private int id;
    private CountDownLatch countDownLatch;

    public Processor2(int id, CountDownLatch countDownLatch){
        this.id = id;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread with id " + this.id + " proceeded.");
    }
}

