package Operations;

import java.util.Locale;

public interface LowerCaseOperation {
  static String toLowerCase(String text) {
    return text.toLowerCase(Locale.ROOT);
  }
}
