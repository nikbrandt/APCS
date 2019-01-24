// Nik Brandt - week2 assignment

import java.io.*;
import static java.lang.System.*;

import java.util.Scanner;

class week2 {
  
  public static void main (String str[]) {
    
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("If you could enter your favorite ice cream flavor that'd be great thanks");
    String flavor = scanner.nextLine();
    
    System.out.println("Alright, alright, " + flavor + " sounds.. okay, what's your favorite number?");
    int number = scanner.nextInt();
    
    System.out.println("That's crazy duuude! I ate " + number + " " + flavor + " ice cream cones over the summer! :O");
    
  }
  
}