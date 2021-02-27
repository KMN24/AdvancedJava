package multithreading.lesson16;

// Продолжение

// Часть 3

class MyThread2 extends Thread{
    @Override
    public void run() {
        for ( int i =0; i< 10; i++){
            try {
                Thread.sleep(1000); // мы должны обработать exception
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello from MyThread " + i);
        }
    }
}

class Runner implements Runnable{ // имплементируемся и переопределяем метод run
    @Override
    public void run() {
        for ( int i =0; i< 10; i++){
            try {
                Thread.sleep(1000); // мы должны обработать exception
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello from MyThread " + i);
        }
    }
}

public class Lesson16_2 {
    public static void main(String[] args) throws InterruptedException {
        /*
        // Часть 3
        MyThread2 myThread1 = new MyThread2();
        myThread1.start();

        MyThread2 myThread2 = new MyThread2();
        myThread2.start();
        // Теперь наши потоки стали немножко синхронизированными
        */

        // Часть 4

        Thread thread = new Thread(new Runner()); // мы передаем наш Runner()
        // Так как мы имплеминтировались от Runnable и переопределили метод run()
        // теперь наш новый thread знает какой метод run() запустить
        thread.start(); // наш start() запустит метод run() в Runner
        System.out.println("Hello from main thread");
        // метод main запускает thread.start() и сразу же выходит от туда и продолжает делать следующий код в main

        // Если наш главный поток закончил свою работу но если остались другие потоки созданные в главном потоке,
        // то метод main будет ждать завершения остальных потоков
    }
}
