package operations;

import Operations.UpperCaseOperation;
import writer.FileWriter;
import writer.Writer;

import java.io.IOException;

public class FileWriterUpperCaseOperationsTest extends UpperCaseWriteOperationsTest{
  @Override
  Writer createInstance() throws IOException {
    return new FileWriter("myfile.dat", UpperCaseOperation::toUpperCase);
  }
}
