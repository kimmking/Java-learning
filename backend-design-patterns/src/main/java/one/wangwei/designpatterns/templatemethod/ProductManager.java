package one.wangwei.designpatterns.templatemethod;

import lombok.extern.slf4j.Slf4j;

/**
 * 产品经理
 *
 * @author wangwei
 * @date 2018/05/08
 */
@Slf4j
public class ProductManager extends Worker {

    /**
     * 获取姓名
     *
     * @return
     */
    @Override
    protected String getName() {
        return "小伟";
    }

    /**
     * 工作
     *
     * @param name
     */
    @Override
    protected void work(String name) {
        log.info("{} 是位产品经理，主要的工作就是画产品原型", name);
    }
}
