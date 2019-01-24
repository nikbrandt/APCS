import java.util.ArrayList;
import java.util.Scanner;

class Main {
  public static void main (String str[]) {
    Scanner scanner = new Scanner(System.in);
    ArrayList<String> array = new ArrayList<String>();
    
    while (true) {
      String in = scanner.nextLine();
      if (in.equals("STOP")) break;
      array.add(in);
    }
    
    for (String e: array) {
      if (e.indexOf("a") >= 0) System.out.println(e);
    }
  }
}