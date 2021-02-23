package lessons.collectionsFramework.lesson7;

import java.util.HashSet;
import java.util.Set;

public class Lesson7_2 {
    public static void main(String[] args) {
        // Это продолжение Lesson7


        // В множестве (в теории множеств) есть несколько операций: НО В JAVA МЕТОДЫ НАЗЫВАЮТСЯ ПО ДРУГОМУ
        // set1.intersect(set2) - Пересечение - кесилиши
        // set1.exclusiveOr(set2) - Симметрическая разность - кеслишинен сырткары , только озуно гана тиешелуулор
        // set1.union(set2) - Объединение - биригуу Set1 U Set2
        // set1.subtract(set2) - Разность - айырмасы Set1 - Set2 or Set1\Set2

        Set<Integer> hashSet1 = new HashSet<>();
        hashSet1.add(0);
        hashSet1.add(1);
        hashSet1.add(2);
        hashSet1.add(3);
        hashSet1.add(4);
        hashSet1.add(5);

        Set<Integer> hashSet2 = new HashSet<>();
        hashSet2.add(2);
        hashSet2.add(3);
        hashSet2.add(4);
        hashSet2.add(5);
        hashSet2.add(6);
        hashSet2.add(7);


        Set<Integer> union = new HashSet<>(hashSet1); // В качестве конструктора может принимать set и кон-р создает новый set
        // В нашем примере новый set (union) скопировал все элементы hashSet1
        // Union - Объединение - set1.addAll(set2)
        union.addAll(hashSet2); // Объединили union и hashSet2
        System.out.println(union); // [0, 1, 2, 3, 4, 5, 6, 7] - потому что дубликат не сох-ся

        // intersection - Пересечение множеств - set1.retainAll(set2)
        Set<Integer> intersection = new HashSet<>(hashSet1); // В качестве конструктора может принимать set и кон-р создает новый set
        intersection.retainAll(hashSet2);
        System.out.println(intersection); // [2, 3, 4, 5] - retain - переводится как сохрани, оставь

        // subtract - Разность - set1.removeAll(set2)
        Set<Integer> subtract = new HashSet<>(hashSet1);
        subtract.removeAll(hashSet2);
        System.out.println(subtract); // [0, 1] - потому что 0 и 1 есть только в set1 т.е.
        // МЕТОД set1.removeAll(set2) - удаляет все одинаковые элементы в set1 и set2 и оставляет остальные элементы в set1

    }
}
