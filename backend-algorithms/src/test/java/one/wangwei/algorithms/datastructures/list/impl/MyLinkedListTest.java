package one.wangwei.algorithms.datastructures.list.impl;

public class MyLinkedListTest {

    public static void main(String[] args) {
        DoublyLinkedList<Integer> myLinkedList = new DoublyLinkedList<>();
        for (int i = 0; i < 100; i++) {
            myLinkedList.add(i);
        }
        System.out.println(myLinkedList);

        myLinkedList.add(2, 222);
        System.out.println(myLinkedList);

        myLinkedList.remove(Integer.valueOf(222));
        System.out.println(myLinkedList);

        myLinkedList.remove(99);
        System.out.println(myLinkedList);

        myLinkedList.remove(3);
        System.out.println(myLinkedList);

        myLinkedList.set(0, 827);

        System.out.println(myLinkedList.contains(827));

        myLinkedList.clear();
    }

}