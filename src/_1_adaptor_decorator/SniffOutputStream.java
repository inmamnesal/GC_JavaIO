package _1_adaptor_decorator;

import java.io.IOException;
import java.io.OutputStream;

public class SniffOutputStream extends OutputStream {
    private final OutputStream delegee;

    public SniffOutputStream(OutputStream delegee) {
        this.delegee = delegee;
    }

    @Override
    public void write(int b) throws IOException {
        System.out.println("wrote 1 byte");
        delegee.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        System.out.println("wrote " + b.length +" bytes");
        delegee.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        System.out.println("wrote " + len +" bytes");
        delegee.write(b, off, len);
    }
}
