package multithreading.lesson21;

// todo Паттерн producer - consumer I часть
// http://java-online.ru/concurrent-queue-block.xhtml#exampleABQ

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Lesson21 {
    private static BlockingQueue<Integer> blockingQueue =  new ArrayBlockingQueue<>(10);

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }

    private static void produce() throws InterruptedException { // producer - что то создает, дает
        Random random = new Random();
        while (true){
            blockingQueue.put(random.nextInt(100)); // если очередь заполнена put будет ждать пока очередь не освободится
        }
    }

    private static void consumer() throws InterruptedException { // consumer - что-то берет
        Random random = new Random();
        while (true){
            Thread.sleep(100);

            if(random.nextInt(10) == 5){ // если рандомное число равно 5
                System.out.println(blockingQueue.take()); // выведет на экран узел
                // take - если очередь пуста то take будет ждать пока в очереди не будет элементов
                System.out.println("Queue size is " + blockingQueue.size());
            }
        }
    }
}
