package one.wangwei.designpatterns.factorymethod.button;

/**
 * 按钮
 *
 * @author wangwei
 * @date 2018/05/09
 */
public interface Button {

    /**
     * 渲染
     */
    public void render();

    /**
     * 点击
     */
    public void onClick();

}
