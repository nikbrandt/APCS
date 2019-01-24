/*
 * Lesson 13 Coding Activity 4
 * Input an integer grade from the keyboard and translate it to a letter grade. 
 * For example, if a user enters 4, print "A", and if they enter 0 print "F." 
 * You can assume that an integer between 0 and 4 will be input.
 */


import java.util.Scanner;

class Lesson_13_Activity_Four {
    public static void main(String[] args)
     {
     
      Scanner scanner = new Scanner(System.in);
      
      int input = scanner.nextInt();
      char grade = 'F';
      if (input == 4) grade = 'A';
      else if (input == 3) grade = 'B';
      else if (input == 2) grade = 'C';
      else if (input == 1) grade = 'D';
      
      System.out.println(grade);
      
    }
}