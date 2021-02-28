package collectionsFramework.lesson11;

// Продолжение Lesson11.java
// Часть 4

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lesson11_2 {
    public static void main(String[] args) {
        // Теперь будем сортировать объекты

        List<Person> people = new ArrayList<>();

        people.add( new Person(3, "Bob") );
        people.add( new Person(2, "Katy") );
        people.add( new Person(1, "Mike") );


        //todo  Collections.sort(people); // ОШИБКА. Потому, что НЕТУ в классе Person сортировка по умолчанию,
        // так как мы сортируем объекты мы должны сами создать Comparator,
        // а в след-м уроке научимся создовать сортировку объектов по умолчанию

        // Будем сортировать по воз-ю id

        System.out.println(people); // [Person{id=3, name='Bob'}, Person{id=2, name='Katy'}, Person{id=1, name='Mike'}]
        Collections.sort(people, new Comparator<Person>() { // создали анонимный класс
            @Override
            public int compare(Person o1, Person o2) {
                if(o1.getId() > o2.getId()){
                    return 1;
                }
                else if(o1.getId() < o2.getId()){
                    return -1;
                }
                else {
                    return 0;
                }
            }
        });

        System.out.println(people); // [Person{id=1, name='Mike'}, Person{id=2, name='Katy'}, Person{id=3, name='Bob'}]
    }
}

class Person {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
