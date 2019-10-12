package _0_stream;

import java.io.*;

public class IO_Test_4_OutputStream2 {
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
        //byte buff[] = new byte[5];
        int oneByte;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        while((oneByte = in.read()) != -1){
            out.write(oneByte);
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
