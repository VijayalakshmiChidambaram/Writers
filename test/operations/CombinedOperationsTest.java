package operations;

import Operations.DuplicateRemoverOperation;
import Operations.LowerCaseOperation;
import Operations.StupidRemoverOperation;
import Operations.UpperCaseOperation;
import org.junit.jupiter.api.Test;
import writer.FileWriter;
import writer.StringWriter;
import writer.Writer;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CombinedOperationsTest {
  
  @Test
  void testWriteAStringToStringWriterWithUpperCaseAndLowerCaseOperation() throws IOException {

    Writer writer = new StringWriter(UpperCaseOperation::toUpperCase, LowerCaseOperation::toLowerCase);

    writer.write("hello THERE");

    assertEquals("hello there", writer.getContents());
  }

  @Test
  void testWriteAStringToFileWriterWithUpperCaseAndLowerCaseOperation() throws IOException {

    Writer writer = new FileWriter("myfile.dat", LowerCaseOperation::toLowerCase, UpperCaseOperation::toUpperCase);

    writer.write("hello THERE");

    assertEquals("HELLO THERE", writer.getContents());
  }

  @Test
  void testWriteAStringToStringWriterWithUpperCaseLowerCaseAndStupidRemovalOperation() throws IOException {

    Writer writer = new StringWriter(UpperCaseOperation::toUpperCase, LowerCaseOperation::toLowerCase,
      StupidRemoverOperation::removeStupid);

    writer.write("hello THERE stupid");

    assertEquals("hello there s*****", writer.getContents());
  }

  @Test
  void testWriteAStringToFileWriterWithUpperCaseLowerCaseAndStupidRemovalOperation() throws IOException {

    Writer writer = new FileWriter("myfile.dat", UpperCaseOperation::toUpperCase, LowerCaseOperation::toLowerCase,
      StupidRemoverOperation::removeStupid);

    writer.write("hello THERE stupid");

    assertEquals("hello there s*****", writer.getContents());
  }

  @Test
  void testWriteAStringToStringWriterWithUpperCaseDuplicateRemovalOperation() throws IOException {

    Writer writer = new StringWriter(UpperCaseOperation::toUpperCase, DuplicateRemoverOperation::removeDuplicate);

    writer.write("hello there there");

    assertEquals("HELLO THERE", writer.getContents());
  }

  @Test
  void testWriteAStringToFileWriterWithUpperCaseDuplicateRemovalOperation() throws IOException {

    Writer writer = new FileWriter("myfile.dat", UpperCaseOperation::toUpperCase, DuplicateRemoverOperation::removeDuplicate);

    writer.write("hello there there");

    assertEquals("HELLO THERE", writer.getContents());
  }

  @Test
  void testWriteAStringToStringWriterWithLowerCaseDuplicateRemovalOperation() throws IOException {

    Writer writer = new StringWriter(LowerCaseOperation::toLowerCase, DuplicateRemoverOperation::removeDuplicate,
        StupidRemoverOperation::removeStupid);

    writer.write("tHIS is sTUpiD STUPID");

    assertEquals("this is s*****", writer.getContents());
  }

  @Test
  void testWriteAStringToFileWriterWithLowerCaseDuplicateRemovalOperation() throws IOException {

    Writer writer = new FileWriter("myfile.dat", LowerCaseOperation::toLowerCase, DuplicateRemoverOperation::removeDuplicate,
        StupidRemoverOperation::removeStupid);

    writer.write("tHIS is sTUpiD STUPID");

    assertEquals("this is s*****", writer.getContents());
  }

  @Test
  void testWriteAStringToStringWriterWithUpperCaseStupidRemovalDuplicateRemovalOperation() throws IOException {

    Writer writer = new StringWriter(UpperCaseOperation::toUpperCase, StupidRemoverOperation::removeStupid,
        DuplicateRemoverOperation::removeDuplicate);

    writer.write("tHIS is sTUpiD STUPID");

    assertEquals("THIS IS STUPID", writer.getContents());
  }

  @Test
  void testWriteAStringToFileWriterWithUpperCaseStupidRemovalDuplicateRemovalOperation() throws IOException {

    Writer writer = new FileWriter("myfile.dat", UpperCaseOperation::toUpperCase, StupidRemoverOperation::removeStupid,
        DuplicateRemoverOperation::removeDuplicate);

    writer.write("tHIS is sTUpiD STUPID");

    assertEquals("THIS IS STUPID", writer.getContents());
  }
}
