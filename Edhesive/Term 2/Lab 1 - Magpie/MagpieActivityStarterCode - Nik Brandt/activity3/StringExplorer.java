// Nikolas Brandt, 1/22/19

/**
 * A program to allow students to try out different 
 * String methods. 
 * @author Laurie White
 * @version April 2012
 */
public class StringExplorer
{

 public static void main(String[] args)
 {
  String sample = "The quick brown fox jumped over the lazy dog.";
  
  //  Demonstrate the indexOf method.
  int position = sample.indexOf("quick");
  System.out.println ("sample.indexOf(\"quick\") = " + position);
  
  //  Demonstrate the toLowerCase method.
  String lowerCase = sample.toLowerCase();
  System.out.println ("sample.toLowerCase() = " + lowerCase);
  System.out.println ("After toLowerCase(), sample = " + sample);
  
  //  Try other methods here:
  int nop = lowerCase.indexOf("HELLO");
  int firstThe = lowerCase.indexOf("the");
  int secondThe = lowerCase.indexOf("the", firstThe + 3);
  System.out.println("String that is not found: " + nop + "\nFirst the index: " + firstThe + "\nSecond the index: " + secondThe);
 }

}
