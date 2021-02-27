package multithreading.lesson22;

import java.util.Scanner;

// todo Методы wait и notify
// Сделаем паттерн produce, consume через wait и notify без исп-я каких то классов
// У любого объекта есть методы wait() and notify() так, как реализован в классе Object
// Так, как ключевое слово synchronized исп-ся для объектов, вот и wait and notify доступны для всех объектов

// Методы wait() и notify() вызывается на тех объектах который указывает lock

public class Lesson22 {
    public static void main(String[] args) throws InterruptedException {
        //Object ob = new Object();
        //ob.wait();
        //ob.notify();

        WaitAndNotify wn = new WaitAndNotify();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.consume();
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

class WaitAndNotify {
    public void produce() throws InterruptedException {
        synchronized (this){ // this это указывает на объект wn ( new WaitAndNotify() )
            System.out.println("Producer thread started...");
            // Когда вызывается wait() происходит 2 вещи:
            // 1) Сразу же Отдаем intrinsic lock ( отдаем наш монитор для другого потока)
            // 2) Ждем пока будет вызван notify()
            // Если вместо this был какой то другой lock то мы должны у него вызвать методы wait() и notify()
            this.wait(); // wait -  вызывается на сихронизированном блоке если просто вызвать у объекта то смысла нету
            // И вызывается на том объекте на котором определен наш синхро-й блок, а блок син-н на объекте this
            System.out.println("Producer thread resumed...");

            //wait(1000);// Будет ждать 1 сек и если не вызевится notify() до 1 сек-ы , то produce() выполнит свою работу

        }
    }

    public void consume() throws InterruptedException {
        Thread.sleep(2000);

        Scanner scanner = new Scanner(System.in);

        synchronized (this){
            System.out.println("Waiting for returning (Enter) key pressed");
            scanner.nextLine();
            this.notify(); // Пробуждает только 1 поток // Вызывает тот поток который вызвал wait()
            // notify() -> не сразу отдает монитор, а после того как закончится син-й блок
            System.out.println("Notify() не сразу отдает монитор, а после того как закончится син-й блок");
            // notifyAll(); // Пробуждает все потоки
        }
    }
}
