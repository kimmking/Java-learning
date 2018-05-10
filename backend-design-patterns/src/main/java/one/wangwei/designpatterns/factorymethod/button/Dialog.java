package one.wangwei.designpatterns.factorymethod.button;

/**
 * 对话框
 */
public abstract class Dialog {

    public void renderWindow() {
        Button button = createButton();
        button.render();
    }

    public abstract Button createButton();

}
