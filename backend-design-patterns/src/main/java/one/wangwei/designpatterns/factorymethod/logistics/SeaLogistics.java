package one.wangwei.designpatterns.factorymethod.logistics;

/**
 * 海运
 *
 * @author wangwei
 * @date 2018/05/10
 */
public class SeaLogistics extends BaseLogistics {

    @Override
    protected Transport createTransport() {
        return new Ship();
    }
}
