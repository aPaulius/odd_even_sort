import java.sql.SQLOutput;
import java.sql.Time;

public class TimeService {
    private long start;
    private long elapsedTime;

    public void start() {
        start = System.currentTimeMillis();
    }

    public void stopAndLog(boolean isTune) {
        elapsedTime = System.currentTimeMillis() - start;

        if (!isTune) {
            System.out.format("Elapsed time: %sms\n", elapsedTime);
        }
    }
}
