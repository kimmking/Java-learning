package one.wangwei.designpatterns.factorymethod;

public abstract class Logistics {

    public void planDelivery() {
        Transport transport = createTransport();
        transport.deliver();
    }

    protected abstract Transport createTransport();

}
