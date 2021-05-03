package operations;

import Operations.LowerCaseOperation;
import writer.StringWriter;
import writer.Writer;

public class StringWriterLowerCaseOperationsTest extends LowerCaseWriteOperationsTest {
  @Override
  public Writer createInstance() {
    return new StringWriter(LowerCaseOperation::toLowerCase);
  }
}
