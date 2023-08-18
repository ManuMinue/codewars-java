import java.util.*;

public class Kata {

  public static long nextBiggerNumber(long n) {
    var text = Arrays.asList(String.valueOf(n).split(""));
    for (int i = text.size() - 2; i >= 0; --i) {
      if (text.get(i).compareTo(text.get(i + 1)) < 0) {
        var tail = text.subList(i + 1, text.size());
        int finalI = i;
        var min = tail.stream()
          .filter(it -> it.compareTo(text.get(finalI)) > 0)
          .min(String::compareTo)
          .orElse("-1");
        if (!min.equals("-1")) {
          var minIndex = tail.indexOf(min);
          text.set(i + 1 + minIndex, text.get(i));
          text.set(i, min);
          tail.sort(Comparator.naturalOrder());
          return Long.parseLong(String.join("", text));
        }
      }
    }
    return -1;
  }
}
