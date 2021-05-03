package operations;

import Operations.LowerCaseOperation;
import writer.FileWriter;
import writer.Writer;
import java.io.IOException;

class FileWriterLowerCaseOperationsTest extends LowerCaseWriteOperationsTest {
  @Override
  public Writer createInstance() throws IOException {
    return new FileWriter("myfile.dat", LowerCaseOperation::toLowerCase);
  }
}
