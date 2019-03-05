// Nikolas Brandt, 2/26/19

import java.util.List;
import java.util.ArrayList;

class Deck {
  private List<Card> cards;
  private int size; // index, starting at # of cards, of currently non-dealt card
  // don't you love ambiguous variable names?
  
  Deck(String[] ranks, String[] suits, int[] values) {
    cards = new ArrayList<Card>(ranks.length * suits.length);
    
    for (String suit: suits) {
      for (int i = 0; i < ranks.length; i++) {
        cards.add(new Card(ranks[i], suit, values[i]));
      }
    }
    
    size = cards.size();
    shuffle();
  }
  
  public boolean isEmpty() {
    return size == 0 || cards == null || cards.size() == 0; 
  }
  
  public int size() {
    return size;
  }
  
  public void shuffle() { // 3/5/19
    for (int i = cards.size() - 1; i >= 0; i--) {
      int random = (int)(Math.random() * i);
      Card temp = cards.get(i);
      
      cards.set(random, cards.get(i));
      cards.set(i, temp);
    }
  }
  
  public Card deal() {
    if (size == 0) return null;
    size--;
    return cards.get(size);
  }
  
  // CollegeBoard code below this comment
  @Override
  public String toString() {
    String rtn = "size = " + size + "\nUndealt cards: \n";
    
    for (int k = size - 1; k >= 0; k--) {
      rtn = rtn + cards.get(k);
      if (k != 0) {
        rtn = rtn + ", ";
      }
      if ((size - k) % 2 == 0) {
        // Insert carriage returns so entire deck is visible on console.
        rtn = rtn + "\n";
      }
    }
    
    rtn = rtn + "\nDealt cards: \n";
    for (int k = cards.size() - 1; k >= size; k--) {
      rtn = rtn + cards.get(k);
      if (k != size) {
        rtn = rtn + ", ";
      }
      if ((k - cards.size()) % 2 == 0) {
        // Insert carriage returns so entire deck is visible on console.
        rtn = rtn + "\n";
      }
    }
    
    rtn = rtn + "\n";
    return rtn;
  }
}