package multithreading.lesson23;

// todo Паттерн producer - consumer II часть
// Сдеалем тот же самое что было в уроке 21, но создадим без Blocking Queue
import java.util.LinkedList;
import java.util.Queue;

public class Lesson23 {
    public static void main(String[] args) throws InterruptedException {
        ProducerConsumer pc = new ProducerConsumer();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consume();
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
}

class ProducerConsumer{
    private Queue<Integer> queue = new LinkedList<>(); // Исп-м простой queue и а не ArrayBlockingQueue
    private final int LIMIT = 10; // max elements in queue
    private final Object lock = new Object(); // На этом объекте будет синхронизация и мы должны явно уазать lock.wait() и lock.notify()
    // Все объекты на которых мы син-ся должны быть константами (final)
    public void produce() throws InterruptedException {
        int value = 0;
        while (true){
            synchronized (lock){
                while (queue.size() == LIMIT){ // если оччередь заполнена то мы должны ждать пока очередь не освободится
                    lock.wait();
                }
                //queue.add(); // тоже можем исп-ь главное чтобы наши методы добавления эле-в НЕ были потокобезопасными (Blocking Queue)
                queue.offer(value++);
                lock.notify();
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true){
            synchronized (lock){

                while (queue.size() == 0){
                    lock.wait();
                }

                int value = queue.poll();
                System.out.println(value);
                System.out.println("Queue size is " + queue.size());
                lock.notify(); // Лучше вызвать в конце блока, так как он ждет пока блок закончится а потом лишь отдает монитор
            }
            Thread.sleep(1000);
        }
    }

}