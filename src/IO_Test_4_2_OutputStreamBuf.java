import java.io.*;

public class IO_Test_4_2_OutputStreamBuf {
    public static void main(String[] args) throws IOException {
        String fileName1 = "1.jpg";
        String fileName2 = "2.jpg";

        for(int k = 1; k <= 1024*1024; k *= 2) {
            InputStream in = null;
            OutputStream out = null;

            try {
                in = new BufferedInputStream(
                        new FileInputStream(fileName1),k);
                out = new BufferedOutputStream(
                        new FileOutputStream(fileName2),k);
                long timeBegin = System.currentTimeMillis();
                copy0(in, out);
                long timeEnd = System.currentTimeMillis();
                System.out.println("Elapsed time in mills = " + (timeEnd - timeBegin));

            } catch (IOException e) {
                throw new IOException("Exception when open or copy from '" + fileName1 + " to '" + fileName2, e);
            } finally {
                CloseQuietly(in);
                FlushAndCloseQuietly(out);
            }
        }
    }

    public static void copy0 (InputStream in, OutputStream out) throws IOException {
        int oneByte;
        while((oneByte = in.read()) != -1){
            out.write(oneByte);
        }
    }

    public static void copy1 (InputStream in, OutputStream out) throws IOException {
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
//        InputStream is = new URL("http://www.avito.ru").openStream();
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
