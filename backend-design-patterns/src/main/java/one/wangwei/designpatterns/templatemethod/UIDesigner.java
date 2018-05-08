package one.wangwei.designpatterns.templatemethod;

import lombok.extern.slf4j.Slf4j;

/**
 * UI 设计师
 *
 * @author wangwei
 * @date 2018/05/08
 */
@Slf4j
public class UIDesigner extends Worker {

    /**
     * 获取姓名
     *
     * @return
     */
    @Override
    protected String getName() {
        return "小美";
    }

    /**
     * 工作
     *
     * @param name
     */
    @Override
    protected void work(String name) {
        log.info("{} 是位UI设计师，每天的工作主要是设计UI界面", name);
    }

    /**
     * 放松休息
     *
     * @param name
     */
    @Override
    public void relax(String name) {
        log.info("{} 喜欢看韩剧来放松心情", name);
    }
}
