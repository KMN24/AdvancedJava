package lessons.collectionsFramework.lesson5;
// HashMap - Введение

import java.util.HashMap;
import java.util.Map;

public class Lesson5 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>(); // Ключ - Integer, Значение - String
        map.put(1, "Один");
        map.put(2, "Два");
        map.put(3, "Три");

//        System.out.println(map); // {1=Один, 2=Два, 3=Три}
//
//        map.put(3, "Другое значение для ключа три"); // если такой ключ уже есть то новое значение перезаписывается
//        System.out.println(map); // {1=Один, 2=Два, 3=Другое значение для ключа три}
//
//        System.out.println(map.get(1)); // get(key) - получаем значение через ключ

        for (Map.Entry<Integer, String> entry : map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue()); // Выйдет ключ : значение
        }
        System.out.println(map.size()); // 3

    }
}
