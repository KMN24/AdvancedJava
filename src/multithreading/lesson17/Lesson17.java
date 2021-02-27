package multithreading.lesson17;

// todo Ключевое слово volatile

import java.util.Scanner;

public class Lesson17 {
    public static void main(String[] args) {

        MyThread myThread1 = new MyThread();
        myThread1.start();

        // Мы постараемся отключить поток
        // Для этого создадим переменную типа boolean и функцию в классе MyThread

        // В консоли будут ждать когда же мы нажмем на Enter
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); // Лишь когда мы нажмем на Enter в консоли тогда и закончится бесконечный цикл
        myThread1.shutDown();
        // В большенстве случаев это работает

        // Этот код может не сработать по причине плохой когерентции кешей
        // todo Cache Coherency
        /*
            CPU             CPU
             |               |
            Cache          Cache       Main Memory
             |               |              |
             |               |              |
                            Bus
         */

        /*
        CPU - это поток и у каждого потока есть свой кеш
        Кеш - это участок памяти и она очень маленька в МБ. Но зато очень быстрая даже чем оперативка.
        И в кеш попадают лишь очень важные элементы.
        Н: наш boolean хранится в одном потоке (кеше) как true
         а вдругом как false и поэтому наши кеши не когерентны
         И наш поток myThread не остановится.
         НО современных процессоров когерентность кешей работают хорошо они переодически попадают в MainMemory и там
         обмениваются значениями т.е. обновляется.

         НО это может и не работать, для этого мы сами должны связать наши потоки и для этого нам приходит
         в помощь VOLATILE - изменчивый, подверженный изменению
         */

        // Для этого нам нужно добавить в переменную ключевое слово volatile
        // Volatile - не будет хранить переменную в кеше а добавляет переменную в MainMemory ( в главную память),
        // а когда нужна будет то и потоки будут брать из главной памяти

    }
}

class MyThread extends Thread{
    private volatile boolean running = true;
    @Override
    public void run() {
        while (running){ // бесконечный цикл
            System.out.println("Hello");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void shutDown(){ // с помощью этой функции остановим бесконечный цикл
        this.running = false;
    }}
