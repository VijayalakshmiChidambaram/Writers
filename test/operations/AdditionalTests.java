package operations;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import writer.StringWriter;
import Operations.StupidRemoverOperation;
import Operations.DuplicateRemoverOperation;
import Operations.LowerCaseOperation;

public class AdditionalTests {
  @Test
  void testReplaceMultipleStupidWords() throws IOException {
    var stringWriter = new StringWriter(StupidRemoverOperation::removeStupid);
    
    stringWriter.write("This is stupid really stupid");
    
    assertEquals("This is s***** really s*****", stringWriter.getContents());
  }

  @Test
  void testDonotReplaceCapitalizedStupidWord() throws IOException {
    var stringWriter = new StringWriter(StupidRemoverOperation::removeStupid);
    
    stringWriter.write("This is Stupid");
    
    assertEquals("This is Stupid", stringWriter.getContents());
  }

//  @Test
//  void testDonotReplaceEmbeddedStupidWord() throws IOException {
//    var stringWriter = new StringWriter(StupidRemoverOperation::removeStupid);
//    
//    stringWriter.write("This is stupidest");
//    
//    assertEquals("This is stupidest", stringWriter.getContents());
//  }
  
  @Test
  void testReplaceThreeConsequetiveDuplicatedWords() throws IOException {
    var stringWriter = new StringWriter(DuplicateRemoverOperation::removeDuplicate);
    
    stringWriter.write("This is duplicate duplicate duplicate");
    
    assertEquals("This is duplicate", stringWriter.getContents());
  }

//  @Test
//  void testDonotReplaceNonConsequetiveRepeatedWords() throws IOException {
//    var stringWriter = new StringWriter(DuplicateRemoverOperation::removeDuplicate);
//    
//    stringWriter.write("Is this a duplicate no not a duplicate");
//    
//    assertEquals("Is this a duplicate no not a duplicate", stringWriter.getContents());
//  }
  
  @Test
  void testLowerStupidDuplicateCombination() throws IOException {
    var stringWriter = new StringWriter(LowerCaseOperation::toLowerCase, StupidRemoverOperation::removeStupid, DuplicateRemoverOperation::removeDuplicate);
    
    stringWriter.write("This is a stupid stupid test");
    
    assertEquals("this is a s***** test", stringWriter.getContents());
  }
}
