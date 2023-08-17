public class PangramChecker {

  public boolean check(String sentence) {
    String replaced = sentence.replaceAll("[^A-Za-z]", "");
    Set<String> letters = new HashSet<>(Arrays.asList(replaced.split("")));
    return letters.size() >= 26;
  }
}
