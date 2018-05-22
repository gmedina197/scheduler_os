import java.util.ArrayList;

public class FCFS {
    private ArrayList<Process> Processes;
    private int totalExec;

    FCFS(ArrayList<Process> Processes){
        this.Processes = new ArrayList<>(Processes);
    }

    public void run(){
        totalExec = Processes.get(0).arrivalTime;
        for(Process p: Processes) {
            totalExec += p.execTime;
            p.totalExecTime = totalExec - p.arrivalTime;
            p.waitTime = p.totalExecTime - p.execTimeOriginal;
        }

        System.out.println("EXEC | CPU | TOTAL | ESPERA");
        for(Process p: Processes) {
            System.out.println(p.toString());
        }
    }
}
