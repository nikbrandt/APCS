// Nikolas Brandt, 2/26/19

import java.util.ArrayList;

class Day67 {
  public static void main(String[] str) {
    // the lovely Western 19th century races, gotta love AP World.
    String[] races = { "civlilized", "semibarbarous", "barbarian", "savage" };
    System.out.print("Array size: ");
    printArraySize(races);
    
    System.out.println("\nArrayList time:");
    ArrayList<String> racesList = new ArrayList<String>();
    for (String race: races)
      racesList.add(race);
    
    for (String race: racesList)
      System.out.println("  " + race);
    
    System.out.println("List size: " + racesList.size());
  }
  
  private static void printArraySize(String[] array) {
    System.out.println(array.length);
  }
}