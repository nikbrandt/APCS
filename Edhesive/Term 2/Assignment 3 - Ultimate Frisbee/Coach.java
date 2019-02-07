class Coach extends Person {
  private String role;
  
  Coach(String first, String last, String r) {
    super(first, last);
    role = r;
  }
  
  public String toString() {
    return super.toString() +
      "\n   Role: " + role;
  }
}