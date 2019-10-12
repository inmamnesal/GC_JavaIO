package _1_adaptor_decorator;

import java.io.*;
import java.util.Arrays;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class _2_adapter_DataInput {
    public static void main(String[] args) throws IOException {
        writeToFile();
        readFromFile();
    }

    private static void writeToFile() throws IOException {
        byte age = 45;
        String name = "Mike";
        int[] salaryArr = {200, 300, 240, 150};

        GZIPOutputStream outputStream =
                new GZIPOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(
                                        new File("tmp.bin"))));
        DataOutput dataOut = new DataOutputStream(outputStream);

        dataOut.writeByte(age);
        dataOut.writeUTF(name);
        dataOut.writeInt(salaryArr.length);
        for(int salaryElem : salaryArr){
            dataOut.writeInt(salaryElem);
        }
        outputStream.flush();
        outputStream.close();
    }

    private static void readFromFile() throws IOException {
        GZIPInputStream inputStream =
                new GZIPInputStream(
                        new BufferedInputStream(
                                new FileInputStream(
                                        new File("tmp.bin"))));

        DataInput dataIn = new DataInputStream(inputStream);

        byte age = dataIn.readByte();
        String name = dataIn.readUTF();
        int[] salaryArr = new int[dataIn.readInt()];
        for (int i = 0; i < salaryArr.length; i++) {
            salaryArr[i] = dataIn.readInt();
        }
        inputStream.close();

        System.out.println("age = " + age);
        System.out.println("name = " + name);
        System.out.println("salaryArr = " + Arrays.toString(salaryArr));
    }




}
