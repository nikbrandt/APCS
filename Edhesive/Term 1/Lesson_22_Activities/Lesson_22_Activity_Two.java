/*
 * Lesson 22 Coding Activity 2
 * Write the code to take a String and print it diagonally.
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
 Use a tab character for every four spaces in the sample.
 
 Hint: You may need more than one loop.
 
 */ 

import java.util.Scanner;
import java.lang.Math; 

class Lesson_22_Activity_Two {
  public static void main(String[] args)
  {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter a string oaki thanks fukin' shitty goddamn edhesive bs pieces of macaroni noodles");
    
    String input = scanner.nextLine();
    
    
    for (int i = 0; i < input.length(); i++) {
      System.out.println(repeatTab(i) + input.charAt(i));
    }
  }
  
  private static String repeatTab (int num) {
    String out = "";
    for (int i = 0; i < num; i++) {
      out += "\t";
    }    
    return out;
  }
}