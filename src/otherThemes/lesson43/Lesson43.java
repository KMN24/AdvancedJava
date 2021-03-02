package otherThemes.lesson43;

// todo Рефлексия (Java Reflection API). Часть II

//                  Что еще можно делать с помощью рефлексии в Java?
//  Для объекта класса Class:
//      *Создавать новые объекты класса (по умолчанию вызывает пустой конструктор) - newInstance()
//      Получать методы по сигнатуре - getMethod(...)
//      Получать конструктор по сигнатуре - getConstructor(...)
//
//  Для объекта класса Method:
//      Вызывать методы - invoke()
//      И многое другое...

//  *Метод newInstance() можно вызывать не только на объектах класса Class, но и на объектах класса Constructor.

//                  Как получить метод по сигнатуре?
// Сигнатура метода в терминах рефлексии это имя и набор типов параметров.
// Н:
/*
    Class stringClass = String.class;
    Method m = stringClass.getMethod( "indexOf", String.class, int.class);
    System.out.println(m);
 */

// Для второго аргумента у метода getMethod() исп-ся Java varargs - можно передать любое число аргументов.


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Lesson43 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {

        Scanner scanner = new Scanner(System.in);
        // Что мы будем вводить: otherThemes.lesson43.Person java.lang.String setName
        // Название_класса1 Название_класса2 Название_метода
        Class classObject1 =  Class.forName( scanner.next()); // scanner.next() - 1 строчка до пробела, forName() - создает объект соот-го класса
        Class classObject2 =  Class.forName( scanner.next()); //  1 строчка от первого пробела до следуещего пробела
        String methodName =  scanner.next(); // 1 строчка от 2 пробела до 3 го

        Method m = classObject1.getMethod(methodName, classObject2);

        Object o1 = classObject1.newInstance();
        Object o2 = classObject2.getConstructor(String.class).newInstance("String value"); // Конструктор принимает на вход строку

        m.invoke(o1, o2);

        System.out.println(o1);
        // scanner пример
//java.lang.Thread java.lang.String setName
    }
}
