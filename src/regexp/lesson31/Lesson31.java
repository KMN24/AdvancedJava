package regexp.lesson31;

// todo Регулярные выражения часть II

import java.util.ArrayList;
import java.util.Arrays;

public class Lesson31 {
    public static void main(String[] args) {
        String a = "Hello there hey";
        String b = "Hello.there.hey.";
        String c = "Hello1232342there124321424hey4234234qwerty";

        String[] words1 = a.split(" ");
        String[] words2 = b.split("\\."); // простая точка - \\.
        String [] words3 = c.split("\\d+"); // уберет все цифры

        System.out.println(Arrays.toString(words1)); // [Hello, there, hey]
        System.out.println(Arrays.toString(words2)); // [Hello, there, hey]
        System.out.println(Arrays.toString(words3)); // [Hello, there, hey, qwerty]

        String d = "Hello there hey";
        String e =  d.replace(" ", ".");
        System.out.println(e); // Hello.there.hey

        String f = "Hello213124there1234124hey";
        String g = f.replace("\\d+", "-");
        System.out.println(g); // Hello213124there1234124hey  - так как replace() - не принимает regexp, а простой символ
        // но можем исп-ть replaceAll()

        String h = f.replaceAll("\\d+", "-");
        System.out.println(h); // Hello-there-hey

        String i = f.replaceFirst("\\d+", "-"); // replaceFirst() - может принимать regexp но заменяет только первые
        // символы которые указаны на regexp
        System.out.println(i); // Hello-there1234124hey  -> как видим заменили лишь первые числа




    }
}
