package collectionsFramework.lesson14;

// todo Стек Stack

import java.util.Stack;

public class Lesson14 {
    public static void main(String[] args) {

        // Класс Vector устарел, вместо него используют класс ArrayList, так как он более удобен
        // НО класс todo Stack наследуется от класса Vector
        // Stack работает по принципе LIFO - last in fist out

        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(3);
        stack.push(1);

        System.out.println(stack.pop()); // 1 - еще и удаляет элемент из стека
        System.out.println(stack); // [5, 3]
        System.out.println(stack.pop()); // 3
        System.out.println(stack.pop()); // 5
        //System.out.println(stack.pop()); // Exception. EmptyStackException - стек пустой

        stack.push(4);
        stack.push(12);

        System.out.println(stack.peek()); //12 - peek() просто покажет но не удалит элемент из стека
        System.out.println(stack); // [4, 12] как мы видим 12 остался в стеке

        while ( !stack.empty()){ // if stack is empty return true
            System.out.println(stack.pop());
        }

    }
}
