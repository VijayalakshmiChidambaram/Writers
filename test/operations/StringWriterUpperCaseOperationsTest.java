package operations;

import Operations.UpperCaseOperation;
import writer.StringWriter;
import writer.Writer;

public class StringWriterUpperCaseOperationsTest extends UpperCaseWriteOperationsTest {
  @Override
  Writer createInstance() {
    return new StringWriter(UpperCaseOperation::toUpperCase);
  }
}
