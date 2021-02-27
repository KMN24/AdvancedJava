package multithreading.lesson24;

// todo Класс CountDownLatch
// в пакете concurrent есть много способов сделать син-ию
// И есть классы которые же синхрони-ы и не нужно исп-ь synchronized, потому что эти классы уже потокобезопасны
// Обычно исп-т эти классы нежели synchronized и внутри писать wait() and notify()

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Lesson24 {
    public static void main(String[] args) throws InterruptedException {
        // CountDownLatch - в переводе защелка обратного отсчета ( latch - защелка, запор, count down - отсчет назад)
        CountDownLatch countDownLatch = new CountDownLatch(3); // количество отсчета пока защелка нам оттопрется
        // Мы должны 3 раза отсчитать пока наша защелка оттопрется, до тех пор наша защелка будет закрыта
        // В общем countDown() должен вызевится всего 3 раза

        ExecutorService executorService = Executors.newFixedThreadPool(3); // 3 потока

        for(int i=0; i<3; i++){
            executorService.submit(new Processor(countDownLatch)); // 3 потокам дали задания
            // Задание состоит в том, что в качестве аргумента конструктора передаем countDownLatch
            // и этом latch'е вызываем countDown(); - который декреминтирует его на единицу
        }

        executorService.shutdown(); // чтобы дать понять что больше не добавим новых работ (submit)

        // await - будет ждать пока countDown() не будет равен 0. Т.е. пока защелка не откроется
        countDownLatch.await(); // в общем 4 потока : main  и 3 остальные
        // наш главный поток будет ждать пока защелка не откроется
        System.out.println("Latch has been opened, main thread is proceeding");

        // Здесь наш главный поток ждал пока 3 остальные потоки делали работу,
        // А теперь посмотрим что если наш главный поток будет работать а 3 остальные потоки будут ждать окончание отсчета
        // ПРОДОЛЖЕНИЕ В Lesson24_2.java
    }
}

class Processor implements Runnable{

    private CountDownLatch countDownLatch;

    public Processor(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        countDownLatch.countDown(); // -- декримент
    }
}

