package multithreading.lesson25;

// todo Класс ReentrantLock
// С помощью этого класса можем сделать то же самое что с synchronized
// Но у этого класса есть свои плюсы, их будем изучать когда изучим DeadLock

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Lesson25 {
    public static void main(String[] args) throws InterruptedException {

        Task task = new Task();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                task.firstThread();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                task.secondThread();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        task.showCounter();
    }
}

class Task  {
    private int counter;

    private Lock lock = new ReentrantLock(); // Lock - интерфейс, ReentrantLock - class
    // ссылаем этот класс на интерфейс

    private void increment(){ // до этого мы писали synchronized а сейчас решим эту проблему черз ReentrantLock
        for (int i=0; i<10000; i++){
            counter++;
        }
    }

    public void firstThread(){
       try {
           lock.lock(); // Если один поток вызвал lock() то остальные потоки будут ждать пока не вызевится unlock()
           increment(); // так как у нас один монитор
       }finally {
           lock.unlock(); // должны вызвать в finally блоке так как метод increment() может выбросить exception
           // и не смотря на exception мы должны вызвать метод unlock()
       }
    }

    public void secondThread(){
        try {
            lock.lock();
            increment();
        }finally {
            lock.unlock();
        }
    }

    public void showCounter(){
        System.out.println(counter);
    }
}