package one.wangwei.algorithms.datastructures.list.impl;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SinglyCircularLinkedListTest {

    private SinglyCircularLinkedList<Integer> cyclicLinkedList;

    @BeforeMethod
    public void setUp() {
        cyclicLinkedList = new SinglyCircularLinkedList<>();
        for (int i = 0; i < 5; i++) {
            cyclicLinkedList.add(i);
        }
    }

    @Test
    public void testAdd() {
        cyclicLinkedList.add(1);
        cyclicLinkedList.add(null);

    }

    @Test
    public void testAdd1() {
        cyclicLinkedList.add(1, 1);
        cyclicLinkedList.add(1, null);
    }

    @Test
    public void testRemove() {
        cyclicLinkedList.remove(1);
    }

    @Test
    public void testRemove1() {
        cyclicLinkedList.add(null);
        cyclicLinkedList.remove(Integer.valueOf(999));
        cyclicLinkedList.remove(null);
        cyclicLinkedList.remove(Integer.valueOf(4));

        System.out.println(cyclicLinkedList);
    }

    @Test
    public void testSet() {
        cyclicLinkedList.set(1, 87);
    }

    @Test
    public void testClear() {
        cyclicLinkedList.clear();
    }

    @Test
    public void testContains() {
        System.out.println(cyclicLinkedList.contains(3));
        System.out.println(cyclicLinkedList.contains(null));
    }

    @Test
    public void testSize() {
        System.out.println(cyclicLinkedList.size());
    }
}