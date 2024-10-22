package Sax;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

    public class MiObjectOutputStream extends ObjectOutputStream
    {
        public MiObjectOutputStream(OutputStream out) throws IOException, SecurityException
        {
            super(out);
            //writeStreamHeader();
        }

        @Override
        public void writeStreamHeader() throws IOException {

        }
    }

