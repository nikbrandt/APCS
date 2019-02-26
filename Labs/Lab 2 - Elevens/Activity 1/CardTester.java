// Nikolas Brandt, 2/25/19

public class CardTester {
 public static void main(String[] args) {
   // create cards
   Card one = new Card("10", "Spades", 10);
   Card two = new Card("5", "Jacks", 5);
   Card three = new Card("10", "Spades", 10);
   
   // card one toString then suit/rank/pointValue;
   System.out.println(one);
   System.out.println("\tsuit: " + one.suit());
   System.out.println("\trank: " + one.rank());
   System.out.println("\tpointValue: " + one.pointValue());
   
   // cards that match, then cards that don't
   System.out.println(one.matches(three));
   System.out.println(one.matches(two));
 }
}
