package Logica;

import java.time.LocalTime;

public class PrintService {
    private PrintQueue queue;

    public PrintService() {
        this.queue = new PrintQueue();
    }

    public void addJob(PrintJob job) {
        queue.addJob(job);
    }

    /*
    * Se encarga de procesar los trabajos mediante la prioridad de los mismos.
    * Primero divide el queue en tres diferentes "queues" para poder manejarlos mas facilmente y de una manera organizada
    * Luego de eso se procesa cada trabajo empezando desde el de prioridad mas alta, se usa como condicion la hora en
    * la que el trabajo fue mandado. Cuando se encuentra el primer trabajo en el sub-queue se proceso y luego se elimina para
    * seguir con el siguiente. */
    public void processJobs() {
        while (queue.isEmpty()) {


            PrintQueue auxHQueue = new PrintQueue();
            PrintQueue auxMQueue = new PrintQueue();
            PrintQueue auxLQueue = new PrintQueue();

            for (PrintJob job : queue.getJobs()) {
                if( job.getPriority() == Priority.H ){
                    auxHQueue.addJob(job);
                } else if ( job.getPriority() == Priority.M ){
                    auxMQueue.addJob(job);
                } else {
                    auxLQueue.addJob(job);
                }
            }

            LocalTime latestTime = LocalTime.of(0, 0, 0);
            for (PrintJob job : auxHQueue.getJobs()){
                if ( job.getHoraEnvio().isAfter(latestTime) ){
                    System.out.println("Processing job: " + job);

                } else {
                    continue;
                }
                job = queue.removeJob();
            }
            for (PrintJob job : auxMQueue.getJobs()){
                if ( job.getHoraEnvio().isAfter(latestTime) ){
                    System.out.println("Processing job: " + job);

                } else {
                    continue;
                }
                job = queue.removeJob();
            }
            for (PrintJob job : auxLQueue.getJobs()){
                if ( job.getHoraEnvio().isAfter(latestTime) ){
                    System.out.println("Processing job: " + job);

                } else {
                    continue;
                }
                job = queue.removeJob();
            }
        }
    }

    public void displayQueue() {
        queue.displayJobs();
    }
}
