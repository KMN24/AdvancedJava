package collectionsFramework.lesson11;

//todo  Интерфейс Comparator

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lesson11 {
    public static void main(String[] args) {

        // Часть 1
        // На этом уроке мы изучим как сортировать Java Коллекции
        // Мы будем исп-ть те коллекции которые можно как то отсортировать: ArrayList, LinkedList, TreeSet, TreeMap ...

        // Для сортирования будем исп-ть класс Collections, но сортировка идет по умол-ю по возростанию


        List<String> animals = new ArrayList<>();
        animals.add("elephant");
        animals.add("cat");
        animals.add("dog");
        animals.add("ab");
        animals.add("bird");
        animals.add("a");
        animals.add("frog");

        //System.out.println(animals); // [cat, dog, bird, frog]
        //Collections.sort(animals); // Наши объекты отсортированы по лексикографическому порядку A,B,C...Z, a,b,c...z
        //System.out.println(animals); // [bird, cat, dog, frog]

        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(0);
        numbers.add(500);
        numbers.add(100);

        //System.out.println(numbers); // [5, 0, 500, 100]
        //Collections.sort(numbers); // Отсортированы по воз-ю, по умолчанию
        //System.out.println(numbers); // [0, 5, 100, 500]

        // Часть 2
        // todo НО если мы хотим отсортировать СТРОКУ по другому ( Н: по длине )  мы должны исп-ть интерфейс Comparator
        // для этого нужно создать класс и наследовать от интерфейса Comparator и в данном классе переопределить метод compare

        // В нашем случае будем сравнивать строки по длине
        // Для этого в методе sort в качестве второго аргумента передаем Comparator ( в нашем случае new StringLengthComparator())

        System.out.println(animals); // [elephant, cat, dog, ab, bird, a, frog]
        Collections.sort(animals, new StringLengthComparator()); // сравнение идет по длине строки
        System.out.println(animals); // [a, ab, cat, dog, bird, frog, elephant]

        // Теперь для типа int сделаем сравнение
        // Мы хотим сортировать по убыванию, для этого создадим класс Comparator, т.е. Изменим тип аргумента интерфейса

        //System.out.println(numbers); // [5, 0, 500, 100]
        //Collections.sort( numbers, new BackWardsIntegerComparator() );
        //System.out.println(numbers); // [500, 100, 5, 0]

        // Часть 3
        // Но для того чтобы сортировать мы создаем класс и пишем больше кода для того чтобы сократить код мы можем в качестве
        // второго аргумента sort исп-ть анонимный класс

        System.out.println(numbers); // [5, 0, 500, 100]

        Collections.sort(numbers, new Comparator<Integer>() { // Но если еще больше хотим сократить код то можем
            // исп-ть лямбду функцию но мы изучим лямбду в следующих уроках
            @Override
            public int compare(Integer o1, Integer o2) {
                if( o1 > o2 )
                    return -1; // по умол-ю было 1, потому что сортировал по возрастанию, а мы хотим по убыванию
                else if( o1 < o2 )
                    return 1; // по умол-ю было -1
                else return 0;
            }
        });

        System.out.println(numbers); // [500, 100, 5, 0]

    // Часть 4 в следующем классе Lesson11_2.java
    }
}

class StringLengthComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) { // Наш метод будет сортировать по длине строки
        // Две строки сравниваются и возращается конвенсия
        /* Конвенсия
            o1 > o2 => 1; Если o1 больше o2 то воз-ся 1
            o1 < 02 => -1;
            o1 == o2 => 0;
         */

        if( o1.length() > o2.length() )
            return 1;
        else if( o1.length() < o2.length() )
            return -1;
        else return 0;
    }
}

class BackWardsIntegerComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        // В джаве сортировка исп-т алгоритм быстрой сортировки (quick sort)
        if( o1 > o2 )
            return -1; // по умол-ю было 1, потому что сортировал по возрастанию, а мы хотим по убыванию
        else if( o1 < o2 )
            return 1; // по умол-ю было -1
        else return 0;
    }
}


