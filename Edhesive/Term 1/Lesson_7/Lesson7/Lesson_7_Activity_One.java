/*
 * Lesson 7 Coding Activity Question 1
 *
 * Input a positive three digit integer. Print out the digits one per line.
 *
 * Sample run:
 
Please enter a three digit number:
678

Here are the digits:
6
7
8

*/

import java.util.Scanner;
import java.lang.Math;

class Lesson_7_Activity_One {
    public static void main(String[] args) {
      
        /* Write your code here 
         * Copy and paste your entire code to Code Runner to complete the activity, 
         * from the first import statement to the last bracket. 
        */
      Scanner scanner = new Scanner(System.in);
      System.out.println("gimme your 3 digit integer k");
      
      int number = scanner.nextInt();
      
      System.out.println("y'all here are the digits:");
      System.out.println(number / 100);
      System.out.println(number % 100 / 10);
      System.out.println(number % 10);

    }
}