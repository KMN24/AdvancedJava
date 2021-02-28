package collectionsFramework.lesson4;

import java.util.Arrays;

public class MyLinkedList {

    private Node head; // head ссылка в листе
    private int size; // размер листа

    public void add(int value){ // значение
        // если это первое добавление в список
        // то здесь будет какая-то логика
        if(head == null){
            this.head = new Node(value);
        }else {
            Node temp = head;

            while ((temp.getNext() != null)){
                temp = temp.getNext(); // в конце наш temp будет указывать на последний элемент
            }
            temp.setNext(new Node(value)); // и добавим следующий элемент
            // наш код будет работать
            // Н: [1] -> [2] -> [3]
            // head всегда указывает на первый элемент

        }
        size++;
    }

    public int get(int index){
        int currentIndex = 0;
        Node temp = head;
        while (temp != null){
            if(currentIndex == index){
                return temp.getValue();
            }else {
                temp = temp.getNext();
                currentIndex++;
            }
        }
        // [1] -> [2] -> [3]

        throw new IllegalArgumentException();
    }

    public void remove(int index){

        // нам нужно удалить элемент с index , но для этого нужно взять ссылку предыдущего элемента
        // и указать на следующий элемент после index

        if (index == 0){
            head = head.getNext(); // если мы хотим удалить 0 индекс то мы просто укажем на следующий элемент
            size--;
            return;
        }
        int currentIndex = 0;
        Node temp = head;
        while (temp != null){
            if(currentIndex  == index - 1){
                temp.setNext(temp.getNext().getNext()); // даем следующий узел слудующего узла
                size--; // потому что после удаления размер листа уменьщается
                return;
            }else {
                temp = temp.getNext();
                currentIndex++;
            }
        }

    }

    public String toString(){ // мы переопределяем метод toString
        int [] result = new int[size];
        int index = 0;
        Node temp = head;
        while (temp != null ){
            result[index] = temp.getValue();
            temp = temp.getNext();
            index++;
        }
        return Arrays.toString(result);
    }

    private static class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
