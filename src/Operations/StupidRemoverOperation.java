package Operations;

public interface StupidRemoverOperation {
  static String removeStupid (String text) {
    return text.replace("stupid", "s*****");
  }
}
