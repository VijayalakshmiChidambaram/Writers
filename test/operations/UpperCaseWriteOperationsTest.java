package operations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import writer.Writer;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class UpperCaseWriteOperationsTest {
  abstract Writer createInstance() throws IOException;
  Writer writer;

  @BeforeEach
  void init() throws IOException {
    writer = createInstance();
  }

  @Test
  void testWriteNothingToAStringWriter() throws IOException {
    assertEquals("", writer.getContents());
  }

  @Test
  void testWriteAStringToAStringWriter() throws IOException {
    writer.write("hello THERE");

    assertEquals("HELLO THERE", writer.getContents());
  }

  @Test
  void testWriteStringTwiceToAStringWriter() throws IOException {
    writer.write("hELLo");

    writer.write("wORLd");

    assertEquals("HELLOWORLD", writer.getContents());
  }

  @Test
  void testWriteCloseWriteToAStringWriter() throws IOException {
    writer.write("hELLo");

    writer.close();

    writer.write("thERe");

    assertEquals("HELLO", writer.getContents());
  }

  @Test
  void testCloseThenWriteToAStringWriter() throws IOException {
    writer.close();

    writer.write("heLLo");

    assertEquals("", writer.getContents());
  }
}
