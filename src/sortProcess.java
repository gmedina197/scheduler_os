import java.util.Comparator;

public class sortProcess implements Comparator<Process> {
    @Override
    public int compare(Process c1, Process c2) {
        return (int)(c1.arrivalTime - c2.arrivalTime);
    }
}