import java.util.ArrayList;
import java.util.Random;

public class Main {

    private static ArrayList<Process> Processes = new ArrayList<>();

    public static ArrayList<Process> getProcesses() {
        return Processes;
    }

    private static double getRandomDouble(int minRange, int maxRange) {
        Random randGen = new Random();
        return minRange + (maxRange - minRange) * randGen.nextDouble();
    }

    private static void generateProcesses(int N) {
        for(int i = 0; i < N; i++)
            Processes.add(new Process());

        Processes.sort(new sortProcess());
        int t = 0;
        for (Process p: Processes){
            t += p.execTime;
            System.out.println(p.toString());
        }
        System.out.println("T--> " + t);
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
        }
    }
}