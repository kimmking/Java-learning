package one.wangwei.designpatterns.factorymethod.logistics;

/**
 * 客户端
 *
 * @author wangwei
 * @date 2018/05/10
 */
public class App {

    public static void main(String[] args) {

        BaseLogistics logistics = new RoadLogistics();
        logistics.planDelivery();

        BaseLogistics logistics1 = new SeaLogistics();
        logistics1.planDelivery();
    }

}
