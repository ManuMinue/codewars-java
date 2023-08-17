import java.util.stream.IntStream;

public class Solution {

  public int solution(int number) {
    if (number <= 0) {
      return 0;
    }
    return IntStream
      .range(0, number)
      .filter(i -> i % 3 == 0 || i % 5 == 0)
      .sum();
  }
}
