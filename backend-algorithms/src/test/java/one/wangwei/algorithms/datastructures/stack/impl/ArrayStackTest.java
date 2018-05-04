package one.wangwei.algorithms.datastructures.stack.impl;

public class ArrayStackTest {

    public static void main(String[] args) {

        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            arrayStack.push(i);
        }

        System.out.println(arrayStack);

        for (int i = 0; i < 5; i++) {
            System.out.println(arrayStack.pop());
        }

//        arrayStack.remove(2);

        System.out.println(arrayStack);

    }

}