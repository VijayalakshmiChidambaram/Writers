package operations;

import Operations.DuplicateRemoverOperation;
import writer.FileWriter;
import writer.Writer;

import java.io.IOException;

public class FileWriterDuplicateRemovalOperationsTest extends DuplicateRemovalOperationsTest {
  @Override
  Writer createInstance() throws IOException {
    return new FileWriter("myfile.dat", DuplicateRemoverOperation::removeDuplicate);
  }
}
