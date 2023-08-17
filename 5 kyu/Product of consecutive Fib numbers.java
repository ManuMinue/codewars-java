public class ProdFib {

  public static long[] productFib(long prod) {
    // your code
    var n = 0L;
    var nPlus = 1L;
    while (n * nPlus < prod) {
      nPlus = n + nPlus;
      n = nPlus - n;
    }
    return new long[] { n, nPlus, n * nPlus == prod ? 1L : 0L };
  }
}
