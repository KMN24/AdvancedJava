package multithreading.lesson27;

// todo Взаимная блокировка Deadlock

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Lesson27_2 {
    public static void main(String[] args) throws InterruptedException {

        Runner2 runner = new Runner2();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    runner.firstThread();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    runner.secondThread();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        runner.finished();
    }
}

class Runner2 {

    private Lock lock1 = new ReentrantLock(); // с ReentrantLock() мы избежать вложенных блоков
    private Lock lock2 = new ReentrantLock();

    private Account2 account1 = new Account2();
    private Account2 account2 = new Account2();

    private void takeLocks(Lock lock1, Lock lock2) throws InterruptedException {
        boolean firstLockTaken = false;
        boolean secondLockTaken = false;

        while (true){
            try{
                firstLockTaken = lock1.tryLock(); // тот самый метод который нужно чтобы избежать от DeadLock
                secondLockTaken = lock2.tryLock();
            }finally {
                if(firstLockTaken && secondLockTaken){
                    return;
                }

                if(firstLockTaken){
                    lock1.unlock();
                }

                if (secondLockTaken){
                    lock2.unlock();
                }
            }
            Thread.sleep(1);
        }


    }

    public void firstThread() throws InterruptedException {
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            /*
            lock1.lock();
            lock2.lock();
            */

            takeLocks(lock1, lock2);

            try {
                // передаем рандомное число денег с 1 акк на 2 акк
                Account2.transfer(account1, account2, random.nextInt(100));
            }finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void secondThread() throws InterruptedException {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            //lock2.lock(); // Если первым вызвать lock2.lock() - то будет взаимный DeadLock и программа зависнет
            //lock1.lock();
            // todo Избежание DeadLock
            //  1) нужно вызвать наши lock'и одинаково
            //  2) в ReentrantLock есть один метод можем его исп-ть, он поможет избежать от deadLock, несмотря на очередность
            // Создадим наш метод takeLocks и передадим в него наши локи, и не будет разницы очередности

            /*
            lock1.lock();
            lock2.lock();
             */

            takeLocks(lock2, lock1); // Специально отправляем сначала lock2 потом lock1, чтобы удостовериться что не будет DeadLock

            try {
                Account2.transfer(account2, account1, random.nextInt(100));
            }finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void finished() {
        System.out.println(account1.getBalance());
        System.out.println(account2.getBalance());
        System.out.println("Total balance = " + (account1.getBalance() + account2.getBalance())); // должно быть 20000
    }
}

class Account2 {
    private int balance = 10000;

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) { // количество денег которые добавляем на баланс
        this.balance += amount;
    }

    public void withDraw(int amount) {
        this.balance -= amount;
    }

    public static void transfer(Account2 act1, Account2 act2, int amount) { // снимаем деньги с act1 и передаем в act2
        act1.withDraw(amount);
        act2.deposit(amount);
    }
}
