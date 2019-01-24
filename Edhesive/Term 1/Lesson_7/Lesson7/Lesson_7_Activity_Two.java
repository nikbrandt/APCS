/*
 * Lesson 7 Coding Activity Question 2
 *
 * Change the last problem so that it also prints the sum of the digits. 
 * Use the format shown below.
 *
 * Make sure your output is printed in the same order as the sample run.
 *
 * Sample run:
 
Please enter a three digit number:
678

Here are the digits:
6
7
8

6 + 7 + 8 = 21

*/

import java.util.Scanner;
import java.lang.Math;

class Lesson_7_Activity_Two {
    public static void main(String[] args) {
      
        /* Write your code here 
         * Copy and paste your entire code to Code Runner to complete the activity, 
         * from the first import statement to the last bracket. 
        */

      Scanner scanner = new Scanner(System.in);
      System.out.println("gimme your 3 digit integer k");
      
      int number = scanner.nextInt();
      int firstDigit = number / 100;
      int secondDigit = number % 100 / 10;
      int thirdDigit = number % 10;
      int sum = firstDigit + secondDigit + thirdDigit;
      
      System.out.println("y'all here are the digits:");
      System.out.println(firstDigit);
      System.out.println(secondDigit);
      System.out.println(thirdDigit + "\n");
      
      System.out.println(firstDigit + " + " + secondDigit + " + " + thirdDigit + " = " + sum);

    }
}