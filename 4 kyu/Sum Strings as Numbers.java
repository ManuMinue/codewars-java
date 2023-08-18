public class Kata {

  public static String sumStrings(String a, String b) {
    StringBuilder result = new StringBuilder();
    a = a.trim().replaceFirst("^0+", "");
    b = b.trim().replaceFirst("^0+", "");
    var cadA = a.length() > 0 ? a.split("") : "0".split("");
    var cadB = b.length() > 0 ? b.split("") : "0".split("");
    var indexA = cadA.length - 1;
    var indexB = cadB.length - 1;
    var rest = 0;
    while(indexA >= 0 || indexB >= 0) {
      var intA = indexA >= 0 ? Integer.parseInt(cadA[indexA]) : 0;
      var intB = indexB >= 0 ? Integer.parseInt(cadB[indexB]) : 0;
      var sum = intA + intB + rest;
      rest = sum >= 10 ? 1 : 0;
      result.insert(0, sum % 10);
      --indexA;
      --indexB;
    }
    if(rest == 1) {
      result.insert(0, 1);
    }
    return result.length() > 0 ? result.toString() : "0";
  }
}
