package multithreading.lesson18;

// todo Ключевое слово synchronized I часть


public class Lesson18 {

    private int counter=0;

    public static void main(String[] args) throws InterruptedException {

        // volatile - когда ОДИН поток пишет, а другие читают.
        // Таким образом потоки синхронизируются, и переменная не кэшируется, а сохроняется
        // в главной памяти.
        // Но что если мы хотим чтобы записывали несколько потоков то тогда volatile не будет работать.

        // Нам нужно ключовое слово synchronized

        Lesson18 test = new Lesson18();
        test.doWork(); // 2 потока будут перезаписовать на одну переменную

    }

    public synchronized void increment(){ // synchronized исп-ся только для методов
        counter++;
    }

    // todo  Атомарность - нечто не делимое, когда операция у нас занимает 1 такт времени,
    //  т.е. когда операция потоке работает за 1 такт времени

    public void doWork() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() { // анонимный класс
            @Override
            public void run() {
                for(int i=0; i<10000; i++){
                    //counter++; // не атомарный, так как здесь 3 такта операции
                    // counter = counter + 1; // 3 такта операции: 1) берет знач  2) увеличивает  3)записывает

                    increment();

                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<10000; i++){
                    //counter++;
                    increment();
                }
            }
        });

        thread1.start();
        thread2.start();
        // todo join()
        thread1.join(); // главный поток будет ждать пока поток thread1 не закончит работу
        thread2.join(); // главный поток будет ждать пока поток thread2 не закончит работу

        System.out.println(counter); // Посмотрим конечный результат
        // Но как мы видим занчение выходят по разному кроме 0 и потоки не связаны между собой и не синхронизированы
        // Для того, чтобы исправить это состояние гонки ( race condition) есть ключевое слово synchronized

        // Добавим в переменную ключевое слово synchronized
        // todo НО synchronized можем писать только для методов

        // Так что counter++; изменим на метод increment()
        // Теперь значение count всегда будет 20 000

        //todo synchronized - говорит что за один момент времени лишь один поток может работать
        // Как только один поток завершит метод тогда уж и второй поток начнет, а до тех пор 2 поток будет ждать

        // 1.Thread : 0 -> 1 -> 2 -> 3 -> 4 -> 8 -> 9
        // 2.Thread : 1 -> 5 -> 6 -> 7 -> 10 -> 11 -> 12 и т.д.

        // Когда создается объект, то объекту присваевается сущность - монитор (Monitor Log)
        // И synchronized исп-т именно эту сущность
        // Synchronized нужен объект, в нашем случае test
        // И Synchronized исп-т monitor log, монитор видит все поля и методы класса
        // Monitor log - работает за один момент только для одного объекта
        // т.е. работает только с одним потоком и он связан с объектом, поэтому другие потоки не взаимодействуют
        // с этим объектом. Они должны ждать.



    }

}
