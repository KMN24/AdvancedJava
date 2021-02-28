package collectionsFramework.lesson8;

// TODO   Методы hashcode и equals

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Lesson8 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        // Integer  - это обертывание над притивным типом int
        // Значит все значение это объекты

        map.put(1, "one");
        map.put(1, "another one");

        set.add(1);
        set.add(1);
        // получится у map и set дубликаты и сохранится только последний дубликат

        boolean c = 1 == 2; // будет false

        System.out.println(map); //  {1=another one}
        System.out.println(set); // [1]

        System.out.println();

        // А что будет если мы отправим в качестве значения другой тип объект
        // Если сравнить объекты то нужно исп-ть Методы hashcode и equals
        // Для примера создадим новый класс

        Map<Person , String> mapPerson = new HashMap<>();
        Set<Person> setPerson = new HashSet<>();

        Person person1 = new Person(1, "Mike");
        //Person person2 = new Person(2, "Katy"); // что если создадим идентичные объекты
        Person person2 = new Person(1, "Mike"); // TODO несмотря на то что это одинаковые объекты, т.е. у нас одинаковые ключа
        // а как мы знаем в map если ключи одинаковые то это будет дубликатом - ПОСМОТРИ на out
        // Потому что map  set не лезут на другие классы ( в нашем случаи класс Person), не смотрят на поля класса и не сравнивают объекты
        // Map и Set видит что это разные объекты

        mapPerson.put(person1, "123");
        mapPerson.put(person2, "123");

        setPerson.add(person1);
        setPerson.add(person2);

        System.out.println(mapPerson);
        System.out.println(setPerson);

        // TODO Продолжение на Lesson8_2.java
    }
}

class Person{
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
