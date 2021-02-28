package collectionsFramework.lesson2_3;

// TODO Динамический массив ArrayList - Как устроен - Lesson 2
// TODO Связный список LinkedList - Введение - Lesson 3

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lesson2_3 {
    public static void main(String[] args) {

        List<Integer> linkedList = new LinkedList<>();
//        linkedList.add(1);
//        System.out.println( linkedList.get(0) +" " +  linkedList.size());
//        linkedList.remove(0);

        List<Integer> arrayList = new ArrayList<>();
        measureTime(linkedList); // посмотрим на время выполнения Linked List
        measureTime(arrayList); //  посмотрим на время выполнения Array List
        // array list почти два раза быстрее добавит элементы
    }

    private static void measureTime(List<Integer> list){
        long start = System.currentTimeMillis(); // вернет текущее время в милли секундах

//        for (int i=0; i<100000; i++){
//            list.add(i); // array list почти в 2 раза быстрее записывает элементы
//        }
        // [] -> [0][1] -> [0][1][2]  -> каждый раз новое число добавляется в конец листа
        // но мы можем добавить элементы в любой индекс

        for(int i=0; i<100000; i++){
            list.add(0, i); // linked list почти в 50 раз быстрее добавит на конкретный индекс
        }
        // list.add(0, i); // здесь добавляем элемент в индекс 0
        // [] -> [0] -> [1][0] -> [2][1][0] -> и т.д.

//        for (int i=0; i<100000; i++){
//            list.get(i); // array list в 1000 раз быстрее берет элементы
//        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

}
