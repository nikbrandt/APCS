import java.util.ArrayList;
import java.util.Scanner;

class Main {
  public static void main (String str[]) {
    Scanner scanner = new Scanner(System.in);
    ArrayList array = new ArrayList();
    
    while (true) {
      String in = scanner.nextLine();
      if (in.equals("STOP")) break;
      array.add(in);
    }
    
    System.out.println(array.size());
    System.out.println(array);
    
    if (array.size() > 2) {
      array.remove(0);
      array.remove(array.size() - 1);
    }
    
    System.out.println(array);
  }
}