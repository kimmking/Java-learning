package one.wangwei.algorithms.datastructures.list.interfaces;

/**
 * 线性表接口
 *
 * @param <T>
 * @author wangwei
 * @date 2018/04/27
 */
public interface IList<T> {

    /**
     * 添加元素
     *
     * @param element
     * @return
     */
    public boolean add(T element);

    /**
     * 在index处添加元素
     *
     * @param index
     * @param element
     * @return
     */
    public boolean add(int index, T element);

    /**
     * 移除元素
     *
     * @param element
     * @return
     */
    public boolean remove(T element);

    /**
     * 删除 index 位置上的元素
     *
     * @param index
     * @return
     */
    public T remove(int index);

    /**
     * 设置index上的元素
     *
     * @param index
     * @param element
     * @return
     */
    public T set(int index, T element);

    /**
     * 清空list集合
     */
    public void clear();

    /**
     * 判断是否包含某个元素
     *
     * @param element
     */
    public boolean contains(T element);

    /**
     * 集合大小
     *
     * @return
     */
    public int size();

}
