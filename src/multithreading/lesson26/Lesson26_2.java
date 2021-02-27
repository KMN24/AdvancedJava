package multithreading.lesson26;

// Продолжение
// на 200 потоков будет всего 10 разрешений.

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Lesson26_2 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(200); // будет 200 потоков

        Connection connection = Connection.getConnection(); // наш ситнглтон объект

        for(int i=0; i<200; i++){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        connection.work();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        executorService.shutdown();

        executorService.awaitTermination(1, TimeUnit.DAYS);
    }
}

// Singleton
class Connection{

    private static Connection connection = new Connection();
    private int connectionsCount = 0;

    private Semaphore semaphore = new Semaphore(10); // будет всего 10 разрешений

    // не можем вызвать конструктор так, как модификатор доступа private, чтобы получить объект добавим getConnection()
    // но будет сингилтон
    private Connection(){ // можем создать лишь 1 объект данного класса ( Singleton)

    }

    public static Connection getConnection(){
        return connection;
    }

    public void work() throws InterruptedException {
        semaphore.acquire(); // даем разрешение
        try{
            doWork(); // метод release должен вызываться в finally блоке, так как метод doWork() может вбросить исклю-е
            // и если не будет finally то не сработает release() при exception
        }finally {
            semaphore.release(); // передаем разрешение на другие потоки
            // даже если выбросить exception в doWork() все равно должны отпустить разрешение (release())
        }
    }

    private void doWork() throws InterruptedException {
        synchronized (this){
            connectionsCount++;
            System.out.println(connectionsCount); // число не будет преввышено 10 ти так как мы указали разрешение до 10
        }

        Thread.sleep(5000);// поспим пока добавятся немножко больше connectionsCount

        synchronized (this){
            connectionsCount--;
        }
    }
}