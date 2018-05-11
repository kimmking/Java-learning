package one.wangwei.designpatterns.abstractfactory;

/**
 * The type Mac osgui factory.
 */
public class MacOSGUIFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}
