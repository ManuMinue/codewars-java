import java.util.*;
import java.util.stream.*;

public class NumberUtils {

  public static boolean isNarcissistic(int number) {
    var digits = String.valueOf(number).split("");
    var length = digits.length;
    int sum = Arrays
      .stream(digits)
      .mapToInt(digit -> (int) Math.pow(Double.parseDouble(digit), length))
      .sum();
    return number == sum;
  }
}