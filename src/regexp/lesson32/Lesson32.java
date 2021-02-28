package regexp.lesson32;

// todo Классы Pattern и Matcher
// До этого мы просто исп-ли регулярные выражения класса String. Но есть и 2 класса которые могут принимать regexp: Pattern and Matcher
// У этих классов много методов чтобы работать с regexp
// Pattern - представляет из себя само регулярное выражение, поместим его в класс Pattern
// Matcher - он исппользует наш Pattern для того, чтобы проводить операции над текстом (строкой)

// Самое нужное использование классов Pattern и Matcher, это поиск паттернов в тексте, т.е. поиск совпадение в тексте
// Н: у нас есть текст и нужно найти все адреса электронных почты.

// Мы можем составит паттерн и этот паттерн у нас будет представлять из себя адрес элек-х почты.
// Этот паттерн мы выразим с помощью регулярных выражений. И в Matcher'е исп-м этот паттерн.
// Так мы найдем все строки которые совподают с паттерном

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lesson32 {
    public static void main(String[] args) {
        String text = "Hello, Guys! I send you my email joe@gmail.com so we can\n" +
                "keep in touch. Thanks, Joe! That's cool. I am sending you\n" +
                "my address: tim@yandex.ru. Let's stay in touch...";

        Pattern email = Pattern.compile("(\\w+)@(gmail|yandex)\\.(com|ru)"); // не можем создовать объект Pattern так как конструктор приватный
        Matcher matcher = email.matcher(text);

//         while (matcher.find()){ // найдем наш email
//             System.out.println(matcher.group()); // group() - получаем это совпадение
//                // joe@gmail.com
//                // tim@yandex.ru
//         }

        /*
            Нумерация id начинается с 1 а не 0 и идет слева на направо Н:
            -----------------------------------------------------------------------------
            группы |  ()()()   |        (1 (2)(3) )                    |       (1 (2) ) (3)
            -----------------------------------------------------------------------------
                                            1   - самый внешний     |          1-внешний    3-отдельная группа
            id     |  1 2 3    |           2 3  - внутренние        |          2-внутренний
            -----------------------------------------------------------------------------
         */

        // group() - может принимать id группы и вывести соот-ю группу в тексте
        // Группы - это те выражения которые мы написали в круглых скобках ()
        // Одна () - это 1 группа
        // (\\w+)@(gmail|yandex)\\.(com|ru) - здесь у нас 3 группы

        // Например если нам нужен только логин без @gmail или @yandex, то можем в качестве аргумента дать id группы

//        while (matcher.find()){
//            System.out.println(matcher.group(1));
//                //joe
//                //tim
//        }

        // а теперь если мы хотим сайты
        while (matcher.find()){
            System.out.println(matcher.group(2));
            //gmail
            //yandex
        }
        // если id=3 -> com, ru

        //

    }
}
