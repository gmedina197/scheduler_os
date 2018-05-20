import java.util.ArrayList;

public class RoundRobin {
    private int Quantum;
    private ArrayList<Process> clone;
    private ArrayList<Process> Processes;
    private double totalExec;

    RoundRobin(int Quantum, ArrayList<Process> processes) {
        this.Quantum = Quantum;
        this.clone = new ArrayList<>(processes);
        this.Processes = new ArrayList<>(processes);
        totalExec = 0.0;
    }

    private boolean checkZero() {
        for(Process p: clone) {
            if(p.execTime != 0) return false;
        }
        return true;
    }

    public void run() {
        for(Process p: clone) {
            System.out.println(p.toString());
        }
        while (!checkZero()) {
            for (Process p: clone) {
                if(p.execTime == 0) continue;
                if(p.execTime < Quantum) {
                    totalExec += p.execTime;
                    p.execTime = 0;
                    p.totalExecTime = totalExec - p.arrivalTime;
                    p.waitTime = p.totalExecTime - p.execTime;
                } else {
                    totalExec += Quantum;
                    p.execTime -= Quantum;
                    p.totalExecTime = totalExec;
                }
            }
        }

        System.out.println("EXEC | CPU | TOTAL | ESPERA");
        for(Process p: clone) {
            System.out.println(p.toString());
        }
    }

    public ArrayList<Process> getProcesses() {
        return this.Processes;
    }
}
