package one.wangwei.designpatterns.abstractfactory;

public class App {

    private static Client application;

    public static void main(String[] args) {
        configure();
        application.paint();
    }

    public static void configure() {
        String osName = System.getProperty("os.name");
        if (!osName.equalsIgnoreCase("Mac OS X")) {
            application = new Client(new MacOSGUIFactory());
        } else {
            application = new Client(new WindowsGUIFactory());
        }
    }

}
