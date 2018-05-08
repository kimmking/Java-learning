package one.wangwei.designpatterns.templatemethod;

public class App {

    public static void main(String[] args) {
        WorkerHelper workerHelper = new WorkerHelper(new ProductManager());
        workerHelper.dailyRountine();

        workerHelper.changeWorker(new Programmer());
        workerHelper.dailyRountine();

        workerHelper.changeWorker(new UIDesigner());
        workerHelper.dailyRountine();
    }

}
