package _0_stream;

import java.io.*;

public class IO_Test_6_copyImg {
    public static void main(String[] args) throws IOException {
        String fileNameIn = "1.jpg";
        String fileNameOut = "2.jpg";

        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream(fileNameIn);
            out = new FileOutputStream(fileNameOut);
            copy(in,out);

        } catch (IOException e) {
            throw new IOException("Custom exception ", e);
        } finally {
            closeQuietly(in);
            closeAndFlushQuietly(out);
        }


    }

    public static void copy(FileInputStream in, FileOutputStream out) throws IOException {
        byte[] buff = new byte[64 * 1024];
        int count;
        while((count = in.read(buff)) != -1){
            out.write(buff, 0, count);
        }
    }




    public static void closeQuietly (InputStream in) {
        if(in != null) {
            try{
                in.close();
            } catch (IOException e) {

            }
        }
    }

    public static void closeAndFlushQuietly (OutputStream out) {
        if(out != null) {
            try{
                out.flush();
                out.close();
            } catch (IOException e) {

            }
        }
    }
}
