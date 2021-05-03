package writer;

import java.util.function.Function;

public class StringWriter extends Writer {
  private StringBuilder contents = new StringBuilder();

  @SafeVarargs
  public StringWriter(Function<String, String>... stringOperations) {
    super(stringOperations);
  }

  @Override
  public void writeToTarget(String text) {
    contents.append(text);
  }

  @Override
  public String getContents() {
    return contents.toString();
  }
}
