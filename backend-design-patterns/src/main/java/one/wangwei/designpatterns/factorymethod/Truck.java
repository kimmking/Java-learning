package one.wangwei.designpatterns.factorymethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Truck implements Transport {

    /**
     * 发送
     */
    @Override
    public void deliver() {
        log.info("Deliver by land in a box. ");
    }
}
