package lambdaExpressions.lesson33;

// Часть 5

// Создаем свой COMPARATOR с помощью  лямбда выраж. Раньше создовали через анонимный класс в предыдущих уроках
// Будем сортировать лист по размеру ( обычная сортировка сортирует по очередности букв )


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lesson33_3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("Hello");
        list.add("Goodbye");
        list.add("a");
        list.add("ab");

        /*
        list.sort(new Comparator<String>() { // 1 способ. Можем через анонимный класс сравнивать строки и тем самым сортировать
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() > o2.length())
                    return 1;
                if(o1.length() < o2.length())
                    return -1;
                else
                    return 0;
            }
        });

        System.out.println(list); // [a, ab, Hello, Goodbye]

         */
        /*
        list.sort((o1, o2) -> { // 2 способ. Можем исп-ть лямбду
            if (o1.length() > o2.length())
                return 1;
            if (o1.length() < o2.length())
                return -1;
            else
                return 0;
        });

        System.out.println(list); // [a, ab, Hello, Goodbye]

         */

        // Часть 6
        // Еще один плюс лямбды в том, что можем хранить значение лямбды в переменную

        Comparator<String> comparator = (o1, o2) -> { // 2 способ. Можем исп-ть лямбду
            if (o1.length() > o2.length())
                return 1;
            if (o1.length() < o2.length())
                return -1;
            else
                return 0;
        };
        list.sort(comparator); // и передадим наш comparator
        System.out.println(list); // [a, ab, Hello, Goodbye]
    }
}
