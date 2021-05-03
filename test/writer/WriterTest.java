package writer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class WriterTest {
  protected abstract Writer createInstance() throws IOException;
  private Writer writer;

  @Test
  void canaryTest() {
    assertTrue(true);
  }

  @BeforeEach
  void init() throws IOException {
    writer = createInstance();
  }

  @Test
  void testWriteNothingToWriter() throws IOException {
    assertEquals("", writer.getContents());
  }

  @Test
  void testWriteAStringToWriter() throws IOException {
    writer.write("apple");

    assertEquals("apple", writer.getContents());
  }

  @Test
  void testWriteStringTwiceToWriter() throws IOException {
    writer.write("Apple");

    writer.write("fruit");

    assertEquals("Applefruit", writer.getContents());
  }

  @Test
  void testWriteCloseWriteToAWriter() throws IOException {
    writer.write("Apple");

    writer.close();

    writer.write("fruit");

    assertEquals("Apple", writer.getContents());
  }

  @Test
  void testCloseThenWriteToAStringWriter() throws IOException {
    writer.close();

    writer.write("Apple");

    assertEquals("", writer.getContents());
  }
}
