package one.wangwei.designpatterns.factorymethod;

import lombok.extern.slf4j.Slf4j;

/**
 * 水路运输
 *
 * @author wangwei
 * @date 2018/05/10
 */
@Slf4j
public class Ship implements Transport {

    /**
     * 发送
     */
    @Override
    public void deliver() {
        log.info("Deliver by sea in a container. ");
    }
}
