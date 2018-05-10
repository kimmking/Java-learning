package one.wangwei.designpatterns.factorymethod;

public class SeaLogistics extends Logistics {

    @Override
    protected Transport createTransport() {
        return new Ship();
    }
}
