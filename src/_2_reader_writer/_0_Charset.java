package _2_reader_writer;

import java.nio.charset.Charset;
import java.util.SortedMap;

public class _0_Charset {
    public static void main(String[] args) {
        SortedMap<String, Charset> charsetMap = Charset.availableCharsets();
        for (String name : charsetMap.keySet()){
            System.out.println(name);
        }
    }
}
