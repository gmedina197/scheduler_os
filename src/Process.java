import java.util.Random;

public class Process {
    public double execTimeOriginal;
    public double execTime;
    public double arrivalTime;
    public double waitTime;
    public double totalExecTime;

    Process() {
        execTimeOriginal = getRandomDouble(1,10);
        execTime = execTimeOriginal;
        arrivalTime = getRandomDouble(1,5);
        waitTime = 0.0;
    }

    private static int getRandomDouble(int minRange, int maxRange) {
        Random randGen = new Random();
        return (int)(minRange + (maxRange - minRange) * randGen.nextDouble());
    }

    @Override
    public String toString() {
        return arrivalTime + "\t\t" + execTimeOriginal+ "\t\t" + totalExecTime + "\t\t" + waitTime;
    }
}
