package one.wangwei.algorithms.datastructures.queue;

/**
 * 队列接口
 *
 * @param <T>
 * @author wangwei
 * @date 2018/05/03
 */
public interface IQueue<T> {

    /**
     * 添加元素到队列头部
     *
     * @param value
     * @return
     */
    public boolean offer(T value);

    /**
     * 移除队列尾部元素
     *
     * @return
     */
    public T poll();

    /**
     * 查看队列尾部元素值
     *
     * @return
     */
    public T peek();

    /**
     * 从队列中移除元素
     *
     * @param value
     * @return
     */
    public boolean remove(T value);

    /**
     * 清除队列元素
     */
    public void clear();

    /**
     * 队列大小
     */
    public int size();
}
