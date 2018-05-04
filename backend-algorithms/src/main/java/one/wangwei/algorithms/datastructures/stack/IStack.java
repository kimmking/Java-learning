package one.wangwei.algorithms.datastructures.stack;


/**
 * 栈
 *
 * @author wangwei
 * @date 2018/05/04
 */
public interface IStack<T> {

    /**
     * 入栈
     *
     * @param value
     * @return
     */
    public boolean push(T value);

    /**
     * 出栈
     *
     * @return
     */
    public T pop();

    /**
     * 查看栈顶值
     *
     * @return
     */
    public T peek();

    /**
     * 删除元素
     *
     * @param value
     * @return
     */
    public boolean remove(T value);

    /**
     * 清空栈
     */
    public void clear();

    /**
     * 是否包含元素
     *
     * @param value
     * @return
     */
    public boolean contains(T value);

    /**
     * 栈大小
     *
     * @return
     */
    public int size();

}
