package Operations;

import java.util.Arrays;
import java.util.stream.Collectors;

public interface DuplicateRemoverOperation {
  static String removeDuplicate(String text) {
    return Arrays.stream( text.split("\\s+")).distinct()
        .collect(Collectors.joining(" ") );
    }
}
