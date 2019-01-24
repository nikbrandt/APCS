// Copyright (c) Nikolas Brandt 2018
// just kidding 
// except by law it is copyrighted i suppose
// 1/10/19, period 4

import java.util.Scanner;
import java.util.ArrayList;

class CourseLister {
  public static void main (String str[]) {
    ArrayList<String> courses = new ArrayList<String>();
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("Weclome to CourseLister, created by Nikolas Brandt!");
    
    while (true) {
      System.out.println("Please enter a course name, or 'done' if you are finished:");
      String input = scanner.nextLine();
      
      if (input.toLowerCase().equals("done")) break;
      
      courses.add(input);
    }
    
    System.out.println("\n" + courses);
    for (String course: courses)
      System.out.println(course);
    
    System.out.println("\nPlease enter a course to remove:");
    String toRemove = scanner.nextLine();
    
    for (int i = courses.size() - 1; i >= 0; i--)
      if (courses.get(i).equals(toRemove)) courses.remove(i);
   
    System.out.println();
    for (String course: courses)
      System.out.println(course);
    
  }
}