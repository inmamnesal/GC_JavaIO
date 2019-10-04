import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class IO_Test_2 {
    //демонстрация второго метода read InputStream
    public static void main(String[] args) throws IOException {
        String fileName = "text.txt";
        InputStream inFile = null;

        try {
            inFile = new FileInputStream(fileName);

            readFullyByByteShort(inFile);
        } catch (IOException e) {
           throw new IOException("Exception when open and read file " + fileName);
        } finally {
            if(inFile != null){
                try{
                    inFile.close();
                } catch (IOException ignore){

                }
            }
        }

    }
    public static void readFullyByByte(InputStream in) throws IOException {
        byte[] buff = new byte[5];
        while (true) {
//            byte[] buff = new byte[5];
            int count = in.read(buff);
            if(count != -1){
                System.out.println("count = " + count
                        + ", buff = " + Arrays.toString(buff)
                        + ", str = " + new String(buff, 0,count, "UTF8"));
            } else {
                System.out.println("\n"+"END");
                break;
            }
        }
    }
    public static void readFullyByByteShort(InputStream in) throws IOException {
        byte[] buff = new byte[5];
        int count;
        while ((count = in.read(buff)) != -1) {
            System.out.print(new String(buff,0, count, "UTF8"));
        }
        System.out.println("\n" + "END");
    }

}
