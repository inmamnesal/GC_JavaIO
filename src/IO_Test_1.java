import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class IO_Test_1 {
    public static void main(String[] args) throws IOException {
        String fileName = "text.txt";
        InputStream inFile = null;

        try {
            inFile = new FileInputStream(fileName);
            //readFullyByByte(inFile);
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
        while (true) {
            int oneByte = in.read();
            if(oneByte != -1){
                System.out.print((char) oneByte);
            } else {
                System.out.println("\n"+"END");
                break;
            }
        }
    }
    public static void readFullyByByteShort(InputStream in) throws IOException {
        int oneByte;
        while((oneByte = in.read()) != -1){
            System.out.print((char) oneByte);
        }
        System.out.println("\n"+"END");
    }
}
