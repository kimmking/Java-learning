package one.wangwei.algorithms.datastructures.queue.impl;

import one.wangwei.algorithms.datastructures.queue.IQueue;

/**
 * 链表队列
 *
 * @param <T>
 * @author wangwei
 * @date 2018/05/07
 */
public class LinkedQueue<T> implements IQueue<T> {

    /**
     * 添加元素到队列头部
     *
     * @param value
     * @return
     */
    @Override
    public boolean offer(T value) {
        return false;
    }

    /**
     * 移除队列尾部元素
     *
     * @return
     */
    @Override
    public T poll() {
        return null;
    }

    /**
     * 查看队列尾部元素值
     *
     * @return
     */
    @Override
    public T peek() {
        return null;
    }

    /**
     * 从队列中移除元素
     *
     * @param value
     * @return
     */
    @Override
    public boolean remove(T value) {
        return false;
    }

    /**
     * 清除队列元素
     */
    @Override
    public void clear() {

    }

    /**
     * 队列大小
     */
    @Override
    public int size() {
        return 0;
    }
}
