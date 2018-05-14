import os.Source;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
    /**
     *
     * @param args - nThreads, tune, size
     */
    public static void main(String[] args) throws InterruptedException {
        int nThreads = 1;
        boolean isTune = false;
        int size = 10;

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

        OddEvenSort oddEvenSort = new OddEvenSort(list, isTune);

        timeService.start();

        executor.submit(() -> oddEvenSort.sort());
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);

        timeService.stopAndLog(isTune);
    }
}
