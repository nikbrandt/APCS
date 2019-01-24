/*
 * Lesson 3 Coding Activity Question 3
 * 
 * Write a program that will ask the user to enter an adjective and a name. 
 * Print the following sentence, replacing the ______ with the words they entered.
 * 
 * My name is _____. I am _____.
 *
 * Sample Run:

Hi there. What is your name?
Ada
What adjective describes you?
logical
My name is Ada. I am logical.

*/

import java.util.Scanner;
import java.lang.Math;

class Lesson_3_Activity_Three {
    public static void main(String[] args) {
      
        /* Write your code here 
         * Copy and paste your entire code to Code Runner to complete the activity, 
         * from the first import statement to the last bracket. 
        */
      Scanner scanner = new Scanner(System.in);
      String name;
      String adjective;
      
      System.out.println("Wha's your name?");
      name = scanner.nextLine();
      
      System.out.println("What describes ya?");
      adjective = scanner.nextLine();
      
      System.out.println("My name is " + name + ". I am " + adjective + ".");

    }
}