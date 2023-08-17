import java.util.*;

public class Kata {

  public static int findShort(String s) {
    return Arrays.stream(s.split(" ")).mapToInt(String::length).min().orElse(0);
  }
}
