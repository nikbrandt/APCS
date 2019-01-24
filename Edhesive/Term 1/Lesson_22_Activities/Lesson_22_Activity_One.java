/*
 * Lesson 22 Coding Activity 1
 * Write the code to take a String and print it with one letter per line.
 * 
 Sample run:
 
 Enter a string:
 bought
 b
 o
 u
 g
 h
 t
 
 */ 

import java.util.Scanner;
import java.lang.Math; 

class Lesson_22_Activity_One {
  public static void main(String[] args)
  {
    System.out.println("Enter a stirng oaki");
    Scanner scanner = new Scanner(System.in);
    
    String input = scanner.nextLine();
    
    for (int i = 0; i < input.length(); i++) {
      System.out.println(input.charAt(i));
    }
  }
}