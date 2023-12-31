import java.util.*;
import java.util.stream.*;

public class PigLatin {

  public static String pigIt(String str) {
    return Arrays
      .stream(str.split("(?<=\\s+)|(?=\\s+)"))
      .map(word ->
        word.matches("[\\s\\p{Punct}]+")
          ? word
          : word.substring(1) + word.charAt(0) + "ay"
      )
      .collect(Collectors.joining(""));
  }
}
