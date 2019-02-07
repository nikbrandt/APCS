import java.util.Scanner;
import java.util.regex.*;
import java.awt.*;
import java.util.ArrayList;
import java.io.*;

class Test extends Frame {
  
  /* Test () {
   Frame frame = new Frame();
   Button button = new Button("look nik i made a button");
   
   button.setBounds(15, 35, 200, 30);
   frame.add(button);
   frame.setSize(300, 150);
   frame.setLayout(null);
   frame.setVisible(true);
   }
   
   public static void main (String str[]) {
   Test t = new Test();
   } */
  
  public static void main (String str[]) {
    
    /*Scanner scanner = new Scanner(System.in);
     * 
     Matcher matcher = Pattern.compile("([+-]?[0-9]*)x\\^2([+-][0-9]*)x([+-][0-9]+)").matcher(scanner.nextLine());
     
     if (!matcher.matches()) {
     System.out.println("Input expression was in the wrong format, try again");
     return;
     }
     
     int groupOne = getNum(matcher.group(1));
     int groupTwo = getNum(matcher.group(2));
     int groupThree = getNum(matcher.group(3));
     
     System.out.println("Numbers: " + groupOne + ", " + groupTwo + ", " + groupThree);*/ // regex ^
    
    
    try {
      String line;
      // for linux Process p = Runtime.getRuntime().exec("ps -e");
      Process p = Runtime.getRuntime().exec
        (System.getenv("windir") +"\\system32\\"+"tasklist.exe");
      BufferedReader input =
        new BufferedReader(new InputStreamReader(p.getInputStream()));
      while ((line = input.readLine()) != null) {
        System.out.println(line); //<-- Parse data here.
      }
      input.close();
    } catch (Exception err) {
      err.printStackTrace();
    }
    
  }
  
  public static boolean mystery(int nums[]) {
    for (int i = 1; i < nums.length; i++)  
      if (nums[i - 1] >= nums[i])
      return false;
    return true;  
  }
  
  
  
  public static void println(int [] array) {
    for (int i = 0; i < array.length; i++)
      System.out.print(array[i] + (i == array.length - 1 ? "" : ", "));
    System.out.println();
  }
  
  public static void println(String str) {
    System.out.println(str);
  }
  
  public static void println(String... array) {
    for (int i = 0; i < array.length; i++)
      System.out.print(array[i] + (i == array.length - 1 ? "" : " "));
    System.out.println();
  }
  
  
  /*public static int howdy(int in) {
   return (int)(Math.random() * (in ));
   }
   
   public static void digits (int w) {
   System.out.println(w % 10);
   System.out.println((w % 100) / 10);
   System.out.println(((w%1000) - (w%100)) / 100);
   }
   
   private static int[] test() {
   return new int[]{1, 3, 2};
   }
   
   private static int getNum (String input) {
   if (input.length() == 0 || input.equals("+")) return 1;
   else if (input.equals("-")) return -1;
   return Integer.parseInt(input);
   }*/
  
}