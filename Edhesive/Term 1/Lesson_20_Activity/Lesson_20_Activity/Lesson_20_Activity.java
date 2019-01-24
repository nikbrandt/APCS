/*
 * Lesson 20 Coding Activity 
 * 
 * Computer science jobs are in demand. Right now we have a shortage 
 * of people that can do computer programming, and one of the fastest
 * growing areas of new jobs in the sector are so-called hybrid jobs. 
 * This means you specialize in an area like biology, 
 * and then use computer programming to do your job. 
 * 
 * These hybrid jobs exist in the arts, sciences,
 * economics, healthcare, and entertainment fields.
 * 
 * One of these jobs is computational biology. Computational Biology, 
 * sometimes referred to as bioinformatics, is the science of 
 * using biological data to develop algorithms and relations
 * among various biological systems.
 * 
 * In this lab we are going to investigate the data from a
 * grey seal named Gracie. WeÕll input the longitude and
 * latitude data from a tracking device. We want to investigate 
 * the farthest north, south, east and west Gracie has been.
 * 
 * We will use the latitude to measure this.
 * Write a program to enter GracieÕs longitude and Latitude data. 
 * Each time through the loop it should ask if you want to continue. 
 * Enter 1 to repeat, 0 to stop.
 * 
 * Any value for latitude not between -90 and 90 inclusive should be ignored.
 * 
 * Any value for longitude not between -180 and 180 inclusive should be ignored.
 *
 *
 *          Sample Run:
 *
 *              Please enter the latitude:
 *              41.678
 *              Please enter the longitude:
 *              69.938
 *              Would you like to enter another location?
 *              1
 *              Please enter the latitude:
 *              41.755
 *              Please enter the longitude:
 *              69.862
 *              Would you like to enter another location?
 *              1
 *              Please enter the latitude:
 *              41.829
 *              Please enter the longitude:
 *              69.947
 *              Would you like to enter another location?
 *              1
 *              Please enter the latitude:
 *              300
 *              Please enter the longitude:
 *              69.947
 *              Incorrect Latitude or Longitude
 *              Please enter the latitude:
 *              41.827
 *              Please enter the longitude: 
 *              69.904
 *              Would you like to enter another location?
 *              0
 *              Farthest North: 41.829
 *              Farthest South: 41.678
 *              Farthest East: 69.947  
 *              Farthest West: 69.862
 *   
 */ 

import java.util.Scanner;
import java.lang.Math; 

class Lesson_20_Activity{
  public static void main(String[] args)
  {
    
    Scanner scanner = new Scanner(System.in);
    
    double farNorth = -90;
    double farSouth = 90;
    double farEast = -180;
    double farWest = 180;
    
    boolean cont = true;
    
    while (cont) {
      System.out.println("Please enter latitude:");
      double latIn = scanner.nextDouble();
      
      System.out.println("Please enter longititude okay:");
      double longIn = scanner.nextDouble();
      
       // lat between -90 and 90, negatives are south, positives are north
       // long between -180 and 180, negatives are west, positives are east
      
      if (latIn >= -90.0 && latIn <= 90.0) {
        if (latIn < farSouth) farSouth = latIn;
        if (latIn > farNorth) farNorth = latIn;
      } else {
        System.out.println("Incorrect Latitude or Longitude");
        continue;
      }
      
      if (longIn > 180.0 || longIn < -180.0) {
        System.out.println("Incorrect Latitude or Longitude");
        continue;
      } else {
        if (longIn < farWest) farWest = longIn;
        if (longIn > farEast) farEast = longIn;
      }
      
      System.out.println("wanna enter another?");
      if (scanner.nextInt() != 1) cont = false; 
      
    }
    
    System.out.println("Farthest North: " + farNorth);
    System.out.println("Farthest South: " + farSouth);
    System.out.println("Farthest East: " + farEast);
    System.out.println("Farthest West: " + farWest);
    
  }
}