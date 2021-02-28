package lambdaExpressions.lesson34;

// todo Лямбда - выражения часть II

import java.util.*;
import java.util.stream.Collectors;

public class Lesson34 {
    public static void main(String[] args) {

        // Часть 1
        // Создадим простой массив и arrayList. И добавим элементы от 1 до 10, а потом умножим все элементы на 2
        // И посмотрим как мы бы умножали простым способом(через цикл) и 2 способом через лямбду

        int[] arr1 = new int[10];
        List<Integer> list1 = new ArrayList<>();

        fillArr(arr1);
        fillList(list1);

        System.out.println(Arrays.toString(arr1)); // мы не можем вывести простой массив просто так -> [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        System.out.println(list1); // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

        /*
        // 1 способ. Чтобы умножить элементы на 2
        for(int i=0; i<10; i++){
            arr1[i] = arr1[i] * 2;
            list1.set(i, list1.get(i) * 2); //set(index, newElement)
        }

        System.out.println(Arrays.toString(arr1));  // [2, 4, 6, 8, 10, 12, 14, 16, 18, 20]
        System.out.println(list1); // [2, 4, 6, 8, 10, 12, 14, 16, 18, 20]

         */

        // 2 способ. Используем лямбду и метод
        // stream() - принимает массив и возвращает поток
        // Lambda не может сразу же изменить массив ей нужен поток чтобы изменить что-то, поэтому мы через stream(arr1)
        // возвращаем поток и лямбда работает с этим потоком

        // А для листа сразу же вызовем stream() в качестве аргумента не принимает

        // и в конце тот самый нужный метод это map() - отображение от английск.
        // внутри  map() пишем логику лямбды
        // Arrays.stream(arr1).map((int a) -> a * 2);  - вот так тоже можем писать. Лямбда принимает значение и возвращает умноженное значение
        // list1.stream().map((Integer a) -> a * 2); - на самом деле наша лямбда выглядит вот так но мы можем сократить код
        // map() method будет итерироватся и будет умножать элементы

        arr1 = Arrays.stream(arr1).map(a -> a * 2).toArray(); // map() - возвращает stream(поток) и этот поток нужно переобразовать
        // обратно в простой массив вызываем toArray() и обновляем значения сохранив в тот же массив
        list1 = list1.stream().map(a -> a * 2).collect(Collectors.toList()); // map() - возвращает stream(поток) и этот поток нужно
        // переобразовать в List для этого вызываем collect(Collectors.toList()) и обновляем значения сохранив в тот же лист

        System.out.println(Arrays.toString(arr1)); // [2, 4, 6, 8, 10, 12, 14, 16, 18, 20]
        System.out.println(list1); // [2, 4, 6, 8, 10, 12, 14, 16, 18, 20]

        arr1 = Arrays.stream(arr1).map(el -> 3).toArray();
        System.out.println(Arrays.toString(arr1)); // [3, 3, 3, 3, 3, 3, 3, 3, 3, 3]

        arr1 = Arrays.stream(arr1).map(el -> el + 1).toArray();
        System.out.println(Arrays.toString(arr1)); // [4, 4, 4, 4, 4, 4, 4, 4, 4, 4]

        // Часть 2
        // filter() method - фильтрует наши элементы

        int[] arr2 = new int[10];
        List<Integer> list2 = new ArrayList<>();

        fillArr(arr2); // наш массив будет выглядет вот так после заполнения [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        fillList(list2); // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

        arr2 = Arrays.stream(arr2).filter( el -> el % 2 == 0).toArray(); // возвращаются те числа которые делятся на 2 без остатка
        list2 = list2.stream().filter(el -> el % 2 != 0 ).collect(Collectors.toList()); // возвращаются те числа которые НЕ делятся на 2 без остатка

        System.out.println(Arrays.toString(arr2)); // [2, 4, 6, 8, 10]
        System.out.println(list2); // [1, 3, 5, 7, 9]

        // Часть 3
        // forEach method

        Arrays.stream(arr2).forEach(a -> System.out.println(a)); // 2 4 6 8 10
        list2.stream().forEach( a -> System.out.println(a));  // 1 3 5 7 9

        // Часть 4
        //todo reduce method - уменьшить. Берет набор данных сжимает его в какой-то ОДИН элемент
        // Н: Найдем сумму всех элементов массива, а для листа найдем произведение всех элементов

        int[] arr3 = new int[10];
        List<Integer> list3 = new ArrayList<>();

        fillArr(arr3);
        fillList(list3);

        // accumulator - это такая временная пере-я, она будет обновляться ( как счетчик ).
        // Если начальное значение аккумулятора не назначано то, начальное значение акк-я будет 1 элементом в массиве,
        // а начальное значение currentEl будет второй элемент.

        // reduce( 0, (accumulator, currentEl) -> accumulator + currentEl ) - десь 0 это начальное значение акк будет 0 и
        // начальное значение currentEl будет 1 элемент. Если мы так напишем
        // то не нужно будет вызывать метод getAsInt() так как и так будет возвращено число а не поток.
        // currentEl - текущий элемент
        // getAsInt() - переобразует поток в int исп-ся для массива
        // get() - переобразует поток в int для листа
        int sumArr = Arrays.stream(arr3).reduce( (accumulator, currentEl) -> accumulator + currentEl ).getAsInt();
        // до getAsInt() - должны были вызвать isPresent() чтобы знать точно ли есть элементы в массиве, ео так мы знаем что есть
        // мы пропустили этот метод
        int productList = list3.stream().reduce((acc, curEl) -> acc * curEl).get();

        System.out.println(sumArr); // 55
        System.out.println(productList); // 3628800

        // Часть 5
        // Мы можем эти методы вызвать одновременно
        // Н: Будет массив. Оставим нечетные элементы и каждое нечетное число умножим на 2

        int[] arr4 = new int[10];
        fillArr(arr4);

        arr4 = Arrays.stream(arr4).filter( el -> el % 2 != 0).map( el -> el * 2 ).toArray();
                                        // [1, 3, 5, 7, 9]    ->  [2, 6, 10, 14, 18]
        System.out.println(Arrays.toString(arr4)); // [2, 6, 10, 14, 18]

        // Часть 6
        // Мы можем исп-ть эти методы для всех коллекций так, как все они исп-т потоки

        Set<Integer> set = new HashSet();
        set.add(1);
        set.add(2);
        set.add(5);

        System.out.println(set); // [1, 2, 5]
        set = set.stream().map(el -> el * 3).collect(Collectors.toSet());
        // через collect(Collectors.toSet()) переоб-м поток обратно в set

        System.out.println(set); //[3, 6, 15]
    }

    private static void fillList(List<Integer> list) {
        for (int i = 0; i < 10; i++) {
            list.add(i + 1);
        }
    }

    private static void fillArr(int[] arr) {
        for (int i = 0; i < 10; i++) {
            arr[i] = i + 1;
        }
    }
}
