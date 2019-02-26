// Nikolas Brandt, 2/26/19

public class DeckTester {
  public static void main(String[] args) {
    String[] ranks = { "freshman", "sophomore", "junior", "senior" };
    String[] suits = { "tiger", "lion" };
    int[] values = { 9, 10, 11, 12 };
    
    Deck wscuhsd = new Deck(ranks, suits, values);
    System.out.println("Deck: \n" + wscuhsd);
    
    System.out.println("Cards:\n");
    for (int i = 0; i < 10; i++) {
      System.out.println(wscuhsd.deal());
    }
    
    // uhh sorry for the insane amount of cards
    System.out.println("\n\n\n-----\ncustom deck thingy\n");
    
    ranks = new String[]{ "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
    values = new int[]{ 11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10 };
    suits = new String[]{ "Spades", "Hearts", "Clubs", "Diamonds" };
    
    Deck deck = new Deck(ranks, suits, values);
    System.out.println("Deck:\n" + deck);
    System.out.println("isEmpty: " + deck.isEmpty());
    System.out.println("size: " + deck.size());
    
    System.out.println("\n\nCards\n");
    for (int i =0; i < 55; i++) {
      System.out.println(deck.deal());
    }
    
    System.out.println("\nisEmpty: " + deck.isEmpty());
    System.out.println("size: " + deck.size());
  }
}
