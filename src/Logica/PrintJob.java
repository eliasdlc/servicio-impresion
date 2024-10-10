package Logica;


import java.time.LocalTime;

public class PrintJob {
    private String user;
    private LocalTime horaEnvio;
    private Priority priority;


    public PrintJob(String user, LocalTime horaEnvio, Priority priority) {
        this.user = user;
        this.horaEnvio = horaEnvio;
        this.priority = priority;
    }
    public PrintJob(String user, LocalTime horaEnvio) {
        this.user = user;
        this.horaEnvio = horaEnvio;
        this.priority = Priority.M;
    }

    public String getUser() {
        return user;
    }

    public LocalTime getHoraEnvio() {
        return horaEnvio;
    }

    public Priority getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "PrintJob{" +
                "user='" + user + '\'' +
                ", horaEnvio='" + horaEnvio + '\'' +
                ", priority=" + priority.toString() +
                '}';
    }
}

