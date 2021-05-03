package operations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import writer.Writer;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class StupidRemovalOperationsTest {
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
    writer.write("this is really stupid");

    assertEquals("this is really s*****", writer.getContents());
  }

  @Test
  void testWriteStringTwiceToAStringWriter() throws IOException {
    writer.write("stupid");

    writer.write("reallystupid");

    assertEquals("s*****reallys*****", writer.getContents());
  }

  @Test
  void testWriteCloseWriteToAStringWriter() throws IOException {
    writer.write("stupid");

    writer.close();

    writer.write("reallystupid");

    assertEquals("s*****", writer.getContents());
  }

  @Test
  void testCloseThenWriteToAStringWriter() throws IOException {
    writer.close();

    writer.write("stupid");

    assertEquals("", writer.getContents());
  }

  @Test
  void testWriteUpperCaseStupidToAStringWriterDoesNotReplaceWord() throws IOException {
    writer.write("Stupid");

    assertEquals("Stupid", writer.getContents());
  }
}
