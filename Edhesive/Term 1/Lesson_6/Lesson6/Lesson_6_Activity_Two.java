/*
 * Lesson 6 Coding Activity Question 2
 *
 * Input a double value and print only the integer part.
 *
 * Sample run:
 
Please input a decimal number:
57.8934
Answer: 57

*/

import java.util.Scanner;
import java.lang.Math;

class Lesson_6_Activity_Two {
    public static void main(String[] args) {
      
        /* Write your code here 
         * Copy and paste your entire code to Code Runner to complete the activity, 
         * from the first import statement to the last bracket. 
        */
      
      System.out.println("gimme a decimal");
      Scanner scanner = new Scanner(System.in);
      double input = scanner.nextDouble();
      int intResult = (int) input;
      
      System.out.println("Answer: " + intResult);

    }
}