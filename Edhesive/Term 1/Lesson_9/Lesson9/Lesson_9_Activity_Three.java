/*
 * Lesson 9 Coding Activity Question 3
 *
 * Write the code to print a random integer from 20 to 40 inclusive using Math.random().
 *
*/

import java.util.Scanner;
import java.lang.Math;

class Lesson_9_Activity_Three {
    public static void main(String[] args) {
      
        /* Write your code here 
         * Copy and paste your entire code to Code Runner to complete the activity, 
         * from the first import statement to the last bracket. 
        */
      int answer = (int)(Math.random() * 21) + 20;
      System.out.println(answer);

    }
}