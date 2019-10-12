package _2_reader_writer;

import java.io.*;

public class _2_Charset {
    public static void main(String[] args) throws IOException {
        byte[] rawData = new byte[256];
        for(int k = 0; k < rawData.length; k++){
            rawData[k] = (byte)(k-128);
        }

        InputStream is = new ByteArrayInputStream(rawData);
        Reader reader = new InputStreamReader(is, "UTF-8");

        char[] buff = new char[16];
        int count;
        while ((count = reader.read(buff)) != -1) {
            System.out.println(new String(buff, 0, count));
        }
    }
}
