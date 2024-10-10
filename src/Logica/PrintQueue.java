package Logica;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PrintQueue {
    private PriorityQueue<PrintJob> jobs;

    public PrintQueue() {
        jobs = new PriorityQueue<>(new PrintJobComparator());
    }

    public PriorityQueue<PrintJob> getJobs() {
        return jobs;
    }

    public void addJob(PrintJob job) {
        jobs.offer(job);
    }

    public PrintJob removeJob() {
        return jobs.poll();
    }

    public boolean isEmpty() {
        return !jobs.isEmpty();
    }

    public void displayJobs() {
        System.out.println("Current Print Queue:");
        for (PrintJob job : jobs) {
            System.out.println(job);
        }
    }

    /*
    * Se crea una clase para comparar los trabajos*/
    private static class PrintJobComparator implements Comparator<PrintJob> {
        @Override
        public int compare(PrintJob job1, PrintJob job2) {
            int priorityComparison = job2.getPriority().compareTo(job1.getPriority());
            if (priorityComparison != 0) {
                return priorityComparison;
            }
            return job1.getHoraEnvio().compareTo(job2.getHoraEnvio());
        }
    }
}
