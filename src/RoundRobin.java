import java.util.ArrayList;

public class RoundRobin {
    private int Quantum;
    private ArrayList<Process> Processes;
    private double totalExec;

    RoundRobin(int Quantum, ArrayList<Process> processes) {
        this.Quantum = Quantum;
        this.Processes = new ArrayList<>(processes);
    }

    public void run() {

        totalExec = Processes.get(0).arrivalTime;
        System.out.println("QUANTUM = " + Quantum);

        while(true) {
            boolean done = true;

            for(Process p: Processes) {
                if(p.execTime > 0) {
                    done = false;
                    if(p.execTime > Quantum) {
                        totalExec += Quantum;
                        p.execTime -= Quantum;
                    }else {
                        totalExec += p.execTime;
                        p.totalExecTime = totalExec - p.arrivalTime;
                        p.waitTime = p.totalExecTime - p.execTimeOriginal;
                        p.execTime = 0;
                    }
                }
            }

            if(done)
                break;
        }

        System.out.println("TOTAL = " + totalExec);

        System.out.println("EXEC | CPU | TOTAL | ESPERA");
        for(Process p: Processes) {
            System.out.println(p.toString());
        }
    }

    public ArrayList<Process> getProcesses() {
        return this.Processes;
    }
}
