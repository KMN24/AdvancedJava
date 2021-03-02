package otherThemes.lesson42;

// todo Рефлексия (Java Reflection API). Часть I
//Рефлексия - простая тема, но может быть вначале придется немного поломать голову, чтобы понять концепцию

// Для начала вспомним что есть в классе:
// name, package name, List of attributes, List of methods...

// Все классы, которые мы создавали в Java (и встроенные классы тоже) можно рассматривать как экземпляры (объекты) класса Class.
// Значит, все инструменты ООП мы можем применить к самим классам как к сущностям.
// (Рассматриваем класс как объект класса Class и работает с ним как с обычным объектом в Java)
//Это и называется рефлексией!

// Н: class Class:

//  class Class {
//      String name;
//      String packageName;
//      List<Attribute> attributes;
//      List<Method> methods;
//  }

// Служебный класс, экземпляры которого (Java классы) хранят конкретную информацию о конкретном классе.
//Уже реализован в чама (Reflection API)

//              Как получить доступ к объекту класс Class?
// Классу (пусть это MyClass):
//      Class c = MyClass.class;
// Объекту (пусть о - экземпляр класса MyClass):
//      Class c = obj.getClass();
// Названию класса (пусть полное имя класса: kg.kanatbekov.MyClass):
//      Class c = Class.forName("kg.kanatbekov.MyClass"); // kg.kanatbekov - это пакет(package)

//              Получить все методы
/*
    public class TestReflection {
        public static void main(String[] args) {
           Class personClass = Person.class; // Person - это просто наш созданный класс ( любой класс)
            Method[] methods = personClass.getMethods(); // и мы можем взять все методы нашего класса
            for (Method method : methods) {
                System. out.println(method.getName());
                System. out.println(method.getReturnType());
                System. out.println(Arrays.toString(method.getParameterTypes()));
            }
        }
    }
 */
// Method - это тоже класс. Методы, которые мы объявляем в классе - это экземпляры (объекты) класса Method

//                          Получить все поля
/*
    public class TestReflection {
        public static void main(String[] args) {
           Class personClass = Person.class;
            Field[] fields = personClass.getFields(); // Но будут возвращены только public поля, читай внизу есть чтобы вызвать private поля
            for (Field field : fields) {
                System. out.println(field.getName());
                System. out.println(field.getReturnType());
                System. out.println(Arrays.toString(field.getParameterTypes()));
            }
        }
    }
 */
// Field - это тоже класс. Поля, которые мы объявляем в классе - это экземпляры (объекты) класса Field.

// Рефлексия учитывает инкапсуляцию, поэтому будут возвращены только public поля.
// Рефлексия может не учитывать инкапсуляцию, тогда будут возвращены все поля (даже private). Делается это с помощью
// методов, которые имеют Declared в названии.
//      Field[] fields = personClass.getDeclaredFields();
//* Это используется в Spring Framework для аннотации @Autowired

//                  Проверка аннотация
/*
    public class TestReflection {
        public static void main(String[] args) {
           Class cv = Person.class;
            Annotation[] annotations = cv.getAnnotations();
            for (Annotation annotation : annotations) {
                if( annotation instanceof Author){
                    System. out.println("Yes");
                }
            }
        }
    }
 */
// Проверяем, что класс Person аннотирован @Author - если да, то выводим Yes

//


import otherThemes.lesson41.MethodInfo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Lesson42 {
    public static void main(String[] args) {

        Person person = new Person();

        Class personClass = Person.class; //1 способ. получаем объект (Person.class) класса Class
        Class personClass2 = person.getClass(); //2 способ. получаем объект класса Class
        try {
            Class personClass3 = Class.forName("otherThemes.lesson42.Person"); // 3 способ
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        /*
        // Получаем методы
        Method[] methods = personClass.getMethods();
        for (Method method : methods){
            System.out.println(method.getName() +", "+ method.getReturnType() + ", " +
                    Arrays.toString(method.getParameterTypes()) );
        }

         */

        /*
        // Получаем private поля
        Field[] fields = personClass.getFields();
        for (Field field : fields){
            System.out.println(field.getName() +", "+ field.getType() ); // ничего не выводит так, как все поля у нас private
        }
         */

        // Получаем все поля
        Field[] fields = personClass.getDeclaredFields();
        for (Field field : fields){
            System.out.println(field.getName() +", "+ field.getType() );
        }

        //  Получим все аннотации
        Annotation[] annotations =  personClass.getAnnotations();
        for(Annotation annotation : annotations){
            if(annotation instanceof Author){ // Если наша annotation экземпляр Author то выведи Yes
                System.out.println("Yes");
            }
        }
    }
}
