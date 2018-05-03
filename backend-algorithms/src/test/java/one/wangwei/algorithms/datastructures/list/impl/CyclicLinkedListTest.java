package one.wangwei.algorithms.datastructures.list.impl;

public class CyclicLinkedListTest {

    public static void main(String[] args) {

        CyclicLinkedList<Integer> cyclicLinkedList = new CyclicLinkedList<>();
        for (int i = 0; i < 10; i++) {
            cyclicLinkedList.add(i);
        }
        System.out.println(cyclicLinkedList);

        cyclicLinkedList.add(5, null);
        System.out.println(cyclicLinkedList);

        cyclicLinkedList.remove(Integer.valueOf(0));
        System.out.println(cyclicLinkedList);
    }

}