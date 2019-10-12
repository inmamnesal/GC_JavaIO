package _1_adaptor_decorator;

import java.io.*;
import java.util.zip.GZIPOutputStream;

public class _1_IO_Test_4_4_OutputStreamFZipSniff {
    public static void main(String[] args) throws IOException {
        String fileName1 = "xakep.pdf";
        String fileName2 = "xakep.xxx";

        InputStream in = null;
        OutputStream out = null;

        try {
            in =
//                    new SniffInputStream(
                            new BufferedInputStream(
//                                    new SniffInputStream(
                                            new FileInputStream(fileName1)/*))*/);
            out = /*new SniffOutputStream(*/
                    new GZIPOutputStream(
                            /*new SniffOutputStream(*/
                            new BufferedOutputStream(
                                    new FileOutputStream(fileName2))/*))*/);

            long timeBegin = System.currentTimeMillis();
            copy(in, out);
            long timeEnd = System.currentTimeMillis();
            System.out.println("Elapsed time in mills = " + (timeEnd - timeBegin));

        } catch (IOException e) {
            throw new IOException("Exception when open or copy from '" + fileName1 + " to '" + fileName2, e);
        } finally {
            CloseQuietly(in);
            FlushAndCloseQuietly(out);
        }

    }


    public static void copy (InputStream in, OutputStream out) throws IOException {
        byte[] buff = new byte[256];
        int count;
        while((count = in.read(buff)) != -1){
            out.write(buff,0,count);
        }
    }


    public static void CloseQuietly (InputStream in){
        if (in != null){
            try {
                in.close();
            } catch (IOException e) {

            }
        }
    }

    public static void FlushAndCloseQuietly (OutputStream out){
        if (out != null){
            try {
                out.flush();
            } catch (IOException e) {

            }
            try {
                out.close();
            } catch (IOException e) {

            }
        }
    }


}


//class C{
//    public static void main(String[] args) throws IOException {
//        _0_stream is = new URL("http://www.avito.ru").openStream();
//        long timeBegin = System.currentTimeMillis();
//        while(is.read() != -1){
//            long timeEnd = System.currentTimeMillis();
//            System.out.println("Elapsed time in mills = " + (timeEnd - timeBegin));
//            timeBegin = timeEnd;
//        }
//
//
//
//
//    }
//}
