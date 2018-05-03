package one.wangwei.algorithms.datastructures.list.impl;

import one.wangwei.algorithms.datastructures.list.interfaces.IList;

/**
 * 双向链表结构
 *
 * @param <T>
 * @author wangwei
 * @date 2018/04/28
 */
public class DoublyLinkedList<T> implements IList<T> {

    /**
     * 集合大小
     */
    private int size = 0;
    /**
     * 头部元素
     */
    private Node<T> head = null;
    /**
     * 尾部元素
     */
    private Node<T> tail = null;

    /**
     * 添加元素
     *
     * @param element
     * @return
     */
    @Override
    public boolean add(T element) {
        return addLast(element);
    }

    /**
     * 添加元素
     *
     * @param index
     * @param element
     * @return
     */
    @Override
    public boolean add(int index, T element) {
        checkElementIndex(index);
        if (index == size) {
            return add(element);
        } else {
            return addBefore(element, node(index));
        }
    }

    /**
     * 末端元素添加
     *
     * @param element
     * @return
     */
    private boolean addLast(T element) {
        final Node<T> last = tail;
        Node<T> newElement = new Node<>(last, element, null);
        tail = newElement;
        if (last == null) {
            head = newElement;
        } else {
            last.next = newElement;
        }
        size++;
        return true;
    }

    /**
     * 插入元素
     *
     * @param element
     * @param target
     * @return
     */
    private boolean addBefore(T element, Node<T> target) {
        Node<T> pred = target.prev;
        Node<T> newElement = new Node<>(pred, element, target);
        target.prev = newElement;
        if (pred == null) {
            head = newElement;
        } else {
            pred.next = newElement;
        }
        size++;
        return true;
    }

    /**
     * 移除元素
     *
     * @param element
     * @return
     */
    @Override
    public boolean remove(T element) {
        if (element == null) {
            for (Node<T> x = head; x != null; x = x.next) {
                if (x.element == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<T> x = head; x != null; x = x.next) {
                if (element.equals(x.element)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 删除 index 位置上的元素
     *
     * @param index
     * @return
     */
    @Override
    public T remove(int index) {
        checkElementIndex(index);
        return unlink(node(index));
    }

    /**
     * 返回 index 位置上的元素
     *
     * @param index
     * @return
     */
    private Node<T> node(int index) {
        // 二分查找
        if (index < (size >> 1)) {
            Node<T> x = head;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        } else {
            Node<T> x = tail;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
            return x;
        }
    }

    /**
     * 卸载元素
     *
     * @param node
     */
    private T unlink(Node<T> node) {
        final T element = node.element;
        final Node<T> prev = node.prev;
        final Node<T> next = node.next;

        // 删除head元素
        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        // 删除tail元素
        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }

        node.element = null;
        size--;
        return element;
    }

    private void checkElementIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    /**
     * 设置index上的元素
     *
     * @param index
     * @param element
     * @return
     */
    @Override
    public T set(int index, T element) {
        checkElementIndex(index);
        Node<T> oldNode = node(index);
        T oldElement = oldNode.element;
        oldNode.element = element;
        return oldElement;
    }

    /**
     * 清空list集合
     */
    @Override
    public void clear() {
        for (Node<T> x = head; x != null; ) {
            Node<T> next = x.next;
            x.element = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        head = tail = null;
        size = 0;
    }

    /**
     * 判断是否包含某个元素
     *
     * @param element
     */
    @Override
    public boolean contains(T element) {
        if (element == null) {
            for (Node<T> x = head; x != null; x = x.next) {
                if (x.element == null) {
                    return true;
                }
            }
        } else {
            for (Node<T> x = head; x != null; x = x.next) {
                if (element.equals(x.element)) {
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

    /**
     * 节点
     *
     * @param <T>
     */
    private class Node<T> {

        private T element = null;
        private Node<T> prev = null;
        private Node<T> next = null;

        public Node(Node<T> prev, T element, Node<T> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

}
