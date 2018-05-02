package one.wangwei.algorithms.datastructures.list.impl;

import one.wangwei.algorithms.datastructures.list.interfaces.IList;

import java.util.Arrays;

/**
 * 顺序表
 *
 * @param <T>
 * @author wangwei
 * @date 2018/04/27
 */
public class MyArrayList<T> implements IList<T> {

    /**
     * 默认大小
     */
    private static final int DEFAULT_SIZE = 10;

    private int size = 0;
    /**
     * 初始化一个默认数组
     */
    private transient T[] array = (T[]) new Object[DEFAULT_SIZE];

    /**
     * 添加元素
     *
     * @param element
     * @return
     */
    @Override
    public boolean add(T element) {
        return add(size, element);
    }

    /**
     * 添加元素
     *
     * @param index
     * @param element
     * @return
     */
    private boolean add(int index, T element) {
        // 扩容
        if (size >= array.length) {
            grow();
        }
        if (index == size) {
            array[size] = element;
        } else {
            System.arraycopy(array, index, array, index + 1, size - index);
            array[index] = element;
        }
        size++;
        return true;
    }

    /**
     * 扩容
     */
    private void grow() {
        int growSize = size + (size << 1);
        array = Arrays.copyOf(array, growSize);
    }

    /**
     * 缩减
     */
    private void shrink() {
        int shrinkSize = array.length >> 1;
        array = Arrays.copyOf(array, shrinkSize);
    }

    /**
     * 移除第一个匹配的元素
     *
     * @param element
     * @return
     */
    @Override
    public boolean remove(T element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (array[i] == null) {
                    remove(i);
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (array[i].equals(element)) {
                    remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 删除 index 位置上元素
     *
     * @param index
     * @return
     */
    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        T element = array[index];
        if (index != --size) {
            System.arraycopy(array, index + 1, array, index, size - index);
        }
        array[size] = null;
        int shrinkSize = array.length >> 1;
        if (shrinkSize >= DEFAULT_SIZE && shrinkSize > size) {
            shrink();
        }
        return element;
    }

    /**
     * 设置索引值
     *
     * @param index
     * @param element
     * @return
     */
    @Override
    public T set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        T oldElement = array[index];
        array[index] = element;
        return oldElement;
    }

    /**
     * 清空元素
     */
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    /**
     * 检查是否包含某个元素
     *
     * @param element
     */
    @Override
    public boolean contains(T element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (array[i] == null) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(array[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 集合大小
     *
     * @return
     */
    @Override
    public int size() {
        return size;
    }
}
