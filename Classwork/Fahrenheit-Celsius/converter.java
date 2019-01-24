//put your name and the date here: Nikolas Brandt - 9/25/18

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class converter {
  public static void main(String[] args) throws IOException {
    
    Scanner inFile = new Scanner(new File("temperatures.txt"));
    
    int num;
    int maxFahrenheit = Integer.MIN_VALUE;
    int minFahrenheit = Integer.MAX_VALUE;
    System.out.println("Values are rounded; temperatures:");
    
    while(inFile.hasNext()) {
      num = inFile.nextInt();
      
      if (num < minFahrenheit) minFahrenheit = num;
      if (num > maxFahrenheit) maxFahrenheit = num; 
      
      double celsius = 5.0 / 9.0 * (num - 32);
      int intCelsius = (int) Math.round(celsius * 10);
      double finalCelsius = (double) intCelsius / 10;
      
      System.out.println("F: " + num + "\tC: " + finalCelsius);
    }
    
    inFile.close();
    
    System.out.println("\nMax F value:\t" + maxFahrenheit);
    System.out.println("Min F value:\t" + minFahrenheit);
  }
}

