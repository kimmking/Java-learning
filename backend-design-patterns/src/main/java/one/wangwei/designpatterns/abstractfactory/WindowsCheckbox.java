package one.wangwei.designpatterns.abstractfactory;

public class WindowsCheckbox implements Checkbox {

    @Override
    public void paint() {
        System.out.println("You had created windows checkbox. ");
    }
}
