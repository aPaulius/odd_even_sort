import java.util.ArrayList;

public class OddEvenSort {
    private final Object lock = new Object();
    private ArrayList<Integer> list;
    private boolean sorted;
    private boolean isTune;

    public OddEvenSort(ArrayList<Integer> list, boolean isTune) {
        this.list = list;
        this.isTune = isTune;
    }

    public ArrayList<Integer> sort() throws InterruptedException {
        sorted = false;

        synchronized (lock) {
            while (!sorted) {
                sorted = true;

                sort(0);
                sort(1);
            }
        }

        return list;
    }

    private void sort(int start) throws InterruptedException {
        for (int i = start; i < list.size() - 1; i += 2) {
            if (list.get(i).intValue() > list.get(i+1).intValue()) {
                if (isTune) log(i);

                swap(list, i, i+1);
                sorted = false;
            }
        }
    }

    private void swap(ArrayList<Integer> list, int i, int j) {
        Integer itemI = list.get(i);
        list.set(i, list.get(j));
        list.set(j, itemI);
    }

    private void log(int i) throws InterruptedException {

        for (int number : list) {
            if (number == list.get(i)) {
                System.out.print(">" + number + " ");
            } else if (number == list.get(i+1)) {
                System.out.print("" + number + "<");
            } else {
                System.out.print(" " + number + " ");
            }
        }

        System.out.println();

        Thread.sleep(3000);
    }
}
