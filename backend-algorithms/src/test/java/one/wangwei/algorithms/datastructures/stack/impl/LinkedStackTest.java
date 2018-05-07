package one.wangwei.algorithms.datastructures.stack.impl;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinkedStackTest {

    private LinkedStack<Integer> linkedStack;

    @BeforeMethod
    public void setUp() {
        linkedStack = new LinkedStack<>();
        for (int i = 0; i < 5; i++) {
            linkedStack.push(i);
        }
    }

    @Test
    public void testPush() {
        linkedStack.push(null);
        linkedStack.push(55);
        System.out.println(linkedStack);
    }

    @Test
    public void testPop() {
        for (int i = 0, size = linkedStack.size(); i < size; i++) {
            System.out.println(linkedStack.pop());
        }
    }

    @Test
    public void testPeek() {
        System.out.println(linkedStack.peek());
    }

    @Test
    public void testRemove() {
        linkedStack.remove(3);
        linkedStack.remove(null);
        System.out.println(linkedStack);
    }

    @Test
    public void testClear() {
        linkedStack.clear();
        System.out.println(linkedStack);
    }

    @Test
    public void testContains() {
        System.out.println(linkedStack.contains(4));
        System.out.println(linkedStack.contains(null));
    }

    @Test
    public void testSize() {
        System.out.println(linkedStack.size());
    }
}