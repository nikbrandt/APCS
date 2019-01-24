/*
 * Lesson 17 Coding Activity 1
 * Write a program that will input a list of test scores in from the keyboard. 
 * When the user enters -1, print the average.
 * 
 * What do you need to be careful about when using -1 to stop a loop?
 * 
 *     Sample Run:
 *         Enter the Scores:
 *         45
 *         100
 *         -1
 *
 *         The average is: 72.5
 * 
 * 
 */ 

import java.util.Scanner;
import java.lang.Math; 

class Lesson_17_Activity_One {
  public static void main(String[] args)
  {
    
    Scanner scanner = new Scanner(System.in);
    
    int i = 0;
    int total = 0;
    int amount = 0;
    
    System.out.println("Enter teh scores: (-1 to cancel)");
    
    while (i != -1) {
      int input = scanner.nextInt();
      if (input == -1) i = -1;
      else {
        total += input;
        amount++;
      }
    }
    
    System.out.println("The average is: " + (double)(total) / amount);
    
  }
}