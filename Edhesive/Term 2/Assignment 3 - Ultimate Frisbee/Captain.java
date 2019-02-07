class Captain extends UltimatePlayer {
  private boolean type; // true for offense, false for defense
  
  Captain(String first, String last, String pos, boolean t) {
    super(first, last, pos);
    type = t;
  }
  
  public String toString() {
    return super.toString() +
      "\n   Captain: " + (type ? "offense" : "defense");
  }
}