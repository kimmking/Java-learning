package one.wangwei.designpatterns.factorymethod.button;

/**
 * 对话框
 */
public abstract class Dialog {

    /**
     * Render window.
     */
    public void renderWindow() {
        Button button = createButton();
        button.render();
    }

    /**
     * Create button button.
     *
     * @return the button
     */
    public abstract Button createButton();

}
