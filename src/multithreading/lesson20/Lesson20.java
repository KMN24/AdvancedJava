package multithreading.lesson20;

// todo Пул потоков Thread pool

// Скажем так у нас есть 2 работника и 5 каробок, нужно чтобы работники перенесли коробки с одного места в другую.
// И работники будут работать параллельно и берут по одной коробке и переносять.
// Кто-то работает быстрее, тот который работает быстрее он идет за слудуещей коробкой. Тот который работает медленнее
// он тоже дет за слудуещей коробкой. И вот они так работают паралелльно.

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Lesson20 {
    public static void main(String[] args) throws InterruptedException {

        // Thread pool - пул потоков, некое множество потоков

        // Executor Service - Сервис по выполнению, другими словами это и есть пул потоки
        ExecutorService executorService = Executors.newFixedThreadPool(2); // pull потоки

        for(int i=0; i<5; i++){ // у каждого задания будет свой уникальный id
            executorService.submit(new Work(i));
        }
        executorService.shutdown(); // начнет выполнять те задания которые мы передали через метод submit(object)
        System.out.println("All task submitted");

        executorService.awaitTermination(1, TimeUnit.DAYS); // Главный поток 1 день будет ждать пока все потоки завершаться
        // Если после 1 дня потоки все еще не завершат работу то главный поток продолжит свою работу
    }
}

class Work implements Runnable{

    private int id;
    public Work(int id){
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Work " + id + " was completed");
    }
}