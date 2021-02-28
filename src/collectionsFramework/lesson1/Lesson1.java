package collectionsFramework.lesson1;
// Сезон Java Collections Framework Коллекции, эпизод 1
// TODO Динамический массив ArrayList - Введение

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lesson1 {
    public static void main(String[] args) {
        int []x = new int[3];
//        for (int i=0; i<4; i++){ // будет ошибка потому что простой List не может изменить первоначальный размер
//            x[i] = 1;
//        }
        // В Array List память безграничен
        ArrayList<Integer> arrayList = new ArrayList<>();
        //TODO мы не можем исп-ть примитивные типы нап: int, float ... Нужно исп-ть ссылочные типы Integer, String ...
        // потому что в Generics(Обобщение) нету примитивных типов

        for (int i=0; i<10; i++){
            arrayList.add(i);
        }
        System.out.println(arrayList); // [0, 1, 2, ... 99]

        System.out.println(arrayList.get(0));// получим первый элемент
        System.out.println(arrayList.get(arrayList.size() - 1)); // возмем последний элемент

        for(int i=0; i<arrayList.size(); i++){
            System.out.println(arrayList.get(i));
        }

        for( Integer el : arrayList ){
            System.out.println(el);
        }
        // remove дун минус жагы бул баштапкы элменттин бири жок болсо, анда он жактагы элементтер сол жакка кочуруллот
        // array list болгону жонокой эле list ти колдонот, качан array listтин размери жетпей калганда озунн 2 эсе коп
        // олчомдогу arrayllist тузулуп бардык элементтер жанысына кочурулот
        arrayList.remove(5);
        System.out.println(arrayList);
        System.out.println(arrayList.get(5));

        List<Integer> list = new ArrayList<>();
        // это будет работать точно так же как и преждний
        // Это называется конвенсией

        // если мы проводим много удалений из нашего листа, то нужно лучше исп LinkedList
        list = new LinkedList<>();
        // Эмнеге List<Integer> list = new ArrayList<>(); List интерфейсинин негиз катары кылганыбыз себеби
        // каалаган маалда LInked List же ArrayList... отуп кетсек болот

        // Себеби бардык листтер List интерфейсинен наследование алат

    }
}
