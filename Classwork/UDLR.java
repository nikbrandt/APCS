// Nikolas Brandt making a majestic program on the 12th month of 2018 on the day 4
// and it took me like 23 minutes to do, more than 20, correct, I suppose, be that way

import java.util.Scanner;

class UDLR {
  
  public static void main (String str[]) {
    new UDLR();
  }
  
  private int x;
  private int y;
  String path;
  
  UDLR() {
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("Welcome to the Cartesian Plane.");
    System.out.println("Please enter the x coordinate:");
    x = scanner.nextInt();
    
    System.out.println("Please enter the y coordinate:");
    y = scanner.nextInt(); scanner.nextLine();
    
    System.out.println("Finally, please enter a path to follow:");
    path = scanner.nextLine().toUpperCase();
    
    int pathValidateNum = validatePath(); // path validation
    if (pathValidateNum >= 0) {
      System.out.println("There is an error in the path at index " + pathValidateNum + ".");
      System.out.println("The path must contain at least one each of U, D, L, and R.");
      return;
    }
    
    if (pathValidateNum == -2) {
      System.out.println("The path must contain at least one each of U, D, L, and R.");
      return;
    }
    
    System.out.println("\nLet's walk the path:");
    System.out.println("( " + x + ", " + y + " ) (Start)");
    walk();
  }
  
  private int validatePath() {
    int uCount = 0;
    int dCount = 0;
    int lCount = 0;
    int rCount = 0;
    
    for (int i = 0; i < path.length(); i++) {
      char at = path.charAt(i);
      
      if (at == 'U') {
        uCount++;
        continue;
      } 
      
      if (at == 'D') {
        dCount++;
        continue;
      }
      
      if (at == 'L') {
        lCount++;
        continue;
      }
      
      if (at == 'R') {
        rCount++;
        continue;
      }
      
      return i;
    }
    
    if (uCount < 1 || dCount < 1 || lCount < 1 || rCount < 1) return -2;
    return -1;
  }
  
  private void walk() {
    char direction = path.charAt(0);
    if (direction == 'U') y++;
    if (direction == 'D') y--;
    if (direction == 'L') x--;
    if (direction == 'R') x++;
    
    System.out.println("( " + x + ", " + y + " ) (" + direction + ")");
    
    if (path.length() > 1) {
      path = path.substring(1);
      walk();
    } else {
      finish();
    }
  }
  
  private void finish() {
    System.out.println();
    if (x == 0 && y == 0) System.out.println("Congratulations, you made it back to the origin.");
    else System.out.println("You ended up " + 
                            Math.sqrt(x * x + y * y) +
                            " units away from the origin.");
  }
}