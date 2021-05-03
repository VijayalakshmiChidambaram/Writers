package Operations;

import java.util.Locale;

public interface UpperCaseOperation {
  static String toUpperCase(String text) {
    return text.toUpperCase(Locale.ROOT);
  }
}
