package os;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Source implements Iterable<Character> {
    private ArrayList<Character> program = new ArrayList<>();

    public Source(Iterable<Byte> storage, String programName) {
        readProgramFromStorage(storage, programName);
    }

    @Override
    public Iterator<Character> iterator() {
        return new Iterator<>() {
            int current = 0;

            @Override
            public boolean hasNext() {
                return current < program.size() ? true : false;
            }

            @Override
            public Character next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                return program.get(current++);
            }
        };
    }

    private void readProgramFromStorage(Iterable<Byte> storage, String programName) {
        boolean programFound = false;
        int bytesRead = 0;
        String cell = "";

        for (Byte cellByte : storage) {
            // this is correct way to cast byte to char
            // more info: https://stackoverflow.com/a/17912706/5432666
            cell += (char) (cellByte & 0xFF);
            bytesRead++;

            if (bytesRead == 4) {
                if (programFound && cell.trim().toString().equals("END")) {
                    addCell(cell);
                    break;
                }

                if (programFound) {
                    addCell(cell);
                }

                if (cell.toString().equals(programName)) {
                    addCell(cell);
                    programFound = true;
                }

                bytesRead = 0;
                cell = "";
            }
        }
    }

    private void addCell(String cell) {
        for (char symbol : cell.toCharArray()) {
            program.add(symbol);
        }
    }
}
