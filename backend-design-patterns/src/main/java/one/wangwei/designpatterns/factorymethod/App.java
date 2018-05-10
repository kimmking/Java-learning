package one.wangwei.designpatterns.factorymethod;

public class App {

    private static Dialog dialog;

    public static void main(String[] args) {
        configure();
        runBusinessLogic();

        Logistics logistics = new RoadLogistics();
        logistics.planDelivery();

        Logistics logistics1 = new SeaLogistics();
        logistics1.planDelivery();
    }

    static void configure() {
        if (System.getProperty("os.name").equals("Mac OS X")) {
            dialog = new WindowsDialog();
        } else {
            dialog = new HtmlDialog();
        }
    }

    static void runBusinessLogic() {
        dialog.renderWindow();
    }

}
