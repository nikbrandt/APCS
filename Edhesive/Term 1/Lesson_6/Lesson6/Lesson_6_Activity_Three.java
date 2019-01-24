/*
 * Lesson 6 Coding Activity Question 3
 *
 * Input a double and print the first two digits after the decimal point.
 *
 * Sample run:
 
Please input a decimal number:
57.8934
3.5832
Answer: 89

 * Hint - you will need to do a numeric cast and some division and/or subtraction.
 *
*/

import java.util.Scanner;
import java.lang.Math;

class Lesson_6_Activity_Three {
    public static void main(String[] args) {
      
        /* Write your code here 
         * Copy and paste your entire code to Code Runner to complete the activity, 
         * from the first import statement to the last bracket. 
        */
      Scanner scanner = new Scanner(System.in);
      
      System.out.println("Input a decimal okey:");
      double input = scanner.nextDouble();
      
      int wholeNumber = (int) input;
      double newNumber = input - (double) wholeNumber;
      newNumber *= 100;
      int finalNumber = (int) newNumber;
      
      System.out.println("Answer: " + finalNumber);
      

    }
}