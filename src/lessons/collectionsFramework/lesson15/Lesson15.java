package lessons.collectionsFramework.lesson15;

// todo Интерфейс Iterable
// Iterable - это то в чем можно итерироваться. Н: цикл for ( for each)

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lesson15 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);

        // todo Различие между iterator и forEach в том, что iterator может одновременно итерироваться по элементам и удалять
        //  forEach - НЕ может одновременно итерироваться и удалять элементы

        Iterator<Integer> iterator = list.iterator();
        // До Java5 использовали так, Java нам подсказывает что лучше использовать forEach
        while (iterator.hasNext()){ // return true if there are elements in iterator, else - otherwise
            System.out.println(iterator.next()); // 1 , 2 , 3
            // next() работает так => сначала он смотрит какое-то пространство до первого элемента
            // head [1, 2, 3]
            // до вызова next() итератор будет стоят на head а когда вызовим то он будет смотреть на первый элемент
            // может одновременно итерироваться и удалять элементы
            iterator.remove();// НО не может принимать аргумент, удаляет тот который указывает указатель iterator
        }
        System.out.println(list); // [] - как мы видим iterator может одновременно удалять и итерироваться

        // Цикл forEach использует внутри себя iterator
        for( int x : list2){ // Цикл forEach появился в Java5, немножко различается от простого for
            System.out.println(x); // 1 , 2 , 3
            //list.remove(1); // Exception. ConcurrentModificationException,
            // НЕ может одновременно итерироваться и удалять элементы, НО может принимать аргумент
        }
        System.out.println(list2); // [1, 2, 3]


        ArrayList<Integer> arrayList = new ArrayList<>();
        Iterator<Integer> iterator1 = arrayList.iterator(); // Вот здесь мы можем посмотреть код iterator()

        // Если в нашем собственном классе нужно будет итерироваться то нужно имплементироваться от Iterable



    }
}
