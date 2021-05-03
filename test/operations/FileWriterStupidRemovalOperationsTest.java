package operations;

import Operations.StupidRemoverOperation;
import writer.FileWriter;
import writer.Writer;

import java.io.IOException;

public class FileWriterStupidRemovalOperationsTest extends StupidRemovalOperationsTest {
  @Override
  Writer createInstance() throws IOException {
    return new FileWriter("myfile.dat", StupidRemoverOperation::removeStupid);
  }
}
