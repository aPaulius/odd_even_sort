package os;

import os.Source;

import java.util.Arrays;

public class App {
    public static void main(String[] args) throws InterruptedException {

        Byte[] storage = {
                Byte.valueOf((byte) 's'),
                Byte.valueOf((byte) 'a'),
                Byte.valueOf((byte) 'v'),
                Byte.valueOf((byte) 'e'),
                Byte.valueOf((byte) 'o'),
                Byte.valueOf((byte) 'p'),
                Byte.valueOf((byte) 'a'),
                Byte.valueOf((byte) '1'),
                Byte.valueOf((byte) 'E'),
                Byte.valueOf((byte) 'N'),
                Byte.valueOf((byte) 'D'),
                Byte.valueOf((byte) ' '),
                Byte.valueOf((byte) 'l'),
                Byte.valueOf((byte) 'o'),
                Byte.valueOf((byte) 'a'),
                Byte.valueOf((byte) 'd'),
                Byte.valueOf((byte) 'o'),
                Byte.valueOf((byte) 'p'),
                Byte.valueOf((byte) 'a'),
                Byte.valueOf((byte) '2'),
                Byte.valueOf((byte) 'E'),
                Byte.valueOf((byte) 'N'),
                Byte.valueOf((byte) 'D'),
                Byte.valueOf((byte) ' '),
                Byte.valueOf((byte) 'a'),
                Byte.valueOf((byte) 'd'),
                Byte.valueOf((byte) 'd'),
                Byte.valueOf((byte) ' '),
                Byte.valueOf((byte) 'E'),
                Byte.valueOf((byte) 'N'),
                Byte.valueOf((byte) 'D'),
                Byte.valueOf((byte) ' '),
        };

        Iterable<Byte> byteIterable = Arrays.asList(storage);

        Source source = new Source(byteIterable, "load");

        for (Character character : source) {
            for (byte b : character.toString().getBytes()) {
                System.out.println(b);
            }
        }
    }
}
