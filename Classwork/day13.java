//Please put your name here: Nikolas Brandt

/* Do the following today, saved to the Z: drive
 * 
 * fill out this program so that it asks the user for two
 * integers then reports if the first is divisible by the
 * second. If it is it says so. If it isn't it reports 
 * how many times the second goes into the first along with 
 * the remainder.
 * 
 * Sample run 1:
 * 
 * Please enter two integers: 
 * 15
 * 2
 * 2 divides into 15 7 times with a remainder of 1. 
 * 
 * Sample run 2:
 * 
 * Please enter two integers: 
 * 16
 * 2
 * 16 is evenly divisible by 2 8 times.  
 * */
import java.util.Scanner;
public class day13
{
  public static void main(String[] args)
  {
    
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("Please give me two ints thanks:");
    int numOne = scanner.nextInt();
    int numTwo = scanner.nextInt();
    int rem = numOne % numTwo;
    int times = numOne / numTwo;
    
    if (rem == 0) System.out.println(numOne + " is evenly divisible by " + numTwo + " " + times + " times.");
    else System.out.println(numOne + " divides into " + numTwo + " " + times + " times with a remainder of " + rem + ".");
    
  }
}