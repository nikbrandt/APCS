// Nikolas Brandt, 3/5/19

import java.util.ArrayList;

public class DeckTester {
 public static void main(String[] args) {
  String[] ranks = {"jack", "queen", "king"};
  String[] suits = {"blue", "red"};
  int[] pointValues = {11, 12, 13};
  Deck d = new Deck(ranks, suits, pointValues);

  System.out.println("**** Original Deck Methods ****");
  System.out.println("  toString:\n" + d.toString());
  System.out.println("  isEmpty: " + d.isEmpty());
  System.out.println("  size: " + d.size());
  System.out.println();
  System.out.println();

  System.out.println("**** Deal a Card ****");
  System.out.println("  deal: " + d.deal());
  System.out.println();
  System.out.println();

  System.out.println("**** Deck Methods After 1 Card Dealt ****");
  System.out.println("  toString:\n" + d.toString());
  System.out.println("  isEmpty: " + d.isEmpty());
  System.out.println("  size: " + d.size());
  System.out.println();
  System.out.println();

  System.out.println("**** Deal Remaining 5 Cards ****");
  for (int i = 0; i < 5; i++) {
   System.out.println("  deal: " + d.deal());
  }
  System.out.println();
  System.out.println();

  System.out.println("**** Deck Methods After All Cards Dealt ****");
  System.out.println("  toString:\n" + d.toString());
  System.out.println("  isEmpty: " + d.isEmpty());
  System.out.println("  size: " + d.size());
  System.out.println();
  System.out.println();

  System.out.println("**** Deal a Card From Empty Deck ****");
  System.out.println("  deal: " + d.deal());
  System.out.println();
  System.out.println();

  // CollegeBoard code above this line
  
  System.out.println("\n**** Full deck ****");
  
  ranks = new String[]{ "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
  pointValues = new int[]{ 11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10 };
  suits = new String[]{ "Spades", "Hearts", "Clubs", "Diamonds" };
  
  Deck deck = new Deck(ranks, suits, pointValues);
  System.out.println(deck);

  System.out.println("\n\nDuplicates:");
  ArrayList<String> list = new ArrayList<String>();
  boolean printed = false;

  while (!deck.isEmpty()) {
	list.add(deck.deal().toString());
  }

  for (int i = 0; i < list.size() - 1; i++) {
	if (list.size() <= i) break;

	int count = 0;
	String cur = list.get(i);

	do {
		list.remove(cur);
		count++;
	} while (list.contains(cur));

	if (count > 1) {
		System.out.println("\t" + cur + "\t" + count + "x");
		printed = true;
	}
  }

  if (!printed) System.out.println("\tnone.");
 }
}
