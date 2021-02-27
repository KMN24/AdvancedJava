package multithreading.lesson29;

// todo Callable и Future
// Эти классы нам возвращают значение из потоков и позволяют выбрасывать исключения из потоков

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Lesson29 {

    private static int result;

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(new Runnable() {
            @Override
            public void run() { // run не возвращает значение
                // и чтобы хоть как то возвращать значение мы создаем статическую переменную
                // но МЫ могли бы использовать Callable
                // Именно Callable сделаем в Lesson29_2.java
                System.out.println("Starting");
                try {
                    Thread.sleep(3000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("Finished");
                result = 5; // так как run() не возвращает значение мы использовали статическую переменную
            }
        });

        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(result);

    }

    public static int calculate(){
        return 5+4;
    }
}
