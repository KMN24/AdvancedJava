package multithreading.lesson16;

// todo Введение в многопоточность в Java

class MyThread extends Thread{
    @Override
    public void run() {
        for ( int i =0; i< 10; i++){
            System.out.println("Hello from MyThread " + i);
        }
    }
}

public class Lesson16 {
    public static void main(String[] args) throws InterruptedException {
        // Часть 1
        //  works in parallel
        // Java сам распределяет операции на потоки

        // Сначала у нас будет только один поток main
        // todo Мы можем создовать новые потоки для этого

        /*
        MyThread myThread1 = new MyThread();
        myThread1.start(); // Нужно вызвать метод start() а не run()
        //todo start() - создает новый поток и выполняет то, что описано в методе run()
        // метод run() не нужно вызывать, метод start() запускает run()

        System.out.println("Hello from main thread"); // первым выйдет до myThread1

        for(int i=0; i<10; i++){
            System.out.println("main thread " + i); // вторым выйдет
        }

        // уж потом выйдет myThread1
        // Потому что ротоки которые создавались в main потоке они не гарантируют что будут работать синхронно
        // Потоки борятся за оперативность

        MyThread myThread2 = new MyThread();
        myThread2.start();

        // Запускаем потки myThread1 и myThread2 в потоке main и они борятся за поточность

         */


        // Часть 2
        System.out.println("I'm going to sleep");
        Thread.sleep(3000);
        // метод sleep() выбрасывает исключение InterruptedException. Мы должны обработать exception или выкинуть в методе.
        // Когда в методе main() доходит до этой строчки кода, то поток main засыпает и  ждет 3000 миллисекунды

        System.out.println("I'm awake"); // Все это выполняется в главном потоке и как мы видим,
        // Сначала выводится I'm going to sleep и ждет 3 секунды и выходит I'm awake

        // Все потоки равносильные

    }
}
