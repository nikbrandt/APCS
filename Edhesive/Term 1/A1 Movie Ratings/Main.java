import java.util.Scanner;
import java.lang.Math;

class Main {
  
  public static void main (String str[]) {
    
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("Please enter movie review website ratings");
    int websiteRatingOne = scanner.nextInt();
    int websiteRatingTwo = scanner.nextInt();
    int websiteRatingThree = scanner.nextInt();
    double averageWebsiteRating = ((double) websiteRatingOne + (double) websiteRatingTwo + (double) websiteRatingThree) / 3;
    
    System.out.println("Enter two ratings from the focus group por favor");
    double focusRatingOne = scanner.nextDouble();
    double focusRatingTwo = scanner.nextDouble();
    double averageFocusRating = (focusRatingOne + focusRatingTwo) / 2.0;
    
    System.out.println("Enter the professional movie critics average and we'll be good");
    double criticRating = scanner.nextDouble();
    
    double overallAverageRating = averageWebsiteRating * 0.2 + averageFocusRating * 0.3 + criticRating * 0.5;
    
    System.out.println("Average website rating: " + averageWebsiteRating);
    System.out.println("Average focus group rating: " + averageFocusRating);
    System.out.println("Average movie critic rating: " + criticRating);
    System.out.println("Overall movie rating: " + overallAverageRating);
  
  }
  
}