package one.wangwei.algorithms.datastructures.stack.impl;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ArrayStackTest {

    private ArrayStack<Integer> arrayStack;

    @BeforeMethod
    public void setUp() {
        arrayStack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            arrayStack.push(i);
        }
    }

    @Test
    public void testPush() {
        arrayStack.push(null);
        arrayStack.push(45);
        System.out.println(arrayStack);
    }

    @Test
    public void testPop() {
        for (int i = 0, size = arrayStack.size(); i < size; i++) {
            System.out.println(arrayStack.pop());
        }
    }

    @Test
    public void testPeek() {
        System.out.println(arrayStack.peek());
    }

    @Test
    public void testRemove() {
        arrayStack.remove(null);
        arrayStack.remove(1);
    }

    @Test
    public void testClear() {
        arrayStack.clear();
    }

    @Test
    public void testContains() {
        System.out.println(arrayStack.contains(3));
        System.out.println(arrayStack.contains(null));
    }

    @Test
    public void testSize() {
        System.out.println(arrayStack.size());
    }
}