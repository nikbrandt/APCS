/*
 * Lesson 10 Coding Activity Question 1
 * 
 * The following calculation will give roundoff error:
 *      double x = 1.473;
 *      System.out.println(2 - x);
 * 
 * Write the code to correct it. You can assume no more than 3 decimal places will be used.
 * 
 * Sample run:
 * 
 *      Please enter two decimal values:
 *      2
 *      1.473
 *     
 *      The difference is: 0.527
 * 
 * Use this starter file as your template.
 * 
*/

import java.util.Scanner;
import java.lang.Math;


class Lesson_10_Activity {
    public static void main(String[] args) {
      
        /* Write your code here 
         * Copy and paste your entire code to Code Runner to complete the activity, 
         * from the first import statement to the last bracket. 
        */
      Scanner scanner = new Scanner(System.in);
      System.out.println("insert a two thingies okay thanks");
      
      double numberOne = scanner.nextDouble();
      double numberTwo = scanner.nextDouble();
      int numberOneInt = (int) Math.round(numberOne * 1000);
      int numberTwoInt = (int) Math.round(numberTwo * 1000);
      double difference = numberOneInt - numberTwoInt;
      
      System.out.println("The difference is: " + ( difference / 1000 ));

    }
}