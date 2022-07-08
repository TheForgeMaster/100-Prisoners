import java.util.ArrayList;

public class TimeLog {
    ArrayList<Long> log = new ArrayList<>();
    TimeLog(){
        logTime();
    }

    public void logTime(){
        log.add((long)System.nanoTime());
    }

    public void displayLog(){
        for(int i = 1; i < log.size(); i++)
        {
            System.out.println("Log " +i + ": " + (log.get(i) - log.get(i-1)));
        }
    }
}
