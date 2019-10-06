package adaptor_decorator;

import java.io.IOException;
import java.io.InputStream;

public class SniffInputStream extends InputStream {
    private final InputStream delegee;


    public SniffInputStream(InputStream delegee) {
        this.delegee = delegee;
    }


    @Override
    public int read() throws IOException {
        System.out.println("read: 1byte");
        return this.delegee.read();
    }

    @Override
    public int read(byte[] b) throws IOException {
        int read = delegee.read(b);
        System.out.println("read: " + read);
        return read;
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int read = delegee.read(b, off, len);
        System.out.println("read: " + read);
        return read;
    }
}
