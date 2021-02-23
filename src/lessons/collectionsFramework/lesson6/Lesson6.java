package lessons.collectionsFramework.lesson6;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

// TODO LinkedHashMap и TreeMap
public class Lesson6 {
    public static void main(String[] args) {
//        Map<String, String> translations = new HashMap<>();
//
//        translations.put("кошка", "cat");
//        translations.put("собака", "dog");
//        translations.put("слон", "elephant");
//
//        for( Map.Entry entry : translations.entrySet()){
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }

//        HashMap<Integer, String> hashMap = new HashMap<>();
//        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
//        TreeMap<Integer, String> treeMap = new TreeMap<>();

        // можно и так создать потому что все они наследуются от интерфейса Map

        Map<Integer, String> hashMap = new HashMap<>(); // внутри не гарантируется никакого порядка

        Map<Integer, String> linkedHashMap = new LinkedHashMap<>(); // в каком порядке пары (ключ, значение) были добавлены
        // в таком и порядке они вернутся

        Map<Integer, String> treeMap = new TreeMap<>(); // пары (ключ, значение) сортируются по ключу (по цифрам, по буквам,
        // объектам. Т.е. сортируются естественным порядком - natural order


        System.out.println("Hash Map - порядок может быть разным рандомно");
        testMap(hashMap);
        System.out.println("\nLinked Hash Map - порядок сохраняется");
        testMap(linkedHashMap);
        System.out.println("\nTree Map - ключи находятся в возрастающем порядке, а значения выходят по ключам соот-о");
        testMap(treeMap);

    }

    public static void testMap(Map<Integer, String> map){
        map.put(39, "Bob");
        map.put(12, "Mike");
        map.put(78, "Tom");
        map.put(0, "Tim");
        map.put(1500, "Lewis");
        map.put(7, "Bob"); // Значения могут быть одинаковыми а ключи - нет

        for (Map.Entry<Integer, String> entry : map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
