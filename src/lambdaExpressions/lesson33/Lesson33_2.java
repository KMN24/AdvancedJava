package lambdaExpressions.lesson33;

// Продолжение Lesson33.java
// Часть 3 мы увидим как нужно возвращать значение из lambda expression
// Часть 4 и как принимать параметры в лямбде

interface Executable2{
    int execute(int x, int y);
}

class Runner2{
    public void run(Executable2 e){
        int a = e.execute(10, 15);
        System.out.println(a);
    }
}

public class Lesson33_2 {
    public static void main(String[] args) {

        Runner2 runner2 = new Runner2();

        int b = 24;
        //b = 2; не можем изменить если изменим то не можем исп-ть в анонимном классе
        //нужно чтобы начальное значение переменной не изменялся или же пере-я должна быть final (константой)
        runner2.run(new Executable2() {
            @Override
            public int execute(int x, int y) {
                System.out.println("Hello1 ");
                int b = 4; // а в анонимных классах есть своя собственная область видимости (scope)
                return x+y+1+b;
            }
        });

        int a = 24;
        //a = 2; // если мы хотим использовать переменную в лямбде то нужно чтобы начальное значение переменной
        // не изменялся или же пере-я должна быть final (константой)

        // мы можем и не писать типы параметров в лямбда выражении так, как он знает
        runner2.run((x, y) -> { // в лямбда не пишем возвра-й тип, он сам понимает какой тип нужно возвращать, так, как он переопределяет
            // другой метод и у этого метода есть тип и лямбда смотрит на тип этого метода
            System.out.println("Hello2");
            //int a = 4; // не можем создать внутри переменную уже созданную в внешнем блоке ( в той в которой была созданга дямбда
            // в нашем случае scope - это мотод main. У лямбды нету своей собственной области видимости (scope)
            int c =2; // но можем создать новую переменную и использовать ее
            return x+y+2+a;
        });

    }
}
