package regexp.lesson30;

// todo Регулярные выражения часть I
// regexlib.com  потом зайти на Regex Cheat Sheet  https://regexlib.com/CheatSheet.aspx

public class Lesson30 {
    public static void main(String[] args) {
        /* Регулярные выражения (Regular Expressions) :

            \\d -> одна цифра
            +   -> 1 или более
            *   -> 0 или более
            ?  -> Н: -? ->  символ "-" который до него может и быть и не быть т.е.  0 или 1 символов
            ( | | ) - разделяем через "|" - лоическое или . Н: (x|y|z) - одна из множество строк
            [a-zA-Z] -> если перед числом есть буква. Вот так мы опишем все английские буквы. [abc] = (a|b|c) равны
                    [0-9] = \\d оба говорят есть ли одна цифра,  [a-z123A-K]
            ^   -> отрицание. После этого все что есть не должно быть в строке в том случае ернет true
                    [^abc] - мы хотим все символы кроме [abc]
            .   -> любой символ
            {2} -> 2 символа до Н: (\\d{2}) мы хотим чтобы в этом месте было 2 цифры тогда вернет true
            {2,}  ->  2 или более символов   Н: (\\d{2,})
            {2,4} ->  от 2 до 4 символов     Н: (\\d{2,4})
            \\w   -> одна буква английская буква  \\w = [a-zA-Z] равны

         */

        String a = "1234";
        String b = "1";
        String c = "123";
        String d = "";
        String e = "-1234";
        String f = "+1234";

        // метод matches() не только принимает строку, а и RegExp тоже
        System.out.println(a.matches("1234")); // true
        System.out.println(a.matches("\\d")); // false
        System.out.println(b.matches("\\d")); // true - так как в b - одна цифра
        System.out.println(c.matches("\\d")); // false- так как С не содержит одну цифру
        System.out.println(a.matches("\\d+")); // true
        System.out.println(d.matches("\\d+")); // false
        System.out.println(d.matches("\\d*")); // true
        System.out.println(e.matches("-\\d*")); // true -> так как проверяет положительные числа, чтобы правильно вывело
        // мы можем перед поставить -

        System.out.println(a.matches("-?\\d*")); // true
        System.out.println(e.matches("-?\\d*")); // true
        System.out.println(f.matches("-?\\d*")); // false - так как у нас перед числом не стоит - а стоит +
        System.out.println(f.matches("(-|\\+)?\\d+"));// true // перед числом стоит либо - или +.
        // Но чтобы писать + нужно пережд ним добавить \\
        // Нужно все в писать не раздельно в скобках

        String g = "a12"; // перед числом есть буква
        String h = "sdf1234";
        String i = "abw123bfdf232";
        String j = "svad14ava416hgvk890";

        System.out.println(g.matches("[a-zA-Z]\\d+")); // true
        System.out.println(h.matches("[a-zA-Z]\\d+")); // false - так как пред числом не одна буква а много
        System.out.println(h.matches("[a-zA-Z]+\\d+")); // true - есть ли перед числом 1 или более букв
        System.out.println(h.matches("[a-zA-Z]*\\d+")); // true - есть ли перед числом 0 или более букв
        System.out.println(i.matches("[a-zA-Z]*\\d+")); // false - так перед числом стоит и буквы и цифры
        System.out.println(i.matches("[a-zA-Z123]*\\d+")); // говорим что перед числом стоит буквы и цифры 1,2,3
        System.out.println(j.matches("[a-zA-Z1-9]*\\d+")); // true

        String k = "hello";
        String l = "abc";

        System.out.println(k.matches("[^a]*")); // true
        System.out.println(l.matches("[^a]*")); // false
        System.out.println(l.matches("[^kmn]*")); // true

        String url = "http://www.google.com"; // валидное значение
        String url2 = "http://www.yandex.ru";
        String url3 = "Hello there!";

        System.out.println(url.matches("http://www\\..+\\.(com|ru)")); // true.   \\. значит простую точку, а . это уже регул.выражение
        System.out.println(url2.matches("http://www\\..+\\.(com|ru)")); // true
        System.out.println(url3.matches("http://www\\..+\\.(com|ru)")); // false

        String m = "123";
        String n = "12";
        String o = "1";

        System.out.println(m.matches("\\d{2}")); // false - так как цифр не 2
        System.out.println(n.matches("\\d{2}")); // true
        System.out.println(o.matches("\\d{2}")); // false - должно быть только 2 цифры
        System.out.println(m.matches("\\d{2,}")); // true - 2 или более цифры

        String p = "123";
        String q = "a";
        String r = "ab";

        System.out.println(p.matches("\\w")); // false
        System.out.println(q.matches("\\w")); // true - так как содержит 1 английскую букву
        System.out.println(r.matches("\\w")); // false

    }
}
