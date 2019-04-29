// Nikolas Brandt

class TitleCase {
  public static void main(String[] str) {
    String test = "THAT'S wHaT i'M TALKING ABOUT!";
    System.out.println(title(test));
  }
  
  public static String title(String title) {
    String out = "";
    
    while (title.indexOf(" ") >= 0) {
      int index = title.indexOf(" ");
      out += titleCase(title.substring(0, index)) + " ";
      title = title.substring(index + 1);
    }
    
    out += titleCase(title);
    
    return out;
  }
  
  private static String titleCase(String text) {
    if (text.length() <= 1) return text.toUpperCase();
    return text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase();
  }
}