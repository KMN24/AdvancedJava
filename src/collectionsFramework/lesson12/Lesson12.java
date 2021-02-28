package collectionsFramework.lesson12;

// todo Интерфейс Comparable

import java.util.*;

public class Lesson12 {
    public static void main(String[] args) {

        // В наших собственных объектах не было естественной сортировки ( сортировка по умолчанию)
        // В этом уроке добавим наш естественный порядок

        List <Person> peopleList = new ArrayList<>();
        Set <Person> peopleSet = new TreeSet<>(); // Потому что в TreeSet есть сортировка

        addElements(peopleList);
        addElements(peopleSet);

        //Collections.sort(peopleList); //todo ОШИБКА. Нету естественной сортировки в классе Person для ArrayList
        // если наследуемся от Comparable и переопределим метод compareTo() то эта ошибка исчезне

        System.out.println("Array List");
        // Отсортируем по id, первый метод compareTo() в классе Person закомментирован
        //System.out.println(peopleList); // [Person{id=4, name='George'}, Person{id=1, name='Bob'}, Person{id=3, name='Katy'}, Person{id=2, name='Tom'}]
        //Collections.sort(peopleList); // Сначала мы отсортировали по id
        //System.out.println(peopleList); // [Person{id=1, name='Bob'}, Person{id=2, name='Tom'}, Person{id=3, name='Katy'}, Person{id=4, name='George'}]

        // Отсортируем по name, второй метод compareTo() в классе Person
        System.out.println(peopleList); // [Person{id=4, name='George'}, Person{id=1, name='Bob'}, Person{id=3, name='Katy'}, Person{id=2, name='Tom'}]
        Collections.sort(peopleList); // Сначала мы отсортировали по id
        System.out.println(peopleList); // [Person{id=1, name='Bob'}, Person{id=2, name='Tom'}, Person{id=3, name='Katy'}, Person{id=4, name='George'}]


        // Collections.sort(peopleSet); //todo ОШИБКА, потому что когда мы добавляем элементы в set то он автоматически сортирует
        // Поэтому нам нужно лишь переопределить метод compareTo
        System.out.println("Tree Set");
        System.out.println(peopleSet); // [Person{id=2, name='Tom'}, Person{id=3, name='Katy'}, Person{id=4, name='George'}, Person{id=1, name='Bobbbyyyy'}]
    }

    private static void addElements(Collection collection){
        collection.add(new Person(4, "George"));
        collection.add(new Person(1, "Bobbbyyyy"));
        collection.add(new Person(3, "Katy"));
        collection.add(new Person(2, "Tom"));
    }
}

class Person implements Comparable<Person>{ // наследумся и переопределяем метод compareTo()
    private int id;
    private String name;
    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

// Исп-ся для сортировки по id
//    @Override
//    public int compareTo(Person o) { // Принимается лишь один параметр и сравнивается с другим объектом
//        if (this.id > o.getId()){
//            return 1;
//        }
//        else if(this.id < o.getId()){
//            return -1;
//        }
//        else return 0;
//    }

    // Исп-ся для сортировки по длине name
        @Override
    public int compareTo(Person o) { // Принимается лишь один параметр и сравнивается с другим объектом
        if (this.name.length() > o.getName().length()){
            return 1;
        }
        else if(this.name.length() < o.getName().length()){
            return -1;
        }
        else return 0;
    }
}