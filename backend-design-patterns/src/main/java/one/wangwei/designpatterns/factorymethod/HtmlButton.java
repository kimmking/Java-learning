package one.wangwei.designpatterns.factorymethod;

/**
 * HTML 按钮
 *
 * @author wangwei
 * @date 2018/05/09
 */
public class HtmlButton implements Button {

    /**
     * 渲染
     */
    @Override
    public void render() {
        System.out.println("<button>Test Button</button>");
        onClick();
    }

    /**
     * 点击
     */
    @Override
    public void onClick() {
        System.out.println("Click! Button says - 'Hello World!'");
    }
}
