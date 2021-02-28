package lambdaExpressions.lesson33;

// todo Лямбда - выражения часть I
// Lambda Expression - also called "Anonymous function", a function( or a subroutine) defined, and possibly called,
// without being bound to an identifier. ( определена без привязки к идентификатору)

// Это просто простой способ передать какой-то кусок кода в метод.
// Или же лямба выражения позволяют обойтись без использования анонимных классов
// Сокращает объекм кода
// У метода есть имя, а у лябда выр-й нету так, как они анонимные функции


interface Executable{
    void execute();
}

class Runner{
    public void run(Executable e){
        e.execute();
    }
}

class ExecutableImplementation implements Executable{
    @Override
    public void execute() {
        System.out.println("Hello1");
    }
}

public class Lesson33 {
    public static void main(String[] args) {
        /* Часть 1
        Thread thread = new Thread(new Runnable() { // раньшек делали так использовали анонимный класс
            @Override
            public void run() {
                System.out.println("Hi");
            }
        });

        Thread thread1 = new Thread(() -> { // можем использовать лямбда выражение чтобы сократить код
            System.out.println("Hi");
        });

         */

        // Часть 2
        Runner runner = new Runner();
        runner.run(new ExecutableImplementation()); //1 способ. можем здесь так написать и вызвать метод run

        runner.run(new Executable() { // 2 способ. Можем прям здесь написать как анонимный класс
            @Override
            public void execute() {
                System.out.println("Hello2 ");
            }
        });

        runner.run(() -> System.out.println("Hello3") ); // 3 способ. Лябда выра-е (анономный метод)

    }
}
