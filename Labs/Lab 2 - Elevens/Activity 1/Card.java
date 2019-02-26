// Nikolas Brandt, 2/25/19

class Card {
  private String rank;
  private String suit;
  private int pointValue;
  
  public Card(String rank, String suit, int pointValue) {
    this.rank = rank;
    this.suit = suit;
    this.pointValue = pointValue;
  }
  
  public String rank() {
    return rank;
  }
  
  public String suit() {
    return suit;
  }
  
  public int pointValue() {
    return pointValue;
  }
  
  // because the equals() method is apparently *not* convention, and we need to use matches() instead. right.
  public boolean matches (Card other) {
    if (!other.rank().equals(this.rank)) return false;
    if (!other.suit().equals(this.suit)) return false;
    if (other.pointValue() != this.pointValue) return false;
    return true;
  }
  
  public String toString() {
    return rank + " of " + suit + " (point value = " + pointValue + ")";
  }
}