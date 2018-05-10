package one.wangwei.designpatterns.factorymethod.button;

/**
 * HTML 对话框
 *
 * @author wangwei
 * @date 2018/05/09
 */
public class HtmlDialog extends Dialog {

    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
