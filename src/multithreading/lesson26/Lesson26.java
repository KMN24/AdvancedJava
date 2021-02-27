package multithreading.lesson26;

// todo Семафор Semaphore
// Изучаем классы в пакете java.util.concurrent
// Этот класс исп-ся в том случае если у нас есть какой-то ресурс и много потоков которые исп-т этот ресурс.
// и мы исп-м class Semaphore когда хотим ограничить доступ к этому ресурсу.
// Н: у нас есть сервер, и 10 потоков пишут в этот сервер ( отправляют данные).  Сервер - ресурс, само соединение с сервором тоже ресурс.
// Т.е. пропускная способность кабеля ограничена, мы должны делить этот ресурс между потоками.


import java.util.concurrent.Semaphore;

public class Lesson26 {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3); // сколько потоков могут одновременно писать
        // В нашем случае максимум 3 потока могут отправлять данные на сервер

        try {
            semaphore.acquire(); // вызываем когда начинаем рабтать с ресурсом
            // если количество доступных раз-й будет 0, то наш метод acquire() будет ждать когда вызовут release()
            semaphore.acquire();
            semaphore.acquire();

            System.out.println("All permits have been acquired");

            semaphore.acquire(); // вызовем в 4 раз, но доступа нет так как все раз-я недоступны
            // чтобы этот acquire() сработал нужно в каком-то потоке вызвать release() чтобы дать разрешение
            System.out.println("Can't reach here..."); // эта запись не выведится на экран так как остановится в acquire()
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(semaphore.availablePermits()); // возвращает количество доступных разрешений

        semaphore.release(); // исп-м когда поток закончил работать с ресурсом, чтобы другие потки могли работать с ресурсом
        // так как лишь 3 потока могут одновременно исп-ть ресурс, а другие будут ждать разрешения
        // release() - и дает нам разрешения

        // А теперь сделаем наш пример с сервером
        // Сделаем это в Lesson26_2.java

    }
}


