import java.util.*;

class Permutations {

  public static Set<String> singlePermutations(String s) {
    var chars = Arrays.asList(s.split(""));
    var result = new HashSet<String>();
    boolean[] used = new boolean[chars.size()];

    permutations(chars, used, new StringBuilder(), result);

    return result;
  }

  private static void permutations(List<String> chars, boolean[] used,
    StringBuilder possible, Set<String> result) {
    if (possible.length() == chars.size()) {
      result.add(possible.toString());
    } else {
      for (int i = 0; i < chars.size(); ++i) {
        if (!used[i]) {
          possible.append(chars.get(i));
          used[i] = true;
          permutations(chars, used, possible, result);
          possible.deleteCharAt(possible.length() - 1);
          used[i] = false;
          System.out.println("Return: " + possible);
        }
      }
    }
  }
}
