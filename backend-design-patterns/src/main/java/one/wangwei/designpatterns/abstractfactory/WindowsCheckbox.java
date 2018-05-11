package one.wangwei.designpatterns.abstractfactory;

public class WindowsCheckbox extends Checkbox {

    @Override
    public void paint() {
        System.out.println("You had created windows checkbox. ");
    }
}
