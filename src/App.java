import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
    /**
     *
     * @param args - nThreads, tune, size
     */
    public static void main(String[] args) throws InterruptedException {
        int nThreads = 32;
        boolean isTune = false;
        int size = 10000;

        try {
            nThreads = Integer.parseInt(args[0]);
        } catch (Exception e) {}


        try {
            if (args[1].equals("tune")) isTune = true;
        } catch (Exception e) {}

        try {
            size = Integer.parseInt(args[2]);
        } catch (Exception e) {}


        TimeService timeService = new TimeService();
        DataService dataService = new DataService();

        ExecutorService executor = Executors.newFixedThreadPool(nThreads);

        ArrayList list = dataService.generateArray(size);

        final OddEvenSort oddEvenSort = new OddEvenSort(list, isTune);

        timeService.start();



        executor.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    oddEvenSort.sort();
                } catch (InterruptedException e) {

                }
            }
        });


        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);

        timeService.stopAndLog(isTune);
    }
}
