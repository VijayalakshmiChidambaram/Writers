package operations;

import Operations.DuplicateRemoverOperation;
import writer.StringWriter;
import writer.Writer;

public class StringWriterDuplicateRemovalOperationTest extends DuplicateRemovalOperationsTest {
  @Override
  Writer createInstance() {
    return new StringWriter(DuplicateRemoverOperation::removeDuplicate);
  }
}
