package one.wangwei.algorithms.datastructures.list.impl;

public class MyArrayListTest {

    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.remove(9);
        list.add(null);
        list.clear();
        System.out.println(list);

    }
}