package lessons.collectionsFramework.lesson13;

// todo Очередь Queue

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Lesson13 {
    public static void main(String[] args) {

        Person person1 = new Person(1);
        Person person2  = new Person(2);
        Person person3 = new Person(3);
        Person person4 = new Person(4);

        Queue<Person> people = new LinkedList<>();
        people.add(person3);
        people.add(person2);
        people.add(person4);
        people.add(person1);

        System.out.println(people); // [Person{id=3}, Person{id=2}, Person{id=4}, Person{id=1}]
        for (Person person : people)
            System.out.println(person);
/*
             Person{id=3}
             Person{id=2}
             Person{id=4}
             Person{id=1}
 */

        Queue<Person> people2 = new ArrayBlockingQueue<Person>(2); // Аргумент всегда должен быть - макс количество очереди
        // Если у нас очередь будет больше чем 2 то не остальные не добавятся
        people2.add(person3);
        people2.add(person2);
        //people2.add(person4); // ОШИБКА IllegalStateException: Queue full
        //people2.add(person1); // Ошибка

        System.out.println(people2); // [Person{id=3}, Person{id=2}]

        System.out.println(people.remove()); // Person{id=3} - удалится главный узел стоящий в очереди
        System.out.println(people); // [Person{id=2}, Person{id=4}, Person{id=1}]

        System.out.println(people.peek()); // Просто возмет главный элемент НО не удалит => Person{id=2}
        System.out.println(people); // [Person{id=2}, Person{id=4}, Person{id=1}]
        // Как мы видим peek() не удалил элемент просто покажет (посмотрит) и все peek - заглянуть, посмотреть


        /*
            // todo методы Queue и их различия.

               // Н: add(e) и  offer(e) делают одно и тоже, парные методы,
                 но различия в том, что при ошибке выдает add() - Throw Exception а offer() - возвращает значение.
                 Есть и другие парные методы :

                            |   Throw Exception     |   Returns special value
            -----------------------------------------------------------------
            Insert          |   add(e)              |   offer(e)
            -----------------------------------------------------------------
            Remove          |   remove()            |   poll()
            -----------------------------------------------------------------
            Examine         |   element()           |   peek()

         */

        // Мы узнали что при add() - выдает exception, а теперь узнаем что же воз-т offer() если добавляется лишний элемент
        System.out.println(people2.offer(person4)); // false - если элемент не добавился, true - если добавился

    }

             }

class Person{
    private int id;

    public Person(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                '}';
    }
}
