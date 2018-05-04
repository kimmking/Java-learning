package one.wangwei.algorithms.datastructures.stack.impl;

import one.wangwei.algorithms.datastructures.stack.IStack;

import java.util.Arrays;

/**
 * 顺序栈
 *
 * @param <T>
 * @author wangwei
 * @date 2018/05/04
 */
public class ArrayStack<T> implements IStack<T> {

    /**
     * 默认大小
     */
    private static final int DEFAULT_SIZE = 10;
    /**
     * 数组
     */
    private T[] array = (T[]) new Object[DEFAULT_SIZE];
    /**
     * 大小
     */
    private int size;

    /**
     * 入栈
     *
     * @param value
     * @return
     */
    @Override
    public boolean push(T value) {
        if (size >= array.length) {
            grow();
        }
        array[size] = value;
        size++;
        return false;
    }

    /**
     * 扩容50%
     */
    private void grow() {
        int growSize = size + (size << 1);
        array = Arrays.copyOf(array, growSize);
    }

    /**
     * 压缩50%
     */
    private void shrink() {
        int shrinkSize = size >> 1;
        array = Arrays.copyOf(array, shrinkSize);
    }

    /**
     * 出栈
     *
     * @return
     */
    @Override
    public T pop() {
        if (size <= 0) {
            return null;
        }
        T element = array[--size];
        array[size] = null;

        int shrinkSize = array.length >> 1;
        if (shrinkSize >= DEFAULT_SIZE && shrinkSize > size) {
            shrink();
        }
        return element;
    }

    /**
     * 查看栈顶值
     *
     * @return
     */
    @Override
    public T peek() {
        if (size <= 0) {
            return null;
        }
        return array[size - 1];
    }

    /**
     * 删除元素
     *
     * @param value
     * @return
     */
    @Override
    public boolean remove(T value) {
        if (size <= 0) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            T t = array[i];
            if (value == null && t == null) {
                return remove(i);
            }
            if (value != null && value.equals(t)) {
                return remove(i);
            }
        }
        return false;
    }

    /**
     * 移除 index 处的栈值
     *
     * @param index
     * @return
     */
    private boolean remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index != --size) {
            System.arraycopy(array, index + 1, array, index, size - index);
        }
        array[size] = null;

        int shrinkSize = array.length >> 1;
        if (shrinkSize >= DEFAULT_SIZE && shrinkSize > size) {
            shrink();
        }
        return true;
    }

    /**
     * 清空栈
     */
    @Override
    public void clear() {
        if (size <= 0) {
            return;
        }
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
        array = null;
    }

    /**
     * 是否包含元素
     *
     * @param value
     * @return
     */
    @Override
    public boolean contains(T value) {
        if (size <= 0) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            T t = array[i];
            if (value == null && t == null) {
                return true;
            }
            if (value != null && value.equals(t)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 栈大小
     *
     * @return
     */
    @Override
    public int size() {
        return size;
    }
}
