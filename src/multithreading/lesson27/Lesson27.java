package multithreading.lesson27;

// todo Взаимная блокировка Deadlock

import java.util.Random;

public class Lesson27 {
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

class Runner {

    private Account account1 = new Account();
    private Account account2 = new Account();

    public void firstThread() {
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            // Если в первом synchronized был account2 то был бы DeadLock ( программа зависла бы)
            // О DeadLock поговорим еще в Lesson27_2.java
            synchronized (account1) { // НО ТАКИЕ ВЛОЖЕННЫЕ БЛОКИ НЕ ПРИВЕТСТВУЕТСЯ В JAVA ИЗМЕНИМ НАЩ КОД В Lesson27_2.java
                synchronized (account2) {
                    // здесь поток можот безопасно изменять данные счетов

                    // передаем рандомное число денег с 1 акк на 2 акк
                    Account.transfer(account1, account2, random.nextInt(100));
                }
            }
        }
    }

    public void secondThread() {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            synchronized (account1) {
                synchronized (account2) {
                    // здесь поток можот безопасно изменять данные счетов
                    // передаем рандомное число денег с 2 акк на 1 акк
                    Account.transfer(account2, account1, random.nextInt(100));
                }
            }
        }
    }

    public void finished() {
        System.out.println(account1.getBalance());
        System.out.println(account2.getBalance());
        System.out.println("Total balance = " + (account1.getBalance() + account2.getBalance())); // должно быть 20000
    }
}

class Account {
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

    public static void transfer(Account act1, Account act2, int amount) { // снимаем деньги с act1 и передаем в act2
        act1.withDraw(amount);
        act2.deposit(amount);
    }
}

// НО ТАКИЕ ВЛОЖЕННЫЕ БЛОКИ (synchronized) НЕ ПРИВЕТСТВУЕТСЯ В JAVA ИЗМЕНИМ НАЩ КОД В Lesson27_2.java