import Logica.*;
import java.time.LocalTime;


public class Main {
    public static void main(String[] args) {
        PrintService printService = new PrintService();
        PrintManager printManager = new PrintManager(printService);

        printManager.addJob(new PrintJob("User1", LocalTime.of(3, 10, 10), Priority.M));
        printManager.addJob(new PrintJob("User2", LocalTime.of(5, 50, 10), Priority.L));
        printManager.addJob(new PrintJob("User3", LocalTime.of(9, 30, 10), Priority.H));
        printManager.addJob(new PrintJob("User4", LocalTime.of(1, 10, 10), Priority.L));
        printManager.addJob(new PrintJob("User5", LocalTime.of(12, 0, 10), Priority.M));
        printManager.addJob(new PrintJob("User6", LocalTime.of(10, 10, 10), Priority.H));
        printManager.addJob(new PrintJob("User7", LocalTime.of(9, 30, 5), Priority.H));
        printManager.addJob(new PrintJob("User8", LocalTime.of(1, 30, 10), Priority.L));

        printManager.displayQueue();

        printManager.processJobs();

        printManager.displayQueue();
    }
}