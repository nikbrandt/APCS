/*
 * Lesson 13 Coding Activity 3 
 * Input two integers and print the largest. If they are equal print "EQUAL". 
 * You should be able to do this with only one if statement but you may use multiple else statements.
 */


import java.util.Scanner;

class Lesson_13_Activity_Three {
    public static void main(String[] args)
     {
     Scanner scanner = new Scanner(System.in);
     
     int inputOne = scanner.nextInt();
     int inputTwo = scanner.nextInt();
     
     if (inputOne > inputTwo) System.out.println(inputOne);
     else if (inputTwo > inputOne) System.out.println(inputTwo);
     else System.out.println("EQUAL");
    }
}