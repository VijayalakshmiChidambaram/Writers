package operations;

import Operations.StupidRemoverOperation;
import writer.StringWriter;
import writer.Writer;

public class StringWriterStupidRemovalOperationTest extends StupidRemovalOperationsTest {
  @Override
  Writer createInstance() {
    return new StringWriter(StupidRemoverOperation::removeStupid);
  }
}
