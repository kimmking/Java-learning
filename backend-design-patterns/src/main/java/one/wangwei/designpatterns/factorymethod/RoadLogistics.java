package one.wangwei.designpatterns.factorymethod;

public class RoadLogistics extends Logistics {

    @Override
    protected Transport createTransport() {
        return new Truck();
    }
}
