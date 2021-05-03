package writer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Function;

public class FileWriter extends Writer {
  java.io.FileWriter fileWriter;
  private String file;

  @SafeVarargs
  public FileWriter(String filename, Function<String, String>... stringOperations) throws IOException {
    super(stringOperations);
    fileWriter = new java.io.FileWriter(filename);
    file = filename;
  }

  @Override
  public void writeToTarget(String text) throws IOException {
    fileWriter.write(text);
    fileWriter.flush();
  }

 @Override
  public String getContents() throws IOException {
    return Files.readString(Path.of(file));
  }
}
