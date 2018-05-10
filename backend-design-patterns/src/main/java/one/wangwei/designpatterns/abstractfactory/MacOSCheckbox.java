package one.wangwei.designpatterns.abstractfactory;

public class MacOSCheckbox implements Checkbox {

    @Override
    public void paint() {
        System.out.println("You had created mac os checkbox");
    }
}
