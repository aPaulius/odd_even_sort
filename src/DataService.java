import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.stream.IntStream;

public class DataService {
    public ArrayList<Integer> generateArray(int size) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            list.add(i);
        }

        Collections.shuffle(list);

        return list;
    }
}
