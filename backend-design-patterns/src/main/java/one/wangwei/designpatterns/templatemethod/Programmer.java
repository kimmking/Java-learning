package one.wangwei.designpatterns.templatemethod;

import lombok.extern.slf4j.Slf4j;

/**
 * 程序员
 *
 * @author wangwei
 * @date 2018/05/08
 */
@Slf4j
public class Programmer extends Worker {

    /**
     * 获取姓名
     *
     * @return
     */
    @Override
    protected String getName() {
        return "小明";
    }

    /**
     * 工作
     *
     * @param name
     */
    @Override
    protected void work(String name) {
        log.info("{} 是名程序猿，主要的工作是编写程序", name);
    }

    /**
     * 放松休息
     *
     * @param name
     */
    @Override
    public void relax(String name) {
        log.info("{} 喜欢跑步来放松心情", name);
    }
}
