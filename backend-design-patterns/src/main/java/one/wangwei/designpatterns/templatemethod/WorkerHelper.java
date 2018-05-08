package one.wangwei.designpatterns.templatemethod;

public class WorkerHelper {

    private Worker worker;

    public WorkerHelper(Worker worker) {
        this.worker = worker;
    }

    public void changeWorker(Worker worker) {
        this.worker = worker;
    }

    public void dailyRountine() {
        this.worker.dailyRountine();
    }
}
