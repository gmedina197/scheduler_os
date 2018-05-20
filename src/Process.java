import java.util.Random;

public class Process {
    public double execTime;
    public double arrivalTime;
    public double waitTime;
    public double totalExecTime;

    Process() {
        execTime = getRandomDouble(1,10);
        arrivalTime = getRandomDouble(1,5);
        waitTime = 0.0;
    }

    private static int getRandomDouble(int minRange, int maxRange) {
        Random randGen = new Random();
        return (int)(minRange + (maxRange - minRange) * randGen.nextDouble());
    }

    @Override
    public String toString() {
        return arrivalTime + "     " + execTime+ "     " + totalExecTime + "     " + waitTime;
    }
}
