package TratadoArchivos;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class MiObjectOutputStream extends ObjectOutputStream
{
public MiObjectOutputStream(FileOutputStream out) throws IOException, SecurityException{
	super(out);
	writeStreamHeader();
}

@Override
public void writeStreamHeader() throws IOException{}
}
