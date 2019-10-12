package _0_stream;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class IO_Test_5_OS {
    public static void main(String[] args) throws IOException {
        String fileName = "text.txt";
        InputStream inFile = null;

        try {
            inFile = new FileInputStream(fileName);
            byte[] data = readFullyByByteShort(inFile);
            System.out.println(new String(data,"UTF8"));
        } catch (IOException e) {
            throw new IOException("exception /w open or read file");
        } finally {
           closeQuietly(inFile);
        }

    }

    public static byte[] readFullyByByteShort(InputStream in) throws IOException {
        byte buff[] = new byte[5];
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int count;
        while((count = in.read(buff)) != -1 ){
            out.write(buff, 0 , count);
        }
        return out.toByteArray();
    }

    public static void closeQuietly (InputStream inFile) {
        if(inFile != null) {
            try{
                inFile.close();
            } catch (IOException e) {

            }
        }
    }

}
