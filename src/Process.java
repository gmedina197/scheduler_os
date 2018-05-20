import java.util.Random;

public class Process {
    public double execTime;
    public double arrivalTime;
    public double waitTime;
    public double totalExecTime;

    Process() {
        execTime = this.pickRandom(100);
        arrivalTime = this.pickRandom(20);
        waitTime = 0.0;
    }

    private int pickRandom(int bound) {
        Random r = new Random();
        return Math.abs(r.nextInt(bound));
    }

    @Override
    public String toString() {
        return "<" + arrivalTime + ", " + execTime + ">";
    }
}
