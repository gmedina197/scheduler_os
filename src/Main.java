import java.util.ArrayList;
import java.util.Random;

public class Main {

    private static ArrayList<Process> Processes = new ArrayList<>();

    public static ArrayList<Process> getProcesses() {
        return Processes;
    }

    private static void generateProcesses(int N) {
        for(int i = 0; i < N; i++)
            Processes.add(new Process());
        Processes.sort(new sortProcess());
    }

    public static void main(String[] args) {
        Random r = new Random();
        Integer N, q; //n processes
        RoundRobin rr;

        if(args[0].equals("rr")) {
            N = Integer.parseInt(args[1]);
            q = Integer.parseInt(args[2]);
            generateProcesses(N);
            rr = new RoundRobin(q, Processes);
            rr.run();
            Processes = rr.getProcesses();
        }
    }
}