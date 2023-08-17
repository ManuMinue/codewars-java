public class Troll {

  public static String disemvowel(String str) {
    if (str == null) {
      return null;
    }
    return str.replaceAll("[aeiouAEIOU]", "");
  }
}
