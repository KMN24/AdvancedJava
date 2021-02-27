package multithreading.lesson19;

// todo Ключевое слово synchronized II часть
// Читай комментарии

//public void increment(){ // Этот код из прошлого урока
// synchronized(object){ ... } - это synchronized блок и то что внутри этого блока будет синхонизирован
//synchronized (this){ // this указывает на один объект test
//        counter++;      // todo Но что если мы хотим указывать на два или больше объектов
//
//        }
//}

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lesson19 {

    public static void main(String[] args) throws InterruptedException {

        new Worker().main(); // вызываем метод main() in the Class Worker
    }
}

class Worker {
    Object lock1 = new Object(); // По стандарту для мониторов имя объекта лучше назвать lock
    Object lock2 = new Object(); // И эти объекты будут указывать на мониторы

    Random random = new Random();

    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    public  void addToList1() {// убрали synchronized и создадим блок synchronized чтобы его монитор указывал на конкретный объект
        synchronized (lock1){ // Теперь один поток будет работать с одним объектом, а другой поток с другим объектом синхр-о
            try {
                Thread.sleep(1); // Каждый раз программа будет спать 1 миллисекунды
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list1.add(random.nextInt(100)); // В лист будет добавлен рандомное число от 0 до 100
        }
    }

    public void addToList2() { // убрали synchronized и создадим блок synchronized чтобы его монитор указывал на конкретный объект
        synchronized (lock2){ //
            try {
                Thread.sleep(1); // Каждый раз программа будет спать 1 миллисекунды
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list2.add(random.nextInt(100)); // В лист будет добавлен рандомное число от 0 до 100
        }
    }

    public void work() {
        for (int i = 0; i < 1000; i++) { // программа 1000 раз будет добавлять число в лист1 и лист2
            addToList1();
            addToList2();
        }
    }

    public void main() {
        long before = System.currentTimeMillis();
        //work();
        // Давайте теперь добавим метод work() на два потока

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                work();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                work();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join(); // Вызываем чтобы размер листа не показывал 0, нужно чтообы главный поток ждал пока
            thread2.join(); // остальные 2 потока закончат свою работу
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        long after = System.currentTimeMillis();
        System.out.println("Program took " + (after - before) + "ms to run");

        System.out.println("list 1 size : " + list1.size());
        System.out.println("list 2 size : " + list2.size());
        // без добавление synchronized на методы (addToList1 ,2)  размеры листов были бы разные потому что
        // не было синхронизации, если добавим то размер в листах будет по 2000 элементов

        // Но так как synchronized исп-т монитор и монитор видит только один объект в одном потоке а остальные потоки должны ждать
        // и время работы программы увеличивается, нам нужно чтобы 2 потока были на разных объектах и работали синхронно
        // Так, как наши потоки не используют одну и ту же переменную а исп-т 2 разные листы
        // Мы можем создать 2 объекта типа Object ( тип не важен главное чтобы у этого объекта был монитор)
        // И потом уберем ключевое слово synchronized из методов и создадим synchronized блоки,
        // Потому что этот synchronized блок может указывать на конкретный объект, а ключевое слово synchronized лишь указывал
        // на this объект ( в нашем случае объект new Worker)

        // Теперь мы разрешаем потокам одновременно выполнять добавление элементов к листу, так как
        // наши потоки смотрят на две разные мониторы а мониторы указывают на 2 разные объекты(lock1, lock2)

        // Тепеь отсутствует состояние гонки за потоки (race condition)
    }
}
