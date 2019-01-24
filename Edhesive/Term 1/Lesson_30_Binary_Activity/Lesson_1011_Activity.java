/*
 * Lesson 30 1/2 Coding Activity 
 * 
 * For this program you will input an int to represent the octal number 
 * and translate to the base ten number. The octal number must be 8 digits or less.
 * 
 * Your program should also check that all the digits are 0 - 7, then translate the 
 * number to base ten. 
 * 
 * Sample Run 1: 
 * Enter a number in base 8: 
 * 1287 
 * ERROR: Incorrect Octal Format 
 * 
 * Sample Run 2: 
 * Enter a number in base 8: 
 * 123 
 * 83 
 * 
 * Sample Run 3: 
 * Enter a number in base 8: 
 * 1111111111 
 * ERROR: Incorrect Octal Format
 *   
 */ 

import java.util.Scanner;
import java.lang.Math; 

class Lesson_1011_Activity{
  public static void main(String[] args) {
    
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("Enter a base 8 number por favor");
    String input = scanner.nextLine();
    
    if (input.length() > 8) {
      System.out.println("ERROR: Incorrect Octal Format");
      return;
    }
    
    int sum = 0;
    
    for (int i = 0; i < input.length(); i++) {
      char current = input.charAt(i);
      int parsed = Integer.parseInt(String.valueOf(current));
      
      if (parsed < 0 || parsed > 7) {
        System.out.println("ERROR: Incorrect Octal Format");
        return;
      }
      
      sum += parsed * (int) Math.pow(8, input.length() - 1 - i);
    }
    
    System.out.println(sum);
    
  }
}