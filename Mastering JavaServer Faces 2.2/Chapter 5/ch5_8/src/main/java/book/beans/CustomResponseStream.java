package book.beans;

import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author Leonard
 */
public class CustomResponseStream extends OutputStream {

    private OutputStream responseStream;

    public CustomResponseStream(OutputStream responseStream) {        
        this.responseStream = responseStream;
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        String s = new String(b, off, len);
        s = s.replace('a', 'A'); 
        byte[] bb = s.getBytes();
        responseStream.write(bb, off, len);
    }

    @Override
    public void write(int b) throws IOException {        
    }
}
