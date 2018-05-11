package one.wangwei.designpatterns.abstractfactory;

/**
 * The type Application.
 */
public class Client {

    private Button button;
    private Checkbox checkbox;

    /**
     * Instantiates a new Application.
     *
     * @param factory the factory
     */
    public Client(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    /**
     * Paint.
     */
    public void paint() {
        button.paint();
        checkbox.paint();
    }
}
