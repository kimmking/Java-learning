package one.wangwei.designpatterns.factorymethod;

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

    protected abstract Transport createTransport();

}
