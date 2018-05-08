package one.wangwei.designpatterns.templatemethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class Worker {

    /**
     * 每日日程安排
     */
    public void dailyRountine() {
        String name = getName();
        getUp(name);
        eatBreakfast(name);
        goToWork(name);
        work(name);
        goBackHome(name);
        relax(name);
        sleep(name);
        System.out.println("\n");
    }

    /**
     * 获取姓名
     *
     * @return
     */
    protected abstract String getName();

    /**
     * 起床
     */
    public void getUp(String name) {
        log.info("{} 起床了", name);
    }

    /**
     * 吃早餐
     */
    public void eatBreakfast(String name) {
        log.info("{} 吃早餐", name);
    }

    /**
     * 去上班
     */
    public void goToWork(String name) {
        log.info("{} 要去上班了", name);
    }

    /**
     * 工作
     */
    protected abstract void work(String name);

    /**
     * 下班回家
     */
    public void goBackHome(String name) {
        log.info("{} 忙完工作，下班回家了", name);
    }

    /**
     * 放松休息
     */
    public void relax(String name) {
        log.info("{} 看美剧，放松一下", name);
    }

    /**
     * 入睡
     */
    public void sleep(String name) {
        log.info("{} 开始睡觉了", name);
    }

}
