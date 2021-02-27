package multithreading.lesson28;

// todo Прерывание потоков
// ПОЙМЕМ ПОЧЕМУ У НАС ВЫХОДИТ INTERRUPT EXCEPTION
// Interrupt Exception выйдет в том случае если какие-то методы выполняются в потоке, который был прерван
// т.е. на котором был вызван thread.interrupt()

import javax.print.attribute.standard.RequestingUserName;
import java.util.Random;

public class Lesson28 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                for(int i=0; i<1_000_000_000; i++){ // найти синус 1 млрд будет очень долго поэтому мы специально остановим
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) { // выбрасет Interrupted Exception так, как мы хотим поспать уже
                        // был прерван
                        e.printStackTrace();
                        System.out.println("Thread was interrupted but you want to do sleep in already interrupted thread");
                    }
                    // цикл через thread.interrupt() - после thread.start()
                    /* // чтобы сработал этот код убери на вверху код try-catch, так как они продолжение (часть 2)
                    if(Thread.currentThread().isInterrupted()){
                        System.out.println("Thread was interrupted");
                        break; // выйдет из цикла
                    }
                    Math.sin(random.nextDouble());
                    */
                }
            }
        });

        System.out.println("Starting thread");
        thread.start();
        Thread.sleep(1000);
        //thread.stop(); // Deprecated method - плохой метод, не советуется разработчиками, так, как убивает поток сразу

        // Если вызовится interrupt() то он отпрвит сообщ-е к isInterrupted() -> true. Что значит мы хотим остановить поток.
        thread.interrupt(); // есть такой метод но он не убивает поток, но мы даем потоки сообщение что мы хотим
        // остановить поток, поэтому лучше исп-ть interrupt() чем stop().
        // interrupt() должен вызваться до join() так, как join() будет ждать окончание потока

        thread.join();
        System.out.println("Ending thread");
    }
}
