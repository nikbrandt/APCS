/*
 * week3.java base code. Add your name here: Nikolas Brandt
 * 
 * You should do this AFTER finishing lesson 9.
 * 
 * Change line 30 to generate a random integer between 
 * lower and upper (inclusive). The given code will print 
 * 100 random results so that you can test to make sure you 
 * have done it correctly. Leave the "int r = " part but 
 * replace the "0" with proper code to generate a random 
 * value within the parameters.
 * 
 * Save to the Z: drive with your name up top to get credit.
 * August 30, 2018
 * 
 */

import java.util.Scanner;
public class week3
{
  public static void main(String[] args)
  {
    Scanner t = new Scanner(System.in);
    System.out.println("We're going to choose a random integer.");
    System.out.println("Please enter the lower bound:");
    int lower = t.nextInt();
    System.out.println("Please enter the upper bound:");
    int upper = t.nextInt();
    int x = 0;
    while(x<100)
    {
      int r = (int)(Math.random() * (upper + Math.abs(lower))) + lower; //replace this line per instructions above.
      System.out.print(r+" ");
      x++;
    }
  }
}