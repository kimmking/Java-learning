package one.wangwei.algorithms.datastructures.stack.impl;

import one.wangwei.algorithms.datastructures.stack.IStack;

/**
 * 链表栈
 *
 * @param <T>
 * @author wangwei
 * @date 2018/05/04
 */
public class LinkedStack<T> implements IStack<T> {

    /**
     * 入栈
     *
     * @param value
     * @return
     */
    @Override
    public boolean push(T value) {
        return false;
    }

    /**
     * 出栈
     *
     * @return
     */
    @Override
    public T pop() {
        return null;
    }

    /**
     * 查看栈顶值
     *
     * @return
     */
    @Override
    public T peek() {
        return null;
    }

    /**
     * 删除元素
     *
     * @param value
     * @return
     */
    @Override
    public boolean remove(T value) {
        return false;
    }

    /**
     * 清空栈
     */
    @Override
    public void clear() {

    }

    /**
     * 是否包含元素
     *
     * @param value
     * @return
     */
    @Override
    public boolean contains(T value) {
        return false;
    }

    /**
     * 栈大小
     *
     * @return
     */
    @Override
    public int size() {
        return 0;
    }
}
