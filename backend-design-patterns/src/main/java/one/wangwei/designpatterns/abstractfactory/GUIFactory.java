package one.wangwei.designpatterns.abstractfactory;

/**
 * The interface Gui factory.
 */
public interface GUIFactory {

    /**
     * Create button button.
     *
     * @return the button
     */
    public abstract Button createButton();

    /**
     * Create checkbox checkbox.
     *
     * @return the checkbox
     */
    public abstract Checkbox createCheckbox();

}
