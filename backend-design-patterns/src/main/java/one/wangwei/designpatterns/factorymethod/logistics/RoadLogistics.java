package one.wangwei.designpatterns.factorymethod.logistics;

/**
 * 道路物流
 *
 * @author wangwei
 * @date 2018/05/10
 */
public class RoadLogistics extends BaseLogistics {

    @Override
    protected Transport createTransport() {
        return new Truck();
    }
}
