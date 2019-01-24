/*
 * Lesson 24 Coding Activity 2
 * Use a for loop to print the even numbers between 1 and 50. 
 * Print each number on a new line.
 */ 

import java.util.Scanner;
import java.lang.Math; 

class Lesson_24_Activity_Two {
  public static void main(String[] args) {
    for (int i = 2; i <= 50; i += 2) {
      System.out.println(i);
    }
  }
}