package collectionsFramework.lesson8;

// TODO Продолжение Lesson8.java
// TODO   Методы hashcode и equals
import java.util.*;

public class Lesson8_2 {
    public static void main(String[] args) {
        Map<Person2, String> map = new HashMap<>();
        Set<Person2> set = new HashSet<>();

        // TODO Созданные классы в Java Integer, String... у них уже есть методы hashcode и equals,
        //  эти методы автоматически проверяют объекты на идентичность и поэтому они не добавляют дубликаты
        //  А наши собственные объекты созданных собственными классами не проверяются на идентичность и сохраняются одинаковые значения разных объектов
        // Для этого мы сами можем проверять на идентичность с помощью методов hashcode и equals


        //Integer x = 1;
        //x.equals(); // У нас есть метод equals(Object) и hashCode(Object)
        //x.hashCode();

        // Person2 person1 = new Person2(1, "Mike");
        // person1.equals(); // эти методы просто сравнивают на идентичность ссылок на объект, но у нас 2 объекта содержат разные ссылки
        // person1.hashCode();
        // TODO  И в наших собственных объектов тоже есть такие методы НО эти методы по умол-ю
        // TODO сравнивают только ссылки объекта, но у нас 2 объекты класса Person2 и у этих объектов ссылки разные,
        // ПОЭТОМУ У НАС И БЫЛИ ОДИНАКОВЫЕ ЗНАЧЕНИЯ, КЛЮЧИ В LESSON8.JAVA

        // TODO Поэтому нам нужно переопределить методы equals() и hashCode() в классе Person2
        // we need to override methods in the class Person2

        // Когда мы переопределили методы мы можем теперь сравнивать, и сравнение идет по смыслу ( значениям [id, name] )

        Person2 person1 = new Person2(1, "Mike");
        Person2 person2 = new Person2(1, "Mike");

        map.put(person1, "123");
        map.put(person2, "123");

        set.add(person1);
        set.add(person2);

        System.out.println(map); // {Person{id=1, name='Mike'}=123}
        System.out.println(set); // [Person{id=1, name='Mike'}]
        //TODO ИТОГ:  Теперь дубликаты не сохранются

        // Если ключ будет одинаковым а значения разными то просто обновится наш map

    }
}

class Person2{
    private int id;
    private String name;

    public Person2(int id, String name) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person2 person2 = (Person2) o;
        return id == person2.id &&
                Objects.equals(name, person2.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

}
