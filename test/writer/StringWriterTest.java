package writer;

public class StringWriterTest extends WriterTest{
  @Override
  public Writer createInstance() {
    return new StringWriter();
  }
}
