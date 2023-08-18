import static java.util.Map.entry;

import java.util.*;

public class Parser {

  private static Map<String, Integer> words = Map.ofEntries(
    entry("zero", 0),
    entry("one", 1),
    entry("two", 2),
    entry("three", 3),
    entry("four", 4),
    entry("five", 5),
    entry("six", 6),
    entry("seven", 7),
    entry("eight", 8),
    entry("nine", 9),
    entry("ten", 10),
    entry("eleven", 11),
    entry("twelve", 12),
    entry("thirteen", 13),
    entry("fourteen", 14),
    entry("fifteen", 15),
    entry("sixteen", 16),
    entry("seventeen", 17),
    entry("eighteen", 18),
    entry("nineteen", 19),
    entry("twenty", 20),
    entry("thirty", 30),
    entry("forty", 40),
    entry("fifty", 50),
    entry("sixty", 60),
    entry("seventy", 70),
    entry("eighty", 80),
    entry("ninety", 90)
  );

  private static Map<String, Integer> mult = Map.ofEntries(
    entry("hundred", 100),
    entry("thousand", 1000),
    entry("million", 1000000)
  );

  public static int parseInt(String numStr) {
    return Integer.parseInt(
      Arrays
        .stream(numStr.split("[^a-zA-Z]"))
        .reduce(
          "0",
          (sum, word) -> {
            int result = Integer.parseInt(sum);
            if (words.containsKey(word)) {
              result += words.get(word);
            } else if (mult.containsKey(word)) {
              result +=
                mult.get(word) *
                (result % mult.get(word)) -
                (result % mult.get(word));
            }
            return String.valueOf(result);
          }
        )
    );
  }
}
