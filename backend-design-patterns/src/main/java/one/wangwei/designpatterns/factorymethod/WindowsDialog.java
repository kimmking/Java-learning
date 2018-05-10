package one.wangwei.designpatterns.factorymethod;

/**
 * Windows 对话框
 *
 * @author wangwei
 * @date 2018/05/09
 */
public class WindowsDialog extends Dialog {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
