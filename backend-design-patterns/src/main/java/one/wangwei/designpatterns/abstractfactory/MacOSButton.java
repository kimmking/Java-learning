package one.wangwei.designpatterns.abstractfactory;

public class MacOSButton extends Button {

    @Override
    public void paint() {
        System.out.println("This is a mac os button. ");
    }
}
