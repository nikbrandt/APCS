//Use this runner file to test your day.java class.
//You may add your own tests to this file, but make sure your
//class works with the tests I give you below.
//Store your file in the same folder as this file.
//Be sure to put your name and the date in your day.java file at the top.

import java.util.*;
public class dayRunner
{
  public static void main(String[] args)
  {
    //create and print a day using the default constructor:
    day d1 = new day();
    System.out.println("Test 1: Default constructor: "+d1);
    
    //create and print a day, providing weather and school day info:
    day d2 = new day(43,true);
    System.out.println("Test 2: A cloudy school day: "+d2);
    
    //create a day with rain % out of bounds:
    day d3 = new day(200,false);
    System.out.println("Test 3: Rain 200 test: "+d3);
    
    //create and print an ArrayList with 5 school days with random weather:
    System.out.println("Test 4: A week of school with random weather: ");
    ArrayList<day> week = new ArrayList<day>();
    for(int i = 0;i<5;i++)
    {
      week.add(new day((int)(Math.random()*101),true));
    }
    for(day x: week)
      System.out.println(" "+x);
  }
}

/* Sample output from this tester file:

Test 1: Default constructor: Today is a sunny non-school day with a 0% chance of rain. 
Test 2: A cloudy school day: Today is a cloudy school day with a 43% chance of rain. 
Test 3: Rain 200 test: Today is a sunny non-school day with a 0% chance of rain. 
Test 4: A week of school with random weather:  
 Today is a cloudy school day with a 92% chance of rain. 
 Today is a sunny school day with a 18% chance of rain. 
 Today is a sunny school day with a 24% chance of rain. 
 Today is a sunny school day with a 12% chance of rain. 
 Today is a cloudy school day with a 64% chance of rain. 

*/