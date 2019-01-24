/*
 * Lesson 13 Coding Activity 5 
 * Create a program to let the user practice their multiplication tables.
 * Print two random integers between 1 and 12 each on a new line. 
 * Then, ask the user to input the multiplication of the two numbers. 
 * If they enter the correct product print "Correct!" otherwise print "Wrong".
 */


import java.util.Scanner;
import java.lang.Math;

class Lesson_13_Activity_Five {
    public static void main(String[] args)
     {
     Scanner scanner = new Scanner(System.in);
     
     int randomOne = (int)(Math.random() * 12) + 1;
     int randomTwo = (int)(Math.random() * 12) + 1;
     
     System.out.println(randomOne);
     System.out.println(randomTwo);
     
     System.out.println("multiply those two ^ thanks");
     int userAnswer = scanner.nextInt();
     int realAnswer = randomOne * randomTwo;
     
     if (userAnswer == realAnswer) System.out.println("Correct!");
     else System.out.println("Wrong");
     
    }
}