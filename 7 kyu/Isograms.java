public class isogram {

  public static boolean isIsogram(String str) {
    if (str == null) {
      return true;
    }
    return str.length() == str.toLowerCase().chars().distinct().count();
  }
}
