import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class IO_Test_4_OutputStream {
    public static void main(String[] args) throws IOException {
        String fileName1 = "1.jpg";
        String fileName2 = "2.jpg";

        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream(fileName1);
            out = new FileOutputStream(fileName2);
            long timeBegin = System.currentTimeMillis();
            copy(in, out);
            long timeEnd = System.currentTimeMillis();
            System.out.println("Elapsed time in mills = " + (timeEnd - timeBegin));

        }catch (IOException e){
            throw new IOException("Exception when open or copy from '"+fileName1+" to '"+fileName2,e);
        }finally {
            CloseQuietly(in);
            FlushAndCloseQuietly(out);
        }
    }

    public static void copy (FileInputStream in, FileOutputStream out) throws IOException {
        byte[] buff = new byte[64 * 1024];
        int count;
        while((count = in.read(buff)) != -1){
            out.write(buff,0,count);
        }
    }


    public static void CloseQuietly (FileInputStream in){
        if (in != null){
            try {
                in.close();
            } catch (IOException e) {

            }
        }
    }

    public static void FlushAndCloseQuietly (FileOutputStream out){
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
