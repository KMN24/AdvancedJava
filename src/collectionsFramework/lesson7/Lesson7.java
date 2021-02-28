package collectionsFramework.lesson7;
// TODO Множества Set
// http://www.ts.kg/show/prodvinutaya_java/1/7

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Lesson7 {
    public static void main(String[] args) {

        // todo: Set - имеет тоже что и Map, различие в том что он хранит только значение, т.е. не нужен ключ
        // todo ГЛАВНОЕ: В множестве(Set) нельзя хранит одинаковые элементы


        Set<String> hashSet = new HashSet<>(); //  нет никакого порядка
        Set<String> linkedHashSet = new LinkedHashSet<>(); // сохраняется порядок
        Set<String> treeSet = new TreeSet<>(); // сохраняется от меньшего к большому, т.е. сортируется по воз-ю : 1,2,3, and a,b,c
        // aa , ab because aa < ab, A,B,C ... a,b,c ... , A < a

        System.out.println("Hash Set - порядок может быть разным рандомно");
        displaySet(hashSet);
        System.out.println("\nLinked Hash Set - порядок сохраняется");
        displaySet(linkedHashSet);
        System.out.println("\nTree Set - значения находятся в возрастающем порядке");
        displaySet(treeSet);

        // Обычно на практике часто исп-ся HashSet, потому что нам всего лишь нужно знать есть ли элемент в множестве
        // Hash Set работает быстро и метод contains() исп-т хеширование поетому и метод тоже работает быстро за константное время
        System.out.println("\n" + hashSet.contains("Tom") ); // МЕТОД contains(String) - вернет true если есть такое значение в Set'е
        System.out.println( hashSet.contains("Tim") );

        System.out.println( "\nIs the HashSet empty - " +  hashSet.isEmpty()); // воз-т true если множество пустое

    }
    public static void displaySet(Set<String> set){
        set.add("Mike");
        set.add("Katy");
        set.add("Tom");
        set.add("George");
        set.add("Donald");

        set.add("Tom"); // Будет считатся как дубликат и не сохранится
        set.add("Tom"); // Мы три раза положили имя Том в наш set но сох-ся лишь одна, потому что в set е должен быть один экзампляр

        for (String name : set ){
            System.out.println(name);
        }
    }
}
