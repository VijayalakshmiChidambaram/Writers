package writer;

import java.io.IOException;

public class FileWriterTest extends WriterTest {
  private static final String file = "myfile.dat";

  @Override
  public Writer createInstance() throws IOException {
    return new FileWriter(file);
  }
}