import java.util.ArrayList;

public class RoundRobin {
    private int Quantum;
    private ArrayList<Process> clone;
    private ArrayList<Process> Processes;
    private double totalExec;

    RoundRobin(int Quantum, ArrayList<Process> processes) {
        this.Quantum = Quantum;
        this.clone = processes;
        this.Processes = processes;
        totalExec = 0.0;
    }

    public void run() {
        while(!clone.isEmpty()) {
            for(int i = 0; i < clone.size(); i++) {
                Process p = clone.get(i);
                if(p.execTime < this.Quantum) {
                    this.totalExec += p.execTime;
                    p.execTime = 0;
                    clone.remove(p);
                } else {
                    this.totalExec += this.Quantum;
                    p.execTime -= this.Quantum;
                }
            }
        }
        System.out.println(this.totalExec);
    }
}
