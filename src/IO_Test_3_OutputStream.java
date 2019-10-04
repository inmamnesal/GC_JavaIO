import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class IO_Test_3_OutputStream {
    public static void main(String[] args) throws IOException {
        String fileName = "text.txt";
        InputStream inFile = null;

        try {
            inFile = new FileInputStream(fileName);
            readFullyByByteShort(inFile);
        } catch (IOException e) {
            throw new IOException("exception /w open or read file");
        } finally {
            if(inFile != null){
                try{
                    inFile.close();
                } catch (IOException ignore){

                }
            }
        }

    }

    public static void readFullyByByteShort(InputStream in) throws IOException {
        int oneByte;
        while((oneByte = in.read()) != -1){

        }
        System.out.println("\n"+"END");
    }

    public static void closeQuietly (InputStream inFile) {
        if(inFile != null) {

        }
    }

}
