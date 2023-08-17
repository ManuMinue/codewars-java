import java.util.*;
import java.util.stream.*;

public class MorseCodeDecoder {

  public static String decode(String morseCode) {
    return Arrays.stream(morseCode.trim().split("   "))
      .map(words -> Arrays.stream(words.trim().split(" ")))
      .map(word -> word.map(MorseCode::get).collect(Collectors.joining("")))
      .collect(Collectors.joining(" "));
  }
}
