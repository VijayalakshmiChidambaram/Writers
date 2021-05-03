package operations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import writer.Writer;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class LowerCaseWriteOperationsTest {
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

    assertEquals("hello there", writer.getContents());
  }

  @Test
  void testWriteStringTwiceToAStringWriter() throws IOException {
    writer.write("hELLo");

    writer.write("wORLd");

    assertEquals("helloworld", writer.getContents());
  }

  @Test
  void testWriteCloseWriteToAStringWriter() throws IOException {
    writer.write("hELLo");

    writer.close();

    writer.write("wORLd");

    assertEquals("hello", writer.getContents());
  }

  @Test
  void testCloseThenWriteToAStringWriter() throws IOException {
    writer.close();

    writer.write("wORLd");

    assertEquals("", writer.getContents());
  }
}

