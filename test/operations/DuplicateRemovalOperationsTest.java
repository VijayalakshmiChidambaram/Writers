package operations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import writer.Writer;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class DuplicateRemovalOperationsTest {
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
    writer.write("This is is it");

    assertEquals("This is it", writer.getContents());
  }

  @Test
  void testWriteStringTwiceToAStringWriter() throws IOException {
    writer.write("This is is it.");

    writer.write("Apple is a fruit fruit");

    assertEquals("This is it.Apple is a fruit", writer.getContents());
  }

  @Test
  void testWriteCloseWriteToAStringWriter() throws IOException {
    writer.write("This is is it");

    writer.close();

    writer.write("Apple is a fruit fruit");

    assertEquals("This is it", writer.getContents());
  }

  @Test
  void testCloseThenWriteToAStringWriter() throws IOException {
    writer.close();

    writer.write("This is is it");

    assertEquals("", writer.getContents());
  }

  @Test
  void testDuplicateRemovalDoesNotRemoveSameWordOfDifferentCase() throws IOException {
    writer.write("This is IS it");

    assertEquals("This is IS it", writer.getContents());
  }
}
