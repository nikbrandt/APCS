import java.io.*;
import java.util.*;

class Main {
  public static int countLetter(ArrayList<String> list, String letter) {
    letter = letter.toLowerCase();
    int counter = 0;
    
    for (String item: list)
      if (item.substring(0, 1).toLowerCase().equals(letter)) counter++;
    
    return counter;
  }
  
  public static void main(String str[]) throws IOException {
    ArrayList<String> zoo = new ArrayList<String>();
    zoo.add("Zebra");
    zoo.add("Aardvark");
    zoo.add("Emu");
    zoo.add("Hippo");
    zoo.add("Aligator");
    zoo.add("Lion");
    zoo.add("Giraffe");
    zoo.add("Seal");
    zoo.add("Tiger");
    zoo.add("Elephant");
    
    System.out.println(zoo);
    
    System.out.println("A: " + countLetter(zoo, "A"));
    System.out.println("B: " + countLetter(zoo, "B"));
    System.out.println("C: " + countLetter(zoo, "C"));
    System.out.println("L: " + countLetter(zoo, "L"));
    System.out.println("T: " + countLetter(zoo, "T"));
    
    System.out.println("a: " + countLetter(zoo, "a"));
    System.out.println("b: " + countLetter(zoo, "b"));
    System.out.println("c: " + countLetter(zoo, "c"));
    System.out.println("l: " + countLetter(zoo, "l"));
    System.out.println("t: " + countLetter(zoo, "t"));
  }
}
