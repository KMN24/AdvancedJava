package multithreading.lesson29;

// Продолжение
// todo Callable и Future
// Эти классы нам возвращают значение из потоков и позволяют выбрасывать исключения из потоков

import java.util.Random;
import java.util.concurrent.*;

public class Lesson29_2 {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        //todo С помощью интерфейса Future мы сохраняем ссылаемое возвращаемое значение от метода call()
        // Через future.get() можно получить значение, так как future это объект ссылаемое на значение
        Future<Integer> future =  executorService.submit(new Callable<Integer>() {
            //todo С помощью интерфейса Callable и переопределим метод call()
            // Тип можем выбрать любой, call() возвращает тот тип который мы указали в Callable
            @Override
            public Integer call() throws Exception { // воз-т Integer
                System.out.println("Starting");
                try {
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("Finished");
                Random random = new Random();
                int randomValue = random.nextInt(10);
                if(randomValue < 5){ // так как плюс future что он может выбрасить исключение
                    throw new Exception("Some exception happened");
                }
                return randomValue;
            }
        });

        executorService.shutdown();

        try {
            int result = future.get(); // todo через get() получаем значение
            // get() - доожидается окончания выполнения потока
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) { // здесь поймает тот самый exception который мы вызвали вверху
            Throwable ex = e.getCause(); // Узнает причину возникновение exception
            System.out.println(ex.getMessage());
            System.out.println("Returning number less to 5");
        }

    }
}
