package one.wangwei.designpatterns.factorymethod.logistics;

/**
 * 物流
 *
 * @author wangwei
 * @date 2018/05/10
 */
public abstract class BaseLogistics {

    public void planDelivery() {
        Transport transport = createTransport();
        transport.deliver();
    }

    /**
     * 创建运输方式
     *
     * @return
     */
    protected abstract Transport createTransport();

}
