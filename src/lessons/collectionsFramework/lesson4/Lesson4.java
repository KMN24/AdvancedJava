package lessons.collectionsFramework.lesson4;

// TODO Связный список LinkedList - Как устроен

import java.util.LinkedList;
import java.util.List;

public class Lesson4 {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        // есть два вида Linked List 1) Односвязный(Single LL)  и  2) двусвязный (double LL)
        // в дваже исп двусязный LL
        // Single LL - имеет ссылку только на сfледующий элемент
        // Double LL - имеет ссылку на предыдущий и следующий элементы

        // в LL сначала идет HEAD -> потом 0 индекс -> 1 индекс и т.д.
        // В Double LL мы можем получить элементы с конца листа, так как есть ссылка на предыдущий элемент
        // а в Single LL только от начала (HEAD) идем к нужному элементу

        // Здесь мы создадим наш собственный MyLinkedList

        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(10);

        System.out.println(myLinkedList);
        System.out.println(myLinkedList.get(0));
        System.out.println(myLinkedList.get(1));
        System.out.println(myLinkedList.get(2));

        myLinkedList.remove(1);
        System.out.println(myLinkedList);
        myLinkedList.remove(1);
        System.out.println(myLinkedList);
        myLinkedList.remove(0);
        System.out.println(myLinkedList); // пусто
        System.out.println();


    }
}
