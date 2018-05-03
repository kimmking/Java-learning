package one.wangwei.algorithms.datastructures.list.impl;

public class SingleLinkedListTest {

    public static void main(String[] args) {

        SingleLinkedList<Integer> singlyLinkedList = new SingleLinkedList<>();
        for (int i = 0; i < 10; i++) {
            singlyLinkedList.add(i);
        }
        singlyLinkedList.add(null);
        System.out.println(singlyLinkedList);

        singlyLinkedList.add(5, null);
        System.out.println(singlyLinkedList);

        singlyLinkedList.remove(null);
        System.out.println(singlyLinkedList);

        singlyLinkedList.remove(Integer.valueOf(5));
        System.out.println(singlyLinkedList);


    }

}