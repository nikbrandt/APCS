class UltimatePlayer extends Person {
  private static int jerseyTotal;
  
  private int jerseyNumber;
  private String position;
  
  UltimatePlayer(String first, String last, String pos) {
    super(first, last);
    if (pos.equals("handler") || pos.equals("cutter")) position = pos;
    else position = "handler";
    
    jerseyTotal++;
    jerseyNumber = jerseyTotal;
  }
  
  public String getPosition() {
    return position;
  }
  
  public String toString() {
    return super.toString() +
      "\n   Jersey #: " + jerseyNumber +
      "\n   Position: " + position;
  }
}