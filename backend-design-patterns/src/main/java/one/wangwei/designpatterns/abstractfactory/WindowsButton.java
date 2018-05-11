package one.wangwei.designpatterns.abstractfactory;

public class WindowsButton extends Button {

    @Override
    public void paint() {
        System.out.println("This is a window button. ");
    }
}
