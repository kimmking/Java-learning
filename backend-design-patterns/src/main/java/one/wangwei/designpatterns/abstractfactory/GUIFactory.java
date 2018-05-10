package one.wangwei.designpatterns.abstractfactory;

public interface GUIFactory {

    public abstract Button createButton();

    public abstract Checkbox createCheckbox();

}
