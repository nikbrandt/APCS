/*
 * Lesson 14 Coding Activity 3
 * The Internet runs on web addresses.The addresses we type represent the IP address 
 * for each site and how the computer finds an individual web page.
 *
 * IP addresses are made up of four numbers, each between 0 and 255 separated by a period. 
 * For example, 128.253.21.58 is an IP address.
 * 
 * Write a program to enter four numbers and test if they make up a valid IP address.
 * In other words, test to see if the numbers entered are between 0 and 255 inclusive.
 * 
 *     Sample Run 1
 *         Please enter the first octet:
 *         898
 *         Please enter the second octet:
 *         34
 *         Please enter the third octet:
 *         712
 *         Please enter the fourth octet:
 *         45
 *         Octet 1 is incorrect
 *         Octet 3 is incorrect
 * 
 *         
 *      Sample Run 2
 *         Please enter the first octet:
 *         112
 *         Please enter the second octet:
 *         200
 *         Please enter the third octet:
 *         0
 *         Please enter the fourth octet:
 *         254
 *         IP Address: 112.200.0.254
 * 
 */


import java.util.Scanner;

class Lesson_14_Activity_Three {
    public static void main(String[] args)
     {
     /*
      * Write your code here
      * Copy and paste your entire program to Code Runner
      * to complete the activity, from the first import statement
      * to the last bracket.
      */
      
      Scanner scanner = new Scanner(System.in);
      
      System.out.println("enter first octet");
      int octetOne = scanner.nextInt();
      
      System.out.println("enter second octet");
      int octetTwo = scanner.nextInt();
      
      System.out.println("enter third octet okay");
      int octetThree = scanner.nextInt();
      
      System.out.println("i hope you know what to do by now, okay?");
      int octetFour = scanner.nextInt();
      
      boolean fail = false;
      
      if (!checkInclusive(octetOne)) {
        System.out.println("Octet 1 is incorrect");
        fail = true;
      }
      if (!checkInclusive(octetTwo)) {
        System.out.println("Octet 2 is incorrect");
        fail = true;
      }
      if (!checkInclusive(octetThree)) {
        System.out.println("Octet 3 is incorrect");
        fail = true;
      }
      if (!checkInclusive(octetFour)) {
        System.out.println("Octet 4 is incorrect");
        fail = true;
      }
      
      if (!fail) System.out.println("IP Address: " + octetOne + '.' + octetTwo + '.' + octetThree + '.' + octetFour);
    }

    private static boolean checkInclusive (int num) {
      return num >= 0 && num <= 255;
    }
}