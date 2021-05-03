package writer;

import java.io.IOException;
import java.util.function.Function;
import java.util.stream.Stream;

public abstract class Writer {
  private boolean targetOpen = true;
  private Function<String, String> operations;
  public abstract void writeToTarget(String text) throws IOException;
  public abstract String getContents() throws IOException;

  @SafeVarargs
  public Writer(Function<String, String>... stringOperations) {
    operations = Stream.of(stringOperations)
      .reduce(Function.identity(), Function::andThen);
  }

  public void close() {
    targetOpen = false;
  }

  public void write(String text) throws IOException {
    if(targetOpen){
      String word = text;
      writeToTarget(operations.apply(word));
    }
  }
}
