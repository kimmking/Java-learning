package one.wangwei.algorithms.datastructures.list.impl;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DoublyLinkedListTest {

    private DoublyLinkedList<Integer> myLinkedList;

    @BeforeMethod
    public void setUp() {
        myLinkedList = new DoublyLinkedList<>();
        for (int i = 0; i < 100; i++) {
            myLinkedList.add(i);
        }
    }

    @Test
    public void testAdd() {
        myLinkedList.add(1);
        myLinkedList.add(null);
    }

    @Test
    public void testAdd1() {
        myLinkedList.add(1, 1);
        myLinkedList.add(1, null);
    }

    @Test
    public void testRemove() {
        myLinkedList.remove(1);
    }

    @Test
    public void testRemove1() {
        myLinkedList.remove(null);
        myLinkedList.remove(Integer.valueOf(4));
    }

    @Test
    public void testSet() {
        myLinkedList.set(1, 87);
    }

    @Test
    public void testClear() {
        myLinkedList.clear();
    }

    @Test
    public void testContains() {
        System.out.println(myLinkedList.contains(3));
        System.out.println(myLinkedList.contains(null));
    }

    @Test
    public void testSize() {
        System.out.println(myLinkedList.size());
    }
}