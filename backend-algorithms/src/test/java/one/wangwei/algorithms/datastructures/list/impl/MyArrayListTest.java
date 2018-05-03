package one.wangwei.algorithms.datastructures.list.impl;

public class MyArrayListTest {

    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        for (int i = 0; i < 10; i++) {
            myArrayList.add(i);
        }

        myArrayList.add(3, 100);

        myArrayList.remove(5);

        myArrayList.add(null);

        System.out.println(myArrayList);

    }
}