import java.math.BigInteger;
import java.util.*;

public class Anagrams {

  public BigInteger listPosition(String word) {
    var sum = BigInteger.ZERO;
    var letters = word.toCharArray();
    var numLettersBefore = 0;
    for (var i = 0; i < letters.length - 1; ++i) {
      for (var j = i + 1; j < letters.length; ++j) {
        if (letters[i] > letters[j]) {
          numLettersBefore++;
        }
      }
      var sortedLetters = Arrays.copyOfRange(letters, i, letters.length);
      Arrays.sort(sortedLetters);
      var uniqueLetterCount = countDuplicates(sortedLetters);
      sum =
        sum.add(
          BigInteger
            .valueOf(numLettersBefore)
            .multiply(permutations(sortedLetters.length - 1, uniqueLetterCount))
        );
      numLettersBefore = 0;
    }
    return sum.add(BigInteger.ONE);
  }

  private BigInteger factorial(int n) {
    if (n == 0) {
      return BigInteger.ZERO;
    }
    var product = BigInteger.ONE;
    for (int i = n; i > 0; i--) {
      product = product.multiply(BigInteger.valueOf(i));
    }
    return product;
  }

  private BigInteger permutations(int n, int[] m) {
    if (n == 0) {
      return BigInteger.ZERO;
    }
    var product = BigInteger.ONE;
    for (int i = n; i > 0; i--) {
      product = product.multiply(BigInteger.valueOf(i));
    }
    for (int j : m) {
      product = product.divide(factorial(j));
    }
    return product;
  }

  private int[] countDuplicates(char[] sortedLetters) {
    var lastLetter = sortedLetters[0];
    var counts = new int[sortedLetters.length];
    var currentCount = 1;
    var numUniqueLetters = 0;
    for (var i = 1; i < sortedLetters.length; i++) {
      if (sortedLetters[i] == lastLetter) {
        currentCount++;
      }
      if (sortedLetters[i] != lastLetter) {
        counts[numUniqueLetters] = currentCount;
        currentCount = 1;
        lastLetter = sortedLetters[i];
        numUniqueLetters++;
      }
    }
    counts[numUniqueLetters] = currentCount;
    return Arrays.copyOf(counts, numUniqueLetters + 1);
  }
}
