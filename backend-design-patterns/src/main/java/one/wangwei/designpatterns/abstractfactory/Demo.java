package one.wangwei.designpatterns.abstractfactory;

public class Demo {

    private static Application application;

    public static void main(String[] args) {
        configure();
        application.paint();
    }

    public static void configure() {
        String osName = System.getProperty("os.name");
        if (!osName.equalsIgnoreCase("Mac OS X")) {
            application = new Application(new MacOSUIFactory());
        } else {
            application = new Application(new WindowsGUIFactory());
        }
    }

}
