package Logica;

public class PrintManager {
    private PrintService service;

    public PrintManager(PrintService service) {
        this.service = service;
    }

    public void addJob(PrintJob job) {
        service.addJob(job);
    }

    public void processJobs() {
        service.processJobs();
    }

    public void displayQueue() {
        service.displayQueue();
    }
}
