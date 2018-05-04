package one.wangwei.algorithms.datastructures.list.impl;

public class SinglyCircularLinkedListTest {

    public static void main(String[] args) {

        SinglyCircularLinkedList<Integer> cyclicLinkedList = new SinglyCircularLinkedList<>();
        for (int i = 0; i < 5; i++) {
            cyclicLinkedList.add(i);
        }
        cyclicLinkedList.add(4);

//        cyclicLinkedList.remove(Integer.valueOf(4));
//        System.out.println(cyclicLinkedList);

        cyclicLinkedList.remove(5);
        System.out.println(cyclicLinkedList);

        cyclicLinkedList.remove(3);
        System.out.println(cyclicLinkedList);

        cyclicLinkedList.add(0, 99);
        System.out.println(cyclicLinkedList);

        cyclicLinkedList.remove(9);
        System.out.println(cyclicLinkedList);

        cyclicLinkedList.clear();

    }

}